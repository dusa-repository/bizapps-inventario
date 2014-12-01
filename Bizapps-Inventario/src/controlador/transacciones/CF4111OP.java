package controlador.transacciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F00021;
import modelo.maestros.F0005;
import modelo.maestros.F4100;
import modelo.maestros.F4101;
import modelo.maestros.F4301;
import modelo.maestros.F4311;
import modelo.pk.F00021PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.buscadores.BuscadorF0101;
import componentes.buscadores.BuscadorF4301;
import controlador.maestros.CGenerico;

public class CF4111OP extends CGenerico {

	private static final long serialVersionUID = -3406820146315915655L;

	@Wire
	private Datebox dtbDGLF4111OP;
	@Wire
	private Datebox dtbVPEJF4111OP;
	@Wire
	private Datebox dtbHDGJF4111OP;
	@Wire
	private Datebox dtbTRDJF4111OP;

	@Wire
	private Radiogroup rdoREF4111OP;

	@Wire
	private Textbox txtTREXF4111OP;
	@Wire
	private Textbox txtASIDF4111OP;
	// valor por defecto OV
	@Wire
	private Textbox txtDCTF4111OP;
	// Pendiente por campo
	// valor por defecto APR
	@Wire
	private Textbox txtXF4111OP;
	@Wire
	private Textbox txtLITMF4111OP;

	@Wire
	private Doublebox txtDOCF4111OP;
	@Wire
	private Doublebox txtAN8F4111OP;
	@Wire
	private Doublebox txtSHANF4111OP;
	@Wire
	private Doublebox txtOPSQF4111OP;
	@Wire
	private Doublebox txtRFLNF4111OP;
	@Wire
	private Doublebox txtTRQTF4111OP;
	@Wire
	private Doublebox txtUNCSF4111OP;
	@Wire
	private Doublebox txtLNIDF4111OP;

	@Wire
	private Div divBuscadorDOCO;
	BuscadorF4301 buscadorDOCO;
	@Wire
	private Div divBuscadorSUB;
	BuscadorF0101 buscadorSUB;
	@Wire
	private Div divBuscadorSBL;
	BuscadorF0101 buscadorSBL;
	@Wire
	private Div divBuscadorMCU;
	BuscadorF0101 buscadorMCU;
	@Wire
	private Div divBuscadorLOCN;
	BuscadorF0101 buscadorLOCN;
	@Wire
	private Div catalogoF4111OP;
	@Wire
	private Div divVF4111OP;
	@Wire
	private Div botoneraF4111OP;
	private Botonera botonera;

	@Wire
	private Groupbox gpxRegistroF4111OP;
	@Wire
	private Groupbox gpxRegistro1F4111OP;
	@Wire
	private Groupbox gpxItems;
	@Wire
	private Groupbox gpxDatosF4111OP;
	private F4301 modelo;

	@Wire
	private Listbox ltbItems;
	List<F4311> listaDetalle = new ArrayList<F4311>();

