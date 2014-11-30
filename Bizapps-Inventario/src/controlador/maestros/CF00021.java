package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F00021;
import modelo.maestros.F0005;
import modelo.maestros.F0010;
import modelo.maestros.F0101;
import modelo.pk.F00021PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import arbol.CArbol;
import componentes.Botonera;
import componentes.buscadores.BuscadorUDC;
import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;

public class CF00021 extends CGenerico {

	@Wire
	private Textbox txtKCOF00021;
	@Wire
	private Textbox txtDESF00021;
	@Wire
	private Doublebox txtCTRYF00021;
	@Wire
	private Doublebox txtFYF00021;
	@Wire
	private Doublebox txtN001F00021;
	@Wire
	private Div divVF00021;
	@Wire
	private Div catalogoF00021;
	@Wire
	private Div divCatalogoF0010;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Button btnBuscarCompannia;
	@Wire
	private Div botoneraF00021;
	@Wire
	private Div divbuscadorDCT;
	@Wire
	private Div divbuscadorSMAS;
	@Wire
	private Div divbuscadorINCRUS;
	@Wire
	private Label lblDescripcionF0010;
	CatalogoGenerico<F00021> catalogo;
	CatalogoGenerico<F0010> catalogoF0010;
	protected List<F00021> listaGeneral = new ArrayList<F00021>();
	Botonera botonera;
	F00021PK clave = null;
	CArbol arbol = new CArbol();
	BuscadorUDC buscadorDCT, buscadorSMAS, buscadorINCRUS;

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = (HashMap<String, Object>) Sessions
				.getCurrent().getAttribute("mapaGeneral");
		if (map != null) {
			if (map.get("tabsGenerales") != null) {
				tabs = (List<Tab>) map.get("tabsGenerales");
				titulo = (String) map.get("titulo");
				map.clear();
				map = null;
			}
		}
		arbol.booleanoApg();
		txtKCOF00021.setFocus(true);
		mostrarCatalogo();
		List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"DT");
		buscadorDCT = new BuscadorUDC("Tipo Documento", 10, true, "00", "DT",
				servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "DT",
						buscadorDCT.obtenerCaja());
			}
		};

		List<F0005> listF0005 = servicioF0005
				.buscarParaUDCOrdenados("00", "DT");
		buscadorSMAS = new BuscadorUDC("Igual a tipo doc", 10, false, "00",
				"DT", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "DT",
						buscadorSMAS.obtenerCaja());
			}
		};
		List<F0005> lisF0005 = servicioF0005
				.buscarParaUDCOrdenados("H00", "IM");
		buscadorINCRUS = new BuscadorUDC("Digito Incrus", 10, false,
				"H00", "IM" , servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H00", "IM",
						buscadorINCRUS.obtenerCaja());
			}
		};
		divbuscadorSMAS.appendChild(buscadorSMAS);
		divbuscadorDCT.appendChild(buscadorDCT);
		divbuscadorINCRUS.appendChild(buscadorINCRUS);
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F00021 f21 = catalogo.objetoSeleccionadoDelCatalogo();
						txtKCOF00021.setValue(f21.getId().getNlkco());
						lblDescripcionF0010.setValue(servicioF0010.buscar(
								f21.getId().getNlkco()).getCcname());
						txtKCOF00021.setDisabled(true);
						btnBuscarCompannia.setVisible(false);
						if (f21.getId() != null) {
							buscadorDCT.settearModelo(servicioF0005.buscar(
									"00", "DT", f21.getId().getNldct()));
							buscadorDCT.inhabilitarCampo();
							// txtDCTF00021.setValue(f21.getId().getNldct());
							// txtDCTF00021.setDisabled(true);
						}
						buscadorSMAS.settearModelo(servicioF0005.buscar("00",
								"DT", f21.getNlsmas()));
						buscadorINCRUS.settearModelo(servicioF0005.buscar(
								"H00", "IM", f21.getNlimb()));
						txtCTRYF00021.setValue(f21.getId().getNlctry());
						txtFYF00021.setValue(f21.getId().getNlfy());
						txtN001F00021.setValue(f21.getNln001());
						txtN001F00021.setDisabled(true);
						txtDESF00021.setFocus(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}

			}

			@Override
			public void salir() {
				cerrarVentana(divVF00021, titulo, tabs);
				arbol.booleanoApg();

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
				habilitarCampos();
				clave = null;
				buscarSiguiente();
			}

			@Override
			public void guardar() {
				if (validar()) {
					String kco = txtKCOF00021.getValue();
					String dct = buscadorDCT.obtenerCaja();
					String smas = buscadorSMAS.obtenerCaja();
					// donde se guarda la descripcion
					String des = txtDESF00021.getValue();
					double ctry = txtCTRYF00021.getValue();
					double fy = txtFYF00021.getValue();
					double n001 = 0;
					if (txtN001F00021.getText().compareTo("") != 0)
						n001 = txtN001F00021.getValue();
					String imb = buscadorINCRUS.obtenerCaja();
					F00021PK clave = new F00021PK();
					clave.setNlkco(kco);
					clave.setNldct(dct);
					clave.setNlctry(ctry);
					clave.setNlfy(fy);
					F00021 f00021 = new F00021();
					f00021.setId(clave);
					f00021.setNlsmas(smas);
					f00021.setNln001(n001);
					f00021.setNlimb(imb);
					servicioF00021.guardar(f00021);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					listaGeneral = servicioF00021.buscarTodosOrdenados();
					catalogo.actualizarLista(listaGeneral);
				}

			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F00021> eliminarLista = catalogo
								.obtenerSeleccionados();
						Messagebox
								.show("¿Desea Eliminar los "
										+ eliminarLista.size() + " Registros?",
										"Alerta",
										Messagebox.OK | Messagebox.CANCEL,
										Messagebox.QUESTION,
										new org.zkoss.zk.ui.event.EventListener<Event>() {
											public void onEvent(Event evt)
													throws InterruptedException {
												if (evt.getName()
														.equals("onOK")) {
													servicioF00021
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													listaGeneral = servicioF00021
															.buscarTodosOrdenados();
													catalogo.actualizarLista(listaGeneral);
												}
											}
										});
					}
				} else {
					/* Elimina un solo registro */
					if (clave != null) {
						Messagebox
								.show(Mensaje.deseaEliminar,
										"Alerta",
										Messagebox.OK | Messagebox.CANCEL,
										Messagebox.QUESTION,
										new org.zkoss.zk.ui.event.EventListener<Event>() {
											public void onEvent(Event evt)
													throws InterruptedException {
												if (evt.getName()
														.equals("onOK")) {
													servicioF00021
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													listaGeneral = servicioF00021
															.buscarTodosOrdenados();
													catalogo.actualizarLista(listaGeneral);
												}
											}
										});
					} else
						msj.mensajeAlerta(Mensaje.noSeleccionoRegistro);
				}

			}

			@Override
			public void buscar() {
				// TODO Auto-generated method stub
				abrirCatalogo();

			}

			@Override
			public void ayuda() {
				// TODO Auto-generated method stub

			}

			@Override
			public void annadir() {
				abrirRegistro();
				mostrarBotones(false);
			}
		};
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF00021.appendChild(botonera);

	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(!bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
	}

	public boolean validarSeleccion() {
		List<F00021> seleccionados = catalogo.obtenerSeleccionados();
		if (seleccionados == null) {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			return false;
		} else {
			if (seleccionados.isEmpty()) {
				msj.mensajeAlerta(Mensaje.noSeleccionoItem);
				return false;
			} else {
				return true;
			}
		}
	}

	public boolean camposLLenos() {
		if (txtKCOF00021.getText().compareTo("") == 0
				|| buscadorDCT.obtenerCaja().compareTo("") == 0
				|| txtDESF00021.getText().compareTo("") == 0
				|| txtCTRYF00021.getText().compareTo("") == 0
				|| txtFYF00021.getText().compareTo("") == 0) {
			return false;
		} else
			return true;

	}

	protected boolean validar() {
		if (!camposLLenos()) {
			msj.mensajeError(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	@Listen("onClick = #txtN001F00021")
	public boolean buscarSiguiente() {
		String a = txtKCOF00021.getValue();
		String b = buscadorDCT.obtenerCaja();
		if (servicioF00021.Numero(a, b) >= 0) {
			double numero = servicioF00021.Numero(a, b);
			if (numero != 0)
				txtN001F00021.setValue(numero + 1);
			return true;
		} else
			return false;
	}

	@Listen("onClick = #txtN001F00021")
	public boolean buscarSiguiente1() {
		String a = txtKCOF00021.getValue();
		String b = buscadorDCT.obtenerCaja();
		if (servicioF00021.Numero(a, b) >= 0) {
			double numero = servicioF00021.Numero(a, b);
			if (numero != 0)
				txtN001F00021.setValue(numero + 1);
			return true;
		} else
			return false;
	}

	public void limpiarCampos() {
		txtKCOF00021.setValue("");
		buscadorDCT.settearCampo(null);
		buscadorSMAS.settearCampo(null);
		txtDESF00021.setValue("");
		txtCTRYF00021.setValue(null);
		txtFYF00021.setValue(null);
		txtN001F00021.setValue(null);
		lblDescripcionF0010.setValue("");
		buscadorINCRUS.settearCampo(null);
		txtKCOF00021.setFocus(true);
		btnBuscarCompannia.setVisible(true);
	}

	public void habilitarCampos() {
		if (txtKCOF00021.isDisabled())
			txtKCOF00021.setDisabled(false);
		buscadorDCT.habilitarCampos();
		if (txtN001F00021.isDisabled())
			txtN001F00021.setDisabled(false);
	}

	public boolean camposEditando() {
		if (txtKCOF00021.getText().compareTo("") != 0
				|| buscadorDCT.obtenerCaja().compareTo("") != 0
				|| buscadorSMAS.obtenerCaja().compareTo("") != 0
				|| txtDESF00021.getText().compareTo("") != 0
				|| txtCTRYF00021.getText().compareTo("") != 0
				|| txtFYF00021.getText().compareTo("") != 0
				|| buscadorINCRUS.obtenerCaja().compareTo("") != 0
				|| txtN001F00021.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	@Listen("onOpen = #gpxDatos")
	public void abrirCatalogo() {
		gpxDatos.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatos.setOpen(false);
								gpxRegistro.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatos.setOpen(true);
									gpxRegistro.setOpen(false);
									limpiarCampos();
									habilitarCampos();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatos.setOpen(true);
			gpxRegistro.setOpen(false);
			mostrarBotones(true);
		}
	}

	public void mostrarCatalogo() {
		listaGeneral = servicioF00021.buscarTodosOrdenados();
		catalogo = new CatalogoGenerico<F00021>(catalogoF00021, "F00021",
				listaGeneral, false, true, true, "Compañia Documento",
				"Tipo Documento", "Igual a Tipo Doc", "Digito Incrus",
				"Digito Verif", "Número Siguiente", "Reinicio Automático") {

			@Override
			protected List<F00021> buscar(List<String> valores) {

				List<F00021> compannia = new ArrayList<F00021>();

				for (F00021 companniadoc : listaGeneral) {
					String ck = "";
					if (companniadoc.getNlck01() != null)
						ck = companniadoc.getNlck01();
					if (companniadoc.getId().getNlkco().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& companniadoc.getId().getNldct().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& companniadoc.getNlsmas().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& companniadoc.getNlimb().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& ck.toLowerCase().contains(
									valores.get(4).toLowerCase())
							&& String.valueOf(companniadoc.getNln001())
									.toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& String.valueOf(companniadoc.getNlaur())
									.toLowerCase()
									.contains(valores.get(6).toLowerCase())) {
						compannia.add(companniadoc);
					}
				}
				return compannia;
			}

			@Override
			protected String[] crearRegistros(F00021 numerosiguiente) {
				String[] registros = new String[7];
				registros[0] = numerosiguiente.getId().getNlkco();
				registros[1] = numerosiguiente.getId().getNldct();
				if (numerosiguiente.getNlsmas() != null)
					registros[2] = numerosiguiente.getNlsmas();
				else
					registros[2] = "";
				registros[3] = numerosiguiente.getNlimb();
				registros[4] = numerosiguiente.getNlck01();
				registros[5] = String.valueOf(numerosiguiente.getNln001());
				if (numerosiguiente.getNlaur() != null)
					registros[6] = String.valueOf(numerosiguiente.getNlaur());
				else
					registros[6] = "";

				return registros;
			}
		};
		catalogo.setParent(catalogoF00021);
		// catalogo.doModal();
	}

	@Listen("onClick = #btnBuscarCompannia")
	public void mostrarCatalogoF0010() {
		final List<F0010> lista = servicioF0010.buscarTodosOrdenados();
		catalogoF0010 = new CatalogoGenerico<F0010>(divCatalogoF0010,
				"Catalogo de Compañías", lista, true, false, true, "Codigo",
				"Nombre", "Nº Periodo", "Patron", "Inicio año Fiscal",
				"Periodo LM", "Inicio año C/P", "Periodo C/P",
				"Inicio año C/C", "Periodo C/C") {

			@Override
			protected List<F0010> buscar(List<String> valores) {

				List<F0010> lista2 = new ArrayList<F0010>();

				for (F0010 f0010 : lista) {
					if (f0010.getCcco().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f0010.getCcname().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& String.valueOf(f0010.getCcpnc()).toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& f0010.getCcdot1().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f0010.getCcarfj().toString().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& String.valueOf(f0010.getCctxbm()).toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& f0010.getCcapfj().toString().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& String.valueOf(f0010.getCctxbo()).toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& f0010.getCcdfyj().toString().toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& String.valueOf(f0010.getCcpnf()).toLowerCase()
									.contains(valores.get(9).toLowerCase())) {
						lista2.add(f0010);
					}
				}
				return lista2;
			}

			@Override
			protected String[] crearRegistros(F0010 f0010) {
				String[] registros = new String[10];
				registros[0] = f0010.getCcco();
				registros[1] = f0010.getCcname();
				registros[2] = String.valueOf(f0010.getCcpnc());
				registros[3] = f0010.getCcdot1();
				registros[4] = f0010.getCcarfj().toString();
				registros[5] = String.valueOf(f0010.getCctxbm());
				registros[6] = f0010.getCcapfj().toString();
				registros[7] = String.valueOf(f0010.getCctxbo());
				registros[8] = f0010.getCcdfyj().toString();
				registros[9] = String.valueOf(f0010.getCcpnf());
				return registros;

			}
		};
		catalogoF0010.setParent(divCatalogoF0010);
		catalogoF0010.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0010")
	public void seleccionF0010() {
		F0010 f0010 = catalogoF0010.objetoSeleccionadoDelCatalogo();
		txtKCOF00021.setValue(f0010.getCcco());
		lblDescripcionF0010.setValue(servicioF0010.buscar(f0010.getCcco())
				.getCcname());
		catalogoF0010.setParent(null);
	}

	@Listen("onChange = #txtKCOF00021; onOK = #txtKCOF00021")
	public boolean buscarCompania() {
		if (txtKCOF00021.getValue() != null) {
			F0010 f0010 = servicioF0010.buscar(txtKCOF00021.getValue());
			if (f0010 != null) {
				txtKCOF00021.setValue(f0010.getCcco());
				lblDescripcionF0010.setValue(servicioF0010.buscar(
						f0010.getCcco()).getCcname());
				return true;
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				return false;
			}
		} else
			return false;
	}

}
