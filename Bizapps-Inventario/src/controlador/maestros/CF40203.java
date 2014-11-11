package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F40203;
import modelo.maestros.F40203;
import modelo.pk.F40203PK;
import modelo.pk.F40203PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF40203 extends CGenerico {

	@Wire
	private Textbox txtDCTOF40203;
	@Wire
	private Textbox txtLNTYF40203;
	@Wire
	private Textbox txtNSF40203;
	@Wire
	private Textbox txtTRTYF40203;
	@Wire
	private Textbox txtDSC1F40203;
	@Wire
	private Textbox txtNXTRF40203;
	@Wire
	private Textbox txtA1TRF40203;
	@Wire
	private Textbox txtA2TRF40203;
	@Wire
	private Textbox txtA3TRF40203;
	@Wire
	private Textbox txtA4TRF40203;
	@Wire
	private Textbox txtA5TRF40203;
	@Wire
	private Textbox txtWRTHF40203;
	@Wire
	private Div divVF40203;
	@Wire
	private Div botoneraF40203;
	@Wire
	private Div divbuscadorDCTO;
	@Wire
	private Div divbuscadorNTYF;
	@Wire
	private Div divbuscadorTRTY;
	@Wire
	private Div divbuscadorNXTR;
	@Wire
	private Div divbuscadorA1TR;
	@Wire
	private Div divbuscadorA2TR;
	@Wire
	private Div divbuscadorA3TR;
	@Wire
	private Div divbuscadorA4TR;
	@Wire
	private Div divbuscadorA5TR;

	@Wire
	private Div divbuscadorCategoria2;
	@Wire
	private Div catalogoF40203;
	Catalogo<F40203> catalogo;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;

	Botonera botonera;
	F40203PK clave = null;
	BuscadorUDC buscadorDCTO, buscadorNTYF, buscadorTRTY, buscadorNXTR,
			buscadorA1TR, buscadorA2TR, buscadorA3TR, buscadorA4TR,
			buscadorA5TR;

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
		List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"DT");
		buscadorDCTO = new BuscadorUDC("Tipo Orden", 10, listaF0005, true,
				false, false, "00", "DT") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "DT",
						buscadorDCTO.obtenerCaja());
			}
		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "00");
		buscadorNTYF = new BuscadorUDC("Tipo Línea", 10, listaF0005, true,
				false, false, "00", "00") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorNTYF.obtenerCaja());
			}
		};
		List<F0005> listaF0005TRTY = servicioF0005.buscarParaUDCOrdenados("40",
				"AT");
		buscadorTRTY = new BuscadorUDC("Último Estado", 10, listaF0005TRTY,
				true, false, false, "40", "AT") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "AT",
						buscadorTRTY.obtenerCaja());
			}
		};
		List<F0005> listaF0005NXTR = servicioF0005.buscarParaUDCOrdenados("40",
				"AT");
		buscadorNXTR = new BuscadorUDC("Estado Siguiente", 10, listaF0005NXTR,
				false, false, false, "40", "AT") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "AT",
						buscadorNXTR.obtenerCaja());
			}
		};
		List<F0005> listaF0005A1TR = servicioF0005.buscarParaUDCOrdenados("40",
				"AT");
		buscadorA1TR = new BuscadorUDC("Otros 1", 10, listaF0005A1TR, false,
				false, false, "40", "AT") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "AT",
						buscadorA1TR.obtenerCaja());
			}
		};
		List<F0005> listaF0005A2TR = servicioF0005.buscarParaUDCOrdenados("A0",
				"AT");
		buscadorA2TR = new BuscadorUDC("Otros 2", 10, listaF0005A2TR, false,
				false, false, "A0", "AT") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("A0", "AT",
						buscadorA2TR.obtenerCaja());
			}
		};
		List<F0005> listaF0005A3TR = servicioF0005.buscarParaUDCOrdenados("40",
				"AT");
		buscadorA3TR = new BuscadorUDC("Otros 3", 10, listaF0005A3TR, false,
				false, false, "40", "AT") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "AT",
						buscadorA3TR.obtenerCaja());
			}
		};
		List<F0005> listaF0005A4TR = servicioF0005.buscarParaUDCOrdenados("40",
				"AT");
		buscadorA4TR = new BuscadorUDC("Otros 4", 10, listaF0005A4TR, false,
				false, false, "40", "AT") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "AT",
						buscadorA4TR.obtenerCaja());
			}
		};
		List<F0005> listaF0005A5TR = servicioF0005.buscarParaUDCOrdenados("40",
				"AT");
		buscadorA5TR = new BuscadorUDC("Otros 1", 10, listaF0005A5TR, false,
				false, false, "40", "AT") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "AT",
						buscadorA5TR.obtenerCaja());
			}
		};
		divbuscadorNTYF.appendChild(buscadorNTYF);
		divbuscadorDCTO.appendChild(buscadorDCTO);
		divbuscadorTRTY.appendChild(buscadorTRTY);
		divbuscadorNXTR.appendChild(buscadorNXTR);
		divbuscadorA1TR.appendChild(buscadorA1TR);
		divbuscadorA2TR.appendChild(buscadorA2TR);
		divbuscadorA3TR.appendChild(buscadorA3TR);
		divbuscadorA4TR.appendChild(buscadorA4TR);
		divbuscadorA5TR.appendChild(buscadorA5TR);
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F40203 f40 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f40.getId();
						// txtDCTOF40203.setValue(f40.getId().getFsdcto());
						buscadorDCTO.settearCampo(servicioF0005.buscar("00",
								"DT", f40.getId().getFsdcto()));
						buscadorDCTO.inhabilitarCampo();
						buscadorNTYF.settearCampo(servicioF0005.buscar("00",
								"00", f40.getId().getFslnty()));
						buscadorNXTR.settearCampo(servicioF0005.buscar("40",
								"AT", f40.getFsnxtr()));
						buscadorNTYF.inhabilitarCampo();
						// txtLNTYF40203.setValue(f40.getId().getFslnty());
						if (f40.getId().getFstrty() != null) {
//							txtTRTYF40203.setValue(f40.getId().getFstrty());
//							txtTRTYF40203.setDisabled(true);
							buscadorTRTY.settearCampo(servicioF0005.buscar("40",
									"AT", f40.getId().getFstrty()));
							buscadorTRTY.inhabilitarCampo();
						}
						
						// txtNSF40203.setValue(f40.);
