package controlador.maestros;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F0013;
import modelo.maestros.F0101;
import modelo.maestros.F4008;
import modelo.maestros.F4101;
import modelo.maestros.F4105;
import modelo.maestros.F4301;
import modelo.maestros.F4311;
import modelo.pk.F4105PK;
import modelo.pk.F4301PK;
import modelo.pk.F4311PK;

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

public class CF4301 extends CGenerico {

	@Wire
	private Div divVF4301;
	@Wire
	private Div botoneraF4301;
	@Wire
	private Groupbox gpxRegistroF4301;
	@Wire
	private Groupbox gpxRegistro1F4301;
	@Wire
	private Longbox txtDOCOF4301;
	@Wire
	private Textbox txtDCTOF4301;
	@Wire
	private Textbox txtKCOOF4301;
	@Wire
	private Textbox txtSFXOF4301;
	@Wire
	private Textbox txtMCUF4301;
	@Wire
	private Button btnBuscarSucPlantaF0006;
	@Wire
	private Label lblSucPlantaF0006;
	@Wire
	private Textbox txtCRCDF4301;
	@Wire
	private Button btnBuscarMonedaF0013;
	@Wire
	private Label lblMonedaF0013;
	@Wire
	private Doublebox txtCRRF4301;
	@Wire
	private Label lblTipoDireccionF0101;
	@Wire
	private Label lblTipoDireccion2F0101;
	@Wire
	private Groupbox gpxNumeroDireccionF4301;
	@Wire
	private Longbox txtAN8F4301;
	@Wire
	private Button btnBuscarProveedorF0101;
	@Wire
	private Label lblProveedoresF0101;
	@Wire
	private Longbox txtSHANF4301;
	@Wire
	private Button btnBuscarDestinoF0101;
	@Wire
	private Label lblDestinoF0101;
	@Wire
	private Longbox txtANBYF4301;
	@Wire
	private Button btnBuscarCompradorF0101;
	@Wire
	private Label lblCompradorF0101;
	@Wire
	private Longbox txtANCRF4301;
	@Wire
	private Label lblTransportistaF0101;
	@Wire
	private Textbox txtRMKF4301;
	@Wire
	private Label lblObservacion;
	@Wire
	private Label lblObservacion2;
	@Wire
	private Textbox txtDESCF4301;
	@Wire
	private Label lblDescripcion;
	@Wire
	private Label lblMensaje2;
	@Wire
	private Groupbox gpxRegistroF43012;
	@Wire
	private Button btnBuscarF0006;
	@Wire
	private Groupbox gpxRegistro2F4301;
	@Wire
	private Textbox txtTXA1F4301;
	@Wire
	private Label lblZonaV4008;
	@Wire
	private Textbox txtTXCTF4301;
	@Wire
	private Label lblCertificadoF0013;
	@Wire
	private Textbox txtPCRTF4301;
	@Wire
	private Label lblRetencion;
	@Wire
	private Textbox txtABTAXF4301;
	@Wire
	private Label lblIdFiscalF0101;
	@Wire
	private Textbox txtTKBYF4301;
	@Wire
	private Label lblOrdenPor;
	@Wire
	private Textbox txtPTCF4301;
	@Wire
	private Label lblCondicionPagoF0101;
	@Wire
	private Groupbox gpxDatosF4301;
	@Wire
	private Div catalogoF4301;
	@Wire
	private Div divCatalogoMonedaF0013;
	@Wire
	private Div divCatalogoSucPlantaF0006;
	@Wire
	private Div divCatalogooLibroDireccionesF0101;
	@Wire
	private Div divCatalogooTaxAreasV4008;
	@Wire
	private Datebox dtbTRDJF4301;
	@Wire
	private Datebox dtbDRQJF4301;
	@Wire
	private Datebox dtbPDDJF4301;
	@Wire
	private Datebox dtbCNDJF4301;
	@Wire
	private Button btnBuscarRifF0101;
	@Wire
	private Button btnBuscarTaxAreasV4008;
	@Wire
	private Groupbox gpxItems;
	@Wire
	private Row rowBoton;
	@Wire
	private Div divBuscadorINMG;
	BuscadorUDC buscadorINMG;
	@Wire
	private Div divBuscadorEXR1;
	BuscadorUDC buscadorEXR1;
	@Wire
	private Div divBuscadorHOLD;
	BuscadorUDC buscadorHOLD;
	@Wire
	private Div divBuscadorFUF1;
	BuscadorUDC buscadorFUF1;
	// DETALLE
	@Wire
	private Doublebox txtITMF4311;
	@Wire
	private Doublebox txtLNIDF4311;
	@Wire
	private Textbox txtDSC1F4311;
	@Wire
	private Textbox txtDSC2F4311;
	@Wire
	private Doublebox txtPRRCF4311;
	@Wire
	private Doublebox txtAEXPF4311;
	@Wire
	private Textbox txtVR01F4311;
	@Wire
	private Textbox txtOORNF4311;
	@Wire
	private Textbox txtMCUF4311;
	@Wire
	private Label lblPDITMF4311;
	@Wire
	private Label lblMCUF4311;
	@Wire
	private Doublespinner spnUORGF4311;
	@Wire
	private Button btnBuscarF4101;
	@Wire
	private Button btnAgregar;
	@Wire
	private Button btnBuscarF0011;
	@Wire
	private Div divBuscadorUOM;
	BuscadorUDC buscadorUOM;
	@Wire
	private Div divBuscadorLTTR;
	BuscadorUDC buscadorLTTR;
	@Wire
	private Div divBuscadorNXTR;
	BuscadorUDC buscadorNXTR;
	@Wire
	private Div divCatalogoF4101;
	@Wire
	private Div divCatalogoF0011;
	@Wire
	private Listbox ltbItems;
	List<F4311> listaDetalle = new ArrayList<F4311>();

