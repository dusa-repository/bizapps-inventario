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
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
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
	private Div divBuscadorIMPRGR;
	@Wire
	private Div divBuscadorIMRPRC;
	@Wire
	private Div divBuscadorIMORPR;
	@Wire
	private Div divBuscadorIMDSGP;
	@Wire
	private Checkbox chxIMXDCKF4101;
	@Wire
	private Textbox txtDLTLF4101;
	@Wire
	private Radiogroup rdgIMABCSF4101;
	@Wire
	private Radio rdoIMABCSClasificacionAF4101;
	@Wire
	private Radio rdoIMABCSClasificacionBF4101;
	@Wire
	private Radio rdoIMABCSClasificacionCF4101;
	@Wire
	private Radio rdoIMABCSSinClasificacionF4101;
	@Wire
	private Radiogroup rdgIMABCMF4101;
	@Wire
	private Radio rdoIMABCMClasificacionAF4101;
	@Wire
	private Radio rdoIMABCMClasificacionBF4101;
	@Wire
	private Radio rdoIMABCMClasificacionCF4101;
	@Wire
	private Radio rdoIMABCMSinClasificacionF4101;
	@Wire
	private Radiogroup rdgIMABCIF4101;
	@Wire
	private Radio rdoIMABCIClasificacionAF4101;
	@Wire
	private Radio rdoIMABCIClasificacionBF4101;
	@Wire
	private Radio rdoIMABCIClasificacionCF4101;
	@Wire
	private Radio rdoIMABCISinClasificacionF4101;
	@Wire
	private Div divBuscadorPrincipalIMUOM1;
	@Wire
	private Div divBuscadorIMUOM2;
	@Wire
	private Div divBuscadorIMUOM3;
	@Wire
	private Div divBuscadorIMUOM4;
	@Wire
	private Div divBuscadorIMUOM6;
	@Wire
	private Div divBuscadorIMUOM8;
	@Wire
	private Div divBuscadorIMUOM9;
	@Wire
	private Div divBuscadorIMUWUM;
	@Wire
	private Div divBuscadorIMUVM1;
	@Wire
	private Div divBuscadorIMSRNR;
	@Wire
	private Div divBuscadorIMLOTS;
	@Wire
	private Div divBuscadorIMSRCE;
	@Wire
	private Div divBuscadorIMCMDM;
	@Wire
	private Div divBuscadorIMLECM;
	@Wire
	private Textbox txtIMSLDF4101;
	@Wire
	private Textbox txtIMU1DDF4101;
	@Wire
	private Textbox txtIMU2DDF4101;
	@Wire
	private Textbox txtIMU3DDF4101;
	@Wire
	private Textbox txtIMU4DDF4101;
	@Wire
	private Textbox txtIMU5DDF4101;
	@Wire
	private Textbox txtIMBBDDF4101;
	@Wire
	private Textbox txtIMSBDDF4101;
	@Wire
	private Textbox txtIMLEDDF4101;
	@Wire
	private Textbox txtIMPEFDF4101;
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
	buscadorIMCMGL, buscadorIMINMG, buscadorIMIFLA,
	buscadorIMTFLA, buscadorIMPRGR, buscadorIMRPRC,
	buscadorIMORPR, buscadorIMDSGP, buscadorPrincipalIMUOM1,
	buscadorIMUOM2, buscadorIMUOM3, buscadorIMUOM4,
	buscadorIMUOM6, buscadorIMUOM8, buscadorIMUOM9,
	buscadorIMUWUM, buscadorIMUVM1, buscadorIMSRNR,
	buscadorIMLOTS, buscadorIMSRCE, buscadorIMCMDM,
	buscadorIMLECM;

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
		
		
		/*UDC IMPPLV (H40, PP)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMPPLV = new BuscadorUDC("Nivel precio compra", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMPPLV.obtenerCaja());
			}
		};
		divBuscadorIMPPLV.appendChild(buscadorIMPPLV);
		
		
		/*UDC IMPMTH (H41, PM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMPMTH = new BuscadorUDC("Mét fijación precios juegos/config", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMPMTH.obtenerCaja());
			}
		};
		divBuscadorIMPMTH.appendChild(buscadorIMPMTH);
		
		
		/*UDC IMCMETH (41, CM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMCMETH = new BuscadorUDC("Método configurador cálculo costos", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMCMETH.obtenerCaja());
			}
		};
		divBuscadorIMCMETH.appendChild(buscadorIMCMETH);
		
		
		/*UDC IMCMGL (H40, CM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMCMGL = new BuscadorUDC("Método compromiso", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMCMGL.obtenerCaja());
			}
		};
		divBuscadorIMCMGL.appendChild(buscadorIMCMGL);
		
		
		/*UDC IMINMG (40, PM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMINMG = new BuscadorUDC("Mensaje impr", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMINMG.obtenerCaja());
			}
		};
		divBuscadorIMINMG.appendChild(buscadorIMINMG);
		
		
		/*UDC IMIFLA (40, FL)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMIFLA = new BuscadorUDC("Mensaje intermitente artículo", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMIFLA.obtenerCaja());
			}
		};
		divBuscadorIMIFLA.appendChild(buscadorIMIFLA);
		
		
		/*UDC IMTFLA (H40, ST)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMTFLA = new BuscadorUDC("Conversión UM estándar", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMTFLA.obtenerCaja());
			}
		};
		divBuscadorIMTFLA.appendChild(buscadorIMTFLA);
		
		/*UDC IMPRGR (40, PI)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMPRGR = new BuscadorUDC("Gp precios art", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMPRGR.obtenerCaja());
			}
		};
		divBuscadorIMPRGR.appendChild(buscadorIMPRGR);
		
		/*UDC IMRPRC (40, PI)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMRPRC = new BuscadorUDC("Retarif precios gp", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMRPRC.obtenerCaja());
			}
		};
		divBuscadorIMRPRC.appendChild(buscadorIMRPRC);
		
		/*UDC IMORPR (40, PI)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMORPR = new BuscadorUDC("Retarif precio órdenes", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMORPR.obtenerCaja());
			}
		};
		divBuscadorIMORPR.appendChild(buscadorIMORPR);
		
		/*UDC IMPRGR (40, PI)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMDSGP = new BuscadorUDC("Grupo despacho", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMDSGP.obtenerCaja());
			}
		};
		divBuscadorIMDSGP.appendChild(buscadorIMDSGP);
		
		/*UDC IMUOM1 (00, UM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorPrincipalIMUOM1 = new BuscadorUDC("Principal", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorPrincipalIMUOM1.obtenerCaja());
			}
		};
		divBuscadorPrincipalIMUOM1.appendChild(buscadorPrincipalIMUOM1);
		
		/*UDC IMUOM2 (00, UM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMUOM2 = new BuscadorUDC("Secundario", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMUOM2.obtenerCaja());
			}
		};
		divBuscadorIMUOM2.appendChild(buscadorIMUOM2);
		
		/*UDC IMUOM3 (00, UM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMUOM3 = new BuscadorUDC("Compras", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMUOM3.obtenerCaja());
			}
		};
		divBuscadorIMUOM3.appendChild(buscadorIMUOM3);
		
		/*UDC IMUOM4 (00, UM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMUOM4 = new BuscadorUDC("Tarificación", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMUOM4.obtenerCaja());
			}
		};
		divBuscadorIMUOM4.appendChild(buscadorIMUOM4);
		
		/*UDC IMUOM6 (00, UM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMUOM6 = new BuscadorUDC("Envío", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMUOM6.obtenerCaja());
			}
		};
		divBuscadorIMUOM6.appendChild(buscadorIMUOM6);
		
		/*UDC IMUOM8 (00, UM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMUOM8 = new BuscadorUDC("Producción", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMUOM8.obtenerCaja());
			}
		};
		divBuscadorIMUOM8.appendChild(buscadorIMUOM8);
		
		/*UDC IMUOM9 (00, UM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMUOM9 = new BuscadorUDC("Componente", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMUOM9.obtenerCaja());
			}
		};
		divBuscadorIMUOM9.appendChild(buscadorIMUOM9);
		
		
		/*UDC IMUWUM (00, UM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMUWUM = new BuscadorUDC("Peso", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMUWUM.obtenerCaja());
			}
		};
		divBuscadorIMUWUM.appendChild(buscadorIMUWUM);
		
		/*UDC IMUWUM (00, UM)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMUVM1 = new BuscadorUDC("Volúmen", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMUVM1.obtenerCaja());
			}
		};
		divBuscadorIMUVM1.appendChild(buscadorIMUVM1);
		
		
		/*UDC IMSRNR (H41, NR)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMSRNR = new BuscadorUDC("N° serie obligatorio", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMSRNR.obtenerCaja());
			}
		};
		divBuscadorIMSRNR.appendChild(buscadorIMSRNR);
		
		
		/*UDC IMLOTS (41, L)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMLOTS = new BuscadorUDC("Código estado lote", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMLOTS.obtenerCaja());
			}
		};
		divBuscadorIMLOTS.appendChild(buscadorIMLOTS);
		
		
		/*UDC IMSRCE (H41, SR)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		 buscadorIMSRCE = new BuscadorUDC("Tipo proceso lote", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						 buscadorIMSRCE.obtenerCaja());
			}
		};
		divBuscadorIMSRCE.appendChild(buscadorIMSRCE);
		
		
		/*UDC IMCMDM (H40, CD)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		 buscadorIMCMDM = new BuscadorUDC("Método fecha compromiso", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						 buscadorIMCMDM.obtenerCaja());
			}
		};
		divBuscadorIMCMDM.appendChild(buscadorIMCMDM);
		
		
		/*UDC IMLECM (H41, EC)*/
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"00");
		buscadorIMLECM = new BuscadorUDC("Método fecha caducidad lote", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorIMLECM.obtenerCaja());
			}
		};
		divBuscadorIMLECM.appendChild(buscadorIMLECM);
		
				
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
