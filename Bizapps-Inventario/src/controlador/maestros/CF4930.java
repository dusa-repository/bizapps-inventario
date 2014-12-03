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
import modelo.maestros.F0010;
import modelo.maestros.F0013;
import modelo.maestros.F0015;
import modelo.maestros.F0101;
import modelo.maestros.F49041;
import modelo.maestros.F4930;
import modelo.maestros.F4931;

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

public class CF4930 extends CGenerico {

	private static final long serialVersionUID = 4858496432716297913L;
	@Wire
	private Div divVF4930;
	@Wire
	private Div botoneraF4930;
	@Wire
	private Textbox txtVEHIF4930;
	@Wire
	private Textbox txtMCUF4930;
	@Wire
	private Button btnBuscarMCUF0006;
	@Wire
	private Label lblF0006;
	@Wire
	private Textbox txtDL01F4930;
	@Wire
	private Textbox txtVEHSF4930;
	@Wire
	private Textbox txtVTYPF4931;
	@Wire
	private Button btnBuscarVTYPF4931;
	@Wire
	private Label lblF4931;
	@Wire
	private Textbox txtVOWNF0101;
	@Wire
	private Button btnBuscarVOWNF0101;
	@Wire
	private Label lblF0101;
	@Wire
	private Groupbox gpxPeso;
	@Wire
	private Div divBuscadorWTUMF;
	BuscadorUDC buscadorWtumf;
	@Wire
	private Textbox txtWTEMF4930;
	@Wire
	private Textbox txtCapacidadPesoF4930;
	@Wire
	private Textbox txtBrutoF4930;
	@Wire
	private Groupbox gpxVolumen;
	@Wire
	private Div divBuscadorCVUMF;
	BuscadorUDC buscadorCvumf;
	@Wire
	private Textbox txtCapacidadVolumenF4930;
	@Wire
	private Div divCatalogoF4930;
	@Wire
	private Div divCatalogoF4931;
	@Wire
	private Div divCatalogoF0101;
	@Wire
	private Div divCatalogoF0006;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;

	private static SimpleDateFormat formatoFecha = new SimpleDateFormat(
			"dd-MM-yyyy");
	protected List<F4930> listaGeneral = new ArrayList<F4930>();

	String clave = null;

	Botonera botonera;
	CatalogoGenerico<F4930> catalogo;
	CatalogoGenerico<F0101> catalogoF0101;
	CatalogoGenerico<F4931> catalogoF4931;
	CatalogoGenerico<F0006> catalogoF0006;

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

