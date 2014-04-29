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
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0015D extends CGenerico {

	@Wire
	private Div divVF0015D;
	@Wire
	private Div botoneraF0015D;
	@Wire
	private Groupbox gpxRegistroF0015D;
	@Wire
	private Textbox txtCRCDF0015D;
	@Wire
	private Textbox txtCRDCF0015D;
	@Wire
	private Datebox dtbEFTF0015D;
	@Wire
	private Textbox txtAN8F0015D;
	@Wire
	private Radiogroup rdgMetodoCalculoF0015D;
	@Wire
	private Radio rdoMetodoInversionF0015D;
	@Wire
	private Radio rdoSinMetodoF0015D;
	@Wire
	private Radio rdoMetodoTriangulacionF0015D;
	@Wire 
	private Checkbox chxCambioContadoF0015D;
	@Wire
	private Textbox txtCRCMF0015D;
	@Wire
	private Label lblMetodoConversionF0015D;
	@Wire
	private Intbox txtCRRF0015D;
	@Wire
	private Intbox txtCRRDF0015D;
	@Wire
	private Groupbox gpxDatosF0015D;
	@Wire
	private Div catalogoF0015H;

	Botonera botonera;
	Catalogo<F0015> catalogo;
	F0015PK clave = null;

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		txtCRCDF0015D.setFocus(true);

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
				cerrarVentana(divVF0015D, "Sistema");
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
		botoneraF0015D.appendChild(botonera);

	}

	public void limpiarCampos() {
		clave = null;
		rdgMetodoCalculoF0015D.setSelectedItem(null);
		chxCambioContadoF0015D.setChecked(false);
		txtCRCMF0015D.setValue("");
		lblMetodoConversionF0015D.setValue("");
		txtCRRF0015D.setValue(null);
		txtCRRDF0015D.setValue(null);
		
	}

	public boolean camposLLenos() {
		if ((rdoMetodoInversionF0015D.isChecked() == false && rdoSinMetodoF0015D
				.isChecked() == false && rdoMetodoTriangulacionF0015D.isChecked() == false)
				||txtCRCMF0015D.getText().compareTo("") == 0
				||txtCRRF0015D.getText().compareTo("") == 0
				||txtCRRDF0015D.getText().compareTo("") == 0) {
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
