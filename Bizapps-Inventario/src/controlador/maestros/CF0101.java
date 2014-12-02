package controlador.maestros;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F00021;
import modelo.maestros.F0006;
import modelo.maestros.F0010;
import modelo.maestros.F0101;
import modelo.maestros.F0111;
import modelo.maestros.F0115;
import modelo.maestros.F01151;
import modelo.maestros.F0116;
import modelo.maestros.F4008;
import modelo.maestros.F49041;
import modelo.maestros.F4930;
import modelo.pk.F00021PK;
import modelo.pk.F0111PK;
import modelo.pk.F0116PK;
import modelo.transacciones.F4111;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.buscadores.BuscadorF0006;
import componentes.buscadores.BuscadorF0101;
import componentes.buscadores.BuscadorUDC;
import componentes.catalogos.CatalogoF0006;
import componentes.catalogos.CatalogoF0101;

public class CF0101 extends CGenerico {

	@Wire
	private Textbox txtAN8F0101;
	@Wire
	private Textbox txtALPHF0101;
	@Wire
	private Textbox txtALKYF0101;
	@Wire
	private Textbox txtTAXF0101;
	@Wire
	private Div divBuscadorAT1;
	BuscadorUDC buscadorAT1;
	@Wire
	private Div divBuscadorMCU;
	BuscadorF0006 buscadorMCU;
	@Wire
	private Div divBuscadorATP;
	BuscadorUDC buscadorATP;
	@Wire
	private Checkbox chxATRF0101;
	@Wire
	private Div divBuscadorMPGP;
	BuscadorUDC buscadorMPGP;
	@Wire
	private Checkbox chxATPRF0101;
	@Wire
	private Div divBuscadorAT2;
	BuscadorUDC buscadorAT2;
	@Wire
	private Checkbox chxSBLIF0101;
	@Wire
	private Textbox txtTX2F0101;
	@Wire
	private Checkbox chxATEF0101;
	@Wire
	private Textbox txtTXCTF0101;
	@Wire
	private Div divBuscadorTAXC;
	BuscadorUDC buscadorTAXC;
	@Wire
	private Div divBuscadorCM;
	BuscadorUDC buscadorCM;
	@Wire
	private Div divBuscadorLNGP;
	BuscadorUDC buscadorLNGP;
	@Wire
	private Div divBuscadorSIC;
	BuscadorUDC buscadorSIC;
	@Wire
	private Div divBuscadorCLASS01;
	BuscadorUDC buscadorCLASS01;
	@Wire
	private Div divBuscadorCLASS02;
	BuscadorUDC buscadorCLASS02;
	@Wire
	private Div divBuscadorCLASS03;
	BuscadorUDC buscadorCLASS03;
	@Wire
	private Div divBuscadorCLASS04;
	BuscadorUDC buscadorCLASS04;
	@Wire
	private Div divBuscadorCLASS05;
	BuscadorUDC buscadorCLASS05;

	BuscadorF0101 buscadorPrincipal;
	@Wire
	Div divBuscadorPrincipal;
	BuscadorF0101 buscadorDireccion1;
	@Wire
	Div divBuscadorDireccion1;
	BuscadorF0101 buscadorDireccion2;
	@Wire
	Div divBuscadorDireccion2;
	BuscadorF0101 buscadorDireccion3;
	@Wire
	Div divBuscadorDireccion3;
	BuscadorF0101 buscadorDireccion4;
	@Wire
	Div divBuscadorDireccion4;
	BuscadorF0101 buscadorDireccion5;
	@Wire
	Div divBuscadorDireccion5;
	BuscadorF0101 buscadorFactor;
	@Wire
	Div divBuscadorFactor;

	@Wire
	private Textbox txtYEARSTARF0101;
	@Wire
	private Div divBuscadorABREV;
	BuscadorUDC buscadorABREV;
	@Wire
	private Doublespinner dspGROWF0101;
	@Wire
	private Doublespinner dspNOE0101;
	@Wire
	private Textbox txtTICKERF0101;
	@Wire
	private Textbox txtEXCHF0101;
	@Wire
	private Textbox txtMlnmF0101;
	@Wire
	private Textbox txtADD1F0101;
	@Wire
	private Textbox txtCTY1F0101;
	@Wire
	private Textbox txtADD2F0101;
	@Wire
	private Div divBuscadorADDS;
	BuscadorUDC buscadorADDS;
	@Wire
	private Textbox txtADD3F0101;
	@Wire
	private Textbox txtADDZF0101;
	@Wire
	private Label lblCodigoPostal1F0101;
	@Wire
	private Textbox txtADD4F0101;
	@Wire
	private Div divBuscadorCTR;
	BuscadorUDC buscadorCTR;
	@Wire
	private Div divBuscadorCOUN;
	BuscadorUDC buscadorCOUN;
	@Wire
	private Div divBuscadorAC01;
	BuscadorUDC buscadorAC01;
	@Wire
	private Div divBuscadorAC02;
	BuscadorUDC buscadorAC02;
	@Wire
	private Div divBuscadorAC03;
	BuscadorUDC buscadorAC03;
	@Wire
	private Div divBuscadorAC04;
	BuscadorUDC buscadorAC04;
	@Wire
	private Div divBuscadorAC05;
	BuscadorUDC buscadorAC05;
	@Wire
	private Div divBuscadorAC06;
	BuscadorUDC buscadorAC06;
	@Wire
	private Div divBuscadorAC07;
	BuscadorUDC buscadorAC07;
	@Wire
	private Div divBuscadorAC08;
	BuscadorUDC buscadorAC08;
	@Wire
	private Div divBuscadorAC09;
	BuscadorUDC buscadorAC09;
	@Wire
	private Div divBuscadorAC10;
	BuscadorUDC buscadorAC10;
	@Wire
	private Div divBuscadorAC11;
	BuscadorUDC buscadorAC11;
	@Wire
	private Div divBuscadorAC12;
	BuscadorUDC buscadorAC12;
	@Wire
	private Div divBuscadorAC13;
	BuscadorUDC buscadorAC13;
	@Wire
	private Div divBuscadorAC14;
	BuscadorUDC buscadorAC14;
	@Wire
	private Div divBuscadorAC15;
	BuscadorUDC buscadorAC15;
	@Wire
	private Div divBuscadorAC16;
	BuscadorUDC buscadorAC16;
	@Wire
	private Div divBuscadorAC17;
	BuscadorUDC buscadorAC17;
	@Wire
	private Div divBuscadorAC18;
	BuscadorUDC buscadorAC18;
	@Wire
	private Div divBuscadorAC19;
	BuscadorUDC buscadorAC19;
	@Wire
	private Div divBuscadorAC20;
	BuscadorUDC buscadorAC20;
	@Wire
	private Div divBuscadorAC21;
	BuscadorUDC buscadorAC21;
	@Wire
	private Div divBuscadorAC22;
	BuscadorUDC buscadorAC22;
	@Wire
	private Div divBuscadorAC23;
	BuscadorUDC buscadorAC23;
	@Wire
	private Div divBuscadorAC24;
	BuscadorUDC buscadorAC24;
	@Wire
	private Div divBuscadorAC25;
	BuscadorUDC buscadorAC25;
	@Wire
	private Div divBuscadorAC26;
	BuscadorUDC buscadorAC26;
	@Wire
	private Div divBuscadorAC27;
	BuscadorUDC buscadorAC27;
	@Wire
	private Div divBuscadorAC28;
	BuscadorUDC buscadorAC28;
	@Wire
	private Div divBuscadorAC29;
	BuscadorUDC buscadorAC29;
	@Wire
	private Div divBuscadorAC30;
	BuscadorUDC buscadorAC30;
	@Wire
	private Textbox txtDUNS1F0101;
	@Wire
	private Textbox txtDUNS2F0101;
	@Wire
	private Textbox txtDUNS3F0101;
	@Wire
	private Div divVF0101;
	@Wire
	private Div botoneraF0101;
	@Wire
	private Div catalogoF0101;
	@Wire
	private Groupbox gpxDatosF0101;
	@Wire
	private Groupbox gpxRegistroF0101;
	@Wire
	private Div catalogoF0006F0101;
	@Wire
	private Div DivCatalogoF0101;

