package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F4101;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF4101 extends CGenerico {

	@Wire
	private Div divVF4101;
	@Wire
	private Div botoneraF4101;
	@Wire
	private Groupbox gpxRegistroF4101;
	@Wire
	private Textbox txtArticuloF4101;
	@Wire
	private Textbox txtIMLITMF4101;
	@Wire
	private Button btnBuscarIMLITMF4101;
	@Wire
	private Textbox txIMLITMF4101;
	@Wire
	private Textbox txtIMDSC1F4101;
	@Wire
	private Textbox txtIMDSC2F4101;
	@Wire
	private Textbox txtIMSRTXF4101;
	@Wire
	private Div divBuscadorIMSTKT;
	@Wire
	private Div divBuscadorIMGLPT;
	@Wire
	private Div divBuscadorIMUOM1;
	@Wire
	private Textbox txtIMLNTYF4101;
	@Wire
	private Button btnBuscarIMLNTYF4101;
	@Wire
	private Label lblIMLNTYF4101;
	@Wire
	private Div divBuscadorIMBPFG;
	@Wire
	private Textbox txtIMALKYF4101;
	@Wire
	private Button btnBuscarIMALKYF4101;
	@Wire
	private Label lblIMALKYF4101;
	@Wire
	private Checkbox chxIMBACKF4101;
	@Wire
	private Checkbox chxIMCKAVF4101;
	@Wire
	private Div divBuscadorIMCLEV;
	@Wire
	private Div divBuscadorIMPLEV;
	@Wire
	private Div divBuscadorIMPPLV;
	@Wire
	private Div divBuscadorIMPMTH;
	@Wire
	private Div divBuscadorIMCMETH;
	@Wire
	private Div divBuscadorIMCMGL;
	@Wire
	private Div divBuscadorIMINMG;
	@Wire
	private Div divBuscadorIMIFLA;
	@Wire
	private Div divBuscadorIMTFLA;
	@Wire
	private Groupbox gpxDatosF4101;
	@Wire
	private Div catalogoF4101;
	@Wire
	private Div divCatalogoF40205;
	@Wire
	private Div divCatalogoF0101;

	Botonera botonera;
	double clave = 0;
	Catalogo<F0005> catalogoF0005;
	Catalogo<F4101> catalogo;
	

	BuscadorUDC buscadorIMSTKT, buscadorIMGLPT, buscadorIMUOM1,
	buscadorIMBPFG, buscadorIMCLEV, buscadorIMPLEV,
	buscadorIMPPLV, buscadorIMPMTH, buscadorIMCMETH,
	buscadorIMCMG, buscadorIMINMG, buscadorIMIFLA,
	buscadorIMTFLA, buscadorCategoria14, buscadorCategoria15,
	buscadorCategoria16, buscadorCategoria17, buscadorCategoria18,
	buscadorCategoria19, buscadorCategoria20, buscadorCategoria21,
	buscadorCategoria22, buscadorCategoria23, buscadorCategoria24,
	buscadorCategoria25, buscadorCategoria26, buscadorCategoria27,
	buscadorCategoria28, buscadorCategoria29, buscadorCategoria30,
	buscadorSTYL, buscadorSBLI, buscadorFMOD, buscadorPECC;

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		/*UDC IMSTKT (41,I)*/
		List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMSTKT = new BuscadorUDC("Tipo alm", 10, listaF0005,
				true, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMSTKT.obtenerCaja());
			}
		};
		divBuscadorIMSTKT.appendChild(buscadorIMSTKT);
		
		/*UDC IMGLPT (41,9)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMGLPT = new BuscadorUDC("Clasif libro mayor", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMGLPT.obtenerCaja());
			}
		};
		divBuscadorIMGLPT.appendChild(buscadorIMGLPT);
		
		/*UDC IMUOM1 (00,UM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMUOM1 = new BuscadorUDC("Unidad medida", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMUOM1.obtenerCaja());
			}
		};
		divBuscadorIMUOM1.appendChild(buscadorIMUOM1);
		
		
		/*UDC IMBPFG (41B,BF)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMBPFG = new BuscadorUDC("Prod granel/emb", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMBPFG.obtenerCaja());
			}
		};
		divBuscadorIMBPFG.appendChild(buscadorIMBPFG);
		
		/*UDC IMCLEV (H40, CL)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMCLEV = new BuscadorUDC("Nivel costo inventario", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMCLEV.obtenerCaja());
			}
		};
		divBuscadorIMCLEV.appendChild(buscadorIMCLEV);
		
		/*UDC IMPLEV (H40, PL)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMPLEV = new BuscadorUDC("Nivel precio venta", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMPLEV.obtenerCaja());
			}
		};
		divBuscadorIMPLEV.appendChild(buscadorIMPLEV);
		
		
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void buscar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void annadir() {
				// TODO Auto-generated method stub

			}

			@Override
			public void guardar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void limpiar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void salir() {
				// TODO Auto-generated method stub
				cerrarVentana(divVF4101,
						"Trabajo con Examinador de Maestro de Articulos");
			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void ayuda() {
				// TODO Auto-generated method stub

			}

		};
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF4101.appendChild(botonera);

	}

	public void limpiarCampos() {

	}

	public void habilitarTextClave() {

	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
		botonera.getChildren().get(6).setVisible(bol);
	}

}
