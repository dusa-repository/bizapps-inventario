package componentes.catalogos;

import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0101;

import org.zkoss.zk.ui.Component;

public class CatalogoF0101 extends CatalogoGenerico<F0101> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF0101(Component cGenerico, String titulo, List<F0101> lista,
			boolean emergente, String... campos) {
		super(cGenerico, titulo, lista, emergente, campos);
	}

	@Override
	protected List<F0101> buscar(List<String> valores) {
		List<F0101> lista = new ArrayList<F0101>();
		for (F0101 f01 : getLista()) {
			if (String.valueOf(f01.getAban8()).toLowerCase()
					.startsWith(valores.get(0))
					&& f01.getAbalph().toLowerCase().startsWith(valores.get(1))
					&& f01.getAbalky().toLowerCase().startsWith(valores.get(2))
					&& f01.getAbsic().toLowerCase().startsWith(valores.get(3))
					&& f01.getAbat1().toLowerCase().startsWith(valores.get(4))
					&& f01.getAbtax().toLowerCase().startsWith(valores.get(5))) {
				lista.add(f01);
			}
		}
		return lista;
	}

	@Override
	protected String[] crearRegistros(F0101 f0101) {
		String[] registros = new String[6];
		registros[0] = String.valueOf(f0101.getAban8());
		registros[1] = f0101.getAbalph();
		registros[2] = f0101.getAbalky();
		registros[3] = f0101.getAbsic();
		registros[4] = f0101.getAbat1();
		registros[5] = f0101.getAbtax();
		return registros;
	}

}
