package componentes.catalogos;

import java.util.List;

import org.zkoss.zk.ui.Component;

import modelo.maestros.F4301;
import componentes.Catalogo;

public class CatalogoF4301 extends Catalogo<F4301>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF4301(Component cGenerico, String titulo, List<F4301> lista,
			boolean emergente, boolean udc, boolean param2, String[] campos) {
		super(cGenerico, titulo, lista, emergente, udc, param2, campos);
	}

	@Override
	protected List<F4301> buscar(List<String> valores) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] crearRegistros(F4301 objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
