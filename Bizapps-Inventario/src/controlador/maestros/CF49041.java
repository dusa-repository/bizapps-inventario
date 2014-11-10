package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F0008;
import modelo.maestros.F0010;
import modelo.maestros.F0013;
import modelo.maestros.F0101;
import modelo.maestros.F40203;
import modelo.maestros.F4100;
import modelo.maestros.F4105;
import modelo.maestros.F49041;
import modelo.pk.F0005PK;
import modelo.pk.F0008PK;
import modelo.pk.F49041PK;
import modelo.transacciones.F4111;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF49041 extends CGenerico {

	private static final long serialVersionUID = 4858496432716297913L;
	@Wire
	private Div divVF49041;
	@Wire
	private Div botoneraF49041;
	@Wire
	private Textbox txtSTFNF49041;
	@Wire
	private Button btnBuscarF0101;
	@Wire
	private Label lblF0101;
	@Wire
	private Textbox txtVEHIF49041;
	@Wire
	private Button btnBuscarF4930;
	@Wire
	private Label lblF4930;
	@Wire
	private Datebox dtbEFTJF49041;
	@Wire
	private Div divBuscadorSHFTF49041;
	@Wire
	private Textbox txtMCU49041;
	@Wire
	private Button btnBuscarF0011;
	@Wire
	private Label lblF0011;
	@Wire
	private Div divCatalogoF49041;
	@Wire
	private Div divCatalogoF0101;
	@Wire
	private Div divCatalogoF4930;
	@Wire
	private Div divCatalogoF0011;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;

	private static SimpleDateFormat formatoFecha = new SimpleDateFormat(
			"dd-MM-yyyy");

	Botonera botonera;
	Catalogo<F49041> catalogo;
	Catalogo<F0101> catalogoF0101;
	// Catalogo<F0011> catalogoF0011; falta crear

	BuscadorUDC buscadorSHFT;

	F49041PK clave = null;

	@Override
	public void inicializar() throws IOException {
		HashMap<String, Object> map = (HashMap<String, Object>) Sessions
				.getCurrent().getAttribute("mapaGeneral");
		if (map != null) {
			if (map.get("tabsGenerales") != null) {
				tabs = (List<Tab>) map.get("tabsGenerales");
				map.clear();
				map = null;
			}
		}

		txtSTFNF49041.setFocus(true);
		mostrarCatalogo();

		List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("06",
				"SH");

		buscadorSHFT = new BuscadorUDC("Cd turno", 10, listaF0005, true, false,
				false, "06", "SH") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("06", "SH",
						buscadorSHFT.obtenerCaja());
			}
		};

		divBuscadorSHFTF49041.appendChild(buscadorSHFT);
		botonera = new Botonera() {

			@Override
			public void seleccionar() {

				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F49041 f49041 = catalogo
								.objetoSeleccionadoDelCatalogo();
						clave = f49041.getId();
						txtSTFNF49041.setValue(String.valueOf(f49041.getId()
								.getVsstfn()));
						lblF0101.setValue("");
						txtVEHIF49041.setValue(f49041.getVsvehi());
						if (f49041.getVsvehi() != null)
							lblF4930.setValue("");
						dtbEFTJF49041
								.setValue((transformarJulianaAGregoria(BigDecimal
										.valueOf(f49041.getId().getVseftj()))));
						buscadorSHFT.settearCampo(servicioF0005.buscar("06",
								"SH", f49041.getId().getVsshft()));
						txtMCU49041.setValue(f49041.getVsmcu());
						lblF0011.setValue("");
						txtSTFNF49041.setFocus(true);

					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}

			}

			@Override
			public void salir() {
				cerrarVentana(divVF49041, "Configuracion de Choferes", tabs);

			}

			@Override
			public void reporte() {
			}

			@Override
			public void limpiar() {
				clave = null;
				mostrarBotones(false);
				limpiarCampos();
				habilitarTextClave();

			}

			@Override
			public void guardar() {

				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {

					double stfn = Double.valueOf(txtSTFNF49041.getValue());
					String shft = buscadorSHFT.obtenerCaja();
					long eftj = Long.valueOf((String
							.valueOf(transformarGregorianoAJulia(dtbEFTJF49041
									.getValue()))));
					String vehi = txtVEHIF49041.getValue();
					String mcu = txtMCU49041.getValue();

					F49041PK clave = new F49041PK();
					clave.setVseftj(eftj);
					clave.setVsshft(shft);
					clave.setVsstfn(stfn);
					F49041 f49041 = new F49041();
					f49041.setId(clave);
					f49041.setVsvehi(vehi);
					f49041.setVsmcu(mcu);
					f49041.setVsuser("JDE");
					f49041.setVsupmj(transformarGregorianoAJulia(new Date()));
					servicioF49041.guardar(f49041);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF49041
							.buscarTodosOrdenados());
				}

			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F49041> eliminarLista = catalogo
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
													servicioF49041
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF49041
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
													servicioF49041
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF49041
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
			}

			@Override
			public void ayuda() {

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
		botoneraF49041.appendChild(botonera);

	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	public void limpiarCampos() {

		clave = null;
		txtSTFNF49041.setValue("");
		lblF0101.setValue("");
		txtVEHIF49041.setValue("");
		lblF4930.setValue("");
		dtbEFTJF49041.setValue(null);
		buscadorSHFT.settearCampo(null);
		txtMCU49041.setValue("");
		lblF0011.setValue("");
		catalogo.limpiarSeleccion();
		txtSTFNF49041.setFocus(true);

	}

	public void habilitarTextClave() {

	}

	public boolean validarSeleccion() {
		List<F49041> seleccionados = catalogo.obtenerSeleccionados();
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

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
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
									habilitarTextClave();
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

		final List<F49041> choferes = servicioF49041.buscarTodosOrdenados();
		catalogo = new Catalogo<F49041>(divCatalogoF49041, "F49041", choferes,
				false, false, true, "N° empleado", "Nombre empleado",
				"Depósito", "Tipo pto", "Descripción del empleo",
				"ID vehículo", "turno", "Fecha efectiva", "Fecha vto") {

			@Override
			protected List<F49041> buscar(List<String> valores) {

				List<F49041> chofer = new ArrayList<F49041>();

				for (F49041 choferesv : choferes) {
					if (String.valueOf(choferesv.getId().getVsstfn())
							.toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& String.valueOf(choferesv.getId().getVsstfn())
									.toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& choferesv.getVsmcu().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& choferesv.getVsjbcd().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& choferesv.getVsjbcd().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& choferesv.getVsvehi().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& choferesv.getId().getVsshft().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(BigDecimal
											.valueOf(choferesv.getId()
													.getVseftj())))
									.toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(choferesv
											.getVsexdj())).toLowerCase()
									.contains(valores.get(8).toLowerCase())) {
						chofer.add(choferesv);
					}
				}
				return chofer;
			}

			@Override
			protected String[] crearRegistros(F49041 f49041) {
				String[] registros = new String[9];
				registros[0] = String.valueOf(f49041.getId().getVsstfn());
				registros[1] = String.valueOf(f49041.getId().getVsstfn());
				registros[2] = f49041.getVsmcu();
				registros[3] = f49041.getVsjbcd();
				registros[4] = f49041.getVsjbcd();
				registros[5] = f49041.getVsvehi();
				registros[6] = f49041.getId().getVsshft();
				if (f49041.getId().getVseftj() != 0)
					registros[7] = formatoFecha
							.format(transformarJulianaAGregoria(BigDecimal
									.valueOf(f49041.getId().getVseftj())));
				if (f49041.getVsexdj() != null)
					registros[8] = formatoFecha
							.format(transformarJulianaAGregoria(f49041
									.getVsexdj()));

				return registros;
			}
		};
		catalogo.setParent(divCatalogoF49041);
		// catalogo.doModal();

	}

	@Listen("onClick = #btnBuscarF0101")
	public void mostrarCatalogoF0101() {
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoF0101 = new Catalogo<F0101>(divCatalogoF0101, "F0101",
				listF0101, true, false, false, "Nº direccion",
				"Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal") {

			@Override
			protected List<F0101> buscar(List<String> valores) {

				List<F0101> lista = new ArrayList<F0101>();

				for (F0101 f01 : listF0101) {
					if (String.valueOf(f01.getAban8()).toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f01.getAbalph().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& f01.getAbalky().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& f01.getAbsic().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f01.getAbat1().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& f01.getAbtax().toLowerCase()
									.contains(valores.get(5).toLowerCase())) {
						lista.add(f01);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0101 f013) {
				String[] registros = new String[6];
				registros[0] = String.valueOf(f013.getAban8().longValue());
				registros[1] = f013.getAbalph();
				registros[2] = f013.getAbalky();
				registros[3] = f013.getAbsic();
				registros[4] = f013.getAbat1();
				registros[5] = f013.getAbtax();
				return registros;
			}
		};
		catalogoF0101.setParent(divCatalogoF0101);
		catalogoF0101.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0101")
	public void seleccionF0101() {
		F0101 f0101 = catalogoF0101.objetoSeleccionadoDelCatalogo();
		txtSTFNF49041.setValue(f0101.getAbab3());
		lblF0101.setValue("");
		catalogoF0101.setParent(null);
	}

	public boolean camposLLenos() {
		if (txtSTFNF49041.getText().compareTo("") == 0
				|| buscadorSHFT.obtenerCaja().compareTo("") == 0
				|| dtbEFTJF49041.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtSTFNF49041.getText().compareTo("") != 0
				|| txtVEHIF49041.getText().compareTo("") != 0
				|| dtbEFTJF49041.getText().compareTo("") != 0
				|| buscadorSHFT.obtenerCaja().compareTo("") != 0
				|| txtMCU49041.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	protected boolean validar() {

		if (!camposLLenos()) {
			msj.mensajeAlerta(Mensaje.camposVacios);
			return false;
		} else
			return true;

	}

}