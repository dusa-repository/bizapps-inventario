package controlador.transacciones;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F00021;
import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F0010;
import modelo.maestros.F4100;
import modelo.maestros.F4101;
import modelo.maestros.F4105;
import modelo.pk.F00021PK;
import modelo.pk.F4105PK;
import modelo.pk.F4211PK;
import modelo.transacciones.F4111;
import modelo.transacciones.F4211;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

import controlador.maestros.CGenerico;

public class CF4211 extends CGenerico {
	private static final long serialVersionUID = 4666579770670871843L;

	@Wire
	private Div divVF4211;
	@Wire
	private Div botoneraF4211;
	@Wire
	private Div catalogoF4211;
	@Wire
	private Div divCatalogoF4101;
	@Wire
	private Div divCatalogoF0006;
	@Wire
	private Div divCatalogoF4100;
	@Wire
	private Div divCatalogoF0010;
	@Wire
	private Groupbox gpxDatosF4211;
	@Wire
	private Groupbox gpxRegistroF4211;
	@Wire
	private Button btnBuscarPlanta1;
	@Wire
	private Button btnBuscarPlanta2;
	@Wire
	private Button btnBuscarEmpresa1;
	@Wire
	private Button btnBuscarEmpresa2;
	@Wire
	private Button btnBuscarItm;
	@Wire
	private Button btnBuscarUbicacion;
	@Wire
	private Doublebox txtDoco;
	@Wire
	private Textbox txtDcto;
	@Wire
	private Doublebox txtLnid;
	@Wire
	private Textbox txtPlanta1;
	@Wire
	private Label lblPlanta1;
	@Wire
	private Textbox txtPlanta2;
	@Wire
	private Label lblPlanta2;
	@Wire
	private Textbox txtEmpresa1;
	@Wire
	private Label lblEmpresa1;
	@Wire
	private Textbox txtEmpresa2;
	@Wire
	private Label lblEmpresa2;
	@Wire
	private Datebox dtbFecha;
	@Wire
	private Doublebox txtDoc;
	@Wire
	private Doublebox txtItm;
	@Wire
	private Label lblItm;
	@Wire
	private Textbox txtUM;
	@Wire
	private Doublebox txtCosto;
	@Wire
	private Spinner spnCantidad;
	@Wire
	private Label lblUbicacion;
	@Wire
	private Textbox txtUbicacion;
	@Wire
	private Listbox ltbPedidos;
	@Wire
	private Button btnAgregarItems;
	@Wire
	private Groupbox gpxItems;
	@Wire
	private Row rowBoton;
	
