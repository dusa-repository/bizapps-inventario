package componentes.buscadores;

import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Textbox;

import modelo.maestros.F4301;
import modelo.pk.F4301PK;
import servicio.maestros.SF4301;
import componentes.catalogos.CatalogoF4301;

public class BuscadorF4301 extends
		BuscadorGenerico<F4301, String, SF4301, Textbox, CatalogoF4301> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private F4301PK clave = null;

	public BuscadorF4301(String etiqueta, boolean requerido,
			String tooltipCajaTexto, String tooltipBoton,
			String tooltipCatalogo, int longitud, SF4301 servicio,
			String ancho1, String ancho2, String ancho3, String ancho4) {
		super(etiqueta, requerido, tooltipCajaTexto, tooltipBoton,
				tooltipCatalogo, longitud, servicio, ancho1, ancho2, ancho3,
				ancho4);
		getCajaTexto().setReadonly(true);
	}

	@Override
	protected Textbox inicializarCampo() {
		return new Textbox();
	}

	@Override
	protected CatalogoF4301 crearCatalogo() {
		CatalogoF4301 catalogo = new CatalogoF4301(divCatalogo, "F4301",
				getLista(), true, "N° orden", "Tp ord", "Cía orden", "NP",
				"Descripción del proveedor", "Fecha orden", "Dir de entrg",
				"Comprador"
		// , "Cd rtn", "Importe", "Mon base",
		// "Impte en mon ext", "Mon", "Suc/planta"
		);
		return catalogo;
	}

	@Override
	protected String valorAMostrarEnCajaTexto(F4301 modelo) {
		clave = modelo.getId();
		return String.valueOf(clave.getPhdoco());
	};

	@Override
	protected String valorAMostrarEnLabel(F4301 modelo) {
		return getCatalogo().getServicioF0101().buscar(modelo.getPhan8())
				.getAbalph();
	}

	@Override
	protected List<F4301> listaInicial() {
		return servicio.buscarTodosOrdenados();
	}

	@Override
	public String obtenerCaja() {
		return cajaTexto.getValue();
	}

	@Override
	protected F4301 buscarEnServicio(String valorBusqueda) {
		List<F4301> lista = servicio.buscarDOCO(Double.valueOf(valorBusqueda));
		if (lista != null) {
			return lista.get(0);
		}
		return null;
	}

	@Override
	public void seleccionarItem() {
		super.seleccionarItem();
		Events.postEvent(this, new Event("onSeleccion"));
	}
}
