package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F0010;
import modelo.maestros.F0013;
import modelo.maestros.F0101;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Mensaje;
import componentes.catalogos.CatalogoF0010;
import componentes.catalogos.CatalogoF0013;
import componentes.catalogos.CatalogoF0101;
import componentes.catalogos.CatalogoGenerico;

public class CF0010 extends CGenerico {

	private static final long serialVersionUID = -3026737348271891635L;

	@Wire
	private Textbox txtCCCOF0010;
	@Wire
	private Textbox txtNameF0010;
	@Wire
	private Label lblMonedaF0010;
	// @Wire
	// private Textbox txtPatronF0010;
	// @Wire
	// private Textbox txtDireccionF0010;
	@Wire
	private Textbox txtCCCRCDF0010;
	@Wire
	private Textbox txtRMF0010;
	@Wire
	private Textbox txtDot2F0010;
	@Wire
	private Longbox txtAn8F0010;
	@Wire
	private Label lblDireccionF0010;
	@Wire
	private Div catalogoDireccionF0010;
	// @Wire
	// private Textbox txtCaldF0010;
	@Wire
	private Div divbuscadorDPNT;
	@Wire
	private Div divbuscadorCALD;
	@Wire
	private Doublespinner dpnPeriodoActualGeneralF0010;
	@Wire
	private Doublespinner dpnPeriodoPagarF0010;
	@Wire
	private Doublespinner dpnPeriodoCobrarF0010;
	@Wire
	private Doublespinner dpnPeriodoInformeF0010;
	@Wire
	private Doublespinner dpnAnnoInformeF0010;
	@Wire
	private Datebox dtbFechaGeneralF0010;
	@Wire
	private Datebox dtbFechaPagarF0010;
	@Wire
	private Datebox dtbFechaCobrarF0010;
	@Wire
	private Checkbox chxTransitoria;
	@Wire
	private Checkbox chxSaldos;
	@Wire
	private Div divVF0010;
	@Wire
	private Div botoneraF0010;
	@Wire
	private Div catalogoF0010;
	@Wire
	private Div catalogoMonedaF0010;
	@Wire
	private Groupbox gpxDatosF0010;
	@Wire
	private Groupbox gpxRegistroF0010;
	protected List<F0010> listaGeneral = new ArrayList<F0010>();

	Botonera botonera;
	CatalogoF0010 catalogo;
	CatalogoF0013 catalogoM;
	CatalogoF0101 catalogoD;
	String clave = null;

