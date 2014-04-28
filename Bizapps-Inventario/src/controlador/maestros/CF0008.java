package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0008;
import modelo.pk.F0008PK;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0008 extends CGenerico {

	@Wire
	private Div divVF0008;
	@Wire
	private Div botoneraF0008;
	@Wire
	private Groupbox gpxRegistroF0008;
	@Wire
	private Textbox txtDTPNF0008;
	@Wire
	private Button btnBuscarF0008;
	@Wire
	private Datebox dtbDFYJF0008;
	@Wire
	private Datebox dtbD01JF0008;
	@Wire
	private Datebox dtbD02JF0008;
	@Wire
	private Datebox dtbD03JF0008;
	@Wire
	private Datebox dtbD04JF0008;
	@Wire
	private Datebox dtbD05JF0008;
	@Wire
	private Datebox dtbD06JF0008;
	@Wire
	private Datebox dtbD07JF0008;
	@Wire
	private Datebox dtbD08JF0008;
	@Wire
	private Datebox dtbD09JF0008;
	@Wire
	private Datebox dtbD10JF0008;
	@Wire
	private Datebox dtbD11JF0008;
	@Wire
	private Datebox dtbD12JF0008;
	@Wire
	private Datebox dtbD13JF0008;
	@Wire
	private Datebox dtbD14JF0008;
	@Wire
	private Groupbox gpxDatosF0008;
	@Wire
	private Div catalogoF0008;

	Botonera botonera;
	Catalogo<F0008> catalogo;
	F0008PK clave = null;

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		txtDTPNF0008.setFocus(true);

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void buscar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void annadir() {
				// TODO Auto-generated method stub

			}

			@Override
			public void guardar() {
				// TODO Auto-generated method stub
				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {

				}

			}

			@Override
			public void limpiar() {
				// TODO Auto-generated method stub
				mostrarBotones(false);
				limpiarCampos();
				clave = null;

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void salir() {
				// TODO Auto-generated method stub
				cerrarVentana(divVF0008, "Sistema");
			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void ayuda() {
				// TODO Auto-generated method stub

			}

		};
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF0008.appendChild(botonera);

	}

	public void limpiarCampos() {
		clave = null;
		txtDTPNF0008.setValue("");
		dtbDFYJF0008.setValue(null);
		dtbD01JF0008.setValue(null);
		dtbD02JF0008.setValue(null);
		dtbD03JF0008.setValue(null);
		dtbD04JF0008.setValue(null);
		dtbD05JF0008.setValue(null);
		dtbD06JF0008.setValue(null);
		dtbD07JF0008.setValue(null);
		dtbD08JF0008.setValue(null);
		dtbD09JF0008.setValue(null);
		dtbD10JF0008.setValue(null);
		dtbD11JF0008.setValue(null);
		dtbD12JF0008.setValue(null);
		dtbD13JF0008.setValue(null);
		dtbD14JF0008.setValue(null);
		txtDTPNF0008.setFocus(true);
	}

	public boolean camposLLenos() {
		if (txtDTPNF0008.getText().compareTo("") == 0
				|| dtbDFYJF0008.getText().compareTo("") == 0
				|| dtbD01JF0008.getText().compareTo("") == 0
				|| dtbD02JF0008.getText().compareTo("") == 0
				|| dtbD03JF0008.getText().compareTo("") == 0
				|| dtbD04JF0008.getText().compareTo("") == 0
				|| dtbD05JF0008.getText().compareTo("") == 0
				|| dtbD06JF0008.getText().compareTo("") == 0
				|| dtbD07JF0008.getText().compareTo("") == 0
				|| dtbD08JF0008.getText().compareTo("") == 0
				|| dtbD09JF0008.getText().compareTo("") == 0
				|| dtbD10JF0008.getText().compareTo("") == 0
				|| dtbD11JF0008.getText().compareTo("") == 0
				|| dtbD12JF0008.getText().compareTo("") == 0
				|| dtbD13JF0008.getText().compareTo("") == 0
				|| dtbD14JF0008.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtDTPNF0008.getText().compareTo("") != 0
				|| dtbDFYJF0008.getText().compareTo("") != 0
				|| dtbD01JF0008.getText().compareTo("") != 0
				|| dtbD02JF0008.getText().compareTo("") != 0
				|| dtbD03JF0008.getText().compareTo("") != 0
				|| dtbD04JF0008.getText().compareTo("") != 0
				|| dtbD05JF0008.getText().compareTo("") != 0
				|| dtbD06JF0008.getText().compareTo("") != 0
				|| dtbD07JF0008.getText().compareTo("") != 0
				|| dtbD08JF0008.getText().compareTo("") != 0
				|| dtbD09JF0008.getText().compareTo("") != 0
				|| dtbD10JF0008.getText().compareTo("") != 0
				|| dtbD11JF0008.getText().compareTo("") != 0
				|| dtbD12JF0008.getText().compareTo("") != 0
				|| dtbD13JF0008.getText().compareTo("") != 0
				|| dtbD14JF0008.getText().compareTo("") != 0) {
			return false;
		} else
			return false;
	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
		botonera.getChildren().get(6).setVisible(bol);
	}

	protected boolean validar() {
		if (!camposLLenos()) {
			msj.mensajeAlerta(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

}
