package controlador.maestros;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F0004;
import modelo.maestros.F0005;
import modelo.maestros.F0005;
import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F0010;
import modelo.pk.F0005PK;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Button;
import componentes.Botonera;
import componentes.Catalogo;
import componentes.Mensaje;

public class CF0006 extends CGenerico {
	
	@Wire
	private Textbox txtUDCF0006;
	@Wire
	private Textbox txtDL01F0006;
	@Wire
	private Textbox txtCOF0006;
	@Wire
	private Textbox txtLDMF0006;
	@Wire
	private Textbox txtSTYLF0006;
	@Wire
	private Textbox txtSBLIF0006;
	@Wire
	private Textbox txtFMODF0006;
	@Wire
	private Textbox txtDL02F0006;
	@Wire
	private Textbox txtDL03F0006;
	@Wire
	private Textbox txtDL04F0006;
	@Wire
	private Textbox txtAN8F0006;
	@Wire
	private Textbox txtTXA1F0006;
	@Wire
	private Textbox txtMCUSF0006;
	@Wire
	private Textbox txtPECCF0006;
	@Wire
	private Textbox txtRP01F0006;
	@Wire
	private Textbox txtRP02F0006;
	@Wire
	private Textbox txtRP03F0006;
	@Wire
	private Textbox txtRP04F0006;
	@Wire
	private Textbox txtRP05F0006;
	@Wire
	private Textbox txtRP06F0006;
	@Wire
	private Textbox txtRP07F0006;
	@Wire
	private Textbox txtRP08F0006;
	@Wire
	private Textbox txtRP09F0006;
	@Wire
	private Textbox txtRP10F0006;
	@Wire
	private Textbox txtRP11F0006;
	@Wire
	private Textbox txtRP12F0006;
	@Wire
	private Textbox txtRP13F0006;
	@Wire
	private Textbox txtRP14F0006;
	@Wire
	private Textbox txtRP15F0006;
	@Wire
	private Textbox txtRP16F0006;
	@Wire
	private Textbox txtRP17F0006;
	@Wire
	private Textbox txtRP18F0006;
	@Wire
	private Textbox txtRP19F0006;
	@Wire
	private Textbox txtRP20F0006;
	@Wire
	private Textbox txtRP21F0006;
	@Wire
	private Textbox txtRP22F0006;
	@Wire
	private Textbox txtRP23F0006;
	@Wire
	private Textbox txtRP24F0006;
	@Wire
	private Textbox txtRP25F0006;
	@Wire
	private Textbox txtRP26F0006;
	@Wire
	private Textbox txtRP27F0006;
	@Wire
	private Textbox txtRP28F0006;
	@Wire
	private Textbox txtRP29F0006;
	@Wire
	private Textbox txtRP30F0006;
	@Wire
	private Div divVF0006;
	@Wire
	private Div catalogoF0006;
	@Wire
	private Div botoneraF0006;
	@Wire
	private Div divCatalogoF0005;
	@Wire
	private Div divCatalogoF0010;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Button btnBuscarCompannia ;
	@Wire
	private Button btnBuscarTipoUnidad;
	@Wire
	private Label lblDescripcionF0004;
	@Wire
	private Label lblDescripcionF0010;
	Catalogo<F0006> catalogo;
	Botonera botonera;
	String clave = null;
	Catalogo<F0005> catalogoF0005;
	Catalogo<F0010> catalogoF0010;
	
