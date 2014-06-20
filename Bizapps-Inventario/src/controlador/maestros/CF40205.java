package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0010;
import modelo.maestros.F0101;
import modelo.maestros.F0115;
import modelo.maestros.F40205;
import modelo.pk.F0115PK;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF40205 extends CGenerico {

	private static final long serialVersionUID = 6128733232559473294L;

	@Wire
	private Div divVF40205;
	@Wire
	private Textbox txtLntyF40205;
	@Wire
	private Textbox txtLndsF40205;
	@Wire
	private Textbox txtLnd2F40205;
	@Wire
	private Div divBuscadorIvi;
	BuscadorUDC buscadorIvi;
	@Wire
	private Div divBuscadorGltp;
	BuscadorUDC buscadorGltp;
	@Wire
	private Div divBuscadorTx01;
	BuscadorUDC buscadorTx01;
	@Wire
	private Div divBuscadorCsj;
	BuscadorUDC buscadorCsj;
	@Wire
	private Checkbox chxGliF40205;
	@Wire
	private Checkbox chxAriF40205;
	@Wire
	private Checkbox chxApiF40205;
	@Wire
	private Checkbox chxPdc2F40205;
	@Wire
	private Checkbox chxTxynF40205;
	@Wire
	private Checkbox chxRsgnF40205;
	@Wire
	private Checkbox chxAftF40205;
	@Wire
	private Checkbox chxArtF40205;
	@Wire
	private Checkbox chxGwoF40205;
	@Wire
	private Checkbox chxCdscF40205;
	@Wire
	private Checkbox chxPrftF40205;
	@Wire
	private Checkbox chxPdc4F40205;
	@Wire
	private Checkbox chxPdc3F40205;
	@Wire
	private Checkbox chxPdc1F40205;
	@Wire
	private Checkbox chxIdc1F40205;
	@Wire
	private Checkbox chxCmiF40205;
	@Wire
	private Checkbox chxPrrqF40205;
	@Wire
	private Div botoneraF40205;
	@Wire
	private Div catalogoF40205;
	@Wire
	private Groupbox gpxDatosF40205;
	@Wire
	private Groupbox gpxRegistroF40205;
	Botonera botonera;
	Catalogo<F40205> catalogo;
	String clave = "";

	@Override
	public void inicializar() throws IOException {
		mostrarCatalogo();
		cargarUdc();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F40205 f0115 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f0115.getLflnty();
						txtLntyF40205.setValue(f0115.getLflnty());
						txtLndsF40205.setValue(f0115.getLflnds());
						txtLnd2F40205.setValue(f0115.getLflnd2());
						buscadorIvi.settearCampo(servicioF0005.buscar("H40",
								"IV", f0115.getLfivi()));
						buscadorGltp.settearCampo(servicioF0005.buscar("41",
								"9", f0115.getLfglc()));
						buscadorTx01.settearCampo(servicioF0005.buscar("H00",
								"TV", f0115.getLftx01()));
						buscadorCsj.settearCampo(servicioF0005.buscar("H41",
								"CS", f0115.getLfcsj()));
						if (f0115.getLfgli().equals("Y"))
							chxGliF40205.setChecked(true);
						else
							chxGliF40205.setChecked(false);

						if (f0115.getLfari().equals("Y"))
							chxAriF40205.setChecked(true);
						else
							chxAriF40205.setChecked(false);

						if (f0115.getLfapi().equals("Y"))
							chxApiF40205.setChecked(true);
						else
							chxApiF40205.setChecked(false);

						if (f0115.getLfpdc2().equals("Y"))
							chxPdc2F40205.setChecked(true);
						else
							chxPdc2F40205.setChecked(false);

						if (f0115.getLftxyn().equals("Y"))
							chxTxynF40205.setChecked(true);
						else
							chxTxynF40205.setChecked(false);
						if (f0115.getLfrsgn().equals("Y"))
							chxRsgnF40205.setChecked(true);
						else
							chxRsgnF40205.setChecked(false);

						if (f0115.getLfaft().equals("Y"))
							chxAftF40205.setChecked(true);
						else
							chxAftF40205.setChecked(false);

						if (f0115.getLfart().equals("Y"))
							chxArtF40205.setChecked(true);
						else
							chxArtF40205.setChecked(false);

						if (f0115.getLfgwo().equals("Y"))
							chxGwoF40205.setChecked(true);
						else
							chxGwoF40205.setChecked(false);

						if (f0115.getLfcdsc().equals("Y"))
							chxCdscF40205.setChecked(true);
						else
							chxCdscF40205.setChecked(false);

						if (f0115.getLfprft().equals("Y"))
							chxPrftF40205.setChecked(true);
						else
							chxPrftF40205.setChecked(false);

						if (f0115.getLfpdc4().equals("Y"))
							chxPdc4F40205.setChecked(true);
						else
							chxPdc4F40205.setChecked(false);

						if (f0115.getLfpdc3().equals("Y"))
							chxPdc3F40205.setChecked(true);
						else
							chxPdc3F40205.setChecked(false);

						if (f0115.getLfpdc1().equals("Y"))
							chxPdc1F40205.setChecked(true);
						else
							chxPdc1F40205.setChecked(false);

						if (f0115.getLfidc1().equals("Y"))
							chxIdc1F40205.setChecked(true);
						else
							chxIdc1F40205.setChecked(false);

						if (f0115.getLfcmi().equals("Y"))
							chxCmiF40205.setChecked(true);
						else
							chxCmiF40205.setChecked(false);

						if (f0115.getLfprrq().equals("Y"))
							chxPrrqF40205.setChecked(true);
						else
							chxPrrqF40205.setChecked(false);
						txtLntyF40205.setDisabled(true);
						txtLndsF40205.setFocus(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF40205, "Tipos de Linea");
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
				clave = "";
			}

			@Override
			public void guardar() {
				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {

					F40205 f40 = new F40205();
					f40.setLflnty(txtLntyF40205.getValue());
					f40.setLflnds(txtLndsF40205.getValue());
					f40.setLflnd2(txtLnd2F40205.getValue());
					f40.setLfivi(buscadorIvi.obtenerCaja());
					f40.setLfglc(buscadorGltp.obtenerCaja());
					f40.setLftx01(buscadorTx01.obtenerCaja());
					f40.setLfcsj(buscadorCsj.obtenerCaja());
					// f40.setLfupmj(transformarGregorianoAJulia(fecha));
					// f40.setLfupmt(Double.valueOf(horaAuditoria));
					// f40.setLfuser("JDE");
					if (chxAftF40205.isChecked())
						f40.setLfaft("Y");
					else
						f40.setLfaft("N");

					if (chxApiF40205.isChecked())
						f40.setLfapi("Y");
					else
						f40.setLfapi("N");

					if (chxAriF40205.isChecked())
						f40.setLfari("Y");
					else
						f40.setLfari("N");

					if (chxArtF40205.isChecked())
						f40.setLfart("Y");
					else
						f40.setLfart("N");

					if (chxCdscF40205.isChecked())
						f40.setLfcdsc("Y");
					else
						f40.setLfcdsc("N");

					if (chxCmiF40205.isChecked())
						f40.setLfcmi("Y");
					else
						f40.setLfcmi("N");

					if (chxGliF40205.isChecked())
						f40.setLfgli("Y");
					else
						f40.setLfgli("N");

					if (chxGwoF40205.isChecked())
						f40.setLfgwo("Y");
					else
						f40.setLfgwo("N");

					if (chxIdc1F40205.isChecked())
						f40.setLfidc1("Y");
					else
						f40.setLfidc1("N");

					if (chxPdc1F40205.isChecked())
						f40.setLfpdc1("Y");
					else
						f40.setLfpdc1("N");

					if (chxPdc2F40205.isChecked())
						f40.setLfpdc2("Y");
					else
						f40.setLfpdc2("N");

					if (chxPdc3F40205.isChecked())
						f40.setLfpdc3("Y");
					else
						f40.setLfpdc3("N");

					if (chxPdc4F40205.isChecked())
						f40.setLfpdc4("Y");
					else
						f40.setLfpdc4("N");

					if (chxPrftF40205.isChecked())
						f40.setLfprft("Y");
					else
						f40.setLfprft("N");

					if (chxPrrqF40205.isChecked())
						f40.setLfprrq("Y");
					else
						f40.setLfprrq("N");

					if (chxRsgnF40205.isChecked())
						f40.setLfrsgn("Y");
					else
						f40.setLfrsgn("N");

					if (chxTxynF40205.isChecked())
						f40.setLftxyn("Y");
					else
						f40.setLftxyn("N");

					servicioF40205.guardar(f40);
					catalogo.actualizarLista(servicioF40205
							.buscarTodosOrdenados());
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();

				}
			}

			@Override
			public void eliminar() {
				if (gpxDatosF40205.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F40205> eliminarLista = catalogo
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
													servicioF40205
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF40205
															.buscarTodosOrdenados());
												}
											}
										});
					}
				} else {
					/* Elimina un solo registro */
					if (clave != "") {
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
													servicioF40205
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF40205
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
		botoneraF40205.appendChild(botonera);
	}

	@Listen("onOpen = #gpxDatosF40205")
	public void abrirCatalogo() {
		gpxDatosF40205.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF40205.setOpen(false);
								gpxRegistroF40205.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF40205.setOpen(true);
									gpxRegistroF40205.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF40205.setOpen(true);
			gpxRegistroF40205.setOpen(false);
			mostrarBotones(true);
		}
	}

	private boolean camposEditando() {
		if (txtLnd2F40205.getText().compareTo("") != 0
				|| txtLndsF40205.getText().compareTo("") != 0
				|| txtLntyF40205.getText().compareTo("") != 0
				|| buscadorCsj.obtenerCaja().compareTo("") != 0
				|| buscadorGltp.obtenerCaja().compareTo("") != 0
				|| buscadorIvi.obtenerCaja().compareTo("") != 0
				|| buscadorTx01.obtenerCaja().compareTo("") != 0) {
			return true;
		} else
			return false;
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

	private boolean camposLLenos() {
		if (txtLntyF40205.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	private boolean claveSYExiste() {
		if (servicioF40205.comparar(txtLntyF40205.getValue())) {
			msj.mensajeAlerta(Mensaje.claveUsada);
			txtLntyF40205.setFocus(true);
			return true;
		} else
			return false;
	}

	protected void habilitarTextClave() {
		if (txtLntyF40205.isDisabled())
			txtLntyF40205.setDisabled(false);
	}

	protected void limpiarCampos() {
		clave = "";
		txtLntyF40205.setValue("");
		txtLndsF40205.setValue("");
		txtLnd2F40205.setValue("");
		buscadorIvi.settearCampo(null);
		buscadorGltp.settearCampo(null);
		buscadorTx01.settearCampo(null);
		buscadorCsj.settearCampo(null);
		if (chxAftF40205.isChecked())
			chxAftF40205.setChecked(false);
		if (chxApiF40205.isChecked())
			chxApiF40205.setChecked(false);
		if (chxAriF40205.isChecked())
			chxAriF40205.setChecked(false);
		if (chxArtF40205.isChecked())
			chxArtF40205.setChecked(false);
		if (chxCdscF40205.isChecked())
			chxCdscF40205.setChecked(false);
		if (chxCmiF40205.isChecked())
			chxCmiF40205.setChecked(false);
		if (chxGliF40205.isChecked())
			chxGliF40205.setChecked(false);
		if (chxGwoF40205.isChecked())
			chxGwoF40205.setChecked(false);
		if (chxIdc1F40205.isChecked())
			chxIdc1F40205.setChecked(false);
		if (chxPdc1F40205.isChecked())
			chxPdc1F40205.setChecked(false);
		if (chxPdc2F40205.isChecked())
			chxPdc2F40205.setChecked(false);
		if (chxPdc3F40205.isChecked())
			chxPdc3F40205.setChecked(false);
		if (chxPdc4F40205.isChecked())
			chxPdc4F40205.setChecked(false);
		if (chxPrftF40205.isChecked())
			chxPrftF40205.setChecked(false);
		if (chxPrrqF40205.isChecked())
			chxPrrqF40205.setChecked(false);
		if (chxRsgnF40205.isChecked())
			chxRsgnF40205.setChecked(false);
		if (chxTxynF40205.isChecked())
			chxTxynF40205.setChecked(false);
		txtLntyF40205.setFocus(true);
	}

	@Listen("onClick = #gpxRegistroF40205")
	public void abrirRegistro() {
		gpxDatosF40205.setOpen(false);
		gpxRegistroF40205.setOpen(true);
		mostrarBotones(false);
	}

	protected void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(bol);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	protected boolean validarSeleccion() {
		List<F40205> seleccionados = catalogo.obtenerSeleccionados();
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

	private void mostrarCatalogo() {
		final List<F40205> listF40205 = servicioF40205.buscarTodosOrdenados();
		catalogo = new Catalogo<F40205>(catalogoF40205, "F40205", listF40205,
				false, false, false, "Tipo Linea", "Descripcion", "Interf Inv",
				"C/P", "C/C", "LM", "AS/G", "Compensacion LM") {

			@Override
			protected List<F40205> buscar(List<String> valores) {

				List<F40205> lista = new ArrayList<F40205>();

				for (F40205 f01 : listF40205) {
					if (f01.getLflnty().toLowerCase()
							.startsWith(valores.get(0))
							&& f01.getLflnds().toLowerCase()
									.startsWith(valores.get(1))
							&& f01.getLfivi().toLowerCase()
									.startsWith(valores.get(2))
							&& f01.getLfapi().toLowerCase()
									.startsWith(valores.get(3))
							&& f01.getLfari().toLowerCase()
									.startsWith(valores.get(4))
							&& f01.getLfgli().toLowerCase()
									.startsWith(valores.get(5))
							&& f01.getLfpdc2().toLowerCase()
									.startsWith(valores.get(6))
							&& f01.getLfglc().toLowerCase()
									.startsWith(valores.get(7))) {
						lista.add(f01);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F40205 f0115) {
				String[] registros = new String[8];
				registros[0] = f0115.getLflnty();
				registros[1] = f0115.getLflnds();
				registros[2] = f0115.getLfivi();
				registros[3] = f0115.getLfapi();
				registros[4] = f0115.getLfari();
				registros[5] = f0115.getLfgli();
				registros[6] = f0115.getLfpdc2();
				registros[7] = f0115.getLfglc();
				return registros;
			}
		};
		catalogo.setParent(catalogoF40205);
	}

	private void cargarUdc() {
		List<F0005> listF0005 = servicioF0005.buscarParaUDCOrdenados("H40",
				"IV");
		buscadorIvi = new BuscadorUDC("Interfaz Inventario", 1, listF0005,
				false, false, false,"H40",
				"IV") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H40", "IV",
						buscadorIvi.obtenerCaja());
			}
		};
		divBuscadorIvi.appendChild(buscadorIvi);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("41", "9");
		buscadorGltp = new BuscadorUDC("Compensacion LM", 4, listF0005, false,
				false, false,"41", "9") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("41", "9",
						buscadorGltp.obtenerCaja());
			}
		};
		divBuscadorGltp.appendChild(buscadorGltp);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("H00", "TV");
		buscadorTx01 = new BuscadorUDC("Incluir en impto 1", 1, listF0005,
				false, false, false,"H00", "TV") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H00", "TV",
						buscadorTx01.obtenerCaja());
			}
		};
		divBuscadorTx01.appendChild(buscadorTx01);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("H41", "CS");
		buscadorCsj = new BuscadorUDC("Col diario ventas", 1, listF0005, false,
				false, false,"H41", "CS") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H41", "CS",
						buscadorCsj.obtenerCaja());
			}
		};
		divBuscadorCsj.appendChild(buscadorCsj);
	}

}