	private static SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

	private Botonera botonera;
	private Catalogo<F4301> catalogo;
	Catalogo<F0013> catalogoF0013;
	Catalogo<F0006> catalogoF0006;
	Catalogo<F4008> catalogoF4008;
	Catalogo<F0101> catalogoF0101;
	Catalogo<F4101> catalogoF4101;
	// Catalogo<F0011> catalogoF0011;
	private F4301PK clave = null;
	String idBoton = "";

	@Override
	public void inicializar() throws IOException {
		HashMap<String, Object> map = (HashMap<String, Object>) Sessions.getCurrent().getAttribute("mapaGeneral");
		if (map != null) {
			if (map.get("tabsGenerales") != null) {
				tabs = (List<Tab>) map.get("tabsGenerales");
				map.clear();
				map = null;
			}
		}

		buscadorINMG = crearCampoUDC(divBuscadorINMG, "Mensaje imprimir", "40", "PM");
		buscadorEXR1 = crearCampoUDC(divBuscadorEXR1, "Cod expl fiscal", "00", "EX");
		buscadorHOLD = crearCampoUDC(divBuscadorHOLD, "Cod retencion", "42", "HC");
		buscadorFUF1 = crearCampoUDC(divBuscadorFUF1, "Doc A\'A", "40", "FU");
		// Detalles
		buscadorUOM = crearCampoUDC(divBuscadorUOM, "UM", "00", "UM");
		buscadorLTTR = crearCampoUDC(divBuscadorLTTR, "Ultimo Estado", "40", "AT");
		buscadorNXTR = crearCampoUDC(divBuscadorNXTR, "Siguiente Estado", "40", "AT");
		mostrarCatalogo();
		txtLNIDF4311.setValue(listaDetalle.size() + 1);
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccionEncabezado()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						abrirRegistro();
						F4301 f4301 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f4301.getId();
						listaDetalle.clear();
						ltbItems.setModel(new ListModelList<F4311>(listaDetalle));
						ltbItems.renderAll();
						txtDCTOF4301.setValue(clave.getPhdcto());
						txtDOCOF4301.setValue(Math.round(clave.getPhdoco()));
						txtKCOOF4301.setValue(clave.getPhkcoo());
						txtMCUF4301.setValue(f4301.getPhmcu());
						if (f4301.getPhmcu().equals("")) {
							F0006 f0006 = servicioF0006.buscar(f4301.getPhmcu());
							lblSucPlantaF0006.setValue(f0006.getMcdc());
						}
						txtCRCDF4301.setValue(f4301.getPhcrcd());
						if (!f4301.getPhcrcd().equals("")) {
							F0013 f0013 = servicioF0013.buscar(f4301.getPhcrcd());
							lblMonedaF0013.setValue(f0013.getCvdl01());
						}
						F0101 f0101;
						f0101 = servicioF0101.buscar(f4301.getPhan8());
						if (f0101 != null) {
							lblProveedoresF0101.setValue(f0101.getAbalph());
						}
						f0101 = servicioF0101.buscar(f4301.getPhshan());
						if (f0101 != null) {
							lblDestinoF0101.setValue(f0101.getAbalph());
						}
						f0101 = servicioF0101.buscar(f4301.getPhanby());
						if (f0101 != null) {
							lblCompradorF0101.setValue(f0101.getAbalph());
						}
						f0101 = servicioF0101.buscar(f4301.getPhancr());
						if (f0101 != null) {
							lblTransportistaF0101.setValue(f0101.getAbalph());
						}
						f0101 = servicioF0101.buscar(f4301.getPhan8()); // no
																		// se
																		// si
																		// es
																		// asi
						if (f0101 != null) {
							lblTransportistaF0101.setValue(f0101.getAbalph());
						}
						// F4008 f4008 =
						// servicioF4008.buscarPorTatxa1(f4301.getPhtxa1()).get(0);
						// lblZonaV4008.setValue(f4008.getId().getTatxa1());
						buscadorINMG.settearCampo(servicioF0005.buscar("40",
								"PM", f4301.getPhinmg()));
						buscadorEXR1.settearCampo(servicioF0005.buscar("00",
								"EX", f4301.getPhexr1()));
						buscadorHOLD.settearCampo(servicioF0005.buscar("42",
								"HC", f4301.getPhhold()));
						buscadorFUF1.settearCampo(servicioF0005.buscar("40",
								"FU", f4301.getPhfuf1()));
						txtAN8F4301.setValue(Math.round(f4301.getPhan8()));
						txtANBYF4301.setValue(Math.round(f4301.getPhanby()));
						txtANCRF4301.setValue(Math.round(f4301.getPhancr()));
						txtCRRF4301.setValue(f4301.getPhcrr());
						txtDESCF4301.setValue(f4301.getPhdesc());
						txtPCRTF4301.setValue(String.valueOf(f4301.getPhpcrt()));
						txtPTCF4301.setValue(f4301.getPhptc());
						txtRMKF4301.setValue(f4301.getPhrmk());
						txtSHANF4301.setValue(Math.round(f4301.getPhshan()));
						txtTKBYF4301.setValue(f4301.getPhtkby());
						txtTXA1F4301.setValue(f4301.getPhtxa1());
						txtTXCTF4301.setValue(f4301.getPhtxct());
						dtbCNDJF4301.setValue(transformarJulianaAGregoria(f4301.getPhcndj()));
						dtbDRQJF4301.setValue(transformarJulianaAGregoria(f4301.getPhdrqj()));
						dtbPDDJF4301.setValue(transformarJulianaAGregoria(f4301.getPhpddj()));
						dtbTRDJF4301.setValue(transformarJulianaAGregoria(f4301.getPhtrdj()));
						List<F4311> lista = servicioF4311.buscarPorDocoDctoKcooYSfxo(clave.getPhdoco(),
								clave.getPhdcto(), clave.getPhkcoo(), clave.getPhsfxo());
						listaDetalle.addAll(lista);
						ltbItems.setModel(new ListModelList<F4311>(listaDetalle));
						ltbItems.renderAll();
						botonera.getChildren().get(2).setVisible(true);
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
				abrirRegistro();
				mostrarBotones(false);
			}

