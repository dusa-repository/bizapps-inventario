package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import modelo.maestros.F0005;
import modelo.maestros.F0013;
import modelo.maestros.F0101;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0101 extends CGenerico {

	@Wire
	private Textbox txtAN8F0101;
	@Wire
	private Textbox txtALPHF0101;
	@Wire
	private Textbox txtALKYF0101;
	@Wire
	private Textbox txtTAXF0101;
	@Wire
	private Div divBuscadorAT1;
	BuscadorUDC buscadorAT1;
	@Wire
	private Textbox txtMCUF0101;
	@Wire
	private Button btnBuscarUnidades;
	@Wire
	private Label lblMCUF0101;
	@Wire
	private Div divBuscadorATP;
	BuscadorUDC buscadorATP;
	@Wire
	private Checkbox chxATRF0101;
	@Wire
	private Div divBuscadorMPGP;
	BuscadorUDC buscadorMPGP;
	@Wire
	private Checkbox chxATPRF0101;
	@Wire
	private Div divBuscadorAT2;
	BuscadorUDC buscadorAT2;
	@Wire
	private Checkbox chxSBLIF0101;
	@Wire
	private Textbox txtTX2F0101;
	@Wire
	private Checkbox chxATEF0101;
	@Wire
	private Textbox txtTXCTF0101;
	@Wire
	private Checkbox chx654F0101;
	@Wire
	private Div divBuscadorTAXC;
	BuscadorUDC buscadorTAXC;
	@Wire
	private Div divBuscadorCM;
	BuscadorUDC buscadorCM;
	@Wire
	private Div divBuscadorLNGP;
	BuscadorUDC buscadorLNGP;
	@Wire
	private Div divBuscadorSIC;
	BuscadorUDC buscadorSIC;
	@Wire
	private Textbox txtDUNS1F0101;
	@Wire
	private Textbox txtDUNS2F0101;
	@Wire
	private Textbox txtDUNS3F0101;
	@Wire
	private Div divVF0101;
	@Wire
	private Div botoneraF0101;
	@Wire
	private Div catalogoF0101;
	@Wire
	private Groupbox gpxDatosF0101;
	@Wire
	private Groupbox gpxRegistroF0101;
	Botonera botonera;
	Catalogo<F0101> catalogo;
	long clave = 0;

	private static final long serialVersionUID = -423722886120387655L;

	@Override
	public void inicializar() throws IOException {
		List<F0005> listF0005 = servicioF0005.buscarTodosOrdenados();

		mostrarCatalogo();
//		Ajustar a 3 el long
		buscadorAT1 = new BuscadorUDC("Tipo busqueda", 10, listF0005, true) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAT1.obtenerCaja());
			}
		};
		divBuscadorAT1.appendChild(buscadorAT1);

		buscadorAT2 = new BuscadorUDC("Compen c/c y c/p", 1, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAT2.obtenerCaja());
			}
		};
		divBuscadorAT2.appendChild(buscadorAT2);

		buscadorATP = new BuscadorUDC("Cuentas por Pagar Y/N/M", 1, listF0005,
				false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorATP.obtenerCaja());
			}
		};
		divBuscadorATP.appendChild(buscadorATP);

		buscadorCM = new BuscadorUDC("Mensaje credito", 2, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorCM.obtenerCaja());
			}
		};
		divBuscadorCM.appendChild(buscadorCM);

		buscadorLNGP = new BuscadorUDC("Idioma", 2, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorLNGP.obtenerCaja());
			}
		};
		divBuscadorLNGP.appendChild(buscadorLNGP);

		buscadorMPGP = new BuscadorUDC("Aprobaciones Grupo Empl", 5, listF0005,
				false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorMPGP.obtenerCaja());
			}
		};
		divBuscadorMPGP.appendChild(buscadorMPGP);

		buscadorSIC = new BuscadorUDC("Clasificacion industrial", 10,
				listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorSIC.obtenerCaja());
			}
		};
		divBuscadorSIC.appendChild(buscadorSIC);

		buscadorTAXC = new BuscadorUDC("Cd persona/compañia", 1, listF0005,
				false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorTAXC.obtenerCaja());
			}
		};
		divBuscadorTAXC.appendChild(buscadorTAXC);

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F0101 f01 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f01.getAban8();
						txtALPHF0101.setFocus(true);
						txtALKYF0101.setValue(f01.getAbalky());
						txtALPHF0101.setValue(f01.getAbalph());
						txtAN8F0101.setValue(String.valueOf(f01.getAban8()));
						String a = f01.getAbduns();
