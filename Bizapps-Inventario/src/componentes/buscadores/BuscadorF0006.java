package componentes.buscadores;

import java.util.List;

import org.zkoss.zul.Textbox;

import modelo.maestros.F0006;
import servicio.maestros.SF0006;
import componentes.catalogos.CatalogoF0006;

public class BuscadorF0006 extends
		BuscadorGenerico<F0006, String, SF0006, Textbox, CatalogoF0006> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuscadorF0006(String etiqueta, boolean requerido,
			String tooltipCajaTexto, String tooltipBoton,
			String tooltipCatalogo, int longitud, SF0006 servicio,
			String ancho1, String ancho2, String ancho3, String ancho4) {
		super(etiqueta, requerido, tooltipCajaTexto, tooltipBoton,
				tooltipCatalogo, longitud, servicio, ancho1, ancho2, ancho3,
				ancho4);
	}

	@Override
	protected Textbox inicializarCampo() {
		return new Textbox();
	}

	@Override
	protected CatalogoF0006 crearCatalogo() {
		CatalogoF0006 catalogo = new CatalogoF0006(divCatalogo, "F0006",
				getLista(), true, "UnitLdad Negocio", "Descripcion",
				"Nivel det", "Cta", "Tipo UN", "LM Auxiliar Inactivo",
				"Mto Cons", "CAT 01", "CAT 02", "CAT 03", "CAT 04", "CAT 05",
				"CAT 06");
		return catalogo;
	}

	@Override
	protected String valorAMostrarEnCajaTexto(F0006 modelo) {
		return modelo.getMcmcu();
	};

	@Override
	protected String valorAMostrarEnLabel(F0006 modelo) {
		return modelo.getMcdl01();
	}

	@Override
	protected List<F0006> listaInicial() {
		return servicio.buscarTodosOrdenados();
	}

	@Override
	public String obtenerCaja() {
		return cajaTexto.getValue();
	}

	@Override
	protected F0006 buscarEnServicio(String valorBusqueda) {
		return servicio.buscar(valorBusqueda);
	}

}
