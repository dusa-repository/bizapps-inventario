package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.maestros.F0015;
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
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0015D extends CGenerico {

	@Wire
	private Div divVF0015D;
	@Wire
	private Div botoneraF0015D;
	@Wire
	private Groupbox gpxRegistroF0015D;
	@Wire
	private Textbox txtCRCDF0015D;
	@Wire
	private Textbox txtCRDCF0015D;
	@Wire
	private Datebox dtbEFTF0015D;
	@Wire
	private Doublespinner dblAN8F0015D;
	@Wire
	private Radiogroup rdgMetodoCalculoF0015D;
	@Wire
	private Radio rdoMetodoInversionF0015D;
	@Wire
	private Radio rdoSinMetodoF0015D;
	@Wire
	private Radio rdoMetodoTriangulacionF0015D;
	@Wire
	private Checkbox chxCambioContadoF0015D;
	@Wire
	private Textbox txtCRCMF0015D;
	@Wire
	private Label lblMetodoConversionF0015D;
	@Wire
	private Doublespinner dblCRRF0015D;
	@Wire
	private Doublespinner dblCRRDF0015D;
	@Wire
	private Groupbox gpxDatosF0015D;
	@Wire
	private Div catalogoF0015D;
	private static SimpleDateFormat formatoFecha = new SimpleDateFormat(
			"dd-MM-yyyy");

	Botonera botonera;
	Catalogo<F0015> catalogo;
	F0015PK clave = null;

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		txtCRCDF0015D.setFocus(true);
		mostrarCatalogo();

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F0015 f015 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f015.getId();
						txtCRCDF0015D.setValue(f015.getId().getCxcrcd());
						txtCRCDF0015D.setDisabled(true);
						txtCRDCF0015D.setValue(f015.getId().getCxcrdc());
						txtCRDCF0015D.setDisabled(true);
						dtbEFTF0015D
								.setValue((transformarJulianaAGregoria(BigDecimal
										.valueOf(f015.getId().getCxeft()))));
						dtbEFTF0015D.setDisabled(true);
						dblAN8F0015D.setValue(f015.getId().getCxan8());
						dblAN8F0015D.setDisabled(true);
						txtCRCMF0015D.setValue(f015.getCxcrcm());
						dblCRRF0015D.setValue(f015.getCxcrr());
						dblCRRDF0015D.setValue(f015.getCxcrrd());
						txtCRCMF0015D.setFocus(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
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
				mostrarBotones(false);

			}

			@Override
			public void guardar() {
				// TODO Auto-generated method stub
				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {
					String crcd = txtCRCDF0015D.getValue();
					String crdc = txtCRDCF0015D.getValue();
					String rttyp = "";
					long eft = Long.valueOf((String
							.valueOf(transformarGregorianoAJulia(dtbEFTF0015D
									.getValue()))));
					double an8 = dblAN8F0015D.getValue();
					String crcm = txtCRCMF0015D.getValue();
					double crr = dblCRRF0015D.getValue();
					double crrd = dblCRRDF0015D.getValue();
					F0015PK clave = new F0015PK();
					clave.setCxcrcd(crcd);
					clave.setCxcrdc(crdc);
					clave.setCxrttyp(rttyp);
					clave.setCxeft(eft);
					clave.setCxan8(an8);
					F0015 foo15 = new F0015();
					foo15.setId(clave);
					foo15.setCxcrcm(crcm);
					foo15.setCxcrr(crr);
					foo15.setCxcrrd(crrd);
					foo15.setCxuser("JDE");
					foo15.setCxupmj(transformarGregorianoAJulia(new Date()));
					foo15.setCxupmt(Double.parseDouble(horaAuditoria));
					servicioF0015.guardar(foo15);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF0015
							.buscarTodosOrdenados());
				}

			}

			@Override
			public void limpiar() {
				// TODO Auto-generated method stub
				mostrarBotones(false);
				limpiarCampos();
				clave = null;

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void salir() {
				// TODO Auto-generated method stub
				cerrarVentana(divVF0015D, "Sistema");
			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub
				if (gpxDatosF0015D.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F0015> eliminarLista = catalogo
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
													servicioF0015
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF0015
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
													servicioF0015
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF0015
															.buscarTodosOrdenados());
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
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF0015D.appendChild(botonera);

	}

	public void limpiarCampos() {
		clave = null;
		txtCRCDF0015D.setValue("");
		txtCRDCF0015D.setValue("");
		dtbEFTF0015D.setValue(null);
		dblAN8F0015D.setValue(null);
		rdgMetodoCalculoF0015D.setSelectedItem(null);
		chxCambioContadoF0015D.setChecked(false);
		txtCRCMF0015D.setValue("");
		lblMetodoConversionF0015D.setValue("");
		dblCRRF0015D.setValue(null);
		dblCRRDF0015D.setValue(null);

	}

	public boolean camposLLenos() {
		if (txtCRCDF0015D.getText().compareTo("") == 0
				|| txtCRDCF0015D.getText().compareTo("") == 0
				|| dtbEFTF0015D.getText().compareTo("") == 0
				|| dblAN8F0015D.getText().compareTo("") == 0
				|| (rdoMetodoInversionF0015D.isChecked() == false
						&& rdoSinMetodoF0015D.isChecked() == false && rdoMetodoTriangulacionF0015D
						.isChecked() == false)
				|| txtCRCMF0015D.getText().compareTo("") == 0
				|| dblCRRF0015D.getText().compareTo("") == 0
				|| dblCRRDF0015D.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtCRCDF0015D.getText().compareTo("") != 0
				|| txtCRDCF0015D.getText().compareTo("") != 0
				|| dtbEFTF0015D.getText().compareTo("") != 0
				|| dblAN8F0015D.getText().compareTo("") != 0
				|| (rdoMetodoInversionF0015D.isChecked() != false
						|| rdoSinMetodoF0015D.isChecked() != false || rdoMetodoTriangulacionF0015D
						.isChecked() != false)
				|| txtCRCMF0015D.getText().compareTo("") != 0
				|| dblCRRF0015D.getText().compareTo("") != 0
				|| dblCRRDF0015D.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
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

	public boolean validarSeleccion() {
		List<F0015> seleccionados = catalogo.obtenerSeleccionados();
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

	@Listen("onClick = #gpxRegistroF0015D")
	public void abrirRegistro() {
		gpxDatosF0015D.setOpen(false);
		gpxRegistroF0015D.setOpen(true);
		mostrarBotones(false);
	}

	@Listen("onOpen = #gpxDatosF0015D")
	public void abrirCatalogo() {
		gpxDatosF0015D.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF0015D.setOpen(false);
								gpxRegistroF0015D.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF0015D.setOpen(true);
									gpxRegistroF0015D.setOpen(false);
									limpiarCampos();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF0015D.setOpen(true);
			gpxRegistroF0015D.setOpen(false);
			mostrarBotones(true);
		}
	}

	public void mostrarCatalogo() {
		final List<F0015> listF0015 = servicioF0015.buscarTodosOrdenados();
		catalogo = new Catalogo<F0015>(catalogoF0015D, "F0015", listF0015,
				"Fecha efectiva", "Método cálculo", "Método conv",
				"Tipo multiplicador", "Tipo divisor", "Mon Trian",
				"Tipo tringulación paso1", "Tipo triangulación paso2",
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
		catalogo.setParent(catalogoF0015D);
	}
}