	F4211PK clave = null;
	List<F4211> listaPedido = new ArrayList<F4211>();
	Botonera botonera;
	Catalogo<F4211> catalogo;
	Catalogo<F4101> catalogoF4101;
	Catalogo<F0006> catalogoF0006;
	Catalogo<F4100> catalogoF4100;
	Catalogo<F0010> catalogoF0010;
	private String mcu = "";
	private String idBotonF0010 = "";
	private String idBotonF0006 = "";
	private String ccoA = "";
	private String ccoB = "";
	double id = (double) 0;

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
		txtDcto.setValue("ET");
		mostrarCatalogo();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						
						mostrarGroupbox();
						mostrarBotones(false);
						F4211 f4211 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f4211.getId();
						abrirRegistro();
						txtDcto.setValue(f4211.getId().getSddcto());
						txtDoco.setValue(f4211.getId().getSddoco());
						txtLnid.setValue(f4211.getId().getSdlnid());
						txtEmpresa1.setValue(f4211.getId().getSdkcoo());
						F0010 f10 = new F0010();
						f10 = servicioF0010.buscar(f4211.getId().getSdkcoo());
						if (f10 != null)
							lblEmpresa1.setValue(f10.getCcname());
						txtEmpresa2.setValue(f4211.getSdkco());
						if (f4211.getSdkco() != null) {
							f10 = servicioF0010.buscar(f4211.getSdkco());
							if (f10 != null)
								lblEmpresa2.setValue(f10.getCcname());
						}
						dtbFecha.setValue(transformarJulianaAGregoria(f4211
								.getSddrqj()));
						txtDoc.setValue(f4211.getSddoc());
						txtPlanta1.setValue(f4211.getSdmcu());
						List<F4211> lista = servicioF4211.buscarPorDocoYDcto(
								f4211.getId().getSddoco(), f4211.getId()
										.getSddcto());
						for (int i = 0; i < lista.size(); i++) {
							F4211 f42 = lista.get(i);
							listaPedido.add(f42);
						}
						ltbPedidos.setModel(new ListModelList<F4211>(
								listaPedido));
						ltbPedidos.renderAll();
						txtDoco.setDisabled(true);
						txtDcto.setDisabled(true);
						txtLnid.setDisabled(true);
						txtEmpresa1.setDisabled(true);
						btnBuscarEmpresa1.setDisabled(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF4211, "Pedidos", tabs);
			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

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
					F4211 f4211 = new F4211();
					if (clave == null) {
						clave = new F4211PK();
						clave.setSddcto(txtDcto.getValue());
						clave.setSddoco(numeroSiguiente());
						clave.setSdkcoo(txtEmpresa1.getValue());
					}else {
						List<F4211> lista = servicioF4211.buscarPorDocoYDcto(
								clave.getSddoco(), clave
										.getSddcto());
						servicioF4211.eliminarVarios(lista);
					}
					f4211.setSdmcu(txtPlanta1.getValue());
					f4211.setSdkco(txtEmpresa2.getValue());
					f4211.setSddoc(txtDoc.getValue());
					f4211.setSddrqj(transformarGregorianoAJulia(dtbFecha
							.getValue()));
					f4211.setSdspattn("Enviada");
					if (listaPedido.isEmpty()) {
						clave.setSdlnid((double) 0);
						f4211.setId(clave);
						servicioF4211.guardar(f4211);
					} else {
						for (int i = 0; i < listaPedido.size(); i++) {
							F4211 f42 = listaPedido.get(i);
							Integer a = i + 1;
							clave.setSdlnid(a.doubleValue());
							f4211 = new F4211();
							f4211.setId(clave);
							f4211.setSdmcu(txtPlanta1.getValue());
							f4211.setSdkco(txtEmpresa2.getValue());
							f4211.setSddoc(txtDoc.getValue());
							f4211.setSddrqj(transformarGregorianoAJulia(dtbFecha
									.getValue()));
							f4211.setSditm(f42.getSditm());
							f4211.setSduncs(f42.getSduncs());
							f4211.setSdemcu(f42.getSdemcu());
							f4211.setSdecst(f42.getSdecst());
							f4211.setSdpqor(f42.getSdpqor());
							f4211.setSdlocn(f42.getSdlocn());
							f4211.setSduom(f42.getSduom());
							f4211.setSdspattn("Enviada");
							servicioF4211.guardar(f4211);
						}
					}
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF4211
							.buscarTodosOrdenados());
				}
			}

			@Override
			public void eliminar() {
				if (gpxDatosF4211.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F4211> eliminarLista = catalogo
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
													servicioF4211
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF4211
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
													servicioF4211
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF4211
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
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF4211.appendChild(botonera);
	}

	protected double numeroSiguiente() {
		double numeroNext = servicioF00021.Numero("7", "JE");
		if (numeroNext != 0) {
			id = numeroNext + 1;
			F00021 f021 = servicioF00021.buscar("7", "JE");
			f021.setNln001(id);
			servicioF00021.guardar(f021);
		} else {
			id = 1;
			F00021 f021 = new F00021();
			F00021PK clave21 = new F00021PK();
			clave21.setNldct("JE");
			clave21.setNlkco("7");
			clave21.setNlctry((double) 0);
			clave21.setNlfy((double) 0);
			f021.setId(clave21);
			f021.setNln001(id);
			servicioF00021.guardar(f021);
		}
		return id;
	}

	protected boolean validar() {
		if (!camposLLenos()) {
			msj.mensajeError(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	private boolean camposLLenos() {
		if (txtEmpresa1.getText().compareTo("") == 0
				|| txtEmpresa2.getText().compareTo("") == 0
				|| txtPlanta1.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	protected void habilitarTextClave() {
		if (txtEmpresa1.isDisabled()) {
			txtEmpresa1.setDisabled(false);
			btnBuscarEmpresa1.setDisabled(false);
		}
	}

	protected void limpiarCampos() {
		txtCosto.setValue(null);
		txtDoc.setValue(null);
		txtDoco.setValue(null);
		txtEmpresa1.setValue("");
		txtEmpresa2.setValue("");
		txtItm.setValue(null);
		txtLnid.setValue(null);
		txtPlanta1.setValue("");
		txtPlanta2.setValue("");
		txtUbicacion.setValue("");
		txtUM.setValue("");
		txtItm.setValue(null);
		ltbPedidos.getItems().clear();
		listaPedido.clear();
		spnCantidad.setValue(0);
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

	public boolean validarSeleccion() {
		List<F4211> seleccionados = catalogo.obtenerSeleccionados();
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

	@Listen("onOpen = #gpxDatosF4211")
	public void abrirCatalogo() {
		gpxDatosF4211.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF4211.setOpen(false);
								gpxRegistroF4211.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF4211.setOpen(true);
									gpxRegistroF4211.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF4211.setOpen(true);
			gpxRegistroF4211.setOpen(false);
			mostrarBotones(true);
		}
	}

	private boolean camposEditando() {
		if (txtCosto.getText().compareTo("") != 0
				|| txtDcto.getText().compareTo("") != 0
				|| txtItm.getText().compareTo("") != 0
				|| txtItm.getText().compareTo("") != 0
				|| txtDoc.getText().compareTo("") != 0
				|| txtDoco.getText().compareTo("") != 0
				|| txtEmpresa1.getText().compareTo("") != 0
				|| txtEmpresa2.getText().compareTo("") != 0
				|| txtLnid.getText().compareTo("") != 0
				|| txtPlanta1.getText().compareTo("") != 0
				|| txtPlanta2.getText().compareTo("") != 0
				|| txtUbicacion.getText().compareTo("") != 0
				|| txtUM.getText().compareTo("") != 0
				|| ltbPedidos.getItemCount() != 0 || listaPedido.size() != 0
				|| spnCantidad.getValue() != 0) {
			return false;
		} else
			return true;
	}

	@Listen("onClick = #gpxRegistroF4211")
	public void abrirRegistro() {
		gpxDatosF4211.setOpen(false);
		gpxRegistroF4211.setOpen(true);
		mostrarBotones(false);
	}

	private void mostrarCatalogo() {
		final List<F4211> listF0005 = servicioF4211.buscarTodosOrdenados();
		catalogo = new Catalogo<F4211>(catalogoF4211, "F4211", listF0005,
				false, false, false, "Nº Orden", "Tipo ord", "Cia ord",
				"Compañia", "Sucursal/Planta", "Articulo", "Cantidad", "Total",
				"Fecha") {

			@Override
			protected List<F4211> buscar(List<String> valores) {

				List<F4211> listF0005_2 = new ArrayList<F4211>();

				for (F4211 f0005 : listF0005) {
					if (String.valueOf(f0005.getId().getSddoco().longValue()).toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f0005.getId().getSddcto().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& String.valueOf(f0005.getId().getSdlnid().longValue())
									.toLowerCase().contains(valores.get(2).toLowerCase())
							&& f0005.getId().getSdkcoo().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f0005.getSdmcu().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& String.valueOf(f0005.getSditm().longValue()).toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& String.valueOf(f0005.getSdpqor().longValue()).toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& String.valueOf(f0005.getSdecst().longValue()).toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0005
											.getSddrqj())).toLowerCase()
									.contains(valores.get(8).toLowerCase())) {
						listF0005_2.add(f0005);
					}
				}
				return listF0005_2;
			}

			@Override
			protected String[] crearRegistros(F4211 f0005) {
				String[] registros = new String[9];
				registros[0] = String.valueOf(f0005.getId().getSddoco().longValue());
				registros[1] = f0005.getId().getSddcto();
				registros[2] = String.valueOf(f0005.getId().getSdlnid().longValue());
				registros[3] = f0005.getId().getSdkcoo();
				registros[4] = f0005.getSdmcu();
				registros[5] = String.valueOf(f0005.getSditm().longValue());
				registros[6] = String.valueOf(f0005.getSdpqor().longValue());
				registros[7] = String.valueOf(f0005.getSdecst().longValue());
				registros[8] = formatoFecha
						.format(transformarJulianaAGregoria(f0005.getSddrqj()));
				;
				return registros;
			}
		};
		catalogo.setParent(catalogoF4211);
	}

	@Listen("onClick = #btnBuscarUbicacion")
	public void mostrarCatalogoF4100() {
		final List<F4100> listF41002 = servicioF4100
				.buscarTodosOrdenadosPorMcu(mcu);
		catalogoF4100 = new Catalogo<F4100>(divCatalogoF4100, "F4100",
				listF41002, true, false, false, "Cod. Sucursal/planta",
				"Sucursal/planta", "Fecha acta", "Ubicacion", "Zona alm",
				"Zona acopio", "Zona reabast", "Detalle", "Pasillo", "Bin",
				"Ubic 3", "Ubic 4", "Ubic 5", "Ubic 6", "Ubic 7", "Ubic 8",
				"Ubic 9", "Ubic 10", "Art/Lote mixtos", "Ubic temp") {

			@Override
			protected List<F4100> buscar(List<String> valores) {
				List<F4100> listF4100_2 = new ArrayList<F4100>();

				for (F4100 f4100 : listF41002) {
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
							.contains(valores.get(0).toLowerCase())
							&& mcdc.toLowerCase().contains(valores.get(1).toLowerCase())
							&& String
									.valueOf(
											transformarJulianaAGregoria(f4100
													.getLmupmj()))
									.toLowerCase().contains(valores.get(2).toLowerCase())
							&& f4100.getId().getLmlocn().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f4100.getLmpzon().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& f4100.getLmkzon().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& f4100.getLmzonr().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& f4100.getLmlldl().toLowerCase()
									.contains(valores.get(7).toLowerCase())
							// poner campos pasillo y bin
							&& num3.toLowerCase().contains(valores.get(10).toLowerCase())
							&& num4.toLowerCase().contains(valores.get(11).toLowerCase())
							&& num5.toLowerCase().contains(valores.get(12).toLowerCase())
							&& num6.toLowerCase().contains(valores.get(13).toLowerCase())
							&& num7.toLowerCase().contains(valores.get(14).toLowerCase())
							&& num8.toLowerCase().contains(valores.get(15).toLowerCase())
							&& num9.toLowerCase().contains(valores.get(16).toLowerCase())
							&& num10.toLowerCase().contains(valores.get(17).toLowerCase())
							&& f4100.getLmmixl().toLowerCase()
									.contains(valores.get(18).toLowerCase())
							&& f4100.getLmstag().toLowerCase()
									.contains(valores.get(19).toLowerCase())) {
						listF4100_2.add(f4100);
					}
				}
				return listF4100_2;
			}

			@Override
			protected String[] crearRegistros(F4100 f4100) {

				F0006 f0006 = servicioF0006.buscar(f4100.getId().getLmmcu());
				BigDecimal a = null;
				if (f4100.getLmupmj() != null)
					a = f4100.getLmupmj();
				String[] registros = new String[20];
				registros[0] = String.valueOf(f4100.getId().getLmmcu());
				registros[1] = f0006.getMcdc();
				registros[2] = String.valueOf(transformarJulianaAGregoria(a));
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
		catalogoF4100.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF4100")
	public void seleccionarCatalogo() {
		F4100 f4100 = catalogoF4100.objetoSeleccionadoDelCatalogo();
		setearUbicacion(f4100, txtUbicacion, lblUbicacion);
		catalogoF4100.setParent(null);
	}

	private void setearUbicacion(F4100 f4100, Textbox txtUbicacion22,
			Label lblUbicacion22) {
		txtUbicacion22.setValue(f4100.getId().getLmlocn());
		lblUbicacion22.setValue(f4100.getId().getLmlocn());

	}

	@Listen("onClick = #btnBuscarPlanta1,#btnBuscarPlanta2")
	public void mostrarCatalogoF0006(Event evento) {
		Button boton = (Button) evento.getTarget();
		idBotonF0006 = boton.getId();
		List<F0006> lista = new ArrayList<F0006>();
		if (idBotonF0006.equals("btnBuscarPlanta1"))
			lista = servicioF0006.buscarPorMco(ccoA);
		else
			lista = servicioF0006.buscarPorMco(ccoB);
		final List<F0006> unidades = lista;
		catalogoF0006 = new Catalogo<F0006>(divCatalogoF0006, "F0006",
				unidades, true, false, false, "Unidad Negocio", "Descripcion",
				"Nivel det", "Cta", "Tipo UN", "LM Auxiliar Inactivo",
				"Mto Cons", "CAT 01", "CAT 02", "CAT 03", "CAT 04", "CAT 05",
				"CAT 06") {

			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					String mcdc = "";
					if (unidad.getMcdc() != null)
						mcdc = unidad.getMcdc();
					if (unidad.getMcmcu().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& mcdc.toLowerCase().contains(valores.get(1).toLowerCase())
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
	public void seleccionarSucursal() {
		F0006 f06 = catalogoF0006.objetoSeleccionadoDelCatalogo();
		switch (idBotonF0006) {
		case "btnBuscarPlanta1":
			setearPlanta(f06, txtPlanta1, lblPlanta1);
			break;
		case "btnBuscarPlanta2":
			setearPlanta(f06, txtPlanta2, lblPlanta2);
			mcu = f06.getMcmcu();
			txtUbicacion.setValue("");
			lblUbicacion.setValue("");
			break;
		default:
			break;
		}

		catalogoF0006.setParent(null);
	}

	@Listen("onChange = #txtPlanta1, #txtPlanta2")
	public void buscarNombreSucursal(Event evento) {
		F0006 f06 = new F0006();
		Textbox txt = (Textbox) evento.getTarget();
		switch (txt.getId()) {
		case "txtPlanta1":
			f06 = servicioF0006.buscar(txtPlanta1.getValue());
			if (f06 != null) {
				setearPlanta(f06, txtPlanta1, lblPlanta1);
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				txtPlanta1.setValue("");
				txtPlanta1.setFocus(true);
				lblPlanta1.setValue("");
			}
			break;
		case "txtPlanta2":
			f06 = servicioF0006.buscar(txtPlanta2.getValue());
			if (f06 != null) {
				setearPlanta(f06, txtPlanta2, lblPlanta2);
				mcu = f06.getMcmcu();
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				txtPlanta2.setValue("");
				txtPlanta2.setFocus(true);
				lblPlanta2.setValue("");
			}
			break;
		}
	}

	private void setearPlanta(F0006 f06, Textbox txtPlanta12, Label lblPlanta12) {
		txtPlanta12.setValue(f06.getMcmcu());
		lblPlanta12.setValue(f06.getMcdl01());
	}

	@Listen("onClick = #btnBuscarItm")
	public void mostrarCatalogoF4101() {
		final List<F4101> listF4101 = servicioF4101
				.buscarTodosOrdenadosPorMcu(txtPlanta1.getValue());
		catalogoF4101 = new Catalogo<F4101>(divCatalogoF4101, "F4101",
				listF4101, true, false, false, "Número artículo",
				"Descripción", "Descripción 2", "Texto búsqueda", "Tipo línea",
				"Tipo alm", "Código vta 1") {

			@Override
			protected List<F4101> buscar(List<String> valores) {

				List<F4101> lista = new ArrayList<F4101>();

				for (F4101 f4101 : listF4101) {
					String valor = "";
					if(f4101.getImsrp1()!=null)
						valor = f4101.getImsrp1();
					if (f4101.getImlitm().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f4101.getImdsc1().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& f4101.getImdsc2().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& f4101.getImsrtx().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f4101.getImlnty().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& f4101.getImstkt().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& valor.toLowerCase()
									.contains(valores.get(6).toLowerCase())) {
						lista.add(f4101);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4101 f4101) {
				String[] registros = new String[7];
				registros[0] = f4101.getImlitm();
				registros[1] = f4101.getImdsc1();
				registros[2] = f4101.getImdsc2();
				registros[3] = f4101.getImsrtx();
				registros[4] = f4101.getImlnty();
				registros[5] = f4101.getImstkt();
				registros[6] = f4101.getImsrp1();
				return registros;
			}
		};
		catalogoF4101.setParent(divCatalogoF4101);
		catalogoF4101.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF4101")
	public void seleccionarItem() {
		F4101 f4101 = catalogoF4101.objetoSeleccionadoDelCatalogo();
		llenarCamposItem(f4101);
		catalogoF4101.setParent(null);
	}

	@Listen("onChange = #txtItm")
	public void buscarNombreItem() {
		F4101 f4101 = servicioF4101.buscar(txtItm.getValue());
		if (f4101 != null) {
			llenarCamposItem(f4101);
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtItm.setValue(null);
			txtItm.setFocus(true);
			txtUM.setValue("");
			txtCosto.setValue(null);
			lblItm.setValue("");
		}
	}

	private void llenarCamposItem(F4101 f4101) {
		limpiarCamposItem();
		txtItm.setValue(f4101.getImitm());
		txtUM.setValue(f4101.getImuom1());
		lblItm.setValue(f4101.getImdsc1());
		F4105 f4105 = new F4105();
		F4105PK clave = new F4105PK();
		clave.setCoitm(f4101.getImitm());
		clave.setColedg("02");
		clave.setColocn("");
		clave.setColotn("");
		clave.setComcu(mcu);
		f4105 = servicioF4105.buscar(clave);
		if (f4105 != null) {
			txtCosto.setValue(f4105.getCouncs());
		} else
			txtCosto.setValue(0);
	}

	private void limpiarCamposItem() {
		txtItm.setValue(null);
		txtUM.setValue("");
		lblItm.setValue("");
		txtCosto.setValue(null);
		spnCantidad.setValue(0);
	}

	@Listen("onClick = #btnBuscarEmpresa1,#btnBuscarEmpresa2")
	public void mostrarCatalogoF0010(Event e) {
		idBotonF0010 = e.getTarget().getId();
		final List<F0010> lista = servicioF0010.buscarTodosOrdenados();
		catalogoF0010 = new Catalogo<F0010>(divCatalogoF0010, "F0010", lista,
				true, false, false, "Codigo", "Nombre", "Nº Periodo", "Patron",
				"Inicio año Fiscal", "Periodo LM", "Inicio año C/P",
				"Periodo C/P", "Inicio año C/C", "Periodo C/C") {

			@Override
			protected List<F0010> buscar(List<String> valores) {

				List<F0010> lista2 = new ArrayList<F0010>();

				for (F0010 f0010 : lista) {
					String ccdot = "";
					if (f0010.getCcdot1() != null)
						ccdot = f0010.getCcdot1();
					if (f0010.getCcco().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f0010.getCcname().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& String.valueOf(f0010.getCcpnc()).toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& ccdot.toLowerCase().contains(valores.get(3).toLowerCase())
							&& f0010.getCcarfj().toString().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& String.valueOf(f0010.getCctxbm()).toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& f0010.getCcapfj().toString().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& String.valueOf(f0010.getCctxbo()).toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& f0010.getCcdfyj().toString().toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& String.valueOf(f0010.getCcpnf()).toLowerCase()
									.contains(valores.get(9).toLowerCase())) {
						lista2.add(f0010);
					}
				}
				return lista2;
			}

			@Override
			protected String[] crearRegistros(F0010 f0010) {
				String[] registros = new String[10];
				registros[0] = f0010.getCcco();
				registros[1] = f0010.getCcname();
				registros[2] = String.valueOf(f0010.getCcpnc());
				registros[3] = f0010.getCcdot1();
				registros[4] = f0010.getCcarfj().toString();
				registros[5] = String.valueOf(f0010.getCctxbm());
				registros[6] = f0010.getCcapfj().toString();
				registros[7] = String.valueOf(f0010.getCctxbo());
				registros[8] = f0010.getCcdfyj().toString();
				registros[9] = String.valueOf(f0010.getCcpnf());
				return registros;

			}
		};
		catalogoF0010.setParent(divCatalogoF0010);
		catalogoF0010.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0010")
	public void seleccionF0010() {
		F0010 f0010 = catalogoF0010.objetoSeleccionadoDelCatalogo();
		switch (idBotonF0010) {
		case "btnBuscarEmpresa1":
			setteaEmpresa(f0010, txtEmpresa1, lblEmpresa1);
			ccoB = f0010.getCcco();
			break;
		case "btnBuscarEmpresa2":
			setteaEmpresa(f0010, txtEmpresa2, lblEmpresa2);
			ccoA = f0010.getCcco();
			break;
		}
		catalogoF0010.setParent(null);
	}

	@Listen("onChange = #txtEmpresa1, #txtEmpresa2")
	public void buscarNombreEmpresa(Event evento) {
		F0010 f06 = new F0010();
		Textbox txt = (Textbox) evento.getTarget();
		switch (txt.getId()) {
		case "txtEmpresa1":
			f06 = servicioF0010.buscar(txtEmpresa1.getValue());
			if (f06 != null) {
				setteaEmpresa(f06, txtEmpresa1, lblEmpresa1);
				ccoA = f06.getCcco();
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				txtEmpresa1.setValue("");
				txtEmpresa1.setFocus(true);
				lblEmpresa1.setValue("");
			}
			break;
		case "txtEmpresa2":
			f06 = servicioF0010.buscar(txtEmpresa2.getValue());
			if (f06 != null) {
				setteaEmpresa(f06, txtEmpresa2, lblEmpresa2);
				ccoB = f06.getCcco();
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				txtEmpresa2.setValue("");
				txtEmpresa2.setFocus(true);
				lblEmpresa2.setValue("");
			}
			break;
		}
	}

	private void setteaEmpresa(F0010 f0010, Textbox txtEmpresa12,
			Label lblEmpresa12) {
		txtEmpresa12.setValue(f0010.getCcco());
		lblEmpresa12.setValue(f0010.getCcname());
	}

	private boolean validarItems() {
		if (txtEmpresa2.getText().compareTo("") == 0
				|| txtPlanta2.getText().compareTo("") == 0
				|| txtItm.getText().compareTo("") == 0
				|| txtUbicacion.getText().compareTo("") == 0
				|| spnCantidad.getValue() == 0)
			return false;
		else
			return true;
	}

	@Listen("onClick = #btnAgregar")
	public void annadirLista() {
		if (validarItems()) {
			F4211 f4211 = new F4211();
			Double item = txtItm.getValue();
			String um = txtUM.getValue();
			double costo = txtCosto.getValue();
			int cantidad = spnCantidad.getValue();
			double total = costo * cantidad;
			String emcu = txtPlanta2.getValue();
			String locn = txtUbicacion.getValue();
			f4211.setSditm(item);
			f4211.setSduom(um);
			f4211.setSduncs(costo);
			f4211.setSdpqor((double) cantidad);
			f4211.setSdecst(total);
			f4211.setSdemcu(emcu);
			f4211.setSdlocn(locn);
			boolean error = false;
			for (int i = 0; i < ltbPedidos.getItemCount(); i++) {
				Listitem listItem = ltbPedidos.getItemAtIndex(i);
				F4211 modeloLista = listItem.getValue();
				if (modeloLista.getSditm().equals(item)) {
					error = true;
				}
			}
			if (!error) {
				listaPedido.add(f4211);
				ltbPedidos.setModel(new ListModelList<F4211>(listaPedido));
				ltbPedidos.renderAll();
				limpiarCamposItem();
			} else
				msj.mensajeAlerta(Mensaje.itemRepetido);
		} else
			msj.mensajeAlerta(Mensaje.camposVaciosItem);
	}

	@Listen("onClick = #btnVer")
	public void seleccionarItemLista() {
		if (ltbPedidos.getItemCount() != 0) {
			if (ltbPedidos.getSelectedItems().size() == 1) {
				Listitem listItem = ltbPedidos.getSelectedItem();
				F4211 modelo = listItem.getValue();
				Double item = modelo.getSditm();
				String um = modelo.getSduom();
				Double costo = modelo.getSduncs();
				Double cantidad = modelo.getSdpqor();
				String emcu = modelo.getSdemcu();
				String locn = modelo.getSdlocn();
				txtItm.setValue(item);
				txtUM.setValue(um);
				txtCosto.setValue(costo);
				spnCantidad.setValue(cantidad.intValue());
				txtPlanta2.setValue(emcu);
				txtUbicacion.setValue(locn);
				ltbPedidos.removeItemAt(listItem.getIndex());
				listaPedido.remove(modelo);
				ltbPedidos.renderAll();
			} else
				msj.mensajeAlerta(Mensaje.editarSoloUno);
		} else
			msj.mensajeAlerta(Mensaje.noHayRegistros);
	}

	@Listen("onClick = #btnRemover")
	public void removerItem() {
		if (ltbPedidos.getItemCount() != 0) {
			if (ltbPedidos.getSelectedItems().size() == 1) {
				Listitem listItem = ltbPedidos.getSelectedItem();
				F4211 modelo = listItem.getValue();
				int i = listItem.getIndex();
				ltbPedidos.removeItemAt(i);
				listaPedido.remove(modelo);
				ltbPedidos.renderAll();
			} else
				msj.mensajeAlerta(Mensaje.editarSoloUno);
		} else
			msj.mensajeAlerta(Mensaje.noHayRegistros);
	}
	
	@Listen("onClick = #btnAgregarItems")
	public void mostrarGroupbox() {
		gpxItems.setVisible(true);
		rowBoton.setVisible(false);

	}
}