	public String getTitulo() {
		return titulo;
	}

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
		String ancho1P2 = "34%";
		String ancho2P2 = "15%";
		String ancho3P2 = "25%";
		String ancho4P2 = "26%";
		buscadorDOCO = new BuscadorF4301("Orden de compra / Pedido", true, "",
				"", "", 10, servicioF4301, ancho1P2, ancho2P2, ancho3P2,
				ancho4P2);
		buscadorDOCO.setId("divBuscadorDOCO2");
		divBuscadorDOCO.appendChild(buscadorDOCO);
		buscadorSBL = new BuscadorF0101("Transportista", true, "", "", "", 10,
				servicioF0101, ancho1P2, ancho2P2, ancho3P2, ancho4P2);
		divBuscadorSBL.appendChild(buscadorSBL);
		buscadorSUB = new BuscadorF0101("Transporte", true, "", "", "", 10,
				servicioF0101, ancho1P2, ancho2P2, ancho3P2, ancho4P2);
		divBuscadorSUB.appendChild(buscadorSUB);
		buscadorMCU = new BuscadorF0101("ALmacen", true, "", "", "", 10,
				servicioF0101, ancho1P2, ancho2P2, ancho3P2, ancho4P2);
		divBuscadorMCU.appendChild(buscadorMCU);
		buscadorLOCN = new BuscadorF0101("Ubicacion", true, "", "", "", 10,
				servicioF0101, ancho1P2, ancho2P2, ancho3P2, ancho4P2);
		divBuscadorLOCN.appendChild(buscadorLOCN);

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
			}

			@Override
			public void salir() {
				cerrarVentana(divVF4111OP, titulo, tabs);
			}

			@Override
			public void reporte() {
			}

			@Override
			public void limpiar() {
				botonera.getChildren().get(3).setVisible(true);
				mostrarBotones(false);
				limpiarCampos();
			}

			@Override
			public void guardar() {
			}

			@Override
			public void eliminar() {
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
				botonera.getChildren().get(3).setVisible(true);
			}
		};

		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botonera.getChildren().get(4).setVisible(false);
		botoneraF4111OP.appendChild(botonera);
	}

	@Listen("onOpen = #gpxRegistroF4111OP")
	public void abrirRegistro() {
		// botonera.getChildren().get(3).setVisible(true);
		// gpxRegistroF4111OP.setOpen(false);
		// gpxRegistroF4111OP.setOpen(true);
		// mostrarBotones(false);
	}

	protected double numeroSiguiente() {
		// double numeroNext = servicioF00021.Numero("6", "JE");
		// if (numeroNext != 0) {
		// id = numeroNext + 1;
		// F00021 f021 = servicioF00021.buscar("6", "JE");
		// f021.setNln001(id);
		// servicioF00021.guardar(f021);
		// } else {
		id = 1;
		// F00021 f021 = new F00021();
		// F00021PK clave21 = new F00021PK();
		// clave21.setNldct("JE");
		// clave21.setNlkco("6");
		// clave21.setNlctry((double) 0);
		// clave21.setNlfy((double) 0);
		// f021.setId(clave21);
		// f021.setNln001(id);
		// servicioF00021.guardar(f021);
		// }
		return id;
	}

	protected void limpiarCampos() {
		dtbDGLF4111OP.setValue(null);
		dtbVPEJF4111OP.setValue(null);
		dtbHDGJF4111OP.setValue(null);
		dtbTRDJF4111OP.setValue(null);
		// rdoREF4111OP; valores por defecto
		txtTREXF4111OP.setValue("");
		txtASIDF4111OP.setValue("");
		// txtDCTF4111OP; valores por defecto
		// txtXF4111OP; valores por defecto
		txtLITMF4111OP.setValue("");
		txtLNIDF4111OP.setValue(null);
		txtDOCF4111OP.setValue(null);
		txtAN8F4111OP.setValue(null);
		txtSHANF4111OP.setValue(null);
		txtOPSQF4111OP.setValue(null);
		txtRFLNF4111OP.setValue(null);
		txtTRQTF4111OP.setValue(null);
		txtUNCSF4111OP.setValue(null);
		buscadorDOCO.limpiarCampo();
		buscadorSUB.limpiarCampo();
		buscadorSBL.limpiarCampo();
		buscadorMCU.limpiarCampo();
		buscadorLOCN.limpiarCampo();
	}

	protected void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(0).setVisible(bol);
		// botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	@Listen("onSeleccion = #divBuscadorDOCO2")
	public void llenarCampos() {
		modelo = buscadorDOCO.getModelo();
		if (modelo != null) {
			buscadorSUB.settearCampo(modelo.getPhancr().longValue()); // Transportista
			txtAN8F4111OP.setValue(modelo.getPhan8()); // Proveedor
			dtbDGLF4111OP.setValue(transformarJulianaAGregoria(modelo
					.getPhtrdj()));
			listaDetalle.clear();
			listaDetalle = servicioF4311.buscarPorDocoDctoKcooYSfxo(modelo
					.getId().getPhdoco(), modelo.getId().getPhdcto(), modelo
					.getId().getPhkcoo(), modelo.getId().getPhsfxo());
			ltbItems.setModel(new ListModelList<F4311>(listaDetalle));
			ltbItems.renderAll();
		}
	}

	
	@Listen("onSelect = #ltbItems")
	public void seleccionarItemLista() {
		Listitem listItem = ltbItems.getSelectedItem();
		F4311 modelo = listItem.getValue();
		this.setValoresDetalles(modelo);
	}
	
	
	

	
	
	public void setValoresDetalles(F4311 modelo) {
		txtLNIDF4111OP.setValue(modelo.getId().getPdlnid());
//		txtLNIDF4311.setValue(listaDetalle.size() + 1);
//		txtDSC1F4311.setValue(modelo.getPddsc1());
//		txtDSC2F4311.setValue(modelo.getPddsc2());
//		txtPRRCF4311.setValue(modelo.getPdprrc());
//		txtAEXPF4311.setValue(modelo.getPdaexp());
//		txtVR01F4311.setValue(modelo.getPdvr01());
//		txtOORNF4311.setValue(modelo.getPdoorn());
//		buscadorMCU.settearCampo(modelo.getPdmcu());
//		spnUORGF4311.setValue(modelo.getPduorg());
//		String udc = modelo.getPduom();
//		F0005 f05 = servicioF0005.buscar("00", "UM", udc);
//		buscadorUOM.settearModelo(f05);
//		udc = modelo.getPdlttr();
//		f05 = servicioF0005.buscar("40", "AT", udc);
//		buscadorLTTR.settearModelo(f05);
//		udc = modelo.getPdnxtr();
//		f05 = servicioF0005.buscar("40", "AT", udc);
//		buscadorNXTR.settearModelo(f05);
	}
	
	
	
	
	
	
	
	
	
	
	protected boolean validar() {
		return true;
	}

	@Listen("onOpen = #gpxDatosF4111")
	public void abrirCatalogo() {
	}

	protected void habilitarTextClave() {
	}

	private boolean camposEditando() {
		if (dtbDGLF4111OP.getText().compareTo("") != 0
				|| dtbVPEJF4111OP.getText().compareTo("") != 0
				|| dtbHDGJF4111OP.getText().compareTo("") != 0
				|| dtbTRDJF4111OP.getText().compareTo("") != 0
				|| txtTREXF4111OP.getText().compareTo("") != 0
				|| txtASIDF4111OP.getText().compareTo("") != 0
				|| txtDOCF4111OP.getText().compareTo("") != 0
				|| txtAN8F4111OP.getText().compareTo("") != 0
				|| txtSHANF4111OP.getText().compareTo("") != 0
				|| txtOPSQF4111OP.getText().compareTo("") != 0
				|| txtRFLNF4111OP.getText().compareTo("") != 0
				|| txtTRQTF4111OP.getText().compareTo("") != 0
				|| txtUNCSF4111OP.getText().compareTo("") != 0
				|| buscadorDOCO.getCajaTexto().getText().compareTo("") != 0
				|| buscadorSUB.getCajaTexto().getText().compareTo("") != 0
				|| buscadorSBL.getCajaTexto().getText().compareTo("") != 0
				|| buscadorMCU.getCajaTexto().getText().compareTo("") != 0
				|| buscadorLOCN.getCajaTexto().getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	protected boolean validarSeleccion() {
		return true;
	}

	private void mostrarCatalogo() {
	}

	@Listen("onClick=#btnBuscarF4111P")
	public void mostrarCatalogoEmergente() {
	}

	@Listen("onSeleccion = #catalogoF4111Emergente")
	public void seleccionarEmergente() {
	}

	@Listen("onClick = #btnBuscarUbicacion1,#btnBuscarUbicacion2")
	public void mostrarCatalogoF4100(Event evento) {
	}

	private void setearUbicacion(F4100 f4100, Textbox txtUbicacion22,
			Label lblUbicacion22) {
		txtUbicacion22.setValue(f4100.getId().getLmlocn());
		lblUbicacion22.setValue(f4100.getId().getLmlocn());

	}

	private void llenarCamposItem(F4101 f4101) {
	}

	private void limpiarCamposDetalle() {

	}

}