	Botonera botonera;
	CatalogoF0101 catalogo;
	CatalogoF0101 catalogoDivF0101;
	CatalogoF0006 catalogoF0006;
	double clave = 0;
	String idBoton = "";

	private static final long serialVersionUID = -423722886120387655L;

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
		// Ajustar a 3 el long
		cargarBuscadores();

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F0101 f01 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f01.getAban8();
						txtALPHF0101.setFocus(true);
						txtALKYF0101.setValue(f01.getAbalky());
						txtALPHF0101.setValue(f01.getAbalph());
						txtAN8F0101.setValue(String.valueOf(f01.getAban8()));
						String a = f01.getAbduns();
						a = a.trim();
						if (a.length() <= 3) {
							txtDUNS1F0101.setValue(f01.getAbduns().trim());
						} else {
							txtDUNS1F0101.setValue(f01.getAbduns().trim()
									.substring(0, 3));
							if (a.length() > 3 && a.length() <= 7) {
								txtDUNS2F0101.setValue(f01.getAbduns().trim()
										.substring(3, a.length()));
							} else {
								txtDUNS2F0101.setValue(f01.getAbduns().trim()
										.substring(3, 7));
								txtDUNS3F0101.setValue(f01.getAbduns().trim()
										.substring(7));
							}
						}
						if (!f01.getAbmcu().equals("")) {
							buscadorMCU.settearCampo(f01.getAbmcu());
						}
						txtTAXF0101.setValue(f01.getAbtax());
						txtTX2F0101.setValue(f01.getAbtx2());
						txtTXCTF0101.setValue(f01.getAbtxct());
						txtYEARSTARF0101.setValue(f01.getAbyearstar());
						dspGROWF0101.setValue(f01.getAbgrowthr());
						dspNOE0101.setValue(f01.getAbnoe());
						txtEXCHF0101.setValue(f01.getAbexchg());
						txtTICKERF0101.setValue(f01.getAbticker());
						Double doble = f01.getAban81();
						F0101 f0101 = new F0101();
						if (doble != null) {
							f0101 = servicioF0101.buscar(doble);
							if (f0101 != null) {
								buscadorDireccion1.settearModelo(f0101);
							}
						}
						Double doble1 = f01.getAban82();
						if (doble1 != null) {
							f0101 = servicioF0101.buscar(doble1);
							if (f0101 != null) {
								buscadorDireccion2.settearModelo(f0101);
							}
						}
						Double doble2 = f01.getAban83();
						if (doble2 != null) {
							f0101 = servicioF0101.buscar(doble2);
							if (f0101 != null) {
								buscadorDireccion3.settearModelo(f0101);
							}
						}
						Double doble3 = f01.getAban84();
						if (doble3 != null) {
							f0101 = servicioF0101.buscar(doble3);
							if (f0101 != null) {
								buscadorDireccion4.settearModelo(f0101);
							}
						}
						Double doble4 = f01.getAban85();
						if (doble4 != null) {
							f0101 = servicioF0101.buscar(doble4);
							if (f0101 != null) {
								buscadorDireccion5.settearModelo(f0101);
							}
						}
						Double doble5 = f01.getAban86();
						if (doble5 != null) {
							f0101 = servicioF0101.buscar(doble5);
							buscadorFactor.settearModelo(f0101);
						}
						F0111PK clave2 = new F0111PK();
						Long val2 = (long) 1;
						clave2.setWwan8(f01.getAban8());
						clave2.setWwidln(val2.doubleValue());
						F0111 f0111 = servicioF0111.buscar(clave2);
						if (f0111 != null)
							txtMlnmF0101.setValue(f0111.getWwmlnm());

						F0116PK clave = new F0116PK();
						long val = 1;
						clave.setAlan8(f01.getAban8());
						clave.setAleftb(val);
						F0116 f0116 = servicioF0116.buscar(clave);
						if (f0116 != null) {
							buscadorCTR.settearCampo(f0116.getAlctr());
							buscadorADDS.settearCampo(f0116.getAladds());
							buscadorCOUN.settearCampo(f0116.getAlcoun());
							txtADD1F0101.setValue(f0116.getAladd1());
							txtADD2F0101.setValue(f0116.getAladd2());
							txtADD3F0101.setValue(f0116.getAladd3());
							txtADD4F0101.setValue(f0116.getAladd4());
							txtCTY1F0101.setValue(f0116.getAlcty1());
						}

