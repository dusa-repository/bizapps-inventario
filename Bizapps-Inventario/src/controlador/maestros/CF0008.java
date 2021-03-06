package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0008;
import modelo.pk.F0008PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.buscadores.BuscadorUDC;
import componentes.catalogos.CatalogoGenerico;

public class CF0008 extends CGenerico {

	@Wire
	private Div divVF0008;
	@Wire
	private Div botoneraF0008;
	@Wire
	private Groupbox gpxRegistroF0008;
	@Wire
	private Div divbuscadorDPNT;
	@Wire
	private Datebox dtbDFYJF0008;
	@Wire
	private Datebox dtbD01JF0008;
	@Wire
	private Datebox dtbD02JF0008;
	@Wire
	private Datebox dtbD03JF0008;
	@Wire
	private Datebox dtbD04JF0008;
	@Wire
	private Datebox dtbD05JF0008;
	@Wire
	private Datebox dtbD06JF0008;
	@Wire
	private Datebox dtbD07JF0008;
	@Wire
	private Datebox dtbD08JF0008;
	@Wire
	private Datebox dtbD09JF0008;
	@Wire
	private Datebox dtbD10JF0008;
	@Wire
	private Datebox dtbD11JF0008;
	@Wire
	private Datebox dtbD12JF0008;
	@Wire
	private Datebox dtbD13JF0008;
	@Wire
	private Datebox dtbD14JF0008;
	@Wire
	private Groupbox gpxDatosF0008;
	@Wire
	private Div catalogoF0008;
	protected List<F0008> listaGeneral = new ArrayList<F0008>();
	private static SimpleDateFormat formatoFecha = new SimpleDateFormat(
			"dd-MM-yyyy");

	Botonera botonera;
	CatalogoGenerico<F0008> catalogo;
	F0008PK clave = null;

	BuscadorUDC buscadorDPNT;

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
		mostrarCatalogo();