//						txtDSC1F40203.setValue(f40.getFsstds());
						txtDSC1F40203.setValue(f40.getFsstds());
//						txtNXTRF40203.setValue(f40.getFsnxtr());
//						txtA1TRF40203.setValue(f40.getFsa1tr());
//						txtA2TRF40203.setValue(f40.getFsa2tr());
//						txtA3TRF40203.setValue(f40.getFsa3tr());
//						txtA4TRF40203.setValue(f40.getFsa4tr());
//						txtA5TRF40203.setValue(f40.getFsa5tr()); Acomodar UDC
						txtWRTHF40203.setValue(f40.getFswrth());
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF40203,
						titulo , tabs);

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

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
				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {
					String dcto = buscadorDCTO.obtenerCaja();
					String lnty = buscadorNTYF.obtenerCaja();
					String trty = buscadorTRTY.obtenerCaja();
					// donde la guardo
					String ns = txtNSF40203.getValue();
					String dsc1 = txtDSC1F40203.getValue();
					String nxtr = buscadorNXTR.obtenerCaja();
					String a1tr = buscadorA1TR.obtenerCaja();
					String a2tr = buscadorA2TR.obtenerCaja();
					String a3tr = buscadorA3TR.obtenerCaja();
					String a4tr = buscadorA4TR.obtenerCaja();
					String a5tr = buscadorA5TR.obtenerCaja();
					String wrth = txtWRTHF40203.getValue();
					F40203PK clave = new F40203PK();
					clave.setFsdcto(dcto);
					clave.setFslnty(lnty);
					clave.setFstrty(trty);
					F40203 f40203 = new F40203();
					f40203.setId(clave);
					// f40203
					f40203.setFsstds(dsc1);
					f40203.setFsnxtr(nxtr);
					f40203.setFsa1tr(a1tr);
					f40203.setFsa2tr(a2tr);
					f40203.setFsa3tr(a3tr);
					f40203.setFsa4tr(a4tr);
					f40203.setFsa5tr(a5tr);
					f40203.setFswrth(wrth);
					servicioF40203.guardar(f40203);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF40203
							.buscarTodosOrdenados());
				}

			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F40203> eliminarLista = catalogo
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
													servicioF40203
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF40203
															.buscarTodosOrdenados());
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
													servicioF40203
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF40203
															.buscarTodosOrdenados());
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
		botoneraF40203.appendChild(botonera);

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
		buscadorDCTO.settearCampo(null);
		buscadorNTYF.settearCampo(null);
		txtNSF40203.setValue("");
		buscadorTRTY.settearCampo(null);
		txtDSC1F40203.setValue("");
		buscadorNXTR.settearCampo(null);
		buscadorA1TR.settearCampo(null);
		buscadorA2TR.settearCampo(null);
		buscadorA3TR.settearCampo(null);
		buscadorA4TR.settearCampo(null);
		buscadorA5TR.settearCampo(null);
		txtWRTHF40203.setValue("");
		buscadorDCTO.focus();
	}

	public void habilitarTextClave() {
		buscadorDCTO.habilitarCampos();
		buscadorNTYF.habilitarCampos();
		buscadorTRTY.habilitarCampos();
	}

	public boolean validarSeleccion() {
		List<F40203> seleccionados = catalogo.obtenerSeleccionados();
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
		if (claveDCTOExiste()) {
			return false;
		} else {
			if (!camposLLenos()) {
				msj.mensajeError(Mensaje.camposVacios);
				return false;
			} else
				return true;
		}
	}

	@Listen("onChange = #txtDCTOF40203")
	public boolean claveDCTOExiste() {
		if (servicioF40203.buscar(buscadorDCTO.obtenerCaja(),
				buscadorNTYF.obtenerCaja(), buscadorTRTY.obtenerCaja()) != null) {
			msj.mensajeAlerta(Mensaje.claveUsada);
			buscadorDCTO.focus();
			return true;
		} else
			return false;
	}

	public boolean camposLLenos() {
		if (buscadorDCTO.obtenerCaja().compareTo("") == 0
				|| buscadorNTYF.obtenerCaja().compareTo("") == 0
				//|| txtNSF40203.getText().compareTo("") == 0
				|| buscadorTRTY.obtenerCaja().compareTo("") == 0
				//|| txtDSC1F40203.getText().compareTo("") == 0
				//|| buscadorNXTR.obtenerCaja().compareTo("") == 0
				//|| buscadorA1TR.obtenerCaja().compareTo("") == 0
				//|| buscadorA2TR.obtenerCaja().compareTo("") == 0
				//|| buscadorA3TR.obtenerCaja().compareTo("") == 0
				//|| buscadorA4TR.obtenerCaja().compareTo("") == 0
				//|| buscadorA5TR.obtenerCaja().compareTo("") == 0
				//|| txtWRTHF40203.getText().compareTo("") == 0
				) {
			return false;
		} else
			return true;
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
	}

	public boolean camposEditando() {
		if (buscadorDCTO.obtenerCaja().compareTo("") != 0
				|| buscadorNTYF.obtenerCaja().compareTo("") != 0
				|| txtNSF40203.getText().compareTo("") != 0
				|| buscadorTRTY.obtenerCaja().compareTo("") != 0
				|| txtDSC1F40203.getText().compareTo("") != 0
				|| buscadorNXTR.obtenerCaja().compareTo("") != 0
				|| buscadorA1TR.obtenerCaja().compareTo("") != 0
				|| buscadorA2TR.obtenerCaja().compareTo("") != 0
				|| buscadorA3TR.obtenerCaja().compareTo("") != 0
				|| buscadorA4TR.obtenerCaja().compareTo("") != 0
				|| buscadorA5TR.obtenerCaja().compareTo("") != 0
				|| txtWRTHF40203.getText().compareTo("") != 0) {
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
									// habilitarTextClave();
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
		final List<F40203> actividades = servicioF40203.buscarTodosOrdenados();
		catalogo = new Catalogo<F40203>(catalogoF40203, "F40203", actividades,
				false, false, true, "Tipo Orden", "Tipo Línea",
				"Último estado", "Descripción", "Est sig", "Otros 1",
				"Otros 2", "Otros 3", "Otros 4", "Otros 5", "LM (Y/M)") {

			@Override
			protected List<F40203> buscar(List<String> valores) {

				List<F40203> actividad = new ArrayList<F40203>();

				for (F40203 actividadord : actividades) {
					if (actividadord.getId().getFsdcto().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& actividadord.getId().getFslnty().toLowerCase()
							.contains(valores.get(1).toLowerCase())
							&& actividadord.getId().getFslnty().toLowerCase()
							.contains(valores.get(2).toLowerCase())
							&& actividadord.getFsstds().toLowerCase()
							.contains(valores.get(3).toLowerCase())
							&& actividadord.getFsnxtr().toLowerCase()
							.contains(valores.get(4).toLowerCase())
							&& actividadord.getFsa1tr().toLowerCase()
							.contains(valores.get(5).toLowerCase())
							&& actividadord.getFsa2tr().toLowerCase()
							.contains(valores.get(6).toLowerCase())
							&& actividadord.getFsa3tr().toLowerCase()
							.contains(valores.get(7).toLowerCase())
							&& actividadord.getFsa4tr().toLowerCase()
							.contains(valores.get(8).toLowerCase())
							&& actividadord.getFsa5tr().toLowerCase()
							.contains(valores.get(9).toLowerCase())
							&& actividadord.getFswrth().toLowerCase()
							.contains(valores.get(10).toLowerCase())) {
						actividad.add(actividadord);
					}
				}
				return actividad;
			}

			@Override
			protected String[] crearRegistros(F40203 reglasactividad) {
				String[] registros = new String[11];
				registros[0] = reglasactividad.getId().getFsdcto();
				registros[1] = reglasactividad.getId().getFslnty();
				registros[2] = reglasactividad.getId().getFslnty();
				registros[3] = reglasactividad.getFsstds();
				registros[4] = reglasactividad.getFsnxtr();
				registros[5] = reglasactividad.getFsa1tr();
				registros[6] = reglasactividad.getFsa2tr();
				registros[7] = reglasactividad.getFsa3tr();
				registros[8] = reglasactividad.getFsa4tr();
				registros[9] = reglasactividad.getFsa5tr();
				registros[10] = reglasactividad.getFswrth();
				return registros;
			}
		};
		catalogo.setParent(catalogoF40203);
		// catalogo.doModal();
	}

}
