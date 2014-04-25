package controlador.maestros;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0006;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import componentes.Botonera;
import componentes.Catalogo;

public class CF0006 extends CGenerico {
	
	@Wire
	private Div divVF0006;
	@Wire
	private Div catalogoF0006;
	@Wire
	private Div botoneraF0006;
	Catalogo<F0006> catalogo;
	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		Botonera botonera = new Botonera() {

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void salir() {
				cerrarVentana(divVF0006, "Sistema");

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void limpiar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void guardar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void buscar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void ayuda() {
				// TODO Auto-generated method stub

			}

			@Override
			public void annadir() {
				// TODO Auto-generated method stub

			}
		};
//		botonera.getChildren().get(3).setVisible(false);
//		botonera.getChildren().get(5).setVisible(false);
		botoneraF0006.appendChild(botonera);
		mostrarCatalogo();
		

	}
	public void mostrarCatalogo() {
		final List<F0006> unidades = servicioF0006.buscarTodosContado();
		catalogo = new Catalogo<F0006>(catalogoF0006, "F0006", unidades, "Unidad Negocio",
				"Descripcion", "Nivel det", "Cta", "Tipo UN", "LM Auxiliar Inactivo", "Mto Cons",
				"CAT 01", "CAT 02", "CAT 03", "CAT 04", "CAT 05", "CAT 06") {



			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					if (unidad.getMcmcu().toLowerCase()
							.startsWith(valores.get(0))
							&& unidad.getMcdc().toLowerCase()
									.startsWith(valores.get(1))
							&& unidad.getMcldm().toLowerCase()
									.startsWith(valores.get(2))
							&& unidad.getMcco().toLowerCase()
									.startsWith(valores.get(3))
							&& unidad.getMcstyl().toLowerCase()
									.startsWith(valores.get(4))) {
						unidadnegocio.add(unidad);
					}
				}
				return unidadnegocio;
			}

			@Override
			protected String[] crearRegistros(F0006 negocio) {
				String[] registros = new String[5];
				registros[0] = negocio.getMcmcu();
				registros[1] = negocio.getMcdc();
				registros[2] = negocio.getMcldm();
				registros[3] = negocio.getMcco();
				registros[4] = negocio.getMcstyl();
				return registros;
			}
		};
		catalogo.setParent(catalogoF0006);
		// catalogo.doModal();
	}

}
