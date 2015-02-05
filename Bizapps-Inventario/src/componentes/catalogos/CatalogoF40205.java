package componentes.catalogos;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;

import modelo.maestros.F40205;

public class CatalogoF40205 extends CatalogoGenerico<F40205> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF40205(Component cGenerico, String titulo,
			List<F40205> lista, boolean emergente, String[] campos) {
		super(cGenerico, titulo, lista, emergente, campos);
	}

	@Override
	protected List<F40205> buscar(List<String> valores) {
		List<F40205> lista = new ArrayList<F40205>();
		for (F40205 f01 : getLista()) {
			if (f01.getLflnty().toLowerCase()
					.contains(valores.get(0).toLowerCase())
					&& f01.getLflnds().toLowerCase()
							.contains(valores.get(1).toLowerCase())
					&& f01.getLfivi().toLowerCase()
							.contains(valores.get(2).toLowerCase())
					&& f01.getLfapi().toLowerCase()
							.contains(valores.get(3).toLowerCase())
					&& f01.getLfari().toLowerCase()
							.contains(valores.get(4).toLowerCase())
					&& f01.getLfgli().toLowerCase()
							.contains(valores.get(5).toLowerCase())
					&& f01.getLfpdc2().toLowerCase()
							.contains(valores.get(6).toLowerCase())
					&& f01.getLfglc().toLowerCase()
							.contains(valores.get(7).toLowerCase())) {
				lista.add(f01);
			}
		}
		return lista;
	}

	@Override
	protected String[] crearRegistros(F40205 objeto) {
		String[] registros = new String[8];
		registros[0] = objeto.getLflnty();
		registros[1] = objeto.getLflnds();
		registros[2] = objeto.getLfivi();
		registros[3] = objeto.getLfapi();
		registros[4] = objeto.getLfari();
		registros[5] = objeto.getLfgli();
		registros[6] = objeto.getLfpdc2();
		registros[7] = objeto.getLfglc();
		return registros;
	}

}
