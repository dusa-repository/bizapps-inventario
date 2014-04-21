package controlador.maestros;

import java.io.IOException;

import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import componentes.Botonera;

public class CF0004 extends CGenerico {

	@Wire
	private Div divVF0004;
	
	@Wire
	private Div botoneraF0004;

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
		

	}

}
