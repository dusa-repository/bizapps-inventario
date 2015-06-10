package componentes.buscadores;

import java.util.List;

import modelo.maestros.F0005;

import org.zkoss.zul.Textbox;

import servicio.maestros.SF0005;

import componentes.catalogos.CatalogoUDC;

public class BuscadorUDC extends
		BuscadorGenerico<F0005, String, SF0005, Textbox, CatalogoUDC> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String valorP1;
	private String valorP2;

	public BuscadorUDC(String etiqueta, int longitud, boolean requerido,
			String valor1, String valor2, SF0005 servicio) {
		this(etiqueta, longitud, requerido, valor1, valor2, servicio, "30%",
				"7%", "7%", "40%");
		this.valorP1 = valor1;
		this.valorP2 = valor2;
	}

	public BuscadorUDC(String etiqueta, int longitud, boolean requerido,
			String valor1, String valor2, SF0005 servicio, String ancho1,
			String ancho2, String ancho3, String ancho4) {
		super(etiqueta, requerido, "Código Definido por el Usuario (DRKY de "
				+ valor1 + "," + valor2 + ")",
				"Catalogo de Codigo Definidos por el Usuario" + " " + "("
						+ valor1 + "," + valor2 + ")",
				"Click para Seleccionar un Codigo", longitud, servicio, ancho1,
				ancho2, ancho3, ancho4);
		this.valorP1 = valor1;
		this.valorP2 = valor2;
	}

	@Override
	protected F0005 buscar() {
		return buscarEnServicio(obtenerCaja());
	}

	@Override
	protected Textbox inicializarCampo() {
		return new Textbox();
	}

	@Override
	protected CatalogoUDC crearCatalogo() {
		CatalogoUDC catalogo = new CatalogoUDC(divCatalogo, valorP1, valorP2,
				"Catalogo de Códigos Definidos por el Usuario (" + valorP1
						+ "," + valorP2 + ")", getLista(), "KY",
				"Descripcion 01", "Descripcion 02", "Gestion Especial",
				"Codificacion Fija");
		return catalogo;
	}

	@Override
	protected String valorAMostrarEnCajaTexto(F0005 modelo) {
		return modelo.getId().getDrky();
	}

	@Override
	protected String valorAMostrarEnLabel(F0005 modelo) {
		return modelo.getDrdl01();
	}

	@Override
	protected List<F0005> listaInicial() {
		return servicio.buscarParaUDCOrdenados(valorP1, valorP2);
	}

	@Override
	public String obtenerCaja() {
		return cajaTexto.getValue();
	}

	@Override
	protected F0005 buscarEnServicio(String valorBusqueda) {
		return servicio.buscar(valorP1, valorP2, valorBusqueda);
	}

}
