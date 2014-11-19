package componentes.catalogos;

import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0006;

import org.zkoss.zk.ui.Component;

import componentes.Catalogo;

public class CatalogoF0006 extends Catalogo<F0006> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF0006(Component cGenerico, String titulo, List<F0006> lista,
			boolean emergente, String... campos) {
		super(cGenerico, titulo, lista, emergente, campos);
	}

	@Override
	protected List<F0006> buscar(List<String> valores) {
		List<F0006> unidadnegocio = new ArrayList<F0006>();
		for (F0006 unidad : getLista()) {
			String mcdc = "";
			if (unidad.getMcdc() != null)
				mcdc = unidad.getMcdc();
			if (unidad.getMcmcu().toLowerCase()
					.contains(valores.get(0).toLowerCase())
					&& mcdc.toLowerCase()
							.contains(valores.get(1).toLowerCase())
					&& unidad.getMcldm().toLowerCase()
							.contains(valores.get(2).toLowerCase())
					&& unidad.getMcco().toLowerCase()
							.contains(valores.get(3).toLowerCase())
					&& unidad.getMcstyl().toLowerCase()
							.contains(valores.get(4).toLowerCase())
					&& unidad.getMcfmod().toLowerCase()
							.contains(valores.get(5).toLowerCase())
					&& unidad.getMcsbli().toLowerCase()
							.contains(valores.get(6).toLowerCase())
					&& unidad.getMcrp01().toLowerCase()
							.contains(valores.get(7).toLowerCase())
					&& unidad.getMcrp02().toLowerCase()
							.contains(valores.get(8).toLowerCase())
					&& unidad.getMcrp03().toLowerCase()
							.contains(valores.get(9).toLowerCase())
					&& unidad.getMcrp04().toLowerCase()
							.contains(valores.get(10).toLowerCase())
					&& unidad.getMcrp05().toLowerCase()
							.contains(valores.get(11).toLowerCase())
					&& unidad.getMcrp06().toLowerCase()
							.contains(valores.get(12).toLowerCase())) {
				unidadnegocio.add(unidad);
			}
		}
		return unidadnegocio;
	}

	@Override
	protected String[] crearRegistros(F0006 negocio) {
		String[] registros = new String[13];
		registros[0] = negocio.getMcmcu();
		registros[1] = negocio.getMcdc();
		registros[2] = negocio.getMcldm();
		registros[3] = negocio.getMcco();
		registros[4] = negocio.getMcstyl();
		registros[5] = negocio.getMcfmod();
		registros[6] = negocio.getMcsbli();
		registros[7] = negocio.getMcrp01();
		registros[8] = negocio.getMcrp02();
		registros[9] = negocio.getMcrp03();
		registros[10] = negocio.getMcrp04();
		registros[11] = negocio.getMcrp05();
		registros[12] = negocio.getMcrp06();
		return registros;
	}

}
