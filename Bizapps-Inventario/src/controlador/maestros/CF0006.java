package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0004;
import modelo.maestros.F0005;
import modelo.maestros.F0005;
import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F0010;
import modelo.maestros.F0101;
import modelo.maestros.F4100;
import modelo.pk.F0005PK;
import modelo.transacciones.F4111;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Button;
import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0006 extends CGenerico {

	@Wire
	private Textbox txtUDCF0006;
	@Wire
	private Textbox txtDL01F0006;
	@Wire
	private Textbox txtCOF0006;
	@Wire
	private Textbox txtLDMF0006;
	@Wire
	private Textbox txtDL02F0006;
	@Wire
	private Textbox txtDL03F0006;
	@Wire
	private Textbox txtDL04F0006;
	@Wire
	private Textbox txtAN8F0006;
	@Wire
	private Textbox txtTXA1F0006;
	@Wire
	private Textbox txtMCUSF0006;
	@Wire
	private Div divVF0006;
	@Wire
	private Div catalogoF0006;
	@Wire
	private Div divCatalogoF0006Emergente;
	@Wire
	private Div botoneraF0006;
	@Wire
	private Div divCatalogoF0005;
	@Wire
	private Div divCatalogoF0010;
	@Wire
	private Div divCatalogoF0101;
	@Wire
	private Div divbuscadorCategoria1;
	@Wire
	private Div divbuscadorCategoria2;
	@Wire
	private Div divbuscadorCategoria3;
	@Wire
	private Div divbuscadorCategoria4;
	@Wire
	private Div divbuscadorCategoria5;
	@Wire
	private Div divbuscadorCategoria6;
	@Wire
	private Div divbuscadorCategoria7;
	@Wire
	private Div divbuscadorCategoria8;
	@Wire
	private Div divbuscadorCategoria9;
	@Wire
	private Div divbuscadorCategoria10;
	@Wire
	private Div divbuscadorCategoria11;
	@Wire
	private Div divbuscadorCategoria12;
	@Wire
	private Div divbuscadorCategoria13;
	@Wire
	private Div divbuscadorCategoria14;
	@Wire
	private Div divbuscadorCategoria15;
	@Wire
	private Div divbuscadorCategoria16;
	@Wire
	private Div divbuscadorCategoria17;
	@Wire
	private Div divbuscadorCategoria18;
	@Wire
	private Div divbuscadorCategoria19;
	@Wire
	private Div divbuscadorCategoria20;
	@Wire
	private Div divbuscadorCategoria21;
	@Wire
	private Div divbuscadorCategoria22;
	@Wire
	private Div divbuscadorCategoria23;
	@Wire
	private Div divbuscadorCategoria24;
	@Wire
	private Div divbuscadorCategoria25;
	@Wire
	private Div divbuscadorCategoria26;
	@Wire
	private Div divbuscadorCategoria27;
	@Wire
	private Div divbuscadorCategoria28;
	@Wire
	private Div divbuscadorCategoria29;
	@Wire
	private Div divbuscadorCategoria30;
	@Wire
	private Div divbuscadorSTYL;
	@Wire
	private Div divbuscadorSBLI;
	@Wire
	private Div divbuscadorFMOD;
	@Wire
	private Div divbuscadorPECC;
	@Wire
	private Div divbuscadorLDM;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Button btnBuscarCompannia;
	@Wire
	private Button btnBuscarDireccion;
	@Wire
	private Button btnBuscarProyecto;
	@Wire
	private Button btnBuscarTipoUnidad;
	@Wire
	private Label lblDescripcionF0004;
	@Wire
	private Label lblDescripcionF0010;
	@Wire
	private Label lblDescripcionF0006;
	@Wire
	private Label lblDescripcionF0101;
	Catalogo<F0006> catalogo;
	Catalogo<F0006> catalogoEmergente;
	Botonera botonera;
	String clave = null;
	Catalogo<F0005> catalogoF0005;
	Catalogo<F0010> catalogoF0010;
	Catalogo<F0101> catalogoF0101;

	BuscadorUDC buscadorCategoria1, buscadorCategoria2, buscadorCategoria3,
			buscadorCategoria4, buscadorCategoria5, buscadorCategoria6,
			buscadorCategoria7, buscadorCategoria8, buscadorCategoria9,
			buscadorCategoria10, buscadorCategoria11, buscadorCategoria12,
			buscadorCategoria13, buscadorCategoria14, buscadorCategoria15,
			buscadorCategoria16, buscadorCategoria17, buscadorCategoria18,
			buscadorCategoria19, buscadorCategoria20, buscadorCategoria21,
			buscadorCategoria22, buscadorCategoria23, buscadorCategoria24,
			buscadorCategoria25, buscadorCategoria26, buscadorCategoria27,
			buscadorCategoria28, buscadorCategoria29, buscadorCategoria30,
			buscadorSTYL, buscadorSBLI, buscadorFMOD, buscadorPECC,
			buscadorLDM;

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = (HashMap<String, Object>) Sessions
				.getCurrent().getAttribute("mapaGeneral");
		if (map != null) {
			if (map.get("tabsGenerales") != null) {
				tabs = (List<Tab>) map.get("tabsGenerales");
				System.out.println(tabs.size());
				map.clear();
				map = null;
			}
		}
		txtUDCF0006.setFocus(true);
		mostrarCatalogo();
		List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"01");
		buscadorCategoria1 = new BuscadorUDC("Código Categoría 01", 10,
				listaF0005, false, true, true, "00", "01") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "01",
						buscadorCategoria1.obtenerCaja());
			}
		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "02");
		buscadorCategoria2 = new BuscadorUDC("Código Categoría 02", 10,
				listaF0005, false, true, true, "00", "02") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "02",
						buscadorCategoria2.obtenerCaja());
			}

		};

		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "03");
		buscadorCategoria3 = new BuscadorUDC("Código Categoría 03", 10,
				listaF0005, false, true, true, "00", "03") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "03",
						buscadorCategoria3.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "04");
		buscadorCategoria4 = new BuscadorUDC("Código Categoría 04", 10,
				listaF0005, false, true, true, "00", "04") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "04",
						buscadorCategoria4.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "05");
		buscadorCategoria5 = new BuscadorUDC("Código Categoría 05", 10,
				listaF0005, false, true, true, "00", "05") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "05",
						buscadorCategoria5.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "06");
		buscadorCategoria6 = new BuscadorUDC("Código Categoría 06", 10,
				listaF0005, false, true, true, "00", "06") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "06",
						buscadorCategoria6.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "07");
		buscadorCategoria7 = new BuscadorUDC("Código Categoría 07", 10,
				listaF0005, false, true, true, "00", "07") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "07",
						buscadorCategoria7.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "08");
		buscadorCategoria8 = new BuscadorUDC("Código Categoría 08", 10,
				listaF0005, false, true, true, "00", "08") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "08",
						buscadorCategoria8.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "09");
		buscadorCategoria9 = new BuscadorUDC("Código Categoría 09", 10,
				listaF0005, false, true, true, "00", "09") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "09",
						buscadorCategoria9.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "10");
		buscadorCategoria10 = new BuscadorUDC("Código Categoría 10", 10,
				listaF0005, false, true, true, "00", "10") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "10",
						buscadorCategoria10.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "11");
		buscadorCategoria11 = new BuscadorUDC("Código Categoría 11", 10,
				listaF0005, false, true, true, "00", "11") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "11",
						buscadorCategoria11.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "12");
		buscadorCategoria12 = new BuscadorUDC("Código Categoría 12", 10,
				listaF0005, false, true, true, "00", "12") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "12",
						buscadorCategoria12.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "13");
		buscadorCategoria13 = new BuscadorUDC("Código Categoría 13", 10,
				listaF0005, false, true, true, "00", "13") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "13",
						buscadorCategoria13.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "14");
		buscadorCategoria14 = new BuscadorUDC("Código Categoría 14", 10,
				listaF0005, false, true, true, "00", "14") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "14",
						buscadorCategoria14.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "15");
		buscadorCategoria15 = new BuscadorUDC("Código Categoría 15", 10,
				listaF0005, false, true, true, "00", "15") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "15",
						buscadorCategoria15.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "16");
		buscadorCategoria16 = new BuscadorUDC("Código Categoría 16", 10,
				listaF0005, false, true, true, "00", "16") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "16",
						buscadorCategoria16.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "17");
		buscadorCategoria17 = new BuscadorUDC("Código Categoría 17", 10,
				listaF0005, false, true, true, "00", "17") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "17",
						buscadorCategoria17.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "18");
		buscadorCategoria18 = new BuscadorUDC("Código Categoría 18", 10,
				listaF0005, false, true, true, "00", "18") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "18",
						buscadorCategoria18.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "19");
		buscadorCategoria19 = new BuscadorUDC("Código Categoría 19", 10,
				listaF0005, false, true, true, "00", "19") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "19",
						buscadorCategoria19.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "20");
		buscadorCategoria20 = new BuscadorUDC("Código Categoría 20", 10,
				listaF0005, false, true, true, "00", "20") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "20",
						buscadorCategoria20.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "21");
		buscadorCategoria21 = new BuscadorUDC("Código Categoría 21", 10,
				listaF0005, false, true, true, "00", "21") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "21",
						buscadorCategoria21.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "22");
		buscadorCategoria22 = new BuscadorUDC("Código Categoría 22", 10,
				listaF0005, false, true, true, "00", "22") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "22",
						buscadorCategoria22.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "23");
		buscadorCategoria23 = new BuscadorUDC("Código Categoría 23", 10,
				listaF0005, false, true, true, "00", "23") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "23",
						buscadorCategoria23.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "24");
		buscadorCategoria24 = new BuscadorUDC("Código Categoría 24", 10,
				listaF0005, false, true, true, "00", "24") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "24",
						buscadorCategoria24.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "25");
		buscadorCategoria25 = new BuscadorUDC("Código Categoría 25", 10,
				listaF0005, false, true, true, "00", "25") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "25",
						buscadorCategoria25.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "26");
		buscadorCategoria26 = new BuscadorUDC("Código Categoría 26", 10,
				listaF0005, false, true, true, "00", "26") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "26",
						buscadorCategoria26.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "27");
		buscadorCategoria27 = new BuscadorUDC("Código Categoría 27", 10,
				listaF0005, false, true, true, "00", "27") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "27",
						buscadorCategoria27.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "28");
		buscadorCategoria28 = new BuscadorUDC("Código Categoría 28", 10,
				listaF0005, false, true, true, "00", "28") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "28",
						buscadorCategoria28.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "29");
		buscadorCategoria29 = new BuscadorUDC("Código Categoría 29", 10,
				listaF0005, false, true, true, "00", "29") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "29",
						buscadorCategoria29.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "30");
		buscadorCategoria30 = new BuscadorUDC("Código Categoría 30", 10,
				listaF0005, false, true, true, "00", "30") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "30",
						buscadorCategoria30.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "MC");
		buscadorSTYL = new BuscadorUDC("Tipo unidad negocio", 10, listaF0005,
				false, true, true, "00", "MC") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "MC",
						buscadorSTYL.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "SI");
		buscadorSBLI = new BuscadorUDC("Código inactivo LM auxiliar", 10,
				listaF0005, false, true, true, "00", "SI") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "SI",
						buscadorSBLI.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H09", "MD");
		buscadorFMOD = new BuscadorUDC("Cuenta modelo/consolidada", 10,
				listaF0005, false, true, true, "H09", "MD") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H09", "MD",
						buscadorFMOD.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "PF");
		buscadorPECC = new BuscadorUDC("Edición contabilización", 10,
				listaF0005, false, true, true, "00", "PF") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "PF",
						buscadorPECC.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H00", "LD");
		buscadorLDM = new BuscadorUDC("Nivel Detalle", 10, listaF0005, false,
				true, true, "H00", "LD") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H00", "LD",
						buscadorLDM.obtenerCaja());
			}
		};
		divbuscadorCategoria1.appendChild(buscadorCategoria1);
		divbuscadorCategoria2.appendChild(buscadorCategoria2);
		divbuscadorCategoria3.appendChild(buscadorCategoria3);
		divbuscadorCategoria4.appendChild(buscadorCategoria4);
		divbuscadorCategoria5.appendChild(buscadorCategoria5);
		divbuscadorCategoria6.appendChild(buscadorCategoria6);
		divbuscadorCategoria7.appendChild(buscadorCategoria7);
		divbuscadorCategoria8.appendChild(buscadorCategoria8);
		divbuscadorCategoria9.appendChild(buscadorCategoria9);
		divbuscadorCategoria10.appendChild(buscadorCategoria10);
		divbuscadorCategoria11.appendChild(buscadorCategoria11);
		divbuscadorCategoria12.appendChild(buscadorCategoria12);
		divbuscadorCategoria13.appendChild(buscadorCategoria13);
		divbuscadorCategoria14.appendChild(buscadorCategoria14);
		divbuscadorCategoria15.appendChild(buscadorCategoria15);
		divbuscadorCategoria16.appendChild(buscadorCategoria16);
		divbuscadorCategoria17.appendChild(buscadorCategoria17);
		divbuscadorCategoria18.appendChild(buscadorCategoria18);
		divbuscadorCategoria19.appendChild(buscadorCategoria19);
		divbuscadorCategoria20.appendChild(buscadorCategoria20);
		divbuscadorCategoria21.appendChild(buscadorCategoria21);
		divbuscadorCategoria22.appendChild(buscadorCategoria22);
		divbuscadorCategoria23.appendChild(buscadorCategoria23);
		divbuscadorCategoria24.appendChild(buscadorCategoria24);
		divbuscadorCategoria25.appendChild(buscadorCategoria25);
		divbuscadorCategoria26.appendChild(buscadorCategoria26);
		divbuscadorCategoria27.appendChild(buscadorCategoria27);
		divbuscadorCategoria28.appendChild(buscadorCategoria28);
		divbuscadorCategoria29.appendChild(buscadorCategoria29);
		divbuscadorCategoria30.appendChild(buscadorCategoria30);
		divbuscadorSTYL.appendChild(buscadorSTYL);
		divbuscadorSBLI.appendChild(buscadorSBLI);
		divbuscadorFMOD.appendChild(buscadorFMOD);
		divbuscadorPECC.appendChild(buscadorPECC);
		divbuscadorLDM.appendChild(buscadorLDM);
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F0006 f06 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f06.getMcmcu();
						txtUDCF0006.setValue(f06.getMcmcu());
						txtUDCF0006.setDisabled(true);
						txtDL01F0006.setValue(f06.getMcdl01());
						txtDL01F0006.setDisabled(true);
						txtCOF0006.setValue(f06.getMcco());
						txtCOF0006.setDisabled(true);
						if (f06.getMcldm() != null)
							buscadorLDM.settearCampo(servicioF0005.buscar(
									"H00", "LD", f06.getMcldm()));
						// txtLDMF0006.setValue(f06.getMcldm());
						buscadorSTYL.settearCampo(servicioF0005.buscar("00",
								"00", f06.getMcstyl()));
						buscadorSBLI.settearCampo(servicioF0005.buscar("00",
								"00", f06.getMcsbli()));
						buscadorFMOD.settearCampo(servicioF0005.buscar("00",
								"00", f06.getMcfmod()));
						txtDL02F0006.setValue(f06.getMcdl02());
						txtDL03F0006.setValue(f06.getMcdl03());
						txtDL04F0006.setValue(f06.getMcdl04());
						txtAN8F0006.setValue(String.valueOf(f06.getMcan8()));
						txtTXA1F0006.setValue(f06.getMctxa1());
						txtMCUSF0006.setValue(f06.getMcmcus());
						buscadorPECC.settearCampo(servicioF0005.buscar("00",
								"00", String.valueOf(f06.getMcpcc())));
						buscadorCategoria1.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp01()));
						buscadorCategoria2.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp02()));
						buscadorCategoria3.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp03()));
						buscadorCategoria4.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp04()));
						buscadorCategoria5.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp05()));
						buscadorCategoria6.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp06()));
						buscadorCategoria7.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp07()));
						buscadorCategoria8.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp08()));
						buscadorCategoria9.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp09()));
						buscadorCategoria10.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp10()));
						buscadorCategoria11.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp11()));
						buscadorCategoria12.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp12()));
						buscadorCategoria13.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp13()));
						buscadorCategoria14.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp14()));
						buscadorCategoria15.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp15()));
						buscadorCategoria16.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp16()));
						buscadorCategoria17.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp17()));
						buscadorCategoria18.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp18()));
						buscadorCategoria19.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp19()));
						buscadorCategoria20.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp20()));
						buscadorCategoria21.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp21()));
						buscadorCategoria22.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp22()));
						buscadorCategoria23.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp23()));
						buscadorCategoria24.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp24()));
						buscadorCategoria25.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp25()));
						buscadorCategoria26.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp26()));
						buscadorCategoria27.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp27()));
						buscadorCategoria28.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp28()));
						buscadorCategoria29.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp29()));
						buscadorCategoria30.settearCampo(servicioF0005.buscar(
								"00", "00", f06.getMcrp30()));
						buscadorLDM.setFocus(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0006, "Trabajo con Unidades de Negocio",
						tabs);

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
				habilitarCampos();

			}

			@Override
			public void guardar() {
				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {
					String MCMCU = txtUDCF0006.getValue();
					String dl01 = txtDL01F0006.getValue();
					String co = txtCOF0006.getValue();
					String ldmf = buscadorLDM.obtenerCaja();
					String styl = buscadorSTYL.obtenerCaja();
					String sbli = buscadorSBLI.obtenerCaja();
					String fmod = buscadorFMOD.obtenerCaja();
					String dl02 = txtDL02F0006.getValue();
					String dl03 = txtDL03F0006.getValue();
					String dl04 = txtDL04F0006.getValue();
					// double an8 = Double.parseDouble(txtAN8F0006.getValue());
					String txa1 = txtTXA1F0006.getValue();
					String mcus = txtMCUSF0006.getValue();
					String pecc = buscadorPECC.obtenerCaja();
					String rp01 = buscadorCategoria1.obtenerCaja();
					String rp02 = buscadorCategoria2.obtenerCaja();
					String rp03 = buscadorCategoria3.obtenerCaja();
					String rp04 = buscadorCategoria4.obtenerCaja();
					String rp05 = buscadorCategoria5.obtenerCaja();
					String rp06 = buscadorCategoria6.obtenerCaja();
					String rp07 = buscadorCategoria7.obtenerCaja();
					String rp08 = buscadorCategoria8.obtenerCaja();
					String rp09 = buscadorCategoria9.obtenerCaja();
					String rp10 = buscadorCategoria10.obtenerCaja();
					String rp11 = buscadorCategoria11.obtenerCaja();
					String rp12 = buscadorCategoria12.obtenerCaja();
					String rp13 = buscadorCategoria13.obtenerCaja();
					String rp14 = buscadorCategoria14.obtenerCaja();
					String rp15 = buscadorCategoria15.obtenerCaja();
					String rp16 = buscadorCategoria16.obtenerCaja();
					String rp17 = buscadorCategoria17.obtenerCaja();
					String rp18 = buscadorCategoria18.obtenerCaja();
					String rp19 = buscadorCategoria19.obtenerCaja();
					String rp20 = buscadorCategoria20.obtenerCaja();
					String rp21 = buscadorCategoria21.obtenerCaja();
					String rp22 = buscadorCategoria22.obtenerCaja();
					String rp23 = buscadorCategoria23.obtenerCaja();
					String rp24 = buscadorCategoria24.obtenerCaja();
					String rp25 = buscadorCategoria25.obtenerCaja();
					String rp26 = buscadorCategoria26.obtenerCaja();
					String rp27 = buscadorCategoria27.obtenerCaja();
					String rp28 = buscadorCategoria28.obtenerCaja();
					String rp29 = buscadorCategoria29.obtenerCaja();
					String rp30 = buscadorCategoria30.obtenerCaja();
					F0006 fooo6 = new F0006();
					fooo6.setMcmcu(MCMCU);
					fooo6.setMcdl01(dl01);
					fooo6.setMcco(co);
					fooo6.setMcldm(ldmf);
					fooo6.setMcstyl(styl);
					fooo6.setMcsbli(sbli);
					fooo6.setMcfmod(fmod);
					fooo6.setMcdl02(dl02);
					fooo6.setMcdl03(dl03);
					fooo6.setMcdl04(dl04);
					// fooo6.setMcan8(an8);
					fooo6.setMctxa1(txa1);
					fooo6.setMcmcus(mcus);
					fooo6.setMcpecc(pecc);
					fooo6.setMcrp01(rp01);
					fooo6.setMcrp02(rp02);
					fooo6.setMcrp03(rp03);
					fooo6.setMcrp04(rp04);
					fooo6.setMcrp05(rp05);
					fooo6.setMcrp06(rp06);
					fooo6.setMcrp07(rp07);
					fooo6.setMcrp08(rp08);
					fooo6.setMcrp09(rp09);
					fooo6.setMcrp10(rp10);
					fooo6.setMcrp11(rp11);
					fooo6.setMcrp12(rp12);
					fooo6.setMcrp13(rp13);
					fooo6.setMcrp14(rp14);
					fooo6.setMcrp15(rp15);
					fooo6.setMcrp16(rp16);
					fooo6.setMcrp17(rp17);
					fooo6.setMcrp18(rp18);
					fooo6.setMcrp19(rp19);
					fooo6.setMcrp20(rp20);
					fooo6.setMcrp21(rp21);
					fooo6.setMcrp22(rp22);
					fooo6.setMcrp23(rp23);
					fooo6.setMcrp24(rp24);
					fooo6.setMcrp25(rp25);
					fooo6.setMcrp26(rp26);
					fooo6.setMcrp27(rp27);
					fooo6.setMcrp28(rp28);
					fooo6.setMcrp29(rp29);
					fooo6.setMcrp30(rp30);

					servicioF0006.guardar(fooo6);

					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF0006
							.buscarTodosOrdenados());
				}

			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F0006> eliminarLista = catalogo
								.obtenerSeleccionados();
						final int cantidad = eliminarLista.size();
						for (int i = 0; i < eliminarLista.size(); i++) {
							F0006 valor = eliminarLista.get(i);
							List<F4100> objeto = servicioF4100
									.buscarPorMcu(valor.getMcmcu());
							List<F4111> objeto2 = servicioF4111
									.buscarPorMcuOMccu(valor.getMcmcu());
							if (!objeto.isEmpty() || !objeto2.isEmpty()) {
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
														servicioF0006
																.eliminarVarios(eliminarLista);
														catalogo.actualizarLista(servicioF0006
																.buscarTodosOrdenados());
														if (cantidad != eliminarLista
																.size())
															msj.mensajeInformacion(Mensaje.algunosEliminados);
														else
															msj.mensajeInformacion(Mensaje.eliminado);
													}
												}
											});
						} else {
							msj.mensajeAlerta(Mensaje.registroUtilizado);
						}
					}
				} else {
					/* Elimina un solo registro */
					if (clave != null) {
						List<F4100> objeto = servicioF4100.buscarPorMcu(clave);
						List<F4111> objeto2 = servicioF4111
								.buscarPorMcuOMccu(clave);
						if (objeto.isEmpty() || objeto2.isEmpty()) {
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
														servicioF0006
																.eliminarUno(clave);
														msj.mensajeInformacion(Mensaje.eliminado);
														limpiar();
														catalogo.actualizarLista(servicioF0006
																.buscarTodosOrdenados());
													}
												}
											});
						} else {
							msj.mensajeAlerta(Mensaje.registroUtilizado);
						}
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
		botoneraF0006.appendChild(botonera);

	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(bol);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
	}

	public boolean validarSeleccion() {
		List<F0006> seleccionados = catalogo.obtenerSeleccionados();
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
		if (txtUDCF0006.getText().compareTo("") == 0
				|| txtDL01F0006.getText().compareTo("") == 0
				|| txtCOF0006.getText().compareTo("") == 0) {
			return false;
		} else
			return true;

	}

	protected boolean validar() {
		// if (claveSYExiste()) {
		// return false;
		// }
		// else {
		if (!camposLLenos()) {
			msj.mensajeAlerta(Mensaje.camposVacios);
			return false;
		} else
			return true;
		// }
	}

	@Listen("onChange = #txtUDCF0006")
	public boolean claveSYExiste() {
		if (servicioF0006.buscar(txtUDCF0006.getValue()) != null) {
			msj.mensajeAlerta(Mensaje.claveUsada);
			txtUDCF0006.setValue("");
			txtUDCF0006.setFocus(true);
			return true;
		} else
			return false;
	}

	public void limpiarCampos() {
		clave = null;
		txtUDCF0006.setValue("");
		txtDL01F0006.setValue("");
		txtCOF0006.setValue("");
		buscadorLDM.settearCampo(null);
		buscadorSTYL.settearCampo(null);
		buscadorSBLI.settearCampo(null);
		buscadorFMOD.settearCampo(null);
		txtDL02F0006.setValue("");
		txtDL03F0006.setValue("");
		txtDL04F0006.setValue("");
		txtAN8F0006.setValue("");
		txtTXA1F0006.setValue("");
		txtMCUSF0006.setValue("");
		buscadorPECC.settearCampo(null);
		buscadorCategoria1.settearCampo(null);
		buscadorCategoria2.settearCampo(null);
		buscadorCategoria3.settearCampo(null);
		buscadorCategoria4.settearCampo(null);
		buscadorCategoria5.settearCampo(null);
		buscadorCategoria6.settearCampo(null);
		buscadorCategoria7.settearCampo(null);
		buscadorCategoria8.settearCampo(null);
		buscadorCategoria9.settearCampo(null);
		buscadorCategoria10.settearCampo(null);
		buscadorCategoria11.settearCampo(null);
		buscadorCategoria12.settearCampo(null);
		buscadorCategoria13.settearCampo(null);
		buscadorCategoria14.settearCampo(null);
		buscadorCategoria15.settearCampo(null);
		buscadorCategoria16.settearCampo(null);
		buscadorCategoria17.settearCampo(null);
		buscadorCategoria18.settearCampo(null);
		buscadorCategoria19.settearCampo(null);
		buscadorCategoria20.settearCampo(null);
		buscadorCategoria21.settearCampo(null);
		buscadorCategoria22.settearCampo(null);
		buscadorCategoria23.settearCampo(null);
		buscadorCategoria24.settearCampo(null);
		buscadorCategoria25.settearCampo(null);
		buscadorCategoria26.settearCampo(null);
		buscadorCategoria27.settearCampo(null);
		buscadorCategoria28.settearCampo(null);
		buscadorCategoria29.settearCampo(null);
		buscadorCategoria30.settearCampo(null);
		lblDescripcionF0010.setValue("");
		txtUDCF0006.setFocus(true);
	}

	public void habilitarCampos() {
		if (txtUDCF0006.isDisabled())
			txtUDCF0006.setDisabled(false);
		if (txtDL01F0006.isDisabled())
			txtDL01F0006.setDisabled(false);
		if (txtCOF0006.isDisabled())
			txtCOF0006.setDisabled(false);
	}

	public boolean camposEditando() {
		if (txtUDCF0006.getText().compareTo("") != 0
				|| txtDL01F0006.getText().compareTo("") != 0
				|| txtCOF0006.getText().compareTo("") != 0
				|| buscadorLDM.obtenerCaja().compareTo("") != 0
				|| buscadorSTYL.obtenerCaja().compareTo("") != 0
				|| buscadorSBLI.obtenerCaja().compareTo("") != 0
				|| buscadorFMOD.obtenerCaja().compareTo("") != 0
				|| txtDL02F0006.getText().compareTo("") != 0
				|| txtDL03F0006.getText().compareTo("") != 0
				|| txtDL04F0006.getText().compareTo("") != 0
				|| txtAN8F0006.getText().compareTo("") != 0
				|| txtTXA1F0006.getText().compareTo("") != 0
				|| txtMCUSF0006.getText().compareTo("") != 0
				|| buscadorPECC.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria1.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria2.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria3.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria4.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria5.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria6.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria7.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria8.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria9.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria10.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria11.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria12.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria13.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria14.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria15.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria16.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria17.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria18.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria19.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria20.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria21.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria22.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria23.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria24.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria25.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria26.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria27.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria28.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria29.obtenerCaja().compareTo("") != 0
				|| buscadorCategoria30.obtenerCaja().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	@Listen("onOpen = #gpxDatos")
	public void abrirCatalogo() {
		gpxDatos.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatos.setOpen(false);
								gpxRegistro.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatos.setOpen(true);
									gpxRegistro.setOpen(false);
									limpiarCampos();
									habilitarCampos();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatos.setOpen(true);
			gpxRegistro.setOpen(false);
			mostrarBotones(true);
		}
	}

	public void mostrarCatalogo() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogo = new Catalogo<F0006>(catalogoF0006, "F0006", unidades, false,
				true, true, "Unidad Negocio", "Descripcion", "Nivel det",
				"Cta", "Tipo UN", "LM Auxiliar Inactivo", "Mto Cons", "CAT 01",
				"CAT 02", "CAT 03", "CAT 04", "CAT 05", "CAT 06") {

			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					String mcdc = "";
					if (unidad.getMcdc() != null)
						mcdc = unidad.getMcdc();
					if (unidad.getMcmcu().toLowerCase()
							.startsWith(valores.get(0))
							&& mcdc.toLowerCase().startsWith(valores.get(1))
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
		catalogo.setParent(catalogoF0006);
	}

	@Listen("onClick = #btnBuscarCompannia")
	public void mostrarCatalogoF0010() {
		final List<F0010> lista = servicioF0010.buscarTodosOrdenados();
		catalogoF0010 = new Catalogo<F0010>(divCatalogoF0010, "F0010", lista,
				true, false, false, "Codigo", "Nombre", "Nº Periodo", "Patron",
				"Inicio año Fiscal", "Periodo LM", "Inicio año C/P",
				"Periodo C/P", "Inicio año C/C", "Periodo C/C") {

			@Override
			protected List<F0010> buscar(List<String> valores) {

				List<F0010> lista2 = new ArrayList<F0010>();

				for (F0010 f0010 : lista) {
					String ccdot = "";
					if (f0010.getCcdot1() != null)
						ccdot = f0010.getCcdot1();
					if (f0010.getCcco().toLowerCase()
							.startsWith(valores.get(0))
							&& f0010.getCcname().toLowerCase()
									.startsWith(valores.get(1))
							&& String.valueOf(f0010.getCcpnc()).toLowerCase()
									.startsWith(valores.get(2))
							&& ccdot.toLowerCase().startsWith(valores.get(3))
							&& f0010.getCcarfj().toString().toLowerCase()
									.startsWith(valores.get(4))
							&& String.valueOf(f0010.getCctxbm()).toLowerCase()
									.startsWith(valores.get(5))
							&& f0010.getCcapfj().toString().toLowerCase()
									.startsWith(valores.get(6))
							&& String.valueOf(f0010.getCctxbo()).toLowerCase()
									.startsWith(valores.get(7))
							&& f0010.getCcdfyj().toString().toLowerCase()
									.startsWith(valores.get(8))
							&& String.valueOf(f0010.getCcpnf()).toLowerCase()
									.startsWith(valores.get(9))) {
						lista2.add(f0010);
					}
				}
				return lista2;
			}

			@Override
			protected String[] crearRegistros(F0010 f0010) {
				String[] registros = new String[10];
				registros[0] = f0010.getCcco();
				registros[1] = f0010.getCcname();
				registros[2] = String.valueOf(f0010.getCcpnc());
				registros[3] = f0010.getCcdot1();
				registros[4] = f0010.getCcarfj().toString();
				registros[5] = String.valueOf(f0010.getCctxbm());
				registros[6] = f0010.getCcapfj().toString();
				registros[7] = String.valueOf(f0010.getCctxbo());
				registros[8] = f0010.getCcdfyj().toString();
				registros[9] = String.valueOf(f0010.getCcpnf());
				return registros;

			}
		};
		catalogoF0010.setParent(divCatalogoF0010);
		catalogoF0010.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0010")
	public void seleccionF0010() {
		F0010 f0010 = catalogoF0010.objetoSeleccionadoDelCatalogo();
		txtCOF0006.setValue(f0010.getCcco());
		lblDescripcionF0010.setValue(servicioF0010.buscar(f0010.getCcco())
				.getCcname());
		catalogoF0010.setParent(null);
	}

	@Listen("onClick = #btnBuscarDireccion")
	public void mostrarCatalogoF0101() {
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoF0101 = new Catalogo<F0101>(divCatalogoF0101, "F0101",
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
		catalogoF0101.setParent(divCatalogoF0101);
		catalogoF0101.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0101")
	public void seleccionF0101() {
		F0101 f0101 = catalogoF0101.objetoSeleccionadoDelCatalogo();
		txtAN8F0006.setValue(String.valueOf(f0101.getAban8()));
		lblDescripcionF0101.setValue(f0101.getAbalph());
		catalogoF0101.setParent(null);
	}

	@Listen("onClick = #btnBuscarProyecto")
	public void mostrarCatalogoProyecto() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoEmergente = new Catalogo<F0006>(divCatalogoF0006Emergente,
				"F0006Emergente", unidades, true, false, false,
				"Unidad Negocio", "Descripcion", "Nivel det", "Cta", "Tipo UN",
				"LM Auxiliar Inactivo", "Mto Cons", "CAT 01", "CAT 02",
				"CAT 03", "CAT 04", "CAT 05", "CAT 06") {

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
		catalogoEmergente.setParent(divCatalogoF0006Emergente);
		catalogoEmergente.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0006Emergente")
	public void seleccionF0006() {
		F0006 f0006 = catalogoEmergente.objetoSeleccionadoDelCatalogo();
		txtMCUSF0006.setValue(f0006.getMcmcu());
		lblDescripcionF0006.setValue(f0006.getMcdl01());
		catalogoEmergente.setParent(null);
	}
}
