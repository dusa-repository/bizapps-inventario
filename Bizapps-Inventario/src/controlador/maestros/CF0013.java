package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0010;
import modelo.maestros.F0013;
import modelo.maestros.F0015;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;

public class CF0013 extends CGenerico {

	private static final long serialVersionUID = 947665973351909698L;
	@Wire
	private Textbox txtCRCDF0013;
	@Wire
	private Textbox txtDL01F0013;
	@Wire
	private Textbox txtDECF0013;
	@Wire
	private Textbox txtCKRF0013;
	@Wire
	private Div divVF0013;
	@Wire
	private Div botoneraF0013;
	@Wire
	private Div catalogoF0013;
	@Wire
	private Groupbox gpxDatosF0013;
	@Wire
	private Groupbox gpxRegistroF0013;
	protected List<F0013> listaGeneral = new ArrayList<F0013>();

	Botonera botonera;
	CatalogoGenerico<F0013> catalogo;
	String clave = null;

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
		txtCRCDF0013.setFocus(true);
		mostrarCatalogo();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F0013 f013 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f013.getCvcrcd();
						txtCRCDF0013.setValue(f013.getCvcrcd());
						txtCRCDF0013.setDisabled(true);
						txtCKRF0013.setValue(f013.getCvckr());
						txtDECF0013.setValue(f013.getCvcdec());
						txtDL01F0013.setValue(f013.getCvdl01());
						txtCRCDF0013.setFocus(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0013, titulo , tabs);

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
				
				if (validar()) {
					F0013 f0013 = new F0013();
					f0013.setCvcdec(txtDECF0013.getValue());
					f0013.setCvckr(txtCKRF0013.getValue());
					f0013.setCvdl01(txtDL01F0013.getValue());
					f0013.setCvcrcd(txtCRCDF0013.getValue());
					f0013.setCvupmj(transformarGregorianoAJulia(fecha));
					f0013.setCvupmt(Double.valueOf(horaAuditoria));
					f0013.setCvuser("JDE");
					servicioF0013.guardar(f0013);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					listaGeneral = servicioF0013.buscarTodosOrdenados();
					catalogo.actualizarLista(listaGeneral);
				}

			}

			@Override
			public void eliminar() {
				if (gpxDatosF0013.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F0013> eliminarLista = catalogo
								.obtenerSeleccionados();
						final int cantidad = eliminarLista.size();
						for (int i = 0; i < eliminarLista.size(); i++) {
							F0013 valor = eliminarLista.get(i);
							List<F0010> objeto = servicioF0010
									.buscarPorDrdc(valor.getCvcrcd());
							List<F0015> objeto2 = servicioF0015
									.buscarCRCD(valor.getCvcrcd());
							if (!objeto.isEmpty() || !objeto2.isEmpty()) {
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
														servicioF0013
																.eliminarVarios(eliminarLista);
														listaGeneral = servicioF0013.buscarTodosOrdenados();
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
						List<F0010> objeto = servicioF0010
								.buscarPorDrdc(clave);
						List<F0015> objeto2 = servicioF0015
								.buscarCRCD(clave);
						if (objeto.isEmpty() && objeto2.isEmpty()) {
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
														servicioF0013
																.eliminarUno(clave);
														msj.mensajeInformacion(Mensaje.eliminado);
														limpiar();
														listaGeneral = servicioF0013.buscarTodosOrdenados();
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
		botoneraF0013.appendChild(botonera);
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
		txtCKRF0013.setValue("");
		txtCRCDF0013.setValue("");
		txtDECF0013.setValue("");
		txtDL01F0013.setValue("");
		catalogo.limpiarSeleccion();
		txtCRCDF0013.setFocus(true);
	}

	public void habilitarTextClave() {
		if (txtCRCDF0013.isDisabled())
			txtCRCDF0013.setDisabled(false);
	}

	public boolean validarSeleccion() {
		List<F0013> seleccionados = catalogo.obtenerSeleccionados();
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

	@Listen("onChange = #txtCRCDF0013")
	public boolean claveSYExiste() {
		if (servicioF0013.buscar(txtCRCDF0013.getValue()) != null) {
			msj.mensajeAlerta(Mensaje.claveUsada);
			txtCRCDF0013.setFocus(true);
			return true;
		} else
			return false;
	}

	public boolean camposLLenos() {
		if (txtCRCDF0013.getText().compareTo("") == 0
				|| txtDL01F0013.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtCKRF0013.getText().compareTo("") != 0
				|| txtCRCDF0013.getText().compareTo("") != 0
				|| txtDECF0013.getText().compareTo("") != 0
				|| txtDL01F0013.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	@Listen("onClick = #gpxRegistroF0013")
	public void abrirRegistro() {
		gpxDatosF0013.setOpen(false);
		gpxRegistroF0013.setOpen(true);
		mostrarBotones(false);
	}

	@Listen("onOpen = #gpxDatosF0013")
	public void abrirCatalogo() {
		gpxDatosF0013.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF0013.setOpen(false);
								gpxRegistroF0013.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF0013.setOpen(true);
									gpxRegistroF0013.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF0013.setOpen(true);
			gpxRegistroF0013.setOpen(false);
			mostrarBotones(true);
		}
	}

	public void mostrarCatalogo() {
		listaGeneral = servicioF0013.buscarTodosOrdenados();
		catalogo = new CatalogoGenerico<F0013>(catalogoF0013, "F0013", listaGeneral,
				false, false, false, "Codigo moneda", "Descripcion", "Vlslz",
				"Rutina cheques") {

			@Override
			protected List<F0013> buscar(List<String> valores) {

				List<F0013> lista = new ArrayList<F0013>();

				for (F0013 f0013 : listaGeneral) {
					if (f0013.getCvcrcd().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f0013.getCvdl01().toLowerCase()
							.contains(valores.get(1).toLowerCase())
							&& f0013.getCvcdec().toLowerCase()
							.contains(valores.get(2).toLowerCase())
							&& f0013.getCvckr().toLowerCase()
							.contains(valores.get(3).toLowerCase())) {
						lista.add(f0013);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0013 f013) {
				String[] registros = new String[4];
				registros[0] = f013.getCvcrcd();
				registros[1] = f013.getCvdl01();
				registros[2] = f013.getCvcdec();
				registros[3] = f013.getCvckr();
				return registros;
			}
		};
		catalogo.setParent(catalogoF0013);
	}
}
