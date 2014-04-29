package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0015;
import modelo.pk.F0015PK;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0015H extends CGenerico {

	@Wire
	private Div divVF0015H;
	@Wire
	private Div botoneraF0015H;
	@Wire
	private Groupbox gpxRegistroF0015H;
	@Wire
	private Textbox txtCRCDF0015H;
	@Wire
	private Button btnBuscarCRCDF0015H;
	@Wire
	private Textbox txtCRDCF0015H;
	@Wire
	private Button btnBuscarCRDCF0015H;
	@Wire
	private Datebox dtbEFTF0015H;
	@Wire
	private Textbox txtAN8F0015H;
	@Wire
	private Button btnBuscarAN8F0015H;
	@Wire
	private Groupbox gpxDatosF0015H;
	@Wire
	private Div catalogoF0015H;

	Botonera botonera;
	Catalogo<F0015> catalogo;
	F0015PK clave = null;

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		txtCRCDF0015H.setFocus(true);

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
				cerrarVentana(divVF0015H, "Sistema");
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
		botoneraF0015H.appendChild(botonera);

	}

	public void limpiarCampos() {
		clave = null;
		txtCRCDF0015H.setValue("");
		txtCRDCF0015H.setValue("");
		dtbEFTF0015H.setValue(null);
		txtAN8F0015H.setValue("");
		txtCRCDF0015H.setFocus(true);
	}

	public boolean camposLLenos() {
		if (txtCRCDF0015H.getText().compareTo("") == 0
				||txtCRDCF0015H.getText().compareTo("") == 0
				|| dtbEFTF0015H.getText().compareTo("") == 0
				|| txtAN8F0015H.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtCRCDF0015H.getText().compareTo("") != 0
				||txtCRDCF0015H.getText().compareTo("") != 0
				|| dtbEFTF0015H.getText().compareTo("") != 0
				|| txtAN8F0015H.getText().compareTo("") != 0) {
			return false;
		} else
			return true;
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
