package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.IdClass;

import modelo.maestros.F0004;
import modelo.pk.F0004PK;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Listitem;
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
	F0004PK clave = new F0004PK();

	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		Botonera botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						abrirRegistro();
						F0004 f04 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f04.getId();
						txtRTF0004.setValue(f04.getId().getDtrt());
						txtRTF0004.setDisabled(true);
						txtSYF0004.setValue(f04.getId().getDtsy());
						txtSYF0004.setDisabled(true);
						txtDL01F0004.setValue(f04.getDtdl01());
						txtLNF0004.setValue(f04.getDtln2());
						txtNUMF0004.setValue(f04.getDtcnum());
						System.out.println("Entro");
					} else
						Messagebox
								.show("Solo puede editar de un Item a la vez, "
										+ "seleccione un (1) solo item y repita la operacion",
										"Informacion", Messagebox.OK,
										Messagebox.INFORMATION);
				}
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
				limpiarCampos();
				abrirCatalogo();
				habilitarTextClave();
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
					fooo4.setDtuser("jDE");
					// fooo4.setDtupmj(dtupmj); //Fecha
					fooo4.setDtupmt(Double.parseDouble(horaAuditoria)); // Hora
					servicioF0004.guardar(fooo4);
					Messagebox.show("Registro guardado exitosamente", "Informacion",
							Messagebox.OK, Messagebox.INFORMATION);
					limpiar();
					abrirCatalogo();
					habilitarTextClave();
				}
			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					// EliminarVarios
					if (validarSeleccion()) {
						final List<F0004> eliminarLista = catalogo.obtenerSeleccionados();
						System.out.println("A eliminar" + eliminarLista.size());
						Messagebox
								.show("¿Desea eliminar los "+eliminarLista.size()+" registros?",
										"Alerta",
										Messagebox.OK | Messagebox.CANCEL,
										Messagebox.QUESTION,
										new org.zkoss.zk.ui.event.EventListener<Event>() {
											public void onEvent(Event evt)
													throws InterruptedException {
												if (evt.getName()
														.equals("onOK")) {
											servicioF0004.eliminarVarios(eliminarLista);
											abrirCatalogo();
												}
											}
										});
					}
				} else {
					// Eliminar solo 1
					if (clave != null) {
						Messagebox
						.show("¿Desea eliminar el registro?",
								"Alerta",
								Messagebox.OK | Messagebox.CANCEL,
								Messagebox.QUESTION,
								new org.zkoss.zk.ui.event.EventListener<Event>() {
									public void onEvent(Event evt)
											throws InterruptedException {
										if (evt.getName()
												.equals("onOK")) {
											servicioF0004.eliminarUno(clave);
											limpiar();
											abrirCatalogo();
											habilitarTextClave();
											Messagebox.show("Registro eliminado exitosamente", "Informacion",
													Messagebox.OK, Messagebox.INFORMATION);
										}
									}
								});
					}
				}
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

	public void limpiarCampos() {
		clave = null;
		txtDL01F0004.setValue("");
		txtLNF0004.setValue("");
		txtNUMF0004.setValue("");
		txtRTF0004.setValue("");
		txtSYF0004.setValue("");
		dblCDLF0004.setValue(0.0);
	}

	public void habilitarTextClave() {
		if (txtRTF0004.isDisabled())
			txtRTF0004.setDisabled(false);
		if (txtSYF0004.isDisabled())
			txtSYF0004.setDisabled(false);
	}

	public boolean validarSeleccion() {
		List<F0004> seleccionados = catalogo.obtenerSeleccionados();
		if (seleccionados == null) {
			Messagebox.show("La lista esta Vacia", "Informacion",
					Messagebox.OK, Messagebox.INFORMATION);
			return false;
		} else {
			if (seleccionados.isEmpty()) {
				Messagebox.show("No ha seleccionado ningun Item",
						"Informacion", Messagebox.OK, Messagebox.INFORMATION);
				return false;
			} else {
				return true;
			}
		}
	}

	protected boolean validar() {
		if (!buscar() || !buscarA()) {
			return false;
		} else {
			if (!camposLLenos()) {
				Messagebox.show("Debe llenar Todos los campos", "Informacion",
						Messagebox.OK, Messagebox.INFORMATION);
				return false;
			} else
				return true;
		}
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
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
	}

//	Falta Modificar
	@Listen("onClick = #gpxDatos")
	public void abrirCatalogo() {
		System.out.println(txtDL01F0004.getValue()+
		txtLNF0004.getValue()+
		txtNUMF0004.getValue()+
		txtRTF0004.getValue()+
		txtSYF0004.getValue()+
		dblCDLF0004.getValue());
//		if (camposLLenos()) {
			System.out.println("vacios");
			gpxDatos.setOpen(true);
			gpxRegistro.setOpen(false);
			limpiarCampos();
			habilitarTextClave();
//		} else {
//			System.out.println("llenos");
//			Messagebox.show("¿No ha culminado la edicion, desea continuar?",
//					"Alerta", Messagebox.OK | Messagebox.CANCEL,
//					Messagebox.QUESTION,
//					new org.zkoss.zk.ui.event.EventListener<Event>() {
//						public void onEvent(Event evt)
//								throws InterruptedException {
//							if (evt.getName().equals("onOK")) {
//								gpxDatos.setOpen(true);
//								gpxRegistro.setOpen(false);
//								limpiarCampos();
//							}
//						}
//					});
//		}
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

	@Listen("onChange = #txtRTF0004")
	public boolean buscarA() {
		if (servicioF0004.buscar(txtSYF0004.getValue(), txtRTF0004.getValue()) != null) {
			Messagebox.show("Ya existe esta Clave", "Informacion",
					Messagebox.OK, Messagebox.INFORMATION);
			txtRTF0004.setFocus(true);
			return false;
		} else
			return true;
	}

	public boolean camposLLenos() {
		if (txtDL01F0004.getText().compareTo("") == 0
				|| txtLNF0004.getText().compareTo("") == 0
				|| txtNUMF0004.getText().compareTo("") == 0
				|| txtRTF0004.getText().compareTo("") == 0
				|| txtSYF0004.getText().compareTo("") == 0
				|| dblCDLF0004.getValue() == 0.0)
			return false;
		else
			return true;
	}
}
