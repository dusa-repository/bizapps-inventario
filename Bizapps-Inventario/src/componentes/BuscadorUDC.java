package componentes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0004;
import modelo.maestros.F0005;
import modelo.maestros.F0013;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;

import arbol.CArbol;

import servicio.maestros.SF0004;
import servicio.maestros.SF0005;

import controlador.maestros.CGenerico;

public abstract class BuscadorUDC extends Hbox {
	Mensaje msj = new Mensaje();
	Catalogo<F0005> catalogo;
	Div divCatalogo;
	List<F0005> lista;
	Textbox cajaTexto;
	Label nombre;
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"/META-INF/ConfiguracionAplicacion.xml");

	public static SF0004 getServicioF4() {
		return applicationContext.getBean(SF0004.class);
	}
	public BuscadorUDC(String etiqueta, int longitud, List<F0005> lista2,
			boolean requerido, boolean param1, boolean param2) {
		super();
		this.setWidth("100%");

		Label label = new Label(etiqueta + " :");
		label.setClass("etiqueta");
		label.setWidth("auto");
		label.setHflex("1");
		label.setStyle("color:#636363");

		cajaTexto = new Textbox();
		cajaTexto.setHflex("1");
		// cajaTexto.setReadonly(true);
		cajaTexto.setMaxlength(longitud);
		cajaTexto
				.setTooltiptext("Seleccione del Catalogo el Codigo del Producto");
		cajaTexto.setWidth("10px");
		cajaTexto.setHflex("1");

		Button boton = new Button();
		boton.setTooltiptext("Buscar");
		boton.setSrc("/public/imagenes/botones/buscar.png");
		boton.setWidth("auto");

		nombre = new Label();
		nombre.setWidth("auto");
		nombre.setHflex("1");

		divCatalogo = new Div();
		divCatalogo.setTooltiptext("Click para Seleccionar un Codigo");

		if (requerido) {
			Hbox caja = new Hbox();
			Label lbl = new Label("*");
			lbl.setStyle("font-weight:bold;color:red");
			caja.appendChild(label);
			caja.appendChild(new Space());
			caja.appendChild(lbl);
			caja.setWidth("auto");
			caja.setHflex("1");
			this.appendChild(caja);
		} else
			this.appendChild(label);
		this.appendChild(cajaTexto);
		this.appendChild(boton);
		this.appendChild(nombre);
		this.appendChild(divCatalogo);
		this.setAlign("center");
		this.setPack("center");
		this.setWidths("46%,2%,2%,50%,0%");

		cajaTexto.addEventListener(Events.ON_CHANGE,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						buscarPorTexto();
					}
				});

		boton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				mostrarCatalogo();
			}
		});
		divCatalogo.addEventListener("onSeleccion", new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				seleccionarItem();
			}
		});
		lista = lista2;
	}

	protected void buscarPorTexto() {
		F0005 f0005 = buscar();
		if (f0005 != null) {
			cajaTexto.setValue(f0005.getId().getDrky());
			nombre.setValue(f0005.getDrdl01());
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			cajaTexto.setValue("");
			nombre.setValue("");
			cajaTexto.setFocus(true);
		}
	}

	// Debe contener un servicio que busca un valor de la clave
	protected abstract F0005 buscar();

	public void seleccionarItem() {
		F0005 f0005 = catalogo.objetoSeleccionadoDelCatalogo();
		cajaTexto.setValue(f0005.getId().getDrky());
		nombre.setValue(f0005.getDrdl01());
		catalogo.setParent(null);
	}

	public void inhabilitarCampo() {
		cajaTexto.setDisabled(true);
	}

	public void focus() {
		cajaTexto.setFocus(true);
	}

	public void habilitarCampos() {
		if (cajaTexto.isDisabled()) {
			cajaTexto.setDisabled(false);
		}
	}

	public String obtenerCaja() {
		return cajaTexto.getValue();
	}

	public void settearCampo(F0005 f0005) {
		if (f0005 != null) {
			cajaTexto.setValue(f0005.getId().getDrky());
			nombre.setValue(f0005.getDrdl01());
		} else {
			cajaTexto.setValue("");
			nombre.setValue("");
		}
	}

	private void mostrarCatalogo() {

		final List<F0005> listF0005 = lista;
		
		catalogo = new Catalogo<F0005>(divCatalogo, "CatF0005", listF0005,
				true, true, false, "KY", "Descripcion 01",
				"Descripcion 02", "Gestion Especial", "Codificacion Fija") {
			
			@Override
			protected List<F0005> buscar(List<String> valores) {

				List<F0005> listF0005_2 = new ArrayList<F0005>();

				for (F0005 f0005 : listF0005) {
					if (f0005.getId().getDrky().toLowerCase()
									.startsWith(valores.get(0))
							&& f0005.getDrdl01().toLowerCase()
									.startsWith(valores.get(1))
							&& f0005.getDrdl02().toLowerCase()
									.startsWith(valores.get(2))
							&& f0005.getDrsphd().toLowerCase()
									.startsWith(valores.get(3))
							&& f0005.getDrhrdc().toLowerCase()
									.startsWith(valores.get(4))) {
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
		};
		if(!listF0005.isEmpty()){
			F0004 f004 = getServicioF4().buscar(listF0005.get(0).getId().getDrsy(), listF0005.get(0).getId().getDrrt());
			System.out.println(f004);
			catalogo.settearCamposUdc(f004);
		}
		catalogo.setParent(divCatalogo);
		catalogo.doModal();
	}

}
