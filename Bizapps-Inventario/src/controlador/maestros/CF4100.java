package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F4100;
import modelo.pk.F4100PK;
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

public class CF4100 extends CGenerico {

	@Wire
	private Datebox dtbUPMJF4100;
	@Wire
	private Textbox txtLOCNF4100;
	@Wire
	private Textbox txtMCUF4100;
	@Wire
	private Div divBuscadorPZONF4100;
	@Wire
	private Div divBuscadorKZONF4100;
	@Wire
	private Div divBuscadorZONRF4100;
	@Wire
	private Div divBuscadorLLDLF4100;
	@Wire
	private Div divBuscadorMIXLF4100;
	@Wire
	private Div divBuscadorSTAGF4100;
	@Wire
	private Div divVF4100;
	@Wire
	private Div botoneraF4100;
	@Wire
	private Div divCatalogoF0006;
	@Wire
	private Div divCatalogoF4100;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Label lblMCUF0006;
	@Wire
	private Button btnBuscarF0006;

	Botonera botonera;
	Catalogo<F4100> catalogoF4100;
	Catalogo<F0006> catalogoF0006;
	F4100PK clave = null;
	BuscadorUDC buscadorPZONF4100;
	BuscadorUDC buscadorKZONF4100;
	BuscadorUDC buscadorZONRF4100;
	BuscadorUDC buscadorLLDLF4100;
	BuscadorUDC buscadorMIXLF4100;
	BuscadorUDC buscadorSTAGF4100;

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
		txtMCUF4100.setFocus(true);
		mostrarCatalogo();

		List<F0005> listF0005 = servicioF0005
				.buscarParaUDCOrdenados("46", "ZN");

