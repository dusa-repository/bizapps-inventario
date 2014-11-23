package componentes.buscadores;

import java.util.List;

import org.zkoss.zul.Textbox;

import modelo.maestros.F0013;
import servicio.maestros.SF0013;
import componentes.catalogos.CatalogoF0013;

public class BuscadorF0013 extends
		BuscadorGenerico<F0013, String, SF0013, Textbox, CatalogoF0013> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuscadorF0013(String etiqueta, boolean requerido,
			String tooltipCajaTexto, String tooltipBoton,
			String tooltipCatalogo, int longitud, SF0013 servicio,
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
	protected CatalogoF0013 crearCatalogo() {
		CatalogoF0013 catalogo = new CatalogoF0013(divCatalogo, "F0013",
				getLista(), true, "Codigo moneda", "Descripcion", "Vlslz",
				"Rutina cheques");
		return catalogo;
	}

	@Override
	protected String valorAMostrarEnCajaTexto(F0013 modelo) {
		return modelo.getCvcrcd();
	};

	@Override
	protected String valorAMostrarEnLabel(F0013 modelo) {
		return modelo.getCvdl01();
	}

	@Override
	protected List<F0013> listaInicial() {
		return servicio.buscarTodosOrdenados();
	}

	@Override
	public String obtenerCaja() {
		return cajaTexto.getValue();
	}

	@Override
	protected F0013 buscarEnServicio(String valorBusqueda) {
		return servicio.buscar(valorBusqueda);
	}

}
