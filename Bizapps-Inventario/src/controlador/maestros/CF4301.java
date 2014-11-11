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
import modelo.maestros.F4301;
import modelo.pk.F4301PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
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
	private Textbox txtCRRF4301;
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
	private Label lblDescripcion2;
	@Wire
	private Textbox txtINMGF4301;
	@Wire
	private Label lblMensaje;
	@Wire
	private Label lblMensaje2;
	@Wire
	private Div divBuscadorINMG40PM;
	@Wire
	private Groupbox gpxRegistroF43012;
	@Wire
	private Button btnBuscarF0006;
	@Wire
	private Groupbox gpxRegistro2F4301;
	@Wire
	private Textbox txtEXR1F4301;
	@Wire
	private Label lblCodExpFiscal;
	@Wire
	private Div divBuscadorEXR100EX;
	@Wire
	private Textbox txtHOLDF4301;
	@Wire
	private Label lblCodRetencionExp;
	@Wire
	private Div divBuscadorHOLD42HC;
	@Wire
	private Textbox txtTXA1F4301;
	@Wire
	private Button btnBuscarTaxAreasV4008;
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
	private Textbox txtFUF1F4301;
	@Wire
	private Label lblDocF0101;
	@Wire
	private Div divBuscadorFUF1H40FU;
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

	private static SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

	private Botonera botonera;
	private Catalogo<F4301> catalogo;
	Catalogo<F0013> catalogoF0013;
	Catalogo<F0006> catalogoF0006;
	Catalogo<F4008> catalogoF4008;
	Catalogo<F0101> catalogoF0101;
	private F4301PK clave = null;
	String idBoton = "";

	@Override
	public void inicializar() throws IOException {
		HashMap<String, Object> map = (HashMap<String, Object>) Sessions.getCurrent().getAttribute("mapaGeneral");
		if (map != null) {
			if (map.get("tabsGenerales") != null) {
				tabs = (List<Tab>) map.get("tabsGenerales");
				titulo = (String) map.get("titulo");
				map.clear();
				map = null;
			}
		}
		mostrarCatalogo();

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccionEncabezado()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						abrirRegistro();

						F4301 f4301 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f4301.getId();

						txtDCTOF4301.setValue(clave.getPhdcto());
						txtDOCOF4301.setValue(Math.round(clave.getPhdoco()));
						txtKCOOF4301.setValue(clave.getPhkcoo());

						txtAN8F4301.setValue(Math.round(f4301.getPhan8()));
						txtANBYF4301.setValue(Math.round(f4301.getPhanby()));
						txtANCRF4301.setValue(Math.round(f4301.getPhancr()));
						txtCRCDF4301.setValue(f4301.getPhcrcd());
						txtCRRF4301.setValue(String.valueOf(f4301.getPhcrr()));
						txtDESCF4301.setValue(f4301.getPhdesc());
						txtEXR1F4301.setValue(f4301.getPhexr1());
						txtHOLDF4301.setValue(f4301.getPhhold());
						txtINMGF4301.setValue(f4301.getPhinmg());
						txtMCUF4301.setValue(f4301.getPhmcu());
						txtPCRTF4301
								.setValue(String.valueOf(f4301.getPhpcrt()));
						txtPTCF4301.setValue(f4301.getPhptc());
						txtRMKF4301.setValue(f4301.getPhrmk());
						txtSHANF4301.setValue(Math.round(f4301.getPhshan()));
						txtTKBYF4301.setValue(f4301.getPhtkby());
						txtTXA1F4301.setValue(f4301.getPhtxa1());
						txtTXCTF4301.setValue(f4301.getPhtxct());
						txtFUF1F4301.setValue(f4301.getPhfuf1());
						dtbCNDJF4301.setValue(transformarJulianaAGregoria(f4301
								.getPhcndj()));
						dtbDRQJF4301.setValue(transformarJulianaAGregoria(f4301
								.getPhdrqj()));
						dtbPDDJF4301.setValue(transformarJulianaAGregoria(f4301
								.getPhpddj()));
						dtbTRDJF4301.setValue(transformarJulianaAGregoria(f4301
								.getPhtrdj()));

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

					f4301.setId(clavePk);
					// txtABTAXF4301;
					f4301.setPhan8(txtAN8F4301.getValue());
					f4301.setPhanby(txtANBYF4301.getValue());
					f4301.setPhancr(txtANCRF4301.getValue());
					f4301.setPhcrcd(txtCRCDF4301.getValue());
					f4301.setPhcrr(Double.parseDouble(txtCRRF4301.getValue()));
					f4301.setPhdesc(txtDESCF4301.getValue());
					f4301.setPhexr1(txtEXR1F4301.getValue());
					f4301.setPhhold(txtHOLDF4301.getValue());
					f4301.setPhinmg(txtINMGF4301.getValue());
					f4301.setPhmcu(txtMCUF4301.getValue());
					f4301.setPhpcrt(Double.parseDouble(txtPCRTF4301.getValue()));
					f4301.setPhptc(txtPTCF4301.getValue());
					f4301.setPhrmk(txtRMKF4301.getValue());
					f4301.setPhshan(txtSHANF4301.getValue());
					f4301.setPhtkby(txtTKBYF4301.getValue());
					f4301.setPhtxa1(txtTXA1F4301.getValue());
					f4301.setPhtxct(txtTXCTF4301.getValue());
					f4301.setPhfuf1(txtFUF1F4301.getValue());
					f4301.setPhcndj(transformarGregorianoAJulia(dtbCNDJF4301
							.getValue()));
					f4301.setPhdrqj(transformarGregorianoAJulia(dtbDRQJF4301
							.getValue()));
					f4301.setPhpddj(transformarGregorianoAJulia(dtbPDDJF4301
							.getValue()));
					f4301.setPhtrdj(transformarGregorianoAJulia(dtbTRDJF4301
							.getValue()));
					servicioF4301.guardar(f4301);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF4301
							.buscarTodosOrdenados());
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
				cerrarVentana(divVF4301, titulo , tabs);
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
		if (txtABTAXF4301.getText().compareTo("") != 0
				|| txtAN8F4301.getText().compareTo("") != 0
				|| txtANBYF4301.getText().compareTo("") != 0
				|| txtANCRF4301.getText().compareTo("") != 0
				|| txtCRCDF4301.getText().compareTo("") != 0
				|| txtCRRF4301.getText().compareTo("") != 0
				|| txtDCTOF4301.getText().compareTo("") != 0
				|| txtDESCF4301.getText().compareTo("") != 0
				|| txtDOCOF4301.getText().compareTo("") != 0
				|| txtEXR1F4301.getText().compareTo("") != 0
				|| txtHOLDF4301.getText().compareTo("") != 0
				|| txtINMGF4301.getText().compareTo("") != 0
				|| txtKCOOF4301.getText().compareTo("") != 0
				|| txtMCUF4301.getText().compareTo("") != 0
				|| txtPCRTF4301.getText().compareTo("") != 0
				|| txtPTCF4301.getText().compareTo("") != 0
				|| txtRMKF4301.getText().compareTo("") != 0
				|| txtSHANF4301.getText().compareTo("") != 0
				|| txtTKBYF4301.getText().compareTo("") != 0
				|| txtTXA1F4301.getText().compareTo("") != 0
				|| txtTXCTF4301.getText().compareTo("") != 0
				|| txtFUF1F4301.getText().compareTo("") != 0
				|| dtbTRDJF4301.getText().compareTo("") != 0
				|| dtbDRQJF4301.getText().compareTo("") != 0
				|| dtbPDDJF4301.getText().compareTo("") != 0
				|| dtbCNDJF4301.getText().compareTo("") != 0)
			return false;
		return true;
	}

	public void limpiarCampos() {
		clave = null;
		txtABTAXF4301.setValue("");
		txtAN8F4301.setValue(null);
		txtANBYF4301.setValue(null);
		txtANCRF4301.setValue(null);
		txtCRCDF4301.setValue("");
		txtCRRF4301.setValue("");
		txtDCTOF4301.setValue("");
		txtDESCF4301.setValue("");
		txtDOCOF4301.setValue(null);
		txtEXR1F4301.setValue("");
		txtHOLDF4301.setValue("");
		txtINMGF4301.setValue("");
		txtKCOOF4301.setValue("");
		txtMCUF4301.setValue("");
		txtPCRTF4301.setValue("");
		txtPTCF4301.setValue("");
		txtRMKF4301.setValue("");
		txtSHANF4301.setValue(null);
		txtTKBYF4301.setValue("");
		txtTXA1F4301.setValue("");
		txtTXCTF4301.setValue("");
		txtFUF1F4301.setValue("");
		lblCertificadoF0013.setValue("");
		lblCodExpFiscal.setValue("");
		lblCodRetencionExp.setValue("");
		lblCompradorF0101.setValue("");
		lblCondicionPagoF0101.setValue("");
		lblDescripcion.setValue("");
		lblDestinoF0101.setValue("");
		lblDocF0101.setValue("");
		lblIdFiscalF0101.setValue("");
		lblMensaje.setValue("");
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
		dtbTRDJF4301.setValue(null);
		dtbDRQJF4301.setValue(null);
		dtbPDDJF4301.setValue(null);
		dtbCNDJF4301.setValue(null);
		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(0).setVisible(false);
		catalogo.limpiarSeleccion();
	}

	public boolean validarSeleccionEncabezado() {
		List<F4301> seleccionados = catalogo.obtenerSeleccionados();
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
		if (txtABTAXF4301.getText().compareTo("") == 0
				|| txtAN8F4301.getText().compareTo("") == 0
				|| txtANBYF4301.getText().compareTo("") == 0
				|| txtANCRF4301.getText().compareTo("") == 0
				|| txtCRCDF4301.getText().compareTo("") == 0
				|| txtCRRF4301.getText().compareTo("") == 0
				|| txtDCTOF4301.getText().compareTo("") == 0
				|| txtDESCF4301.getText().compareTo("") == 0
				|| txtDOCOF4301.getText().compareTo("") == 0
				|| txtEXR1F4301.getText().compareTo("") == 0
				|| txtHOLDF4301.getText().compareTo("") == 0
				|| txtINMGF4301.getText().compareTo("") == 0
				|| txtKCOOF4301.getText().compareTo("") == 0
				|| txtMCUF4301.getText().compareTo("") == 0
				|| txtPCRTF4301.getText().compareTo("") == 0
				|| txtPTCF4301.getText().compareTo("") == 0
				|| txtRMKF4301.getText().compareTo("") == 0
				|| txtSHANF4301.getText().compareTo("") == 0
				|| txtTKBYF4301.getText().compareTo("") == 0
				|| txtTXA1F4301.getText().compareTo("") == 0
				|| txtTXCTF4301.getText().compareTo("") == 0
				|| txtFUF1F4301.getText().compareTo("") == 0
				|| dtbTRDJF4301.getText().compareTo("") == 0
				|| dtbDRQJF4301.getText().compareTo("") == 0
				|| dtbPDDJF4301.getText().compareTo("") == 0
				|| dtbCNDJF4301.getText().compareTo("") == 0)
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
				String[] registros = new String[6];
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
		System.out.println("hola");
		final List<F4008> listF4008 = servicioF4008.buscarTodosOrdenados();
		System.out.println(listF4008.size() + " LIST");
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
}
