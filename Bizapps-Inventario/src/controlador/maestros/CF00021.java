package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F00021;
import modelo.maestros.F0006;
import modelo.pk.F00021PK;

import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import componentes.Botonera;
import componentes.Catalogo;

public class CF00021 extends CGenerico {

	@Wire
	private Div divVF00021;
	@Wire
	private Div catalogoF00021;
	@Wire
	private Div botoneraF00021;
	Catalogo<F00021> catalogo;

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
				cerrarVentana(divVF00021, "Sistema");

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
		botoneraF00021.appendChild(botonera);
		mostrarCatalogo ();

	}
	
	public void mostrarCatalogo() {
		final List<F00021> compannias = servicioF00021.buscarTodosContado();
		catalogo = new Catalogo<F00021>(catalogoF00021, "F00021", compannias, 
				"Compañia Documento", "Tipo Documento", "Igual aTipo Doc", 
				"Digito Incrus", "Digito Verif", "Número Siguiente", 
				"Reinicio Automático") {

			@Override
			protected List<F00021> buscar(List<String> valores) {

				List<F00021> compannia = new ArrayList<F00021>();

				for (F00021 companniadoc : compannias) {
					if (companniadoc.getId().getNlkco().toLowerCase()
							.startsWith(valores.get(0))
							&& companniadoc.getId().getNldct().toLowerCase()
									.startsWith(valores.get(1))
							&& companniadoc.getNlsmas().toLowerCase()
									.startsWith(valores.get(2))
							&& companniadoc.getNlimb().toLowerCase()
									.startsWith(valores.get(3))
							&& companniadoc.getNlck01().toLowerCase()
									.startsWith(valores.get(4))
							&& String.valueOf(companniadoc.getNln001()).toLowerCase()
									.startsWith(valores.get(5))
							&& String.valueOf(companniadoc.getNlaur()).toLowerCase()
									.startsWith(valores.get(6))) {
						compannia.add(companniadoc);
					}
				}
				return compannia;
			}

			@Override
			protected String[] crearRegistros(F00021 numerosiguiente) {
				String[] registros = new String[7];
				registros[0] = numerosiguiente.getId().getNlkco();
				registros[1] = numerosiguiente.getId().getNldct();
				registros[2] = numerosiguiente.getNlsmas();
				registros[3] = numerosiguiente.getNlimb();
				registros[4] = numerosiguiente.getNlck01();
				registros[5] = String.valueOf(numerosiguiente.getNln001());
				registros[6] = String.valueOf(numerosiguiente.getNlaur());
				return registros;
			}
		};
		catalogo.setParent(catalogoF00021);
		// catalogo.doModal();
	}

}
