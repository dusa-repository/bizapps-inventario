package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F40203;
import modelo.maestros.F40203;

import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import componentes.Botonera;
import componentes.Catalogo;

public class CF40203 extends CGenerico {

	@Wire
	private Div divVF40203;
	@Wire
	private Div botoneraF40203;
	@Wire
	private Div catalogoF40203;
	Catalogo<F40203> catalogo;
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
				cerrarVentana(divVF40203, "Sistema");

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
		botoneraF40203.appendChild(botonera);
		mostrarCatalogo (); 

	}
	public void mostrarCatalogo() {
		final List<F40203> actividades = servicioF40203.buscarTodosContado();
		catalogo = new Catalogo<F40203>(catalogoF40203, "F40203", actividades, 
				"Tipo Orden", "Tipo Línea", "Último estado", "Descripción", 
				"Est sig", "Otros 1", "Otros 2", "Otros 3", "Otros 4" , "Otros 5", "LM (Y/M)") {

			@Override
			protected List<F40203> buscar(List<String> valores) {

				List<F40203> actividad = new ArrayList<F40203>();

				for (F40203 actividadord : actividades) {
					if (actividadord.getId().getFsdcto().toLowerCase()
							.startsWith(valores.get(0))
							&& actividadord.getId().getFslnty().toLowerCase()
									.startsWith(valores.get(1))
							&& actividadord.getId().getFslnty().toLowerCase()
									.startsWith(valores.get(2))
							&& actividadord.getFsstds().toLowerCase()
									.startsWith(valores.get(3))
							&& actividadord.getFsnxtr().toLowerCase()
									.startsWith(valores.get(4))
							&& actividadord.getFsa1tr().toLowerCase()
									.startsWith(valores.get(5)) 
							&& actividadord.getFsa2tr().toLowerCase()
									.startsWith(valores.get(6))
							&& actividadord.getFsa3tr().toLowerCase()
									.startsWith(valores.get(7))
							&& actividadord.getFsa4tr().toLowerCase()
									.startsWith(valores.get(8))
							&& actividadord.getFsa5tr().toLowerCase()
									.startsWith(valores.get(9))
							&& actividadord.getFswrth().toLowerCase()
									.startsWith(valores.get(10))		){
						actividad.add(actividadord);
					}
				}
				return actividad;
			}

			@Override
			protected String[] crearRegistros(F40203 reglasactividad) {
				String[] registros = new String[11];
				registros[0] = reglasactividad.getId().getFsdcto();
				registros[1] = reglasactividad.getId().getFslnty();
				registros[2] = reglasactividad.getId().getFslnty();
				registros[3] = reglasactividad.getFsstds();
				registros[4] = reglasactividad.getFsnxtr();
				registros[5] = reglasactividad.getFsa1tr();
				registros[6] = reglasactividad.getFsa2tr();
				registros[7] = reglasactividad.getFsa3tr();
				registros[8] = reglasactividad.getFsa4tr();
				registros[9] = reglasactividad.getFsa5tr();
				registros[10] =reglasactividad.getFswrth();
				return registros;
			}
		};
		catalogo.setParent(catalogoF40203);
		// catalogo.doModal();
	}

}