		List<F0005> listF0005 = servicioF0005
				.buscarParaUDCOrdenados("UM", "00");
		buscadorWtumf = new BuscadorUDC("UM", 19, false, "UM", "00",
				servicioF0005, "26%", "7%", "7%", "41%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "HI",
						buscadorWtumf.obtenerCaja());
			}
		};
		divBuscadorWTUMF.appendChild(buscadorWtumf);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("UM", "00");
		buscadorCvumf = new BuscadorUDC("UM", 3, false, "UM", "00",
				servicioF0005, "26%", "7%", "7%", "41%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "CF",
						buscadorCvumf.obtenerCaja());
			}
		};
		divBuscadorCVUMF.appendChild(buscadorCvumf);

		txtVEHIF4930.setFocus(true);
		mostrarCatalogo();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {

				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {

						mostrarBotones(false);
						abrirRegistro();
						F4930 f4930 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f4930.getVmvehi();

						F0101 f0101 = servicioF0101.buscar(f4930.getVmvown());
						F0006 f0006 = servicioF0006.buscar(f4930.getVmmcu());
						F4931 f4931 = servicioF4931.buscar(f4930.getVmvtyp());

						txtVEHIF4930.setValue(f4930.getVmvehi());

						if (f4931 != null) {
							txtVTYPF4931.setValue(f4931.getVgvtyp());
							lblF4931.setValue(f4931.getVgdl01());
							txtCapacidadPesoF4930.setValue(String.valueOf(Math
									.round(f4931.getVgwtca())));
							txtBrutoF4930.setValue(String.valueOf(Math
									.round(f4931.getVgwtem())));
							txtCapacidadVolumenF4930
									.setValue(f4931.getVgdsgp());

						}

						txtMCUF4930.setValue(f4930.getVmmcu());

						if (f0006 != null) {
							if (f0006.getMcdl01() != null)
								lblF0006.setValue(f0006.getMcdl01());

						}

						txtDL01F4930.setValue(f4930.getVmdl01());
						txtVEHSF4930.setValue(f4930.getVmvehs());
						txtVOWNF0101.setValue(String.valueOf(Math.round(f4930
								.getVmvown())));

						if (f0101 != null) {
							if (f0101.getAbalph() != null)
								lblF0101.setValue(f0101.getAbalph());
						}

						txtWTEMF4930
								.setValue(String.valueOf(f4930.getVmwtem()));

						if (f4930.getVmwtum().compareTo("") != 0)
							buscadorWtumf.settearModelo(servicioF0005.buscar(
									"UM", "00", f4930.getVmwtum()));

						if (f4930.getVmcvum().compareTo("") != 0)
							buscadorCvumf.settearModelo(servicioF0005.buscar(
									"UM", "00", f4930.getVmcvum()));

						txtVEHIF4930.setFocus(true);

					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}

			}

			@Override
			public void salir() {
				cerrarVentana(divVF4930, titulo, tabs);

			}

			@Override
			public void reporte() {
			}

			@Override
			public void limpiar() {
				clave = null;
				mostrarBotones(false);
				limpiarCampos();

			}

			@Override
			public void guardar() {

				if (validar()) {

					F4930 f4930 = new F4930();
					f4930.setVmvehi(txtVEHIF4930.getValue());
					f4930.setVmdl01(txtDL01F4930.getValue());
					f4930.setVmmcu(txtMCUF4930.getValue());
					f4930.setVmvehs(txtVEHSF4930.getValue());
					f4930.setVmvtyp(txtVTYPF4931.getValue());
					if (txtVOWNF0101.getText().compareTo("") != 0)
						f4930.setVmvown(Double.valueOf(txtVOWNF0101.getValue()));
					f4930.setVmwtum(buscadorWtumf.obtenerCaja());
					if (txtWTEMF4930.getText().compareTo("") != 0)
						f4930.setVmwtem(Double.valueOf(txtWTEMF4930.getValue()));
					f4930.setVmcvum(buscadorCvumf.obtenerCaja());
					f4930.setVmuser("JDE");
					f4930.setVmupmj(transformarGregorianoAJulia(new Date()));
					servicioF4930.guardar(f4930);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					listaGeneral = servicioF4930.buscarTodosOrdenados();
					catalogo.actualizarLista(listaGeneral);
				}

			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F4930> eliminarLista = catalogo
								.obtenerSeleccionados();
						final int cantidad = eliminarLista.size();
						for (int i = 0; i < eliminarLista.size(); i++) {
							F4930 valor = eliminarLista.get(i);
							List<F49041> objeto = servicioF49041
									.buscarPorVsvehi(valor.getVmvehi());

							if (!objeto.isEmpty()) {
								eliminarLista.remove(valor);
								i--;
							}
						}
						if (!eliminarLista.isEmpty()) {
							Messagebox
									.show("¿Desea Eliminar los "
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
														servicioF4930
																.eliminarVarios(eliminarLista);
														listaGeneral = servicioF4930
																.buscarTodosOrdenados();
														catalogo.actualizarLista(listaGeneral);
														if (cantidad != eliminarLista
																.size())
															Mensaje.mensajeInformacion(Mensaje.algunosEliminados);
														else
															Mensaje.mensajeInformacion(Mensaje.eliminado);
													}
												}
											});
						} else {
							Mensaje.mensajeAlerta(Mensaje.registroUtilizado);
						}
					}
				} else {
					/* Elimina un solo registro */
					if (clave != null) {
						List<F49041> objeto = servicioF49041
								.buscarPorVsvehi(clave);
						if (objeto.isEmpty()) {
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
														servicioF0013
																.eliminarUno(clave);
														Mensaje.mensajeInformacion(Mensaje.eliminado);
														limpiar();
														listaGeneral = servicioF4930
																.buscarTodosOrdenados();
														catalogo.actualizarLista(listaGeneral);
													}
												}
											});
						} else {
							Mensaje.mensajeAlerta(Mensaje.registroUtilizado);
						}
					} else
						Mensaje.mensajeAlerta(Mensaje.noSeleccionoRegistro);
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
		botoneraF4930.appendChild(botonera);

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
		txtVEHIF4930.setValue("");
		txtMCUF4930.setValue("");
		lblF0006.setValue("");
		txtDL01F4930.setValue("");
		txtVEHSF4930.setValue("");
		txtVTYPF4931.setValue("");
		lblF4931.setValue("");
		txtVOWNF0101.setValue("");
		lblF0101.setValue("");
		buscadorWtumf.settearCampo(null);
		txtWTEMF4930.setValue("");
		txtCapacidadPesoF4930.setValue("");
		txtBrutoF4930.setValue("");
		buscadorCvumf.settearCampo(null);
		txtCapacidadVolumenF4930.setValue("");
		catalogo.limpiarSeleccion();
		txtVEHIF4930.setFocus(true);

	}

	public void habilitarTextClave() {

	}

	public boolean validarSeleccion() {
		List<F4930> seleccionados = catalogo.obtenerSeleccionados();
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

		final List<F4930> vehiculos = servicioF4930.buscarTodosOrdenados();
		catalogo = new CatalogoGenerico<F4930>(divCatalogoF4930, "F4930",
				vehiculos, false, false, true, "ID vehículo", "Tip veh",
				"Descripción", "Sucursal/planta", "N° de prop", "N° serie veh",
				"Cap peso", "UM ps", "Capacidad en vol cúbicos", "UM") {

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
							&& tvehiculos.getVmvehs().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& String.valueOf(tvehiculos.getVmwtca())
									.toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& tvehiculos.getVmwtum().toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& String.valueOf(tvehiculos.getVmcvol())
									.toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& tvehiculos.getVmcvum().toLowerCase()
									.contains(valores.get(9).toLowerCase())) {
						tvehiculo.add(tvehiculos);
					}
				}
				return tvehiculo;
			}

			@Override
			protected String[] crearRegistros(F4930 f4930) {
				String[] registros = new String[10];
				registros[0] = f4930.getVmvehi();
				registros[1] = f4930.getVmvtyp();
				registros[2] = f4930.getVmdl01();
				registros[3] = f4930.getVmmcu();
				registros[4] = String.valueOf(f4930.getVmvown());
				registros[5] = f4930.getVmvehs();
				registros[6] = String.valueOf(f4930.getVmwtca());
				registros[7] = f4930.getVmwtum();
				registros[8] = String.valueOf(f4930.getVmcvol());
				registros[9] = f4930.getVmcvum();

				return registros;
			}
		};
		catalogo.setParent(divCatalogoF4930);

	}

	@Listen("onClick = #btnBuscarVOWNF0101")
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
		txtVOWNF0101.setValue(String.valueOf(Math.round(f0101.getAban8())));
		lblF0101.setValue(f0101.getAbalph());
		catalogoF0101.setParent(null);
	}

	@Listen("onChange = #txtVOWNF0101; onOk = #txtVOWNF0101")
	public boolean buscarDireccion() {
		if (txtVOWNF0101.getValue() != null) {
			F0101 f0101 = servicioF0101.buscar(Double.valueOf(txtVOWNF0101
					.getValue()));
			if (f0101 != null) {
				txtVOWNF0101.setValue(String.valueOf(Math.round(f0101
						.getAban8())));
				lblF0101.setValue(f0101.getAbalph());
				return true;
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				return false;
			}
		} else
			return false;
	}

	@Listen("onClick = #btnBuscarVTYPF4931")
	public void mostrarCatalogoF4931() {
		final List<F4931> listF4931 = servicioF4931.buscarTodosOrdenados();
		catalogoF4931 = new CatalogoGenerico<F4931>(divCatalogoF4931, "F4931",
				listF4931, true, false, false, "Tp veh", "Descripción",
				"Tipo transp", "Grupo dpch", "Grupo 2 de desp", "Cap peso",
				"UM ps", "Capacidad en vol cúbicos", "UM",
				"Capacidad de vol a granel",
				"Cap secundaria de volumen a granel", "UM vol", "N° com",
				"Lín carga") {

			@Override
			protected List<F4931> buscar(List<String> valores) {
				List<F4931> lista = new ArrayList<F4931>();
				for (F4931 f4931 : listF4931) {

					if (String.valueOf(f4931.getVgvtyp()).toLowerCase()
							.startsWith(valores.get(0))
							&& f4931.getVgdl01().toLowerCase()
									.startsWith(valores.get(2))
							&& f4931.getVgmot().toLowerCase()
									.startsWith(valores.get(3))
							&& f4931.getVgdsgs().toLowerCase()
									.startsWith(valores.get(4))
							&& String.valueOf(f4931.getVgwtca()).toLowerCase()
									.startsWith(valores.get(5))
							&& f4931.getVgwtum().toLowerCase()
									.startsWith(valores.get(6))
							&& String.valueOf(f4931.getVgcvol()).toLowerCase()
									.startsWith(valores.get(7))
							&& f4931.getVgcvum().toLowerCase()
									.startsWith(valores.get(8))
							&& String.valueOf(f4931.getVgvlcp()).toLowerCase()
									.startsWith(valores.get(9))
							&& String.valueOf(f4931.getVgvlcs()).toLowerCase()
									.startsWith(valores.get(10))
							&& f4931.getVgvlum().toLowerCase()
									.startsWith(valores.get(11))
							&& String.valueOf(f4931.getVgnce()).toLowerCase()
									.startsWith(valores.get(12))
							&& String.valueOf(f4931.getVglcnt()).toLowerCase()
									.startsWith(valores.get(13))) {
						lista.add(f4931);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4931 f4931) {
				String[] registros = new String[14];
				registros[0] = String.valueOf(f4931.getVgvtyp());
				registros[1] = f4931.getVgdl01();
				registros[2] = f4931.getVgmot();
				registros[3] = f4931.getVgdsgp();
				registros[4] = f4931.getVgdsgs();
				registros[5] = String.valueOf(f4931.getVgwtca());
				registros[6] = f4931.getVgwtum();
				registros[7] = String.valueOf(f4931.getVgcvol());
				registros[8] = f4931.getVgcvum();
				registros[9] = String.valueOf(f4931.getVgvlcp());
				registros[10] = String.valueOf(f4931.getVgvlcs());
				registros[11] = f4931.getVgvlum();
				registros[12] = String.valueOf(f4931.getVgnce());
				registros[13] = String.valueOf(f4931.getVglcnt());
				return registros;
			}
		};
		catalogoF4931.setParent(divCatalogoF4931);
		catalogoF4931.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF4931")
	public void seleccionF4931() {
		F4931 f4931 = catalogoF4931.objetoSeleccionadoDelCatalogo();
		txtVTYPF4931.setValue(f4931.getVgvtyp());
		lblF4931.setValue(f4931.getVgdl01());
		txtCapacidadPesoF4930.setValue(String.valueOf(Math.round(f4931
				.getVgwtca())));
		txtBrutoF4930.setValue(String.valueOf(Math.round(f4931.getVgwtem())));
		txtCapacidadVolumenF4930.setValue(f4931.getVgdsgp());
		catalogoF4931.setParent(null);
	}

	@Listen("onChange = #txtVTYPF4931; onOk =  #txtVTYPF4931")
	public boolean buscarTipoVehiculo() {
		if (txtVTYPF4931.getText().compareTo("") != 0) {
			F4931 f4931 = servicioF4931.buscar(txtVTYPF4931.getText());
			if (f4931 != null) {
				txtVTYPF4931.setValue(f4931.getVgvtyp());
				lblF4931.setValue(f4931.getVgdl01());
				return true;
			} else {
				msj.mensajeError(Mensaje.almacenNoExiste);
				return false;
			}

		} else
			return false;
	}

	@Listen("onClick = #btnBuscarMCUF0006")
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
		txtMCUF4930.setValue(String.valueOf(f0006.getMcmcu()));
		lblF0006.setValue(f0006.getMcdl01());
		catalogoF0006.setParent(null);
	}

	@Listen("onChange = #txtMCUF4930; onOk =  #txtMCUF4930")
	public boolean idF0006() {
		if (txtMCUF4930.getText().compareTo("") != 0) {
			F0006 f0006 = servicioF0006.buscar(txtMCUF4930.getText());
			if (f0006 != null) {
				txtMCUF4930.setValue(String.valueOf(f0006.getMcmcu()));
				lblF0006.setValue(f0006.getMcdl01());
				return true;
			} else {
				msj.mensajeError(Mensaje.almacenNoExiste);
				return false;
			}

		} else
			return false;
	}

	public boolean camposLLenos() {
		if (txtVEHIF4930.getText().compareTo("") == 0
				|| txtMCUF4930.getText().compareTo("") == 0
				|| txtVEHSF4930.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtVEHIF4930.getText().compareTo("") != 0
				|| txtMCUF4930.getText().compareTo("") != 0
				|| txtDL01F4930.getText().compareTo("") != 0
				|| txtVEHSF4930.getText().compareTo("") != 0
				|| txtVTYPF4931.getText().compareTo("") != 0
				|| txtVOWNF0101.getText().compareTo("") != 0
				|| buscadorWtumf.obtenerCaja().compareTo("") != 0
				|| txtWTEMF4930.getText().compareTo("") != 0
				|| buscadorCvumf.obtenerCaja().compareTo("") != 0) {
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