	@Override
	public void inicializar() throws IOException {
		// TODO Auto-generated method stub

		txtUDCF0006.setFocus(true);
		mostrarCatalogo();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F0006 f06 = catalogo.objetoSeleccionadoDelCatalogo();
						txtUDCF0006.setValue(f06.getMcmcu());
						txtUDCF0006.setDisabled(true);
						txtDL01F0006.setValue(f06.getMcdl01());
						txtDL01F0006.setDisabled(true);
						txtCOF0006.setValue(f06.getMcco());
						txtCOF0006.setDisabled(true);
						txtLDMF0006.setValue(f06.getMcldm());
						txtSTYLF0006.setValue(f06.getMcstyl());
						txtSBLIF0006.setValue(f06.getMcsbli());
						txtFMODF0006.setValue(f06.getMcfmod());
						txtDL02F0006.setValue(f06.getMcdl02());
						txtDL03F0006.setValue(f06.getMcdl03());
						txtDL04F0006.setValue(f06.getMcdl04());
						txtAN8F0006.setValue(String.valueOf(f06.getMcan8()));
						txtTXA1F0006.setValue(f06.getMctxa1());
						txtMCUSF0006.setValue(f06.getMcmcus());
						txtPECCF0006.setValue(String.valueOf(f06.getMcpcc()));
						txtRP01F0006.setValue(f06.getMcrp01());
						txtRP02F0006.setValue(f06.getMcrp02());
						txtRP03F0006.setValue(f06.getMcrp03());
						txtRP04F0006.setValue(f06.getMcrp04());
						txtRP05F0006.setValue(f06.getMcrp05());
						txtRP06F0006.setValue(f06.getMcrp06());
						txtRP07F0006.setValue(f06.getMcrp07());
						txtRP08F0006.setValue(f06.getMcrp08());
						txtRP09F0006.setValue(f06.getMcrp09());
						txtRP10F0006.setValue(f06.getMcrp10());
						txtRP11F0006.setValue(f06.getMcrp11());
						txtRP12F0006.setValue(f06.getMcrp12());
						txtRP13F0006.setValue(f06.getMcrp13());
						txtRP14F0006.setValue(f06.getMcrp14());
						txtRP15F0006.setValue(f06.getMcrp15());
						txtRP16F0006.setValue(f06.getMcrp16());
						txtRP17F0006.setValue(f06.getMcrp17());
						txtRP18F0006.setValue(f06.getMcrp18());
						txtRP19F0006.setValue(f06.getMcrp19());
						txtRP20F0006.setValue(f06.getMcrp20());
						txtRP21F0006.setValue(f06.getMcrp21());
						txtRP22F0006.setValue(f06.getMcrp22());
						txtRP23F0006.setValue(f06.getMcrp23());
						txtRP24F0006.setValue(f06.getMcrp24());
						txtRP25F0006.setValue(f06.getMcrp25());
						txtRP26F0006.setValue(f06.getMcrp26());
						txtRP27F0006.setValue(f06.getMcrp27());
						txtRP28F0006.setValue(f06.getMcrp28());
						txtRP29F0006.setValue(f06.getMcrp29());
						txtRP30F0006.setValue(f06.getMcrp30());
						txtLDMF0006.setFocus(true);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0006, "Sistema");

			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
				habilitarCampos();

			}

			@Override
			public void guardar() {
				boolean guardar = true;
				if (clave == null)
					guardar = validar();
				if (guardar) {
					System.out.println("entrooooooooooo");
					String MCMCU = txtUDCF0006.getValue();
					String dl01 = txtDL01F0006.getValue();
					String co = txtCOF0006.getValue();
					String ldmf = txtLDMF0006.getValue();
					String styl = txtSTYLF0006.getValue();
					String sbli = txtSBLIF0006.getValue();
					String fmod = txtFMODF0006.getValue();
					String dl02 = txtDL02F0006.getValue();
					String dl03 = txtDL03F0006.getValue();
					String dl04 = txtDL04F0006.getValue();
					//double  an8 = Double.parseDouble(txtAN8F0006.getValue());
					String txa1 = txtTXA1F0006.getValue();
					String mcus = txtMCUSF0006.getValue();
					String pecc = txtPECCF0006.getValue();
					String rp01 = txtRP01F0006.getValue();
					String rp02 = txtRP02F0006.getValue();
					String rp03 = txtRP03F0006.getValue();
					String rp04 = txtRP04F0006.getValue();
					String rp05 = txtRP05F0006.getValue();
					String rp06 = txtRP06F0006.getValue();
					String rp07 = txtRP07F0006.getValue();
					String rp08 = txtRP08F0006.getValue();
					String rp09 = txtRP09F0006.getValue();
					String rp10 = txtRP10F0006.getValue();
					String rp11 = txtRP11F0006.getValue();
					String rp12 = txtRP12F0006.getValue();
					String rp13 = txtRP13F0006.getValue();
					String rp14 = txtRP14F0006.getValue();
					String rp15 = txtRP15F0006.getValue();
					String rp16 = txtRP16F0006.getValue();
					String rp17 = txtRP17F0006.getValue();
					String rp18 = txtRP18F0006.getValue();
					String rp19 = txtRP19F0006.getValue();
					String rp20 = txtRP20F0006.getValue();
					String rp21 = txtRP21F0006.getValue();
					String rp22 = txtRP22F0006.getValue();
					String rp23 = txtRP23F0006.getValue();
					String rp24 = txtRP24F0006.getValue();
					String rp25 = txtRP25F0006.getValue();
					String rp26 = txtRP26F0006.getValue();
					String rp27 = txtRP27F0006.getValue();
					String rp28 = txtRP28F0006.getValue();
					String rp29 = txtRP29F0006.getValue();
					String rp30 = txtRP30F0006.getValue();
					F0006 fooo6 = new F0006();
					fooo6.setMcmcu(MCMCU);
					fooo6.setMcdl01(dl01);
					fooo6.setMcco(co);
					fooo6.setMcldm(ldmf);
					fooo6.setMcstyl(styl);
					fooo6.setMcsbli(sbli);
					fooo6.setMcfmod(fmod);
					fooo6.setMcdl02(dl02);
					fooo6.setMcdl03(dl03);
					fooo6.setMcdl04(dl04);
					//fooo6.setMcan8(an8);
					fooo6.setMctxa1(txa1);
					fooo6.setMcmcus(mcus);
					fooo6.setMcpecc(pecc);
					fooo6.setMcrp01(rp01);
					fooo6.setMcrp02(rp02);
					fooo6.setMcrp03(rp03);
					fooo6.setMcrp04(rp04);
					fooo6.setMcrp05(rp05);
					fooo6.setMcrp06(rp06);
					fooo6.setMcrp07(rp07);
					fooo6.setMcrp08(rp08);
					fooo6.setMcrp09(rp09);
					fooo6.setMcrp10(rp10);
					fooo6.setMcrp11(rp11);
					fooo6.setMcrp12(rp12);
					fooo6.setMcrp13(rp13);
					fooo6.setMcrp14(rp14);
					fooo6.setMcrp15(rp15);
					fooo6.setMcrp16(rp16);
					fooo6.setMcrp17(rp17);
					fooo6.setMcrp18(rp18);
					fooo6.setMcrp19(rp19);
					fooo6.setMcrp20(rp20);
					fooo6.setMcrp21(rp21);
					fooo6.setMcrp22(rp22);
					fooo6.setMcrp23(rp23);
					fooo6.setMcrp24(rp24);
					fooo6.setMcrp25(rp25);
					fooo6.setMcrp26(rp26);
					fooo6.setMcrp27(rp27);
					fooo6.setMcrp28(rp28);
					fooo6.setMcrp29(rp29);
					fooo6.setMcrp30(rp30);
					System.out.println(MCMCU);
					
					servicioF0006.guardar(fooo6);
					
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();
					catalogo.actualizarLista(servicioF0006
							.buscarTodosOrdenados());
				}

			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<F0006> eliminarLista = catalogo
								.obtenerSeleccionados();
						Messagebox
								.show("¿Desea Eliminar los "
										+ eliminarLista.size() + " Registros?",
										"Alerta",
										Messagebox.OK | Messagebox.CANCEL,
										Messagebox.QUESTION,
										new org.zkoss.zk.ui.event.EventListener<Event>() {
											public void onEvent(Event evt)
													throws InterruptedException {
												if (evt.getName()
														.equals("onOK")) {
													servicioF0006
															.eliminarVarios(eliminarLista);
													msj.mensajeInformacion(Mensaje.eliminado);
													catalogo.actualizarLista(servicioF0006
															.buscarTodosOrdenados());
												}
											}
										});
					}
				} else {
					/* Elimina un solo registro */
					if (clave != null) {
						Messagebox
								.show(Mensaje.deseaEliminar,
										"Alerta",
										Messagebox.OK | Messagebox.CANCEL,
										Messagebox.QUESTION,
										new org.zkoss.zk.ui.event.EventListener<Event>() {
											public void onEvent(Event evt)
													throws InterruptedException {
												if (evt.getName()
														.equals("onOK")) {
													servicioF0006
															.eliminarUno(clave);
													msj.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													catalogo.actualizarLista(servicioF0006
															.buscarTodosOrdenados());
												}
											}
										});
					} else
						msj.mensajeAlerta(Mensaje.noSeleccionoRegistro);
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
				mostrarBotones(false);
			}
		};
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF0006.appendChild(botonera);

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
	
	public boolean validarSeleccion() {
		List<F0006> seleccionados = catalogo.obtenerSeleccionados();
		if (seleccionados == null) {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			return false;
		} else {
			if (seleccionados.isEmpty()) {
				msj.mensajeAlerta(Mensaje.noSeleccionoItem);
				return false;
			} else {
				return true;
			}
		}
	}

	public boolean camposLLenos() {
		if (txtUDCF0006.getText().compareTo("") == 0
				|| txtDL01F0006.getText().compareTo("") == 0
				|| txtCOF0006.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
		
	}
	
	protected boolean validar() {
		if (claveSYExiste()) {
			return false;
		} else {
			if (!camposLLenos()) {
				msj.mensajeAlerta(Mensaje.camposVacios);
				return false;
			} else
				return true;
		}
	}
	
	@Listen("onChange = #txtUDCF0006")
	public boolean claveSYExiste() {
		if (servicioF0006.buscar(txtUDCF0006.getValue()) != null) {
			msj.mensajeAlerta(Mensaje.claveUsada);
			txtUDCF0006.setFocus(true);
			return true;
		} else
			return false;
	}

	public void limpiarCampos() {
		txtUDCF0006.setValue("");
		txtDL01F0006.setValue("");
		txtCOF0006.setValue("");
		txtLDMF0006.setValue("");
		txtSTYLF0006.setValue("");
		txtSBLIF0006.setValue("");
		txtFMODF0006.setValue("");
		txtDL02F0006.setValue("");
		txtDL03F0006.setValue("");
		txtDL04F0006.setValue("");
		txtAN8F0006.setValue("");
		txtTXA1F0006.setValue("");
		txtMCUSF0006.setValue("");
		txtPECCF0006.setValue("");
		txtRP01F0006.setValue("");
		txtRP02F0006.setValue("");
		txtRP03F0006.setValue("");
		txtRP04F0006.setValue("");
		txtRP05F0006.setValue("");
		txtRP06F0006.setValue("");
		txtRP07F0006.setValue("");
		txtRP08F0006.setValue("");
		txtRP09F0006.setValue("");
		txtRP10F0006.setValue("");
		txtRP11F0006.setValue("");
		txtRP12F0006.setValue("");
		txtRP13F0006.setValue("");
		txtRP14F0006.setValue("");
		txtRP15F0006.setValue("");
		txtRP16F0006.setValue("");
		txtRP17F0006.setValue("");
		txtRP18F0006.setValue("");
		txtRP19F0006.setValue("");
		txtRP20F0006.setValue("");
		txtRP21F0006.setValue("");
		txtRP22F0006.setValue("");
		txtRP23F0006.setValue("");
		txtRP24F0006.setValue("");
		txtRP25F0006.setValue("");
		txtRP26F0006.setValue("");
		txtRP27F0006.setValue("");
		txtRP28F0006.setValue("");
		txtRP29F0006.setValue("");
		txtRP30F0006.setValue("");
		lblDescripcionF0004.setValue("");
		lblDescripcionF0010.setValue("");
		txtUDCF0006.setFocus(true);
	}

	public void habilitarCampos() {
		if (txtUDCF0006.isDisabled())
			txtUDCF0006.setDisabled(false);
		if (txtDL01F0006.isDisabled())
			txtDL01F0006.setDisabled(false);
		if (txtCOF0006.isDisabled())
			txtCOF0006.setDisabled(false);
	}

	public boolean camposEditando() {
		if (txtUDCF0006.getText().compareTo("") != 0
				|| txtDL01F0006.getText().compareTo("") != 0
				|| txtCOF0006.getText().compareTo("") != 0
				|| txtLDMF0006.getText().compareTo("") != 0
				|| txtSTYLF0006.getText().compareTo("") != 0
				|| txtSBLIF0006.getText().compareTo("") != 0
				|| txtFMODF0006.getText().compareTo("") != 0
				|| txtDL02F0006.getText().compareTo("") != 0
				|| txtDL03F0006.getText().compareTo("") != 0
				|| txtDL04F0006.getText().compareTo("") != 0
				|| txtAN8F0006.getText().compareTo("") != 0
				|| txtTXA1F0006.getText().compareTo("") != 0
				|| txtMCUSF0006.getText().compareTo("") != 0
				|| txtPECCF0006.getText().compareTo("") != 0
				|| txtRP01F0006.getText().compareTo("") != 0
				|| txtRP02F0006.getText().compareTo("") != 0
				|| txtRP03F0006.getText().compareTo("") != 0
				|| txtRP04F0006.getText().compareTo("") != 0
				|| txtRP05F0006.getText().compareTo("") != 0
				|| txtRP06F0006.getText().compareTo("") != 0
				|| txtRP07F0006.getText().compareTo("") != 0
				|| txtRP08F0006.getText().compareTo("") != 0
				|| txtRP09F0006.getText().compareTo("") != 0
				|| txtRP10F0006.getText().compareTo("") != 0
				|| txtRP11F0006.getText().compareTo("") != 0
				|| txtRP12F0006.getText().compareTo("") != 0
				|| txtRP13F0006.getText().compareTo("") != 0
				|| txtRP14F0006.getText().compareTo("") != 0
				|| txtRP15F0006.getText().compareTo("") != 0
				|| txtRP16F0006.getText().compareTo("") != 0
				|| txtRP17F0006.getText().compareTo("") != 0
				|| txtRP18F0006.getText().compareTo("") != 0
				|| txtRP19F0006.getText().compareTo("") != 0
				|| txtRP20F0006.getText().compareTo("") != 0
				|| txtRP21F0006.getText().compareTo("") != 0
				|| txtRP22F0006.getText().compareTo("") != 0
				|| txtRP23F0006.getText().compareTo("") != 0
				|| txtRP24F0006.getText().compareTo("") != 0
				|| txtRP25F0006.getText().compareTo("") != 0
				|| txtRP26F0006.getText().compareTo("") != 0
				|| txtRP27F0006.getText().compareTo("") != 0
				|| txtRP28F0006.getText().compareTo("") != 0
				|| txtRP29F0006.getText().compareTo("") != 0
				|| txtRP30F0006.getText().compareTo("") != 0
				|| txtRP01F0006.getText().compareTo("") != 0
				) {
			return true;
		} else
			return false;
	}


	@Listen("onOpen = #gpxDatos")
	public void abrirCatalogo() {
		gpxDatos.setOpen(false);
		if (camposEditando()) {
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
									limpiarCampos();
									habilitarCampos();
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
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogo = new Catalogo<F0006>(catalogoF0006, "F0006", unidades, "Unidad Negocio",
				"Descripcion", "Nivel det", "Cta", "Tipo UN", "LM Auxiliar Inactivo", "Mto Cons",
				"CAT 01", "CAT 02", "CAT 03", "CAT 04", "CAT 05", "CAT 06") {



			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					if (unidad.getMcmcu().toLowerCase()
							.startsWith(valores.get(0))
							&& unidad.getMcdc().toLowerCase()
									.startsWith(valores.get(1))
							&& unidad.getMcldm().toLowerCase()
									.startsWith(valores.get(2))
							&& unidad.getMcco().toLowerCase()
									.startsWith(valores.get(3))
							&& unidad.getMcstyl().toLowerCase()
									.startsWith(valores.get(4))
							&& unidad.getMcfmod().toLowerCase()
									.startsWith(valores.get(5))
							&& unidad.getMcsbli().toLowerCase()
									.startsWith(valores.get(6))
							&& unidad.getMcrp01().toLowerCase()
									.startsWith(valores.get(7))
							&& unidad.getMcrp02().toLowerCase()
									.startsWith(valores.get(8))
							&& unidad.getMcrp03().toLowerCase()
									.startsWith(valores.get(9))
							&& unidad.getMcrp04().toLowerCase()
									.startsWith(valores.get(10))
							&& unidad.getMcrp05().toLowerCase()
									.startsWith(valores.get(11))
							&& unidad.getMcrp06().toLowerCase()
									.startsWith(valores.get(12))) {
						unidadnegocio.add(unidad);
					}
				}
				return unidadnegocio;
			}

			@Override
			protected String[] crearRegistros(F0006 negocio) {
				String[] registros = new String[13];
				registros[0] = negocio.getMcmcu();
				registros[1] = negocio.getMcdc();
				registros[2] = negocio.getMcldm();
				registros[3] = negocio.getMcco();
				registros[4] = negocio.getMcstyl();
				registros[5] = negocio.getMcfmod();
				registros[6] = negocio.getMcsbli();
				registros[7] = negocio.getMcrp01();
				registros[8] = negocio.getMcrp02();
				registros[9] = negocio.getMcrp03();
				registros[10] = negocio.getMcrp04();
				registros[11] = negocio.getMcrp05();
				registros[12] = negocio.getMcrp06();
				return registros;
			}
		};
		catalogo.setParent(catalogoF0006);
		// catalogo.doModal();
	}

	
	@Listen("onClick = #btnBuscarTipoUnidad")
	public void mostrarCatalogoF0005() {
	final List<F0005> listF0005 = servicioF0005.buscarTodosOrdenados();
	catalogoF0005 = new Catalogo<F0005>(divCatalogoF0005, "F0005", listF0005, "SY",
			"RT", "KY", "Descripcion 01", "Descripcion 02",
			"Gestion Especial", "Codificacion Fija") {

		@Override
		protected List<F0005> buscar(List<String> valores) {

			List<F0005> listF0005_2 = new ArrayList<F0005>();

			for (F0005 f0005 : listF0005) {
				if (f0005.getId().getDrsy().toLowerCase()
						.startsWith(valores.get(0))
						&& f0005.getId().getDrrt().toLowerCase()
								.startsWith(valores.get(1))
						&& f0005.getId().getDrky().toLowerCase()
								.startsWith(valores.get(2))
						&& f0005.getDrdl01().toLowerCase()
								.startsWith(valores.get(3))
						&& f0005.getDrdl02().toLowerCase()
								.startsWith(valores.get(4))
						&& f0005.getDrsphd().toLowerCase()
								.startsWith(valores.get(5))
						&& f0005.getDrhrdc().toLowerCase()
								.startsWith(valores.get(6))) {
					listF0005_2.add(f0005);
				}
			}
			return listF0005_2;
		}

		@Override
		protected String[] crearRegistros(F0005 f0005) {
			String[] registros = new String[7];
			registros[0] = f0005.getId().getDrsy();
			registros[1] = f0005.getId().getDrrt();
			registros[2] = f0005.getId().getDrky();
			registros[3] = f0005.getDrdl01();
			registros[4] = f0005.getDrdl02();
			registros[5] = f0005.getDrsphd();
			registros[6] = f0005.getDrhrdc();
			return registros;
		}
		};
		catalogoF0005.setClosable(true);
		catalogoF0005.setWidth("80%");
		catalogoF0005.setTitle("Registros");
		catalogoF0005.setParent(divCatalogoF0005);
		catalogoF0005.doModal();
	}
	
	@Listen("onSeleccion = #divCatalogoF0005")
		public void seleccion() {
			F0005 f0005 = catalogoF0005.objetoSeleccionadoDelCatalogo();
			txtSTYLF0006.setValue(f0005.getId().getDrrt());
			lblDescripcionF0004.setValue(f0005.getId().getDrky());
			catalogoF0005.setParent(null);
		}
	
	@Listen("onClick = #btnBuscarCompannia")
	public void mostrarCatalogoF0010() {
		final List<F0010> lista = servicioF0010.buscarTodosOrdenados();
		catalogoF0010 = new Catalogo<F0010>(divCatalogoF0010, "F0010", lista, "Codigo",
				"Nombre", "Nº Periodo", "Patron", "Inicio año Fiscal",
				"Periodo LM", "Inicio año C/P", "Periodo C/P",
				"Inicio año C/C", "Periodo C/C") {

			@Override
			protected List<F0010> buscar(List<String> valores) {

				List<F0010> lista2 = new ArrayList<F0010>();

				for (F0010 f0010 : lista) {
					if (f0010.getCcco().toLowerCase()
							.startsWith(valores.get(0))
							&& f0010.getCcname().toLowerCase()
									.startsWith(valores.get(1))
							&& String.valueOf(f0010.getCcpnc()).toLowerCase()
									.startsWith(valores.get(2))
							&& f0010.getCcdot1().toLowerCase()
									.startsWith(valores.get(3))
							&& f0010.getCcarfj().toString().toLowerCase()
									.startsWith(valores.get(4))
							&& String.valueOf(f0010.getCctxbm()).toLowerCase()
									.startsWith(valores.get(5))
							&& f0010.getCcapfj().toString().toLowerCase()
									.startsWith(valores.get(6))
							&& String.valueOf(f0010.getCctxbo()).toLowerCase()
									.startsWith(valores.get(7))
							&& f0010.getCcdfyj().toString().toLowerCase()
									.startsWith(valores.get(8))
							&& String.valueOf(f0010.getCcpnf()).toLowerCase()
									.startsWith(valores.get(9))) {
						lista2.add(f0010);
					}
				}
				return lista2;
			}

			@Override
			protected String[] crearRegistros(F0010 f0010) {
				String[] registros = new String[10];
				registros[0] = f0010.getCcco();
				registros[1] = f0010.getCcname();
				registros[2] = String.valueOf(f0010.getCcpnc());
				registros[3] = f0010.getCcdot1();
				registros[4] = f0010.getCcarfj().toString();
				registros[5] = String.valueOf(f0010.getCctxbm());
				registros[6] = f0010.getCcapfj().toString();
				registros[7] = String.valueOf(f0010.getCctxbo());
				registros[8] = f0010.getCcdfyj().toString();
				registros[9] = String.valueOf(f0010.getCcpnf());
				return registros;
	

			}
		};
		catalogoF0010.setClosable(true);
		catalogoF0010.setWidth("80%");
		catalogoF0010.setTitle("Registros");
		catalogoF0010.setParent(divCatalogoF0010);
		catalogoF0010.doModal();
	}
	
	@Listen("onSeleccion = #divCatalogoF0010")
		public void seleccionF0010() {
			F0010 f0010 = catalogoF0010.objetoSeleccionadoDelCatalogo();
			txtCOF0006.setValue(f0010.getCcco());
			lblDescripcionF0010.setValue(servicioF0010.buscar(f0010.getCcco()).getCcname());
			catalogoF0010.setParent(null);
		}
}
