package componentes.buscadores;

import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Space;
import org.zkoss.zul.impl.InputElement;

import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;

public abstract class BuscadorGenerico<Modelo, TipoSalida, Servicio, Campo extends InputElement, TipoCatalogo extends CatalogoGenerico<Modelo>>
		extends Hbox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TipoCatalogo catalogo;
	protected Div divCatalogo;
	private Label lblNombre;
	protected Campo cajaTexto;
	private List<Modelo> lista;
	private Button boton;
	protected Servicio servicio;

	public BuscadorGenerico(String etiqueta, boolean requerido,
			String tooltipCajaTexto, String tooltipBoton,
			String tooltipCatalogo, int longitud, Servicio servicio,
			String ancho1, String ancho2, String ancho3, String ancho4) {

		this.servicio = servicio;
		this.setWidth("100%");
		this.setSpacing("10em");

		cargarLabel(etiqueta, requerido, ancho1);
		cargarCampo(longitud, tooltipCajaTexto, ancho2);
		cargarBoton(tooltipBoton, ancho3);
		cargarLabelNombre(ancho4);
		setWidths(ancho1 + "," + ancho2 + "," + ancho3 + "," + ancho4);
		cargarDivCatalogo(tooltipCatalogo);

		this.setAlign("center");
		this.setPack("center");
	}

	private void cargarLabel(String etiqueta, boolean requerido, String ancho) {
		Label label = new Label(etiqueta + " :");
		label.setClass("etiqueta");
		Hbox hbox = new Hbox();
		hbox.appendChild(label);
		hbox.setWidth("100%");
		if (requerido) {
			hbox.appendChild(new Space());
			Label asterisco = new Label("*");
			asterisco.setStyle("font-weight:bold;color:red");
			hbox.appendChild(asterisco);
		}
//		Cell cell = new Cell();
//		cell.setWidth(ancho);
//		cell.appendChild(hbox);
//		this.appendChild(cell);
		this.appendChild(hbox);
	}

	private void cargarCampo(int longitud, String tooltipCajaTexto, String ancho) {
		cajaTexto = inicializarCampo();
		cajaTexto.setTooltiptext(tooltipCajaTexto);
		cajaTexto.setWidth("100%");
		cajaTexto.setMaxlength(longitud);
		cajaTexto.addEventListener(Events.ON_OK, new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				buscarPorTexto();
			}
		});
		cajaTexto.addEventListener(Events.ON_CHANGE,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event event) throws Exception {
						buscarPorTexto();
					}
				});
//		Cell cell = new Cell();
//		cell.setWidth(ancho);
//		cell.appendChild(cajaTexto);
//		this.appendChild(cell);
		this.appendChild(cajaTexto);
	}

	protected void buscarPorTexto() {
		Modelo modelo = buscar();
		if (modelo != null) {
			cajaTexto.setText(valorAMostrarEnCajaTexto(modelo));
			lblNombre.setValue(valorAMostrarEnLabel(modelo));
		} else {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			cajaTexto.setText("");
			lblNombre.setValue("");
			cajaTexto.setFocus(true);
		}
	}

	protected Modelo buscar() {
		return buscarEnServicio(obtenerCaja());
	}

	protected abstract Campo inicializarCampo();

	private void cargarBoton(String tooltipBoton, String ancho) {
		boton = new Button();
		boton.setAutodisable("true");
		boton.setTooltiptext(tooltipBoton);
		boton.setLabel("Buscar");
		boton.setImage("/public/imagenes/botones/buscar.png");
		boton.setClass("btn");
		boton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				mostrarCatalogo();
			}
		});
//		Cell cell = new Cell();
//		cell.setWidth(ancho);
//		cell.appendChild(boton);
//		this.appendChild(cell);
		this.appendChild(boton);
	}

	private void mostrarCatalogo() {
		catalogo = crearCatalogo();
		catalogo.setParent(divCatalogo);
		catalogo.doModal();
	}

	protected abstract TipoCatalogo crearCatalogo();

	private void cargarLabelNombre(String ancho) {
		lblNombre = new Label();
		lblNombre.setWidth("100%");
//		Cell cell = new Cell();
//		cell.setWidth(ancho);
//		cell.appendChild(lblNombre);
//		this.appendChild(cell);
		this.appendChild(lblNombre);
	}

	private void cargarDivCatalogo(String tooltipCatalogo) {
		divCatalogo = new Div();
		divCatalogo.setTooltiptext(tooltipCatalogo);
		divCatalogo.addEventListener("onSeleccion", new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				seleccionarItem();
			}
		});
		this.appendChild(divCatalogo);
	}

	public void seleccionarItem() {
		Modelo modelo = catalogo.objetoSeleccionadoDelCatalogo();
		cajaTexto.setText(valorAMostrarEnCajaTexto(modelo));
		lblNombre.setValue(valorAMostrarEnLabel(modelo));
		catalogo.setParent(null);
	}

	protected abstract String valorAMostrarEnCajaTexto(Modelo modelo);

	protected abstract String valorAMostrarEnLabel(Modelo modelo);

	protected List<Modelo> getLista() {
		if (lista == null)
			lista = listaInicial();
		return lista;
	}

	protected abstract List<Modelo> listaInicial();

	public void settearCampo(TipoSalida valorBusqueda) {
		Modelo modelo = buscarEnServicio(valorBusqueda);
		settearModelo(modelo);
	}

	protected abstract Modelo buscarEnServicio(TipoSalida valorBusqueda);

	public void settearModelo(Modelo modelo) {
		if (modelo != null) {
			cajaTexto.setText(valorAMostrarEnCajaTexto(modelo));
			lblNombre.setValue(valorAMostrarEnLabel(modelo));
		} else {
			cajaTexto.setText("");
			lblNombre.setValue("");
		}
	}

	public void limpiarCampo() {
		settearCampo(null);
	}

	public abstract TipoSalida obtenerCaja();

	public void focus() {
		cajaTexto.setFocus(true);
	}

	public void inhabilitarCampo() {
		cajaTexto.setDisabled(true);
		boton.setVisible(false);
	}

	public void habilitarCampos() {
		if (cajaTexto.isDisabled()) {
			cajaTexto.setDisabled(false);
		}
		if (!boton.isVisible()) {
			boton.setVisible(true);
		}
	}

}
