package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0010;
import modelo.maestros.F0013;
import modelo.maestros.F0101;
import modelo.maestros.F0115;
import modelo.pk.F0115PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0115 extends CGenerico {

	private static final long serialVersionUID = 7210119388875143230L;
	@Wire
	private Div divVF0115;
	@Wire
	private Longbox txtAn8F0115;
	@Wire
	private Label lblAn8F0115;
	@Wire
	private Textbox txtAr01F0115;
	@Wire
	private Textbox txtPh1F0115;
	@Wire
	private Div divBuscadorPhtp;
	BuscadorUDC buscadorPhtp;
	@Wire
	private Div botoneraF0115;
	@Wire
	private Div catalogoF0115;
	@Wire
	private Button btnBuscarDireccionF0115;
	@Wire
	private Div DivCatalogoDireccionF0115;
	@Wire
	private Groupbox gpxDatosF0115;
	@Wire
	private Groupbox gpxRegistroF0115;
	Botonera botonera;
	Catalogo<F0115> catalogo;
	Catalogo<F0101> catalogoD;
	F0115PK clave = null;

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
		mostrarCatalogo();
		List<F0005> listF0005 = servicioF0005
				.buscarParaUDCOrdenados("01", "PM");
		buscadorPhtp = new BuscadorUDC("Tipo telefono", 4, listF0005, false,
				false, false,"01", "PM") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "PM",
						buscadorPhtp.obtenerCaja());
			}
		};
		divBuscadorPhtp.appendChild(buscadorPhtp);

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F0115 f0115 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f0115.getId();
						F0101 f0101 = servicioF0101.buscar(f0115.getId()
								.getWpan8());
						lblAn8F0115.setValue(f0101.getAbalph());
						Double doble = f0115.getId().getWpan8();
						txtAn8F0115.setValue(doble.longValue());
						txtAn8F0115.setDisabled(true);
						btnBuscarDireccionF0115.setVisible(false);
						txtAr01F0115.setValue(f0115.getWpar1());
						txtPh1F0115.setValue(f0115.getWpph1());
						buscadorPhtp.settearCampo(servicioF0005.buscar("01",
								"PM", f0115.getWpphtp()));
						txtAr01F0115.setFocus(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0115, titulo , tabs);
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
				clave = null;
			}

			@Override
			public void guardar() {
				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {
					Long lon;
					lon = txtAn8F0115.getValue();
					F0115 f015 = new F0115();
					F0115PK clavePk = new F0115PK();
					if (clave != null)
						clavePk = clave;
					else {
						List<F0115> lista = servicioF0115
								.buscarParaRegistrar(lon.doubleValue());
						clavePk.setWpan8(lon.doubleValue());
						clavePk.setWpcnln((double) (lista.size() + 1));
						clavePk.setWpidln((double) 0);
						clavePk.setWprck7((double) 0);
					}
					f015.setId(clavePk);
					f015.setWpar1(txtAr01F0115.getValue());
					f015.setWpph1(txtPh1F0115.getValue());
					f015.setWpphtp(buscadorPhtp.obtenerCaja());
					f015.setWpupmj(transformarGregorianoAJulia(fecha));
					f015.setWpupmt(Double.valueOf(horaAuditoria));
					f015.setWpuser("JDE");
					servicioF0115.guardar(f015);
					catalogo.actualizarLista(servicioF0115
							.buscarTodosOrdenados());
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
				}
			}

			@Override
			public void eliminar() {
				if (gpxDatosF0115.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F0115> eliminarLista = catalogo
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
													servicioF0115
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF0115
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
													servicioF0115
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF0115
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
				
				abrirCatalogo();

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
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF0115.appendChild(botonera);
	}

	protected boolean validar() {
		if (!camposLLenos()) {
			msj.mensajeError(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	@Listen("onOpen = #gpxDatosF0115")
	public void abrirCatalogo() {
		gpxDatosF0115.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF0115.setOpen(false);
								gpxRegistroF0115.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF0115.setOpen(true);
									gpxRegistroF0115.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF0115.setOpen(true);
			gpxRegistroF0115.setOpen(false);
			mostrarBotones(true);
		}
	}

	private boolean camposEditando() {
		if (txtAn8F0115.getText().compareTo("") != 0
				|| txtAr01F0115.getText().compareTo("") != 0
				|| txtPh1F0115.getText().compareTo("") != 0
				|| buscadorPhtp.obtenerCaja().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	private boolean camposLLenos() {
		if (txtAn8F0115.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	protected void habilitarTextClave() {
		if (txtAn8F0115.isDisabled())
			txtAn8F0115.setDisabled(false);
	}

	protected void limpiarCampos() {
		lblAn8F0115.setValue("");
		lblAn8F0115.setValue("");
		txtAn8F0115.setValue(null);
		txtAr01F0115.setValue("");
		txtPh1F0115.setValue("");
		buscadorPhtp.settearCampo(null);
		btnBuscarDireccionF0115.setVisible(true);
		txtAn8F0115.setDisabled(false);
		catalogo.limpiarSeleccion();
	}

	@Listen("onClick = #gpxRegistroF0115")
	public void abrirRegistro() {
		gpxDatosF0115.setOpen(false);
		btnBuscarDireccionF0115.setVisible(true);
		gpxRegistroF0115.setOpen(true);
		mostrarBotones(false);
	}

	protected void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(!bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	protected boolean validarSeleccion() {
		List<F0115> seleccionados = catalogo.obtenerSeleccionados();
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
		final List<F0115> listF0101 = servicioF0115.buscarTodosOrdenados();
		catalogo = new Catalogo<F0115>(catalogoF0115, "F0115", listF0101,
				false, false, false, "Nº direccion", "Prefijo",
				"Numero Telefono", "Tipo", "Descripcion") {

			@Override
			protected List<F0115> buscar(List<String> valores) {

				List<F0115> lista = new ArrayList<F0115>();

				for (F0115 f01 : listF0101) {
					F0005 f05 = servicioF0005.buscar("01", "PM",
							f01.getWpphtp());
					String valor = "";
					if (f05 != null)
						valor = f05.getDrdl01();
					if (String.valueOf(f01.getId().getWpan8().longValue()).toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f01.getWpar1().toLowerCase()
							.contains(valores.get(1).toLowerCase())
							&& f01.getWpph1().toLowerCase()
							.contains(valores.get(2).toLowerCase())
							&& f01.getWpphtp().toLowerCase()
							.contains(valores.get(3).toLowerCase())
							&& valor.toLowerCase()
							.contains(valores.get(4).toLowerCase())) {
						lista.add(f01);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0115 f0115) {
				F0005 f05 = servicioF0005.buscar("01", "PM", f0115.getWpphtp());
				String valor = "";
				if (f05 != null)
					valor = f05.getDrdl01();
				String[] registros = new String[5];
				registros[0] = String.valueOf(f0115.getId().getWpan8().longValue());
				registros[1] = f0115.getWpar1();
				registros[2] = f0115.getWpph1();
				registros[3] = f0115.getWpphtp();
				registros[4] = valor;
				return registros;
			}
		};
		catalogo.setParent(catalogoF0115);
	}

	@Listen("onClick = #btnBuscarDireccionF0115")
	public void mostrarCatalogoDireccion() {
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoD = new Catalogo<F0101>(DivCatalogoDireccionF0115,
				"CatalogoF0013", listF0101, true, false, false, "Nº direccion",
				"Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal") {

			@Override
			protected List<F0101> buscar(List<String> valores) {

				List<F0101> lista = new ArrayList<F0101>();

				for (F0101 f01 : listF0101) {
					if (String.valueOf(f01.getAban8().longValue()).toLowerCase()
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
		catalogoD.setParent(DivCatalogoDireccionF0115);
		catalogoD.doModal();
	}

	@Listen("onChange = #txtAn8F0115")
	public void buscarDireccion() {
		if (txtAn8F0115.getValue() != null) {
			F0101 f0101 = servicioF0101.buscar(txtAn8F0115.getValue());
			if (f0101 != null) {
				Double doble = f0101.getAban8();
				txtAn8F0115.setValue(doble.longValue());
				lblAn8F0115.setValue(f0101.getAbalph());
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				lblAn8F0115.setValue("");
				txtAn8F0115.setValue(null);
				txtAn8F0115.setFocus(true);
			}
		} else
			lblAn8F0115.setValue("");
	}

	@Listen("onSeleccion = #DivCatalogoDireccionF0115")
	public void seleccionarCatalogo() {
		F0101 f0101 = catalogoD.objetoSeleccionadoDelCatalogo();
		if (f0101 != null) {
			Double doble = f0101.getAban8();
			txtAn8F0115.setValue(doble.longValue());
			lblAn8F0115.setValue(f0101.getAbalph());
		}
		catalogoD.setParent(null);
	}

}
