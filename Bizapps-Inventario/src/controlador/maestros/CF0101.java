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

import modelo.maestros.F0004;
import modelo.maestros.F0005;
import modelo.maestros.F0006;
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
	private Div divBuscadorAC01;
	BuscadorUDC buscadorAC01;
	@Wire
	private Div divBuscadorAC02;
	BuscadorUDC buscadorAC02;
	@Wire
	private Div divBuscadorAC03;
	BuscadorUDC buscadorAC03;
	@Wire
	private Div divBuscadorAC04;
	BuscadorUDC buscadorAC04;
	@Wire
	private Div divBuscadorAC05;
	BuscadorUDC buscadorAC05;
	@Wire
	private Div divBuscadorAC06;
	BuscadorUDC buscadorAC06;
	@Wire
	private Div divBuscadorAC07;
	BuscadorUDC buscadorAC07;
	@Wire
	private Div divBuscadorAC08;
	BuscadorUDC buscadorAC08;
	@Wire
	private Div divBuscadorAC09;
	BuscadorUDC buscadorAC09;
	@Wire
	private Div divBuscadorAC10;
	BuscadorUDC buscadorAC10;
	@Wire
	private Div divBuscadorAC11;
	BuscadorUDC buscadorAC11;
	@Wire
	private Div divBuscadorAC12;
	BuscadorUDC buscadorAC12;
	@Wire
	private Div divBuscadorAC13;
	BuscadorUDC buscadorAC13;
	@Wire
	private Div divBuscadorAC14;
	BuscadorUDC buscadorAC14;
	@Wire
	private Div divBuscadorAC15;
	BuscadorUDC buscadorAC15;
	@Wire
	private Div divBuscadorAC16;
	BuscadorUDC buscadorAC16;
	@Wire
	private Div divBuscadorAC17;
	BuscadorUDC buscadorAC17;
	@Wire
	private Div divBuscadorAC18;
	BuscadorUDC buscadorAC18;
	@Wire
	private Div divBuscadorAC19;
	BuscadorUDC buscadorAC19;
	@Wire
	private Div divBuscadorAC20;
	BuscadorUDC buscadorAC20;
	@Wire
	private Div divBuscadorAC21;
	BuscadorUDC buscadorAC21;
	@Wire
	private Div divBuscadorAC22;
	BuscadorUDC buscadorAC22;
	@Wire
	private Div divBuscadorAC23;
	BuscadorUDC buscadorAC23;
	@Wire
	private Div divBuscadorAC24;
	BuscadorUDC buscadorAC24;
	@Wire
	private Div divBuscadorAC25;
	BuscadorUDC buscadorAC25;
	@Wire
	private Div divBuscadorAC26;
	BuscadorUDC buscadorAC26;
	@Wire
	private Div divBuscadorAC27;
	BuscadorUDC buscadorAC27;
	@Wire
	private Div divBuscadorAC28;
	BuscadorUDC buscadorAC28;
	@Wire
	private Div divBuscadorAC29;
	BuscadorUDC buscadorAC29;
	@Wire
	private Div divBuscadorAC30;
	BuscadorUDC buscadorAC30;
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
	@Wire
	private Div catalogoF0006F0101;
	Botonera botonera;
	Catalogo<F0101> catalogo;
	Catalogo<F0006> catalogoF0006;
	long clave = 0;

	private static final long serialVersionUID = -423722886120387655L;

	@Override
	public void inicializar() throws IOException {

		mostrarCatalogo();
		// Ajustar a 3 el long
		cargarBuscadores();

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
						a = a.trim();
						if (a.length() <= 3) {
							txtDUNS1F0101.setValue(f01.getAbduns().trim());
						} else {
							txtDUNS1F0101.setValue(f01.getAbduns().trim()
									.substring(0, 3));
							if (a.length() > 3 && a.length() <= 7) {
								txtDUNS2F0101.setValue(f01.getAbduns().trim()
										.substring(3, a.length()));
							} else {
								txtDUNS2F0101.setValue(f01.getAbduns().trim()
										.substring(3, 7));
								txtDUNS3F0101.setValue(f01.getAbduns().trim()
										.substring(7));
							}
						}
						// txtDUNS1F0101.setValue(f01.getAbduns().substring(0,
						// 4));
						// txtDUNS2F0101.setValue(f01.getAbduns().substring(4,
						// 8));
						// txtDUNS3F0101
						// .setValue(f01.getAbduns().substring(8, 13));
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
						buscadorAC01.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac01()));
						buscadorAC02.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac02()));
						buscadorAC03.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac03()));
						buscadorAC04.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac04()));
						buscadorAC05.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac05()));
						buscadorAC06.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac06()));
						buscadorAC07.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac07()));
						buscadorAC08.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac08()));
						buscadorAC09.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac09()));
						buscadorAC10.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac10()));
						buscadorAC11.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac11()));
						buscadorAC12.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac12()));
						buscadorAC13.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac13()));
						buscadorAC14.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac14()));
						buscadorAC15.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac15()));
						buscadorAC16.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac16()));
						buscadorAC17.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac17()));
						buscadorAC18.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac18()));
						buscadorAC19.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac19()));
						buscadorAC20.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac20()));
						buscadorAC21.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac21()));
						buscadorAC22.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac22()));
						buscadorAC23.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac23()));
						buscadorAC24.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac24()));
						buscadorAC25.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac25()));
						buscadorAC26.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac26()));
						buscadorAC27.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac27()));
						buscadorAC28.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac28()));
						buscadorAC29.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac29()));
						buscadorAC30.settearCampo(servicioF0005.buscar("00",
								"01", f01.getAbac30()));
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
					f01.setAbac01(buscadorAC01.obtenerCaja());
					f01.setAbac02(buscadorAC02.obtenerCaja());
					f01.setAbac03(buscadorAC03.obtenerCaja());
					f01.setAbac04(buscadorAC04.obtenerCaja());
					f01.setAbac05(buscadorAC05.obtenerCaja());
					f01.setAbac06(buscadorAC06.obtenerCaja());
					f01.setAbac07(buscadorAC07.obtenerCaja());
					f01.setAbac08(buscadorAC08.obtenerCaja());
					f01.setAbac09(buscadorAC09.obtenerCaja());
					f01.setAbac10(buscadorAC10.obtenerCaja());
					f01.setAbac11(buscadorAC11.obtenerCaja());
					f01.setAbac12(buscadorAC12.obtenerCaja());
					f01.setAbac13(buscadorAC13.obtenerCaja());
					f01.setAbac14(buscadorAC14.obtenerCaja());
					f01.setAbac15(buscadorAC15.obtenerCaja());
					f01.setAbac16(buscadorAC16.obtenerCaja());
					f01.setAbac17(buscadorAC17.obtenerCaja());
					f01.setAbac18(buscadorAC18.obtenerCaja());
					f01.setAbac19(buscadorAC19.obtenerCaja());
					f01.setAbac20(buscadorAC20.obtenerCaja());
					f01.setAbac21(buscadorAC21.obtenerCaja());
					f01.setAbac22(buscadorAC22.obtenerCaja());
					f01.setAbac23(buscadorAC23.obtenerCaja());
					f01.setAbac24(buscadorAC24.obtenerCaja());
					f01.setAbac25(buscadorAC25.obtenerCaja());
					f01.setAbac26(buscadorAC26.obtenerCaja());
					f01.setAbac27(buscadorAC27.obtenerCaja());
					f01.setAbac28(buscadorAC28.obtenerCaja());
					f01.setAbac29(buscadorAC29.obtenerCaja());
					f01.setAbac30(buscadorAC30.obtenerCaja());
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

	@Listen("onClick = #btnBuscarUnidades")
	public void mostrarCatalogoF0004() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoF0006 = new Catalogo<F0006>(catalogoF0006F0101, "F0006",
				unidades, "Unidad Negocio", "Descripcion", "Nivel det", "Cta",
				"Tipo UN", "LM Auxiliar Inactivo", "Mto Cons", "CAT 01",
				"CAT 02", "CAT 03", "CAT 04", "CAT 05", "CAT 06") {

			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					if (unidad.getMcmcu().toLowerCase()
							.startsWith(valores.get(0))
							&& unidad.getMcdc().toLowerCase()
									.startsWith(valores.get(1))
							&& unidad.getMcldm().toLowerCase()
									.startsWith(valores.get(2))
							&& unidad.getMcco().toLowerCase()
									.startsWith(valores.get(3))
							&& unidad.getMcstyl().toLowerCase()
									.startsWith(valores.get(4))
							&& unidad.getMcfmod().toLowerCase()
									.startsWith(valores.get(5))
							&& unidad.getMcsbli().toLowerCase()
									.startsWith(valores.get(6))
							&& unidad.getMcrp01().toLowerCase()
									.startsWith(valores.get(7))
							&& unidad.getMcrp02().toLowerCase()
									.startsWith(valores.get(8))
							&& unidad.getMcrp03().toLowerCase()
									.startsWith(valores.get(9))
							&& unidad.getMcrp04().toLowerCase()
									.startsWith(valores.get(10))
							&& unidad.getMcrp05().toLowerCase()
									.startsWith(valores.get(11))
							&& unidad.getMcrp06().toLowerCase()
									.startsWith(valores.get(12))) {
						unidadnegocio.add(unidad);
					}
				}
				return unidadnegocio;
			}

			@Override
			protected String[] crearRegistros(F0006 negocio) {
				String[] registros = new String[13];
				registros[0] = negocio.getMcmcu();
				registros[1] = negocio.getMcdc();
				registros[2] = negocio.getMcldm();
				registros[3] = negocio.getMcco();
				registros[4] = negocio.getMcstyl();
				registros[5] = negocio.getMcfmod();
				registros[6] = negocio.getMcsbli();
				registros[7] = negocio.getMcrp01();
				registros[8] = negocio.getMcrp02();
				registros[9] = negocio.getMcrp03();
				registros[10] = negocio.getMcrp04();
				registros[11] = negocio.getMcrp05();
				registros[12] = negocio.getMcrp06();
				return registros;
			}
		};
		catalogoF0006.setClosable(true);
		catalogoF0006.setWidth("80%");
		catalogoF0006.setTitle("Registros");
		catalogoF0006.setParent(catalogoF0006F0101);
		catalogoF0006.doModal();
	}

	@Listen("onSeleccion = #catalogoF0006F0101")
	public void seleccion() {
		System.out.println("aqui");
		F0006 f0006 = catalogoF0006.objetoSeleccionadoDelCatalogo();
		txtMCUF0101.setValue(f0006.getMcmcu());
		lblMCUF0101.setValue(f0006.getMcdl01());
		catalogoF0006.setParent(null);
	}

	private void cargarBuscadores() {

		List<F0005> listF0005 = servicioF0005.buscarTodosOrdenados();
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

		buscadorAC01 = new BuscadorUDC("Cd Categoria 1", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC01.obtenerCaja());
			}
		};
		divBuscadorAC01.appendChild(buscadorAC01);

		buscadorAC02 = new BuscadorUDC("Cd Categoria 02", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC02.obtenerCaja());
			}
		};
		divBuscadorAC02.appendChild(buscadorAC02);

		buscadorAC03 = new BuscadorUDC("Cd Categoria 03", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC03.obtenerCaja());
			}
		};
		divBuscadorAC03.appendChild(buscadorAC03);

		buscadorAC04 = new BuscadorUDC("Cd Categoria 04", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC04.obtenerCaja());
			}
		};
		divBuscadorAC04.appendChild(buscadorAC04);

		buscadorAC05 = new BuscadorUDC("Cd Categoria 05", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC05.obtenerCaja());
			}
		};
		divBuscadorAC05.appendChild(buscadorAC05);

		buscadorAC06 = new BuscadorUDC("Cd Categoria 06", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC06.obtenerCaja());
			}
		};
		divBuscadorAC06.appendChild(buscadorAC06);

		buscadorAC07 = new BuscadorUDC("Cd Categoria 07", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC07.obtenerCaja());
			}
		};
		divBuscadorAC07.appendChild(buscadorAC07);

		buscadorAC08 = new BuscadorUDC("Cd Categoria 08", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC08.obtenerCaja());
			}
		};
		divBuscadorAC08.appendChild(buscadorAC08);

		buscadorAC09 = new BuscadorUDC("Cd Categoria 09", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC09.obtenerCaja());
			}
		};
		divBuscadorAC09.appendChild(buscadorAC09);

		buscadorAC10 = new BuscadorUDC("Cd Categoria 10", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC10.obtenerCaja());
			}
		};
		divBuscadorAC10.appendChild(buscadorAC10);

		buscadorAC11 = new BuscadorUDC("Cd Categoria 11", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC11.obtenerCaja());
			}
		};
		divBuscadorAC11.appendChild(buscadorAC11);

		buscadorAC12 = new BuscadorUDC("Cd Categoria 12", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC12.obtenerCaja());
			}
		};
		divBuscadorAC12.appendChild(buscadorAC12);

		buscadorAC13 = new BuscadorUDC("Cd Categoria 13", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC13.obtenerCaja());
			}
		};
		divBuscadorAC13.appendChild(buscadorAC13);

		buscadorAC14 = new BuscadorUDC("Cd Categoria 14", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC14.obtenerCaja());
			}
		};
		divBuscadorAC14.appendChild(buscadorAC14);

		buscadorAC15 = new BuscadorUDC("Cd Categoria 15", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC15.obtenerCaja());
			}
		};
		divBuscadorAC15.appendChild(buscadorAC15);

		buscadorAC16 = new BuscadorUDC("Cd Categoria 16", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC16.obtenerCaja());
			}
		};
		divBuscadorAC16.appendChild(buscadorAC16);

		buscadorAC17 = new BuscadorUDC("Cd Categoria 17", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC17.obtenerCaja());
			}
		};
		divBuscadorAC17.appendChild(buscadorAC17);

		buscadorAC18 = new BuscadorUDC("Cd Categoria 18", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC18.obtenerCaja());
			}
		};
		divBuscadorAC18.appendChild(buscadorAC18);

		buscadorAC19 = new BuscadorUDC("Cd Categoria 19", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC19.obtenerCaja());
			}
		};
		divBuscadorAC19.appendChild(buscadorAC19);

		buscadorAC20 = new BuscadorUDC("Cd Categoria 20", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC20.obtenerCaja());
			}
		};
		divBuscadorAC20.appendChild(buscadorAC20);

		buscadorAC21 = new BuscadorUDC("Cd Categoria 21", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC21.obtenerCaja());
			}
		};
		divBuscadorAC21.appendChild(buscadorAC21);

		buscadorAC22 = new BuscadorUDC("Cd Categoria 22", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC22.obtenerCaja());
			}
		};
		divBuscadorAC22.appendChild(buscadorAC22);

		buscadorAC23 = new BuscadorUDC("Cd Categoria 23", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC23.obtenerCaja());
			}
		};
		divBuscadorAC23.appendChild(buscadorAC23);

		buscadorAC24 = new BuscadorUDC("Cd Categoria 24", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC24.obtenerCaja());
			}
		};
		divBuscadorAC24.appendChild(buscadorAC24);

		buscadorAC25 = new BuscadorUDC("Cd Categoria 25", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC25.obtenerCaja());
			}
		};
		divBuscadorAC25.appendChild(buscadorAC25);

		buscadorAC26 = new BuscadorUDC("Cd Categoria 26", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC26.obtenerCaja());
			}
		};
		divBuscadorAC26.appendChild(buscadorAC26);

		buscadorAC27 = new BuscadorUDC("Cd Categoria 27", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC27.obtenerCaja());
			}
		};
		divBuscadorAC27.appendChild(buscadorAC27);

		buscadorAC28 = new BuscadorUDC("Cd Categoria 28", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC28.obtenerCaja());
			}
		};
		divBuscadorAC28.appendChild(buscadorAC28);

		buscadorAC29 = new BuscadorUDC("Cd Categoria 29", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC29.obtenerCaja());
			}
		};
		divBuscadorAC29.appendChild(buscadorAC29);

		buscadorAC30 = new BuscadorUDC("Cd Categoria 30", 3, listF0005, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAC30.obtenerCaja());
			}
		};
		divBuscadorAC30.appendChild(buscadorAC30);
	}

}
