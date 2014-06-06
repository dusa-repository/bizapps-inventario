package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;

import modelo.maestros.F0004;
import modelo.maestros.F4008;
import modelo.pk.F0004PK;

import componentes.Botonera;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF4008 extends CGenerico {

	@Wire
	private Div divCatalogoF4008;
	@Wire
	private Div divVF4008;
	@Wire
	private Div botoneraF4008;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;

	Catalogo<F4008> catalogoF4008;
	Botonera botonera;

	@Override
	public void inicializar() throws IOException {

		mostrarCatalogo();

		botonera = new Botonera() {

			@Override
			public void seleccionar() {

			}

			@Override
			public void salir() {
				cerrarVentana(divVF4008, "Trabajo con Zona/Tipo Impositivo");

			}

			@Override
			public void reporte() {
			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
			}

			@Override
			public void guardar() {

			}

			@Override
			public void eliminar() {

			}

			@Override
			public void buscar() {
			}

			@Override
			public void ayuda() {

			}

			@Override
			public void annadir() {
				abrirRegistro();
				mostrarBotones(false);
			}
		};
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF4008.appendChild(botonera);
	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(bol);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
	}

	@Listen("onOpen = #gpxDatos")
	public void abrirCatalogo() {
		gpxDatos.setOpen(false);

		// FALTA CAMPOS EDITANDO
		if (true) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatos.setOpen(false);
								gpxRegistro.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatos.setOpen(true);
									gpxRegistro.setOpen(false);
									// limpiarCampos();
									// habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatos.setOpen(true);
			gpxRegistro.setOpen(false);
			mostrarBotones(true);
		}
	}

	public void mostrarCatalogo() {
		final List<F4008> listF4008 = servicioF4008.buscarTodosOrdenados();
		catalogoF4008 = new Catalogo<F4008>(divCatalogoF4008, "F4008",
				listF4008, false, false, true, "Zona/Tipo impositivo",
				"Descripcion zona fiscal", "Fecha efectiva", "Fecha vto",
				"Tipo imptvo 1", "Tipo imptvo 2", "Tipo imptvo 3",
				"Tipo imptvo 4", "Tipo imptvo 5", "Nro corto articulo") {

			@Override
			protected List<F4008> buscar(List<String> valores) {

				List<F4008> lista = new ArrayList<F4008>();

				for (F4008 f4008 : listF4008) {
					if (f4008.getId().getTatxa1().toLowerCase()
							.startsWith(valores.get(0))
							&& f4008.getTataxa().toLowerCase()
									.startsWith(valores.get(1))
							&& String.valueOf(f4008.getTaeftj()).toLowerCase()
									.startsWith(valores.get(2))
							&& String.valueOf(f4008.getId().getTaefdj())
									.toLowerCase().startsWith(valores.get(3))
							&& String.valueOf(f4008.getTatxr1()).toLowerCase()
									.startsWith(valores.get(4))
							&& String.valueOf(f4008.getTatxr2()).toLowerCase()
									.startsWith(valores.get(5))
							&& String.valueOf(f4008.getTatxr3()).toLowerCase()
									.startsWith(valores.get(6))
							&& String.valueOf(f4008.getTatxr4()).toLowerCase()
									.startsWith(valores.get(7))
							&& String.valueOf(f4008.getTatxr5()).toLowerCase()
									.startsWith(valores.get(8))
							&& String.valueOf(f4008.getId().getTaitm())
									.toLowerCase().startsWith(valores.get(9))) {
						lista.add(f4008);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4008 f4008) {
				String[] registros = new String[6];
				registros[0] = f4008.getId().getTatxa1();
				registros[1] = f4008.getTataxa();
				registros[2] = String.valueOf(f4008.getTaeftj());
				registros[3] = String.valueOf(f4008.getId().getTaefdj());
				registros[4] = String.valueOf(f4008.getTatxr1());
				registros[5] = String.valueOf(f4008.getTatxr2());
				registros[6] = String.valueOf(f4008.getTatxr3());
				registros[7] = String.valueOf(f4008.getTatxr4());
				registros[8] = String.valueOf(f4008.getTatxr5());
				registros[9] = String.valueOf(f4008.getId().getTaitm());
				return registros;
			}
		};
		catalogoF4008.setParent(divCatalogoF4008);
	}
}