		buscadorPZONF4100 = new BuscadorUDC("Zona alm", 255, listF0005, false,
				true, true, "46", "ZN") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("46", "ZN",
						buscadorPZONF4100.obtenerCaja());
			}
		};

		buscadorKZONF4100 = new BuscadorUDC("Zona acopio", 255, listF0005,
				false, true, true, "46", "ZN") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("46", "ZN",
						buscadorKZONF4100.obtenerCaja());
			}
		};

		buscadorZONRF4100 = new BuscadorUDC("Zona reabast", 255, listF0005,
				false, true, true, "46", "ZN") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("46", "ZN",
						buscadorZONRF4100.obtenerCaja());
			}
		};

		List<F0005> listF0005LLDL = servicioF0005.buscarParaUDCOrdenados("M40",
				"LL");
		buscadorLLDLF4100 = new BuscadorUDC("Detalle", 255, listF0005LLDL,
				false, true, true, "M40", "LL") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("M40", "LL",
						buscadorLLDLF4100.obtenerCaja());
			}
		};

		List<F0005> listF0005MIXL = servicioF0005.buscarParaUDCOrdenados("41",
				"ML");
		buscadorMIXLF4100 = new BuscadorUDC("Art/Lotes mixtos", 255,
				listF0005MIXL, false, true, true, "41", "ML") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("41", "ML",
						buscadorMIXLF4100.obtenerCaja());
			}
		};

		List<F0005> listF0005STAG = servicioF0005.buscarParaUDCOrdenados("Y",
				"N");
		buscadorSTAGF4100 = new BuscadorUDC("Ubic temp", 255, listF0005STAG,
				false, true, true, "Y", "N") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("Y", "N",
						buscadorSTAGF4100.obtenerCaja());
			}
		};

		divBuscadorPZONF4100.appendChild(buscadorPZONF4100);
		divBuscadorKZONF4100.appendChild(buscadorKZONF4100);
		divBuscadorZONRF4100.appendChild(buscadorZONRF4100);
		divBuscadorLLDLF4100.appendChild(buscadorLLDLF4100);
		divBuscadorMIXLF4100.appendChild(buscadorMIXLF4100);
		divBuscadorSTAGF4100.appendChild(buscadorSTAGF4100);

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogoF4100.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						F4100 f4100 = catalogoF4100
								.objetoSeleccionadoDelCatalogo();
						clave = f4100.getId();
						abrirRegistro();
						F0006 f0006 = servicioF0006.buscar(f4100.getId()
								.getLmmcu());
						txtMCUF4100.setValue(f4100.getId().getLmmcu());
						lblMCUF0006.setValue(f0006.getMcldm());
						txtMCUF4100.setDisabled(true);

						txtLOCNF4100.setValue(f4100.getId().getLmlocn());
						txtLOCNF4100.setDisabled(true);
						dtbUPMJF4100.setValue(transformarJulianaAGregoria(f4100
								.getLmupmj()));

						buscadorPZONF4100.settearCampo(servicioF0005.buscar(
								"46", "ZN", f4100.getLmpzon()));

						buscadorKZONF4100.settearCampo(servicioF0005.buscar(
								"46", "ZN", f4100.getLmkzon()));

						buscadorZONRF4100.settearCampo(servicioF0005.buscar(
								"46", "ZN", f4100.getLmzonr()));

						buscadorLLDLF4100.settearCampo(servicioF0005.buscar(
								"M40", "LL", f4100.getLmlldl()));

						buscadorMIXLF4100.settearCampo(servicioF0005.buscar(
								"41", "ML", f4100.getLmmixl()));

					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF4100, "Trabajo con Maestro de Ubicaciones",
						tabs);

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

					F4100 f4100 = new F4100();
					F4100PK clave = new F4100PK();
					clave.setLmmcu(txtMCUF4100.getValue());
					clave.setLmlocn(txtLOCNF4100.getValue());
					f4100.setId(clave);
					//
					// if (dtbUPMJF4100.getText().compareTo("") != 0)
					f4100.setLmupmj(transformarGregorianoAJulia(dtbUPMJF4100
							.getValue()));
					f4100.setLmuser("JDE");

					f4100.setLmpzon(buscadorPZONF4100.obtenerCaja());
					f4100.setLmkzon(buscadorKZONF4100.obtenerCaja());
					f4100.setLmzonr(buscadorZONRF4100.obtenerCaja());
					f4100.setLmlldl(buscadorLLDLF4100.obtenerCaja());
					f4100.setLmmixl(buscadorMIXLF4100.obtenerCaja());
					f4100.setLmstag(buscadorSTAGF4100.obtenerCaja());

					servicioF4100.guardar(f4100);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogoF4100.actualizarLista(servicioF4100
							.buscarTodosOrdenados());
				}

			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F4100> eliminarLista = catalogoF4100
								.obtenerSeleccionados();
						final int cantidad = eliminarLista.size();
						for (int i = 0; i < eliminarLista.size(); i++) {
							F4100 valor = eliminarLista.get(i);
							List<F4111> objeto = servicioF4111
									.buscarPorUbicaciones(valor.getId()
											.getLmlocn());
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
														servicioF4100
																.eliminarVarios(eliminarLista);
														catalogoF4100
																.actualizarLista(servicioF4100
																		.buscarTodosOrdenados());
														if (cantidad != eliminarLista
																.size())
															msj.mensajeInformacion(Mensaje.algunosEliminados);
														else
															msj.mensajeInformacion(Mensaje.eliminado);
													}
												}
											});
						} else {
							msj.mensajeAlerta(Mensaje.registroUtilizado);
						}
					}
				} else {
					/* Elimina un solo registro */
					if (clave != null) {
						List<F4111> objeto = servicioF4111
								.buscarPorUbicaciones(clave.getLmlocn());
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
														servicioF4100
																.eliminarUno(clave);
														msj.mensajeInformacion(Mensaje.eliminado);
														limpiar();
														catalogoF4100
																.actualizarLista(servicioF4100
																		.buscarTodosOrdenados());
													}
												}
											});
						} else {
							msj.mensajeAlerta(Mensaje.registroUtilizado);
						}
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
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF4100.appendChild(botonera);

	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(bol);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	public void limpiarCampos() {
		clave = null;
		txtMCUF4100.setValue("");
		txtMCUF4100.setFocus(true);
		lblMCUF0006.setValue("");
		txtLOCNF4100.setValue("");
		btnBuscarF0006.setVisible(true);
		dtbUPMJF4100.setValue(null);
		buscadorKZONF4100.settearCampo(null);
		buscadorKZONF4100.habilitarCampos();
		buscadorPZONF4100.settearCampo(null);
		buscadorPZONF4100.habilitarCampos();
		buscadorZONRF4100.settearCampo(null);
		buscadorZONRF4100.habilitarCampos();
		buscadorLLDLF4100.settearCampo(null);
		buscadorLLDLF4100.habilitarCampos();
		buscadorSTAGF4100.settearCampo(null);
		buscadorSTAGF4100.habilitarCampos();
		buscadorMIXLF4100.settearCampo(null);
		buscadorMIXLF4100.habilitarCampos();
	}

	public void habilitarTextClave() {
		if (txtMCUF4100.isDisabled())
			txtMCUF4100.setDisabled(false);
		if (txtLOCNF4100.isDisabled())
			txtLOCNF4100.setDisabled(false);

	}

	public boolean validarSeleccion() {
		List<F4100> seleccionados = catalogoF4100.obtenerSeleccionados();
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
		if (!idF0006()) {
			msj.mensajeError(Mensaje.almacenNoExiste);
			return false;
		} else {
			if (!camposLLenos()) {
				msj.mensajeError(Mensaje.camposVacios);
				return false;
			} else
				return true;
		}
	}

	@Listen("onChange = #txtMCUF4100")
	public boolean idF0006() {
		if (txtMCUF4100.getText().compareTo("") != 0) {
			F0006 f0006 = servicioF0006.buscar(txtMCUF4100.getText());
			if (f0006 != null) {
				txtMCUF4100.setValue(String.valueOf(f0006.getMcmcu()));
				lblMCUF0006.setValue(f0006.getMcdc());
				return true;
			} else {
				return false;
			}

		} else
			return false;
	}

	public boolean camposLLenos() {
		if (txtMCUF4100.getText().compareTo("") == 0
				|| txtLOCNF4100.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtMCUF4100.getText().compareTo("") != 0
				|| txtLOCNF4100.getText().compareTo("") != 0
				|| txtLOCNF4100.getText().compareTo("") != 0
				|| dtbUPMJF4100.getText().compareTo("") != 0
				|| buscadorKZONF4100.obtenerCaja().compareTo("") != 0
				|| buscadorLLDLF4100.obtenerCaja().compareTo("") != 0
				|| buscadorMIXLF4100.obtenerCaja().compareTo("") != 0
				|| buscadorPZONF4100.obtenerCaja().compareTo("") != 0
				|| buscadorSTAGF4100.obtenerCaja().compareTo("") != 0
				|| buscadorZONRF4100.obtenerCaja().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		if (clave == null)
			btnBuscarF0006.setVisible(true);
		else
			btnBuscarF0006.setVisible(false);
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
		final List<F4100> listF4100 = servicioF4100.buscarTodosOrdenados();
		catalogoF4100 = new Catalogo<F4100>(divCatalogoF4100, "F4100",
				listF4100, false, false, true, "Cod. Sucursal/planta",
				"Sucursal/planta", "Fecha acta", "Ubicacion", "Zona alm",
				"Zona acopio", "Zona reabast", "Detalle", "Pasillo", "Bin",
				"Ubic 3", "Ubic 4", "Ubic 5", "Ubic 6", "Ubic 7", "Ubic 8",
				"Ubic 9", "Ubic 10", "Art/Lote mixtos", "Ubic temp") {

			@Override
			protected List<F4100> buscar(List<String> valores) {

				List<F4100> listF4100_2 = new ArrayList<F4100>();

				for (F4100 f4100 : listF4100) {
					F0006 f0006 = servicioF0006
							.buscar(f4100.getId().getLmmcu());
					String mcdc = "";
					if (f0006.getMcdc() != null)
						mcdc = f0006.getMcdc();
					String num3 = "", num4 = "", num5 = "", num6 = "", num7 = "", num8 = "", num9 = "", num10 = "";
					if (f4100.getLmla03() != null)
						num3 = f4100.getLmla03();
					if (f4100.getLmla04() != null)
						num4 = f4100.getLmla04();
					if (f4100.getLmla05() != null)
						num5 = f4100.getLmla05();
					if (f4100.getLmla06() != null)
						num6 = f4100.getLmla06();
					if (f4100.getLmla07() != null)
						num7 = f4100.getLmla07();
					if (f4100.getLmla08() != null)
						num8 = f4100.getLmla08();
					if (f4100.getLmla09() != null)
						num9 = f4100.getLmla09();
					if (f4100.getLmla10() != null)
						num10 = f4100.getLmla10();
					if (String.valueOf(f4100.getId().getLmmcu()).toLowerCase()
							.startsWith(valores.get(0))
							&& mcdc.toLowerCase().startsWith(valores.get(1))
							&& String
									.valueOf(
											transformarJulianaAGregoria(f4100
													.getLmupmj()))
									.toLowerCase().startsWith(valores.get(2))
							&& f4100.getId().getLmlocn().toLowerCase()
									.startsWith(valores.get(3))
							&& f4100.getLmpzon().toLowerCase()
									.startsWith(valores.get(4))
							&& f4100.getLmkzon().toLowerCase()
									.startsWith(valores.get(5))
							&& f4100.getLmzonr().toLowerCase()
									.startsWith(valores.get(6))
							&& f4100.getLmlldl().toLowerCase()
									.startsWith(valores.get(7))
							// poner campos pasillo y bin
							&& num3.toLowerCase().startsWith(valores.get(10))
							&& num4.toLowerCase().startsWith(valores.get(11))
							&& num5.toLowerCase().startsWith(valores.get(12))
							&& num6.toLowerCase().startsWith(valores.get(13))
							&& num7.toLowerCase().startsWith(valores.get(14))
							&& num8.toLowerCase().startsWith(valores.get(15))
							&& num9.toLowerCase().startsWith(valores.get(16))
							&& num10.toLowerCase().startsWith(valores.get(17))
							&& f4100.getLmmixl().toLowerCase()
									.startsWith(valores.get(18))
							&& f4100.getLmstag().toLowerCase()
									.startsWith(valores.get(19))) {
						listF4100_2.add(f4100);
					}
				}
				return listF4100_2;
			}

			@Override
			protected String[] crearRegistros(F4100 f4100) {

				F0006 f0006 = servicioF0006.buscar(f4100.getId().getLmmcu());
				String[] registros = new String[20];
				registros[0] = String.valueOf(f4100.getId().getLmmcu());
				registros[1] = f0006.getMcdc();
				registros[2] = formatoFecha
						.format((transformarJulianaAGregoria(f4100.getLmupmj())));
				registros[3] = String.valueOf(f4100.getId().getLmlocn());
				registros[4] = f4100.getLmpzon();
				registros[5] = f4100.getLmkzon();
				registros[6] = f4100.getLmzonr();
				registros[7] = f4100.getLmlldl();
				registros[8] = "no se";
				registros[9] = "no se";
				registros[10] = f4100.getLmla03();
				registros[11] = f4100.getLmla04();
				registros[12] = f4100.getLmla05();
				registros[13] = f4100.getLmla06();
				registros[14] = f4100.getLmla07();
				registros[15] = f4100.getLmla08();
				registros[16] = f4100.getLmla09();
				registros[17] = f4100.getLmla10();
				registros[18] = f4100.getLmmixl();
				registros[19] = f4100.getLmstag();
				return registros;
			}
		};
		catalogoF4100.setParent(divCatalogoF4100);
	}

	@Listen("onClick = #btnBuscarF0006")
	public void mostrarCatalogoF0006() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoF0006 = new Catalogo<F0006>(divCatalogoF0006, "F0006Emergente",
				unidades, true, false, false, "Unidad Negocio", "Descripcion",
				"Nivel det", "Cta", "Tipo UN", "LM Auxiliar Inactivo",
				"Mto Cons", "CAT 01", "CAT 02", "CAT 03", "CAT 04", "CAT 05",
				"CAT 06") {

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
		catalogoF0006.setParent(divCatalogoF0006);
		catalogoF0006.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0006")
	public void seleccionF0006() {
		F0006 f0006 = catalogoF0006.objetoSeleccionadoDelCatalogo();
		txtMCUF4100.setValue(String.valueOf(f0006.getMcmcu()));
		lblMCUF0006.setValue(f0006.getMcdc());
		catalogoF0006.setParent(null);
	}

}
