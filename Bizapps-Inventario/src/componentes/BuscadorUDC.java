package componentes;

import java.util.List;

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

import servicio.maestros.SF0005;

import componentes.catalogos.CatalogoUDC;

public abstract class BuscadorUDC extends Hbox {

	private static final long serialVersionUID = 1L;
	private CatalogoUDC catalogo;
	private Div divCatalogo;
	private List<F0005> lista;
	private Label lblNombre;
	private Textbox cajaTexto;
	private String valorP1;
	private String valorP2;
	private Button boton;
	private SF0005 servicio;

	public BuscadorUDC(String etiqueta, int longitud, List<F0005> lista2,
			boolean requerido, boolean param1, boolean param2,
			final String valor1, final String valor2, SF0005 servicio) {
		this(etiqueta, longitud, lista2, requerido, valor1, valor2, servicio);
	}

	public BuscadorUDC(String etiqueta, int longitud, List<F0005> lista2,
			boolean requerido, boolean param1, boolean param2,
			final String valor1, final String valor2) {
		this(etiqueta, longitud, lista2, requerido, valor1, valor2);
	}

	public BuscadorUDC(String etiqueta, int longitud, List<F0005> lista2,
			boolean requerido, String valor1, String valor2, SF0005 servicio) {
		this(etiqueta, longitud, lista2, requerido, valor1, valor2);
		this.servicio = servicio;
	}

	public BuscadorUDC(String etiqueta, int longitud, List<F0005> lista2,
			boolean requerido, String valor1, String valor2) {
		super();
		valorP1 = valor1;
		valorP2 = valor2;
		this.setWidth("100%");
		this.setSpacing("10em");
		Label label = new Label(etiqueta + " :");
		label.setClass("etiqueta");

		cajaTexto = new Textbox();
		cajaTexto.setTooltiptext("C�digo Definido por el Usuario (DRKY de "
				+ valor1 + "," + valor2 + ")");
		cajaTexto.setWidth("100%");
		cajaTexto.setMaxlength(longitud);

		boton = new Button();
		boton.setAutodisable("true");
		boton.setTooltiptext("Catalogo de Codigo Definidos por el Usuario"
				+ " " + "(" + valor1 + "," + valor2 + ")");
		boton.setLabel("Buscar");
		boton.setImage("/public/imagenes/botones/buscar.png");
		boton.setClass("btn");

		lblNombre = new Label();
		lblNombre.setWidth("100%");

		divCatalogo = new Div();
		divCatalogo.setTooltiptext("Click para Seleccionar un Codigo");

		if (requerido) {
			Hbox caja = new Hbox();
			Label lbl = new Label("*");
			lbl.setStyle("font-weight:bold;color:red");
			caja.appendChild(label);
			caja.appendChild(new Space());
			caja.appendChild(lbl);
			caja.setWidth("100%");
			this.appendChild(caja);
		} else {
			this.appendChild(label);
			label.setWidth("100%%o");
		}
		this.appendChild(cajaTexto);
		this.appendChild(boton);
		this.appendChild(lblNombre);
		this.appendChild(divCatalogo);
		this.setAlign("center");
		this.setPack("center");
		this.setWidths("30%,7%,7%,40%");

		cajaTexto.addEventListener(Events.ON_OK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				buscarPorTexto();
			}
		});

		boton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				mostrarCatalogo(valorP1, valorP2);
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
			lblNombre.setValue(f0005.getDrdl01());
		} else {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			cajaTexto.setValue("");
			lblNombre.setValue("");
			cajaTexto.setFocus(true);
		}
	}

	// Debe contener un servicio que busca un valor de la clave
	protected F0005 buscar() {
		return servicio.buscar(getValorP1(), getValorP2(), obtenerCaja());
	}

	public void seleccionarItem() {
		F0005 f0005 = catalogo.objetoSeleccionadoDelCatalogo();
		cajaTexto.setValue(f0005.getId().getDrky());
		lblNombre.setValue(f0005.getDrdl01());
		catalogo.setParent(null);
	}

	public void inhabilitarCampo() {
		cajaTexto.setDisabled(true);
		boton.setVisible(false);
	}

	public void focus() {
		cajaTexto.setFocus(true);
	}

	public void habilitarCampos() {
		if (cajaTexto.isDisabled()) {
			cajaTexto.setDisabled(false);
		}
		if (!boton.isVisible()) {
			boton.setVisible(true);
		}
	}

	public String obtenerCaja() {
		return cajaTexto.getValue();
	}

	public void settearCampo(F0005 f0005) {
		if (f0005 != null) {
			cajaTexto.setValue(f0005.getId().getDrky());
			lblNombre.setValue(f0005.getDrdl01());
		} else {
			cajaTexto.setValue("");
			lblNombre.setValue("");
		}
	}

	public void settearCampo(SF0005 servicioF0005, String valorBusqueda) {
		F0005 f0005 = servicioF0005.buscar(valorP1, valorP2, valorBusqueda);
		settearCampo(f0005);
	}

	public void limpiarCampo() {
		settearCampo(null);
	}

	private void mostrarCatalogo(String valor1, String valor2) {
		catalogo = new CatalogoUDC(divCatalogo, valor1, valor2,
				"Catalogo de C�digos Definidos por el Usuario (" + valorP1
						+ "," + valorP2 + ")", lista, "KY", "Descripcion 01",
				"Descripcion 02", "Gestion Especial", "Codificacion Fija");
		catalogo.setParent(divCatalogo);
		catalogo.doModal();
	}

	public String getValorP1() {
		return valorP1;
	}

	public String getValorP2() {
		return valorP2;
	}

}
