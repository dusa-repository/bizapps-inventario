package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0101;
import modelo.maestros.F01151;
import modelo.pk.F01151PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;

public class CF01151 extends CGenerico {

	private static final long serialVersionUID = -2922709070240428246L;
	@Wire
	private Div divVF01151;
	@Wire
	private Longbox txtAn8F01151;
	@Wire
	private Label lblAn8F01151;
	@Wire
	private Combobox cmbEtpF01151;
	@Wire
	private Textbox txtEmalF01151;
	@Wire
	private Div divbuscadorEhier;
	BuscadorUDC buscadorEhier;
	@Wire
	private Div divbuscadorEclass;
	BuscadorUDC buscadorEclass;
	@Wire
	private Div botoneraF01151;
	@Wire
	private Div catalogoF01151;
	@Wire
	private Div DivCatalogoDireccionF01151;
	@Wire
	private Groupbox gpxDatosF01151;
	@Wire
	private Button btnBuscarDireccionF01151;
	@Wire
	private Groupbox gpxRegistroF01151;
	protected List<F01151> listaGeneral = new ArrayList<F01151>();
	Botonera botonera;
	CatalogoGenerico<F01151> catalogo;
	CatalogoGenerico<F0101> catalogoD;
	F01151PK clave = null;

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
				.buscarParaUDCOrdenados("01", "HI");
		buscadorEhier = new BuscadorUDC("Indicador Mensajes", 19, listF0005,
				false, false, false, "01", "HI") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "HI",
						buscadorEhier.obtenerCaja());
			}
		};
		divbuscadorEhier.appendChild(buscadorEhier);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "CF");
		buscadorEclass = new BuscadorUDC("Cat. Direccion Electronica", 3,
				listF0005, false, false, false, "01", "CF") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "CF",
						buscadorEclass.obtenerCaja());
			}
		};
		divbuscadorEclass.appendChild(buscadorEclass);

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F01151 f0115 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f0115.getId();
						F0101 f0101 = servicioF0101.buscar(f0115.getId()
								.getEaan8());
						lblAn8F01151.setValue(f0101.getAbalph());
						Double doble = f0115.getId().getEaan8();
						txtAn8F01151.setValue(doble.longValue());
						txtAn8F01151.setDisabled(true);
						btnBuscarDireccionF01151.setVisible(false);
						txtEmalF01151.setValue(f0115.getEaemal());
						String valor = "";
						if (f0115.getEaetp() != null)
							switch (f0115.getEaetp()) {
							case "DirW":
								valor = "Direccion de Internet";
								cmbEtpF01151.setContext("DirW");
								break;
							case "DirE":
								valor = "Direccion Electronica";
								cmbEtpF01151.setContext("DirE");
								break;
							case "DirI":
								valor = "Direccion Interna";
								cmbEtpF01151.setContext("DirI");
								break;
							default:
								break;
							}
						cmbEtpF01151.setValue(valor);
						buscadorEclass.settearCampo(servicioF0005.buscar("01",
								"CF", f0115.getEaeclass()));
						int ehier = (int) Math.floor(f0115.getEaehier());
						String ehierMostrar = "0" + String.valueOf(ehier);
						System.out.println(ehierMostrar);
						buscadorEhier.settearCampo(servicioF0005.buscar("01",
								"HI", ehierMostrar));
						cmbEtpF01151.setFocus(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF01151, titulo, tabs);
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
				
				if (validar()) {
					Long lon;
					lon = txtAn8F01151.getValue();
					F01151 f015 = new F01151();
					F01151PK clavePk = new F01151PK();
					if (clave != null)
						clavePk = clave;
					else {
						List<F01151> lista = servicioF01151
								.buscarParaRegistrar(lon.doubleValue());
						clavePk.setEaan8(lon.doubleValue());
						clavePk.setEaidln((double) (lista.size() + 1));
						clavePk.setEarck7((double) 0);
					}
					f015.setId(clavePk);
					f015.setEaemal(txtEmalF01151.getValue());
					if (cmbEtpF01151.getSelectedItem() != null)
						f015.setEaetp(cmbEtpF01151.getSelectedItem()
								.getContext());
					f015.setEaeclass(buscadorEclass.obtenerCaja());
					if (buscadorEhier.obtenerCaja().compareTo("") != 0) {
						Double eaehier = Double.parseDouble(buscadorEhier
								.obtenerCaja());
						f015.setEaehier(eaehier);
					}

					f015.setEaupmj(transformarGregorianoAJulia(fecha));
					f015.setEaupmt(Double.valueOf(horaAuditoria));
					f015.setEauser("JDE");
					servicioF01151.guardar(f015);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					listaGeneral = servicioF01151.buscarTodosOrdenados();
					catalogo.actualizarLista(listaGeneral);
				}
			}

			@Override
			public void eliminar() {
				if (gpxDatosF01151.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F01151> eliminarLista = catalogo
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
													servicioF01151
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													listaGeneral = servicioF01151.buscarTodosOrdenados();
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
													servicioF01151
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													listaGeneral = servicioF01151.buscarTodosOrdenados();
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
		botoneraF01151.appendChild(botonera);
	}

	protected boolean validar() {
		if (!camposLLenos()) {
			msj.mensajeError(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	@Listen("onOpen = #gpxDatosF01151")
	public void abrirCatalogo() {
		gpxDatosF01151.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF01151.setOpen(false);
								gpxRegistroF01151.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF01151.setOpen(true);
									gpxRegistroF01151.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF01151.setOpen(true);
			gpxRegistroF01151.setOpen(false);
			mostrarBotones(true);
		}
	}

	private boolean camposEditando() {
		if (txtAn8F01151.getText().compareTo("") != 0
				|| txtEmalF01151.getText().compareTo("") != 0
				|| buscadorEclass.obtenerCaja().compareTo("") != 0
				|| buscadorEhier.obtenerCaja().compareTo("") != 0
				|| cmbEtpF01151.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	private boolean camposLLenos() {
		if (txtAn8F01151.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	protected void habilitarTextClave() {
		if (txtAn8F01151.isDisabled())
			txtAn8F01151.setDisabled(false);
	}

	protected void limpiarCampos() {
		txtEmalF01151.setValue("");
		txtAn8F01151.setValue(null);
		lblAn8F01151.setValue("");
		btnBuscarDireccionF01151.setVisible(true);
		cmbEtpF01151.setValue("");
		buscadorEclass.settearCampo(null);
		buscadorEhier.settearCampo(null);
		catalogo.limpiarSeleccion();
	}

	@Listen("onClick = #gpxRegistroF01151")
	public void abrirRegistro() {
		gpxDatosF01151.setOpen(false);
		gpxRegistroF01151.setOpen(true);
		btnBuscarDireccionF01151.setVisible(true);
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
		List<F01151> seleccionados = catalogo.obtenerSeleccionados();
		if (seleccionados == null) {
			msj.mensajeError(Mensaje.noHayRegistros);
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
		listaGeneral = servicioF01151.buscarTodosOrdenados();
		catalogo = new CatalogoGenerico<F01151>(catalogoF01151, "F01151", listaGeneral,
				false, false, false, "Nº direccion", "Tipo Direccion",
				"Direccion Correo-e", "Indicador Mensajes",
				"Cat Direccion Electronica") {

			@Override
			protected List<F01151> buscar(List<String> valores) {

				List<F01151> lista = new ArrayList<F01151>();

				for (F01151 f01 : listaGeneral) {
					String valor = "";
					switch (f01.getEaetp()) {
					case "DirW":
						valor = "Direccion de Internet";
						break;
					case "DirE":
						valor = "Direccion Electronica";
						break;
					case "DirI":
						valor = "Direccion Interna";
						break;
					default:
						break;
					}
					if (String.valueOf(f01.getId().getEaan8().longValue())
							.toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& valor.toLowerCase().contains(
									valores.get(1).toLowerCase())
							&& f01.getEaemal().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& String.valueOf(f01.getEaehier()).toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f01.getEaeclass().toLowerCase()
									.contains(valores.get(4).toLowerCase())) {
						lista.add(f01);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F01151 f0115) {
				String valor = "";
				if (f0115.getEaetp() != null) {
					switch (f0115.getEaetp()) {
					case "DirW":
						valor = "Direccion de Internet";
						break;
					case "DirE":
						valor = "Direccion Electronica";
						break;
					case "DirI":
						valor = "Direccion Interna";
						break;
					default:
						break;
					}
				}
				String[] registros = new String[5];
				registros[0] = String.valueOf(f0115.getId().getEaan8()
						.longValue());
				registros[1] = valor;
				registros[2] = f0115.getEaemal();
				registros[3] = String.valueOf(f0115.getEaehier());
				registros[4] = f0115.getEaeclass();
				return registros;
			}
		};
		catalogo.setParent(catalogoF01151);
	}

	@Listen("onClick = #btnBuscarDireccionF01151")
	public void mostrarCatalogoDireccion() {
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoD = new CatalogoGenerico<F0101>(DivCatalogoDireccionF01151,
				"Catalogo de Direcciones", listF0101, true, false, false, "Nº direccion",
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
				registros[0] = String.valueOf(f013.getAban8());
				registros[1] = f013.getAbalph();
				registros[2] = f013.getAbalky();
				registros[3] = f013.getAbsic();
				registros[4] = f013.getAbat1();
				registros[5] = f013.getAbtax();
				return registros;
			}
		};
		catalogoD.setParent(DivCatalogoDireccionF01151);
		catalogoD.doModal();
	}

	@Listen("onChange = #txtAn8F01151; onOk = #txtAn8F01151")
	public void buscarDireccion() {
		if (txtAn8F01151.getValue() != null) {
			F0101 f0101 = servicioF0101.buscar(txtAn8F01151.getValue());
			if (f0101 != null) {
				Double doble = f0101.getAban8();
				txtAn8F01151.setValue(doble.longValue());
				lblAn8F01151.setValue(f0101.getAbalph());
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				lblAn8F01151.setValue("");
				txtAn8F01151.setValue(null);
				txtAn8F01151.setFocus(true);
			}
		} else
			lblAn8F01151.setValue("");
	}

	@Listen("onSeleccion = #DivCatalogoDireccionF01151")
	public void seleccionarCatalogo() {
		F0101 f0101 = catalogoD.objetoSeleccionadoDelCatalogo();
		if (f0101 != null) {
			Double doble = f0101.getAban8();
			txtAn8F01151.setValue(doble.longValue());
			lblAn8F01151.setValue(f0101.getAbalph());
		}
		catalogoD.setParent(null);
	}

}
