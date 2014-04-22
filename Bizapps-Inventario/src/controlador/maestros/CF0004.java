package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0004;

import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import componentes.Botonera;
import componentes.Catalogo;

public class CF0004 extends CGenerico {

	private static final long serialVersionUID = -5111763854219623597L;

	@Wire
	private Div divVF0004;
	
	@Wire
	private Div botoneraF0004;

	@Wire
	private Div catalogoF0004;
	Catalogo<F0004> catalogo;
	
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
				cerrarVentana(divVF0004, "Sistema");

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
		botoneraF0004.appendChild(botonera);
		mostrarCatalogo();
	}
	
	public void mostrarCatalogo() {
		final List<F0004> areas = servicioF0004.buscarTodosContado();
		catalogo = new Catalogo<F0004>(catalogoF0004, "F0004",
				areas, "Descripcion", "Codigo") {
			
			@Override
			protected List<F0004> buscar(String valor, String combo) {
				
				switch (combo) {
				case "Descripcion":{
					return servicioF0004.filtroDl01(valor);
					 }
				case "Codigo":
					return servicioF0004.filtroCdl(valor);
				default:
					return areas;
				}
			}

			@Override
			protected String[] crearRegistros(F0004 avion) {
				String[] registros = new String[2];
				registros[0] = avion.getDtdl01();
				registros[1] = String.valueOf(avion.getDtcdl());
				return registros;
			}
		};
		catalogo.setParent(catalogoF0004);
//		catalogo.doModal();
	}

	/* Permite la seleccion de un item del catalogo */
	@Listen("onSeleccion = #catalogoF0004")
	public void seleccinar() {
		System.out.println("Me tocaste");
	}
}
