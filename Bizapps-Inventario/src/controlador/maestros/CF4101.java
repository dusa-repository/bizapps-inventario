package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0008;
import modelo.maestros.F0015;
import modelo.maestros.F0101;
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
	private Textbox txtArticuloIMLITMF4101;
	@Wire
	private Button btnBuscarIMLITMF4101;
	@Wire
	private Textbox txtIMLITMF4101;
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
	private Checkbox chxIMDUALF4101;
	@Wire
	private Checkbox chxIMDPPOF4101;
	@Wire
	private Textbox txtCMDCDEF4101;
	@Wire
	private Textbox txtUNSPSCF4101;
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
	Catalogo<F0101> catalogoDirecciones;
	Catalogo<F4101> catalogo;

	BuscadorUDC buscadorIMSTKT, buscadorIMGLPT, buscadorIMUOM1, buscadorIMBPFG,
			buscadorIMCLEV, buscadorIMPLEV, buscadorIMPPLV, buscadorIMPMTH,
			buscadorIMCMETH, buscadorIMCMGL, buscadorIMINMG, buscadorIMIFLA,
			buscadorIMTFLA, buscadorIMPRGR, buscadorIMRPRC, buscadorIMORPR,
			buscadorIMDSGP, buscadorPrincipalIMUOM1, buscadorIMUOM2,
			buscadorIMUOM3, buscadorIMUOM4, buscadorIMUOM6, buscadorIMUOM8,
			buscadorIMUOM9, buscadorIMUWUM, buscadorIMUVM1, buscadorIMSRNR,
			buscadorIMLOTS, buscadorIMSRCE, buscadorIMCMDM, buscadorIMLECM;

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		txtArticuloF4101.setFocus(true);

		/* UDC IMSTKT (41,I) */
		List<F0005> listaF0005 = servicioF0005
				.buscarParaUDCOrdenados("41", "I");
		buscadorIMSTKT = new BuscadorUDC("Tipo alm", 1, listaF0005, true,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("41", "I",
						buscadorIMSTKT.obtenerCaja());
			}
		};
		divBuscadorIMSTKT.appendChild(buscadorIMSTKT);

		/* UDC IMGLPT (41,9) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("41", "9");
		buscadorIMGLPT = new BuscadorUDC("Clasif libro mayor", 4, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("41", "9",
						buscadorIMGLPT.obtenerCaja());
			}
		};
		divBuscadorIMGLPT.appendChild(buscadorIMGLPT);

		/* UDC IMUOM1 (00,UM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "UM");
		buscadorIMUOM1 = new BuscadorUDC("Unidad medida", 2, listaF0005, true,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorIMUOM1.obtenerCaja());
			}
		};
		divBuscadorIMUOM1.appendChild(buscadorIMUOM1);

		/* UDC IMBPFG (41B,BF) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("41B", "BF");
		buscadorIMBPFG = new BuscadorUDC("Prod granel/emb", 1, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("41B", "BF",
						buscadorIMBPFG.obtenerCaja());
			}
		};
		divBuscadorIMBPFG.appendChild(buscadorIMBPFG);

		/* UDC IMCLEV (H40, CL) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H40", "CL");
		buscadorIMCLEV = new BuscadorUDC("Nivel costo inventario", 1,
				listaF0005, false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H40", "CL",
						buscadorIMCLEV.obtenerCaja());
			}
		};
		divBuscadorIMCLEV.appendChild(buscadorIMCLEV);

		/* UDC IMPLEV (H40, PL) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H40", "PL");
		buscadorIMPLEV = new BuscadorUDC("Nivel precio venta", 1, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H40", "PL",
						buscadorIMPLEV.obtenerCaja());
			}
		};
		divBuscadorIMPLEV.appendChild(buscadorIMPLEV);

		/* UDC IMPPLV (H40, PP) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H40", "PP");
		buscadorIMPPLV = new BuscadorUDC("Nivel precio compra", 1, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H40", "PP",
						buscadorIMPPLV.obtenerCaja());
			}
		};
		divBuscadorIMPPLV.appendChild(buscadorIMPPLV);

		/* UDC IMPMTH (H41, PM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H41", "PM");
		buscadorIMPMTH = new BuscadorUDC("Mét fijación precios juegos/config",
				1, listaF0005, false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H41", "PM",
						buscadorIMPMTH.obtenerCaja());
			}
		};
		divBuscadorIMPMTH.appendChild(buscadorIMPMTH);

		/* UDC IMCMETH (41, CM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("41", "CM");
		buscadorIMCMETH = new BuscadorUDC("Método configurador cálculo costos",
				1, listaF0005, false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("41", "CM",
						buscadorIMCMETH.obtenerCaja());
			}
		};
		divBuscadorIMCMETH.appendChild(buscadorIMCMETH);

		/* UDC IMCMGL (H40, CM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H40", "CM");
		buscadorIMCMGL = new BuscadorUDC("Método compromiso", 1, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H40", "CM",
						buscadorIMCMGL.obtenerCaja());
			}
		};
		divBuscadorIMCMGL.appendChild(buscadorIMCMGL);

		/* UDC IMINMG (40, PM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("40", "PM");
		buscadorIMINMG = new BuscadorUDC("Mensaje impr", 10, listaF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "PM",
						buscadorIMINMG.obtenerCaja());
			}
		};
		divBuscadorIMINMG.appendChild(buscadorIMINMG);

		/* UDC IMIFLA (40, FL) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("40", "FL");
		buscadorIMIFLA = new BuscadorUDC("Mensaje intermitente artículo", 2,
				listaF0005, false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "FL",
						buscadorIMIFLA.obtenerCaja());
			}
		};
		divBuscadorIMIFLA.appendChild(buscadorIMIFLA);

		/* UDC IMTFLA (H40, ST) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H40", "ST");
		buscadorIMTFLA = new BuscadorUDC("Conversión UM estándar", 2,
				listaF0005, false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H40", "ST",
						buscadorIMTFLA.obtenerCaja());
			}
		};
		divBuscadorIMTFLA.appendChild(buscadorIMTFLA);

		/* UDC IMPRGR (40, PI) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("40", "PI");
		buscadorIMPRGR = new BuscadorUDC("Gp precios art", 8, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "PI",
						buscadorIMPRGR.obtenerCaja());
			}
		};
		divBuscadorIMPRGR.appendChild(buscadorIMPRGR);

		/* UDC IMRPRC (40, PI) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("40", "PI");
		buscadorIMRPRC = new BuscadorUDC("Retarif precios gp", 8, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "PI",
						buscadorIMRPRC.obtenerCaja());
			}
		};
		divBuscadorIMRPRC.appendChild(buscadorIMRPRC);

		/* UDC IMORPR (40, PI) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("40", "PI");
		buscadorIMORPR = new BuscadorUDC("Retarif precio órdenes", 8,
				listaF0005, false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("40", "PI",
						buscadorIMORPR.obtenerCaja());
			}
		};
		divBuscadorIMORPR.appendChild(buscadorIMORPR);

		/* UDC IMDSGP (41B, DG) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("41B", "DG");
		buscadorIMDSGP = new BuscadorUDC("Grupo despacho", 10, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("41B", "DG",
						buscadorIMDSGP.obtenerCaja());
			}
		};
		divBuscadorIMDSGP.appendChild(buscadorIMDSGP);

		/* UDC IMUOM1 (00, UM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "UM");
		buscadorPrincipalIMUOM1 = new BuscadorUDC("Principal", 2, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorPrincipalIMUOM1.obtenerCaja());
			}
		};
		divBuscadorPrincipalIMUOM1.appendChild(buscadorPrincipalIMUOM1);

		/* UDC IMUOM2 (00, UM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "UM");
		buscadorIMUOM2 = new BuscadorUDC("Secundario", 2, listaF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorIMUOM2.obtenerCaja());
			}
		};
		divBuscadorIMUOM2.appendChild(buscadorIMUOM2);

		/* UDC IMUOM3 (00, UM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "UM");
		buscadorIMUOM3 = new BuscadorUDC("Compras", 2, listaF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorIMUOM3.obtenerCaja());
			}
		};
		divBuscadorIMUOM3.appendChild(buscadorIMUOM3);

		/* UDC IMUOM4 (00, UM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "UM");
		buscadorIMUOM4 = new BuscadorUDC("Tarificación", 2, listaF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorIMUOM4.obtenerCaja());
			}
		};
		divBuscadorIMUOM4.appendChild(buscadorIMUOM4);

		/* UDC IMUOM6 (00, UM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "UM");
		buscadorIMUOM6 = new BuscadorUDC("Envío", 2, listaF0005, false, false,
				false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorIMUOM6.obtenerCaja());
			}
		};
		divBuscadorIMUOM6.appendChild(buscadorIMUOM6);

		/* UDC IMUOM8 (00, UM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "UM");
		buscadorIMUOM8 = new BuscadorUDC("Producción", 2, listaF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorIMUOM8.obtenerCaja());
			}
		};
		divBuscadorIMUOM8.appendChild(buscadorIMUOM8);

		/* UDC IMUOM9 (00, UM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "UM");
		buscadorIMUOM9 = new BuscadorUDC("Componente", 2, listaF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorIMUOM9.obtenerCaja());
			}
		};
		divBuscadorIMUOM9.appendChild(buscadorIMUOM9);

		/* UDC IMUWUM (00, UM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "UM");
		buscadorIMUWUM = new BuscadorUDC("Peso", 2, listaF0005, false, false,
				false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorIMUWUM.obtenerCaja());
			}
		};
		divBuscadorIMUWUM.appendChild(buscadorIMUWUM);

		/* UDC IMUVM1 (00, UM) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "UM");
		buscadorIMUVM1 = new BuscadorUDC("Volúmen", 2, listaF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "UM",
						buscadorIMUVM1.obtenerCaja());
			}
		};
		divBuscadorIMUVM1.appendChild(buscadorIMUVM1);

		/* UDC IMSRNR (H41, NR) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H41", "NR");
		buscadorIMSRNR = new BuscadorUDC("N° serie obligatorio", 1,
				listaF0005, false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H41", "NR",
						buscadorIMSRNR.obtenerCaja());
			}
		};
		divBuscadorIMSRNR.appendChild(buscadorIMSRNR);

		/* UDC IMLOTS (41, L) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("41", "L");
		buscadorIMLOTS = new BuscadorUDC("Código estado lote", 1, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("41", "L",
						buscadorIMLOTS.obtenerCaja());
			}
		};
		divBuscadorIMLOTS.appendChild(buscadorIMLOTS);

		/* UDC IMSRCE (H41, SR) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H41", "SR");
		buscadorIMSRCE = new BuscadorUDC("Tipo proceso lote", 1, listaF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H41", "SR",
						buscadorIMSRCE.obtenerCaja());
			}
		};
		divBuscadorIMSRCE.appendChild(buscadorIMSRCE);

		/* UDC IMCMDM (H40, CD) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H40", "CD");
		buscadorIMCMDM = new BuscadorUDC("Método fecha compromiso", 1,
				listaF0005, false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H40", "CD",
						buscadorIMCMDM.obtenerCaja());
			}
		};
		divBuscadorIMCMDM.appendChild(buscadorIMCMDM);

		/* UDC IMLECM (H41, EC) */
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H41", "EC");
		buscadorIMLECM = new BuscadorUDC("Método fecha caducidad lote", 1,
				listaF0005, false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H41", "EC",
						buscadorIMLECM.obtenerCaja());
			}
		};
		divBuscadorIMLECM.appendChild(buscadorIMLECM);

		mostrarCatalogoF4101();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F4101 f4101 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f4101.getImitm();
						txtArticuloF4101.setValue(String.valueOf(f4101
								.getImitm()));
						txtArticuloF4101.setDisabled(true);
						txtArticuloIMLITMF4101.setValue(f4101.getImlitm());
						txtIMLITMF4101.setValue(f4101.getImlitm());
						txtIMDSC1F4101.setValue(f4101.getImdsc1());
						txtIMDSC2F4101.setValue(f4101.getImdsc2());
						txtIMSRTXF4101.setValue(f4101.getImsrtx());
						/* UDC IMSTKT (41,I) */
						buscadorIMSTKT.settearCampo(servicioF0005.buscar("41",
								"I", f4101.getImstkt()));
						/* UDC IMGLPT (41,9) */
						buscadorIMGLPT.settearCampo(servicioF0005.buscar("41",
								"9", f4101.getImglpt()));
						/* UDC IMUOM1 (00,UM) */
						buscadorIMUOM1.settearCampo(servicioF0005.buscar("00",
								"UM", f4101.getImuom1()));
						/* UDC IMBPFG (41B,BF) */
						buscadorIMBPFG.settearCampo(servicioF0005.buscar("41B",
								"BF", f4101.getImbpfg()));
						/* UDC IMCLEV (H40, CL) */
						buscadorIMCLEV.settearCampo(servicioF0005.buscar("H40",
								"CL", f4101.getImclev()));
						/* UDC IMPLEV (H40, PL) */
						buscadorIMPLEV.settearCampo(servicioF0005.buscar("H40",
								"PL", f4101.getImplev()));
						/* UDC IMPPLV (H40, PP) */
						buscadorIMPPLV.settearCampo(servicioF0005.buscar("H40",
								"PP", f4101.getImpplv()));
						/* UDC IMPMTH (H41, PM) */
						buscadorIMPMTH.settearCampo(servicioF0005.buscar("HP1",
								"PM", f4101.getImpmth()));
						/* UDC IMCMETH (41, CM) */
						buscadorIMCMETH.settearCampo(servicioF0005.buscar("41",
								"CM", f4101.getImcmeth()));
						/* UDC IMCMGL (H40, CM) */
						buscadorIMCMGL.settearCampo(servicioF0005.buscar("H40",
								"CM", f4101.getImcmgl()));
						/* UDC IMINMG (40, PM) */
						buscadorIMINMG.settearCampo(servicioF0005.buscar("40",
								"PM", f4101.getIminmg()));
						/* UDC IMIFLA (40, FL) */
						buscadorIMIFLA.settearCampo(servicioF0005.buscar("40",
								"FL", f4101.getImifla()));
						/* UDC IMTFLA (H40, ST) */
						buscadorIMTFLA.settearCampo(servicioF0005.buscar("H40",
								"ST", f4101.getImtfla()));
						/* UDC IMPRGR (40, PI) */
						buscadorIMPRGR.settearCampo(servicioF0005.buscar("40",
								"PI", f4101.getImprgr()));
						/* UDC IMRPRC (40, PI) */
						buscadorIMRPRC.settearCampo(servicioF0005.buscar("40",
								"PI", f4101.getImrprc()));
						/* UDC IMORPR (40, PI) */
						buscadorIMORPR.settearCampo(servicioF0005.buscar("40",
								"PI", f4101.getImorpr()));
						/* UDC IMDSGP (40, PI) */
						buscadorIMDSGP.settearCampo(servicioF0005.buscar("41B",
								"DG", f4101.getImdsgp()));
						/* UDC IMUOM1 (00, UM) */
						buscadorPrincipalIMUOM1.settearCampo(servicioF0005
								.buscar("00", "UM", f4101.getImuom1()));
						/* UDC IMUOM2 (00, UM) */
						buscadorIMUOM2.settearCampo(servicioF0005.buscar("00",
								"UM", f4101.getImuom2()));
						/* UDC IMUOM3 (00, UM) */
						buscadorIMUOM3.settearCampo(servicioF0005.buscar("00",
								"UM", f4101.getImuom3()));
						/* UDC IMUOM4 (00, UM) */
						buscadorIMUOM4.settearCampo(servicioF0005.buscar("00",
								"UM", f4101.getImuom4()));
						/* UDC IMUOM6 (00, UM) */
						buscadorIMUOM6.settearCampo(servicioF0005.buscar("00",
								"UM", f4101.getImuom6()));
						/* UDC IMUOM8 (00, UM) */
						buscadorIMUOM8.settearCampo(servicioF0005.buscar("00",
								"UM", f4101.getImuom8()));
						/* UDC IMUOM9 (00, UM) */
						buscadorIMUOM9.settearCampo(servicioF0005.buscar("00",
								"UM", f4101.getImuom9()));
						/* UDC IMUWUM (00, UM) */
						buscadorIMUWUM.settearCampo(servicioF0005.buscar("00",
								"UM", f4101.getImuwum()));
						/* UDC IMUVM1 (00, UM) */
						buscadorIMUVM1.settearCampo(servicioF0005.buscar("00",
								"UM", f4101.getImuvm1()));
						/* UDC IMSRNR (H41, NR) */
						buscadorIMSRNR.settearCampo(servicioF0005.buscar("H41",
								"NR", f4101.getImsrnr()));
						/* UDC IMLOTS (41, L) */
						buscadorIMLOTS.settearCampo(servicioF0005.buscar("41",
								"L", f4101.getImlots()));
						/* UDC IMSRCE (H41, SR) */
						buscadorIMSRCE.settearCampo(servicioF0005.buscar("H41",
								"SR", f4101.getImsrce()));
						/* UDC IMCMDM (H40, CD) */
						buscadorIMCMDM.settearCampo(servicioF0005.buscar("H40",
								"CD", f4101.getImcmdm()));
						/* UDC IMLECM (H41, EC) */
						buscadorIMLECM.settearCampo(servicioF0005.buscar("H41",
								"EC", f4101.getImlecm()));

						txtIMLNTYF4101.setValue(f4101.getImlnty());

						if (f4101.getImback().equals("Y"))
							chxIMBACKF4101.setChecked(true);

						if (f4101.getImckav().equals("Y"))
							chxIMCKAVF4101.setChecked(true);

						if (f4101.getImckav().equals("Y"))
							chxIMXDCKF4101.setChecked(true);

						if (f4101.getImdual().equals("Y"))
							chxIMDUALF4101.setChecked(true);

						if (f4101.getImdppo().equals("Y"))
							chxIMDPPOF4101.setChecked(true);

						txtDLTLF4101
								.setValue(String.valueOf(f4101.getImdltl()));

						if (f4101.getImabcs().equals("A"))
							rdoIMABCSClasificacionAF4101.setSelected(true);

						if (f4101.getImabcs().equals("B"))
							rdoIMABCSClasificacionBF4101.setSelected(true);

						if (f4101.getImabcs().equals("C"))
							rdoIMABCSClasificacionCF4101.setSelected(true);

						if (f4101.getImabcs().equals("S"))
							rdoIMABCSSinClasificacionF4101.setSelected(true);

						if (f4101.getImabcm().equals("A"))
							rdoIMABCMClasificacionAF4101.setSelected(true);

						if (f4101.getImabcm().equals("B"))
							rdoIMABCMClasificacionBF4101.setSelected(true);

						if (f4101.getImabcm().equals("C"))
							rdoIMABCMClasificacionCF4101.setSelected(true);

						if (f4101.getImabcm().equals("S"))
							rdoIMABCMSinClasificacionF4101.setSelected(true);

						if (f4101.getImabci().equals("A"))
							rdoIMABCMClasificacionAF4101.setSelected(true);

						if (f4101.getImabci().equals("B"))
							rdoIMABCMClasificacionBF4101.setSelected(true);

						if (f4101.getImabci().equals("C"))
							rdoIMABCMClasificacionCF4101.setSelected(true);

						if (f4101.getImabci().equals("S"))
							rdoIMABCMSinClasificacionF4101.setSelected(true);

						txtIMSLDF4101
								.setValue(String.valueOf(f4101.getImsld()));
						txtIMU1DDF4101.setValue(String.valueOf(f4101
								.getImu1dd()));
						txtIMU2DDF4101.setValue(String.valueOf(f4101
								.getImu2dd()));
						txtIMU3DDF4101.setValue(String.valueOf(f4101
								.getImu3dd()));
						txtIMU4DDF4101.setValue(String.valueOf(f4101
								.getImu4dd()));
						txtIMU5DDF4101.setValue(String.valueOf(f4101
								.getImu5dd()));
						txtIMBBDDF4101.setValue(String.valueOf(f4101
								.getImbbdd()));
						txtIMSBDDF4101.setValue(String.valueOf(f4101
								.getImsbdd()));
						txtIMLEDDF4101.setValue(String.valueOf(f4101
								.getImledd()));
						txtIMPEFDF4101.setValue(String.valueOf(f4101
								.getImpefd()));
						txtArticuloIMLITMF4101.setFocus(true);

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
				// TODO Auto-generated method stub
				abrirRegistro();
				mostrarBotones(false);

			}

			@Override
			public void guardar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void limpiar() {
				// TODO Auto-generated method stub
				mostrarBotones(false);
				limpiarCampos();
				clave = 0;
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
				if (gpxDatosF4101.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F4101> eliminarLista = catalogo
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
													servicioF4101
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF4101
															.buscarTodosOrdenados());
												}
											}
										});
					}
				} else {
					/* Elimina un solo registro */
					if (clave != 0) {
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
													servicioF4101
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF4101
															.buscarTodosOrdenados());
												}
											}
										});
					} else
						msj.mensajeAlerta(Mensaje.noSeleccionoRegistro);
				}

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
		clave = 0;
		buscadorIMSTKT.settearCampo(null);
		buscadorIMGLPT.settearCampo(null);
		buscadorIMUOM1.settearCampo(null);
		buscadorIMBPFG.settearCampo(null);
		buscadorIMCLEV.settearCampo(null);
		buscadorIMPLEV.settearCampo(null);
		buscadorIMPPLV.settearCampo(null);
		buscadorIMPMTH.settearCampo(null);
		buscadorIMCMETH.settearCampo(null);
		buscadorIMCMGL.settearCampo(null);
		buscadorIMINMG.settearCampo(null);
		buscadorIMIFLA.settearCampo(null);
		buscadorIMTFLA.settearCampo(null);
		buscadorIMPRGR.settearCampo(null);
		buscadorIMRPRC.settearCampo(null);
		buscadorIMORPR.settearCampo(null);
		buscadorIMDSGP.settearCampo(null);
		buscadorPrincipalIMUOM1.settearCampo(null);
		buscadorIMUOM2.settearCampo(null);
		buscadorIMUOM3.settearCampo(null);
		buscadorIMUOM4.settearCampo(null);
		buscadorIMUOM6.settearCampo(null);
		buscadorIMUOM8.settearCampo(null);
		buscadorIMUOM9.settearCampo(null);
		buscadorIMUWUM.settearCampo(null);
		buscadorIMUVM1.settearCampo(null);
		buscadorIMSRNR.settearCampo(null);
		buscadorIMLOTS.settearCampo(null);
		buscadorIMSRCE.settearCampo(null);
		buscadorIMCMDM.settearCampo(null);
		buscadorIMLECM.settearCampo(null);
		txtArticuloF4101.setValue("");
		txtArticuloIMLITMF4101.setValue("");
		txtIMLITMF4101.setValue("");
		txtIMDSC1F4101.setValue("");
		txtIMDSC2F4101.setValue("");
		txtIMSRTXF4101.setValue("");
		txtIMLNTYF4101.setValue("");
		lblIMLNTYF4101.setValue("");
		txtIMALKYF4101.setValue("");
		lblIMALKYF4101.setValue("");
		chxIMBACKF4101.setChecked(false);
		chxIMCKAVF4101.setChecked(false);
		chxIMXDCKF4101.setChecked(false);
		chxIMDUALF4101.setChecked(false);
		chxIMDPPOF4101.setChecked(false);
		txtDLTLF4101.setValue("");
		txtCMDCDEF4101.setValue("");
		txtUNSPSCF4101.setValue("");
		rdgIMABCSF4101.setSelectedItem(null);
		rdgIMABCMF4101.setSelectedItem(null);
		rdgIMABCIF4101.setSelectedItem(null);
		txtIMSLDF4101.setValue("");
		txtIMU1DDF4101.setValue("");
		txtIMBBDDF4101.setValue("");
		txtIMU2DDF4101.setValue("");
		txtIMSBDDF4101.setValue("");
		txtIMU3DDF4101.setValue("");
		txtIMLEDDF4101.setValue("");
		txtIMU4DDF4101.setValue("");
		txtIMPEFDF4101.setValue("");
		txtIMU5DDF4101.setValue("");
		catalogo.limpiarSeleccion();
		txtArticuloF4101.setFocus(true);

	}

	public boolean camposLLenos() {
		if (txtArticuloIMLITMF4101.getText().compareTo("") == 0
				|| buscadorIMSTKT.obtenerCaja().compareTo("") == 0
				|| txtIMDSC1F4101.getText().compareTo("") == 0
				|| buscadorIMUOM1.obtenerCaja().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (buscadorIMSTKT.obtenerCaja().compareTo("") != 0
				|| buscadorIMGLPT.obtenerCaja().compareTo("") != 0
				|| buscadorIMUOM1.obtenerCaja().compareTo("") != 0
				|| buscadorIMBPFG.obtenerCaja().compareTo("") != 0
				|| buscadorIMCLEV.obtenerCaja().compareTo("") != 0
				|| buscadorIMPLEV.obtenerCaja().compareTo("") != 0
				|| buscadorIMPPLV.obtenerCaja().compareTo("") != 0
				|| buscadorIMPMTH.obtenerCaja().compareTo("") != 0
				|| buscadorIMCMETH.obtenerCaja().compareTo("") != 0
				|| buscadorIMCMGL.obtenerCaja().compareTo("") != 0
				|| buscadorIMINMG.obtenerCaja().compareTo("") != 0
				|| buscadorIMIFLA.obtenerCaja().compareTo("") != 0
				|| buscadorIMTFLA.obtenerCaja().compareTo("") != 0
				|| buscadorIMPRGR.obtenerCaja().compareTo("") != 0
				|| buscadorIMRPRC.obtenerCaja().compareTo("") != 0
				|| buscadorIMORPR.obtenerCaja().compareTo("") != 0
				|| buscadorIMDSGP.obtenerCaja().compareTo("") != 0
				|| buscadorPrincipalIMUOM1.obtenerCaja().compareTo("") != 0
				|| buscadorIMUOM2.obtenerCaja().compareTo("") != 0
				|| buscadorIMUOM3.obtenerCaja().compareTo("") != 0
				|| buscadorIMUOM4.obtenerCaja().compareTo("") != 0
				|| buscadorIMUOM6.obtenerCaja().compareTo("") != 0
				|| buscadorIMUOM8.obtenerCaja().compareTo("") != 0
				|| buscadorIMUOM9.obtenerCaja().compareTo("") != 0
				|| buscadorIMUWUM.obtenerCaja().compareTo("") != 0
				|| buscadorIMUVM1.obtenerCaja().compareTo("") != 0
				|| buscadorIMSRNR.obtenerCaja().compareTo("") != 0
				|| buscadorIMLOTS.obtenerCaja().compareTo("") != 0
				|| buscadorIMSRCE.obtenerCaja().compareTo("") != 0
				|| buscadorIMCMDM.obtenerCaja().compareTo("") != 0
				|| buscadorIMLECM.obtenerCaja().compareTo("") != 0
				|| txtArticuloF4101.getText().compareTo("") != 0
				|| txtArticuloIMLITMF4101.getText().compareTo("") != 0
				|| txtIMLITMF4101.getText().compareTo("") != 0
				|| txtIMDSC1F4101.getText().compareTo("") != 0
				|| txtIMDSC2F4101.getText().compareTo("") != 0
				|| txtIMSRTXF4101.getText().compareTo("") != 0
				|| txtIMLNTYF4101.getText().compareTo("") != 0
				|| txtIMALKYF4101.getText().compareTo("") != 0
				|| chxIMBACKF4101.isChecked() || chxIMCKAVF4101.isChecked()
				|| chxIMXDCKF4101.isChecked() || chxIMDUALF4101.isChecked()
				|| chxIMDPPOF4101.isChecked()
				|| txtDLTLF4101.getText().compareTo("") != 0
				|| txtCMDCDEF4101.getText().compareTo("") != 0
				|| txtUNSPSCF4101.getText().compareTo("") != 0
				|| rdoIMABCSClasificacionAF4101.isChecked()
				|| rdoIMABCSClasificacionBF4101.isChecked()
				|| rdoIMABCMClasificacionCF4101.isChecked()
				|| rdoIMABCSSinClasificacionF4101.isChecked()
				|| rdoIMABCMClasificacionAF4101.isChecked()
				|| rdoIMABCMClasificacionBF4101.isChecked()
				|| rdoIMABCMClasificacionCF4101.isChecked()
				|| rdoIMABCMSinClasificacionF4101.isChecked()
				|| rdoIMABCIClasificacionAF4101.isChecked()
				|| rdoIMABCIClasificacionBF4101.isChecked()
				|| rdoIMABCIClasificacionCF4101.isChecked()
				|| rdoIMABCISinClasificacionF4101.isChecked()
				|| txtIMSLDF4101.getText().compareTo("") != 0
				|| txtIMU1DDF4101.getText().compareTo("") != 0
				|| txtIMBBDDF4101.getText().compareTo("") != 0
				|| txtIMU2DDF4101.getText().compareTo("") != 0
				|| txtIMSBDDF4101.getText().compareTo("") != 0
				|| txtIMU3DDF4101.getText().compareTo("") != 0
				|| txtIMLEDDF4101.getText().compareTo("") != 0
				|| txtIMPEFDF4101.getText().compareTo("") != 0
				|| txtIMU5DDF4101.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	protected boolean validar() {

		if (!camposLLenos()) {
			msj.mensajeAlerta(Mensaje.camposVacios);
			return false;
		} else
			return true;

	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
		botonera.getChildren().get(6).setVisible(bol);
	}

	@Listen("onClick = #gpxRegistroF4101")
	public void abrirRegistro() {
		gpxDatosF4101.setOpen(false);
		gpxRegistroF4101.setOpen(true);
		mostrarBotones(false);

	}

	@Listen("onOpen = #gpxDatosF4101")
	public void abrirCatalogo() {
		gpxDatosF4101.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF4101.setOpen(false);
								gpxRegistroF4101.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF4101.setOpen(true);
									gpxRegistroF4101.setOpen(false);
									limpiarCampos();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF4101.setOpen(true);
			gpxRegistroF4101.setOpen(false);
			mostrarBotones(true);
		}
	}

	public boolean validarSeleccion() {
		List<F4101> seleccionados = catalogo.obtenerSeleccionados();
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

	public void mostrarCatalogoF4101() {
		final List<F4101> listF4101 = servicioF4101.buscarTodosOrdenados();
		catalogo = new Catalogo<F4101>(catalogoF4101, "F4101", listF4101,
				false, true, true, "Número artículo", "Descripción",
				"Descripción 2", "Texto búsqueda", "Tipo línea", "Tipo alm",
				"Código vta 1") {

			@Override
			protected List<F4101> buscar(List<String> valores) {

				List<F4101> lista = new ArrayList<F4101>();

				for (F4101 f4101 : listF4101) {
					if (f4101.getImlitm().toLowerCase()
							.startsWith(valores.get(0))
							&& f4101.getImdsc1().toLowerCase()
									.startsWith(valores.get(1))
							&& f4101.getImdsc2().toLowerCase()
									.startsWith(valores.get(2))
							&& f4101.getImsrtx().toLowerCase()
									.startsWith(valores.get(3))
							&& f4101.getImlnty().toLowerCase()
									.startsWith(valores.get(4))
							&& f4101.getImstkt().toLowerCase()
									.startsWith(valores.get(5))
							&& f4101.getImsrp1().toLowerCase()
									.startsWith(valores.get(6))) {
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
		catalogo.setParent(catalogoF4101);
	}

	@Listen("onClick = #btnBuscarIMALKYF4101")
	public void mostrarCatalogoF0101() {
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoDirecciones = new Catalogo<F0101>(divCatalogoF0101, "F0101",
				listF0101, true, false, false, "Nº direccion",
				"Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal") {

			@Override
			protected List<F0101> buscar(List<String> valores) {

				List<F0101> lista = new ArrayList<F0101>();

				for (F0101 f01 : listF0101) {
					if (String.valueOf(f01.getAban8()).toLowerCase()
							.startsWith(valores.get(0))
							&& f01.getAbalph().toLowerCase()
									.startsWith(valores.get(1))
							&& f01.getAbalky().toLowerCase()
									.startsWith(valores.get(2))
							&& f01.getAbsic().toLowerCase()
									.startsWith(valores.get(4))
							&& f01.getAbat1().toLowerCase()
									.startsWith(valores.get(5))
							&& f01.getAbtax().toLowerCase()
									.startsWith(valores.get(6))) {
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
		catalogoDirecciones.setParent(divCatalogoF0101);
		catalogoDirecciones.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0101")
	public void seleccionCatalogoF0101() {
		F0101 f0101 = catalogoDirecciones.objetoSeleccionadoDelCatalogo();
		txtIMALKYF4101.setValue(String.valueOf(f0101.getAban8()));
		lblIMALKYF4101.setValue(f0101.getAbac02());
		catalogoDirecciones.setParent(null);
	}

}
