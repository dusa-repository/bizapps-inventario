package controlador.reporte;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelo.maestros.F0006;
import modelo.maestros.F4101;
import modelo.maestros.F4102;
import modelo.maestros.F41021;
import modelo.pk.F4102PK;
import modelo.transacciones.F4111;
import modelo.transacciones.F4211;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.catalogos.CatalogoF0006;
import componentes.catalogos.CatalogoGenerico;
import controlador.maestros.CGenerico;

public class CRStock extends CGenerico {

	private static final long serialVersionUID = 3717486322339831419L;
	@Wire
	private Radio rdoMaximo;
	@Wire
	private Radio rdoOrden;
	@Wire
	private Radio rdoMinimo;
	@Wire
	private Radio rdoSeguridad;
	@Wire
	private Div botoneraVStock;
	@Wire
	private Textbox txtCompany;
	@Wire
	private Label lblCompany;
	@Wire
	private Combobox cmbReportType;
	@Wire
	private Div catalogoCompanyF0006;
	@Wire
	private Div divVStock;
	String company = "%";
	Botonera botonera;
	CatalogoF0006 catalogo;

	@SuppressWarnings("unchecked")
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
		botonera = new Botonera() {

			private static final long serialVersionUID = 8569742912403586485L;

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void salir() {
				cerrarVentana(divVStock, titulo, tabs);
			}

			@Override
			public void reporte() {
				if (validar()) {
					String tipoReporte = cmbReportType.getValue();
					String type = null;
					List<F41021> lista = new ArrayList<F41021>();
					if (rdoMaximo.isChecked()) {
						lista = servicioF41021.buscarExistenciaMaxima(company);
						type = "1";
					}
					if (rdoMinimo.isChecked()) {
						lista = servicioF41021.buscarExistenciaMinima(company);
						type = "2";
					}
					if (rdoOrden.isChecked()) {
						lista = servicioF41021.buscarOrdenMinimo(company);
						type = "3";
					}
					if (rdoSeguridad.isChecked()) {
						lista = servicioF41021.buscarSeguridadMinimo(company);
						type = "4";
					}
					String value = "";
					if (company.equals("%"))
						value = "TODOS";
					else
						value = company;
					if (!lista.isEmpty())
						Clients.evalJavaScript("window.open('"
								+ damePath()
								+ "Generador?valor=3&valor2="
								+ value
								+ "&valor3="
								+ type
								+ "&valor20="
								+ tipoReporte
								+ "','','top=100,left=200,height=600,width=800,scrollbars=1,resizable=1')");
					else
						Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
				}
			}

			@Override
			public void limpiar() {
				company = "%";
				txtCompany.setValue("");
				lblCompany.setValue("");
			}

			@Override
			public void guardar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub

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
				// TODO Auto-generated method stub

			}
		};
		botonera.getChildren().get(0).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(4).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botoneraVStock.appendChild(botonera);
	}

	protected boolean validar() {
		if (!rdoMaximo.isChecked() && !rdoMinimo.isChecked()
				&& !rdoOrden.isChecked() && !rdoSeguridad.isChecked()) {
			Mensaje.mensajeAlerta("Debe seleccionar una opcion; Por debajo de o Por encima de");
			return false;
		} else
			return true;
	}

	@Listen("onCheck = #rdoOrden,#rdoMinimo,#rdoSeguridad")
	public void quitar() {
		if (rdoMaximo.isChecked())
			rdoMaximo.setChecked(false);
	}

	@Listen("onCheck = #rdoMaximo")
	public void quitar2() {
		if (rdoOrden.isChecked() || rdoMinimo.isChecked()
				|| rdoSeguridad.isChecked()) {
			rdoOrden.setChecked(false);
			rdoMinimo.setChecked(false);
			rdoSeguridad.setChecked(false);
		}
	}

	@Listen("onClick = #btnFindCompany")
	public void mostrarCatalogoF0006() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogo = new CatalogoF0006(catalogoCompanyF0006,
				"Catalogo de Sucursales (F0006)", unidades, true,
				"Unidad Negocio", "Descripcion", "Nivel det", "Cta", "Tipo UN",
				"LM Auxiliar Inactivo", "Mto Cons", "CAT 01", "CAT 02",
				"CAT 03", "CAT 04", "CAT 05", "CAT 06");
		catalogo.setParent(catalogoCompanyF0006);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoCompanyF0006")
	public void seleccionarSucursal() {
		F0006 f06 = catalogo.objetoSeleccionadoDelCatalogo();
		setearPlanta(f06, txtCompany, lblCompany);
		catalogo.setParent(null);
	}

	@Listen("onChange = #txtCompany; onOK= #txtCompany ")
	public void buscarNombreSucursal() {
		F0006 f06 = new F0006();
		f06 = servicioF0006.buscar(txtCompany.getValue());
		if (f06 != null) {
			setearPlanta(f06, txtCompany, lblCompany);
		} else {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			txtCompany.setValue("");
			txtCompany.setFocus(true);
			lblCompany.setValue("");
			company = "";
		}

	}

	private void setearPlanta(F0006 f06, Textbox txtPlanta12, Label lblPlanta12) {
		company = f06.getMcmcu();
		txtPlanta12.setValue(f06.getMcmcu());
		lblPlanta12.setValue(f06.getMcdl01());
	}

	public byte[] reportOfStock(String part2, String part3, String tipo) {
		byte[] fichero = null;
		if (part2.equals("TODOS"))
			part2 = "%";
		Map<String, Object> p = new HashMap<String, Object>();
		List<F41021> lista = new ArrayList<F41021>();
		switch (part3) {
		case "1":
			lista = getServicioF41021().buscarExistenciaMaxima(part2);
			p.put("titulo", "ITEMS CON STOCK MAXIMO POR ENCIMA DEL ESTABLECIDO");
			break;

		case "2":
			lista = getServicioF41021().buscarExistenciaMinima(part2);
			p.put("titulo", "ITEMS CON STOCK MINIMO POR DEBAJO DEL ESTABLECIDO");
			break;

		case "3":
			lista = getServicioF41021().buscarOrdenMinimo(part2);
			p.put("titulo", "ITEMS CON PUNTO DE REORDEN POR DEBAJO DEL ESTABLECIDO");
			break;

		case "4":
			lista = getServicioF41021().buscarSeguridadMinimo(part2);
			p.put("titulo", "ITEMS CON STOCK DE SEGURIDAD POR DEBAJO DEL ESTABLECIDO");
			break;
		}

		for (Iterator<F41021> iterator = lista.iterator(); iterator.hasNext();) {
			F41021 f41021 = (F41021) iterator.next();
			F4102PK key = new F4102PK();
			key.setIbitm(f41021.getId().getLiitm());
			key.setIbmcu(f41021.getId().getLimcu());
			F4102 object = getServicioF4102().buscar(key);
			if (object != null) {
				switch (part3) {
				case "1":
					f41021.setLifcom(object.getIbanpl());
					break;
				case "2":
					f41021.setLifcom(object.getIbavrt());
					break;
				case "3":
					f41021.setLifcom(object.getIbbqty());
					break;
				case "4":
					f41021.setLifcom(object.getIbcarp());
					break;
				}
				f41021.setLicfgsid(object.getIbaitm());
			}
		}

		JasperReport repor = null;
		try {
			repor = (JasperReport) JRLoader.loadObject(getClass().getResource(
					"/reporte/RStock.jasper"));
		} catch (JRException e1) {
			e1.printStackTrace();
		}

		if (tipo.equals("EXCEL")) {

			JasperPrint jasperPrint = null;
			try {
				jasperPrint = JasperFillManager.fillReport(repor, p,
						new JRBeanCollectionDataSource(lista));
			} catch (JRException e) {
				Mensaje.mensajeError("Error en Reporte"
						+ e.getLocalizedMessage());
			}
			ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, xlsReport);
			try {
				exporter.exportReport();
			} catch (JRException e) {
				Mensaje.mensajeError("Error en Reporte"
						+ e.getLocalizedMessage());
			}
			return xlsReport.toByteArray();
		} else {
			try {
				fichero = JasperRunManager.runReportToPdf(repor, p,
						new JRBeanCollectionDataSource(lista));
			} catch (JRException e) {
				Mensaje.mensajeError("Error en Reporte"
						+ e.getLocalizedMessage());
			}
			return fichero;
		}
	}

}
