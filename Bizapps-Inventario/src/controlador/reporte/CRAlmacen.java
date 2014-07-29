package controlador.reporte;

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

import modelo.maestros.F4101;
import modelo.maestros.F4105;
import modelo.pk.F4105PK;
import modelo.transacciones.F4111;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Tab;

import componentes.Botonera;
import componentes.Mensaje;

import controlador.maestros.CGenerico;

public class CRAlmacen extends CGenerico {

	@Wire
	private Div divVAlmacen;
	@Wire
	private Div botoneraVAlmacen;
	@Wire
	private Datebox dtbFecha;
	private static final long serialVersionUID = 3154539496606898070L;

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
				cerrarVentana(divVAlmacen, "Reporte Almacen", tabs);
			}

			@Override
			public void reporte() {
				BigDecimal hasta = transformarGregorianoAJulia(dtbFecha
						.getValue());
				List<F4111> ordenes = servicioF4111.buscarHastaFecha(hasta);
				if (!ordenes.isEmpty()) {
					DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
					String fecha11 = fecha.format(dtbFecha.getValue());
					Clients.evalJavaScript("window.open('/Bizapps-Inventario/Generador?valor=2&valor2="
							+ fecha11
							+ "','','top=100,left=200,height=600,width=800,scrollbars=1,resizable=1')");
				} else
					msj.mensajeAlerta(Mensaje.noHayRegistros);
			}

			@Override
			public void limpiar() {
				// TODO Auto-generated method stub

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
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(4).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraVAlmacen.appendChild(botonera);
	}

	public byte[] reporte(String part2) {
		byte[] fichero = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha1 = null;
		try {
			fecha1 = formato.parse(part2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BigDecimal desde = transformarGregorianoAJulia(fecha1);
		List<F4111> ordenes = getServicioF4111().buscarHastaFecha(desde);
		List<F4111> finales = new ArrayList<F4111>();
		Date fechaMa = transformarJulianaAGregoria(ordenes.get(0).getIlcrdj());
		ordenes.get(0).setIlasid(formatoFecha.format(fechaMa));
		F4101 f = new F4101();
		if (ordenes.get(0).getIlitm() != null) {
			f = getServicioF4101().buscar(ordenes.get(0).getIlitm());
			ordenes.get(0).setIltrex(f.getImdsc1());
			ordenes.get(0).setIlplot(f.getImuom1());
		} else {
			ordenes.get(0).setIlplot("");
			ordenes.get(0).setIltrex("");
		}
		finales.add(ordenes.get(0));
		double valor = ordenes.get(0).getIlitm();
		String mcu = ordenes.get(0).getIlmcu();
		String lcon2 = ordenes.get(0).getIllocn();
		for (int i = 0; i < ordenes.size(); i++) {
			Date fechaM = transformarJulianaAGregoria(ordenes.get(i)
					.getIlcrdj());
			ordenes.get(i).setIlasid(formatoFecha.format(fechaM));
			f = new F4101();
			if (ordenes.get(i).getIlitm() != null) {
				f = getServicioF4101().buscar(ordenes.get(i).getIlitm());
				ordenes.get(i).setIltrex(f.getImdsc1());
				ordenes.get(i).setIlplot(f.getImuom1());
			} else {
				ordenes.get(i).setIlplot("");
				ordenes.get(i).setIltrex("");
			}
			if (ordenes.get(i).getIlitm() != valor) {
				finales.add(ordenes.get(i));
				valor = ordenes.get(i).getIlitm();
				mcu = ordenes.get(i).getIlmcu();
				lcon2 = ordenes.get(0).getIllocn();
			}
		}

		F4105 costo = new F4105();
		F4105PK claveCostoUnitario = new F4105PK();

		for (int i = 0; i < finales.size(); i++) {
			costo = new F4105();
			claveCostoUnitario = new F4105PK();
			double item = finales.get(i).getIlitm();
			String mcu2 = finales.get(i).getIlmcu();
			String locn = finales.get(i).getIllocn();
			claveCostoUnitario.setCoitm(item);
			claveCostoUnitario.setComcu(mcu2);
			claveCostoUnitario.setColocn(locn);
			claveCostoUnitario.setColotn("");
			claveCostoUnitario.setColedg("");
			costo = getServicioF4105().buscar(claveCostoUnitario);
			Double costoUnitario = (double) 0;
			if (costo != null)
				costoUnitario = costo.getCouncs();
			Double cantidad = getServicioF4111().sumar(item, mcu2, locn);
			finales.get(i).setIluncs(costoUnitario);
			finales.get(i).setIltrqt(cantidad);
			Double total = costoUnitario * cantidad;
			finales.get(i).setIlpaid(total);
		}
		Map p = new HashMap();
		p.put("fecha", fecha1);
		JasperReport repor = null;
		try {
			repor = (JasperReport) JRLoader.loadObject(getClass().getResource(
					"/reporte/RAlmacen.jasper"));
		} catch (JRException e1) {
			e1.printStackTrace();
		}
		try {
			fichero = JasperRunManager.runReportToPdf(repor, p,
					new JRBeanCollectionDataSource(finales));
		} catch (JRException e) {
			msj.mensajeError(Mensaje.errorEnReporte);
		}
		return fichero;
	}

}
