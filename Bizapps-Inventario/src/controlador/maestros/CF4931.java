package controlador.maestros;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F4931;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;
import componentes.catalogos.CatalogoF4931;

public class CF4931 extends CGenerico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox txtVTYPF4931;
	@Wire
	private Textbox txtDL01F4931;
	@Wire
	private Checkbox chxCPFGF4931;
	@Wire
	private Checkbox chxMLLNF4931;
	@Wire
	private Div divBuscadorWTUMF4931;
	private BuscadorUDC buscadorWTUMF4931;
	@Wire
	private Doublebox txtWTEMF4931;
	@Wire
	private Doublebox txtWTCAF4931;
	@Wire
	private Textbox txtWTGRF4931;
	@Wire
	private Div divBuscadorCVUMF4931;
	private BuscadorUDC buscadorCVUMF4931;
	@Wire
	private Doublebox txtCVOLF4931;
	@Wire
	private Div divBuscadorDSGPF4931;
	private BuscadorUDC buscadorDSGPF4931;
	@Wire
	private Div divBuscadorDSGSF4931;
	private BuscadorUDC buscadorDSGSF4931;
	@Wire
	private Doublebox txtNCEF4931;
	@Wire
	private Div divBuscadorLCNTF4931;
	private BuscadorUDC buscadorLCNTF4931;
	@Wire
	private Div divBuscadorVLUMF4931;
	private BuscadorUDC buscadorVLUMF4931;
	@Wire
	private Doublebox txtVLCPF4931;
	@Wire
	private Doublebox txtVLCSF4931;
	@Wire
	private Div divBuscadorMOTF4931;
	private BuscadorUDC buscadorMOTF4931;
	@Wire
	private Div divBuscadorBPFGF4931;
	private BuscadorUDC buscadorBPFGF4931;
	@Wire
	private Doublebox txtAXLEF4931;
	@Wire
	private Doublebox txtWTAXF4931;
	@Wire
	private Doublebox txtSEALF4931;
	@Wire
	private Div divVF4931;
	@Wire
	private Div botoneraF4931;
	@Wire
	private Groupbox gpxRegistroF4931;
	@Wire
	private Groupbox gpxRegistro1F4931;
	@Wire
	private Groupbox gpxNumeroDireccionF4931;
	@Wire
	private Div divBuscadorINMG40PM;
	@Wire
	private Groupbox gpxRegistroF49312;
	@Wire
	private Button btnBuscarF0006;
	@Wire
	private Groupbox gpxRegistro2F4931;
	@Wire
	private Div divBuscadorEXR100EX;
	@Wire
	private Div divBuscadorHOLD42HC;
	@Wire
	private Button btnBuscarTaxAreasV4008;
	@Wire
	private Div divBuscadorFUF1H40FU;
	@Wire
	private Groupbox gpxDatosF4931;
	@Wire
	private Div catalogoF4931;
	@Wire
	private Div divCatalogoMonedaF0013;
	@Wire
	private Div divCatalogoSucPlantaF0006;
	@Wire
	private Div divCatalogooLibroDireccionesF0101;
	@Wire
	private Div divCatalogooTaxAreasV4008;
	@Wire
	private Button btnBuscarRifF0101;

	private static SimpleDateFormat formatoFecha = new SimpleDateFormat(
			"dd-MM-yyyy");

	private Botonera botonera;
	private Catalogo<F4931> catalogo;
	private String clave = null;
	String idBoton = "";

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

		buscadorBPFGF4931 = crearCampoUDC(divBuscadorBPFGF4931,
				"Prod granel/emb", "41B", "BF");
		buscadorCVUMF4931 = crearCampoUDC(divBuscadorCVUMF4931, "UM", "00",
				"UM");
		buscadorDSGPF4931 = crearCampoUDC(divBuscadorDSGPF4931,
				"Grupo despacho", "41B", "DG");
		buscadorDSGSF4931 = crearCampoUDC(divBuscadorDSGSF4931,
				"Grupo despacho secundario", "41B", "DG");
		buscadorLCNTF4931 = crearCampoUDC(divBuscadorLCNTF4931,
				"Lineas de Carga", "49", "LC");
		buscadorMOTF4931 = crearCampoUDC(divBuscadorMOTF4931, "Tipo transp",
				"00", "TM");
		buscadorVLUMF4931 = crearCampoUDC(divBuscadorVLUMF4931, "UM", "00",
				"UM");
		buscadorWTUMF4931 = crearCampoUDC(divBuscadorWTUMF4931, "UM", "00",
				"UM");

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccionEncabezado()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						abrirRegistro();

						F4931 f4931 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f4931.getVgvtyp();

						txtVTYPF4931.setValue(clave);
						txtVTYPF4931.setValue(f4931.getVgvtyp());
						txtDL01F4931.setValue(f4931.getVgdl01());
						chxCPFGF4931.setChecked(f4931.getVgcpfg().equals("1"));
						chxMLLNF4931.setChecked(f4931.getVgmlln().equals("1"));
						buscadorWTUMF4931.settearCampo(servicioF0005,
								f4931.getVgwtum());
						txtWTEMF4931.setValue(f4931.getVgwtem());
						txtWTCAF4931.setValue(f4931.getVgwtca());
						// txtWTGRF4931.setValue(f4931.getVgwtgr());
						buscadorCVUMF4931.settearCampo(servicioF0005,
								f4931.getVgcvum());
						txtCVOLF4931.setValue(f4931.getVgcvol());
						buscadorDSGPF4931.settearCampo(servicioF0005,
								f4931.getVgdsgp());
						buscadorDSGSF4931.settearCampo(servicioF0005,
								f4931.getVgdsgs());
						txtNCEF4931.setValue(f4931.getVgnce());
						String valor = String.valueOf(f4931.getVglcnt());
						buscadorLCNTF4931.settearCampo(servicioF0005, valor);
						buscadorVLUMF4931.settearCampo(servicioF0005,
								f4931.getVgvlum());
						txtVLCPF4931.setValue(f4931.getVgvlcp());
						txtVLCSF4931.setValue(f4931.getVgvlcs());
						buscadorMOTF4931.settearCampo(servicioF0005,
								f4931.getVgmot());
						buscadorBPFGF4931.settearCampo(servicioF0005,
								f4931.getVgbpfg());
						txtAXLEF4931.setValue(f4931.getVgaxle());
						txtWTAXF4931.setValue(f4931.getVgwtax());
						txtSEALF4931.setValue(f4931.getVgseal());

						botonera.getChildren().get(2).setVisible(true);
					} else
						Mensaje.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void buscar() {
				// TODO Auto-generated method stub
				abrirCatalogo();
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
					F4931 f4931 = new F4931();
					String clavePk = txtVTYPF4931.getValue();

					f4931.setVgvtyp(clavePk);
					f4931.setVgdl01(txtDL01F4931.getValue());
					f4931.setVgcpfg(chxCPFGF4931.isChecked() ? "1" : "0");
					f4931.setVgmlln(chxMLLNF4931.isChecked() ? "1" : "0");
					f4931.setVgwtum(buscadorWTUMF4931.obtenerCaja());
					f4931.setVgwtem(txtWTEMF4931.getValue());
					f4931.setVgwtca(txtWTCAF4931.getValue());
					// f4931.setVgwtgr(Double.parseDouble(txtWTGRF4931.getValue()));
					f4931.setVgcvum(buscadorCVUMF4931.obtenerCaja());
					f4931.setVgcvol(txtCVOLF4931.getValue());
					f4931.setVgdsgp(buscadorDSGPF4931.obtenerCaja());
					f4931.setVgdsgs(buscadorDSGSF4931.obtenerCaja());
					f4931.setVgnce(txtNCEF4931.getValue());
					if (buscadorLCNTF4931.obtenerCaja() != null) {
						f4931.setVglcnt(Double.parseDouble(buscadorLCNTF4931
								.obtenerCaja()));
					}
					f4931.setVgvlum(buscadorVLUMF4931.obtenerCaja());
					f4931.setVgvlcp(txtVLCPF4931.getValue());
					f4931.setVgvlcs(txtVLCSF4931.getValue());
					f4931.setVgmot(buscadorMOTF4931.obtenerCaja());
					f4931.setVgbpfg(buscadorBPFGF4931.obtenerCaja());
					f4931.setVgaxle(txtAXLEF4931.getValue());
					f4931.setVgwtax(txtWTAXF4931.getValue());
					f4931.setVgseal(txtSEALF4931.getValue());
					servicioF4931.guardar(f4931);
					Mensaje.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF4931
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
				cerrarVentana(divVF4931, titulo, tabs);
			}

			@Override
			public void eliminar() {
				Mensaje.mensajeAlerta(Mensaje.noSeleccionoRegistro);
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
		botoneraF4931.appendChild(botonera);
	}

	@Listen("onClick = #gpxRegistroF4931")
	public void abrirRegistro() {
		gpxDatosF4931.setOpen(false);
		gpxRegistroF4931.setOpen(true);
		mostrarBotones(false);
	}

	@Listen("onOpen = #gpxDatosF4931")
	public void abrirCatalogo() {
		gpxDatosF4931.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF4931.setOpen(false);
								gpxRegistroF4931.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF4931.setOpen(true);
									gpxRegistroF4931.setOpen(false);
									limpiarCampos();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF4931.setOpen(true);
			gpxRegistroF4931.setOpen(false);
			mostrarBotones(true);
		}
	}

	private boolean camposEditando() {
		if (txtVTYPF4931.getText().compareTo("") != 0
				|| txtDL01F4931.getText().compareTo("") != 0
				|| txtWTEMF4931.getText().compareTo("") != 0
				|| txtWTCAF4931.getText().compareTo("") != 0
				|| txtWTGRF4931.getText().compareTo("") != 0
				|| txtCVOLF4931.getText().compareTo("") != 0
				|| txtNCEF4931.getText().compareTo("") != 0
				|| txtVLCPF4931.getText().compareTo("") != 0
				|| txtVLCSF4931.getText().compareTo("") != 0
				|| txtAXLEF4931.getText().compareTo("") != 0
				|| txtWTAXF4931.getText().compareTo("") != 0
				|| txtSEALF4931.getText().compareTo("") != 0)
			return true;
		return false;
	}

	public void limpiarCampos() {
		clave = null;
		txtVTYPF4931.setValue(clave);
		txtDL01F4931.setValue("");
		chxCPFGF4931.setChecked(false);
		chxMLLNF4931.setChecked(false);
		buscadorWTUMF4931.limpiarCampo();
		txtWTEMF4931.setValue(null);
		txtWTCAF4931.setValue(null);
		txtWTGRF4931.setValue("");
		buscadorCVUMF4931.limpiarCampo();
		txtCVOLF4931.setValue(null);
		buscadorDSGPF4931.limpiarCampo();
		buscadorDSGSF4931.limpiarCampo();
		txtNCEF4931.setValue(null);
		buscadorLCNTF4931.limpiarCampo();
		buscadorVLUMF4931.limpiarCampo();
		txtVLCPF4931.setValue(null);
		txtVLCSF4931.setValue(null);
		buscadorMOTF4931.limpiarCampo();
		buscadorBPFGF4931.limpiarCampo();
		txtAXLEF4931.setValue(null);
		txtWTAXF4931.setValue(null);
		txtSEALF4931.setValue(null);

		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(0).setVisible(false);
		catalogo.limpiarSeleccion();
	}

	public boolean validarSeleccionEncabezado() {
		List<F4931> seleccionados = catalogo.obtenerSeleccionados();
		if (seleccionados == null) {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			return false;
		} else {
			if (seleccionados.isEmpty()) {
				Mensaje.mensajeAlerta(Mensaje.noSeleccionoItem);
				return false;
			} else {
				return true;
			}
		}
	}

	public boolean camposLLenos() {
		if (txtVTYPF4931.getText().compareTo("") == 0
				|| txtDL01F4931.getText().compareTo("") == 0
				|| txtWTEMF4931.getText().compareTo("") == 0
				|| txtWTCAF4931.getText().compareTo("") == 0
				|| txtWTGRF4931.getText().compareTo("") == 0
				|| txtCVOLF4931.getText().compareTo("") == 0
				|| txtNCEF4931.getText().compareTo("") == 0
				|| txtVLCPF4931.getText().compareTo("") == 0
				|| txtVLCSF4931.getText().compareTo("") == 0
				|| txtAXLEF4931.getText().compareTo("") == 0
				|| txtWTAXF4931.getText().compareTo("") == 0
				|| txtSEALF4931.getText().compareTo("") == 0)
			return false;
		return true;
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

	protected boolean validar() {
		if (!camposLLenos()) {
			Mensaje.mensajeAlerta(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	public void mostrarCatalogo() {
		final List<F4931> listF4931 = servicioF4931.buscarTodosOrdenados();
		catalogo = new CatalogoF4931(catalogoF4931, "F4931", listF4931, false,
				"Tp veh", "Descripción", "Tipo transp", "Grupo dpch",
				"Grupo 2 de desp", "Cap peso", "UM ps",
				"Capacidad en vol cúbicos", "UM", "Capacidad de vol a granel",
				"Cap secundaria de volumen a granel", "UM vol", "N° com",
				"Lín carga");
		catalogo.setParent(catalogoF4931);
	}

}
