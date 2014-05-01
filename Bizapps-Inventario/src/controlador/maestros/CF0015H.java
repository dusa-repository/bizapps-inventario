package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
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
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0015H extends CGenerico {

	@Wire
	private Div divVF0015H;
	@Wire
	private Div botoneraF0015H;
	@Wire
	private Groupbox gpxRegistroF0015H;
	@Wire
	private Textbox txtCRCDF0015H;
	@Wire
	private Button btnBuscarCRCDF0015H;
	@Wire
	private Textbox txtCRDCF0015H;
	@Wire
	private Button btnBuscarCRDCF0015H;
	@Wire
	private Datebox dtbEFTF0015H;
	@Wire
	private Doublespinner dblAN8F0015H;
	@Wire
	private Button btnBuscarAN8F0015H;
	@Wire
	private Groupbox gpxDatosF0015H;
	@Wire
	private Div catalogoF0015H;
	private static F0013 F0013;

	Botonera botonera;
	Catalogo<F0015> catalogo;
	F0015PK clave = null;

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		txtCRCDF0015H.setFocus(true);
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
						txtCRCDF0015H.setValue(f015.getId().getCxcrcd());
						txtCRCDF0015H.setDisabled(true);
						btnBuscarCRCDF0015H.setDisabled(true);
						txtCRDCF0015H.setValue(f015.getId().getCxcrdc());
						txtCRDCF0015H.setDisabled(true);
						btnBuscarCRDCF0015H.setDisabled(true);
						dtbEFTF0015H
								.setValue((transformarJulianaAGregoria(BigDecimal
										.valueOf(f015.getId().getCxeft()))));
						dtbEFTF0015H.setDisabled(true);
						dblAN8F0015H.setValue(f015.getId().getCxan8());
						dblAN8F0015H.setDisabled(true);
						btnBuscarAN8F0015H.setDisabled(true);
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
					String crcd = txtCRCDF0015H.getValue();
					String crdc = txtCRDCF0015H.getValue();
					String rttyp = "";
					long eft = Long.valueOf((String
							.valueOf(transformarGregorianoAJulia(dtbEFTF0015H
									.getValue()))));
					double an8 = dblAN8F0015H.getValue();
					F0015PK clave = new F0015PK();
					clave.setCxcrcd(crcd);
					clave.setCxcrdc(crdc);
					clave.setCxrttyp(rttyp);
					clave.setCxeft(eft);
					clave.setCxan8(an8);
					F0015 foo15 = new F0015();
					foo15.setId(clave);
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
				cerrarVentana(divVF0015H, "Sistema");
			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub
				if (gpxDatosF0015H.isOpen()) {
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
		botoneraF0015H.appendChild(botonera);

	}

	public void limpiarCampos() {
		clave = null;
		txtCRCDF0015H.setValue("");
		txtCRDCF0015H.setValue("");
		dtbEFTF0015H.setValue(null);
		dblAN8F0015H.setValue(null);
		txtCRCDF0015H.setFocus(true);
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

	@Listen("onClick = #gpxRegistroF0015H")
	public void abrirRegistro() {
		gpxDatosF0015H.setOpen(false);
		gpxRegistroF0015H.setOpen(true);
		mostrarBotones(false);
	}

	@Listen("onOpen = #gpxDatosF0015H")
	public void abrirCatalogo() {
		gpxDatosF0015H.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF0015H.setOpen(false);
								gpxRegistroF0015H.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF0015H.setOpen(true);
									gpxRegistroF0015H.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF0015H.setOpen(true);
			gpxRegistroF0015H.setOpen(false);
			mostrarBotones(true);
		}
	}

	public void habilitarTextClave() {
		if (txtCRCDF0015H.isDisabled())
			txtCRCDF0015H.setDisabled(false);
		if (txtCRDCF0015H.isDisabled())
			txtCRDCF0015H.setDisabled(false);
		if (dtbEFTF0015H.isDisabled())
			dtbEFTF0015H.setDisabled(false);
		if (dblAN8F0015H.isDisabled())
			dblAN8F0015H.setDisabled(false);
		if (btnBuscarCRCDF0015H.isDisabled())
			btnBuscarCRCDF0015H.setDisabled(false);
		if (btnBuscarCRDCF0015H.isDisabled())
			btnBuscarCRDCF0015H.setDisabled(false);
		if (btnBuscarAN8F0015H.isDisabled())
			btnBuscarAN8F0015H.setDisabled(false);

	}

	public boolean camposLLenos() {
		if (txtCRCDF0015H.getText().compareTo("") == 0
				|| txtCRDCF0015H.getText().compareTo("") == 0
				|| dtbEFTF0015H.getText().compareTo("") == 0
				|| dblAN8F0015H.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtCRCDF0015H.getText().compareTo("") != 0
				|| txtCRDCF0015H.getText().compareTo("") != 0
				|| dtbEFTF0015H.getText().compareTo("") != 0
				|| dblAN8F0015H.getText().compareTo("") != 0) {
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

	public void mostrarCatalogo() {
		final List<F0015> listF0015 = servicioF0015.buscarTodosOrdenados();
		catalogo = new Catalogo<F0015>(catalogoF0015H, "F0015", listF0015,
				"Moneda origen", "Descripción moneda origen", "Moneda destino",
				"Descripción moneda destino", "Contrato (dirección)",
				"Descripción contrato (dirección)") {

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
		catalogo.setParent(catalogoF0015H);
	}

}
