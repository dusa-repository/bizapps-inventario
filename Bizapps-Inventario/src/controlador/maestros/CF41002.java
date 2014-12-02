package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F41002;
import modelo.maestros.F4101;
import modelo.pk.F41002PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.buscadores.BuscadorUDC;
import componentes.catalogos.CatalogoGenerico;

public class CF41002 extends CGenerico {

	@Wire
	private Doublebox txtUMITMF41002;
	@Wire
	private Div divBuscadorUMF41002;
	@Wire
	private Div divBuscadorRUMF41002;
	@Wire
	private Doublebox txtCONVF41002;
	@Wire
	private Textbox txtDescripcionUnidad;
	@Wire
	private Label lblDescripcionUnidad;
	@Wire
	private Textbox txtUSTRF41002;
	@Wire
	private Textbox txtEXSOF41002;
	@Wire
	private Textbox txtEXPOF41002;
	@Wire
	private Longbox txtSEPCF41002;
	@Wire
	private Longbox txtPUPCF41002;
	@Wire
	private Div divVF41002;
	@Wire
	private Div botoneraF41002;
	@Wire
	private Div divCatalogoF4101;
	@Wire
	private Div divCatalogoF41002;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Label lblDescripcionF4101;
	@Wire
	private Button btnBuscarF4101;

	protected List<F41002> listaGeneral = new ArrayList<F41002>();
	Botonera botonera;
	CatalogoGenerico<F41002> catalogoF41002;
	CatalogoGenerico<F4101> catalogoF4101;
	F41002PK clave = null;
	BuscadorUDC buscadorUMF41002;
	BuscadorUDC buscadorRUMF41002;

	@Override
	public void inicializar() throws IOException {
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
		txtUMITMF41002.setFocus(true);
		mostrarCatalogo();

		List<F0005> listF0005 = servicioF0005
				.buscarParaUDCOrdenados("00", "UM");

		buscadorUMF41002 = new BuscadorUDC("De UM", 3, true, "00", "UM",
				servicioF0005, "27%", "10%", "7%", "42%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorUMF41002.obtenerCaja());
			}
		};

