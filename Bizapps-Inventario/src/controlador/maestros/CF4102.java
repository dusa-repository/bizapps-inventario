package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0006;
import modelo.maestros.F4101;
import modelo.maestros.F4102;
import modelo.pk.F4102PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.catalogos.CatalogoF0006;
import componentes.catalogos.CatalogoF4101;
import componentes.catalogos.CatalogoGenerico;

public class CF4102 extends CGenerico {

	private static final long serialVersionUID = -4190367732724804440L;
	@Wire
	private Doublebox txtItem;
	@Wire
	private Label lblItem;
	@Wire
	private Textbox txtPlanta;
	@Wire
	private Label lblPlanta;
	@Wire
	private Button btnBuscarPlanta;
	@Wire
	private Button btnBuscarItem;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Div divVF4102;
	@Wire
	private Div divCatalogoF4101;
	@Wire
	private Div divCatalogoF0006;
	@Wire
	private Div catalogoF4102;
	@Wire
	private Div botoneraF4102;
	@Wire
	private Doublespinner spnOrden;
	@Wire
	private Doublespinner spnMinimo;
	@Wire
	private Doublespinner spnMaximo;
	@Wire
	private Doublespinner spnPunto;
	@Wire
	private Doublespinner spnMultiple;
	@Wire
	private Doublespinner spnContenedor;
	@Wire
	private Doublespinner spnSeguridad;
	Botonera botonera;
	CatalogoGenerico<F0006> catalogoF0006;
	CatalogoGenerico<F4101> catalogoF4101;
	CatalogoGenerico<F4102> catalogo;
	String mcu = "";
	F4102PK clave = null;
	protected List<F4102> listaGeneral = new ArrayList<F4102>();

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
		mostrarCatalogo();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F4102 objeto = catalogo.objetoSeleccionadoDelCatalogo();
						clave = objeto.getId();
						spnContenedor.setValue(objeto.getIbacq());
						spnMaximo.setValue(objeto.getIbanpl());
						spnMinimo.setValue(objeto.getIbavrt());
						spnMultiple.setValue(objeto.getIbbbdd());
						spnOrden.setValue(objeto.getIbbqty());
						spnPunto.setValue(objeto.getIbbuyr());
						spnSeguridad.setValue(objeto.getIbcarp());
						F0006 f0006 = servicioF0006.buscar(objeto.getId()
								.getIbmcu());
						txtPlanta.setValue(String.valueOf(f0006.getMcmcu()));
						lblPlanta.setValue(f0006.getMcdc());
						mcu = f0006.getMcmcu();
						F4101 f4101 = servicioF4101.buscar(objeto.getId()
								.getIbitm());
						Double doble = f4101.getImitm();
						txtItem.setValue(doble.longValue());
						lblItem.setValue(f4101.getImdsc1());
						btnBuscarItem.setVisible(false);
						btnBuscarPlanta.setVisible(false);
						txtItem.setDisabled(false);
						txtPlanta.setDisabled(false);
					} else
						Mensaje.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF4102, titulo, tabs);
			}

			@Override
			public void reporte() {
			}

			@Override
			public void limpiar() {
				btnBuscarItem.setVisible(true);
				btnBuscarPlanta.setVisible(true);
				mostrarBotones(false);
				limpiarCampos();
				habilitarTextClave();
				clave = null;
			}

			@Override
			public void guardar() {
				if (validar()) {
					if (clave == null) {
						clave = new F4102PK();
						clave.setIbitm(txtItem.getValue());
						clave.setIbmcu(txtPlanta.getValue());
					}
					F4102 objeto = new F4102();
					objeto.setId(clave);
					objeto.setIbacq(spnContenedor.getValue());
					objeto.setIbanpl(spnMaximo.getValue());
					objeto.setIbavrt(spnMinimo.getValue());
					objeto.setIbbbdd(spnMultiple.getValue());
					objeto.setIbbqty(spnOrden.getValue());
					objeto.setIbbuyr(spnPunto.getValue());
					objeto.setIbcarp(spnSeguridad.getValue());
					String nombre;
					if (lblItem.getValue().length() > 25)
						nombre = lblItem.getValue().substring(0, 24);
					else
						nombre = lblItem.getValue();
					objeto.setIbaitm(nombre);
					objeto.setIbuser(nombreUsuarioSesion());
					objeto.setIblfdj(transformarGregorianoAJulia(fecha));
					servicioF4102.guardar(objeto);
					Mensaje.mensajeInformacion(Mensaje.guardado);
					limpiar();
					listaGeneral = servicioF4102.buscarTodosOrdenados();
					catalogo.actualizarLista(listaGeneral);
				}
			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F4102> eliminarLista = catalogo
								.obtenerSeleccionados();
						final int cantidad = eliminarLista.size();
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
													servicioF4102
															.eliminarVarios(eliminarLista);
													listaGeneral = servicioF4102
															.buscarTodosOrdenados();
													catalogo.actualizarLista(listaGeneral);

													if (cantidad != eliminarLista
															.size())
														Mensaje.mensajeInformacion(Mensaje.algunosEliminados);
													else
														Mensaje.mensajeInformacion(Mensaje.eliminado);
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
													servicioF4102
															.eliminarUno(clave);
													Mensaje.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													listaGeneral = servicioF4102
															.buscarTodosOrdenados();
													catalogo.actualizarLista(listaGeneral);
												}
											}
										});
					} else
						Mensaje.mensajeAlerta(Mensaje.noSeleccionoRegistro);
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
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF4102.appendChild(botonera);
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

	private boolean camposEditando() {
		if (txtItem.getText().compareTo("") != 0
				|| txtPlanta.getText().compareTo("") != 0
				|| spnContenedor.getValue() != 0 || spnMaximo.getValue() != 0
				|| spnMinimo.getValue() != 0 || spnMultiple.getValue() != 0
				|| spnOrden.getValue() != 0 || spnPunto.getValue() != 0
				|| spnSeguridad.getValue() != 0) {
			return true;
		} else
			return false;
	}

	protected boolean validar() {
		if (!camposLLenos()) {
			Mensaje.mensajeError(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	private boolean camposLLenos() {
		if (txtItem.getText().compareTo("") == 0
				|| txtPlanta.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	protected void habilitarTextClave() {
		if (txtItem.isDisabled())
			txtItem.setDisabled(false);
		if (txtPlanta.isDisabled())
			txtPlanta.setDisabled(false);

	}

	protected void limpiarCampos() {
		clave = null;
		txtItem.setValue(null);
		txtPlanta.setValue("");
		lblPlanta.setValue("");
		lblItem.setValue("");
		spnContenedor.setValue((double) 0);
		spnMaximo.setValue((double) 0);
		spnMinimo.setValue((double) 0);
		spnMultiple.setValue((double) 0);
		spnOrden.setValue((double) 0);
		spnPunto.setValue((double) 0);
		spnSeguridad.setValue((double) 0);
		catalogo.limpiarSeleccion();
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
	}

	protected void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(!bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	protected boolean validarSeleccion() {
		List<F4102> seleccionados = catalogo.obtenerSeleccionados();
		if (seleccionados == null) {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			return false;
		} else {
			if (seleccionados.isEmpty()) {
				Mensaje.mensajeAlerta(Mensaje.noSeleccionoItem);
				return false;
			} else {
				return true;
			}
		}
	}

	private void mostrarCatalogo() {
		listaGeneral = servicioF4102.buscarTodosOrdenados();
		catalogo = new CatalogoGenerico<F4102>(catalogoF4102, "F4102",
				listaGeneral, false, false, true, "Sucursal/Planta", "Item",
				"Descripcion Item", "Cantidad Orden", "Orden Minimo",
				"Orden Maximo", "Stock Seguridad") {
			private static final long serialVersionUID = 1L;

			@Override
			protected List<F4102> buscar(List<String> valores) {
				List<F4102> lista = new ArrayList<F4102>();
				for (F4102 objeto : listaGeneral) {
					if (objeto.getId().getIbmcu().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& String
									.valueOf(
											objeto.getId().getIbitm()
													.longValue()).toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& objeto.getIbaitm().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& String.valueOf(objeto.getIbbqty().longValue())
									.toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& String.valueOf(objeto.getIbavrt().longValue())
									.toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& String.valueOf(objeto.getIbanpl().longValue())
									.toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& String.valueOf(objeto.getIbcarp().longValue())
									.toLowerCase()
									.contains(valores.get(6).toLowerCase())) {
						lista.add(objeto);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4102 objeto) {
				String[] registros = new String[7];
				registros[0] = objeto.getId().getIbmcu();
				registros[1] = String.valueOf(objeto.getId().getIbitm()
						.longValue());
				registros[2] = objeto.getIbaitm();
				registros[3] = String.valueOf(objeto.getIbbqty().longValue());
				registros[4] = String.valueOf(objeto.getIbavrt().longValue());
				registros[5] = String.valueOf(objeto.getIbanpl().longValue());
				registros[6] = String.valueOf(objeto.getIbcarp().longValue());
				return registros;
			}
		};
		catalogo.setParent(catalogoF4102);
	}

	@Listen("onClick = #btnBuscarPlanta")
	public void mostrarCatalogoF0006() {
		List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoF0006 = new CatalogoF0006(divCatalogoF0006, "F0006Emergente",
				unidades, true, "Unidad Negocio", "Descripcion", "Nivel det",
				"Cta", "Tipo UN", "LM Auxiliar Inactivo", "Mto Cons", "CAT 01",
				"CAT 02", "CAT 03", "CAT 04", "CAT 05", "CAT 06");
		catalogoF0006.setParent(divCatalogoF0006);
		catalogoF0006.doModal();
	}

	@Listen("onChange = #txtPlanta; onOK = #txtPlanta ")
	public void buscarNombreSucursal() {
		F0006 f06 = new F0006();
		f06 = servicioF0006.buscar(txtPlanta.getValue());
		if (f06 != null) {
			mcu = f06.getMcmcu();
			txtPlanta.setValue(String.valueOf(f06.getMcmcu()));
			lblPlanta.setValue(f06.getMcdc());
			verificarObjeto();
		} else {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			mcu = "";
			txtPlanta.setValue("");
			txtPlanta.setFocus(true);
			lblPlanta.setValue("");
		}

	}

	@Listen("onSeleccion = #divCatalogoF0006")
	public void seleccionF0006() {
		F0006 f0006 = catalogoF0006.objetoSeleccionadoDelCatalogo();
		txtPlanta.setValue(String.valueOf(f0006.getMcmcu()));
		lblPlanta.setValue(f0006.getMcdc());
		mcu = f0006.getMcmcu();
		verificarObjeto();
		catalogoF0006.setParent(null);
	}

	@Listen("onClick = #btnBuscarItem")
	public void mostrarCatalogoF4101() {
		List<F4101> listF41011 = new ArrayList<F4101>();
		// if (!mcu.equals(""))
		listF41011 = servicioF4101.buscarTodosOrdenadosPorMcu(mcu);
		// else
		// listF41011 = servicioF4101.buscarTodosOrdenados();
		final List<F4101> listF4101 = listF41011;
		catalogoF4101 = new CatalogoF4101(divCatalogoF4101, "F4101", listF4101,
				true, "Codigo", "Descripcion");
		catalogoF4101.setParent(divCatalogoF4101);
		catalogoF4101.doModal();
	}

	@Listen("onChange = #txtItem; onOK = #txtItem")
	public void buscarNombreItem() {
		F4101 f4101 = servicioF4101.buscar(txtItem.getValue());
		if (f4101 != null) {
			Double doble = f4101.getImitm();
			txtItem.setValue(doble.longValue());
			lblItem.setValue(f4101.getImdsc1());
			verificarObjeto();
		} else {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			txtItem.setValue(null);
			txtItem.setFocus(true);
			lblItem.setValue("");
		}
	}

	@Listen("onSeleccion = #divCatalogoF4101")
	public void seleccionF4101() {
		F4101 f4101 = catalogoF4101.objetoSeleccionadoDelCatalogo();
		Double doble = f4101.getImitm();
		txtItem.setValue(doble.longValue());
		lblItem.setValue(f4101.getImdsc1());
		verificarObjeto();
		catalogoF4101.setParent(null);
	}

	private void verificarObjeto() {
		if (txtPlanta.getText().compareTo("") != 0
				&& txtItem.getText().compareTo("") != 0) {
			F4102PK id = new F4102PK();
			id.setIbitm(txtItem.getValue());
			id.setIbmcu(txtPlanta.getValue());
			F4102 objeto = servicioF4102.buscar(id);
			if (objeto != null) {
				spnContenedor.setValue(objeto.getIbacq());
				spnMaximo.setValue(objeto.getIbanpl());
				spnMinimo.setValue(objeto.getIbavrt());
				spnMultiple.setValue(objeto.getIbbbdd());
				spnOrden.setValue(objeto.getIbbqty());
				spnPunto.setValue(objeto.getIbbuyr());
				spnSeguridad.setValue(objeto.getIbcarp());
			}
		}
	}

}
