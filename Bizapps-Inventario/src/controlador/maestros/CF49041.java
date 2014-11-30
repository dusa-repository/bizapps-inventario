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
import modelo.maestros.F0101;
import modelo.maestros.F49041;
import modelo.maestros.F4930;
import modelo.pk.F49041PK;

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
import componentes.buscadores.BuscadorUDC;
import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;

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
	private Button btnBuscarF0006;
	@Wire
	private Label lblF0006;
	@Wire
	private Div divCatalogoF49041;
	@Wire
	private Div divCatalogoF0101;
	@Wire
	private Div divCatalogoF4930;
	@Wire
	private Div divCatalogoF0006;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;

	private static SimpleDateFormat formatoFecha = new SimpleDateFormat(
			"dd-MM-yyyy");
	protected List<F49041> listaGeneral = new ArrayList<F49041>();

	Botonera botonera;
	CatalogoGenerico<F49041> catalogo;
	CatalogoGenerico<F0101> catalogoF0101;
	CatalogoGenerico<F4930> catalogoF4930;
	CatalogoGenerico<F0006> catalogoF0006;

	BuscadorUDC buscadorSHFT;

	F49041PK clave = null;

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

		txtSTFNF49041.setFocus(true);
		mostrarCatalogo();

		List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("06",
				"SH");

		buscadorSHFT = new BuscadorUDC("Cd turno", 10, true, "06", "SH",
				servicioF0005, "27%", "10%", "7%", "42%") {
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

						F0006 f0006 = servicioF0006.buscar(f49041.getVsmcu());
						F4930 f4930 = servicioF4930.buscar(f49041.getVsvehi());
						F0101 f0101 = servicioF0101.buscar(f49041.getId()
								.getVsstfn());

						clave = f49041.getId();

						txtSTFNF49041.setValue(String.valueOf(Math.round(f49041
								.getId().getVsstfn())));

						if (f0101 != null) {
							if (f0101.getAbalph() != null)
								lblF0101.setValue(f0101.getAbalph());
						}

						txtVEHIF49041.setValue(f49041.getVsvehi());

						if (f4930 != null) {
							if (f4930.getVmdl01() != null)
								lblF4930.setValue(f4930.getVmdl01());

						}

						dtbEFTJF49041
								.setValue((transformarJulianaAGregoria(BigDecimal
										.valueOf(f49041.getId().getVseftj()))));
						buscadorSHFT.settearModelo(servicioF0005.buscar("06",
								"SH", f49041.getId().getVsshft()));

						txtMCU49041.setValue(f49041.getVsmcu());
						if (f0006 != null) {
							if (f0006.getMcdl01() != null)
								lblF0006.setValue(f0006.getMcdl01());
						}

						txtSTFNF49041.setFocus(true);

					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}

			}

			@Override
			public void salir() {
				cerrarVentana(divVF49041, titulo, tabs);

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

				if (validar()) {

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
					listaGeneral = servicioF49041.buscarTodosOrdenados();
					catalogo.actualizarLista(listaGeneral);
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
													listaGeneral = servicioF49041
															.buscarTodosOrdenados();
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
													servicioF49041
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													listaGeneral = servicioF49041
															.buscarTodosOrdenados();
													catalogo.actualizarLista(listaGeneral);
												}
											}
										});
					} else
						msj.mensajeAlerta(Mensaje.noSeleccionoRegistro);
				}
			}

			@Override
			public void buscar() {

				abrirCatalogo();

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
		txtSTFNF49041.setValue("");
		lblF0101.setValue("");
		txtVEHIF49041.setValue("");
		lblF4930.setValue("");
		dtbEFTJF49041.setValue(null);
		buscadorSHFT.settearCampo(null);
		txtMCU49041.setValue("");
		lblF0006.setValue("");
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

		listaGeneral = servicioF49041.buscarTodosOrdenados();
		catalogo = new CatalogoGenerico<F49041>(divCatalogoF49041, "F49041",
				listaGeneral, false, true, true, "N° empleado",
				"Nombre empleado", "Depósito","ID vehículo", "turno",
				"Fecha efectiva", "Fecha vto") {

			@Override
			protected List<F49041> buscar(List<String> valores) {

				List<F49041> chofer = new ArrayList<F49041>();

				for (F49041 choferesv : listaGeneral) {
					if (String.valueOf(choferesv.getId().getVsstfn())
							.toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& String.valueOf(choferesv.getId().getVsstfn())
									.toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& choferesv.getVsmcu().toLowerCase()
									.contains(valores.get(2).toLowerCase())	
							&& choferesv.getVsvehi().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& choferesv.getId().getVsshft().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(BigDecimal
											.valueOf(choferesv.getId()
													.getVseftj())))
									.toLowerCase()
									.contains(valores.get(5).toLowerCase())) {
						chofer.add(choferesv);
					}
				}
				return chofer;
			}

			@Override
			protected String[] crearRegistros(F49041 f49041) {
				String[] registros = new String[7];
				registros[0] = String.valueOf(f49041.getId().getVsstfn());
				registros[1] = String.valueOf(f49041.getId().getVsstfn());
				registros[2] = f49041.getVsmcu();
				registros[3] = f49041.getVsvehi();
				registros[4] = f49041.getId().getVsshft();
				if (f49041.getId().getVseftj() != 0)
					registros[5] = formatoFecha
							.format(transformarJulianaAGregoria(BigDecimal
									.valueOf(f49041.getId().getVseftj())));
				else
					registros[5] = "";
				if (f49041.getVsexdj() != null)
					registros[6] = formatoFecha
							.format(transformarJulianaAGregoria(f49041
									.getVsexdj()));
				else
					registros[6] = "";

				return registros;
			}
		};
		catalogo.setParent(divCatalogoF49041);

	}

	@Listen("onClick = #btnBuscarF0101")
	public void mostrarCatalogoF0101() {
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoF0101 = new CatalogoGenerico<F0101>(divCatalogoF0101,
				"Catalogo de Direcciones", listF0101, true, false, false,
				"Nº direccion", "Nombre alfabetico", "Direccion larga",
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
		txtSTFNF49041.setValue(String.valueOf(Math.round(f0101.getAban8())));
		lblF0101.setValue(f0101.getAbalph());
		catalogoF0101.setParent(null);
	}

	@Listen("onChange = #txtSTFNF49041; onOk = #txtSTFNF49041")
	public boolean buscarDireccion() {
		if (txtSTFNF49041.getValue() != null) {
			F0101 f0101 = servicioF0101.buscar(Double.parseDouble(txtSTFNF49041
					.getValue()));
			if (f0101 != null) {
				Double doble = f0101.getAban8();
				txtSTFNF49041.setValue(String.valueOf(doble.longValue()));
				lblF0101.setValue(f0101.getAbalph());
				return true;
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				return false;
			}
		} else
			return false;
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

	@Listen("onClick = #btnBuscarF4930")
	public void mostrarCatalogoVehiculo() {
		final List<F4930> vehiculos = servicioF4930.buscarTodosOrdenados();
		catalogoF4930 = new CatalogoGenerico<F4930>(divCatalogoF4930,
				"Catalogo de Vehiculos", vehiculos, true, false, false,
				"ID vehículo", "Tip veh", "Descripción", "Sucursal/planta",
				"N° de prop", "V/F", "N° serie veh", "Cap peso", "UM ps",
				"Capacidad en vol cúbicos", "UM") {

			@Override
			protected List<F4930> buscar(List<String> valores) {

				List<F4930> tvehiculo = new ArrayList<F4930>();

				for (F4930 tvehiculos : vehiculos) {
					if (tvehiculos.getVmvehi().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& tvehiculos.getVmvtyp().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& tvehiculos.getVmdl01().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& tvehiculos.getVmmcu().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& String.valueOf(tvehiculos.getVmvown())
									.toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& tvehiculos.getVmdumv().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& tvehiculos.getVmvehs().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& String.valueOf(tvehiculos.getVmwtca())
									.toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& tvehiculos.getVmwtum().toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& String.valueOf(tvehiculos.getVmcvol())
									.toLowerCase()
									.contains(valores.get(9).toLowerCase())
							&& tvehiculos.getVmcvum().toLowerCase()
									.contains(valores.get(10).toLowerCase())) {
						tvehiculo.add(tvehiculos);
					}
				}
				return tvehiculo;
			}

			@Override
			protected String[] crearRegistros(F4930 f4930) {
				String[] registros = new String[11];
				registros[0] = f4930.getVmvehi();
				registros[1] = f4930.getVmvtyp();
				registros[2] = f4930.getVmdl01();
				registros[3] = f4930.getVmmcu();
				registros[4] = String.valueOf(f4930.getVmvown());
				registros[5] = f4930.getVmdumv();
				registros[6] = f4930.getVmvehs();
				registros[7] = String.valueOf(f4930.getVmwtca());
				registros[8] = f4930.getVmwtum();
				registros[9] = String.valueOf(f4930.getVmcvol());
				registros[10] = f4930.getVmcvum();

				return registros;
			}
		};
		catalogoF4930.setParent(divCatalogoF4930);
		catalogoF4930.doModal();

	}

	@Listen("onSeleccion = #divCatalogoF4930")
	public void seleccionF4930() {
		F4930 f4930 = catalogoF4930.objetoSeleccionadoDelCatalogo();
		txtVEHIF49041.setValue(f4930.getVmvehi());
		lblF4930.setValue(f4930.getVmdl01());
		catalogoF4930.setParent(null);
	}

	@Listen("onChange = #txtVEHIF49041; onOk = #txtVEHIF49041")
	public boolean buscarVehiculo() {
		if (txtVEHIF49041.getValue() != null) {
			F4930 f4930 = servicioF4930.buscar(txtVEHIF49041.getValue());
			if (f4930 != null) {
				txtVEHIF49041.setValue(f4930.getVmvehi());
				lblF4930.setValue(f4930.getVmdl01());
				return true;
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				return false;
			}
		} else
			return false;
	}

	@Listen("onClick = #btnBuscarF0006")
	public void mostrarCatalogoF0006() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoF0006 = new CatalogoGenerico<F0006>(divCatalogoF0006,
				"Catalogo de Unidades de Negocio", unidades, true, false,
				false, "Unidad Negocio", "Descripcion", "Nivel det", "Cta",
				"Tipo UN", "LM Auxiliar Inactivo", "Mto Cons", "CAT 01",
				"CAT 02", "CAT 03", "CAT 04", "CAT 05", "CAT 06") {

			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					String mcdc = "";
					if (unidad.getMcdc() != null)
						mcdc = unidad.getMcdc();
					if (unidad.getMcmcu().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& mcdc.toLowerCase().contains(
									valores.get(1).toLowerCase())
							&& unidad.getMcldm().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& unidad.getMcco().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& unidad.getMcstyl().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& unidad.getMcfmod().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& unidad.getMcsbli().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& unidad.getMcrp01().toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& unidad.getMcrp02().toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& unidad.getMcrp03().toLowerCase()
									.contains(valores.get(9).toLowerCase())
							&& unidad.getMcrp04().toLowerCase()
									.contains(valores.get(10).toLowerCase())
							&& unidad.getMcrp05().toLowerCase()
									.contains(valores.get(11).toLowerCase())
							&& unidad.getMcrp06().toLowerCase()
									.contains(valores.get(12).toLowerCase())) {
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
		catalogoF0006.setParent(divCatalogoF0006);
		catalogoF0006.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0006")
	public void seleccionF0006() {
		F0006 f0006 = catalogoF0006.objetoSeleccionadoDelCatalogo();
		txtMCU49041.setValue(String.valueOf(f0006.getMcmcu()));
		lblF0006.setValue(f0006.getMcdl01());
		catalogoF0006.setParent(null);
	}

	@Listen("onChange = #txtMCU49041; onOk =  #txtMCU49041")
	public boolean idF0006() {
		if (txtMCU49041.getText().compareTo("") != 0) {
			F0006 f0006 = servicioF0006.buscar(txtMCU49041.getText());
			if (f0006 != null) {
				txtMCU49041.setValue(String.valueOf(f0006.getMcmcu()));
				lblF0006.setValue(f0006.getMcdl01());
				return true;
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				return false;
			}

		} else
			return false;
	}

}