		buscadorRUMF41002 = new BuscadorUDC("A UM", 3, true, "00", "UM",
				servicioF0005, "27%", "10%", "7%", "42%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorRUMF41002.obtenerCaja());
			}
		};

		divBuscadorUMF41002.appendChild(buscadorUMF41002);
		divBuscadorRUMF41002.appendChild(buscadorRUMF41002);

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogoF41002.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						F41002 f41002 = catalogoF41002
								.objetoSeleccionadoDelCatalogo();
						clave = f41002.getId();
						abrirRegistro();

						F4101 f4101 = servicioF4101.buscar(f41002.getId()
								.getUmitm());
						txtUMITMF41002.setValue(f41002.getId().getUmitm());
						lblDescripcionF4101.setValue(f4101.getImdsc1());
						txtUMITMF41002.setDisabled(true);
						txtDescripcionUnidad.setValue(f4101.getImuom1());

						F0005 f05 = servicioF0005.buscar("00", "UM",
								f4101.getImuom1());
						if (f05 != null)
							lblDescripcionUnidad.setValue(f05.getDrdl01());
						txtDescripcionUnidad.setDisabled(true);
						txtEXPOF41002.setValue(f41002.getUmexpo());
						txtUSTRF41002.setValue(f41002.getUmustr());
						txtEXSOF41002.setValue(f41002.getUmexso());

						if (f41002.getUmsepc() != null) {
							BigDecimal s = f41002.getUmsepc();
							txtSEPCF41002.setValue(s.longValue());
						}
						if (f41002.getUmpupc() != null) {
							BigDecimal s = f41002.getUmpupc();
							txtPUPCF41002.setValue(s.longValue());
						}

						txtCONVF41002.setValue(f41002.getUmconv());

						buscadorUMF41002.settearModelo(servicioF0005.buscar(
								"00", "UM", f41002.getId().getUmum()));
						buscadorUMF41002.inhabilitarCampo();

						buscadorRUMF41002.settearModelo(servicioF0005.buscar(
								"00", "UM", f41002.getId().getUmrum()));
						buscadorRUMF41002.inhabilitarCampo();

					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF41002, titulo, tabs);

			}

			@Override
			public void reporte() {
			}

			@Override
			public void limpiar() {
				clave = null;
				mostrarBotones(false);
				limpiarCampos();
				habilitarTextClave();
			}

			@Override
			public void guardar() {

				if (validar()) {
					String expo = txtEXPOF41002.getValue();
					String ustr = txtUSTRF41002.getValue();
					String exso = txtEXSOF41002.getValue();

					F41002 f41002 = new F41002();

					Double conv;
					if (txtCONVF41002.getValue() != null) {
						conv = txtCONVF41002.getValue();
						f41002.setUmconv(conv);
					}
					BigDecimal sepc;
					if (txtSEPCF41002.getValue() != null) {
						sepc = BigDecimal.valueOf(txtSEPCF41002.getValue());
						f41002.setUmsepc(sepc);
					}

					BigDecimal pupc = null;
					if (txtPUPCF41002.getValue() != null) {
						pupc = BigDecimal.valueOf(txtPUPCF41002.getValue());
						f41002.setUmpupc(pupc);
					}

					F41002PK clave = new F41002PK();
					clave.setUmum(buscadorUMF41002.obtenerCaja());
					clave.setUmrum(buscadorRUMF41002.obtenerCaja());
					clave.setUmitm(txtUMITMF41002.getValue());
					clave.setUmmcu("");

					f41002.setId(clave);
					f41002.setUmexpo(expo);
					f41002.setUmexso(exso);
					f41002.setUmustr(ustr);
					f41002.setUmupmj(transformarGregorianoAJulia(fecha));
					// f41002.setUmupmt(Double.valueOf(horaAuditoria)); hora?
					f41002.setUmuser("JDE");

					servicioF41002.guardar(f41002);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					listaGeneral = servicioF41002.buscarTodosOrdenados();
					catalogoF41002.actualizarLista(listaGeneral);
				}

			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F41002> eliminarLista = catalogoF41002
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
													servicioF41002
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													listaGeneral = servicioF41002
															.buscarTodosOrdenados();
													catalogoF41002
															.actualizarLista(listaGeneral);
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
													servicioF41002
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													listaGeneral = servicioF41002
															.buscarTodosOrdenados();
													catalogoF41002
															.actualizarLista(listaGeneral);
												}
											}
										});
					} else
						msj.mensajeAlerta(Mensaje.noSeleccionoRegistro);
				}

			}

			@Override
			public void buscar() {

				abrirCatalogo();

			}

			@Override
			public void ayuda() {

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
		botoneraF41002.appendChild(botonera);

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

	public void limpiarCampos() {
		clave = null;
		txtUMITMF41002.setValue(null);
		txtUMITMF41002.setFocus(true);
		lblDescripcionF4101.setValue("");
		lblDescripcionUnidad.setValue("");
		txtDescripcionUnidad.setValue("");
		txtEXPOF41002.setValue("");
		txtUSTRF41002.setValue("");
		txtEXSOF41002.setValue("");
		txtSEPCF41002.setValue(null);
		txtPUPCF41002.setValue(null);
		txtCONVF41002.setValue(null);
		btnBuscarF4101.setVisible(true);
		buscadorRUMF41002.settearCampo(null);
		buscadorRUMF41002.habilitarCampos();
		buscadorUMF41002.settearCampo(null);
		buscadorUMF41002.habilitarCampos();
	}

	public void habilitarTextClave() {
		if (txtUMITMF41002.isDisabled())
			txtUMITMF41002.setDisabled(false);
		if (txtDescripcionUnidad.isDisabled())
			txtDescripcionUnidad.setDisabled(false);

	}

	public boolean validarSeleccion() {
		List<F41002> seleccionados = catalogoF41002.obtenerSeleccionados();
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

	protected boolean validar() {
		if (!idArticuloExiste()) {
			Mensaje.mensajeError(Mensaje.articuloNoExiste);
			return false;
		} else {
			if (!camposLLenos()) {
				Mensaje.mensajeError(Mensaje.camposVacios);
				return false;
			} else
				return true;
		}
	}

	@Listen("onChange = #txtUMITMF41002; onOK = #txtUMITMF41002")
	public boolean idArticuloExiste() {
		if (txtUMITMF41002.getText().compareTo("") != 0) {
			F4101 f4101 = servicioF4101.buscar(txtUMITMF41002.getValue());
			if (f4101 != null) {
				txtUMITMF41002.setValue(f4101.getImitm());
				lblDescripcionF4101.setValue(f4101.getImdsc1());
				txtDescripcionUnidad.setValue(f4101.getImuom1());
				txtDescripcionUnidad.setDisabled(true);
				F0005 f05 = servicioF0005.buscar("00", "UM", f4101.getImuom1());
				if (f05 != null)
					lblDescripcionUnidad.setValue(f05.getDrdl01());
				return true;
			} else {
				txtUMITMF41002.setValue(null);
				lblDescripcionF4101.setValue("");
				txtDescripcionUnidad.setValue("");
				txtDescripcionUnidad.setDisabled(false);
				lblDescripcionUnidad.setValue("");
				Mensaje.mensajeError(Mensaje.articuloNoExiste);
				return false;
			}

		} else
			return false;
	}

	public boolean camposLLenos() {
		if (txtUMITMF41002.getText().compareTo("") == 0
				|| txtCONVF41002.getText().compareTo("") == 0
				|| buscadorUMF41002.obtenerCaja().compareTo("") == 0
				|| buscadorRUMF41002.obtenerCaja().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtEXPOF41002.getText().compareTo("") != 0
				|| txtUSTRF41002.getText().compareTo("") != 0
				|| txtEXSOF41002.getText().compareTo("") != 0
				|| txtPUPCF41002.getText().compareTo("") != 0
				|| txtCONVF41002.getText().compareTo("") != 0
				|| txtUMITMF41002.getText().compareTo("") != 0
				|| txtSEPCF41002.getText().compareTo("") != 0
				|| txtDescripcionUnidad.getText().compareTo("") != 0
				|| buscadorRUMF41002.obtenerCaja().compareTo("") != 0
				|| buscadorUMF41002.obtenerCaja().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		if (clave == null)
			btnBuscarF4101.setVisible(true);
		else
			btnBuscarF4101.setVisible(false);
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
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
									habilitarTextClave();
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
		listaGeneral = servicioF41002.buscarTodosOrdenados();
		catalogoF41002 = new CatalogoGenerico<F41002>(divCatalogoF41002,
				"F41002", listaGeneral, false, false, true, "Numero articulo",
				"Descripcion", "De UM", "Cantidad", "A UM",
				"Codigo estructura", "Excluir de OV", "Excluir de OC",
				"Sec UM ventas", "Sec UM compras") {

			@Override
			protected List<F41002> buscar(List<String> valores) {

				List<F41002> listF41002_2 = new ArrayList<F41002>();

				for (F41002 f41002 : listaGeneral) {
					F4101 f4101 = servicioF4101.buscar(f41002.getId()
							.getUmitm());
					if (String.valueOf(f41002.getId().getUmitm().longValue())
							.toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f4101.getImdsc1().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& f41002.getId().getUmum().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& String.valueOf(f41002.getUmconv()).toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f41002.getId().getUmrum().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& f41002.getUmustr().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& f41002.getUmexso().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& f41002.getUmexpo().toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& String.valueOf(f41002.getUmsepc()).toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& String.valueOf(f41002.getUmpupc()).toLowerCase()
									.contains(valores.get(9).toLowerCase())) {
						listF41002_2.add(f41002);
					}
				}
				return listF41002_2;
			}

			@Override
			protected String[] crearRegistros(F41002 f41002) {

				F4101 f4101 = servicioF4101.buscar(f41002.getId().getUmitm());
				String[] registros = new String[10];
				registros[0] = String.valueOf(f41002.getId().getUmitm()
						.longValue());
				registros[1] = f4101.getImdsc1();
				registros[2] = f41002.getId().getUmum();
				registros[3] = String.valueOf(f41002.getUmconv());
				registros[4] = f41002.getId().getUmrum();
				registros[5] = f41002.getUmustr();
				registros[6] = f41002.getUmexso();
				registros[7] = f41002.getUmexpo();
				if (f41002.getUmsepc() == null)
					registros[8] = String.valueOf("");
				else
					registros[8] = String.valueOf(f41002.getUmsepc());
				if (f41002.getUmpupc() == null)
					registros[9] = String.valueOf("");
				else
					registros[9] = String.valueOf(f41002.getUmpupc());
				return registros;
			}
		};
		catalogoF41002.setParent(divCatalogoF41002);
	}

	@Listen("onClick = #btnBuscarF4101")
	public void mostrarCatalogoF4101() {
		final List<F4101> listF4101 = servicioF4101.buscarTodosOrdenados();
		catalogoF4101 = new CatalogoGenerico<F4101>(divCatalogoF4101,
				"Catalogo de Artículos", listF4101, true, false, true,
				"Codigo", "Descripcion") {

			@Override
			protected List<F4101> buscar(List<String> valores) {

				List<F4101> lista = new ArrayList<F4101>();

				for (F4101 f4101 : listF4101) {
					if (String.valueOf(f4101.getImitm().longValue())
							.toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f4101.getImdsc1().toLowerCase()
									.contains(valores.get(1).toLowerCase())) {
						lista.add(f4101);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4101 f4101) {
				String[] registros = new String[2];
				registros[0] = String.valueOf(f4101.getImitm().longValue());
				registros[1] = f4101.getImdsc1();
				return registros;
			}
		};
		catalogoF4101.setParent(divCatalogoF4101);
		catalogoF4101.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF4101")
	public void seleccion() {
		F4101 f4101 = catalogoF4101.objetoSeleccionadoDelCatalogo();
		txtUMITMF41002.setValue(f4101.getImitm());
		lblDescripcionF4101.setValue(f4101.getImdsc1());
		txtDescripcionUnidad.setValue(f4101.getImuom1());
		txtDescripcionUnidad.setDisabled(true);
		F0005 f05 = servicioF0005.buscar("00", "UM", f4101.getImuom1());
		if (f05 != null)
			lblDescripcionUnidad.setValue(f05.getDrdl01());
		catalogoF4101.setParent(null);
	}

}