						buscadorAT1.settearCampo(f01.getAbat1());
						buscadorAT2.settearCampo(f01.getAbat2());
						buscadorATP.settearCampo(f01.getAbatp());
						buscadorCM.settearCampo(f01.getAbcm());
						buscadorLNGP.settearCampo(f01.getAblngp());
						buscadorMPGP.settearCampo(f01.getAbaempgp());
						buscadorSIC.settearCampo(f01.getAbsic());
						buscadorTAXC.settearCampo(f01.getAbtax());
						buscadorABREV.settearCampo(f01.getAbrevrng());
						buscadorCLASS01.settearCampo(f01.getAbclass01());
						buscadorCLASS02.settearCampo(f01.getAbclass02());
						buscadorCLASS03.settearCampo(f01.getAbclass03());
						buscadorCLASS05.settearCampo(f01.getAbclass05());
						buscadorCLASS04.settearCampo(f01.getAbclass04());
						buscadorAC01.settearCampo(f01.getAbac01());
						buscadorAC02.settearCampo(f01.getAbac02());
						buscadorAC03.settearCampo(f01.getAbac03());
						buscadorAC04.settearCampo(f01.getAbac04());
						buscadorAC05.settearCampo(f01.getAbac05());
						buscadorAC06.settearCampo(f01.getAbac06());
						buscadorAC07.settearCampo(f01.getAbac07());
						buscadorAC08.settearCampo(f01.getAbac08());
						buscadorAC09.settearCampo(f01.getAbac09());
						buscadorAC10.settearCampo(f01.getAbac10());
						buscadorAC11.settearCampo(f01.getAbac11());
						buscadorAC12.settearCampo(f01.getAbac12());
						buscadorAC13.settearCampo(f01.getAbac13());
						buscadorAC14.settearCampo(f01.getAbac14());
						buscadorAC15.settearCampo(f01.getAbac15());
						buscadorAC16.settearCampo(f01.getAbac16());
						buscadorAC17.settearCampo(f01.getAbac17());
						buscadorAC18.settearCampo(f01.getAbac18());
						buscadorAC19.settearCampo(f01.getAbac19());
						buscadorAC20.settearCampo(f01.getAbac20());
						buscadorAC21.settearCampo(f01.getAbac21());
						buscadorAC22.settearCampo(f01.getAbac22());
						buscadorAC23.settearCampo(f01.getAbac23());
						buscadorAC24.settearCampo(f01.getAbac24());
						buscadorAC25.settearCampo(f01.getAbac25());
						buscadorAC26.settearCampo(f01.getAbac26());
						buscadorAC27.settearCampo(f01.getAbac27());
						buscadorAC28.settearCampo(f01.getAbac28());
						buscadorAC29.settearCampo(f01.getAbac29());
						buscadorAC30.settearCampo(f01.getAbac30());
						if (f01.getAbate().equals("1"))
							chxATEF0101.setChecked(true);
						else
							chxATEF0101.setChecked(false);
						if (f01.getAbatpr().equals("1"))
							chxATPRF0101.setChecked(true);
						else
							chxATPRF0101.setChecked(false);
						if (f01.getAbatr().equals("1"))
							chxATRF0101.setChecked(true);
						else
							chxATRF0101.setChecked(false);
						if (f01.getAbsbli().equals("1"))
							chxSBLIF0101.setChecked(true);
						else
							chxSBLIF0101.setChecked(false);
					} else
						Mensaje.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0101, titulo, tabs);

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
				clave = 0;
			}

			@Override
			public void guardar() {
				boolean guardar = true;
				if (clave == 0)
					guardar = validar();
				if (guardar) {
					F0101 f01 = new F0101();
					double claveLong = 0;
					synchronized (this) {
						while (!nextNumber) {
							try {
								wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
						nextNumber = false;
						try {
							if (clave == claveLong) {
								double numero = servicioF00021
										.Numero("5", "JE");
								if (numero != 0) {
									clave = numero + 1;
									F00021 f021 = servicioF00021.buscar("5",
											"JE");
									f021.setNln001(clave);
									servicioF00021.guardar(f021);
								} else {
									clave = 1;
									F00021 f021 = new F00021();
									F00021PK clave21 = new F00021PK();
									clave21.setNldct("JE");
									clave21.setNlkco("5");
									clave21.setNlctry((double) 0);
									clave21.setNlfy((double) 0);
									f021.setId(clave21);
									f021.setNln001(clave);
									servicioF00021.guardar(f021);
								}
							}
						} catch (NullPointerException e) {
							nextNumber = true;
						}
					}
					synchronized (this) {
						nextNumber = true;
						notifyAll();
					}
					f01.setAban8(clave);
					f01.setAbalky(txtALKYF0101.getValue());
					f01.setAbalph(txtALPHF0101.getValue());
					f01.setAbduns(txtDUNS1F0101.getValue()
							+ txtDUNS2F0101.getValue()
							+ txtDUNS3F0101.getValue());
					f01.setAbmcu(buscadorMCU.obtenerCaja());
					f01.setAbtax(txtTAXF0101.getValue());
					f01.setAbtx2(txtTX2F0101.getValue());
					f01.setAbtxct(txtTXCTF0101.getValue());
					f01.setAbyearstar(txtYEARSTARF0101.getValue());
					f01.setAbgrowthr(dspGROWF0101.getValue());
					f01.setAbnoe(dspNOE0101.getValue());
					f01.setAbexchg(txtEXCHF0101.getValue());
					f01.setAbticker(txtTICKERF0101.getValue());
					f01.setAbat1(buscadorAT1.obtenerCaja());
					f01.setAbat2(buscadorAT2.obtenerCaja());
					f01.setAbatp(buscadorATP.obtenerCaja());
					f01.setAbcm(buscadorCM.obtenerCaja());
					f01.setAblngp(buscadorLNGP.obtenerCaja());
					f01.setAbaempgp(buscadorMPGP.obtenerCaja());
					f01.setAbsic(buscadorSIC.obtenerCaja());
					f01.setAbtax(buscadorTAXC.obtenerCaja());
					Long valor = buscadorDireccion1.obtenerCaja();
					if (valor != null)
						f01.setAban81(valor.doubleValue());
					Long valor2 = buscadorDireccion2.obtenerCaja();
					if (valor2 != null)
						f01.setAban82(valor2.doubleValue());
					Long valor3 = buscadorDireccion3.obtenerCaja();
					if (valor3 != null)
						f01.setAban83(valor3.doubleValue());
					Long valor4 = buscadorDireccion4.obtenerCaja();
					if (valor4 != null)
						f01.setAban84(valor4.doubleValue());
					Long valor5 = buscadorDireccion5.obtenerCaja();
					if (valor5 != null)
						f01.setAban85(valor5.doubleValue());
					Long valor6 = buscadorFactor.obtenerCaja();
					if (valor6 != null)
						f01.setAban86(valor6.doubleValue());
					f01.setAbrevrng(buscadorABREV.obtenerCaja());
					f01.setAbclass01(buscadorCLASS01.obtenerCaja());
					f01.setAbclass02(buscadorCLASS02.obtenerCaja());
					f01.setAbclass03(buscadorCLASS03.obtenerCaja());
					f01.setAbclass04(buscadorCLASS04.obtenerCaja());
					f01.setAbclass05(buscadorCLASS05.obtenerCaja());
					f01.setAbac01(buscadorAC01.obtenerCaja());
					f01.setAbac02(buscadorAC02.obtenerCaja());
					f01.setAbac03(buscadorAC03.obtenerCaja());
					f01.setAbac04(buscadorAC04.obtenerCaja());
					f01.setAbac05(buscadorAC05.obtenerCaja());
					f01.setAbac06(buscadorAC06.obtenerCaja());
					f01.setAbac07(buscadorAC07.obtenerCaja());
					f01.setAbac08(buscadorAC08.obtenerCaja());
					f01.setAbac09(buscadorAC09.obtenerCaja());
					f01.setAbac10(buscadorAC10.obtenerCaja());
					f01.setAbac11(buscadorAC11.obtenerCaja());
					f01.setAbac12(buscadorAC12.obtenerCaja());
					f01.setAbac13(buscadorAC13.obtenerCaja());
					f01.setAbac14(buscadorAC14.obtenerCaja());
					f01.setAbac15(buscadorAC15.obtenerCaja());
					f01.setAbac16(buscadorAC16.obtenerCaja());
					f01.setAbac17(buscadorAC17.obtenerCaja());
					f01.setAbac18(buscadorAC18.obtenerCaja());
					f01.setAbac19(buscadorAC19.obtenerCaja());
					f01.setAbac20(buscadorAC20.obtenerCaja());
					f01.setAbac21(buscadorAC21.obtenerCaja());
					f01.setAbac22(buscadorAC22.obtenerCaja());
					f01.setAbac23(buscadorAC23.obtenerCaja());
					f01.setAbac24(buscadorAC24.obtenerCaja());
					f01.setAbac25(buscadorAC25.obtenerCaja());
					f01.setAbac26(buscadorAC26.obtenerCaja());
					f01.setAbac27(buscadorAC27.obtenerCaja());
					f01.setAbac28(buscadorAC28.obtenerCaja());
					f01.setAbac29(buscadorAC29.obtenerCaja());
					f01.setAbac30(buscadorAC30.obtenerCaja());
					if (chxATEF0101.isChecked())
						f01.setAbate("1");
					else
						f01.setAbate("0");
					if (chxATPRF0101.isChecked())
						f01.setAbatpr("1");
					else
						f01.setAbatpr("0");
					if (chxATRF0101.isChecked())
						f01.setAbatr("1");
					else
						f01.setAbatr("0");
					if (chxSBLIF0101.isChecked())
						f01.setAbsbli("1");
					else
						f01.setAbsbli("0");
					servicioF0101.guardar(f01);

					F0111 f0111 = new F0111();
					F0111PK clave01 = new F0111PK();
					clave01.setWwan8(clave);
					clave01.setWwidln(1);
					f0111.setId(clave01);
					f0111.setWwmlnm(txtMlnmF0101.getValue());
					servicioF0111.guardar(f0111);

					F0116 f0116 = new F0116();
					F0116PK clave16 = new F0116PK();
					clave16.setAlan8(clave);
					clave16.setAleftb(1);
					f0116.setId(clave16);
					f0116.setAladd1(txtADD1F0101.getValue());
					f0116.setAladd2(txtADD2F0101.getValue());
					f0116.setAladd3(txtADD3F0101.getValue());
					f0116.setAladd4(txtADD4F0101.getValue());
					f0116.setAlcty1(txtCTY1F0101.getValue());
					f0116.setAlctr(buscadorCTR.obtenerCaja());
					f0116.setAlcoun(buscadorCOUN.obtenerCaja());
					f0116.setAladds(buscadorADDS.obtenerCaja());
					servicioF0116.guardar(f0116);

					Mensaje.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF0101
							.buscarTodosOrdenados());
				}
			}

			@Override
			public void eliminar() {

				if (gpxDatosF0101.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F0101> eliminarLista = catalogo
								.obtenerSeleccionados();
						final int cantidad = eliminarLista.size();
						for (int i = 0; i < eliminarLista.size(); i++) {
							F0101 valor = eliminarLista.get(i);
							List<F0006> objetoF0006 = servicioF0006
									.buscarPorMcan8(valor.getAban8());
							List<F0010> objetoF0010 = servicioF0010
									.buscarPorCcan8(valor.getAban8());
							// List<F0015> objetoF0015 = servicioF0015
							// .buscarCxan8(valor.getAban8());
							List<F0115> objetoF0115 = servicioF0115
									.buscarPorAn(valor.getAban8());
							List<F01151> objetoF01151 = servicioF01151
									.buscarPorAn(valor.getAban8());
							List<F0101> objetoF0101 = servicioF0101
									.buscarPorAns(valor.getAban8());
							List<F4111> objetoF4111 = servicioF4111
									.buscarPorAn(valor.getAban8());
							List<F4008> objetoF4008 = servicioF4008
									.buscarPorTata1(valor.getAban8());
							List<F4930> objetoF4930 = servicioF4930
									.buscarPorVmvown(valor.getAban8());
							List<F49041> objetoF49041 = servicioF49041
									.buscarPorVsstfn(valor.getAban8());
							if (!objetoF0006.isEmpty()
									|| !objetoF0010.isEmpty()
									// || !objetoF0015.isEmpty()
									|| !objetoF0115.isEmpty()
									|| !objetoF01151.isEmpty()
									|| !objetoF0101.isEmpty()
									|| !objetoF4111.isEmpty()
									|| !objetoF4008.isEmpty()
									|| !objetoF4930.isEmpty()
									|| !objetoF49041.isEmpty()) {
								eliminarLista.remove(valor);
								i--;
							}
						}
						if (!eliminarLista.isEmpty()) {
							Messagebox
									.show("¿Desea Eliminar los "
											+ eliminarLista.size()
											+ " Registros?",
											"Alerta",
											Messagebox.OK | Messagebox.CANCEL,
											Messagebox.QUESTION,
											new org.zkoss.zk.ui.event.EventListener<Event>() {
												public void onEvent(Event evt)
														throws InterruptedException {
													if (evt.getName().equals(
															"onOK")) {
														servicioF0101
																.eliminarVarios(eliminarLista);
														catalogo.actualizarLista(servicioF0101
																.buscarTodosOrdenados());
														if (cantidad != eliminarLista
																.size())
															Mensaje.mensajeInformacion(Mensaje.algunosEliminados);
														else
															Mensaje.mensajeInformacion(Mensaje.eliminado);
													}
												}
											});
						} else {
							Mensaje.mensajeAlerta(Mensaje.registroUtilizado);
						}
					}
				} else {
					/* Elimina un solo registro */
					if (clave != 0) {
						List<F0006> objetoF0006 = servicioF0006
								.buscarPorMcan8(clave);
						List<F0010> objetoF0010 = servicioF0010
								.buscarPorCcan8(clave);
						// List<F0015> objetoF0015 = servicioF0015
						// .buscarCxan8(clave);
						List<F0115> objetoF0115 = servicioF0115
								.buscarPorAn(clave);
						List<F01151> objetoF01151 = servicioF01151
								.buscarPorAn(clave);
						List<F0101> objetoF0101 = servicioF0101
								.buscarPorAns(clave);
						List<F4111> objetoF4111 = servicioF4111
								.buscarPorAn(clave);
						List<F4008> objetoF4008 = servicioF4008
								.buscarPorTata1(clave);
						List<F4930> objetoF4930 = servicioF4930
								.buscarPorVmvown(clave);
						List<F49041> objetoF49041 = servicioF49041
								.buscarPorVsstfn(clave);
						if (objetoF0006.isEmpty()
								&& objetoF0010.isEmpty()
								// && objetoF0015.isEmpty()
								&& objetoF0115.isEmpty()
								&& objetoF01151.isEmpty()
								&& objetoF0101.isEmpty()
								&& objetoF4111.isEmpty()
								&& objetoF4008.isEmpty()
								&& objetoF4930.isEmpty()
								&& objetoF49041.isEmpty()) {
							Messagebox
									.show(Mensaje.deseaEliminar,
											"Alerta",
											Messagebox.OK | Messagebox.CANCEL,
											Messagebox.QUESTION,
											new org.zkoss.zk.ui.event.EventListener<Event>() {
												public void onEvent(Event evt)
														throws InterruptedException {
													if (evt.getName().equals(
															"onOK")) {
														servicioF0101
																.eliminarUno(clave);
														Mensaje.mensajeInformacion(Mensaje.eliminado);
														limpiar();
														catalogo.actualizarLista(servicioF0101
																.buscarTodosOrdenados());
													}
												}
											});
						} else {
							Mensaje.mensajeAlerta(Mensaje.registroUtilizado);
						}
					} else
						Mensaje.mensajeAlerta(Mensaje.noSeleccionoRegistro);
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
		botoneraF0101.appendChild(botonera);
	}

	private void cargarBuscadores() {
		String ancho1P1 = "29%";
		String ancho2P1 = "23%";
		String ancho3P1 = "25%";
		String ancho4P1 = "23%";
		buscadorAT1 = crearCampoUDC(divBuscadorAT1, "Tipo busqueda", true,
				"01", "ST", ancho1P1, ancho2P1, ancho3P1, ancho4P1);
		buscadorMCU = new BuscadorF0006("UN:", false, "", "", "", 10,
				servicioF0006, ancho1P1, ancho2P1, ancho3P1, ancho4P1);
		divBuscadorMCU.appendChild(buscadorMCU);

		String ancho1P2 = "27%";
		String ancho2P2 = "23%";
		String ancho3P2 = "25%";
		String ancho4P2 = "25%";
		buscadorCTR = crearCampoUDC(divBuscadorCTR, "Pais", false, "00", "CN",
				ancho1P2, ancho2P2, ancho3P2, ancho4P2);
		buscadorCOUN = crearCampoUDC(divBuscadorCOUN, "Condado", false, "00",
				"CT", ancho1P2, ancho2P2, ancho3P2, ancho4P2);
		buscadorADDS = crearCampoUDC(divBuscadorADDS, "Estado", false, "00",
				"S", ancho1P2, ancho2P2, ancho3P2, ancho4P2);
		// Cd postal

		String ancho1P3 = "29%";
		String ancho2P3 = "23%";
		String ancho3P3 = "23%";
		String ancho4P3 = "25%";
		buscadorAT2 = crearCampoUDC(divBuscadorAT2, "Compen c/c y c/p", false,
				"H01", "AV", ancho1P3, ancho2P3, ancho3P3, ancho4P3);
		buscadorATP = crearCampoUDC(divBuscadorATP, "Cuentas por Pagar Y/N/M",
				false, "H01", "AS", ancho1P3, ancho2P3, ancho3P3, ancho4P3);
		buscadorCM = crearCampoUDC(divBuscadorCM, "Mensaje credito", false,
				"00", "CM", ancho1P3, ancho2P3, ancho3P3, ancho4P3);
		buscadorLNGP = crearCampoUDC(divBuscadorLNGP, "Mensaje credito", false,
				"01", "LP", ancho1P3, ancho2P3, ancho3P3, ancho4P3);
		buscadorMPGP = crearCampoUDC(divBuscadorMPGP,
				"Aprobaciones Grupo Empl", false, "43E", "AA", ancho1P3,
				ancho2P3, ancho3P3, ancho4P3);
		buscadorSIC = crearCampoUDC(divBuscadorSIC, "Clasificacion industrial",
				false, "01", "SC", ancho1P3, ancho2P3, ancho3P3, ancho4P3);
		buscadorTAXC = crearCampoUDC(divBuscadorTAXC, "Cd persona/compañia",
				false, "H00", "TA", ancho1P3, ancho2P3, ancho3P3, ancho4P3);

		String ancho1P4 = "25%";
		String ancho2P4 = "25%";
		String ancho3P4 = "25%";
		String ancho4P4 = "25%";
		buscadorCLASS01 = crearCampoUDC(divBuscadorCLASS01,
				"Cd Clasificacion 01", false, "01", "CA", ancho1P4, ancho2P4,
				ancho3P4, ancho4P4);
		buscadorCLASS02 = crearCampoUDC(divBuscadorCLASS02,
				"Cd Clasificacion 02", false, "01", "CB", ancho1P4, ancho2P4,
				ancho3P4, ancho4P4);
		buscadorCLASS03 = crearCampoUDC(divBuscadorCLASS03,
				"Cd Clasificacion 03", false, "01", "CC", ancho1P4, ancho2P4,
				ancho3P4, ancho4P4);
		buscadorCLASS04 = crearCampoUDC(divBuscadorCLASS04,
				"Cd Clasificacion 04", false, "01", "CD", ancho1P4, ancho2P4,
				ancho3P4, ancho4P4);
		buscadorCLASS05 = crearCampoUDC(divBuscadorCLASS05,
				"Cd Clasificacion 05", false, "01", "CE", ancho1P4, ancho2P4,
				ancho3P4, ancho4P4);
		buscadorABREV = crearCampoUDC(divBuscadorABREV, "Rango ingresos",
				false, "01", "RR", ancho1P4, ancho2P4, ancho3P4, ancho4P4);

		buscadorPrincipal = new BuscadorF0101("Nº Principal", false, "", "",
				"", 10, servicioF0101, ancho1P4, ancho2P4, ancho3P4, ancho4P4);
		divBuscadorPrincipal.appendChild(buscadorPrincipal);
		buscadorDireccion1 = new BuscadorF0101("1º Nº direccion", false, "",
				"", "", 10, servicioF0101, ancho1P4, ancho2P4, ancho3P4,
				ancho4P4);
		divBuscadorDireccion1.appendChild(buscadorDireccion1);
		buscadorDireccion2 = new BuscadorF0101("2º Nº direccion", false, "",
				"", "", 10, servicioF0101, ancho1P4, ancho2P4, ancho3P4,
				ancho4P4);
		divBuscadorDireccion2.appendChild(buscadorDireccion2);
		buscadorDireccion3 = new BuscadorF0101("3º Nº direccion", false, "",
				"", "", 10, servicioF0101, ancho1P4, ancho2P4, ancho3P4,
				ancho4P4);
		divBuscadorDireccion3.appendChild(buscadorDireccion3);
		buscadorDireccion4 = new BuscadorF0101("4º Nº direccion", false, "",
				"", "", 10, servicioF0101, ancho1P4, ancho2P4, ancho3P4,
				ancho4P4);
		divBuscadorDireccion4.appendChild(buscadorDireccion4);
		buscadorDireccion5 = new BuscadorF0101("5º Nº direccion", false, "",
				"", "", 10, servicioF0101, ancho1P4, ancho2P4, ancho3P4,
				ancho4P4);
		divBuscadorDireccion5.appendChild(buscadorDireccion5);
		buscadorFactor = new BuscadorF0101("Factor/Beneficiario especial",
				false, "", "", "", 10, servicioF0101, ancho1P4, ancho2P4,
				ancho3P4, ancho4P4);
		divBuscadorFactor.appendChild(buscadorFactor);

		String ancho1P5 = "25%";
		String ancho2P5 = "25%";
		String ancho3P5 = "25%";
		String ancho4P5 = "25%";
		buscadorAC01 = crearCampoUDC(divBuscadorAC01, "Cd Categoria 01", false,
				"01", "01", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC02 = crearCampoUDC(divBuscadorAC02, "Cd Categoria 02", false,
				"01", "02", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC03 = crearCampoUDC(divBuscadorAC03, "Cd Categoria 03", false,
				"01", "03", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC04 = crearCampoUDC(divBuscadorAC04, "Cd Categoria 04", false,
				"01", "04", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC05 = crearCampoUDC(divBuscadorAC05, "Cd Categoria 05", false,
				"01", "05", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC06 = crearCampoUDC(divBuscadorAC06, "Cd Categoria 06", false,
				"01", "06", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC07 = crearCampoUDC(divBuscadorAC07, "Cd Categoria 07", false,
				"01", "07", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC08 = crearCampoUDC(divBuscadorAC08, "Cd Categoria 08", false,
				"01", "08", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC09 = crearCampoUDC(divBuscadorAC09, "Cd Categoria 09", false,
				"01", "09", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC10 = crearCampoUDC(divBuscadorAC10, "Cd Categoria 10", false,
				"01", "10", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC11 = crearCampoUDC(divBuscadorAC11, "Cd Categoria 11", false,
				"01", "11", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC12 = crearCampoUDC(divBuscadorAC12, "Cd Categoria 12", false,
				"01", "12", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC13 = crearCampoUDC(divBuscadorAC13, "Cd Categoria 13", false,
				"01", "13", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC14 = crearCampoUDC(divBuscadorAC14, "Cd Categoria 14", false,
				"01", "14", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC15 = crearCampoUDC(divBuscadorAC15, "Cd Categoria 15", false,
				"01", "15", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC16 = crearCampoUDC(divBuscadorAC16, "Cd Categoria 16", false,
				"01", "16", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC17 = crearCampoUDC(divBuscadorAC17, "Cd Categoria 17", false,
				"01", "17", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC18 = crearCampoUDC(divBuscadorAC18, "Cd Categoria 18", false,
				"01", "18", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC19 = crearCampoUDC(divBuscadorAC19, "Cd Categoria 19", false,
				"01", "19", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC20 = crearCampoUDC(divBuscadorAC20, "Cd Categoria 20", false,
				"01", "20", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC21 = crearCampoUDC(divBuscadorAC21, "Cd Categoria 21", false,
				"01", "21", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC22 = crearCampoUDC(divBuscadorAC22, "Cd Categoria 22", false,
				"01", "22", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC23 = crearCampoUDC(divBuscadorAC23, "Cd Categoria 23", false,
				"01", "23", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC24 = crearCampoUDC(divBuscadorAC24, "Cd Categoria 24", false,
				"01", "24", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC25 = crearCampoUDC(divBuscadorAC25, "Cd Categoria 25", false,
				"01", "25", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC26 = crearCampoUDC(divBuscadorAC26, "Cd Categoria 26", false,
				"01", "26", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC27 = crearCampoUDC(divBuscadorAC27, "Cd Categoria 27", false,
				"01", "27", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC28 = crearCampoUDC(divBuscadorAC28, "Cd Categoria 28", false,
				"01", "28", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC29 = crearCampoUDC(divBuscadorAC29, "Cd Categoria 29", false,
				"01", "29", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
		buscadorAC30 = crearCampoUDC(divBuscadorAC30, "Cd Categoria 30", false,
				"01", "30", ancho1P5, ancho2P5, ancho3P5, ancho4P5);
	}

	protected boolean validar() {
		if (!camposLLenos()) {
			Mensaje.mensajeError(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	private boolean camposLLenos() {
		if (txtALPHF0101.getText().compareTo("") == 0
				|| buscadorAT1.obtenerCaja().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	protected void limpiarCampos() {
		idBoton = "";
		clave = 0;
		txtALPHF0101.setFocus(true);
		txtALKYF0101.setValue("");
		txtALPHF0101.setValue("");
		txtAN8F0101.setValue("");
		txtDUNS1F0101.setValue("");
		txtDUNS2F0101.setValue("");
		txtDUNS3F0101.setValue("");
		buscadorMCU.limpiarCampo();
		;
		txtTAXF0101.setValue("");
		txtTX2F0101.setValue("");
		txtTXCTF0101.setValue("");
		txtYEARSTARF0101.setValue("");
		dspGROWF0101.setValue(0.0);
		dspNOE0101.setValue(0.0);
		txtEXCHF0101.setValue("");
		txtTICKERF0101.setValue("");
		buscadorPrincipal.limpiarCampo();
		buscadorDireccion1.limpiarCampo();
		buscadorDireccion2.limpiarCampo();
		buscadorDireccion3.limpiarCampo();
		buscadorDireccion4.limpiarCampo();
		buscadorDireccion5.limpiarCampo();
		buscadorFactor.limpiarCampo();
		chxATEF0101.setChecked(false);
		chxATPRF0101.setChecked(false);
		chxATRF0101.setChecked(false);
		chxSBLIF0101.setChecked(false);
		txtMlnmF0101.setValue("");
		txtADD1F0101.setValue("");
		txtADD2F0101.setValue("");
		txtADD3F0101.setValue("");
		txtADD4F0101.setValue("");
		txtCTY1F0101.setValue("");
		buscadorCTR.settearCampo(null);
		buscadorADDS.settearCampo(null);
		buscadorCOUN.settearCampo(null);
		buscadorAT1.settearCampo(null);
		buscadorAT2.settearCampo(null);
		buscadorATP.settearCampo(null);
		buscadorCM.settearCampo(null);
		buscadorLNGP.settearCampo(null);
		buscadorMPGP.settearCampo(null);
		buscadorSIC.settearCampo(null);
		buscadorTAXC.settearCampo(null);
		buscadorABREV.settearCampo(null);
		buscadorCLASS01.settearCampo(null);
		buscadorCLASS02.settearCampo(null);
		buscadorCLASS03.settearCampo(null);
		buscadorCLASS05.settearCampo(null);
		buscadorCLASS04.settearCampo(null);
		buscadorAC01.settearCampo(null);
		buscadorAC02.settearCampo(null);
		buscadorAC03.settearCampo(null);
		buscadorAC04.settearCampo(null);
		buscadorAC05.settearCampo(null);
		buscadorAC06.settearCampo(null);
		buscadorAC07.settearCampo(null);
		buscadorAC08.settearCampo(null);
		buscadorAC09.settearCampo(null);
		buscadorAC10.settearCampo(null);
		buscadorAC11.settearCampo(null);
		buscadorAC12.settearCampo(null);
		buscadorAC13.settearCampo(null);
		buscadorAC14.settearCampo(null);
		buscadorAC15.settearCampo(null);
		buscadorAC16.settearCampo(null);
		buscadorAC17.settearCampo(null);
		buscadorAC18.settearCampo(null);
		buscadorAC19.settearCampo(null);
		buscadorAC20.settearCampo(null);
		buscadorAC21.settearCampo(null);
		buscadorAC22.settearCampo(null);
		buscadorAC23.settearCampo(null);
		buscadorAC24.settearCampo(null);
		buscadorAC25.settearCampo(null);
		buscadorAC26.settearCampo(null);
		buscadorAC27.settearCampo(null);
		buscadorAC28.settearCampo(null);
		buscadorAC29.settearCampo(null);
		buscadorAC30.settearCampo(null);
	}

	@Listen("onClick = #gpxRegistroF0101")
	public void abrirRegistro() {
		gpxDatosF0101.setOpen(false);
		gpxRegistroF0101.setOpen(true);
		mostrarBotones(false);
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

	protected boolean validarSeleccion() {
		List<F0101> seleccionados = catalogo.obtenerSeleccionados();
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

	@Listen("onOpen = #gpxDatosF0101")
	public void abrirCatalogo() {
		gpxDatosF0101.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF0101.setOpen(false);
								gpxRegistroF0101.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatosF0101.setOpen(true);
									gpxRegistroF0101.setOpen(false);
									limpiarCampos();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatosF0101.setOpen(true);
			gpxRegistroF0101.setOpen(false);
			mostrarBotones(true);
		}
	}

	private boolean camposEditando() {
		if (txtAN8F0101.getText().compareTo("") != 0
				|| txtALPHF0101.getText().compareTo("") != 0
				|| txtALKYF0101.getText().compareTo("") != 0
				|| txtTAXF0101.getText().compareTo("") != 0
				|| buscadorMCU.getCajaTexto().getText().compareTo("") != 0
				|| txtMlnmF0101.getText().compareTo("") != 0
				|| txtADD1F0101.getText().compareTo("") != 0
				|| txtCTY1F0101.getText().compareTo("") != 0
				|| txtADD2F0101.getText().compareTo("") != 0
				|| txtADD3F0101.getText().compareTo("") != 0
				|| txtADDZF0101.getText().compareTo("") != 0
				|| txtADD4F0101.getText().compareTo("") != 0
				|| txtTX2F0101.getText().compareTo("") != 0
				|| txtTXCTF0101.getText().compareTo("") != 0
				|| txtYEARSTARF0101.getText().compareTo("") != 0
				|| txtDUNS1F0101.getText().compareTo("") != 0
				|| txtDUNS2F0101.getText().compareTo("") != 0
				|| txtDUNS3F0101.getText().compareTo("") != 0
				|| txtTICKERF0101.getText().compareTo("") != 0
				|| txtEXCHF0101.getText().compareTo("") != 0
				|| buscadorPrincipal.getCajaTexto().getText().compareTo("") != 0
				|| buscadorDireccion1.getCajaTexto().getText().compareTo("") != 0
				|| buscadorDireccion2.getCajaTexto().getText().compareTo("") != 0
				|| buscadorDireccion3.getCajaTexto().getText().compareTo("") != 0
				|| buscadorDireccion4.getCajaTexto().getText().compareTo("") != 0
				|| buscadorDireccion5.getCajaTexto().getText().compareTo("") != 0
				|| buscadorFactor.getCajaTexto().getText().compareTo("") != 0
				|| buscadorAT1.obtenerCaja().compareTo("") != 0
				|| buscadorATP.obtenerCaja().compareTo("") != 0
				|| buscadorMPGP.obtenerCaja().compareTo("") != 0
				|| buscadorAT2.obtenerCaja().compareTo("") != 0
				|| buscadorTAXC.obtenerCaja().compareTo("") != 0
				|| buscadorCM.obtenerCaja().compareTo("") != 0
				|| buscadorLNGP.obtenerCaja().compareTo("") != 0
				|| buscadorSIC.obtenerCaja().compareTo("") != 0
				|| buscadorCLASS01.obtenerCaja().compareTo("") != 0
				|| buscadorCLASS02.obtenerCaja().compareTo("") != 0
				|| buscadorCLASS03.obtenerCaja().compareTo("") != 0
				|| buscadorCLASS04.obtenerCaja().compareTo("") != 0
				|| buscadorCLASS05.obtenerCaja().compareTo("") != 0
				|| buscadorCLASS03.obtenerCaja().compareTo("") != 0
				|| buscadorABREV.obtenerCaja().compareTo("") != 0
				|| buscadorADDS.obtenerCaja().compareTo("") != 0
				|| buscadorCTR.obtenerCaja().compareTo("") != 0
				|| buscadorCOUN.obtenerCaja().compareTo("") != 0
				|| buscadorAC01.obtenerCaja().compareTo("") != 0
				|| buscadorAC02.obtenerCaja().compareTo("") != 0
				|| buscadorAC03.obtenerCaja().compareTo("") != 0
				|| buscadorAC04.obtenerCaja().compareTo("") != 0
				|| buscadorAC05.obtenerCaja().compareTo("") != 0
				|| buscadorAC06.obtenerCaja().compareTo("") != 0
				|| buscadorAC07.obtenerCaja().compareTo("") != 0
				|| buscadorAC08.obtenerCaja().compareTo("") != 0
				|| buscadorAC09.obtenerCaja().compareTo("") != 0
				|| buscadorAC10.obtenerCaja().compareTo("") != 0
				|| buscadorAC11.obtenerCaja().compareTo("") != 0
				|| buscadorAC12.obtenerCaja().compareTo("") != 0
				|| buscadorAC13.obtenerCaja().compareTo("") != 0
				|| buscadorAC14.obtenerCaja().compareTo("") != 0
				|| buscadorAC15.obtenerCaja().compareTo("") != 0
				|| buscadorAC16.obtenerCaja().compareTo("") != 0
				|| buscadorAC17.obtenerCaja().compareTo("") != 0
				|| buscadorAC18.obtenerCaja().compareTo("") != 0
				|| buscadorAC19.obtenerCaja().compareTo("") != 0
				|| buscadorAC20.obtenerCaja().compareTo("") != 0
				|| buscadorAC21.obtenerCaja().compareTo("") != 0
				|| buscadorAC22.obtenerCaja().compareTo("") != 0
				|| buscadorAC23.obtenerCaja().compareTo("") != 0
				|| buscadorAC24.obtenerCaja().compareTo("") != 0
				|| buscadorAC25.obtenerCaja().compareTo("") != 0
				|| buscadorAC26.obtenerCaja().compareTo("") != 0
				|| buscadorAC27.obtenerCaja().compareTo("") != 0
				|| buscadorAC28.obtenerCaja().compareTo("") != 0
				|| buscadorAC29.obtenerCaja().compareTo("") != 0
				|| buscadorAC30.obtenerCaja().compareTo("") != 0)
			return true;
		return false;
	}

	public void mostrarCatalogo() {
		List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogo = new CatalogoF0101(catalogoF0101, "F0013", listF0101, false,
				"Nº direccion", "Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal");
		catalogo.setParent(catalogoF0101);
	}

}
