package controlador.reporte;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.maestros.F4100;
import modelo.maestros.F4101;
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
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import controlador.maestros.CGenerico;

public class CROrden extends CGenerico {

	@Wire
	private Div divVOrden;
	@Wire
	private Div botoneraVOrden;
	@Wire
	private Datebox dtbDesde;
	@Wire
	private Datebox dtbHasta;
	@Wire
	private Combobox cmbTipo;
	@Wire
	private Combobox cmbEstado;
	@Wire
	private Combobox cmbDoc;

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
		Botonera botonera = new Botonera() {

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void salir() {
				cerrarVentana(divVOrden, "Reporte Orden", tabs);
			}

			@Override
			public void reporte() {
				BigDecimal desde = transformarGregorianoAJulia(dtbDesde
						.getValue());
				BigDecimal hasta = transformarGregorianoAJulia(dtbHasta
						.getValue());
				// List<F4111> ordenes = servicioF4111.buscarEntreFechas(desde,
				// hasta);

				List<F4211> ordenesPendiente = new ArrayList<F4211>();
				String estado = cmbEstado.getValue();
				List<F4111> ordenes = new ArrayList<F4111>();
				String tipo = cmbDoc.getValue();
				if (estado.equals("Despachadas")) {
					if (tipo.equals("TODOS"))
						ordenes = servicioF4111
								.buscarEntreFechas2(desde, hasta);
					else
						ordenes = servicioF4111.buscarEntreFechas2YTipo(desde,
								hasta, tipo);
				} else {
					if (tipo.equals("TODOS"))
						ordenesPendiente = servicioF4211
								.buscarEntreFechasYEstado(desde, hasta,
										"Enviada");
					else
						ordenesPendiente = servicioF4211
								.buscarEntreFechasYEstadoYTipo(desde, hasta,
										"Enviada", tipo);
				}

				String tipoReporte = cmbTipo.getValue();
				if ((!ordenes.isEmpty() && estado.equals("Despachadas"))
						|| (!ordenesPendiente.isEmpty() && estado
								.equals("Pendientes"))) {
					DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
					String fecha11 = fecha.format(dtbDesde.getValue());
					String fecha22 = fecha.format(dtbHasta.getValue());
					Clients.evalJavaScript("window.open('"
							+ damePath()
							+ "Generador?valor=1&valor2="
							+ fecha11
							+ "&valor3="
							+ fecha22
							+ "&valor4="
							+ estado
							+ "&valor5="
							+ tipo
							+ "&valor20="
							+ tipoReporte
							+ "','','top=100,left=200,height=600,width=800,scrollbars=1,resizable=1')");
				} else
					msj.mensajeAlerta(Mensaje.noHayRegistros);
			}

			@Override
			public void limpiar() {
				dtbDesde.setValue(fecha);
				dtbHasta.setValue(fecha);
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
		botoneraVOrden.appendChild(botonera);
	}

	public byte[] reporte(String par1, String part2, String tipoReporte,
			String estado, String tipoDoc) {
		byte[] fichero = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha1 = null;
		try {
			fecha1 = formato.parse(par1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date fecha2 = null;
		try {
			fecha2 = formato.parse(part2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BigDecimal desde = transformarGregorianoAJulia(fecha1);
		BigDecimal hasta = transformarGregorianoAJulia(fecha2);
		// List<F4111> ordenes = getServicioF4111().buscarEntreFechas(desde,
		// hasta);
		List<F4111> ordenes = new ArrayList<F4111>();
		List<F4211> ordenesPendiente = new ArrayList<F4211>();
		if (estado.equals("Despachadas")) {
			if (tipoDoc.equals("TODOS"))
				ordenes = getServicioF4111().buscarEntreFechas2(desde, hasta);
			else
				ordenes = getServicioF4111().buscarEntreFechas2YTipo(desde,
						hasta, tipoDoc);
			for (int i = 0; i < ordenes.size(); i++) {
				Date fechaM = transformarJulianaAGregoria(ordenes.get(i)
						.getIlvpej());
				ordenes.get(i).setIlasid(formatoFecha.format(fechaM));
				double costo = ordenes.get(i).getIlpaid();
				ordenes.get(i).setIlpaid(Math.rint(costo * 100) / 100);
				F4101 f = new F4101();
				if (ordenes.get(i).getIlitm() != null) {
					f = getServicioF4101().buscar(ordenes.get(i).getIlitm());
					ordenes.get(i).setIlplot(f.getImdsc1());
				} else
					ordenes.get(i).setIlplot("");
			}
		} else {
			if (tipoDoc.equals("TODOS"))
				ordenesPendiente = getServicioF4211().buscarEntreFechasYEstado(
						desde, hasta, "Enviada");
			else
				ordenesPendiente = getServicioF4211()
						.buscarEntreFechasYEstadoYTipo(desde, hasta, "Enviada",
								tipoDoc);
			ordenes = new ArrayList<F4111>();
			for (int i = 0; i < ordenesPendiente.size(); i++) {
				F4111 objeto = new F4111();
				Date fechaM = transformarJulianaAGregoria(ordenesPendiente.get(
						i).getSddrqj());
				objeto.setIlasid(formatoFecha.format(fechaM));
				double costo = ordenesPendiente.get(i).getSdecst();
				objeto.setIlpaid(Math.rint(costo * 100) / 100);
				F4101 f = new F4101();
				if (ordenesPendiente.get(i).getSditm() != null) {
					f = getServicioF4101().buscar(
							ordenesPendiente.get(i).getSditm());
					objeto.setIlplot(f.getImdsc1());
				} else
					objeto.setIlplot("");
				objeto.setIlmcu(ordenesPendiente.get(i).getSdmcu());
				objeto.setIllocn(ordenesPendiente.get(i).getSdlocn());
				objeto.setIldct(ordenesPendiente.get(i).getId().getSddcto());
				objeto.setIlitm(ordenesPendiente.get(i).getSditm());
				objeto.setIltrqt(ordenesPendiente.get(i).getSdpqor());
				objeto.setIldoc(ordenesPendiente.get(i).getSddoc());
				objeto.setIltrex(ordenesPendiente.get(i).getSdzon());
				ordenes.add(objeto);
			}
		}

		Map p = new HashMap();
		p.put("fecha1", fecha1);
		p.put("fecha2", fecha2);
		p.put("estado", estado);

		JasperReport repor = null;
		try {
			repor = (JasperReport) JRLoader.loadObject(getClass().getResource(
					"/reporte/ROrden2.jasper"));
		} catch (JRException e1) {
			e1.printStackTrace();
		}

		if (tipoReporte.equals("EXCEL")) {

			JasperPrint jasperPrint = null;
			try {
				jasperPrint = JasperFillManager.fillReport(repor, p,
						new JRBeanCollectionDataSource(ordenes));
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, xlsReport);
			try {
				exporter.exportReport();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return xlsReport.toByteArray();
		} else {
			try {
				fichero = JasperRunManager.runReportToPdf(repor, p,
						new JRBeanCollectionDataSource(ordenes));
			} catch (JRException e) {
				msj.mensajeError("Error en Reporte");
			}
			return fichero;
		}
	}

}
