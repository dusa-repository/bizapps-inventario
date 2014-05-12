package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.maestros.F0004;
import modelo.maestros.F0008;
import modelo.maestros.F0015;
import modelo.maestros.F0013;
import modelo.pk.F0008PK;
import modelo.pk.F0015PK;

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
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0015 extends CGenerico {

	@Wire
	private Div divVF0015;
	@Wire
	private Div botoneraF0015;
	@Wire
	private Groupbox gpxRegistroF0015;
	@Wire
	private Textbox txtCRCDF0015;
	@Wire
	private Button btnBuscarCRCDF0015;
	@Wire
	private Textbox txtCRDCF0015;
	@Wire
	private Button btnBuscarCRDCF0015;
	@Wire
	private Datebox dtbEFTF0015;
	@Wire
	private Doublespinner dblAN8F0015;
	@Wire
	private Radiogroup rdgMetodoCalculoF0015;
	@Wire
	private Radio rdoMetodoInversionF0015;
	@Wire
	private Radio rdoSinMetodoF0015;
	@Wire
	private Radio rdoMetodoTriangulacionF0015;
	@Wire
	private Checkbox chxCambioContadoF0015;
	@Wire
	private Textbox txtCRCMF0015;
	@Wire
	private Label lblMetodoConversionF0015;
	@Wire
	private Doublespinner dblCRRF0015;
	@Wire
	private Doublespinner dblCRRDF0015;
	@Wire
	private Tabbox tbTipoCambioF0015;
	@Wire
	private Tab tbMetodoCalculoF0015;
	@Wire
	private Tab tbRevisionTipoCambioF0015;
	@Wire
	private Button btnBuscarAN8F0015;
	@Wire
	private Groupbox gpxDatosF0015;
	@Wire
	private Div catalogoF0015H;
	@Wire
	private Div catalogoF0015D;
	private static F0013 F0013;
	private static boolean agregarMetodoCalculo = false;
	private static SimpleDateFormat formatoFecha = new SimpleDateFormat(
			"dd-MM-yyyy");

	Botonera botonera;
	Catalogo<F0015> catalogoEncabezado;
	Catalogo<F0015> catalogoDetalle;
	F0015PK clave = null;

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		txtCRCDF0015.setFocus(true);
		mostrarCatalogoEncabezado();
		mostrarCatalogoDetalle();

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub

				if (!agregarMetodoCalculo) {

					botonera.getChildren().get(0).setVisible(false);

					if (validarSeleccionEncabezado()) {
						if (catalogoEncabezado.obtenerSeleccionados().size() == 1) {
							mostrarBotones(false);
							botonera.getChildren().get(2).setVisible(true);
							abrirRegistro();
							F0015 f015 = catalogoEncabezado
									.objetoSeleccionadoDelCatalogo();
							clave = f015.getId();
							txtCRCDF0015.setValue(f015.getId().getCxcrcd());
							txtCRCDF0015.setDisabled(true);
							btnBuscarCRCDF0015.setDisabled(true);
							txtCRDCF0015.setValue(f015.getId().getCxcrdc());
							txtCRDCF0015.setDisabled(true);
							btnBuscarCRDCF0015.setDisabled(true);
							dtbEFTF0015
									.setValue((transformarJulianaAGregoria(BigDecimal
											.valueOf(f015.getId().getCxeft()))));
							dblAN8F0015.setValue(f015.getId().getCxan8());
							dblAN8F0015.setDisabled(true);
							btnBuscarAN8F0015.setDisabled(true);
							txtCRCMF0015.setValue(f015.getCxcrcm());
							dblCRRF0015.setValue(f015.getCxcrr());
							dblCRRDF0015.setValue(f015.getCxcrrd());
							dtbEFTF0015.setFocus(true);

						} else
							msj.mensajeAlerta(Mensaje.editarSoloUno);
					}

				} else {

					if (validarSeleccionDetalle()) {
						if (catalogoDetalle.obtenerSeleccionados().size() == 1) {
							F0015 f015 = catalogoDetalle
									.objetoSeleccionadoDelCatalogo();
							clave = f015.getId();
							txtCRCDF0015.setValue(f015.getId().getCxcrcd());
							txtCRCDF0015.setDisabled(true);
							btnBuscarCRCDF0015.setDisabled(true);
							txtCRDCF0015.setValue(f015.getId().getCxcrdc());
							txtCRDCF0015.setDisabled(true);
							btnBuscarCRDCF0015.setDisabled(true);
							dtbEFTF0015
									.setValue((transformarJulianaAGregoria(BigDecimal
											.valueOf(f015.getId().getCxeft()))));
							dblAN8F0015.setValue(f015.getId().getCxan8());
							dblAN8F0015.setDisabled(true);
							btnBuscarAN8F0015.setDisabled(true);
							txtCRCMF0015.setValue(f015.getCxcrcm());
							dblCRRF0015.setValue(f015.getCxcrr());
							dblCRRDF0015.setValue(f015.getCxcrrd());
							tbMetodoCalculoF0015.setSelected(true);

						} else
							msj.mensajeAlerta(Mensaje.editarSoloUno);
					}

				}

			}

			@Override
			public void buscar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void annadir() {
				// TODO Auto-generated method stub
				abrirRegistro();
				dtbEFTF0015.setDisabled(true);
				tbMetodoCalculoF0015.setSelected(true);
				tbTipoCambioF0015.setVisible(true);
				agregarMetodoCalculo = true;
				mostrarBotones(false);
				botonera.getChildren().get(0).setVisible(true);
				botonera.getChildren().get(2).setVisible(false);
				txtCRCMF0015.setFocus(true);

			}

			@Override
			public void guardar() {
				// TODO Auto-generated method stub
				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {
					String crcd = txtCRCDF0015.getValue();
					String crdc = txtCRDCF0015.getValue();
					String rttyp = "";
					long eft = Long.valueOf((String
							.valueOf(transformarGregorianoAJulia(dtbEFTF0015
									.getValue()))));
					double an8 = dblAN8F0015.getValue();
					String crcm = txtCRCMF0015.getValue();
					double crr = dblCRRF0015.getValue();
					double crrd = dblCRRDF0015.getValue();
					F0015PK clave = new F0015PK();
					clave.setCxcrcd(crcd);
					clave.setCxcrdc(crdc);
					clave.setCxrttyp(rttyp);
					clave.setCxeft(eft);
					clave.setCxan8(an8);
					F0015 foo15 = new F0015();
					foo15.setId(clave);

					if (agregarMetodoCalculo) {
						System.out.println("Metodo calculo");
						foo15.setCxcrcm(crcm);
						foo15.setCxcrr(crr);
						foo15.setCxcrrd(crrd);
					}

					foo15.setCxuser("JDE");
					foo15.setCxupmj(transformarGregorianoAJulia(new Date()));
					foo15.setCxupmt(Double.parseDouble(horaAuditoria));
					servicioF0015.guardar(foo15);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogoEncabezado.actualizarLista(servicioF0015
							.buscarTodosOrdenados());
					catalogoDetalle.actualizarLista(servicioF0015
							.buscarTodosOrdenados());
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
				cerrarVentana(divVF0015, "Sistema");
			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub

				if (!agregarMetodoCalculo) {

					if (gpxDatosF0015.isOpen()) {
						/* Elimina Varios Registros */
						if (validarSeleccionEncabezado()) {
							final List<F0015> eliminarLista = catalogoEncabezado
									.obtenerSeleccionados();
							Messagebox
									.show("�Desea Eliminar los "
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
														servicioF0015
																.eliminarVarios(eliminarLista);
														msj.mensajeInformacion(Mensaje.eliminado);
														catalogoEncabezado
																.actualizarLista(servicioF0015
																		.buscarTodosOrdenados());
														catalogoDetalle
																.actualizarLista(servicioF0015
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
													if (evt.getName().equals(
															"onOK")) {
														servicioF0015
																.eliminarUno(clave);
														msj.mensajeInformacion(Mensaje.eliminado);
														limpiar();
														catalogoEncabezado
																.actualizarLista(servicioF0015
																		.buscarTodosOrdenados());
														catalogoDetalle
																.actualizarLista(servicioF0015
																		.buscarTodosOrdenados());
													}
												}
											});
						} else
							msj.mensajeAlerta(Mensaje.noSeleccionoRegistro);
					}
				} else {

					if (tbRevisionTipoCambioF0015.isSelected()) {
						/* Elimina Varios Registros */
						if (validarSeleccionDetalle()) {
							final List<F0015> eliminarLista = catalogoDetalle
									.obtenerSeleccionados();
							Messagebox
									.show("�Desea Eliminar los "
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
														servicioF0015
																.eliminarVarios(eliminarLista);
														msj.mensajeInformacion(Mensaje.eliminado);
														catalogoDetalle
																.actualizarLista(servicioF0015
																		.buscarTodosOrdenados());
														catalogoEncabezado
																.actualizarLista(servicioF0015
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
													if (evt.getName().equals(
															"onOK")) {
														servicioF0015
																.eliminarUno(clave);
														msj.mensajeInformacion(Mensaje.eliminado);
														limpiar();
														catalogoDetalle
																.actualizarLista(servicioF0015
																		.buscarTodosOrdenados());
														catalogoEncabezado
																.actualizarLista(servicioF0015
																		.buscarTodosOrdenados());
													}
												}
											});
						} else
							msj.mensajeAlerta(Mensaje.noSeleccionoRegistro);
					}

				}

			}

			@Override
			public void ayuda() {
				// TODO Auto-generated method stub

			}

		};
		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF0015.appendChild(botonera);

	}

	public void limpiarCampos() {
		clave = null;
		txtCRCDF0015.setValue("");
		txtCRDCF0015.setValue("");
		dtbEFTF0015.setValue(null);
		dblAN8F0015.setValue(null);
		txtCRCDF0015.setFocus(true);
		rdgMetodoCalculoF0015.setSelectedItem(null);
		chxCambioContadoF0015.setChecked(false);
		txtCRCMF0015.setValue("");
		lblMetodoConversionF0015.setValue("");
		dblCRRF0015.setValue(null);
		dblCRRDF0015.setValue(null);
		tbTipoCambioF0015.setVisible(false);
		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(0).setVisible(false);
		agregarMetodoCalculo = false;
		catalogoEncabezado.limpiarSeleccion();
	}

	public boolean validarSeleccionEncabezado() {
		List<F0015> seleccionados = catalogoEncabezado.obtenerSeleccionados();
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

	public boolean validarSeleccionDetalle() {
		List<F0015> seleccionados = catalogoDetalle.obtenerSeleccionados();
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

	@Listen("onClick = #gpxRegistroF0015")
	public void abrirRegistro() {

		gpxDatosF0015.setOpen(false);
		gpxRegistroF0015.setOpen(true);
		mostrarBotones(false);

	}

	@Listen("onOpen = #gpxDatosF0015")
	public void abrirCatalogo() {
		gpxDatosF0015.setOpen(false);
		botonera.getChildren().get(0).setVisible(true);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF0015.setOpen(false);
								gpxRegistroF0015.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF0015.setOpen(true);
									catalogoEncabezado.limpiarSeleccion();
									gpxRegistroF0015.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
									botonera.getChildren().get(0)
											.setVisible(true);
								}
							}
						}
					});
		} else {
			gpxDatosF0015.setOpen(true);
			gpxRegistroF0015.setOpen(false);
			mostrarBotones(true);
		}
	}

	public void habilitarTextClave() {
		if (txtCRCDF0015.isDisabled())
			txtCRCDF0015.setDisabled(false);
		if (txtCRDCF0015.isDisabled())
			txtCRDCF0015.setDisabled(false);
		if (dtbEFTF0015.isDisabled())
			dtbEFTF0015.setDisabled(false);
		if (dblAN8F0015.isDisabled())
			dblAN8F0015.setDisabled(false);
		if (btnBuscarCRCDF0015.isDisabled())
			btnBuscarCRCDF0015.setDisabled(false);
		if (btnBuscarCRDCF0015.isDisabled())
			btnBuscarCRDCF0015.setDisabled(false);
		if (btnBuscarAN8F0015.isDisabled())
			btnBuscarAN8F0015.setDisabled(false);

	}

	public boolean camposLLenos() {
		if (txtCRCDF0015.getText().compareTo("") == 0
				|| txtCRDCF0015.getText().compareTo("") == 0
				|| dtbEFTF0015.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtCRCDF0015.getText().compareTo("") != 0
				|| txtCRDCF0015.getText().compareTo("") != 0
				|| dtbEFTF0015.getText().compareTo("") != 0
				|| dblAN8F0015.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
		botonera.getChildren().get(6).setVisible(bol);
	}

	protected boolean validar() {
		if (!camposLLenos()) {
			msj.mensajeAlerta(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	public void mostrarCatalogoEncabezado() {
		final List<F0015> listF0015 = servicioF0015.buscarTodosOrdenados();
		catalogoEncabezado = new Catalogo<F0015>(catalogoF0015H, "F0015",
				listF0015, "Moneda origen", "Descripci�n moneda origen",
				"Moneda destino", "Descripci�n moneda destino",
				"Contrato (direcci�n)", "Descripci�n contrato (direcci�n)") {

			@Override
			protected List<F0015> buscar(List<String> valores) {

				List<F0015> lista = new ArrayList<F0015>();

				for (F0015 f0015 : listF0015) {
					if (f0015.getId().getCxcrcd().toLowerCase()
							.startsWith(valores.get(0))
							&& (servicioF0013.buscar(f0015.getId().getCxcrcd()))
									.getCvdl01().toLowerCase()
									.startsWith(valores.get(1))
							&& f0015.getId().getCxcrdc().toLowerCase()
									.startsWith(valores.get(2))
							&& (servicioF0013.buscar(f0015.getId().getCxcrdc()))
									.getCvdl01().toLowerCase()
									.startsWith(valores.get(3))
							&& String.valueOf(f0015.getId().getCxan8())
									.toLowerCase().startsWith(valores.get(4))
							&& f0015.getId().getCxrttyp().toLowerCase()
									.startsWith(valores.get(5))) {
						lista.add(f0015);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0015 f0015) {
				String[] registros = new String[6];
				registros[0] = f0015.getId().getCxcrcd();
				registros[1] = (servicioF0013.buscar(f0015.getId().getCxcrcd()))
						.getCvdl01();
				registros[2] = f0015.getId().getCxcrdc();
				registros[3] = (servicioF0013.buscar(f0015.getId().getCxcrdc()))
						.getCvdl01();
				registros[4] = String.valueOf(f0015.getId().getCxan8());
				registros[5] = f0015.getId().getCxrttyp();
				return registros;
			}
		};
		catalogoEncabezado.setParent(catalogoF0015H);
	}

	public void mostrarCatalogoDetalle() {
		final List<F0015> listF0015 = servicioF0015.buscarTodosOrdenados();
		catalogoDetalle = new Catalogo<F0015>(catalogoF0015D, "F0015D",
				listF0015, "Fecha efectiva", "M�todo c�lculo", "M�todo conv",
				"Tipo multiplicador", "Tipo divisor", "Mon Trian",
				"Tipo tringulaci�n paso1", "Tipo triangulaci�n paso2",
				"Cambio al contado") {

			@Override
			protected List<F0015> buscar(List<String> valores) {

				List<F0015> lista = new ArrayList<F0015>();

				for (F0015 f0015 : listF0015) {
					if (formatoFecha
							.format(transformarJulianaAGregoria(BigDecimal
									.valueOf(f0015.getId().getCxeft())))
							.toLowerCase().startsWith(valores.get(0))
							&& f0015.getCxcsr().toLowerCase()
									.startsWith(valores.get(1))
							&& f0015.getCxcrcm().toLowerCase()
									.startsWith(valores.get(2))
							&& String.valueOf(f0015.getCxcrr()).toLowerCase()
									.startsWith(valores.get(3))
							&& String.valueOf(f0015.getCxcrrd()).toLowerCase()
									.startsWith(valores.get(4))
							&& f0015.getCxtrcr().toLowerCase()
									.startsWith(valores.get(5))
							&& f0015.getCxtrcr().toLowerCase()
									.startsWith(valores.get(6))
							&& f0015.getCxtrcr().toLowerCase()
									.startsWith(valores.get(7))
							&& f0015.getCxcsr().toLowerCase()
									.startsWith(valores.get(8))) {
						lista.add(f0015);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0015 f0015) {
				String[] registros = new String[9];
				registros[0] = formatoFecha
						.format(transformarJulianaAGregoria(BigDecimal
								.valueOf(f0015.getId().getCxeft())));
				registros[1] = f0015.getCxcsr();
				registros[2] = f0015.getCxcrcm();
				registros[3] = String.valueOf(f0015.getCxcrr());
				registros[4] = String.valueOf(f0015.getCxcrrd());
				registros[5] = f0015.getCxtrcr();
				registros[6] = f0015.getCxtrcr();
				registros[7] = f0015.getCxtrcr();
				registros[8] = f0015.getCxcsr();
				return registros;
			}
		};
		catalogoDetalle.setParent(catalogoF0015D);
	}

}
