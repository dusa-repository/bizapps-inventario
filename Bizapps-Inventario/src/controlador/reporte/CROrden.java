package controlador.reporte;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.maestros.F4100;
import modelo.maestros.F4101;
import modelo.transacciones.F4111;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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
				List<F4111> ordenes = servicioF4111.buscarEntreFechas(desde,
						hasta);
				if (!ordenes.isEmpty()) {
					DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
					String fecha11 = fecha.format(dtbDesde.getValue());
					String fecha22 = fecha.format(dtbHasta.getValue());
					Clients.evalJavaScript("window.open('/Bizapps-Inventario/Generador?valor=1&valor2="
							+ fecha11
							+ "&valor3="
							+ fecha22
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

	public byte[] reporte(String par1, String part2) {
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
		List<F4111> ordenes = getServicioF4111().buscarEntreFechas(desde, hasta);
		for (int i = 0; i < ordenes.size(); i++) {
			Date fechaM = transformarJulianaAGregoria(ordenes.get(i)
					.getIlcrdj());
			ordenes.get(i).setIlasid(formatoFecha.format(fechaM));
			F4101 f = new F4101();
			if (ordenes.get(i).getIlitm() != null) {
				f = getServicioF4101().buscar(ordenes.get(i).getIlitm());
				ordenes.get(i).setIlplot(f.getImdsc1());
			} else
				ordenes.get(i).setIlplot("");
		}
		Map p = new HashMap();
		p.put("fecha1", fecha1);
		p.put("fecha2", fecha2);

		JasperReport repor = null;
		try {
			repor = (JasperReport) JRLoader.loadObject(getClass().getResource(
					"/reporte/ROrden.jasper"));
		} catch (JRException e1) {
			e1.printStackTrace();
		}
		try {
			fichero = JasperRunManager.runReportToPdf(repor, p,
					new JRBeanCollectionDataSource(ordenes));
		} catch (JRException e) {
			msj.mensajeError(Mensaje.errorEnReporte);
		}
		return fichero;
	}

}