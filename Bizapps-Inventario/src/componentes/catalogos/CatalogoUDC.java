package componentes.catalogos;

import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0004;
import modelo.maestros.F0005;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.impl.XulElement;

import controlador.maestros.CGenerico;
import servicio.maestros.SF0004;

public class CatalogoUDC extends CatalogoGenerico<F0005> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Label labelSYNombre;
	private Label labelRTNombre;
	private Textbox txtSY;
	private Textbox txtRT;
	private Label labelBuscado;

	public CatalogoUDC(Component div, String valor1, String valor2,
			String titulo, List<F0005> lista, String... campos) {
		super(div, titulo, lista, true, campos);
		settearCamposUdc(valor1, valor2);
	}

	@Override
	protected List<F0005> buscar(List<String> valores) {
		List<F0005> listF0005_2 = new ArrayList<F0005>();
		for (F0005 f0005 : getLista()) {
			if (f0005.getId().getDrky().toLowerCase()
					.contains(valores.get(0).toLowerCase())
					&& f0005.getDrdl01().toLowerCase()
							.contains(valores.get(1).toLowerCase())
					&& f0005.getDrdl02().toLowerCase()
							.contains(valores.get(2).toLowerCase())
					&& f0005.getDrsphd().toLowerCase()
							.contains(valores.get(3).toLowerCase())
					&& f0005.getDrhrdc().toLowerCase()
							.contains(valores.get(4).toLowerCase())) {
				listF0005_2.add(f0005);
			}
		}
		return listF0005_2;
	}

	@Override
	protected String[] crearRegistros(F0005 f0005) {
		String[] registros = new String[5];
		registros[0] = f0005.getId().getDrky();
		registros[1] = f0005.getDrdl01();
		registros[2] = f0005.getDrdl02();
		registros[3] = f0005.getDrsphd();
		registros[4] = f0005.getDrhrdc();
		return registros;
	}

	private void settearCamposUdc(String valor1, String valor2) {
		F0004 f004 = CGenerico.getServicioF4().buscar(valor1, valor2);
		if (f004 != null) {
			txtSY.setValue(f004.getId().getDtsy());
			labelBuscado.setValue(f004.getDtdl01());
			txtRT.setValue(f004.getId().getDtrt());
		} else {
			txtSY.setValue(valor1);
			labelBuscado.setValue("Tipo UDC NO REGISTRADA AUN");
			txtRT.setValue(valor2);
		}
	}

	protected XulElement encabezado() {
		Div div = new Div();
		div.appendChild(crearEncabezadoUDC());
		return div;
	}

	private Vbox crearEncabezadoUDC() {
		Vbox vbox = new Vbox();
		vbox.setStyle("background: #FFFFFF;");
		vbox.setWidth("100%");
		vbox.setAlign("center");
		vbox.setPack("center");
		vbox.appendChild(new Separator());
		vbox.appendChild(crearFila1UDC());
		vbox.appendChild(crearFila2UDC());
		vbox.appendChild(new Separator());
		return vbox;
	}

	private Hbox crearFila1UDC() {
		labelSYNombre = new Label("Cd producto: ");
		labelSYNombre.setClass("etiqueta");
		Space space1 = new Space();
		space1.setWidth("9px");
		txtSY = new Textbox();
		txtSY.setReadonly(true);
		Hbox hbox = new Hbox();
		hbox.setWidth("100%");
		hbox.setHeight("12px");
		hbox.setAlign("start");
		hbox.setPack("start");
		hbox.appendChild(labelSYNombre);
		hbox.appendChild(space1);
		hbox.appendChild(txtSY);
		hbox.appendChild(new Label());
		return hbox;
	}

	private Hbox crearFila2UDC() {
		labelRTNombre = new Label("Cd def Usuario: ");
		labelRTNombre.setClass("etiqueta");
		txtRT = new Textbox();
		txtRT.setReadonly(true);
		Space space = new Space();
		space.setWidth("10px");
		labelBuscado = new Label();
		Hbox hbox = new Hbox();
		hbox.setWidth("100%");
		hbox.setHeight("12px");
		hbox.appendChild(labelRTNombre);
		hbox.appendChild(txtRT);
		hbox.appendChild(space);
		hbox.appendChild(labelBuscado);
		hbox.setAlign("center");
		hbox.setPack("center");
		return hbox;
	}

}
