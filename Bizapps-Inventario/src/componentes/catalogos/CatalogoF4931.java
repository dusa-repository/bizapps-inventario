package componentes.catalogos;

import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F4931;

import org.zkoss.zk.ui.Component;

public class CatalogoF4931 extends CatalogoGenerico<F4931> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF4931(Component cGenerico, String titulo, List<F4931> lista,
			boolean emergente, String... campos) {
		super(cGenerico, titulo, lista, emergente, campos);
	}

	@Override
	protected List<F4931> buscar(List<String> valores) {
		List<F4931> lista = new ArrayList<F4931>();
		for (F4931 f4931 : getLista()) {
			if (String.valueOf(f4931.getVgvtyp()).toLowerCase()
					.startsWith(valores.get(0))
					&& f4931.getVgdl01().toLowerCase()
							.startsWith(valores.get(2))
					&& f4931.getVgmot().toLowerCase()
							.startsWith(valores.get(3))
					&& f4931.getVgdsgs().toLowerCase()
							.startsWith(valores.get(4))
					&& String.valueOf(f4931.getVgwtca()).toLowerCase()
							.startsWith(valores.get(5))
					&& f4931.getVgwtum().toLowerCase()
							.startsWith(valores.get(6))
					&& String.valueOf(f4931.getVgcvol()).toLowerCase()
							.startsWith(valores.get(7))
					&& f4931.getVgcvum().toLowerCase()
							.startsWith(valores.get(8))
					&& String.valueOf(f4931.getVgvlcp()).toLowerCase()
							.startsWith(valores.get(9))
					&& String.valueOf(f4931.getVgvlcs()).toLowerCase()
							.startsWith(valores.get(10))
					&& f4931.getVgvlum().toLowerCase()
							.startsWith(valores.get(11))
					&& String.valueOf(f4931.getVgnce()).toLowerCase()
							.startsWith(valores.get(12))
					&& String.valueOf(f4931.getVglcnt()).toLowerCase()
							.startsWith(valores.get(13))) {
				lista.add(f4931);
			}
		}
		return lista;
	}

	@Override
	protected String[] crearRegistros(F4931 f4931) {
		String[] registros = new String[14];
		registros[0] = String.valueOf(f4931.getVgvtyp());
		registros[1] = f4931.getVgdl01();
		registros[2] = f4931.getVgmot();
		registros[3] = f4931.getVgdsgp();
		registros[4] = f4931.getVgdsgs();
		registros[5] = String.valueOf(f4931.getVgwtca());
		registros[6] = f4931.getVgwtum();
		registros[7] = String.valueOf(f4931.getVgcvol());
		registros[8] = f4931.getVgcvum();
		registros[9] = String.valueOf(f4931.getVgvlcp());
		registros[10] = String.valueOf(f4931.getVgvlcs());
		registros[11] = f4931.getVgvlum();
		registros[12] = String.valueOf(f4931.getVgnce());
		registros[13] = String.valueOf(f4931.getVglcnt());
		return registros;
	}

}
