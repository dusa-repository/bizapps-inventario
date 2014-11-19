package componentes.catalogos;

import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F4101;

import org.zkoss.zk.ui.Component;

import componentes.Catalogo;

public class CatalogoF4101 extends Catalogo<F4101> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF4101(Component cGenerico, String titulo, List<F4101> lista,
			boolean emergente, String... campos) {
		super(cGenerico, titulo, lista, emergente, campos);
	}

	@Override
	protected List<F4101> buscar(List<String> valores) {
		List<F4101> lista = new ArrayList<F4101>();
		for (F4101 f4101 : getLista()) {
			if (String.valueOf(f4101.getImitm()).toLowerCase()
					.contains(valores.get(0).toLowerCase())
					&& f4101.getImdsc1().toLowerCase()
							.contains(valores.get(1).toLowerCase())) {
				lista.add(f4101);
			}
		}
		return lista;
	}

	@Override
	protected String[] crearRegistros(F4101 f4101) {
		String[] registros = new String[2];
		registros[0] = String.valueOf(f4101.getImitm());
		registros[1] = f4101.getImdsc1();
		return registros;
	}

}
