package componentes.catalogos;

import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F4008;

import org.zkoss.zk.ui.Component;

import componentes.Catalogo;
import componentes.utils.Convertidor;

public class CatalogoF4008 extends Catalogo<F4008> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF4008(Component cGenerico, String titulo, List<F4008> lista,
			boolean emergente, String... campos) {
		super(cGenerico, titulo, lista, emergente, campos);
	}

	@Override
	protected List<F4008> buscar(List<String> valores) {
		List<F4008> lista = new ArrayList<F4008>();
		for (F4008 f4008 : getLista()) {
			if (f4008.getId().getTatxa1().toLowerCase()
					.startsWith(valores.get(0))
					&& f4008.getTataxa().toLowerCase()
							.startsWith(valores.get(1))
					&& String
							.valueOf(
									Convertidor
											.transformarJulianaAGregoria(f4008
													.getTaeftj()))
							.toLowerCase().startsWith(valores.get(2))
					&& String
							.valueOf(
									Convertidor
											.transformarJulianaAGregoriadeLong(f4008
													.getId().getTaefdj()))
							.toLowerCase().startsWith(valores.get(3))
					&& String.valueOf(f4008.getTatxr1()).toLowerCase()
							.startsWith(valores.get(4))
					&& String.valueOf(f4008.getTatxr2()).toLowerCase()
							.startsWith(valores.get(5))
					&& String.valueOf(f4008.getTatxr3()).toLowerCase()
							.startsWith(valores.get(6))
					&& String.valueOf(f4008.getTatxr4()).toLowerCase()
							.startsWith(valores.get(7))
					&& String.valueOf(f4008.getTatxr5()).toLowerCase()
							.startsWith(valores.get(8))
					&& String.valueOf(f4008.getId().getTaitm()).toLowerCase()
							.startsWith(valores.get(9))) {
				lista.add(f4008);
			}
		}
		return lista;
	}

	@Override
	protected String[] crearRegistros(F4008 f4008) {
		String[] registros = new String[10];
		registros[0] = f4008.getId().getTatxa1();
		registros[1] = f4008.getTataxa();
		registros[2] = String.valueOf(f4008.getTaeftj());
		registros[3] = String.valueOf(f4008.getId().getTaefdj());
		registros[4] = String.valueOf(f4008.getTatxr1());
		registros[5] = String.valueOf(f4008.getTatxr2());
		registros[6] = String.valueOf(f4008.getTatxr3());
		registros[7] = String.valueOf(f4008.getTatxr4());
		registros[8] = String.valueOf(f4008.getTatxr5());
		registros[9] = String.valueOf(f4008.getId().getTaitm());
		return registros;
	}

}