//						txtDUNS1F0101.setValue(f01.getAbduns().substring(0, 4));
//						txtDUNS2F0101.setValue(f01.getAbduns().substring(4, 8));
//						txtDUNS3F0101
//								.setValue(f01.getAbduns().substring(8, 13));
						txtMCUF0101.setValue(f01.getAbmcu());
						txtTAXF0101.setValue(f01.getAbtax());
						txtTX2F0101.setValue(f01.getAbtx2());
						txtTXCTF0101.setValue(f01.getAbtxct());
						// Se supone que aqui se pasaran los parametros que
						// definiremos luego sy, rt, ky
						buscadorAT1.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbat1()));
						buscadorAT2.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbat2()));
						buscadorATP.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbatp()));
						buscadorCM.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbcm()));
						buscadorLNGP.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAblngp()));
						buscadorMPGP.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbaempgp()));
						buscadorSIC.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbsic()));
						buscadorTAXC.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbtax()));
						if (f01.getAbate().equals("1"))
							chxATEF0101.setChecked(true);
						else
							chxATEF0101.setChecked(false);
						if (f01.getAbatpr().equals("1"))
							chxATPRF0101.setChecked(true);
						else
							chxATPRF0101.setChecked(false);
						if (f01.getAbatr().equals("1"))
							chxATRF0101.setChecked(true);
						else
							chxATRF0101.setChecked(false);
						if (f01.getAbsbli().equals("1"))
							chxSBLIF0101.setChecked(true);
						else
							chxSBLIF0101.setChecked(false);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0101, "Direccion");

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
				clave = 0;
			}

			@Override
			public void guardar() {
				boolean guardar = true;
				if (clave == 0)
					guardar = validar();
				if (guardar) {
					F0101 f01 = new F0101();
					f01.setAban8(clave);
					f01.setAbalky(txtALKYF0101.getValue());
					f01.setAbalph(txtALPHF0101.getValue());
					f01.setAbduns(txtDUNS1F0101.getValue()
							+ txtDUNS2F0101.getValue()
							+ txtDUNS3F0101.getValue());
					f01.setAbmcu(txtMCUF0101.getValue());
					f01.setAbtax(txtTAXF0101.getValue());
					f01.setAbtx2(txtTX2F0101.getValue());
					f01.setAbtxct(txtTXCTF0101.getValue());
					f01.setAbat1(buscadorAT1.obtenerCaja());
					f01.setAbat2(buscadorAT2.obtenerCaja());
					f01.setAbatp(buscadorATP.obtenerCaja());
					f01.setAbcm(buscadorCM.obtenerCaja());
					f01.setAblngp(buscadorLNGP.obtenerCaja());
					f01.setAbaempgp(buscadorMPGP.obtenerCaja());
					f01.setAbsic(buscadorSIC.obtenerCaja());
					f01.setAbtax(buscadorTAXC.obtenerCaja());
					if (chxATEF0101.isChecked())
						f01.setAbate("1");
					else
						f01.setAbate("0");
					if (chxATPRF0101.isChecked())
						f01.setAbatpr("1");
					else
						f01.setAbatpr("0");
					if (chxATRF0101.isChecked())
						f01.setAbatr("1");
					else
						f01.setAbatr("0");
					if (chxSBLIF0101.isChecked())
						f01.setAbsbli("1");
					else
						f01.setAbsbli("0");
					servicioF0101.guardar(f01);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF0101
							.buscarTodosOrdenados());
				}
			}

			@Override
			public void eliminar() {

				if (gpxDatosF0101.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F0101> eliminarLista = catalogo
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
													servicioF0101
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF0101
															.buscarTodosOrdenados());
												}
											}
										});
					}
				} else {
					/* Elimina un solo registro */
					if (clave != 0) {
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
													servicioF0101
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF0101
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
		botoneraF0101.appendChild(botonera);
	}

	protected boolean validar() {
		if (!camposLLenos()) {
			msj.mensajeAlerta(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	private boolean camposLLenos() {
		if (txtALPHF0101.getText().compareTo("") == 0
				|| buscadorAT1.obtenerCaja().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	protected void limpiarCampos() {
		clave = 0;
		txtALPHF0101.setFocus(true);
		txtALKYF0101.setValue("");
		txtALPHF0101.setValue("");
		txtAN8F0101.setValue("");
		txtDUNS1F0101.setValue("");
		txtDUNS2F0101.setValue("");
		txtDUNS3F0101.setValue("");
		txtMCUF0101.setValue("");
		txtTAXF0101.setValue("");
		txtTX2F0101.setValue("");
		txtTXCTF0101.setValue("");
		buscadorAT1.settearCampo(null);
		buscadorAT2.settearCampo(null);
		buscadorATP.settearCampo(null);
		buscadorCM.settearCampo(null);
		buscadorLNGP.settearCampo(null);
		buscadorMPGP.settearCampo(null);
		buscadorSIC.settearCampo(null);
		buscadorTAXC.settearCampo(null);
		chxATEF0101.setChecked(false);
		chxATPRF0101.setChecked(false);
		chxATRF0101.setChecked(false);
		chxSBLIF0101.setChecked(false);
	}

	@Listen("onClick = #gpxRegistroF0101")
	public void abrirRegistro() {
		gpxDatosF0101.setOpen(false);
		gpxRegistroF0101.setOpen(true);
		mostrarBotones(false);
	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(bol);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	protected boolean validarSeleccion() {
		List<F0101> seleccionados = catalogo.obtenerSeleccionados();
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

	@Listen("onOpen = #gpxDatosF0101")
	public void abrirCatalogo() {
		gpxDatosF0101.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF0101.setOpen(false);
								gpxRegistroF0101.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF0101.setOpen(true);
									gpxRegistroF0101.setOpen(false);
									limpiarCampos();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF0101.setOpen(true);
			gpxRegistroF0101.setOpen(false);
			mostrarBotones(true);
		}
	}

	private boolean camposEditando() {
		// TODO Auto-generated method stub
		return false;
	}

	public void mostrarCatalogo() {
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogo = new Catalogo<F0101>(catalogoF0101, "F0013", listF0101,
				"Nº direccion", "Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal") {

			@Override
			protected List<F0101> buscar(List<String> valores) {

				List<F0101> lista = new ArrayList<F0101>();

				for (F0101 f01 : listF0101) {
					if (String.valueOf(f01.getAban8()).toLowerCase()
							.startsWith(valores.get(0))
							&& f01.getAbalph().toLowerCase()
									.startsWith(valores.get(1))
							&& f01.getAbalky().toLowerCase()
									.startsWith(valores.get(2))
							&& f01.getAbsic().toLowerCase()
									.startsWith(valores.get(4))
							&& f01.getAbat1().toLowerCase()
									.startsWith(valores.get(5))
							&& f01.getAbtax().toLowerCase()
									.startsWith(valores.get(6))) {
						lista.add(f01);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0101 f013) {
				String[] registros = new String[6];
				registros[0] = String.valueOf(f013.getAban8());
				registros[1] = f013.getAbalph();
				registros[2] = f013.getAbalky();
				registros[3] = f013.getAbsic();
				registros[4] = f013.getAbat1();
				registros[5] = f013.getAbtax();
				return registros;
			}
		};
		catalogo.setParent(catalogoF0101);
	}

}