	BuscadorUDC buscadorDPNT;
	BuscadorUDC buscadorCALD;

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
		txtCCCOF0010.setFocus(true);
		mostrarCatalogo();
		List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("H00",
				"DP");
		buscadorDPNT = new BuscadorUDC("Patron fecha fiscal", 10, listaF0005,
				true, false, false, "H00", "DP") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H00", "DP",
						buscadorDPNT.obtenerCaja());
			}
		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H00", "DA");
		buscadorCALD = new BuscadorUDC("Numero periodos", 2, listaF0005, false,
				false, false, "H00", "DA") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H00", "DA",
						buscadorCALD.obtenerCaja());
			}
		};
		divbuscadorDPNT.appendChild(buscadorDPNT);
		divbuscadorCALD.appendChild(buscadorCALD);
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F0010 f010 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f010.getCcco();
						txtCCCOF0010.setValue(f010.getCcco());
						txtCCCOF0010.setDisabled(true);
						txtCCCRCDF0010.setValue(f010.getCccrcd());
						if (!f010.getCccrcd().equals(""))
							lblMonedaF0010.setValue(servicioF0013.buscar(
									f010.getCccrcd()).getCvdl01());
						txtNameF0010.setValue(f010.getCcname());
						Double a = f010.getCcan8();
						if (a != null) {
							if (a != 0) {
								txtAn8F0010.setValue(a.longValue());
								lblDireccionF0010.setValue(servicioF0101
										.buscar(f010.getCcan8()).getAbalph());
							}
						}
						buscadorDPNT.settearCampo(servicioF0005.buscar("H00",
								"DP", f010.getCcdtpn()));
						txtRMF0010.setValue(f010.getCcbktx());
						txtDot2F0010.setValue(f010.getCcdot2());
						buscadorCALD.settearCampo(servicioF0005.buscar("H00",
								"DA", f010.getCccald()));
						dpnPeriodoActualGeneralF0010.setValue(f010.getCcpnc());
						dpnPeriodoPagarF0010.setValue(f010.getCcappn());
						dpnPeriodoCobrarF0010.setValue(f010.getCcarpn());
						dpnPeriodoInformeF0010.setValue(f010.getCcpnf());
						dpnAnnoInformeF0010.setValue(f010.getCcfry());
						if (f010.getCcarfj() != null)
							dtbFechaCobrarF0010
									.setValue(transformarJulianaAGregoria(f010
											.getCcarfj()));
						if (f010.getCcdfyj() != null)
							dtbFechaGeneralF0010
									.setValue(transformarJulianaAGregoria(f010
											.getCcdfyj()));
						if (f010.getCcapfj() != null)
							dtbFechaPagarF0010
									.setValue(transformarJulianaAGregoria(f010
											.getCcapfj()));
						if (f010.getCcdprc().equals("1"))
							chxTransitoria.setChecked(true);
						else
							chxTransitoria.setChecked(false);
						if (f010.getCcabin().equals("1"))
							chxSaldos.setChecked(true);
						else
							chxSaldos.setChecked(false);

					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0010, titulo, tabs);
			}

			@Override
			public void reporte() {
				transformarJulianaAGregoria(BigDecimal.valueOf(114093));
			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
				habilitarTextClave();
				clave = null;
			}

			@Override
			public void guardar() {

				if (validar()) {

					F0010 f010 = new F0010();
					Long lon;
					if (txtAn8F0010.getText().compareTo("") != 0) {
						lon = txtAn8F0010.getValue();
						f010.setCcan8(lon.doubleValue());
					}
					f010.setCcco(txtCCCOF0010.getValue());
					f010.setCccrcd(txtCCCRCDF0010.getValue());
					f010.setCcname(txtNameF0010.getValue());
					f010.setCcdtpn(buscadorDPNT.obtenerCaja());
					f010.setCcbktx(txtRMF0010.getValue());
					f010.setCcdot2(txtDot2F0010.getValue());
					f010.setCccald(buscadorCALD.obtenerCaja());
					f010.setCcpnc(dpnPeriodoActualGeneralF0010.getValue());
					f010.setCcappn(dpnPeriodoPagarF0010.getValue());
					f010.setCcarpn(dpnPeriodoCobrarF0010.getValue());
					f010.setCcpnf(dpnPeriodoInformeF0010.getValue());
					f010.setCcfry(dpnAnnoInformeF0010.getValue());
					if (dtbFechaCobrarF0010.getValue() != null)
						f010.setCcarfj(transformarGregorianoAJulia(dtbFechaCobrarF0010
								.getValue()));
					if (dtbFechaGeneralF0010.getValue() != null)
						f010.setCcdfyj(transformarGregorianoAJulia(dtbFechaGeneralF0010
								.getValue()));
					if (dtbFechaPagarF0010.getValue() != null)
						f010.setCcapfj(transformarGregorianoAJulia(dtbFechaPagarF0010
								.getValue()));
					f010.setCcupmj(transformarGregorianoAJulia(fecha));
					f010.setCcupmt(Double.valueOf(horaAuditoria));
					f010.setCcuser("JDE");
					if (chxTransitoria.isChecked())
						f010.setCcdprc("1");
					else
						f010.setCcdprc("0");
					if (chxSaldos.isChecked())
						f010.setCcabin("1");
					else
						f010.setCcabin("0");
					servicioF0010.guardar(f010);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					listaGeneral = servicioF0010.buscarTodosOrdenados();
					catalogo.actualizarLista(listaGeneral);

				}
			}

			@Override
			public void eliminar() {
				if (gpxDatosF0010.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F0010> eliminarLista = catalogo
								.obtenerSeleccionados();
						final int cantidad = eliminarLista.size();
						for (int i = 0; i < eliminarLista.size(); i++) {
							F0010 valor = eliminarLista.get(i);
							List<F0006> objeto = servicioF0006
									.buscarPorMco(valor.getCcco());
							if (!objeto.isEmpty()) {
								eliminarLista.remove(valor);
								i--;
							}
						}
						if (!eliminarLista.isEmpty()) {
							Messagebox
									.show("¿Desea Eliminar los "
											+ eliminarLista.size()
											+ " Registros?",
											"Alerta",
											Messagebox.OK | Messagebox.CANCEL,
											Messagebox.QUESTION,
											new org.zkoss.zk.ui.event.EventListener<Event>() {
												public void onEvent(Event evt)
														throws InterruptedException {
													if (evt.getName().equals(
															"onOK")) {
														servicioF0010
																.eliminarVarios(eliminarLista);
														listaGeneral = servicioF0010
																.buscarTodosOrdenados();
														catalogo.actualizarLista(listaGeneral);

														if (cantidad != eliminarLista
																.size())
															msj.mensajeInformacion(Mensaje.algunosEliminados);
														else
															msj.mensajeInformacion(Mensaje.eliminado);
													}
												}
											});
						} else {
							msj.mensajeAlerta(Mensaje.registroUtilizado);
						}
					}
				} else {
					/* Elimina un solo registro */
					if (clave != null) {
						List<F0006> objeto = servicioF0006.buscarPorMco(clave);
						if (objeto.isEmpty()) {
							Messagebox
									.show(Mensaje.deseaEliminar,
											"Alerta",
											Messagebox.OK | Messagebox.CANCEL,
											Messagebox.QUESTION,
											new org.zkoss.zk.ui.event.EventListener<Event>() {
												public void onEvent(Event evt)
														throws InterruptedException {
													if (evt.getName().equals(
															"onOK")) {
														servicioF0010
																.eliminarUno(clave);
														msj.mensajeInformacion(Mensaje.eliminado);
														limpiar();
														listaGeneral = servicioF0010
																.buscarTodosOrdenados();
														catalogo.actualizarLista(listaGeneral);
													}
												}
											});
						} else {
							msj.mensajeAlerta(Mensaje.registroUtilizado);
						}
					} else
						msj.mensajeAlerta(Mensaje.noSeleccionoRegistro);
				}
			}

			@Override
			public void buscar() {
				// TODO Auto-generated method stub
				abrirCatalogo();
				transformarGregorianoAJulia(fecha);
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
		botoneraF0010.appendChild(botonera);
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
		if (chxTransitoria.isChecked())
			chxTransitoria.setChecked(false);
		if (chxSaldos.isChecked())
			chxSaldos.setChecked(false);
		txtAn8F0010.setValue(null);
		lblDireccionF0010.setValue("");
		txtCCCOF0010.setValue("");
		txtCCCRCDF0010.setValue("");
		txtNameF0010.setValue("");
		buscadorDPNT.settearCampo(null);
		txtRMF0010.setValue("");
		txtDot2F0010.setValue("");
		buscadorCALD.settearCampo(null);
		dpnPeriodoActualGeneralF0010.setValue((double) 0);
		dpnPeriodoPagarF0010.setValue((double) 0);
		dpnPeriodoCobrarF0010.setValue((double) 0);
		dpnPeriodoInformeF0010.setValue((double) 0);
		dpnAnnoInformeF0010.setValue((double) 0);
		dtbFechaCobrarF0010.setValue(null);
		dtbFechaGeneralF0010.setValue(null);
		dtbFechaPagarF0010.setValue(null);
		txtCCCOF0010.setFocus(true);
		lblMonedaF0010.setValue("");
	}

	public void habilitarTextClave() {
		if (txtCCCOF0010.isDisabled())
			txtCCCOF0010.setDisabled(false);
	}

	public boolean validarSeleccion() {
		List<F0010> seleccionados = catalogo.obtenerSeleccionados();
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
		if (claveSYExiste()) {
			return false;
		} else {
			if (!camposLLenos()) {
				msj.mensajeError(Mensaje.camposVacios);
				return false;
			} else
				return true;
		}
	}

	@Listen("onChange = #txtCCCOF0010")
	public boolean claveSYExiste() {
		if (servicioF0010.buscar(txtCCCOF0010.getValue()) != null) {
			msj.mensajeAlerta(Mensaje.claveUsada);
			txtCCCOF0010.setFocus(true);
			return true;
		} else
			return false;
	}

	public boolean camposLLenos() {
		if (txtCCCOF0010.getText().compareTo("") == 0
				|| buscadorDPNT.obtenerCaja().compareTo("") == 0
				|| txtNameF0010.getText().compareTo("") == 0
				|| dtbFechaGeneralF0010.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtCCCOF0010.getText().compareTo("") != 0
				|| txtCCCRCDF0010.getText().compareTo("") != 0
				|| txtNameF0010.getText().compareTo("") != 0
				|| buscadorDPNT.obtenerCaja().compareTo("") != 0
				|| txtRMF0010.getText().compareTo("") != 0
				|| dpnAnnoInformeF0010.getValue() != 0
				|| txtDot2F0010.getText().compareTo("") != 0
				|| dpnPeriodoActualGeneralF0010.getValue() != 0
				|| dpnPeriodoCobrarF0010.getValue() != 0
				|| buscadorCALD.obtenerCaja().compareTo("") != 0
				|| dpnPeriodoInformeF0010.getValue() != 0
				|| dpnPeriodoPagarF0010.getValue() != 0
				|| dtbFechaCobrarF0010.getText().compareTo("") != 0
				|| dtbFechaGeneralF0010.getText().compareTo("") != 0
				|| dtbFechaPagarF0010.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	@Listen("onClick = #gpxRegistroF0010")
	public void abrirRegistro() {
		gpxDatosF0010.setOpen(false);
		gpxRegistroF0010.setOpen(true);
		mostrarBotones(false);
	}

	@Listen("onOpen = #gpxDatosF0010")
	public void abrirCatalogo() {
		gpxDatosF0010.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF0010.setOpen(false);
								gpxRegistroF0010.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF0010.setOpen(true);
									gpxRegistroF0010.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF0010.setOpen(true);
			gpxRegistroF0010.setOpen(false);
			mostrarBotones(true);
		}
	}

	public void mostrarCatalogo() {
		listaGeneral = servicioF0010.buscarTodosOrdenados();
		catalogo = new CatalogoF0010(catalogoF0010, "F0010", listaGeneral,
				false, "Codigo", "Nombre", "Nº Periodo", "Patron fechas",
				"Inicio año Fiscal", "Periodo LM", "Inicio año C/P",
				"Periodo C/P", "Inicio año C/C", "Periodo C/C",
				"Periodo financiero");
		catalogo.setParent(catalogoF0010);
	}

	@Listen("onClick = #btnBuscarDireccion")
	public void mostrarCatalogoDireccion() {
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoD = new CatalogoF0101(catalogoDireccionF0010,
				"Catalogo de Direcciones", listF0101, true, "Nº direccion",
				"Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal");
		catalogoD.setParent(catalogoDireccionF0010);
		catalogoD.doModal();
	}

	@Listen("onChange = #txtAn8F0010; onOk= #txtAn8F0010 ")
	public void buscarDireccion() {
		if (txtAn8F0010.getValue() != null) {
			F0101 f0101 = servicioF0101.buscar(txtAn8F0010.getValue());
			if (f0101 != null) {
				Double doble = f0101.getAban8();
				txtAn8F0010.setValue(doble.longValue());
				lblDireccionF0010.setValue(f0101.getAbalph());
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				lblDireccionF0010.setValue("");
				txtAn8F0010.setValue(null);
				txtAn8F0010.setFocus(true);
			}
		} else
			lblDireccionF0010.setValue("");
	}

	@Listen("onSeleccion = #catalogoDireccionF0010")
	public void seleccionarCatalogo() {
		F0101 f0101 = catalogoD.objetoSeleccionadoDelCatalogo();
		if (f0101 != null) {
			Double doble = f0101.getAban8();
			txtAn8F0010.setValue(doble.longValue());
			lblDireccionF0010.setValue(f0101.getAbalph());
		}
		catalogoD.setParent(null);
	}

	@Listen("onClick = #btnBuscarMoneda")
	public void mostrarCatalogoMoneda() throws IOException {
		List<F0013> listF0013 = servicioF0013.buscarTodosOrdenados();
		catalogoM = new CatalogoF0013(catalogoMonedaF0010,
				"Catalogo de Monedas y Tarifas", listF0013, true, "Codigo",
				"Descripcion", "Vlslz", "Rutina Cheques");
		catalogoM.setParent(catalogoMonedaF0010);
		catalogoM.doModal();
	}

	@Listen("onSeleccion = #catalogoMonedaF0010")
	public void seleccion() {
		F0013 f0013 = catalogoM.objetoSeleccionadoDelCatalogo();
		txtCCCRCDF0010.setValue(f0013.getCvcrcd());
		lblMonedaF0010.setValue(f0013.getCvdl01());
		catalogoM.setParent(null);
	}

	@Listen("onChange = #txtCCCRCDF0010; onOk = #txtCCCRCDF0010")
	public void buscarNombre() {
		F0013 f0013 = servicioF0013.buscar(txtCCCRCDF0010.getValue());
		if (f0013 != null) {
			txtCCCRCDF0010.setValue(f0013.getCvcrcd());
			lblMonedaF0010.setValue(f0013.getCvdl01());
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtCCCRCDF0010.setValue("");
			txtCCCRCDF0010.setFocus(true);
		}
	}
}
