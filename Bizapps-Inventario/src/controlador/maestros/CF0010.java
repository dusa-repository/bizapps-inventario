package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0004;
import modelo.maestros.F0010;
import modelo.maestros.F0013;
import modelo.pk.F0004PK;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0010 extends CGenerico {

	private static final long serialVersionUID = -3026737348271891635L;

	@Wire
	private Textbox txtCCCOF0010;
	@Wire
	private Textbox txtNameF0010;
	@Wire
	private Textbox txtPatronF0010;
	@Wire
	private Textbox txtDireccionF0010;
	@Wire
	private Textbox txtCCCRCDF0010;
	@Wire
	private Textbox txtRMF0010;
	@Wire
	private Doublespinner dpnDDFF0010;
	@Wire
	private Doublespinner dpnPeriodoGeneralF0010;
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

	Botonera botonera;
	Catalogo<F0010> catalogo;
	Catalogo<F0013> catalogoM;
	String clave = null;

	@Override
	public void inicializar() throws IOException {
		txtCCCOF0010.setFocus(true);
		mostrarCatalogo();
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
						txtNameF0010.setValue(f010.getCcname());
						txtDireccionF0010.setValue(f010.getCcaltc());
						txtPatronF0010.setValue(f010.getCcdot1());
						txtRMF0010.setValue(f010.getCcsgbk());
						dpnDDFF0010.setValue(f010.getCcdff());
						dpnPeriodoGeneralF0010.setValue(f010.getCcpnc());
						dpnPeriodoActualGeneralF0010.setValue(f010.getCctxbm());
						dpnPeriodoPagarF0010.setValue(f010.getCctxbo());
						dpnPeriodoCobrarF0010.setValue(f010.getCcpnf());
						dpnPeriodoInformeF0010.setValue(f010.getCccrdy());
						dpnAnnoInformeF0010.setValue(f010.getCcagr1());
						dtbFechaCobrarF0010.setValue(transformarJulianaAGregoria(f010.getCcdfyj()));
						dtbFechaGeneralF0010.setValue(transformarJulianaAGregoria(f010.getCcarfj()));
						dtbFechaPagarF0010.setValue(transformarJulianaAGregoria(f010.getCcapfj()));
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0010, "Empresa");
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
				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {

					F0010 f010 = new F0010();
					System.out.println("claveeee"+txtCCCOF0010.getValue());
					f010.setCcco(txtCCCOF0010.getValue());
					f010.setCccrcd(txtCCCRCDF0010.getValue());
					f010.setCcname(txtNameF0010.getValue());
					f010.setCcaltc(txtDireccionF0010.getValue());
					f010.setCcdot1(txtPatronF0010.getValue());
					f010.setCcsgbk(txtRMF0010.getValue());
					f010.setCcdff(dpnDDFF0010.getValue());
					f010.setCcpnc(dpnPeriodoGeneralF0010.getValue());
					f010.setCctxbm(dpnPeriodoActualGeneralF0010.getValue());
					f010.setCctxbo(dpnPeriodoPagarF0010.getValue());
					f010.setCcpnf(dpnPeriodoCobrarF0010.getValue());
					f010.setCccrdy(dpnPeriodoInformeF0010.getValue());
					f010.setCcagr1(dpnAnnoInformeF0010.getValue());
					f010.setCcdfyj(transformarGregorianoAJulia(dtbFechaCobrarF0010.getValue()));
					f010.setCcarfj(transformarGregorianoAJulia(dtbFechaGeneralF0010.getValue()));
					f010.setCcapfj(transformarGregorianoAJulia(dtbFechaPagarF0010.getValue()));
					f010.setCcupmj(transformarGregorianoAJulia(fecha));
					f010.setCcupmt(Double.valueOf(horaAuditoria));
					f010.setCcuser("JDE");
					servicioF0010.guardar(f010);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF0010
							.buscarTodosOrdenados());
				}
			}

			@Override
			public void eliminar() {
				if (gpxDatosF0010.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F0010> eliminarLista = catalogo
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
													servicioF0010
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF0010
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
													servicioF0010
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF0010
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
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF0010.appendChild(botonera);
	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(bol);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	public void limpiarCampos() {
		clave = null;
		txtCCCOF0010.setValue("");
		txtCCCRCDF0010.setValue("");
		txtNameF0010.setValue("");
		txtDireccionF0010.setValue("");
		txtPatronF0010.setValue("");
		txtRMF0010.setValue("");
		dpnDDFF0010.setValue((double) 0);
		dpnPeriodoGeneralF0010.setValue((double) 0);
		dpnPeriodoActualGeneralF0010.setValue((double) 0);
		dpnPeriodoPagarF0010.setValue((double) 0);
		dpnPeriodoCobrarF0010.setValue((double) 0);
		dpnPeriodoInformeF0010.setValue((double) 0);
		dpnAnnoInformeF0010.setValue((double) 0);
		dtbFechaCobrarF0010.setValue(fecha);
		dtbFechaGeneralF0010.setValue(fecha);
		dtbFechaPagarF0010.setValue(fecha);
		txtCCCOF0010.setFocus(true);
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
				msj.mensajeAlerta(Mensaje.camposVacios);
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
				|| txtCCCRCDF0010.getText().compareTo("") == 0
				|| txtDireccionF0010.getText().compareTo("") == 0
				|| txtNameF0010.getText().compareTo("") == 0
				|| txtPatronF0010.getText().compareTo("") == 0
				|| txtRMF0010.getText().compareTo("") == 0
				|| dpnAnnoInformeF0010.getValue() == 0
				|| dpnDDFF0010.getValue() == 0
				|| dpnPeriodoActualGeneralF0010.getValue() == 0
				|| dpnPeriodoCobrarF0010.getValue() == 0
				|| dpnPeriodoGeneralF0010.getValue() == 0
				|| dpnPeriodoInformeF0010.getValue() == 0
				|| dpnPeriodoPagarF0010.getValue() == 0
				|| dtbFechaCobrarF0010.getText().compareTo("") == 0
				|| dtbFechaGeneralF0010.getText().compareTo("") == 0
				|| dtbFechaPagarF0010.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtCCCOF0010.getText().compareTo("") != 0
				|| txtCCCRCDF0010.getText().compareTo("") != 0
				|| txtDireccionF0010.getText().compareTo("") != 0
				|| txtNameF0010.getText().compareTo("") != 0
				|| txtPatronF0010.getText().compareTo("") != 0
				|| txtRMF0010.getText().compareTo("") != 0
				|| dpnAnnoInformeF0010.getValue() != 0
				|| dpnDDFF0010.getValue() != 0
				|| dpnPeriodoActualGeneralF0010.getValue() != 0
				|| dpnPeriodoCobrarF0010.getValue() != 0
				|| dpnPeriodoGeneralF0010.getValue() != 0
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
		final List<F0010> lista = servicioF0010.buscarTodosOrdenados();
		catalogo = new Catalogo<F0010>(catalogoF0010, "F0010", lista, "Codigo",
				"Nombre", "Nº Periodo", "Patron", "Inicio año Fiscal",
				"Periodo LM", "Inicio año C/P", "Periodo C/P",
				"Inicio año C/C", "Periodo C/C") {

			@Override
			protected List<F0010> buscar(List<String> valores) {

				List<F0010> lista2 = new ArrayList<F0010>();

				for (F0010 f0010 : lista) {
					if (f0010.getCcco().toLowerCase()
							.startsWith(valores.get(0))
							&& f0010.getCcname().toLowerCase()
									.startsWith(valores.get(1))
							&& String.valueOf(f0010.getCcpnc()).toLowerCase()
									.startsWith(valores.get(2))
							&& f0010.getCcdot1().toLowerCase()
									.startsWith(valores.get(3))
							&& f0010.getCcarfj().toString().toLowerCase()
									.startsWith(valores.get(4))
							&& String.valueOf(f0010.getCctxbm()).toLowerCase()
									.startsWith(valores.get(5))
							&& f0010.getCcapfj().toString().toLowerCase()
									.startsWith(valores.get(6))
							&& String.valueOf(f0010.getCctxbo()).toLowerCase()
									.startsWith(valores.get(7))
							&& f0010.getCcdfyj().toString().toLowerCase()
									.startsWith(valores.get(8))
							&& String.valueOf(f0010.getCcpnf()).toLowerCase()
									.startsWith(valores.get(9))) {
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
		catalogo.setParent(catalogoF0010);
	}

	@Listen("onClick = #btnBuscarMoneda")
	public void mostrarCatalogoMoneda() throws IOException {
		final List<F0013> listF0013 = servicioF0013.buscarTodosOrdenados();
		catalogoM = new Catalogo<F0013>(catalogoMonedaF0010, "F0013", listF0013, "Codigo",
				"Descripcion", "Vlslz", "Rutina Cheques") {

			@Override
			protected List<F0013> buscar(List<String> valores) {

				List<F0013> lista = new ArrayList<F0013>();

				for (F0013 f0013 : listF0013) {
					if (f0013.getCvcrcd().toLowerCase()
							.startsWith(valores.get(0))
							&& f0013.getCvdl01().toLowerCase()
									.startsWith(valores.get(1))
							&& f0013.getCvcdec().toLowerCase()
									.startsWith(valores.get(2))
							&& f0013.getCvec().toLowerCase()
									.startsWith(valores.get(3))) {
						lista.add(f0013);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0013 f0013) {
				String[] registros = new String[4];
				registros[0] = f0013.getCvdl01();
				registros[1] = f0013.getCvdl01();
				registros[2] = f0013.getCvcdec();
				registros[3] = f0013.getCvec();
				return registros;
			}
		};
		catalogoM.setParent(catalogoMonedaF0010);
		catalogoM.doModal();
	}

	@Listen("onSeleccion = #catalogoMonedaF0010")
	public void seleccion() {
		F0013 f0013 = catalogoM.objetoSeleccionadoDelCatalogo();
		txtCCCRCDF0010.setValue(f0013.getCvcrcd());
		catalogoM.setParent(null);
	}
	
	@Listen("onChange = #txtCCCRCDF0010")
	public void buscarNombre(){
		F0013 f0013 = servicioF0013.buscar(txtCCCRCDF0010.getValue());
		if(f0013!=null)
			txtCCCRCDF0010.setValue(f0013.getCvcrcd());
		else{
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtCCCRCDF0010.setValue("");
			txtCCCRCDF0010.setFocus(true);
		}
	}
}