			@Override
			public void guardar() {
				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {
					F4301 f4301 = new F4301();
					F4301PK clavePk = new F4301PK();
					clavePk.setPhdcto(txtDCTOF4301.getValue());
					clavePk.setPhdoco(txtDOCOF4301.getValue());
					clavePk.setPhkcoo(txtKCOOF4301.getValue());
					clavePk.setPhsfxo(txtSFXOF4301.getValue());
					f4301.setId(clavePk);
					f4301.setPhan8(txtAN8F4301.getValue());
					f4301.setPhanby(txtANBYF4301.getValue());
					f4301.setPhancr(txtANCRF4301.getValue());
					f4301.setPhcrcd(txtCRCDF4301.getValue());
					f4301.setPhcrr(txtCRRF4301.getValue());
					f4301.setPhdesc(txtDESCF4301.getValue());
					f4301.setPhmcu(txtMCUF4301.getValue());
					f4301.setPhpcrt(Double.parseDouble(txtPCRTF4301.getValue()));
					f4301.setPhptc(txtPTCF4301.getValue());
					f4301.setPhrmk(txtRMKF4301.getValue());
					f4301.setPhshan(txtSHANF4301.getValue());
					f4301.setPhtkby(txtTKBYF4301.getValue());
					f4301.setPhtxa1(txtTXA1F4301.getValue());
					f4301.setPhtxct(txtTXCTF4301.getValue());
					f4301.setPhcndj(transformarGregorianoAJulia(dtbCNDJF4301.getValue()));
					f4301.setPhdrqj(transformarGregorianoAJulia(dtbDRQJF4301.getValue()));
					f4301.setPhpddj(transformarGregorianoAJulia(dtbPDDJF4301.getValue()));
					f4301.setPhtrdj(transformarGregorianoAJulia(dtbTRDJF4301.getValue()));
					f4301.setPhinmg(buscadorINMG.obtenerCaja());
					f4301.setPhexr1(buscadorEXR1.obtenerCaja());
					f4301.setPhhold(buscadorHOLD.obtenerCaja());
					f4301.setPhfuf1(buscadorFUF1.obtenerCaja());
					servicioF4301.guardar(f4301);
					for (F4311 modelo : listaDetalle) {
						modelo.getId().setPddcto(txtDCTOF4301.getValue());
						modelo.getId().setPddoco(txtDOCOF4301.getValue());
						modelo.getId().setPdkcoo(txtKCOOF4301.getValue());
						modelo.getId().setPdsfxo(txtSFXOF4301.getValue());
						modelo.setPdan8(txtAN8F4301.getValue());
						modelo.setPdcrcd(txtCRCDF4301.getValue());
						servicioF4311.guardar(modelo);
					}
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF4301.buscarTodosOrdenados());
				}
			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
				clave = null;
			}

			@Override
			public void reporte() {

			}

			@Override
			public void salir() {
				cerrarVentana(divVF4301, "Orden de Compra Normal", tabs);
			}

			@Override
			public void eliminar() {
				msj.mensajeAlerta(Mensaje.noSeleccionoRegistro);
			}

			@Override
			public void ayuda() {
			}

		};
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF4301.appendChild(botonera);
	}

	@Listen("onClick = #gpxRegistroF4301")
	public void abrirRegistro() {
		gpxDatosF4301.setOpen(false);
		gpxRegistroF4301.setOpen(true);
		mostrarBotones(false);
	}

	@Listen("onOpen = #gpxDatosF4301")
	public void abrirCatalogo() {
		gpxDatosF4301.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt) throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF4301.setOpen(false);
								gpxRegistroF4301.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF4301.setOpen(true);
									gpxRegistroF4301.setOpen(false);
									limpiarCampos();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF4301.setOpen(true);
			gpxRegistroF4301.setOpen(false);
			mostrarBotones(true);
		}
	}

	private boolean camposEditando() {
		if (txtABTAXF4301.getText().compareTo("") != 0 || txtAN8F4301.getText().compareTo("") != 0
				|| txtANBYF4301.getText().compareTo("") != 0 || txtANCRF4301.getText().compareTo("") != 0
				|| txtCRCDF4301.getText().compareTo("") != 0 || txtCRRF4301.getText().compareTo("") != 0
				|| txtDESCF4301.getText().compareTo("") != 0 || txtDOCOF4301.getText().compareTo("") != 0
				|| txtKCOOF4301.getText().compareTo("") != 0 || txtMCUF4301.getText().compareTo("") != 0
				|| txtPCRTF4301.getText().compareTo("") != 0 || txtPTCF4301.getText().compareTo("") != 0
				|| txtRMKF4301.getText().compareTo("") != 0 || txtSHANF4301.getText().compareTo("") != 0
				|| txtTKBYF4301.getText().compareTo("") != 0 || txtTXA1F4301.getText().compareTo("") != 0
				|| txtTXCTF4301.getText().compareTo("") != 0 || dtbTRDJF4301.getText().compareTo("") != 0
				|| dtbDRQJF4301.getText().compareTo("") != 0 || dtbPDDJF4301.getText().compareTo("") != 0
				|| dtbCNDJF4301.getText().compareTo("") != 0)
			return true;
		return false;
	}

	public void limpiarCampos() {
		clave = null;
		txtABTAXF4301.setValue("");
		txtAN8F4301.setValue(null);
		txtANBYF4301.setValue(null);
		txtANCRF4301.setValue(null);
		txtCRCDF4301.setValue("");
		txtCRRF4301.setValue(null);
		txtDESCF4301.setValue("");
		txtDOCOF4301.setValue(null);
		txtKCOOF4301.setValue("");
		txtMCUF4301.setValue("");
		txtPCRTF4301.setValue("");
		txtPTCF4301.setValue("");
		txtRMKF4301.setValue("");
		txtSHANF4301.setValue(null);
		txtTKBYF4301.setValue("");
		txtTXA1F4301.setValue("");
		txtTXCTF4301.setValue("");
		lblCertificadoF0013.setValue("");
		lblCompradorF0101.setValue("");
		lblCondicionPagoF0101.setValue("");
		lblDescripcion.setValue("");
		lblDestinoF0101.setValue("");
		lblIdFiscalF0101.setValue("");
		lblMonedaF0013.setValue("");
		lblObservacion.setValue("");
		lblOrdenPor.setValue("");
		lblProveedoresF0101.setValue("");
		lblRetencion.setValue("");
		lblSucPlantaF0006.setValue("");
		lblZonaV4008.setValue("");
		lblTipoDireccion2F0101.setValue("");
		lblTipoDireccionF0101.setValue("");
		lblTransportistaF0101.setValue("");
		buscadorEXR1.limpiarCampo();
		buscadorFUF1.limpiarCampo();
		buscadorHOLD.limpiarCampo();
		buscadorINMG.limpiarCampo();
		dtbTRDJF4301.setValue(null);
		dtbDRQJF4301.setValue(null);
		dtbPDDJF4301.setValue(null);
		dtbCNDJF4301.setValue(null);
		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(0).setVisible(false);
		listaDetalle.clear();
		ltbItems.setModel(new ListModelList<F4311>(listaDetalle));
		ltbItems.renderAll();
		limpiarCamposItem();
		catalogo.limpiarSeleccion();
	}

	public boolean validarSeleccionEncabezado() {
		List<F4301> seleccionados = catalogo.obtenerSeleccionados();
		System.out.println(catalogo.obtenerSeleccionados().size());
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

	public boolean camposLLenos() {
		if (txtDOCOF4301.getText().compareTo("") == 0 || txtDCTOF4301.getText().compareTo("") == 0
				|| txtKCOOF4301.getText().compareTo("") == 0 || txtSFXOF4301.getText().compareTo("") == 0)
			return false;
		return true;
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

	protected boolean validar() {
		if (!camposLLenos()) {
			msj.mensajeAlerta(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	public void mostrarCatalogo() {
		final List<F4301> listF4301 = servicioF4301.buscarTodosOrdenados();
		catalogo = new Catalogo<F4301>(catalogoF4301, "F4301", listF4301, false, true, true, "N° orden", "Tp ord",
				"Cía orden", "NP", "Descripción del proveedor", "Fecha orden", "Dir de entrg", "Comprador", "Cd rtn",
				"Importe", "Mon base", "Impte en mon ext", "Mon", "Suc/planta") {

			@Override
			protected List<F4301> buscar(List<String> valores) {
				List<F4301> lista = new ArrayList<F4301>();
				for (F4301 f4301 : listF4301) {
					if (String.valueOf(f4301.getId().getPhdoco()).toLowerCase().startsWith(valores.get(0))
							&& f4301.getId().getPhkcoo().toLowerCase().startsWith(valores.get(2))
							&& String.valueOf(f4301.getPhan8()).toLowerCase().startsWith(valores.get(3))
							&& String.valueOf(f4301.getPhtrdj()).toLowerCase().startsWith(valores.get(5))
							&& String.valueOf(f4301.getPhshan()).toLowerCase().startsWith(valores.get(6))
							&& String.valueOf(f4301.getPhanby()).toLowerCase().startsWith(valores.get(7))
							&& f4301.getPhhold().toLowerCase().startsWith(valores.get(8))) {
						lista.add(f4301);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4301 f4301) {
				String[] registros = new String[14];
				registros[0] = String.valueOf(f4301.getId().getPhdoco());
				registros[1] = f4301.getId().getPhdcto();
				registros[2] = f4301.getId().getPhkcoo();
				registros[3] = String.valueOf(f4301.getPhan8());
				registros[4] = servicioF0101.buscar(f4301.getPhan8()).getAbalph();
				registros[5] = String.valueOf(f4301.getPhtrdj());
				registros[6] = String.valueOf(f4301.getPhshan());
				registros[7] = String.valueOf(f4301.getPhanby());
				registros[8] = f4301.getPhhold();
				registros[9] = "";
				registros[10] = "";
				registros[11] = "";
				registros[12] = "";
				registros[13] = "";
				return registros;
			}
		};
		catalogo.setParent(catalogoF4301);
	}

	@Listen("onClick = #btnBuscarSucPlantaF0006")
	public void mostrarCatalogoF0006() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoF0006 = new Catalogo<F0006>(divCatalogoSucPlantaF0006, "F0006Emergente", unidades, true, false, false,
				"Unidad Negocio", "Descripcion", "Nivel det", "Cta", "Tipo UN", "LM Auxiliar Inactivo", "Mto Cons",
				"CAT 01", "CAT 02", "CAT 03", "CAT 04", "CAT 05", "CAT 06") {

			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					String mcdc = "";
					if (unidad.getMcdc() != null)
						mcdc = unidad.getMcdc();
					if (unidad.getMcmcu().toLowerCase().contains(valores.get(0).toLowerCase())
							&& mcdc.toLowerCase().contains(valores.get(1).toLowerCase())
							&& unidad.getMcldm().toLowerCase().contains(valores.get(2).toLowerCase())
							&& unidad.getMcco().toLowerCase().contains(valores.get(3).toLowerCase())
							&& unidad.getMcstyl().toLowerCase().contains(valores.get(4).toLowerCase())
							&& unidad.getMcfmod().toLowerCase().contains(valores.get(5).toLowerCase())
							&& unidad.getMcsbli().toLowerCase().contains(valores.get(6).toLowerCase())
							&& unidad.getMcrp01().toLowerCase().contains(valores.get(7).toLowerCase())
							&& unidad.getMcrp02().toLowerCase().contains(valores.get(8).toLowerCase())
							&& unidad.getMcrp03().toLowerCase().contains(valores.get(9).toLowerCase())
							&& unidad.getMcrp04().toLowerCase().contains(valores.get(10).toLowerCase())
							&& unidad.getMcrp05().toLowerCase().contains(valores.get(11).toLowerCase())
							&& unidad.getMcrp06().toLowerCase().contains(valores.get(12).toLowerCase())) {
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
		catalogoF0006.setParent(divCatalogoSucPlantaF0006);
		catalogoF0006.doModal();
	}

	@Listen("onSeleccion = #divCatalogoSucPlantaF0006")
	public void seleccionF0006() {
		F0006 f0006 = catalogoF0006.objetoSeleccionadoDelCatalogo();
		txtMCUF4301.setValue(String.valueOf(f0006.getMcmcu()));
		lblSucPlantaF0006.setValue(f0006.getMcdc());
		catalogoF0006.setParent(null);
	}

	@Listen("onClick = #btnBuscarMonedaF0013")
	public void mostrarCatalogoMoneda() {
		final List<F0013> listF0013 = servicioF0013.buscarTodosOrdenados();
		catalogoF0013 = new Catalogo<F0013>(divCatalogoMonedaF0013, "F0013", listF0013, true, false, false,
				"Codigo moneda", "Descripcion", "Vlslz", "Rutina cheques") {

			@Override
			protected List<F0013> buscar(List<String> valores) {

				List<F0013> lista = new ArrayList<F0013>();

				for (F0013 f0013 : listF0013) {
					if (f0013.getCvcrcd().toLowerCase().startsWith(valores.get(0))
							&& f0013.getCvdl01().toLowerCase().startsWith(valores.get(1))
							&& f0013.getCvcdec().toLowerCase().startsWith(valores.get(2))
							&& f0013.getCvckr().toLowerCase().startsWith(valores.get(4))) {
						lista.add(f0013);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0013 f013) {
				String[] registros = new String[4];
				registros[0] = f013.getCvcrcd();
				registros[1] = f013.getCvdl01();
				registros[2] = f013.getCvcdec();
				registros[3] = f013.getCvckr();
				return registros;
			}
		};

		catalogoF0013.setParent(divCatalogoMonedaF0013);
		catalogoF0013.doModal();
	}

	@Listen("onSeleccion = #divCatalogoMonedaF0013")
	public void seleccionMoneda() {
		F0013 f0013 = catalogoF0013.objetoSeleccionadoDelCatalogo();
		txtCRCDF4301.setValue(f0013.getCvcrcd());
		lblMonedaF0013.setValue(f0013.getCvdl01());
		catalogoF0013.setParent(null);
	}

	@Listen("onClick = #btnBuscarTaxAreasV4008")
	public void mostrarCatalogoZonaFiscal() {
		final List<F4008> listF4008 = servicioF4008.buscarTodosOrdenados();
		catalogoF4008 = new Catalogo<F4008>(divCatalogooTaxAreasV4008, "F4008", listF4008, true, false, false,
				"Zona/Tipo impositivo", "Descripcion zona fiscal", "Fecha efectiva", "Fecha vto", "Tipo imptvo 1",
				"Tipo imptvo 2", "Tipo imptvo 3", "Tipo imptvo 4", "Tipo imptvo 5", "Nro corto articulo") {

			@Override
			protected List<F4008> buscar(List<String> valores) {
				System.out.println(valores.size() + " VALORES");
				List<F4008> lista = new ArrayList<F4008>();

				for (F4008 f4008 : listF4008) {
					if (f4008.getId().getTatxa1().toLowerCase().startsWith(valores.get(0))
							&& f4008.getTataxa().toLowerCase().startsWith(valores.get(1))
							&& String.valueOf(transformarJulianaAGregoria(f4008.getTaeftj())).toLowerCase()
									.startsWith(valores.get(2))
							&& String.valueOf(transformarJulianaAGregoriadeLong(f4008.getId().getTaefdj()))
									.toLowerCase().startsWith(valores.get(3))
							&& String.valueOf(f4008.getTatxr1()).toLowerCase().startsWith(valores.get(4))
							&& String.valueOf(f4008.getTatxr2()).toLowerCase().startsWith(valores.get(5))
							&& String.valueOf(f4008.getTatxr3()).toLowerCase().startsWith(valores.get(6))
							&& String.valueOf(f4008.getTatxr4()).toLowerCase().startsWith(valores.get(7))
							&& String.valueOf(f4008.getTatxr5()).toLowerCase().startsWith(valores.get(8))
							&& String.valueOf(f4008.getId().getTaitm()).toLowerCase().startsWith(valores.get(9))) {
						lista.add(f4008);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4008 f4008) {
				String[] registros = new String[10];
				registros[0] = f4008.getId().getTatxa1();
				registros[1] = f4008.getTataxa();
				registros[2] = String.valueOf(f4008.getTaeftj());
				registros[3] = String.valueOf(f4008.getId().getTaefdj());
				registros[4] = String.valueOf(f4008.getTatxr1());
				registros[5] = String.valueOf(f4008.getTatxr2());
				registros[6] = String.valueOf(f4008.getTatxr3());
				registros[7] = String.valueOf(f4008.getTatxr4());
				registros[8] = String.valueOf(f4008.getTatxr5());
				registros[9] = String.valueOf(f4008.getId().getTaitm());
				return registros;
			}
		};
		catalogoF4008.setParent(divCatalogooTaxAreasV4008);
		catalogoF4008.doModal();
	}

	@Listen("onSeleccion = #divCatalogooTaxAreasV4008")
	public void seleccionZona() {
		F4008 f4008 = catalogoF4008.objetoSeleccionadoDelCatalogo();
		txtTXA1F4301.setValue(f4008.getId().getTatxa1());
		lblZonaV4008.setValue(f4008.getTataxa());
		catalogoF4008.setParent(null);
	}

	@Listen("onClick = #btnBuscarProveedorF0101,#btnBuscarDestinoF0101,#btnBuscarCompradorF0101,#btnBuscarTransportistaF0101,#btnBuscarRifF0101")
	public void mostrarCatalogoDireccion(Event evento) {
		Button boton = (Button) evento.getTarget();
		idBoton = boton.getId();
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoF0101 = new Catalogo<F0101>(divCatalogooLibroDireccionesF0101, "CatalogoF0101", listF0101, true, false,
				false, "Nº direccion", "Nombre alfabetico", "Direccion larga", "Clasificacion industria", "Tipo bus",
				"ID fiscal") {

			@Override
			protected List<F0101> buscar(List<String> valores) {

				List<F0101> lista = new ArrayList<F0101>();

				for (F0101 f01 : listF0101) {
					if (String.valueOf(f01.getAban8()).toLowerCase().startsWith(valores.get(0))
							&& f01.getAbalph().toLowerCase().startsWith(valores.get(1))
							&& f01.getAbalky().toLowerCase().startsWith(valores.get(2))
							&& f01.getAbsic().toLowerCase().startsWith(valores.get(4))
							&& f01.getAbat1().toLowerCase().startsWith(valores.get(5))
							&& f01.getAbtax().toLowerCase().startsWith(valores.get(6))) {
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
		catalogoF0101.setParent(divCatalogooLibroDireccionesF0101);
		catalogoF0101.doModal();
	}

	public void setearValores(F0101 f0101, Longbox txt, Label label) {
		Double doble = f0101.getAban8();
		txt.setValue(doble.longValue());
		label.setValue(f0101.getAbalph());
	}

	@Listen("onSeleccion = #divCatalogooLibroDireccionesF0101")
	public void seleccionarCatalogo() {
		F0101 f0101 = catalogoF0101.objetoSeleccionadoDelCatalogo();
		switch (idBoton) {
		case "btnBuscarProveedorF0101":
			setearValores(f0101, txtAN8F4301, lblProveedoresF0101);
			break;
		case "btnBuscarDestinoF0101":
			setearValores(f0101, txtSHANF4301, lblDestinoF0101);
			break;
		case "btnBuscarCompradorF0101":
			setearValores(f0101, txtANBYF4301, lblCompradorF0101);
			break;
		case "btnBuscarTransportistaF0101":
			setearValores(f0101, txtANCRF4301, lblTransportistaF0101);
			break;
		case "btnBuscarRifF0101":
			txtABTAXF4301.setValue(f0101.getAbtax());
			lblIdFiscalF0101.setValue(f0101.getAbalph());
			break;
		default:
			break;
		}
		catalogoF0101.setParent(null);
	}

	// DETALLES

	@Listen("onClick = #btnBuscarF4101")
	public void mostrarCatalogoF4101() {
		final List<F4101> listF4101 = servicioF4101.buscarTodosOrdenados();
		catalogoF4101 = new Catalogo<F4101>(divCatalogoF4101, "F4101", listF4101, true, false, true, "Codigo",
				"Descripcion") {

			@Override
			protected List<F4101> buscar(List<String> valores) {

				List<F4101> lista = new ArrayList<F4101>();

				for (F4101 f4101 : listF4101) {
					if (String.valueOf(f4101.getImitm()).toLowerCase().contains(valores.get(0).toLowerCase())
							&& f4101.getImdsc1().toLowerCase().contains(valores.get(1).toLowerCase())) {
						lista.add(f4101);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4101 f4101) {
				String[] registros = new String[2];
				registros[0] = String.valueOf(f4101.getImitm());
				registros[1] = f4101.getImdsc1();
				return registros;
			}
		};
		catalogoF4101.setParent(divCatalogoF4101);
		catalogoF4101.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF4101")
	public void seleccionF4101() {
		F4101 f4101 = catalogoF4101.objetoSeleccionadoDelCatalogo();
		Double doble = f4101.getImitm();
		txtITMF4311.setValue(doble.longValue());
		lblPDITMF4311.setValue(f4101.getImdsc1());
		catalogoF4101.setParent(null);
	}

	@Listen("onClick = #btnAgregarItems")
	public void mostrarGroupbox() {
		gpxItems.setVisible(true);
		rowBoton.setVisible(false);
	}

	private boolean validarItems() {
		if (buscadorUOM.obtenerCaja().compareTo("") == 0 || buscadorLTTR.obtenerCaja().compareTo("") == 0
				|| buscadorNXTR.obtenerCaja().compareTo("") == 0 || spnUORGF4311.getValue() == 0)
			return false;
		else
			return true;
	}

	@Listen("onClick = #btnAgregar")
	public void annadirLista() {
		if (validarItems()) {
			// Cabecera
			// Double numOrden = Double.valueOf(txtDOCOF4301.getValue());
			// Double proveedor = Double.valueOf(txtAN8F4301.getValue());
			// String compania = txtKCOOF4301.getValue();
			// String moneda = txtCRCDF4301.getValue();
			// String tipo = txtDCTOF4301.getValue();
			// Detalle
			Double num = txtITMF4311.getValue();
			Double linea = txtLNIDF4311.getValue();
			String des = txtDSC1F4311.getValue();
			String des2 = txtDSC2F4311.getValue();
			Double precio = txtPRRCF4311.getValue();
			Double costo = txtAEXPF4311.getValue();
			String cuenta = txtVR01F4311.getValue();
			String orden = txtOORNF4311.getValue();
			String unidad = txtMCUF4311.getValue();
			Double cantidad = spnUORGF4311.getValue();
			String udcUOM = buscadorUOM.obtenerCaja();
			String udcLTTR = buscadorLTTR.obtenerCaja();
			String udcNXTR = buscadorNXTR.obtenerCaja();
			F4311 f4311 = new F4311();
			f4311.setPditm(num);
			f4311.setPddsc1(des);
			f4311.setPddsc2(des2);
			f4311.setPdprrc(precio);
			f4311.setPdaexp(costo);
			f4311.setPdvr01(cuenta);
			f4311.setPdoorn(orden);
			f4311.setPdmcu(unidad);
			f4311.setPduorg(cantidad);
			f4311.setPduom(udcUOM);
			f4311.setPdlttr(udcLTTR);
			f4311.setPdnxtr(udcNXTR);
			F4311PK clave = new F4311PK();
			clave.setPdlnid(linea);
			f4311.setId(clave);
			listaDetalle.add(f4311);
			actualizarLinea();
			ltbItems.setModel(new ListModelList<F4311>(listaDetalle));
			ltbItems.renderAll();
			limpiarCamposItem();
		} else
			msj.mensajeAlerta(Mensaje.camposVaciosItem);
	}

	@Listen("onClick = #btnVer")
	public void seleccionarItemLista() {
		if (ltbItems.getItemCount() != 0) {
			if (ltbItems.getSelectedItems().size() == 1) {
				Listitem listItem = ltbItems.getSelectedItem();
				F4311 modelo = listItem.getValue();
				this.setValoresDetalles(modelo);
				ltbItems.removeItemAt(listItem.getIndex());
				listaDetalle.remove(modelo);
				actualizarLinea();
				ltbItems.setModel(new ListModelList<F4311>(listaDetalle));
				ltbItems.renderAll();
			} else
				msj.mensajeAlerta(Mensaje.editarSoloUno);
		} else
			msj.mensajeAlerta(Mensaje.noHayRegistros);
	}

	public void setValoresDetalles(F4311 modelo) {
		txtITMF4311.setValue(modelo.getPditm());
		txtLNIDF4311.setValue(listaDetalle.size() + 1);
		txtDSC1F4311.setValue(modelo.getPddsc1());
		txtDSC2F4311.setValue(modelo.getPddsc2());
		txtPRRCF4311.setValue(modelo.getPdprrc());
		txtAEXPF4311.setValue(modelo.getPdaexp());
		txtVR01F4311.setValue(modelo.getPdvr01());
		txtOORNF4311.setValue(modelo.getPdoorn());
		txtMCUF4311.setValue(modelo.getPdmcu());
		spnUORGF4311.setValue(modelo.getPduorg());
		String udc = modelo.getPduom();
		F0005 f05 = servicioF0005.buscar("00", "UM", udc);
		buscadorUOM.settearCampo(f05);
		udc = modelo.getPdlttr();
		f05 = servicioF0005.buscar("40", "AT", udc);
		buscadorLTTR.settearCampo(f05);
		udc = modelo.getPdnxtr();
		f05 = servicioF0005.buscar("40", "AT", udc);
		buscadorNXTR.settearCampo(f05);
	}

	private void limpiarCamposItem() {
		txtITMF4311.setValue(null);
		lblPDITMF4311.setValue("");
		lblMCUF4311.setValue("");
		txtDSC1F4311.setValue(null);
		txtDSC2F4311.setValue(null);
		txtPRRCF4311.setValue(null);
		txtAEXPF4311.setValue(null);
		txtVR01F4311.setValue(null);
		txtOORNF4311.setValue(null);
		txtMCUF4311.setValue(null);
		spnUORGF4311.setValue((double) 0);
		buscadorUOM.settearCampo(null);
		buscadorLTTR.settearCampo(null);
		buscadorNXTR.settearCampo(null);
		txtLNIDF4311.setValue(listaDetalle.size() + 1);
	}

	@Listen("onClick = #btnRemover")
	public void removerItem() {
		if (ltbItems.getItemCount() != 0) {
			if (ltbItems.getSelectedItems().size() == 1) {
				Listitem listItem = ltbItems.getSelectedItem();
				F4311 modelo = listItem.getValue();
				ltbItems.removeItemAt(listItem.getIndex());
				listaDetalle.remove(modelo);
				actualizarLinea();
				ltbItems.setModel(new ListModelList<F4311>(listaDetalle));
				ltbItems.renderAll();
				txtLNIDF4311.setValue(listaDetalle.size() + 1);
			} else
				msj.mensajeAlerta(Mensaje.editarSoloUno);
		} else
			msj.mensajeAlerta(Mensaje.noHayRegistros);
	}

	private void actualizarLinea() {
		double linea = 1;
		// for (int i =0; i<listaDetalle.size(); i++){
		// F4311 modelo : listaDetalle.get(i);
		for (F4311 modelo : listaDetalle) {
			modelo.getId().setPdlnid(linea);
			linea++;
		}
	}

}