package componentes.catalogos;

import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F4301;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.zk.ui.Component;

import controlador.maestros.CGenerico;
import servicio.maestros.SF0101;

public class CatalogoF4301 extends CatalogoGenerico<F4301> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF4301(Component div, String titulo, List<F4301> lista,
			boolean emergente, String... campos) {
		super(div, titulo, lista, emergente, campos);
	}

	@Override
	protected List<F4301> buscar(List<String> valores) {
		List<F4301> lista = new ArrayList<F4301>();
		for (F4301 f4301 : getLista()) {
			if (String.valueOf(f4301.getId().getPhdoco()).toLowerCase()
					.contains(valores.get(0))
					&& f4301.getId().getPhkcoo().toLowerCase()
							.contains(valores.get(2))
					&& String.valueOf(f4301.getPhan8()).toLowerCase()
							.contains(valores.get(3))
					&& String.valueOf(f4301.getPhtrdj()).toLowerCase()
							.contains(valores.get(5))
					&& String.valueOf(f4301.getPhshan()).toLowerCase()
							.contains(valores.get(6))
					&& String.valueOf(f4301.getPhanby()).toLowerCase()
							.contains(valores.get(7))
					&& f4301.getPhhold().toLowerCase().contains(valores.get(8))) {
				lista.add(f4301);
			}
		}
		return lista;
	}

	@Override
	protected String[] crearRegistros(F4301 f4301) {
		String[] registros = new String[14];
		registros[0] = String.valueOf(f4301.getId().getPhdoco());
		registros[1] = f4301.getId().getPhdcto();
		registros[2] = f4301.getId().getPhkcoo();
		registros[3] = String.valueOf(f4301.getPhan8());
		registros[4] = CGenerico.getServicioF0101().buscar(f4301.getPhan8()).getAbalph();
		registros[5] = String.valueOf(f4301.getPhtrdj());
		registros[6] = String.valueOf(f4301.getPhshan());
		registros[7] = String.valueOf(f4301.getPhanby());
		registros[8] = f4301.getPhhold();
//		registros[9] = "";
//		registros[10] = "";
//		registros[11] = "";
//		registros[12] = "";
//		registros[13] = "";
		return registros;
	}

}
