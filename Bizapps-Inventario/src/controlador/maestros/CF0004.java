package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0004;
import modelo.pk.F0004PK;

import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Catalogo;

public class CF0004 extends CGenerico {

	private static final long serialVersionUID = -5111763854219623597L;

	@Wire
	private Textbox txtSYF0004;
	@Wire
	private Textbox txtRTF0004;
	@Wire
	private Textbox txtLNF0004;
	@Wire
	private Textbox txtNUMF0004;
	@Wire
	private Textbox txtDL01F0004;
	@Wire
	private Doublespinner dblCDLF0004;
	@Wire
	private Div divVF0004;
	@Wire
	private Div botoneraF0004;
	@Wire
	private Div catalogoF0004;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
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
				if (validar()) {
					String rt = txtRTF0004.getValue();
					String sy = txtSYF0004.getValue();
					String dl = txtDL01F0004.getValue();
					String ln = txtLNF0004.getValue();
					double a = dblCDLF0004.getValue();
					String num = txtNUMF0004.getValue();
					F0004PK clave = new F0004PK();
					clave.setDtrt(rt);
					clave.setDtsy(sy);
					F0004 fooo4 = new F0004();
					fooo4.setId(clave);
					fooo4.setDtdl01(dl);
					fooo4.setDtln2(ln);
					fooo4.setDtcnum(num);
					fooo4.setDtcdl(a);
					fooo4.setDtjobn("5");
					fooo4.setDtuseq(45);
					servicioF0004.guardar(fooo4);
					abrirCatalogo();
				}
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
				abrirRegistro();
			}
		};
		// botonera.getChildren().get(3).setVisible(false);
		// botonera.getChildren().get(5).setVisible(false);
		botoneraF0004.appendChild(botonera);
		mostrarCatalogo();
	}

	protected boolean validar() {
		if (!buscar() || !buscarA()) {
			return false;
		} else
			return true;
	}

	public void mostrarCatalogo() {
		final List<F0004> areas = servicioF0004.buscarTodosContado();
		catalogo = new Catalogo<F0004>(catalogoF0004, "F0004", areas, "RT",
				"SY", "Descripcion", "Codigo", "2 Linea", "Numerico") {

			@Override
			protected List<F0004> buscar(List<String> valores) {

				List<F0004> actividad2 = new ArrayList<F0004>();

				for (F0004 fita : areas) {
					if (fita.getId().getDtrt().toLowerCase()
							.startsWith(valores.get(0))
							&& fita.getId().getDtsy().toLowerCase()
									.startsWith(valores.get(1))
							&& fita.getDtdl01().toLowerCase()
									.startsWith(valores.get(2))
							&& String.valueOf(fita.getDtcdl()).toLowerCase()
									.startsWith(valores.get(3))
							&& fita.getDtln2().toLowerCase()
									.startsWith(valores.get(4))
							&& fita.getDtcnum().toLowerCase()
									.startsWith(valores.get(5))) {
						actividad2.add(fita);
					}
				}
				return actividad2;
			}

			@Override
			protected String[] crearRegistros(F0004 avion) {
				String[] registros = new String[6];
				registros[0] = avion.getId().getDtrt();
				registros[1] = avion.getId().getDtsy();
				registros[2] = avion.getDtdl01();
				registros[3] = String.valueOf(avion.getDtcdl());
				registros[4] = avion.getDtln2();
				registros[5] = avion.getDtcnum();
				return registros;
			}
		};
		catalogo.setParent(catalogoF0004);
		// catalogo.doModal();
	}

	/* Permite la seleccion de un item del catalogo */
	@Listen("onSeleccion = #catalogoF0004")
	public void seleccinar() {
		System.out.println("Me tocaste");
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
	}

	@Listen("onClick = #gpxDatos")
	public void abrirCatalogo() {
		gpxDatos.setOpen(true);
		gpxRegistro.setOpen(false);
	}

	@Listen("onChange = #txtSYF0004")
	public boolean buscar() {
		if (servicioF0004.buscar(txtSYF0004.getValue(), txtRTF0004.getValue()) != null) {
			Messagebox.show("Ya existe esta Clave", "Informacion",
					Messagebox.OK, Messagebox.INFORMATION);
			txtSYF0004.setFocus(true);
			return false;
		} else
			return true;
	}

	@Listen("onClick = #txtRTF0004")
	public boolean buscarA() {
		if (servicioF0004.buscar(txtSYF0004.getValue(), txtRTF0004.getValue()) != null) {
			Messagebox.show("Ya existe esta Clave", "Informacion",
					Messagebox.OK, Messagebox.INFORMATION);
			txtRTF0004.setFocus(true);
			return false;
		} else
			return true;
	}
}
