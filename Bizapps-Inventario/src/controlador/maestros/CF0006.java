package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F0010;
import modelo.maestros.F0101;
import modelo.maestros.F4100;
import modelo.maestros.F4105;
import modelo.maestros.F49041;
import modelo.maestros.F4930;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.buscadores.BuscadorUDC;
import componentes.catalogos.CatalogoGenerico;

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
	private Longbox txtAN8F0006;
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
	CatalogoGenerico<F0006> catalogo;
	CatalogoGenerico<F0006> catalogoEmergente;
	Botonera botonera;
	String clave = null;
	CatalogoGenerico<F0005> catalogoF0005;
	CatalogoGenerico<F0010> catalogoF0010;
	CatalogoGenerico<F0101> catalogoF0101;
	protected List<F0006> listaGeneral = new ArrayList<F0006>();

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
				titulo = (String) map.get("titulo");
				map.clear();
				map = null;
			}
		}
		txtUDCF0006.setFocus(true);
		mostrarCatalogo();
		List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"01");
		buscadorCategoria1 = new BuscadorUDC("C�digo Categor�a 01", 10, false,
				"00", "01", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "01",
						buscadorCategoria1.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "02");
		buscadorCategoria2 = new BuscadorUDC("C�digo Categor�a 02", 10, false,
				"00", "02", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "02",
						buscadorCategoria2.obtenerCaja());
			}

		};

		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "03");
		buscadorCategoria3 = new BuscadorUDC("C�digo Categor�a 03", 10, false,
				"00", "03", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "03",
						buscadorCategoria3.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "04");
		buscadorCategoria4 = new BuscadorUDC("C�digo Categor�a 04", 10, false,
				"00", "04", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "04",
						buscadorCategoria4.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "05");
		buscadorCategoria5 = new BuscadorUDC("C�digo Categor�a 05", 10, false,
				"00", "05", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "05",
						buscadorCategoria5.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "06");
		buscadorCategoria6 = new BuscadorUDC("C�digo Categor�a 06", 10, false,
				"00", "06", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "06",
						buscadorCategoria6.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "07");
		buscadorCategoria7 = new BuscadorUDC("C�digo Categor�a 07", 10, false,
				"00", "07", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "07",
						buscadorCategoria7.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "08");
		buscadorCategoria8 = new BuscadorUDC("C�digo Categor�a 08", 10, false,
				"00", "08", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "08",
						buscadorCategoria8.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "09");
		buscadorCategoria9 = new BuscadorUDC("C�digo Categor�a 09", 10, false,
				"00", "09", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "09",
						buscadorCategoria9.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "10");
		buscadorCategoria10 = new BuscadorUDC("C�digo Categor�a 10", 10, false,
				"00", "10", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "10",
						buscadorCategoria10.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "11");
		buscadorCategoria11 = new BuscadorUDC("C�digo Categor�a 11", 10, false,
				"00", "11", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "11",
						buscadorCategoria11.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "12");
		buscadorCategoria12 = new BuscadorUDC("C�digo Categor�a 12", 10, false,
				"00", "12", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "12",
						buscadorCategoria12.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "13");
		buscadorCategoria13 = new BuscadorUDC("C�digo Categor�a 13", 10, false,
				"00", "13", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "13",
						buscadorCategoria13.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "14");
		buscadorCategoria14 = new BuscadorUDC("C�digo Categor�a 14", 10, false,
				"00", "14", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "14",
						buscadorCategoria14.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "15");
		buscadorCategoria15 = new BuscadorUDC("C�digo Categor�a 15", 10, false,
				"00", "15", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "15",
						buscadorCategoria15.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "16");
		buscadorCategoria16 = new BuscadorUDC("C�digo Categor�a 16", 10, false,
				"00", "16", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "16",
						buscadorCategoria16.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "17");
		buscadorCategoria17 = new BuscadorUDC("C�digo Categor�a 17", 10, false,
				"00", "17", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "17",
						buscadorCategoria17.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "18");
		buscadorCategoria18 = new BuscadorUDC("C�digo Categor�a 18", 10, false,
				"00", "18", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "18",
						buscadorCategoria18.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "19");
		buscadorCategoria19 = new BuscadorUDC("C�digo Categor�a 19", 10, false,
				"00", "19", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "19",
						buscadorCategoria19.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "20");
		buscadorCategoria20 = new BuscadorUDC("C�digo Categor�a 20", 10, false,
				"00", "20", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "20",
						buscadorCategoria20.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "21");
		buscadorCategoria21 = new BuscadorUDC("C�digo Categor�a 21", 10, false,
				"00", "21", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "21",
						buscadorCategoria21.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "22");
		buscadorCategoria22 = new BuscadorUDC("C�digo Categor�a 22", 10, false,
				"00", "22", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "22",
						buscadorCategoria22.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "23");
		buscadorCategoria23 = new BuscadorUDC("C�digo Categor�a 23", 10, false,
				"00", "23", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "23",
						buscadorCategoria23.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "24");
		buscadorCategoria24 = new BuscadorUDC("C�digo Categor�a 24", 10, false,
				"00", "24", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "24",
						buscadorCategoria24.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "25");
		buscadorCategoria25 = new BuscadorUDC("C�digo Categor�a 25", 10, false,
				"00", "25", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "25",
						buscadorCategoria25.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "26");
		buscadorCategoria26 = new BuscadorUDC("C�digo Categor�a 26", 10, false,
				"00", "26", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "26",
						buscadorCategoria26.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "27");
		buscadorCategoria27 = new BuscadorUDC("C�digo Categor�a 27", 10, false,
				"00", "27", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "27",
						buscadorCategoria27.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "28");
		buscadorCategoria28 = new BuscadorUDC("C�digo Categor�a 28", 10, false,
				"00", "28", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "28",
						buscadorCategoria28.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "29");
		buscadorCategoria29 = new BuscadorUDC("C�digo Categor�a 29", 10, false,
				"00", "29", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "29",
						buscadorCategoria29.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "30");
		buscadorCategoria30 = new BuscadorUDC("C�digo Categor�a 30", 10, false,
				"00", "30", servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "30",
						buscadorCategoria30.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "MC");
		buscadorSTYL = new BuscadorUDC("Tipo unidad negocio", 10, false, "00",
				"MC", servicioF0005, "25%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "MC",
						buscadorSTYL.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "SI");
		buscadorSBLI = new BuscadorUDC("C�digo inactivo LM auxiliar", 10,
				false, "00", "SI", servicioF0005, "25%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "SI",
						buscadorSBLI.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H09", "MD");
		buscadorFMOD = new BuscadorUDC("Cuenta modelo/consolidada", 10, false,
				"H09", "MD", servicioF0005, "25%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("H09", "MD",
						buscadorFMOD.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("00", "PF");
		buscadorPECC = new BuscadorUDC("Edici�n contabilizaci�n", 10, false,
				"00", "PF", servicioF0005, "25%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "PF",
						buscadorPECC.obtenerCaja());
			}

		};
		listaF0005 = servicioF0005.buscarParaUDCOrdenados("H00", "LD");
		buscadorLDM = new BuscadorUDC("Nivel Detalle", 10, false, "H00", "LD",
				servicioF0005, "25%", "7%", "10%", "40%") {
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
						if (f06.getMcco() != null)
						{
							if (servicioF0010.buscar(
									f06.getMcco()).getCcname()!=null)
							{
							lblDescripcionF0010.setValue(servicioF0010.buscar(
									f06.getMcco()).getCcname());
						txtCOF0006.setDisabled(true);
							}
						}
						if (f06.getMcldm().compareTo("") != 0)
							buscadorLDM.settearModelo(servicioF0005.buscar(
									"H00", "LD", f06.getMcldm()));
						// txtLDMF0006.setValue(f06.getMcldm());

						if (f06.getMcstyl().compareTo("") != 0)
							buscadorSTYL.settearModelo(servicioF0005.buscar(
									"00", "MC", f06.getMcstyl()));

						if (f06.getMcsbli().compareTo("") != 0)
							buscadorSBLI.settearModelo(servicioF0005.buscar(
									"00", "SI", f06.getMcsbli()));

						if (f06.getMcfmod().compareTo("") != 0)
							buscadorFMOD.settearModelo(servicioF0005.buscar(
									"H09", "MD", f06.getMcfmod()));

						if (f06.getMcdl02().compareTo("") != 0)
							txtDL02F0006.setValue(f06.getMcdl02());

						if (f06.getMcdl03().compareTo("") != 0)
							txtDL03F0006.setValue(f06.getMcdl03());

						if (f06.getMcdl04().compareTo("") != 0)
							txtDL04F0006.setValue(f06.getMcdl04());

						if (f06.getMcan8() != null) {
							txtAN8F0006.setValue(Math.round(f06.getMcan8()));
							lblDescripcionF0101.setValue(servicioF0101.buscar(
									f06.getMcan8()).getAbalph());

						}

						if (f06.getMctxa1().compareTo("") != 0)
							txtTXA1F0006.setValue(f06.getMctxa1());

						txtMCUSF0006.setValue(f06.getMcmcus());
						if (f06.getMcmcus().compareTo("") != 0)
							lblDescripcionF0006.setValue(f06.getMcdl01());

						if (f06.getMcpecc().compareTo("") != 0)
							buscadorPECC
									.settearModelo(servicioF0005.buscar("00",
											"PF",
											String.valueOf(f06.getMcpecc())));

						if (f06.getMcrp01().compareTo("") != 0)
							buscadorCategoria1.settearModelo(servicioF0005
									.buscar("00", "01", f06.getMcrp01()));

						if (f06.getMcrp02().compareTo("") != 0)
							buscadorCategoria2.settearModelo(servicioF0005
									.buscar("00", "02", f06.getMcrp02()));

						if (f06.getMcrp03().compareTo("") != 0)
							buscadorCategoria3.settearModelo(servicioF0005
									.buscar("00", "03", f06.getMcrp03()));

						if (f06.getMcrp04().compareTo("") != 0)
							buscadorCategoria4.settearModelo(servicioF0005
									.buscar("00", "04", f06.getMcrp04()));

						if (f06.getMcrp05().compareTo("") != 0)
							buscadorCategoria5.settearModelo(servicioF0005
									.buscar("00", "05", f06.getMcrp05()));

						if (f06.getMcrp06().compareTo("") != 0)
							buscadorCategoria6.settearModelo(servicioF0005
									.buscar("00", "06", f06.getMcrp06()));

						if (f06.getMcrp07().compareTo("") != 0)
							buscadorCategoria7.settearModelo(servicioF0005
									.buscar("00", "07", f06.getMcrp07()));

						if (f06.getMcrp08().compareTo("") != 0)
							buscadorCategoria8.settearModelo(servicioF0005
									.buscar("00", "08", f06.getMcrp08()));

						if (f06.getMcrp09().compareTo("") != 0)
							buscadorCategoria9.settearModelo(servicioF0005
									.buscar("00", "09", f06.getMcrp09()));

						if (f06.getMcrp10().compareTo("") != 0)
							buscadorCategoria10.settearModelo(servicioF0005
									.buscar("00", "10", f06.getMcrp10()));

						if (f06.getMcrp11().compareTo("") != 0)
							buscadorCategoria11.settearModelo(servicioF0005
									.buscar("00", "11", f06.getMcrp11()));

						if (f06.getMcrp12().compareTo("") != 0)
							buscadorCategoria12.settearModelo(servicioF0005
									.buscar("00", "12", f06.getMcrp12()));

						if (f06.getMcrp13().compareTo("") != 0)
							buscadorCategoria13.settearModelo(servicioF0005
									.buscar("00", "13", f06.getMcrp13()));

						if (f06.getMcrp14().compareTo("") != 0)
							buscadorCategoria14.settearModelo(servicioF0005
									.buscar("00", "14", f06.getMcrp14()));

						if (f06.getMcrp15().compareTo("") != 0)
							buscadorCategoria15.settearModelo(servicioF0005
									.buscar("00", "15", f06.getMcrp15()));

						if (f06.getMcrp16().compareTo("") != 0)
							buscadorCategoria16.settearModelo(servicioF0005
									.buscar("00", "16", f06.getMcrp16()));

						if (f06.getMcrp17().compareTo("") != 0)
							buscadorCategoria17.settearModelo(servicioF0005
									.buscar("00", "17", f06.getMcrp17()));

						if (f06.getMcrp18().compareTo("") != 0)
							buscadorCategoria18.settearModelo(servicioF0005
									.buscar("00", "18", f06.getMcrp18()));

						if (f06.getMcrp19().compareTo("") != 0)
							buscadorCategoria19.settearModelo(servicioF0005
									.buscar("00", "19", f06.getMcrp19()));

						if (f06.getMcrp20().compareTo("") != 0)
							buscadorCategoria20.settearModelo(servicioF0005
									.buscar("00", "20", f06.getMcrp20()));

						if (f06.getMcrp21().compareTo("") != 0)
							buscadorCategoria21.settearModelo(servicioF0005
									.buscar("00", "21", f06.getMcrp21()));

						if (f06.getMcrp22().compareTo("") != 0)
							buscadorCategoria22.settearModelo(servicioF0005
									.buscar("00", "22", f06.getMcrp22()));

						if (f06.getMcrp23().compareTo("") != 0)
							buscadorCategoria23.settearModelo(servicioF0005
									.buscar("00", "23", f06.getMcrp23()));

						if (f06.getMcrp24().compareTo("") != 0)
							buscadorCategoria24.settearModelo(servicioF0005
									.buscar("00", "24", f06.getMcrp24()));

						if (f06.getMcrp25().compareTo("") != 0)
							buscadorCategoria25.settearModelo(servicioF0005
									.buscar("00", "25", f06.getMcrp25()));

						if (f06.getMcrp26().compareTo("") != 0)
							buscadorCategoria26.settearModelo(servicioF0005
									.buscar("00", "26", f06.getMcrp26()));

						if (f06.getMcrp27().compareTo("") != 0)
							buscadorCategoria27.settearModelo(servicioF0005
									.buscar("00", "27", f06.getMcrp27()));

						if (f06.getMcrp28().compareTo("") != 0)
							buscadorCategoria28.settearModelo(servicioF0005
									.buscar("00", "28", f06.getMcrp28()));

						if (f06.getMcrp29().compareTo("") != 0)
							buscadorCategoria29.settearModelo(servicioF0005
									.buscar("00", "29", f06.getMcrp29()));

						if (f06.getMcrp30().compareTo("") != 0)
							buscadorCategoria30.settearModelo(servicioF0005
									.buscar("00", "30", f06.getMcrp30()));
						btnBuscarCompannia.setVisible(false);
						buscadorLDM.setFocus(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0006, titulo, tabs);

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

				if (validar()) {
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
					Long an8 = txtAN8F0006.getValue();
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
					if (an8 != null)
						fooo6.setMcan8(an8.doubleValue());
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
					listaGeneral = servicioF0006.buscarTodosOrdenados();
					catalogo.actualizarLista(listaGeneral);
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
							List<F0101> objetoF0101 = servicioF0101
									.buscarPorAbmcu(valor.getMcmcu());
							List<F4100> objetoF4100 = servicioF4100
									.buscarPorMcu(valor.getMcmcu());
							List<F4105> objetoF4105 = servicioF4105
									.buscarPorMcu(valor.getMcmcu());
							List<F4930> objetoF4930 = servicioF4930
									.buscarPorMcu(valor.getMcmcu());
							List<F49041> objetoF49041 = servicioF49041
									.buscarPorMcu(valor.getMcmcu());

							if (!objetoF0101.isEmpty()
									|| !objetoF4100.isEmpty()
									|| !objetoF4105.isEmpty()
									|| !objetoF4930.isEmpty()
									|| !objetoF49041.isEmpty()) {
								eliminarLista.remove(valor);
								i--;
							}
						}
						if (!eliminarLista.isEmpty()) {
							Messagebox
									.show("�Desea Eliminar los "
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
														listaGeneral = servicioF0006
																.buscarTodosOrdenados();
														catalogo.actualizarLista(listaGeneral);

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
						List<F0101> objetoF0101 = servicioF0101
								.buscarPorAbmcu(clave);
						List<F4100> objetoF4100 = servicioF4100
								.buscarPorMcu(clave);
						List<F4105> objetoF4105 = servicioF4105
								.buscarPorMcu(clave);
						List<F4930> objetoF4930 = servicioF4930
								.buscarPorMcu(clave);
						List<F49041> objetoF49041 = servicioF49041
								.buscarPorMcu(clave);
						if (objetoF0101.isEmpty() && objetoF4100.isEmpty()
								&& objetoF4105.isEmpty()
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
														servicioF0006
																.eliminarUno(clave);
														msj.mensajeInformacion(Mensaje.eliminado);
														limpiar();
														listaGeneral = servicioF0006
																.buscarTodosOrdenados();
														catalogo.actualizarLista(listaGeneral);
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
		botoneraF0006.appendChild(botonera);

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

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		btnBuscarCompannia.setVisible(true);
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

		if (!camposLLenos()) {
			msj.mensajeError(Mensaje.camposVacios);
			return false;
		} else {
			if (buscarCompania()) {
				return true;
			} else
				return false;
		}
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
		txtAN8F0006.setValue(null);
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
		lblDescripcionF0006.setValue("");
		lblDescripcionF0101.setValue("");
		catalogo.limpiarSeleccion();
		btnBuscarCompannia.setVisible(true);
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
		listaGeneral = servicioF0006.buscarTodosOrdenados();
		catalogo = new CatalogoGenerico<F0006>(catalogoF0006, "F0006",
				listaGeneral, false, true, true, "Unidad Negocio",
				"Descripcion", "Nivel det", "Cta", "Tipo UN",
				"LM Auxiliar Inactivo", "Mto Cons", "CAT 01", "CAT 02",
				"CAT 03", "CAT 04", "CAT 05", "CAT 06") {

			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : listaGeneral) {
					String mcdc = "";
					if (unidad.getMcdc() != null)
						mcdc = unidad.getMcdc();
					if (unidad.getMcmcu().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& unidad.getMcdl01().toLowerCase().contains(
									valores.get(1).toLowerCase())
							&& unidad.getMcldm().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& unidad.getMcco().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& unidad.getMcstyl().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& unidad.getMcfmod().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& unidad.getMcsbli().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& unidad.getMcrp01().toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& unidad.getMcrp02().toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& unidad.getMcrp03().toLowerCase()
									.contains(valores.get(9).toLowerCase())
							&& unidad.getMcrp04().toLowerCase()
									.contains(valores.get(10).toLowerCase())
							&& unidad.getMcrp05().toLowerCase()
									.contains(valores.get(11).toLowerCase())
							&& unidad.getMcrp06().toLowerCase()
									.contains(valores.get(12).toLowerCase())) {
						unidadnegocio.add(unidad);
					}
				}
				return unidadnegocio;
			}

			@Override
			protected String[] crearRegistros(F0006 negocio) {
				String[] registros = new String[13];
				registros[0] = negocio.getMcmcu();
				registros[1] = negocio.getMcdl01();
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
		catalogoF0010 = new CatalogoGenerico<F0010>(divCatalogoF0010,
				"Catalogo de Compa��as", lista, true, false, false, "Codigo",
				"Nombre", "N� Periodo", "Patron", "Inicio a�o Fiscal",
				"Periodo LM", "Inicio a�o C/P", "Periodo C/P",
				"Inicio a�o C/C", "Periodo C/C") {

			@Override
			protected List<F0010> buscar(List<String> valores) {

				List<F0010> lista2 = new ArrayList<F0010>();

				for (F0010 f0010 : lista) {
					String ccdot = "";
					if (f0010.getCcdot1() != null)
						ccdot = f0010.getCcdot1();
					if (f0010.getCcco().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f0010.getCcname().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& String.valueOf(f0010.getCcpnc()).toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& ccdot.toLowerCase().contains(
									valores.get(3).toLowerCase())
							&& f0010.getCcarfj().toString().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& String.valueOf(f0010.getCctxbm()).toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& f0010.getCcapfj().toString().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& String.valueOf(f0010.getCctxbo()).toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& f0010.getCcdfyj().toString().toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& String.valueOf(f0010.getCcpnf()).toLowerCase()
									.contains(valores.get(9).toLowerCase())) {
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

	@Listen("onChange = #txtCOF0006; onOK = #txtCOF0006")
	public boolean buscarCompania() {
		if (txtCOF0006.getValue() != null) {
			F0010 f0010 = servicioF0010.buscar(txtCOF0006.getValue());
			if (f0010 != null) {
				txtCOF0006.setValue(f0010.getCcco());
				lblDescripcionF0010.setValue(servicioF0010.buscar(
						f0010.getCcco()).getCcname());
				return true;
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				return false;
			}
		} else
			return false;
	}

	@Listen("onClick = #btnBuscarDireccion")
	public void mostrarCatalogoF0101() {
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoF0101 = new CatalogoGenerico<F0101>(divCatalogoF0101,
				"Catalogo de Direcciones", listF0101, true, false, false,
				"N� direccion", "Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal") {

			@Override
			protected List<F0101> buscar(List<String> valores) {

				List<F0101> lista = new ArrayList<F0101>();

				for (F0101 f01 : listF0101) {
					if (String.valueOf(f01.getAban8()).toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f01.getAbalph().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& f01.getAbalky().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& f01.getAbsic().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& f01.getAbat1().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& f01.getAbtax().toLowerCase()
									.contains(valores.get(6).toLowerCase())) {
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
		txtAN8F0006.setValue(Math.round(f0101.getAban8()));
		lblDescripcionF0101.setValue(f0101.getAbalph());
		catalogoF0101.setParent(null);
	}

	@Listen("onChange = #txtAN8F0006; onOk = #txtAN8F0006 ")
	public boolean buscarDireccion() {
		if (txtAN8F0006.getValue() != null) {
			F0101 f0101 = servicioF0101.buscar(txtAN8F0006.getValue());
			if (f0101 != null) {
				Double doble = f0101.getAban8();
				txtAN8F0006.setValue(doble.longValue());
				lblDescripcionF0101.setValue(f0101.getAbalph());
				return true;
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				return false;
			}
		} else
			return false;
	}

	@Listen("onClick = #btnBuscarProyecto")
	public void mostrarCatalogoProyecto() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoEmergente = new CatalogoGenerico<F0006>(
				divCatalogoF0006Emergente, "Catalogo de Unidades de Negocio",
				unidades, true, false, false, "Unidad Negocio", "Descripcion",
				"Nivel det", "Cta", "Tipo UN", "LM Auxiliar Inactivo",
				"Mto Cons", "CAT 01", "CAT 02", "CAT 03", "CAT 04", "CAT 05",
				"CAT 06") {

			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					String mcdc = "";
					if (unidad.getMcdc() != null)
						mcdc = unidad.getMcdc();
					if (unidad.getMcmcu().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& mcdc.toLowerCase().contains(
									valores.get(1).toLowerCase())
							&& unidad.getMcldm().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& unidad.getMcco().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& unidad.getMcstyl().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& unidad.getMcfmod().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& unidad.getMcsbli().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& unidad.getMcrp01().toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& unidad.getMcrp02().toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& unidad.getMcrp03().toLowerCase()
									.contains(valores.get(9).toLowerCase())
							&& unidad.getMcrp04().toLowerCase()
									.contains(valores.get(10).toLowerCase())
							&& unidad.getMcrp05().toLowerCase()
									.contains(valores.get(11).toLowerCase())
							&& unidad.getMcrp06().toLowerCase()
									.contains(valores.get(12).toLowerCase())) {
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

	@Listen("onChange = #txtMCUSF0006; onOk = #txtMCUSF0006")
	public boolean buscarProyecto() {
		if (txtMCUSF0006.getValue() != null) {
			F0006 f0006 = servicioF0006.buscar(txtMCUSF0006.getValue());
			if (f0006 != null) {
				txtMCUSF0006.setValue(f0006.getMcmcu());
				lblDescripcionF0006.setValue(f0006.getMcdl01());
				return true;
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				return false;
			}
		} else
			return false;
	}

}
