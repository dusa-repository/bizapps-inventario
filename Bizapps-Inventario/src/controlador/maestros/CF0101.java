package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import modelo.maestros.F0004;
import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F0013;
import modelo.maestros.F0101;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

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
	private Textbox txtMCUF0101;
	@Wire
	private Button btnBuscarUnidades;
	@Wire
	private Label lblMCUF0101;
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
	private Button btnBuscarDireccion0;
	@Wire
	private Label lblDireccion0F0101;
	@Wire
	private Longbox txtAN81F0101;
	@Wire
	private Button btnBuscarDireccion1;
	@Wire
	private Label lblDireccion1F0101;
	@Wire
	private Longbox txtAN82F0101;
	@Wire
	private Button btnBuscarDireccion2;
	@Wire
	private Label lblDireccion2F0101;
	@Wire
	private Longbox txtAN83F0101;
	@Wire
	private Button btnBuscarDireccion3;
	@Wire
	private Label lblDireccion3F0101;
	@Wire
	private Longbox txtAN84F0101;
	@Wire
	private Button btnBuscarDireccion4;
	@Wire
	private Label lblDireccion4F0101;
	@Wire
	private Longbox txtAN85F0101;
	@Wire
	private Button btnBuscarDireccion5;
	@Wire
	private Label lblDireccion5F0101;
	@Wire
	private Longbox txtFactorF0101;
	@Wire
	private Button btnBuscarFactor;
	@Wire
	private Label lblFactorF0101;
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
	Catalogo<F0101> catalogo;
	Catalogo<F0101> catalogoDivF0101;
	Catalogo<F0006> catalogoF0006;
	double clave = 0;
	String idBoton = "";

	private static final long serialVersionUID = -423722886120387655L;

	@Override
	public void inicializar() throws IOException {

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
							txtMCUF0101.setValue(f01.getAbmcu());
							System.out.println(servicioF0006.buscar(f01
									.getAbmcu()));
							lblMCUF0101.setValue(servicioF0006.buscar(
									f01.getAbmcu()).getMcdl01());
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
						if (doble != null) {
							lblDireccion1F0101.setValue(servicioF0101.buscar(
									doble).getAbalph());
							txtAN81F0101.setValue(doble.longValue());
						}
						Double doble1 = f01.getAban82();
						if (doble1 != null) {
							lblDireccion2F0101.setValue(servicioF0101.buscar(
									doble1).getAbalph());
							txtAN82F0101.setValue(doble1.longValue());
						}
						Double doble2 = f01.getAban83();
						if (doble2 != null) {
							lblDireccion3F0101.setValue(servicioF0101.buscar(
									doble2).getAbalph());
							txtAN83F0101.setValue(doble2.longValue());
						}
						Double doble3 = f01.getAban84();
						if (doble3 != null) {
							lblDireccion4F0101.setValue(servicioF0101.buscar(
									doble3).getAbalph());
							txtAN84F0101.setValue(doble3.longValue());
						}
						Double doble4 = f01.getAban85();
						if (doble4 != null) {
							lblDireccion5F0101.setValue(servicioF0101.buscar(
									doble4).getAbalph());
							txtAN85F0101.setValue(doble4.longValue());
						}
						Double doble5 = f01.getAban86();
						if (doble5 != null) {
							lblFactorF0101.setValue(servicioF0101
									.buscar(doble5).getAbalph());
							txtFactorF0101.setValue(doble5.longValue());
						}
						// FALTA ESTE
						buscadorAT1.settearCampo(servicioF0005.buscar("00",
								"00", f01.getAbat1()));
						buscadorAT2.settearCampo(servicioF0005.buscar("H01",
								"AV", f01.getAbat2()));
						buscadorATP.settearCampo(servicioF0005.buscar("H01",
								"AS", f01.getAbatp()));
						buscadorCM.settearCampo(servicioF0005.buscar("00",
								"CM", f01.getAbcm()));
						buscadorLNGP.settearCampo(servicioF0005.buscar("01",
								"LP", f01.getAblngp()));
						buscadorMPGP.settearCampo(servicioF0005.buscar("43E",
								"AA", f01.getAbaempgp()));
						buscadorSIC.settearCampo(servicioF0005.buscar("01",
								"SC", f01.getAbsic()));
						buscadorTAXC.settearCampo(servicioF0005.buscar("H00",
								"TA", f01.getAbtax()));
						buscadorABREV.settearCampo(servicioF0005.buscar("01",
								"RR", f01.getAbtax()));
						buscadorCLASS01.settearCampo(servicioF0005.buscar("01",
								"CA", f01.getAbtax()));
						buscadorCLASS02.settearCampo(servicioF0005.buscar("01",
								"CB", f01.getAbtax()));
						buscadorCLASS03.settearCampo(servicioF0005.buscar("01",
								"CC", f01.getAbtax()));
						buscadorCLASS05.settearCampo(servicioF0005.buscar("01",
								"CE", f01.getAbtax()));
						buscadorCLASS04.settearCampo(servicioF0005.buscar("01",
								"CD", f01.getAbtax()));
						buscadorAC01.settearCampo(servicioF0005.buscar("01",
								"01", f01.getAbac01()));
						buscadorAC02.settearCampo(servicioF0005.buscar("01",
								"02", f01.getAbac02()));
						buscadorAC03.settearCampo(servicioF0005.buscar("01",
								"03", f01.getAbac03()));
						buscadorAC04.settearCampo(servicioF0005.buscar("01",
								"04", f01.getAbac04()));
						buscadorAC05.settearCampo(servicioF0005.buscar("01",
								"05", f01.getAbac05()));
						buscadorAC06.settearCampo(servicioF0005.buscar("01",
								"06", f01.getAbac06()));
						buscadorAC07.settearCampo(servicioF0005.buscar("01",
								"07", f01.getAbac07()));
						buscadorAC08.settearCampo(servicioF0005.buscar("01",
								"08", f01.getAbac08()));
						buscadorAC09.settearCampo(servicioF0005.buscar("01",
								"09", f01.getAbac09()));
						buscadorAC10.settearCampo(servicioF0005.buscar("01",
								"10", f01.getAbac10()));
						buscadorAC11.settearCampo(servicioF0005.buscar("01",
								"11", f01.getAbac11()));
						buscadorAC12.settearCampo(servicioF0005.buscar("01",
								"12", f01.getAbac12()));
						buscadorAC13.settearCampo(servicioF0005.buscar("01",
								"13", f01.getAbac13()));
						buscadorAC14.settearCampo(servicioF0005.buscar("01",
								"14", f01.getAbac14()));
						buscadorAC15.settearCampo(servicioF0005.buscar("01",
								"15", f01.getAbac15()));
						buscadorAC16.settearCampo(servicioF0005.buscar("01",
								"16", f01.getAbac16()));
						buscadorAC17.settearCampo(servicioF0005.buscar("01",
								"17", f01.getAbac17()));
						buscadorAC18.settearCampo(servicioF0005.buscar("01",
								"18", f01.getAbac18()));
						buscadorAC19.settearCampo(servicioF0005.buscar("01",
								"19", f01.getAbac19()));
						buscadorAC20.settearCampo(servicioF0005.buscar("01",
								"20", f01.getAbac20()));
						buscadorAC21.settearCampo(servicioF0005.buscar("01",
								"21", f01.getAbac21()));
						buscadorAC22.settearCampo(servicioF0005.buscar("01",
								"22", f01.getAbac22()));
						buscadorAC23.settearCampo(servicioF0005.buscar("01",
								"23", f01.getAbac23()));
						buscadorAC24.settearCampo(servicioF0005.buscar("01",
								"24", f01.getAbac24()));
						buscadorAC25.settearCampo(servicioF0005.buscar("01",
								"25", f01.getAbac25()));
						buscadorAC26.settearCampo(servicioF0005.buscar("01",
								"26", f01.getAbac26()));
						buscadorAC27.settearCampo(servicioF0005.buscar("01",
								"27", f01.getAbac27()));
						buscadorAC28.settearCampo(servicioF0005.buscar("01",
								"28", f01.getAbac28()));
						buscadorAC29.settearCampo(servicioF0005.buscar("01",
								"29", f01.getAbac29()));
						buscadorAC30.settearCampo(servicioF0005.buscar("01",
								"30", f01.getAbac30()));
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
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0101, "Trabajo con Direcciones");

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
					if (clave != 0) {
						double numero = servicioF00021.Numero("5", "JE");
						if (numero != 0)
							clave = numero + 1;
						else
							clave = 1;
					}
					f01.setAban8(clave);
					f01.setAbalky(txtALKYF0101.getValue());
					f01.setAbalph(txtALPHF0101.getValue());
					f01.setAbduns(txtDUNS1F0101.getValue()
							+ txtDUNS2F0101.getValue()
							+ txtDUNS3F0101.getValue());
					f01.setAbmcu(txtMCUF0101.getValue());
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
					Long valor = txtAN81F0101.getValue();
					if (valor != null)
						f01.setAban81(valor.doubleValue());
					Long valor2 = txtAN82F0101.getValue();
					if (valor2 != null)
						f01.setAban82(valor2.doubleValue());
					Long valor3 = txtAN83F0101.getValue();
					if (valor3 != null)
						f01.setAban83(valor3.doubleValue());
					Long valor4 = txtAN84F0101.getValue();
					if (valor4 != null)
						f01.setAban84(valor4.doubleValue());
					Long valor5 = txtAN85F0101.getValue();
					if (valor5 != null)
						f01.setAban85(valor5.doubleValue());
					Long valor6 = txtFactorF0101.getValue();
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
					msj.mensajeInformacion(Mensaje.guardado);
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
													servicioF0101
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF0101
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
													servicioF0101
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF0101
															.buscarTodosOrdenados());
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
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF0101.appendChild(botonera);
	}

	protected boolean validar() {
		if (!camposLLenos()) {
			msj.mensajeAlerta(Mensaje.camposVacios);
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
		txtMCUF0101.setValue("");
		txtTAXF0101.setValue("");
		txtTX2F0101.setValue("");
		txtTXCTF0101.setValue("");
		txtYEARSTARF0101.setValue("");
		dspGROWF0101.setValue(0.0);
		dspNOE0101.setValue(0.0);
		txtEXCHF0101.setValue("");
		txtTICKERF0101.setValue("");
		txtAN81F0101.setValue((long) 0);
		txtAN82F0101.setValue((long) 0);
		txtAN83F0101.setValue((long) 0);
		txtAN84F0101.setValue((long) 0);
		txtAN85F0101.setValue((long) 0);
		txtFactorF0101.setValue((long) 0);
		lblDireccion0F0101.setValue("");
		lblDireccion1F0101.setValue("");
		lblDireccion2F0101.setValue("");
		lblDireccion3F0101.setValue("");
		lblDireccion4F0101.setValue("");
		lblDireccion5F0101.setValue("");
		lblDireccion5F0101.setValue("");
		lblFactorF0101.setValue("");
		lblMCUF0101.setValue("");
		chxATEF0101.setChecked(false);
		chxATPRF0101.setChecked(false);
		chxATRF0101.setChecked(false);
		chxSBLIF0101.setChecked(false);
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
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(bol);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	protected boolean validarSeleccion() {
		List<F0101> seleccionados = catalogo.obtenerSeleccionados();
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
		// TODO Auto-generated method stub
		return false;
	}

	public void mostrarCatalogo() {
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogo = new Catalogo<F0101>(catalogoF0101, "F0013", listF0101,
				false, false, false, "Nº direccion", "Nombre alfabetico",
				"Direccion larga", "Clasificacion industria", "Tipo bus",
				"ID fiscal") {

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
		catalogo.setParent(catalogoF0101);
	}

	@Listen("onClick = #btnBuscarDireccion0,#btnBuscarDireccion1,#btnBuscarDireccion2,#btnBuscarDireccion3,#btnBuscarDireccion4,#btnBuscarDireccion5,#btnBuscarFactor")
	public void mostrarCatalogoDireccion(Event evento) {
		Button boton = (Button) evento.getTarget();
		idBoton = boton.getId();
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoDivF0101 = new Catalogo<F0101>(DivCatalogoF0101,
				"CatalogoF0013", listF0101, true, false, false, "Nº direccion",
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
		catalogoDivF0101.setParent(DivCatalogoF0101);
		catalogoDivF0101.doModal();
	}

	@Listen("onSeleccion = #DivCatalogoF0101")
	public void seleccionarCatalogo() {
		F0101 f0101 = catalogoDivF0101.objetoSeleccionadoDelCatalogo();
		switch (idBoton) {
		case "btnBuscarDireccion0":
			// setearValores(f0101, txtAN81F0101, lblDireccion0F0101);
			System.out.println("HOLAAa");
			break;
		case "btnBuscarDireccion1":
			setearValores(f0101, txtAN81F0101, lblDireccion1F0101);
			break;
		case "btnBuscarDireccion2":
			setearValores(f0101, txtAN82F0101, lblDireccion2F0101);
			break;
		case "btnBuscarDireccion3":
			setearValores(f0101, txtAN83F0101, lblDireccion3F0101);
			break;
		case "btnBuscarDireccion4":
			setearValores(f0101, txtAN84F0101, lblDireccion4F0101);
			break;
		case "btnBuscarDireccion5":
			setearValores(f0101, txtAN85F0101, lblDireccion5F0101);
			break;
		case "btnBuscarFactor":
			setearValores(f0101, txtFactorF0101, lblFactorF0101);
			break;
		default:
			break;
		}
		catalogoDivF0101.setParent(null);
	}

	public void setearValores(F0101 f0101, Longbox txt, Label label) {
		Double doble = f0101.getAban8();
		txt.setValue(doble.longValue());
		label.setValue(f0101.getAbalph());
	}

	@Listen("onChange = #txtAN81F0101, #txtAN82F0101, #txtAN83F0101, #txtAN84F0101, #txtAN85F0101, #txtFactorF0101")
	public void buscarNombre(Event evento) {
		F0101 f0101 = servicioF0101.buscar(txtAN81F0101.getValue());
		if (f0101 != null) {
			Longbox txt = (Longbox) evento.getTarget();
			switch (txt.getId()) {
			case "btnBuscarDireccion0":
				// setearValores(f0101, txtAN81F0101, lblDireccion0F0101);
				System.out.println("HOLAAa");
				break;
			case "btnBuscarDireccion1":
				// setearValores(f0101, txtAN81F0101, lblDireccion1F0101);
				break;
			case "btnBuscarDireccion2":
				setearValores(f0101, txtAN82F0101, lblDireccion2F0101);
				break;
			case "btnBuscarDireccion3":
				setearValores(f0101, txtAN83F0101, lblDireccion3F0101);
				break;
			case "btnBuscarDireccion4":
				setearValores(f0101, txtAN84F0101, lblDireccion4F0101);
				break;
			case "btnBuscarDireccion5":
				setearValores(f0101, txtAN85F0101, lblDireccion5F0101);
				break;
			case "btnBuscarFactor":
				setearValores(f0101, txtFactorF0101, lblFactorF0101);
				break;
			default:
				break;
			}
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtAN81F0101.setValue((long) 0);
			txtAN81F0101.setFocus(true);
		}
	}

	@Listen("onClick = #btnBuscarUnidades")
	public void mostrarCatalogoF0004() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoF0006 = new Catalogo<F0006>(catalogoF0006F0101, "F0006",
				unidades, true, false, false, "Unidad Negocio", "Descripcion",
				"Nivel det", "Cta", "Tipo UN", "LM Auxiliar Inactivo",
				"Mto Cons", "CAT 01", "CAT 02", "CAT 03", "CAT 04", "CAT 05",
				"CAT 06") {

			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					if (unidad.getMcmcu().toLowerCase()
							.startsWith(valores.get(0))
							&& unidad.getMcdc().toLowerCase()
									.startsWith(valores.get(1))
							&& unidad.getMcldm().toLowerCase()
									.startsWith(valores.get(2))
							&& unidad.getMcco().toLowerCase()
									.startsWith(valores.get(3))
							&& unidad.getMcstyl().toLowerCase()
									.startsWith(valores.get(4))
							&& unidad.getMcfmod().toLowerCase()
									.startsWith(valores.get(5))
							&& unidad.getMcsbli().toLowerCase()
									.startsWith(valores.get(6))
							&& unidad.getMcrp01().toLowerCase()
									.startsWith(valores.get(7))
							&& unidad.getMcrp02().toLowerCase()
									.startsWith(valores.get(8))
							&& unidad.getMcrp03().toLowerCase()
									.startsWith(valores.get(9))
							&& unidad.getMcrp04().toLowerCase()
									.startsWith(valores.get(10))
							&& unidad.getMcrp05().toLowerCase()
									.startsWith(valores.get(11))
							&& unidad.getMcrp06().toLowerCase()
									.startsWith(valores.get(12))) {
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
		catalogoF0006.setParent(catalogoF0006F0101);
		catalogoF0006.doModal();
	}

	@Listen("onSeleccion = #catalogoF0006F0101")
	public void seleccion() {
		System.out.println("aqui");
		F0006 f0006 = catalogoF0006.objetoSeleccionadoDelCatalogo();
		txtMCUF0101.setValue(f0006.getMcmcu());
		lblMCUF0101.setValue(f0006.getMcdl01());
		catalogoF0006.setParent(null);
	}

	private void cargarBuscadores() {

		List<F0005> listF0005 = servicioF0005.buscarTodosOrdenados();
		buscadorAT1 = new BuscadorUDC("Tipo busqueda", 10, listF0005, true,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "00",
						buscadorAT1.obtenerCaja());
			}
		};
		divBuscadorAT1.appendChild(buscadorAT1);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("H01", "AV");
		buscadorAT2 = new BuscadorUDC("Compen c/c y c/p", 1, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H01", "AV",
						buscadorAT2.obtenerCaja());
			}
		};
		divBuscadorAT2.appendChild(buscadorAT2);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("H01", "AS");
		buscadorATP = new BuscadorUDC("Cuentas por Pagar Y/N/M", 1, listF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H01", "AS",
						buscadorATP.obtenerCaja());
			}
		};
		divBuscadorATP.appendChild(buscadorATP);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("00", "CM");
		buscadorCM = new BuscadorUDC("Mensaje credito", 2, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "CM",
						buscadorCM.obtenerCaja());
			}
		};
		divBuscadorCM.appendChild(buscadorCM);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "LP");
		buscadorLNGP = new BuscadorUDC("Idioma", 2, listF0005, false, false,
				false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "LP",
						buscadorLNGP.obtenerCaja());
			}
		};
		divBuscadorLNGP.appendChild(buscadorLNGP);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("43E", "AA");
		buscadorMPGP = new BuscadorUDC("Aprobaciones Grupo Empl", 5, listF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("43E", "AA",
						buscadorMPGP.obtenerCaja());
			}
		};
		divBuscadorMPGP.appendChild(buscadorMPGP);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "SC");
		buscadorSIC = new BuscadorUDC("Clasificacion industrial", 10,
				listF0005, false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "SC",
						buscadorSIC.obtenerCaja());
			}
		};
		divBuscadorSIC.appendChild(buscadorSIC);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("H00", "TA");
		buscadorTAXC = new BuscadorUDC("Cd persona/compañia", 1, listF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H00", "TA",
						buscadorTAXC.obtenerCaja());
			}
		};
		divBuscadorTAXC.appendChild(buscadorTAXC);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "CA");
		buscadorCLASS01 = new BuscadorUDC("Cd Clasificacion 01", 3, listF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "CA",
						buscadorCLASS01.obtenerCaja());
			}
		};
		divBuscadorCLASS01.appendChild(buscadorCLASS01);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "CB");
		buscadorCLASS02 = new BuscadorUDC("Cd Clasificacion 02", 3, listF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "CB",
						buscadorCLASS02.obtenerCaja());
			}
		};
		divBuscadorCLASS02.appendChild(buscadorCLASS02);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "CC");
		buscadorCLASS03 = new BuscadorUDC("Cd Clasificacion 03", 3, listF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "CC",
						buscadorCLASS03.obtenerCaja());
			}
		};
		divBuscadorCLASS03.appendChild(buscadorCLASS03);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "CD");
		buscadorCLASS04 = new BuscadorUDC("Cd Clasificacion 04", 3, listF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "CD",
						buscadorCLASS04.obtenerCaja());
			}
		};
		divBuscadorCLASS04.appendChild(buscadorCLASS04);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "CE");
		buscadorCLASS05 = new BuscadorUDC("Cd Clasificacion 05", 3, listF0005,
				false, false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "CE",
						buscadorCLASS05.obtenerCaja());
			}
		};
		divBuscadorCLASS05.appendChild(buscadorCLASS05);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "RR");
		buscadorABREV = new BuscadorUDC("Rango ingresos", 5, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "RR",
						buscadorABREV.obtenerCaja());
			}
		};
		divBuscadorABREV.appendChild(buscadorABREV);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "01");
		buscadorAC01 = new BuscadorUDC("Cd Categoria 1", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "01",
						buscadorAC01.obtenerCaja());
			}
		};
		divBuscadorAC01.appendChild(buscadorAC01);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "02");
		buscadorAC02 = new BuscadorUDC("Cd Categoria 02", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "02",
						buscadorAC02.obtenerCaja());
			}
		};
		divBuscadorAC02.appendChild(buscadorAC02);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "03");
		buscadorAC03 = new BuscadorUDC("Cd Categoria 03", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "03",
						buscadorAC03.obtenerCaja());
			}
		};
		divBuscadorAC03.appendChild(buscadorAC03);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "04");
		buscadorAC04 = new BuscadorUDC("Cd Categoria 04", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "04",
						buscadorAC04.obtenerCaja());
			}
		};
		divBuscadorAC04.appendChild(buscadorAC04);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "05");
		buscadorAC05 = new BuscadorUDC("Cd Categoria 05", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "05",
						buscadorAC05.obtenerCaja());
			}
		};
		divBuscadorAC05.appendChild(buscadorAC05);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "06");
		buscadorAC06 = new BuscadorUDC("Cd Categoria 06", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "06",
						buscadorAC06.obtenerCaja());
			}
		};
		divBuscadorAC06.appendChild(buscadorAC06);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "07");
		buscadorAC07 = new BuscadorUDC("Cd Categoria 07", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "07",
						buscadorAC07.obtenerCaja());
			}
		};
		divBuscadorAC07.appendChild(buscadorAC07);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "08");
		buscadorAC08 = new BuscadorUDC("Cd Categoria 08", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "08",
						buscadorAC08.obtenerCaja());
			}
		};
		divBuscadorAC08.appendChild(buscadorAC08);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "09");
		buscadorAC09 = new BuscadorUDC("Cd Categoria 09", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "09",
						buscadorAC09.obtenerCaja());
			}
		};
		divBuscadorAC09.appendChild(buscadorAC09);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "10");
		buscadorAC10 = new BuscadorUDC("Cd Categoria 10", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "10",
						buscadorAC10.obtenerCaja());
			}
		};
		divBuscadorAC10.appendChild(buscadorAC10);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "11");
		buscadorAC11 = new BuscadorUDC("Cd Categoria 11", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "11",
						buscadorAC11.obtenerCaja());
			}
		};
		divBuscadorAC11.appendChild(buscadorAC11);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "12");
		buscadorAC12 = new BuscadorUDC("Cd Categoria 12", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "12",
						buscadorAC12.obtenerCaja());
			}
		};
		divBuscadorAC12.appendChild(buscadorAC12);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "13");
		buscadorAC13 = new BuscadorUDC("Cd Categoria 13", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "13",
						buscadorAC13.obtenerCaja());
			}
		};
		divBuscadorAC13.appendChild(buscadorAC13);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "14");
		buscadorAC14 = new BuscadorUDC("Cd Categoria 14", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "14",
						buscadorAC14.obtenerCaja());
			}
		};
		divBuscadorAC14.appendChild(buscadorAC14);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "15");
		buscadorAC15 = new BuscadorUDC("Cd Categoria 15", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "15",
						buscadorAC15.obtenerCaja());
			}
		};
		divBuscadorAC15.appendChild(buscadorAC15);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "16");
		buscadorAC16 = new BuscadorUDC("Cd Categoria 16", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "16",
						buscadorAC16.obtenerCaja());
			}
		};
		divBuscadorAC16.appendChild(buscadorAC16);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "17");
		buscadorAC17 = new BuscadorUDC("Cd Categoria 17", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "17",
						buscadorAC17.obtenerCaja());
			}
		};
		divBuscadorAC17.appendChild(buscadorAC17);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "18");
		buscadorAC18 = new BuscadorUDC("Cd Categoria 18", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "18",
						buscadorAC18.obtenerCaja());
			}
		};
		divBuscadorAC18.appendChild(buscadorAC18);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "19");
		buscadorAC19 = new BuscadorUDC("Cd Categoria 19", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "19",
						buscadorAC19.obtenerCaja());
			}
		};
		divBuscadorAC19.appendChild(buscadorAC19);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "20");
		buscadorAC20 = new BuscadorUDC("Cd Categoria 20", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "20",
						buscadorAC20.obtenerCaja());
			}
		};
		divBuscadorAC20.appendChild(buscadorAC20);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "21");
		buscadorAC21 = new BuscadorUDC("Cd Categoria 21", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "21",
						buscadorAC21.obtenerCaja());
			}
		};
		divBuscadorAC21.appendChild(buscadorAC21);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "22");
		buscadorAC22 = new BuscadorUDC("Cd Categoria 22", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "22",
						buscadorAC22.obtenerCaja());
			}
		};
		divBuscadorAC22.appendChild(buscadorAC22);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "23");
		buscadorAC23 = new BuscadorUDC("Cd Categoria 23", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "23",
						buscadorAC23.obtenerCaja());
			}
		};
		divBuscadorAC23.appendChild(buscadorAC23);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "24");
		buscadorAC24 = new BuscadorUDC("Cd Categoria 24", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "24",
						buscadorAC24.obtenerCaja());
			}
		};
		divBuscadorAC24.appendChild(buscadorAC24);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "25");
		buscadorAC25 = new BuscadorUDC("Cd Categoria 25", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "25",
						buscadorAC25.obtenerCaja());
			}
		};
		divBuscadorAC25.appendChild(buscadorAC25);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "26");
		buscadorAC26 = new BuscadorUDC("Cd Categoria 26", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "26",
						buscadorAC26.obtenerCaja());
			}
		};
		divBuscadorAC26.appendChild(buscadorAC26);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "27");
		buscadorAC27 = new BuscadorUDC("Cd Categoria 27", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "27",
						buscadorAC27.obtenerCaja());
			}
		};
		divBuscadorAC27.appendChild(buscadorAC27);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "28");
		buscadorAC28 = new BuscadorUDC("Cd Categoria 28", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "28",
						buscadorAC28.obtenerCaja());
			}
		};
		divBuscadorAC28.appendChild(buscadorAC28);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "29");
		buscadorAC29 = new BuscadorUDC("Cd Categoria 29", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "29",
						buscadorAC29.obtenerCaja());
			}
		};
		divBuscadorAC29.appendChild(buscadorAC29);

		listF0005 = servicioF0005.buscarParaUDCOrdenados("01", "30");
		buscadorAC30 = new BuscadorUDC("Cd Categoria 30", 3, listF0005, false,
				false, false) {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("01", "30",
						buscadorAC30.obtenerCaja());
			}
		};
		divBuscadorAC30.appendChild(buscadorAC30);
	}

}
