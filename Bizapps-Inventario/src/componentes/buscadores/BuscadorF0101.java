package componentes.buscadores;

import java.util.List;

import modelo.maestros.F0101;

import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Longbox;

import servicio.maestros.SF0101;
import componentes.catalogos.CatalogoF0101;

public class BuscadorF0101 extends
		BuscadorGenerico<F0101, Long, SF0101, Longbox, CatalogoF0101> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuscadorF0101(String etiqueta, boolean requerido,
			String tooltipCajaTexto, String tooltipBoton,
			String tooltipCatalogo, int longitud, SF0101 servicio,
			String ancho1, String ancho2, String ancho3, String ancho4) {
		super(etiqueta, requerido, tooltipCajaTexto, tooltipBoton,
				tooltipCatalogo, longitud, servicio, ancho1, ancho2, ancho3,
				ancho4);
	}

	@Override
	protected Longbox inicializarCampo() {
		return new Longbox();
	}

	@Override
	protected CatalogoF0101 crearCatalogo() {
		CatalogoF0101 catalogo = new CatalogoF0101(divCatalogo, "F0101",
				getLista(), true, "Nº direccion", "Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal");
		return catalogo;
	}

	@Override
	protected String valorAMostrarEnCajaTexto(F0101 modelo) {
		return String.format("%.0f", modelo.getAban8());
	};

	@Override
	protected String valorAMostrarEnLabel(F0101 modelo) {
		return modelo.getAbalph();
	}

	@Override
	protected List<F0101> listaInicial() {
		return servicio.buscarTodosOrdenados();
	}

	@Override
	public Long obtenerCaja() {
		return cajaTexto.getValue();
	}

	@Override
	protected F0101 buscarEnServicio(Long valorBusqueda) {
		return servicio.buscar(valorBusqueda);
	}

}
