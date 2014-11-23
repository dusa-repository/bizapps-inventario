package componentes.catalogos;

import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0010;

import org.zkoss.zk.ui.Component;

import componentes.utils.Convertidor;

public class CatalogoF0010 extends CatalogoGenerico<F0010> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF0010(Component cGenerico, String titulo, List<F0010> lista,
			boolean emergente, String... campos) {
		super(cGenerico, titulo, lista, emergente, campos);
	}

	@Override
	protected List<F0010> buscar(List<String> valores) {
		List<F0010> lista2 = new ArrayList<F0010>();
		for (F0010 f0010 : getLista()) {
			if (f0010.getCcco().toLowerCase()
					.contains(valores.get(0).toLowerCase())
					&& f0010.getCcname().toLowerCase()
							.contains(valores.get(1).toLowerCase())
					&& f0010.getCccald().toLowerCase()
							.contains(valores.get(2).toLowerCase())
					&& f0010.getCcdtpn().toLowerCase()
							.contains(valores.get(3).toLowerCase())
					&& Convertidor.formatoFecha
							.format(Convertidor
									.transformarJulianaAGregoria(f0010
											.getCcdfyj())).toString()
							.toLowerCase()
							.contains(valores.get(4).toLowerCase())
					&& String.valueOf(f0010.getCcpnc()).toLowerCase()
							.contains(valores.get(5).toLowerCase())
					&& Convertidor.formatoFecha
							.format(Convertidor
									.transformarJulianaAGregoria(f0010
											.getCcapfj())).toString()
							.toLowerCase()
							.contains(valores.get(6).toLowerCase())
					&& String.valueOf(f0010.getCcappn()).toLowerCase()
							.contains(valores.get(7).toLowerCase())
					&& Convertidor.formatoFecha
							.format(Convertidor
									.transformarJulianaAGregoria(f0010
											.getCcarfj())).toString()
							.toLowerCase()
							.contains(valores.get(8).toLowerCase())
					&& String.valueOf(f0010.getCcarpn()).toLowerCase()
							.contains(valores.get(9).toLowerCase())
					&& String.valueOf(f0010.getCcpnf()).toLowerCase()
							.contains(valores.get(10).toLowerCase())) {
				lista2.add(f0010);
			}
		}
		return lista2;
	}

	@Override
	protected String[] crearRegistros(F0010 f0010) {
		String[] registros = new String[11];
		registros[0] = f0010.getCcco();
		registros[1] = f0010.getCcname();
		registros[2] = f0010.getCccald();
		registros[3] = f0010.getCcdtpn();
		registros[4] = Convertidor.formatoFecha.format(Convertidor
				.transformarJulianaAGregoria(f0010.getCcdfyj()));
		registros[5] = String.valueOf(f0010.getCcpnc());
		registros[6] = Convertidor.formatoFecha.format(Convertidor
				.transformarJulianaAGregoria(f0010.getCcapfj()));
		registros[7] = String.valueOf(f0010.getCcappn());
		registros[8] = Convertidor.formatoFecha.format(Convertidor
				.transformarJulianaAGregoria(f0010.getCcarfj()));
		registros[9] = String.valueOf(f0010.getCcarpn());
		registros[10] = String.valueOf(f0010.getCcpnf());
		return registros;
	}

}