		List<F0005> listF0005 = servicioF0005.buscarTodosOrdenados();
		List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("H00",
				"DP");
		buscadorDPNT = new BuscadorUDC("Patron fecha fiscal", 255,
				true,"H00", "DP", servicioF0005, "25%", "5%", "7%", "37%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H00", "DP",
						buscadorDPNT.obtenerCaja());
			}
		};
		divbuscadorDPNT.appendChild(buscadorDPNT);
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F0008 f08 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f08.getId();
						// Se supone que aqui se pasaran los parametros que
						// definiremos luego sy, rt, ky
						buscadorDPNT.settearModelo(servicioF0005.buscar("H00",
								"DP", f08.getId().getCddtpn()));
						buscadorDPNT.inhabilitarCampo();
						dtbDFYJF0008
								.setValue((transformarJulianaAGregoria(BigDecimal
										.valueOf(f08.getId().getCddfyj()))));
						dtbD01JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd01j()));
						dtbD02JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd02j()));
						dtbD03JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd03j()));
						dtbD04JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd04j()));
						dtbD05JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd05j()));
						dtbD06JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd06j()));
						dtbD07JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd07j()));
						dtbD08JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd08j()));
						dtbD09JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd09j()));
						dtbD10JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd10j()));
						dtbD11JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd11j()));
						dtbD12JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd12j()));
						dtbD13JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd13j()));
						dtbD14JF0008.setValue(transformarJulianaAGregoria(f08
								.getCdd14j()));
						dtbD01JF0008.setFocus(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}

			}

			@Override
			public void buscar() {
				// TODO Auto-generated method stub

				abrirCatalogo();

			}

			@Override
			public void annadir() {
				// TODO Auto-generated method stub
				abrirRegistro();
				mostrarBotones(false);

			}

			@Override
			public void guardar() {
				// TODO Auto-generated method stub
			
				if (validar()) {

					if (validarFechas()) {

						long dfyj = Long
								.valueOf((String
										.valueOf(transformarGregorianoAJulia(dtbDFYJF0008
												.getValue()))));
						String cdfq = "";
						BigDecimal d01j = transformarGregorianoAJulia(dtbD01JF0008
								.getValue());
						BigDecimal d02j = transformarGregorianoAJulia(dtbD02JF0008
								.getValue());
						BigDecimal d03j = transformarGregorianoAJulia(dtbD03JF0008
								.getValue());
						BigDecimal d04j = transformarGregorianoAJulia(dtbD04JF0008
								.getValue());
						BigDecimal d05j = transformarGregorianoAJulia(dtbD05JF0008
								.getValue());
						BigDecimal d06j = transformarGregorianoAJulia(dtbD06JF0008
								.getValue());
						BigDecimal d07j = transformarGregorianoAJulia(dtbD07JF0008
								.getValue());
						BigDecimal d08j = transformarGregorianoAJulia(dtbD08JF0008
								.getValue());
						BigDecimal d09j = transformarGregorianoAJulia(dtbD09JF0008
								.getValue());
						BigDecimal d10j = transformarGregorianoAJulia(dtbD10JF0008
								.getValue());
						BigDecimal d11j = transformarGregorianoAJulia(dtbD11JF0008
								.getValue());
						BigDecimal d12j = transformarGregorianoAJulia(dtbD12JF0008
								.getValue());
						BigDecimal d13j = transformarGregorianoAJulia(dtbD13JF0008
								.getValue());
						BigDecimal d14j = transformarGregorianoAJulia(dtbD14JF0008
								.getValue());

						F0008PK clave = new F0008PK();
						clave.setCddtpn(buscadorDPNT.obtenerCaja());
						clave.setCddfyj(dfyj);
						clave.setCdfq(cdfq);
						F0008 fooo8 = new F0008();
						fooo8.setId(clave);
						fooo8.setCdd01j(d01j);
						fooo8.setCdd02j(d02j);
						fooo8.setCdd03j(d03j);
						fooo8.setCdd04j(d04j);
						fooo8.setCdd05j(d05j);
						fooo8.setCdd06j(d06j);
						fooo8.setCdd07j(d07j);
						fooo8.setCdd08j(d08j);
						fooo8.setCdd09j(d09j);
						fooo8.setCdd10j(d10j);
						fooo8.setCdd11j(d11j);
						fooo8.setCdd12j(d12j);
						fooo8.setCdd13j(d13j);
						fooo8.setCdd14j(d14j);
						fooo8.setCduser("JDE");
						fooo8.setCdupmj(transformarGregorianoAJulia(new Date()));
						fooo8.setCdupmt(Double.parseDouble(horaAuditoria));
						servicioF0008.guardar(fooo8);
						msj.mensajeInformacion(Mensaje.guardado);
						limpiar();
						listaGeneral = servicioF0008.buscarTodosOrdenados();
						catalogo.actualizarLista(listaGeneral);

					}

				}

			}

			@Override
			public void limpiar() {
				// TODO Auto-generated method stub
				mostrarBotones(false);
				limpiarCampos();
				habilitarTextClave();
				clave = null;

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void salir() {
				// TODO Auto-generated method stub
				cerrarVentana(divVF0008, titulo, tabs);
			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub
				if (gpxDatosF0008.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F0008> eliminarLista = catalogo
								.obtenerSeleccionados();
						Messagebox
								.show("�Desea Eliminar los "
										+ eliminarLista.size() + " Registros?",
										"Alerta",
										Messagebox.OK | Messagebox.CANCEL,
										Messagebox.QUESTION,
										new org.zkoss.zk.ui.event.EventListener<Event>() {
											public void onEvent(Event evt)
													throws InterruptedException {
												if (evt.getName()
														.equals("onOK")) {
													servicioF0008
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													listaGeneral = servicioF0008.buscarTodosOrdenados();
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
													servicioF0008
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													listaGeneral = servicioF0008.buscarTodosOrdenados();
													catalogo.actualizarLista(listaGeneral);
												}
											}
										});
					} else
						msj.mensajeAlerta(Mensaje.noSeleccionoRegistro);
				}

			}

			@Override
			public void ayuda() {
				// TODO Auto-generated method stub

			}

		};
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF0008.appendChild(botonera);

	}

	public void limpiarCampos() {
		clave = null;
		dtbDFYJF0008.setValue(null);
		dtbD01JF0008.setValue(null);
		dtbD02JF0008.setValue(null);
		dtbD03JF0008.setValue(null);
		dtbD04JF0008.setValue(null);
		dtbD05JF0008.setValue(null);
		dtbD06JF0008.setValue(null);
		dtbD07JF0008.setValue(null);
		dtbD08JF0008.setValue(null);
		dtbD09JF0008.setValue(null);
		dtbD10JF0008.setValue(null);
		dtbD11JF0008.setValue(null);
		dtbD12JF0008.setValue(null);
		dtbD13JF0008.setValue(null);
		dtbD14JF0008.setValue(null);
		buscadorDPNT.settearCampo(null);
		catalogo.limpiarSeleccion();

	}

	public void habilitarTextClave() {

		buscadorDPNT.habilitarCampos();
	}

	public boolean validarFechas() {

		if (dtbD01JF0008.getValue().after(dtbD02JF0008.getValue())) {

			Messagebox
					.show("La fecha del periodo 2 ser posterior a la fecha del periodo 1",
							"Error", Messagebox.OK, Messagebox.ERROR);

			return false;
		} else {

			if (dtbD02JF0008.getValue().after(dtbD03JF0008.getValue())) {

				Messagebox
						.show("La fecha del periodo 3 ser posterior a la fecha del periodo 2",
								"Error", Messagebox.OK, Messagebox.ERROR);

				return false;
			} else {

				if (dtbD03JF0008.getValue().after(dtbD04JF0008.getValue())) {

					Messagebox
							.show("La fecha del periodo 4 ser posterior a la fecha del periodo 3",
									"Error", Messagebox.OK, Messagebox.ERROR);

					return false;
				} else {

					if (dtbD04JF0008.getValue().after(dtbD05JF0008.getValue())) {

						Messagebox
								.show("La fecha del periodo 5 ser posterior a la fecha del periodo 4",
										"Error", Messagebox.OK,
										Messagebox.ERROR);

						return false;
					} else {

						if (dtbD05JF0008.getValue().after(
								dtbD06JF0008.getValue())) {

							Messagebox
									.show("La fecha del periodo 6 ser posterior a la fecha del periodo 5",
											"Error", Messagebox.OK,
											Messagebox.ERROR);

							return false;
						} else {

							if (dtbD06JF0008.getValue().after(
									dtbD07JF0008.getValue())) {

								Messagebox
										.show("La fecha del periodo 7 ser posterior a la fecha del periodo 6",
												"Error", Messagebox.OK,
												Messagebox.ERROR);

								return false;
							} else {

								if (dtbD07JF0008.getValue().after(
										dtbD08JF0008.getValue())) {

									Messagebox
											.show("La fecha del periodo 8 ser posterior a la fecha del periodo 7",
													"Error", Messagebox.OK,
													Messagebox.ERROR);

									return false;
								} else {

									if (dtbD08JF0008.getValue().after(
											dtbD09JF0008.getValue())) {

										Messagebox
												.show("La fecha del periodo 9 ser posterior a la fecha del periodo 8",
														"Error", Messagebox.OK,
														Messagebox.ERROR);

										return false;
									} else {

										if (dtbD09JF0008.getValue().after(
												dtbD10JF0008.getValue())) {

											Messagebox
													.show("La fecha del periodo 10 ser posterior a la fecha del periodo 9",
															"Error",
															Messagebox.OK,
															Messagebox.ERROR);

											return false;
										} else {

											if (dtbD10JF0008.getValue().after(
													dtbD11JF0008.getValue())) {

												Messagebox
														.show("La fecha del periodo 11 ser posterior a la fecha del periodo 10",
																"Error",
																Messagebox.OK,
																Messagebox.ERROR);

												return false;
											} else {

												if (dtbD11JF0008.getValue()
														.after(dtbD12JF0008
																.getValue())) {

													Messagebox
															.show("La fecha del periodo 12 ser posterior a la fecha del periodo 11",
																	"Error",
																	Messagebox.OK,
																	Messagebox.ERROR);

													return false;
												} else {

													if (dtbD12JF0008
															.getValue()
															.after(dtbD13JF0008
																	.getValue())) {

														Messagebox
																.show("La fecha del periodo 13 ser posterior a la fecha del periodo 12",
																		"Error",
																		Messagebox.OK,
																		Messagebox.ERROR);

														return false;
													} else {

														if (dtbD13JF0008
																.getValue()
																.after(dtbD14JF0008
																		.getValue())) {

															Messagebox
																	.show("La fecha del periodo 14 ser posterior a la fecha del periodo 13",
																			"Error",
																			Messagebox.OK,
																			Messagebox.ERROR);

															return false;
														} else {

															return true;

														}

													}

												}

											}

										}

									}

								}

							}

						}

					}

				}

			}

		}

	}

	public boolean camposLLenos() {
		if (buscadorDPNT.obtenerCaja().compareTo("") == 0
				|| dtbDFYJF0008.getText().compareTo("") == 0
				|| dtbD01JF0008.getText().compareTo("") == 0
				|| dtbD01JF0008.getText().compareTo("") == 0
				|| dtbD02JF0008.getText().compareTo("") == 0
				|| dtbD03JF0008.getText().compareTo("") == 0
				|| dtbD04JF0008.getText().compareTo("") == 0
				|| dtbD05JF0008.getText().compareTo("") == 0
				|| dtbD06JF0008.getText().compareTo("") == 0
				|| dtbD07JF0008.getText().compareTo("") == 0
				|| dtbD08JF0008.getText().compareTo("") == 0
				|| dtbD09JF0008.getText().compareTo("") == 0
				|| dtbD10JF0008.getText().compareTo("") == 0
				|| dtbD11JF0008.getText().compareTo("") == 0
				|| dtbD12JF0008.getText().compareTo("") == 0
				|| dtbD13JF0008.getText().compareTo("") == 0
				|| dtbD14JF0008.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (buscadorDPNT.obtenerCaja().compareTo("") != 0
				|| dtbDFYJF0008.getText().compareTo("") != 0
				|| dtbD01JF0008.getText().compareTo("") != 0
				|| dtbD02JF0008.getText().compareTo("") != 0
				|| dtbD03JF0008.getText().compareTo("") != 0
				|| dtbD04JF0008.getText().compareTo("") != 0
				|| dtbD05JF0008.getText().compareTo("") != 0
				|| dtbD06JF0008.getText().compareTo("") != 0
				|| dtbD07JF0008.getText().compareTo("") != 0
				|| dtbD08JF0008.getText().compareTo("") != 0
				|| dtbD09JF0008.getText().compareTo("") != 0
				|| dtbD10JF0008.getText().compareTo("") != 0
				|| dtbD11JF0008.getText().compareTo("") != 0
				|| dtbD12JF0008.getText().compareTo("") != 0
				|| dtbD13JF0008.getText().compareTo("") != 0
				|| dtbD14JF0008.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
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

	@Listen("onClick = #gpxRegistroF0008")
	public void abrirRegistro() {
		gpxDatosF0008.setOpen(false);
		gpxRegistroF0008.setOpen(true);
		mostrarBotones(false);

	}

	@Listen("onOpen = #gpxDatosF0008")
	public void abrirCatalogo() {
		gpxDatosF0008.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF0008.setOpen(false);
								gpxRegistroF0008.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF0008.setOpen(true);
									gpxRegistroF0008.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF0008.setOpen(true);
			gpxRegistroF0008.setOpen(false);
			mostrarBotones(true);
		}
	}

	public boolean validarSeleccion() {
		List<F0008> seleccionados = catalogo.obtenerSeleccionados();
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

		if (!camposLLenos()) {
			msj.mensajeError(Mensaje.camposVacios);
			return false;
		} else
			return true;

	}

	public void mostrarCatalogo() {

		listaGeneral = servicioF0008.buscarTodosOrdenados();
		catalogo = new CatalogoGenerico<F0008>(catalogoF0008, "F0008", listaGeneral,
				false, true, true, "Patr�n fecha", "Fecha inicial",
				"Fin periodo 01", "Fin periodo 02", "Fin periodo 03",
				"Fin periodo 04", "Fin periodo 05", "Fin periodo 06",
				"Fin periodo 07", "Fin periodo 08", "Fin periodo 09",
				"Fin periodo 10", "Fin periodo 11", "Fin periodo 12",
				"Fin periodo 13", "Fin periodo 14") {

			@Override
			protected List<F0008> buscar(List<String> valores) {
				List<F0008> lista = new ArrayList<F0008>();

				for (F0008 f0008 : listaGeneral) {
					if (f0008.getId().getCddtpn().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(BigDecimal
											.valueOf(f0008.getId().getCddfyj())))
									.toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd01j())).toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd02j())).toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd03j())).toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd04j())).toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd05j())).toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd06j())).toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd07j())).toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd08j())).toLowerCase()
									.contains(valores.get(9).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd09j())).toLowerCase()
									.contains(valores.get(10).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd10j())).toLowerCase()
									.contains(valores.get(11).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd11j())).toLowerCase()
									.contains(valores.get(12).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd12j())).toLowerCase()
									.contains(valores.get(13).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd13j())).toLowerCase()
									.contains(valores.get(14).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0008
											.getCdd14j())).toLowerCase()
									.contains(valores.get(15).toLowerCase())) {
						lista.add(f0008);
					}
				}
				return lista;

			}

			@Override
			protected String[] crearRegistros(F0008 f0008) {
				String[] registros = new String[16];
				registros[0] = f0008.getId().getCddtpn();
				registros[1] = formatoFecha
						.format(transformarJulianaAGregoria(BigDecimal
								.valueOf(f0008.getId().getCddfyj())));
				registros[2] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd01j()));
				registros[3] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd02j()));
				registros[4] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd03j()));
				registros[5] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd04j()));
				registros[6] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd05j()));
				registros[7] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd06j()));
				registros[8] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd07j()));
				registros[9] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd08j()));
				registros[10] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd09j()));
				registros[11] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd10j()));
				registros[12] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd11j()));
				registros[13] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd12j()));
				registros[14] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd13j()));
				registros[15] = formatoFecha
						.format(transformarJulianaAGregoria(f0008.getCdd14j()));

				return registros;
			}
		};
		catalogo.setParent(catalogoF0008);

	}
}
