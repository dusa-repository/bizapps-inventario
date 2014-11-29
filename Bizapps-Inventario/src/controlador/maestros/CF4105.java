package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F4101;
import modelo.maestros.F4105;
import modelo.pk.F4105PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
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
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;
import controlador.maestros.CGenerico;

public class CF4105 extends CGenerico {

	private static final long serialVersionUID = -8125584559854362521L;

	@Wire
	private Div divVF4105;
	@Wire
	private Div botoneraF4105;
	@Wire
	private Div catalogoF4105;
	@Wire
	private Div divBuscadorCSMT;
	BuscadorUDC buscadorCSMT;
	@Wire
	private Div divBuscadorPCSM;
	BuscadorUDC buscadorPCSM;
	@Wire
	private Div divBuscadorLEDG;
	BuscadorUDC buscadorLEDG;
	@Wire
	private Div divCatalogoF4101;
	@Wire
	private Div divCatalogoF0006;
	@Wire
	private Doublebox txtItm;
	@Wire
	private Label lblItm;
	@Wire
	private Textbox txtMcu;
	@Wire
	private Label lblMcu;
	@Wire
	private Textbox txtLitm;
	@Wire
	private Doublespinner spnCosto;
	@Wire
	private Listbox ltbCostos;
	@Wire
	private Groupbox gpxDatosF4105;
	@Wire
	private Groupbox gpxRegistroF4105;
	@Wire
	private Button btnBuscarItm;
	@Wire
	private Button btnBuscarMcu;
	@Wire
	private Button btnAgregarItems;
	@Wire
	private Groupbox gpxItems;
	protected List<F4105> listaGeneral = new ArrayList<F4105>();
	
