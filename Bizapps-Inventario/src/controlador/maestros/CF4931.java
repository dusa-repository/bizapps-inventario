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
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

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
	private Textbox txtWTEMF4931;
	@Wire
	private Textbox txtWTCAF4931;
	@Wire
	private Textbox txtWTGRF4931;
	@Wire
	private Div divBuscadorCVUMF4931;
	private BuscadorUDC buscadorCVUMF4931;
	@Wire
	private Textbox txtCVOLF4931;
	@Wire
	private Div divBuscadorDSGPF4931;
	private BuscadorUDC buscadorDSGPF4931;
	@Wire
	private Div divBuscadorDSGSF4931;
	private BuscadorUDC buscadorDSGSF4931;
	@Wire
	private Textbox txtNCEF4931;
	@Wire
	private Div divBuscadorLCNTF4931;
	private BuscadorUDC buscadorLCNTF4931;
	@Wire
	private Div divBuscadorVLUMF4931;
	private BuscadorUDC buscadorVLUMF4931;
	@Wire
	private Textbox txtVLCPF4931;
	@Wire
	private Textbox txtVLCSF4931;
	@Wire
	private Div divBuscadorMOTF4931;
	private BuscadorUDC buscadorMOTF4931;
	@Wire
	private Div divBuscadorBPFGF4931;
	private BuscadorUDC buscadorBPFGF4931;
	@Wire
	private Textbox txtAXLEF4931;
	@Wire
	private Textbox txtWTAXF4931;
	@Wire
	private Textbox txtSEALF4931;

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
						txtWTEMF4931
								.setValue(String.valueOf(f4931.getVgwtem()));
						txtWTCAF4931
								.setValue(String.valueOf(f4931.getVgwtca()));
						// txtWTGRF4931.setValue(f4931.getVgwtgr());
						buscadorCVUMF4931.settearCampo(servicioF0005,
								f4931.getVgcvum());
						txtCVOLF4931
								.setValue(String.valueOf(f4931.getVgcvol()));
						buscadorDSGPF4931.settearCampo(servicioF0005,
								f4931.getVgdsgp());
						buscadorDSGSF4931.settearCampo(servicioF0005,
								f4931.getVgdsgs());
						txtNCEF4931.setValue(String.valueOf(f4931.getVgnce()));
						buscadorLCNTF4931.settearCampo(servicioF0005,
								String.valueOf(f4931.getVglcnt()));
						buscadorVLUMF4931.settearCampo(servicioF0005,
								f4931.getVgvlum());
						txtVLCPF4931
								.setValue(String.valueOf(f4931.getVgvlcp()));
						txtVLCSF4931
								.setValue(String.valueOf(f4931.getVgvlcs()));
						buscadorMOTF4931.settearCampo(servicioF0005,
								f4931.getVgmot());
						buscadorBPFGF4931.settearCampo(servicioF0005,
								f4931.getVgbpfg());
						txtAXLEF4931
								.setValue(String.valueOf(f4931.getVgaxle()));
						txtWTAXF4931
								.setValue(String.valueOf(f4931.getVgwtax()));
						txtSEALF4931
								.setValue(String.valueOf(f4931.getVgseal()));

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
					F4931 f4931 = new F4931();
					String clavePk = txtVTYPF4931.getValue();

					f4931.setVgvtyp(clavePk);
					f4931.setVgdl01(txtDL01F4931.getValue());
					f4931.setVgcpfg(chxCPFGF4931.isChecked() ? "1" : "0");
					f4931.setVgmlln(chxMLLNF4931.isChecked() ? "1" : "0");
					f4931.setVgwtum(buscadorWTUMF4931.obtenerCaja());
					f4931.setVgwtem(Double.parseDouble(txtWTEMF4931.getValue()));
					f4931.setVgwtca(Double.parseDouble(txtWTCAF4931.getValue()));
					// f4931.setVgwtgr(Double.parseDouble(txtWTGRF4931.getValue()));
					f4931.setVgcvum(buscadorCVUMF4931.obtenerCaja());
					f4931.setVgcvol(Double.parseDouble(txtCVOLF4931.getValue()));
					f4931.setVgdsgp(buscadorDSGPF4931.obtenerCaja());
					f4931.setVgdsgs(buscadorDSGSF4931.obtenerCaja());
					f4931.setVgnce(Double.parseDouble(txtNCEF4931.getValue()));
					f4931.setVglcnt(Double.parseDouble(buscadorLCNTF4931
							.obtenerCaja()));
					f4931.setVgvlum(buscadorVLUMF4931.obtenerCaja());
					f4931.setVgvlcp(Double.parseDouble(txtVLCPF4931.getValue()));
					f4931.setVgvlcs(Double.parseDouble(txtVLCSF4931.getValue()));
					f4931.setVgmot(buscadorMOTF4931.obtenerCaja());
					f4931.setVgbpfg(buscadorBPFGF4931.obtenerCaja());
					f4931.setVgaxle(Double.parseDouble(txtAXLEF4931.getValue()));
					f4931.setVgwtax(Double.parseDouble(txtWTAXF4931.getValue()));
					f4931.setVgseal(Double.parseDouble(txtSEALF4931.getValue()));

					servicioF4931.guardar(f4931);
					msj.mensajeInformacion(Mensaje.guardado);
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
				cerrarVentana(divVF4931, "Trabajo con tipos de vehículo", tabs);
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
			return false;
		return true;
	}

	public void limpiarCampos() {
		clave = null;
		txtVTYPF4931.setValue(clave);
		txtDL01F4931.setValue("");
		chxCPFGF4931.setValue("");
		buscadorWTUMF4931.limpiarCampo();
		txtWTEMF4931.setValue("");
		txtWTCAF4931.setValue("");
		txtWTGRF4931.setValue("");
		buscadorCVUMF4931.limpiarCampo();
		txtCVOLF4931.setValue("");
		buscadorDSGPF4931.limpiarCampo();
		buscadorDSGSF4931.limpiarCampo();
		txtNCEF4931.setValue("");
		buscadorLCNTF4931.limpiarCampo();
		buscadorVLUMF4931.limpiarCampo();
		txtVLCPF4931.setValue("");
		txtVLCSF4931.setValue("");
		buscadorMOTF4931.limpiarCampo();
		buscadorBPFGF4931.limpiarCampo();
		txtAXLEF4931.setValue("");
		txtWTAXF4931.setValue("");
		txtSEALF4931.setValue("");

		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(0).setVisible(false);
		catalogo.limpiarSeleccion();
	}

	public boolean validarSeleccionEncabezado() {
		List<F4931> seleccionados = catalogo.obtenerSeleccionados();
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
		final List<F4931> listF4931 = servicioF4931.buscarTodosOrdenados();
		catalogo = new Catalogo<F4931>(catalogoF4931, "F4931", listF4931,
				false, true, true, "Tp veh", "Descripción", "Tipo transp",
				"Grupo dpch", "Grupo 2 de desp", "Cap peso", "UM ps",
				"Capacidad en vol cúbicos", "UM", "Capacidad de vol a granel",
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
		catalogo.setParent(catalogoF4931);
	}

}
