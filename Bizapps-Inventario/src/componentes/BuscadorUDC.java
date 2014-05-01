package componentes;

import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0004;
import modelo.maestros.F0005;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;


public abstract class BuscadorUDC extends Hbox {
	
	Catalogo<F0005> catalogo;
	Div divCatalogo;
	List<F0005> lista;
	Textbox cajaTexto;
	Label nombre;
	
	public BuscadorUDC(String etiqueta, int longitud, List<F0005> lista2) {
		super();
		this.setWidth("100%");
		Label label = new Label(etiqueta+" :");
		label.setClass("etiqueta");
		
		cajaTexto = new Textbox();
		cajaTexto.setHflex("1");
		cajaTexto.setReadonly(true);
		cajaTexto.setMaxlength(longitud);
		cajaTexto.setTooltiptext("Seleccione del Catalogo el Codigo del Producto");
		
		Button boton = new Button();
		boton.setTooltiptext("Buscar");
		boton.setSrc("/public/imagenes/botones/buscar.png");
		
		nombre = new Label();
		nombre.setClass("etiqueta");
		
		divCatalogo = new Div();
		divCatalogo.setTooltiptext("Click para Seleccionar un Codigo");
		
		this.appendChild(label);
		this.appendChild(cajaTexto);
		this.appendChild(boton);
		this.appendChild(nombre);
		this.appendChild(divCatalogo);
		this.setWidths("15%,20%,15%,50%");
		
		boton.addEventListener(Events.ON_CLICK,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						mostrarCatalogo();
					}
				});
		divCatalogo.addEventListener("onSeleccion",
				new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				seleccionarItem();
			}
		});
		lista = lista2;
	}

	public F0005 seleccionarItem() {
		System.out.println("Toco");
		F0005 f0005 = catalogo.objetoSeleccionadoDelCatalogo();
		cajaTexto.setValue(f0005.getId().getDrky());
		nombre.setValue(f0005.getDrdl01());
		catalogo.setParent(null);
		return f0005;
	}

	private void mostrarCatalogo() {
		
		final List<F0005> listF0005 = lista;
		catalogo = new Catalogo<F0005>(divCatalogo, "CatF0005", listF0005, "SY",
				"RT", "KY", "Descripcion 01", "Descripcion 02",
				"Gestion Especial", "Codificacion Fija") {

			@Override
			protected List<F0005> buscar(List<String> valores) {

				List<F0005> listF0005_2 = new ArrayList<F0005>();

				for (F0005 f0005 : listF0005) {
					if (f0005.getId().getDrsy().toLowerCase()
							.startsWith(valores.get(0))
							&& f0005.getId().getDrrt().toLowerCase()
									.startsWith(valores.get(1))
							&& f0005.getId().getDrky().toLowerCase()
									.startsWith(valores.get(2))
							&& f0005.getDrdl01().toLowerCase()
									.startsWith(valores.get(3))
							&& f0005.getDrdl02().toLowerCase()
									.startsWith(valores.get(4))
							&& f0005.getDrsphd().toLowerCase()
									.startsWith(valores.get(5))
							&& f0005.getDrhrdc().toLowerCase()
									.startsWith(valores.get(6))) {
						listF0005_2.add(f0005);
					}
				}
				return listF0005_2;
			}

			@Override
			protected String[] crearRegistros(F0005 f0005) {
				String[] registros = new String[7];
				registros[0] = f0005.getId().getDrsy();
				registros[1] = f0005.getId().getDrrt();
				registros[2] = f0005.getId().getDrky();
				registros[3] = f0005.getDrdl01();
				registros[4] = f0005.getDrdl02();
				registros[5] = f0005.getDrsphd();
				registros[6] = f0005.getDrhrdc();
				return registros;
			}
		};
		catalogo.setClosable(true);
		catalogo.setWidth("80%");
		catalogo.setTitle("Registros");
		catalogo.setParent(divCatalogo);
		catalogo.doModal();
	}

	
}