	Botonera botonera;
	CatalogoGenerico<F4105> catalogo;
	CatalogoGenerico<F4101> catalogoF4101;
	CatalogoGenerico<F0006> catalogoF0006;
	F4105PK clave = null;
	List<F4105> listaCosto = new ArrayList<F4105>();

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
		btnAgregarItems.setVisible(true);
		// Faltan 2 UDC POR PREGUNTAR
		cargarBuscadores();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						F4105 f4105 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f4105.getId();
						abrirRegistro();
						// buscadorLEDG.settearCampo(servicioF0005.buscar("40",
						// "CM", f4105.getId().getColedg()));
						// settear las demas UDC
						txtItm.setValue(f4105.getId().getCoitm());
						F4101 f41 = servicioF4101.buscar(f4105.getId()
								.getCoitm());
						lblItm.setValue(f41.getImdsc1());
						txtMcu.setValue(f4105.getId().getComcu());
						F0006 f06 = servicioF0006.buscar(f4105.getId()
								.getComcu());
						lblMcu.setValue(f06.getMcdl01());
						List<F4105> lista = servicioF4105.buscarPorMcuEItem(
								f4105.getId().getComcu(), f4105.getId()
										.getCoitm());
						for (int i = 0; i < lista.size(); i++) {
							F4105 f41052 = lista.get(i);
							listaCosto.add(f41052);
						}
						ltbCostos.setModel(new ListModelList<F4105>(lista));
						ltbCostos.renderAll();
						txtItm.setDisabled(true);
						txtMcu.setDisabled(true);
						btnBuscarItm.setVisible(false);
						btnBuscarMcu.setVisible(false);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF4105, titulo , tabs);
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
				
				if (validar()) {
					F4105 f4105 = new F4105();
					if (clave == null) {
						clave = new F4105PK();
						clave.setCoitm(txtItm.getValue());
						clave.setColocn("");
						clave.setColotn("");
						clave.setComcu(txtMcu.getValue());
					}
					if (listaCosto.isEmpty()) {
						clave.setColedg("");
						f4105.setId(clave);
						// settear udcs
						servicioF4105.guardar(f4105);
					} else {
						List<F4105> guardados = new ArrayList<F4105>();
						for (int i = 0; i < listaCosto.size(); i++) {
							F4105 f41052 = listaCosto.get(i);
							clave.setColedg(f41052.getId().getColedg());
							f4105 = new F4105();
							f4105.setId(clave);
							f4105.setColitm(f41052.getColitm());
							f4105.setCouncs(f41052.getCouncs());
							// settear udcs
							servicioF4105.guardar(f4105);
						}
//						servicioF4105.guardarVarios(guardados);
					}
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					listaGeneral = servicioF4105.buscarTodosOrdenados();
					catalogo.actualizarLista(listaGeneral);
				}
			}

			@Override
			public void eliminar() {

				if (gpxDatosF4105.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F4105> eliminarLista = catalogo
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
													servicioF4105
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													listaGeneral = servicioF4105.buscarTodosOrdenados();
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
													servicioF4105
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													listaGeneral = servicioF4105.buscarTodosOrdenados();
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
		botoneraF4105.appendChild(botonera);
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

	@Listen("onClick = #gpxRegistroF4105")
	public void abrirRegistro() {
		gpxDatosF4105.setOpen(false);
		gpxRegistroF4105.setOpen(true);
		mostrarBotones(false);
	}

	@Listen("onOpen = #gpxDatosF4105")
	public void abrirCatalogo() {
		gpxDatosF4105.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF4105.setOpen(false);
								gpxRegistroF4105.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF4105.setOpen(true);
									gpxRegistroF4105.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF4105.setOpen(true);
			gpxRegistroF4105.setOpen(false);
			mostrarBotones(true);
		}
	}

	public boolean camposLLenos() {
		if (txtMcu.getText().compareTo("") == 0
				|| txtItm.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	private boolean camposEditando() {
		if (txtLitm.getText().compareTo("") != 0
				|| txtMcu.getText().compareTo("") != 0
				|| txtItm.getText().compareTo("") != 0
				|| ltbCostos.getItemCount() != 0 || listaCosto.size() != 0) {
			return true;
		} else
			return false;
	}

	protected boolean validar() {
		if (!camposLLenos()) {
			msj.mensajeError(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	protected void habilitarTextClave() {
		if (txtItm.isDisabled()) {
			txtItm.setDisabled(false);
			btnBuscarItm.setDisabled(false);
			btnBuscarMcu.setDisabled(false);
			txtMcu.setDisabled(false);
		}
	}

	protected void limpiarCampos() {
		txtLitm.setValue("");
		lblItm.setValue("");
		txtMcu.setValue("");
		lblMcu.setValue("");
		txtItm.setValue(null);
		ltbCostos.setModel(new ListModelList<F4105>());
		listaCosto = new ArrayList<F4105>();
		spnCosto.setValue((double) 0);
		buscadorCSMT.settearCampo(null);
		buscadorLEDG.settearCampo(null);
		buscadorPCSM.settearCampo(null);
		gpxItems.setVisible(false);
		btnAgregarItems.setVisible(true);
		btnBuscarItm.setVisible(true);
		btnBuscarMcu.setVisible(true);
		
		
	}

	protected boolean validarSeleccion() {
		List<F4105> seleccionados = catalogo.obtenerSeleccionados();
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

	public void cargarBuscadores() {
		List<F0005> listF0005 = servicioF0005
				.buscarParaUDCOrdenados("01", "ST");
		buscadorCSMT = new BuscadorUDC("Ventas/Inventario", 10, listF0005,
				false, false, false, "01", "ST") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "ST",
						buscadorCSMT.obtenerCaja());
			}
		};
		divBuscadorCSMT.appendChild(buscadorCSMT);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("40", "CM");
		buscadorLEDG = new BuscadorUDC("Metodo Calculo", 2, listF0005, true,
				false, false, "40", "CM") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "CM",
						buscadorLEDG.obtenerCaja());
			}
		};
		divBuscadorLEDG.appendChild(buscadorLEDG);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("00", "CT");
		buscadorPCSM = new BuscadorUDC("Compras", 25, listF0005, false, false,
				false, "00", "CT") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "CT",
						buscadorPCSM.obtenerCaja());
			}
		};
		divBuscadorPCSM.appendChild(buscadorPCSM);
	}

	public void mostrarCatalogo() {

		listaGeneral = servicioF4105.buscarTodosOrdenados();
		catalogo = new CatalogoGenerico<F4105>(catalogoF4105, "F0005", listaGeneral,
				false, false, false, "Nro Articulo", "Sucursal / Planta",
				"Nivel Costo") {

			@Override
			protected List<F4105> buscar(List<String> valores) {

				List<F4105> listF0005_2 = new ArrayList<F4105>();

				for (F4105 f0005 : listaGeneral) {
					if (String.valueOf(f0005.getId().getCoitm().longValue()).toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f0005.getId().getComcu().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& f0005.getId().getColedg().toLowerCase()
									.contains(valores.get(2).toLowerCase())) {
						listF0005_2.add(f0005);
					}
				}
				return listF0005_2;
			}

			@Override
			protected String[] crearRegistros(F4105 f0005) {
				String[] registros = new String[3];
				registros[0] = String.valueOf(f0005.getId().getCoitm().longValue());
				registros[1] = f0005.getId().getComcu();
				registros[2] = f0005.getId().getColedg();
				;
				return registros;
			}
		};
		catalogo.setParent(catalogoF4105);
	}

	@Listen("onClick = #btnBuscarMcu")
	public void mostrarCatalogoF0006() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoF0006 = new CatalogoGenerico<F0006>(divCatalogoF0006, "Catalogo de Unidades de Negocio",
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
		setearPlanta(f06, txtMcu, lblMcu);
		catalogoF0006.setParent(null);
	}

	@Listen("onChange = #txtMcu; onOk = #txtMcu")
	public void buscarNombreSucursal() {
		F0006 f06 = servicioF0006.buscar(txtMcu.getValue());
		if (f06 != null) {
			setearPlanta(f06, txtMcu, lblMcu);
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtMcu.setValue("");
			txtMcu.setFocus(true);
			lblMcu.setValue("");
		}
	}

	private void setearPlanta(F0006 f06, Textbox txtPlanta12, Label lblPlanta12) {
		txtPlanta12.setValue(f06.getMcmcu());
		lblPlanta12.setValue(f06.getMcdl01());
	}

	@Listen("onClick = #btnBuscarItm")
	public void mostrarCatalogoF4101() {
		final List<F4101> listF4101 = servicioF4101.buscarTodosOrdenados();
		catalogoF4101 = new CatalogoGenerico<F4101>(divCatalogoF4101, "Catalogo de Artículos",
				listF4101, true, false, false, "Número artículo",
				"Descripción", "Descripción 2", "Texto búsqueda", "Tipo línea",
				"Tipo alm", "Código vta 1") {

			@Override
			protected List<F4101> buscar(List<String> valores) {

				List<F4101> lista = new ArrayList<F4101>();

				for (F4101 f4101 : listF4101) {
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
							&& f4101.getImsrp1().toLowerCase()
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

	@Listen("onChange = #txtItm; onOk = #txtItm")
	public void buscarNombreItem() {
		F4101 f4101 = servicioF4101.buscar(txtItm.getValue());
		if (f4101 != null) {
			llenarCamposItem(f4101);
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtItm.setValue(null);
			txtItm.setFocus(true);
			lblItm.setValue("");
		}
	}

	private void llenarCamposItem(F4101 f4101) {
		txtItm.setValue(f4101.getImitm());
		lblItm.setValue(f4101.getImdsc1());
	}

	private boolean validarItems() {
		if (buscadorLEDG.obtenerCaja().compareTo("") == 0
				|| spnCosto.getValue() == 0)
			return false;
		else
			return true;
	}

	@Listen("onClick = #btnAgregar")
	public void annadirLista() {
		if (validarItems()) {
			F4105 f4105 = new F4105();
			F4105PK f4105Pk = new F4105PK();
			String itemNombre = txtLitm.getValue();
			String udc = buscadorLEDG.obtenerCaja();
			double costo = spnCosto.getValue();
			f4105Pk.setColedg(udc);
			f4105.setId(f4105Pk);
			f4105.setColitm(itemNombre);
			f4105.setCouncs(costo);
			boolean error = false;
			for (int i = 0; i < ltbCostos.getItemCount(); i++) {
				Listitem listItem = ltbCostos.getItemAtIndex(i);
				F4105 modeloLista = listItem.getValue();
				if (modeloLista.getId().getColedg().equals(udc)) {
					error = true;
				}
			}
			if (!error) {
				listaCosto.add(f4105);
				ltbCostos.setModel(new ListModelList<F4105>(listaCosto));
				ltbCostos.renderAll();
				limpiarCamposItem();
			} else
				msj.mensajeAlerta(Mensaje.itemRepetido);
		} else
			msj.mensajeAlerta(Mensaje.camposVaciosItem);
	}

	@Listen("onClick = #btnVer")
	public void seleccionarItemLista() {
		if (ltbCostos.getItemCount() != 0) {
			if (ltbCostos.getSelectedItems().size() == 1) {
				Listitem listItem = ltbCostos.getSelectedItem();
				F4105 modelo = listItem.getValue();
				Double costo = modelo.getCouncs();
				String descripcion = modelo.getColitm();
				String udc = modelo.getId().getColedg();
				F0005 f05 = servicioF0005.buscar("40", "CM", udc);
				buscadorLEDG.settearCampo(f05);
				txtLitm.setValue(descripcion);
				spnCosto.setValue(costo);
				ltbCostos.removeItemAt(listItem.getIndex());
				listaCosto.remove(modelo);
				ltbCostos.renderAll();
			} else
				msj.mensajeAlerta(Mensaje.editarSoloUno);
		} else
			msj.mensajeAlerta(Mensaje.noHayRegistros);
	}

	private void limpiarCamposItem() {
		txtLitm.setValue("");
		spnCosto.setValue((double) 0);
		buscadorLEDG.settearCampo(null);
	}

	@Listen("onClick = #btnRemover")
	public void removerItem() {
		if (ltbCostos.getItemCount() != 0) {
			if (ltbCostos.getSelectedItems().size() == 1) {
				Listitem listItem = ltbCostos.getSelectedItem();
				F4105 modelo = listItem.getValue();
				int i = listItem.getIndex();
				ltbCostos.removeItemAt(i);
				listaCosto.remove(modelo);
				ltbCostos.renderAll();
			} else
				msj.mensajeAlerta(Mensaje.editarSoloUno);
		} else
			msj.mensajeAlerta(Mensaje.noHayRegistros);
	}
	
	@Listen("onClick = #btnAgregarItems")
	public void mostrarGroupbox() {
		gpxItems.setVisible(true);
		btnAgregarItems.setVisible(false);

	}

}
