package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import modelo.maestros.F0101;
import modelo.maestros.F4008;
import modelo.maestros.F4101;
import modelo.pk.F4008PK;
import componentes.Botonera;
import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;

public class CF4008 extends CGenerico {

	@Wire
	private Div divCatalogoF4008;
	@Wire
	private Div divCatalogoF0101;
	@Wire
	private Div divVF4008;
	@Wire
	private Div botoneraF4008;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Button btnBuscarDireccion0;
	@Wire
	private Label lblDireccion0F0101;
	@Wire
	private Longbox txtTA1F4008;
	@Wire
	private Button btnBuscarDireccion1;
	@Wire
	private Label lblDireccion1F0101;
	@Wire
	private Longbox txtTA2F4008;
	@Wire
	private Button btnBuscarDireccion2;
	@Wire
	private Label lblDireccion2F0101;
	@Wire
	private Longbox txtTA3F4008;
	@Wire
	private Button btnBuscarDireccion3;
	@Wire
	private Label lblDireccion3F0101;
	@Wire
	private Longbox txtTA4F4008;
	@Wire
	private Button btnBuscarDireccion4;
	@Wire
	private Label lblDireccion4F0101;
	@Wire
	private Longbox txtTA5F4008;
	@Wire
	private Div divCatalogoF4101;
	@Wire
	private Longbox txtTAITMF4008;
	@Wire
	private Label lblArticuloF4101;
	@Wire
	private Doublebox txtTXR1F4008;
	@Wire
	private Doublebox txtTXR2F4008;
	@Wire
	private Doublebox txtTXR3F4008;
	@Wire
	private Doublebox txtTXR4F4008;
	@Wire
	private Doublebox txtTXR5F4008;
	@Wire
	private Doublebox txtMTAXF4008;
	@Wire
	private Doublebox txtSumaF4008;
	@Wire
	private Checkbox chxTT1F4008;
	@Wire
	private Checkbox chxTT2F4008;
	@Wire
	private Checkbox chxTT3F4008;
	@Wire
	private Checkbox chxTT4F4008;
	@Wire
	private Textbox txtTATXA1F4008;
	@Wire
	private Datebox dtbTAEFTJF4008;
	@Wire
	private Datebox dtbTAEFDJF4008;
	@Wire
	private Textbox txtTATAXAF4008;
	@Wire
	private Textbox txtGL01F4008;
	@Wire
	private Textbox txtGL02F4008;
	@Wire
	private Textbox txtGL03F4008;
	@Wire
	private Textbox txtGL04F4008;
	@Wire
	private Textbox txtGL05F4008;
	@Wire
	private Button btnBuscarF4101;
	protected List<F4008> listaGeneral = new ArrayList<F4008>();

	CatalogoGenerico<F4008> catalogoF4008;
	Botonera botonera;
	CatalogoGenerico<F0101> catalogoF0101;
	CatalogoGenerico<F4101> catalogoF4101;

	F4008PK clave = null;
	String idBoton = "";

	@Override
	public void inicializar() throws IOException {
		HashMap<String, Object> map = (HashMap<String, Object>) Sessions
				.getCurrent().getAttribute("mapaGeneral");
		if (map != null) {
			if (map.get("tabsGenerales") != null) {
				tabs = (List<Tab>) map.get("tabsGenerales");
				titulo = (String) map.get("titulo");
				map.clear();
				map = null;
			}
		}
		txtTATXA1F4008.setFocus(true);
		mostrarCatalogo();

		botonera = new Botonera() {

			@Override
			public void seleccionar() {

				if (validarSeleccion()) {
					if (catalogoF4008.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F4008 f408 = catalogoF4008
								.objetoSeleccionadoDelCatalogo();
						clave = f408.getId();
						txtTAITMF4008.setDisabled(true);
						txtTATXA1F4008.setDisabled(true);
						dtbTAEFDJF4008.setDisabled(true);
						btnBuscarF4101.setVisible(false);
						txtTATAXAF4008.setValue(f408.getTataxa());

						txtTATXA1F4008.setValue(String.valueOf(f408.getId()
								.getTatxa1()));
						txtGL01F4008.setValue(f408.getTagl01());
						txtGL02F4008.setValue(f408.getTagl02());
						txtGL03F4008.setValue(f408.getTagl03());
						txtGL04F4008.setValue(f408.getTagl04());
						txtGL05F4008.setValue(f408.getTagl05());

						dtbTAEFDJF4008
								.setValue(transformarJulianaAGregoriadeLong(f408
										.getId().getTaefdj()));
						if (f408.getTaeftj() != null)
							dtbTAEFTJF4008
									.setValue(transformarJulianaAGregoria(f408
											.getTaeftj()));
						if (f408.getTamtax() != null)
							txtMTAXF4008.setValue(f408.getTamtax());
						// txtSumaF4008.setValue(f408.getTa); HACER
						Double codigo = f408.getTata1();
						if (codigo != null) {
							F0101 f0101 = servicioF0101.buscar(codigo
									.doubleValue());
							lblDireccion0F0101.setValue(f0101.getAbalph());
							txtTA1F4008.setValue(codigo.longValue());
						}
						Double codigo2 = f408.getTata2();
						if (codigo2 != null) {
							F0101 f0101a = servicioF0101.buscar(codigo2
									.doubleValue());
							lblDireccion1F0101.setValue(f0101a.getAbalph());
							txtTA2F4008.setValue(codigo2.longValue());
						}
						Double codigo3 = f408.getTata3();
						if (codigo3 != null) {
							F0101 f0101b = servicioF0101.buscar(codigo3
									.doubleValue());
							lblDireccion2F0101.setValue(f0101b.getAbalph());
							txtTA3F4008.setValue(codigo3.longValue());
						}
						Double codigo4 = f408.getTata4();
						if (codigo4 != null) {
							F0101 f0101c = servicioF0101.buscar(codigo4
									.doubleValue());
							lblDireccion3F0101.setValue(f0101c.getAbalph());
							txtTA4F4008.setValue(codigo4.longValue());
						}
						Double codigo5 = f408.getTata5();
						if (codigo5 != null) {
							F0101 f0101d = servicioF0101.buscar(codigo5
									.doubleValue());
							lblDireccion4F0101.setValue(f0101d.getAbalph());
							txtTA5F4008.setValue(codigo5.longValue());
						}

						Double articulo = f408.getId().getTaitm();

						txtTAITMF4008.setValue(articulo.longValue());

						if (f408.getTatxr1() != null)
							txtTXR1F4008.setValue(f408.getTatxr1());
						if (f408.getTatxr2() != null)
							txtTXR2F4008.setValue(f408.getTatxr2());
						if (f408.getTatxr3() != null)
							txtTXR3F4008.setValue(f408.getTatxr3());
						if (f408.getTatxr4() != null)
							txtTXR4F4008.setValue(f408.getTatxr4());
						if (f408.getTatxr5() != null)
							txtTXR5F4008.setValue(f408.getTatxr5());

						Double id = f408.getId().getTaitm();
						F4101 f4101 = servicioF4101.buscar(id.doubleValue());
						lblArticuloF4101.setValue(f4101.getImdsc1());

						if (f408.getTatt2().equals("Y"))
							chxTT1F4008.setChecked(true);
						else
							chxTT1F4008.setChecked(false);

						if (f408.getTatt3().equals("Y"))
							chxTT2F4008.setChecked(true);
						else
							chxTT2F4008.setChecked(false);

						if (f408.getTatt4().equals("Y"))
							chxTT3F4008.setChecked(true);
						else
							chxTT3F4008.setChecked(false);

						if (f408.getTatt5().equals("Y"))
							chxTT4F4008.setChecked(true);
						else
							chxTT4F4008.setChecked(false);

						sumar();

					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}

			}

			@Override
			public void salir() {
				cerrarVentana(divVF4008, titulo, tabs);

			}

			@Override
			public void reporte() {
			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
				habilitarTextClave();
			}

			@Override
			public void guardar() {

				if (validar()) {

					F4008 f408 = new F4008();

					if (chxTT1F4008.isChecked())
						f408.setTatt2("Y");
					else
						f408.setTatt2("N");

					if (chxTT2F4008.isChecked())
						f408.setTatt3("Y");
					else
						f408.setTatt3("N");

					if (chxTT3F4008.isChecked())
						f408.setTatt4("Y");
					else
						f408.setTatt4("N");

					if (chxTT4F4008.isChecked())
						f408.setTatt5("Y");
					else
						f408.setTatt5("N");

					F4008PK clave = new F4008PK();
					clave.setTatxa1(txtTATXA1F4008.getValue());
					Date fecha = dtbTAEFDJF4008.getValue();
					BigDecimal valor = transformarGregorianoAJulia(fecha);
					clave.setTaefdj(valor.longValue());
					Long art = txtTAITMF4008.getValue();
					clave.setTaitm(art.doubleValue());

					if (dtbTAEFTJF4008.getText().compareTo("") != 0)
						f408.setTaeftj(transformarGregorianoAJulia(dtbTAEFTJF4008
								.getValue()));

					f408.setTataxa(txtTATAXAF4008.getValue());

					Long id = txtTA1F4008.getValue();
					if (id != null)
						f408.setTata1(id.doubleValue());

					Long id2 = txtTA2F4008.getValue();
					if (id2 != null)
						f408.setTata2(id2.doubleValue());

					Long id3 = txtTA3F4008.getValue();
					if (id3 != null)
						f408.setTata3(id3.doubleValue());

					Long id4 = txtTA4F4008.getValue();
					if (id4 != null)
						f408.setTata4(id4.doubleValue());

					Long id5 = txtTA5F4008.getValue();
					if (id5 != null)
						f408.setTata5(id5.doubleValue());

					if (txtGL01F4008.getValue().compareTo("") != 0)
						f408.setTagl01(txtGL01F4008.getValue());
					if (txtGL02F4008.getValue().compareTo("") != 0)
						f408.setTagl02(txtGL02F4008.getValue());
					if (txtGL03F4008.getValue().compareTo("") != 0)
						f408.setTagl03(txtGL03F4008.getValue());
					if (txtGL04F4008.getValue().compareTo("") != 0)
						f408.setTagl04(txtGL04F4008.getValue());
					if (txtGL05F4008.getValue().compareTo("") != 0)
						f408.setTagl05(txtGL05F4008.getValue());

					if (txtTXR1F4008.getValue() != null)
						f408.setTatxr1(txtTXR1F4008.getValue());
					if (txtTXR2F4008.getValue() != null)
						f408.setTatxr2(txtTXR2F4008.getValue());
					if (txtTXR3F4008.getValue() != null)
						f408.setTatxr3(txtTXR3F4008.getValue());
					if (txtTXR4F4008.getValue() != null)
						f408.setTatxr4(txtTXR4F4008.getValue());
					if (txtTXR5F4008.getValue() != null)
						f408.setTatxr5(txtTXR5F4008.getValue());

					if (txtMTAXF4008.getValue() != null)
						f408.setTamtax(txtMTAXF4008.getValue());

					f408.setId(clave);
					// Falta Guardar la Suma

					servicioF4008.guardar(f408);
					msj.mensajeInformacion(Mensaje.guardado);
					limpiarCampos();
					listaGeneral = servicioF4008.buscarTodosOrdenados();
					catalogoF4008.actualizarLista(listaGeneral);

				}

			}

			@Override
			public void eliminar() {

			}

			@Override
			public void buscar() {

				abrirCatalogo();

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
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF4008.appendChild(botonera);
	}

	public boolean validar() {
		if (!camposLLenos())
			return false;
		else {
			if (!validarArticulo()) {
				return false;
			} else
				return true;
		}

	}

	@Listen("onChange = #txtTAITMF4008; onOk = #txtTAITMF4008")
	public boolean validarArticulo() {
		Long articulo = txtTAITMF4008.getValue();
		if (articulo != null) {
			F4101 f4101 = servicioF4101.buscar(articulo.doubleValue());
			if (f4101 != null) {
				lblArticuloF4101.setValue(f4101.getImdsc1());
				return true;
			} else {
				txtTAITMF4008.setFocus(true);
				msj.mensajeAlerta(Mensaje.articuloNoExiste);
				return false;
			}
		} else {
			return false;
		}

	}

	public boolean camposLLenos() {
		if (txtTATXA1F4008.getText().compareTo("") == 0
				|| txtTAITMF4008.getText().compareTo("") == 0
				|| dtbTAEFDJF4008.getText().compareTo("") == 0) {
			msj.mensajeError(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	protected boolean validarSeleccion() {
		List<F4008> seleccionados = catalogoF4008.obtenerSeleccionados();
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

	public void limpiarCampos() {
		txtTATAXAF4008.setValue("");
		txtTATXA1F4008.setValue("");
		txtGL01F4008.setValue("");
		txtGL02F4008.setValue("");
		txtGL03F4008.setValue("");
		txtGL04F4008.setValue("");
		txtGL05F4008.setValue("");
		dtbTAEFDJF4008.setValue(null);
		dtbTAEFTJF4008.setValue(null);
		txtMTAXF4008.setValue(null);
		txtSumaF4008.setValue(null);
		txtTA1F4008.setValue(null);
		txtTA2F4008.setValue(null);
		txtTA3F4008.setValue(null);
		txtTA4F4008.setValue(null);
		txtTA5F4008.setValue(null);
		txtTAITMF4008.setValue(null);
		txtTXR1F4008.setValue(null);
		txtTXR2F4008.setValue(null);
		txtTXR3F4008.setValue(null);
		txtTXR4F4008.setValue(null);
		txtTXR5F4008.setValue(null);
		habilitarTextClave();
		lblArticuloF4101.setValue("");
		lblDireccion0F0101.setValue("");
		lblDireccion1F0101.setValue("");
		lblDireccion2F0101.setValue("");
		lblDireccion3F0101.setValue("");
		lblDireccion4F0101.setValue("");
		txtTATXA1F4008.setFocus(true);

		if (chxTT1F4008.isChecked())
			chxTT1F4008.setChecked(false);
		if (chxTT2F4008.isChecked())
			chxTT2F4008.setChecked(false);
		if (chxTT3F4008.isChecked())
			chxTT3F4008.setChecked(false);
		if (chxTT4F4008.isChecked())
			chxTT4F4008.setChecked(false);

		clave = null;
		btnBuscarF4101.setVisible(true);
		catalogoF4008.limpiarSeleccion();

	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(!bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		if (clave == null)
			btnBuscarF4101.setVisible(true);
		else
			btnBuscarF4101.setVisible(false);
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
	}

	private boolean camposEditando() {
		if (txtTATAXAF4008.getText().compareTo("") != 0
				|| txtTATXA1F4008.getText().compareTo("") != 0
				|| txtGL01F4008.getText().compareTo("") != 0
				|| txtGL02F4008.getText().compareTo("") != 0
				|| txtGL03F4008.getText().compareTo("") != 0
				|| txtGL04F4008.getText().compareTo("") != 0
				|| txtGL05F4008.getText().compareTo("") != 0
				|| txtMTAXF4008.getText().compareTo("") != 0
				|| txtSumaF4008.getText().compareTo("") != 0
				|| txtTA1F4008.getText().compareTo("") != 0
				|| txtTA2F4008.getText().compareTo("") != 0
				|| txtTA3F4008.getText().compareTo("") != 0
				|| txtTA4F4008.getText().compareTo("") != 0
				|| txtTA5F4008.getText().compareTo("") != 0
				|| txtTAITMF4008.getText().compareTo("") != 0
				|| txtTXR1F4008.getText().compareTo("") != 0
				|| txtTXR2F4008.getText().compareTo("") != 0
				|| txtTXR3F4008.getText().compareTo("") != 0
				|| txtTXR4F4008.getText().compareTo("") != 0
				|| txtTXR5F4008.getText().compareTo("") != 0
				|| chxTT1F4008.isChecked() || chxTT2F4008.isChecked()
				|| chxTT3F4008.isChecked() || chxTT4F4008.isChecked()) {
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
									habilitarTextClave();
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

	private void habilitarTextClave() {
		txtTAITMF4008.setDisabled(false);
		txtTATXA1F4008.setDisabled(false);
		dtbTAEFDJF4008.setDisabled(false);

	}

	@Listen("onClick = #btnBuscarDireccion0,#btnBuscarDireccion1,#btnBuscarDireccion2,#btnBuscarDireccion3,#btnBuscarDireccion4,#btnBuscarDireccion5,#btnBuscarFactor")
	public void mostrarCatalogoDireccion(Event evento) {
		Button boton = (Button) evento.getTarget();
		idBoton = boton.getId();
		final List<F0101> listF0101 = servicioF0101.buscarTodosOrdenados();
		catalogoF0101 = new CatalogoGenerico<F0101>(divCatalogoF0101,
				"Catalogo de Direcciones", listF0101, true, false, false,
				"Nº direccion", "Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal") {

			@Override
			protected List<F0101> buscar(List<String> valores) {

				List<F0101> lista = new ArrayList<F0101>();

				for (F0101 f01 : listF0101) {
					if (String.valueOf(f01.getAban8()).toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f01.getAbalph().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& f01.getAbalky().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& f01.getAbsic().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f01.getAbat1().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& f01.getAbtax().toLowerCase()
									.contains(valores.get(5).toLowerCase())) {
						lista.add(f01);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0101 f013) {
				String[] registros = new String[6];
				registros[0] = String.valueOf(f013.getAban8());
				registros[1] = f013.getAbalph();
				registros[2] = f013.getAbalky();
				registros[3] = f013.getAbsic();
				registros[4] = f013.getAbat1();
				registros[5] = f013.getAbtax();
				return registros;
			}
		};
		catalogoF0101.setParent(divCatalogoF0101);
		catalogoF0101.doModal();
	}

	public void setearValores(F0101 f0101, Longbox txt, Label label) {
		Double doble = f0101.getAban8();
		txt.setValue(doble.longValue());
		label.setValue(f0101.getAbalph());
	}

	@Listen("onSeleccion = #divCatalogoF0101")
	public void seleccionarCatalogo() {
		F0101 f0101 = catalogoF0101.objetoSeleccionadoDelCatalogo();
		switch (idBoton) {
		case "btnBuscarDireccion0":
			setearValores(f0101, txtTA1F4008, lblDireccion0F0101);
			break;
		case "btnBuscarDireccion1":
			setearValores(f0101, txtTA2F4008, lblDireccion1F0101);
			break;
		case "btnBuscarDireccion2":
			setearValores(f0101, txtTA3F4008, lblDireccion2F0101);
			break;
		case "btnBuscarDireccion3":
			setearValores(f0101, txtTA4F4008, lblDireccion3F0101);
			break;
		case "btnBuscarDireccion4":
			setearValores(f0101, txtTA5F4008, lblDireccion4F0101);
			break;
		default:
			break;
		}
		catalogoF0101.setParent(null);
	}

	@Listen("onChange = #txtTXR1F4008, #txtTXR2F4008, #txtTXR3F4008, #txtTXR4F4008, #txtTXR5F4008; onOk = #txtTXR1F4008, #txtTXR2F4008, #txtTXR3F4008, #txtTXR4F4008, #txtTXR5F4008")
	public void sumar() {
		double uno = 0, dos = 0, tres = 0, cuatro = 0, cinco = 0;
		if (txtTXR1F4008.getValue() != null)
			uno = txtTXR1F4008.getValue();
		if (txtTXR2F4008.getValue() != null)
			dos = txtTXR2F4008.getValue();
		if (txtTXR3F4008.getValue() != null)
			tres = txtTXR3F4008.getValue();
		if (txtTXR4F4008.getValue() != null)
			cuatro = txtTXR4F4008.getValue();
		if (txtTXR5F4008.getValue() != null)
			cinco = txtTXR5F4008.getValue();

		txtSumaF4008.setValue(uno + dos + tres + cuatro + cinco);
	}

	@Listen("onChange = #txtTA1F4008, #txtTA2F4008, #txtTA3F4008, #txtTA4F4008, #txtTA5F4008; onOk = #txtTA1F4008, #txtTA2F4008, #txtTA3F4008, #txtTA4F4008, #txtTA5F4008 ")
	public void buscarNombre(Event evento) {
		F0101 f0101 = new F0101();
		Longbox txt = (Longbox) evento.getTarget();
		switch (txt.getId()) {
		case "txtTA1F4008":
			f0101 = servicioF0101.buscar(txtTA1F4008.getValue());
			if (f0101 != null)
				setearValores(f0101, txtTA1F4008, lblDireccion0F0101);
			else
				noEstaBien(txtTA1F4008);
			break;
		case "txtTA2F4008":
			f0101 = servicioF0101.buscar(txtTA2F4008.getValue());
			if (f0101 != null)
				setearValores(f0101, txtTA2F4008, lblDireccion1F0101);
			else
				noEstaBien(txtTA2F4008);
			break;
		case "txtTA3F4008":
			f0101 = servicioF0101.buscar(txtTA3F4008.getValue());
			if (f0101 != null)
				setearValores(f0101, txtTA3F4008, lblDireccion2F0101);
			else
				noEstaBien(txtTA3F4008);
			break;
		case "txtTA4F4008":
			f0101 = servicioF0101.buscar(txtTA4F4008.getValue());
			if (f0101 != null)
				setearValores(f0101, txtTA4F4008, lblDireccion3F0101);
			else
				noEstaBien(txtTA1F4008);
			break;
		case "txtTA5F4008":
			f0101 = servicioF0101.buscar(txtTA5F4008.getValue());
			if (f0101 != null)
				setearValores(f0101, txtTA5F4008, lblDireccion4F0101);
			else
				noEstaBien(txtTA5F4008);
			break;
		default:
			break;
		}
	}

	public void noEstaBien(Longbox txt) {
		msj.mensajeAlerta(Mensaje.noHayRegistros);
		txt.setValue(null);
		txt.setFocus(true);
	}

	@Listen("onClick = #btnBuscarF4101")
	public void mostrarCatalogoF4101() {
		final List<F4101> listF4101 = servicioF4101.buscarTodosOrdenados();
		catalogoF4101 = new CatalogoGenerico<F4101>(divCatalogoF4101, "Catalogo de Artículos",
				listF4101, true, false, true, "Codigo", "Descripcion") {

			@Override
			protected List<F4101> buscar(List<String> valores) {

				List<F4101> lista = new ArrayList<F4101>();

				for (F4101 f4101 : listF4101) {
					if (String.valueOf(f4101.getImitm()).toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f4101.getImdsc1().toLowerCase()
									.contains(valores.get(1).toLowerCase())) {
						lista.add(f4101);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4101 f4101) {
				String[] registros = new String[2];
				registros[0] = String.valueOf(f4101.getImitm());
				registros[1] = f4101.getImdsc1();
				return registros;
			}
		};
		catalogoF4101.setParent(divCatalogoF4101);
		catalogoF4101.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF4101")
	public void seleccion() {
		F4101 f4101 = catalogoF4101.objetoSeleccionadoDelCatalogo();
		Double doble = f4101.getImitm();
		txtTAITMF4008.setValue(doble.longValue());
		lblArticuloF4101.setValue(f4101.getImdsc1());
		catalogoF4101.setParent(null);
	}

	public void mostrarCatalogo() {
		listaGeneral = servicioF4008.buscarTodosOrdenados();
		catalogoF4008 = new CatalogoGenerico<F4008>(divCatalogoF4008, "F4008",
				listaGeneral, false, false, true, "Zona/Tipo impositivo",
				"Descripcion zona fiscal", "Fecha efectiva", "Fecha vto",
				"Tipo imptvo 1", "Tipo imptvo 2", "Tipo imptvo 3",
				"Tipo imptvo 4", "Tipo imptvo 5", "Nro corto articulo") {

			@Override
			protected List<F4008> buscar(List<String> valores) {

				List<F4008> lista = new ArrayList<F4008>();

				for (F4008 f4008 : listaGeneral) {
					if (f4008.getId().getTatxa1().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f4008.getTataxa().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& String
									.valueOf(
											transformarJulianaAGregoria(f4008
													.getTaeftj()))
									.toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& String
									.valueOf(
											transformarJulianaAGregoriadeLong(f4008
													.getId().getTaefdj()))
									.toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& String.valueOf(f4008.getTatxr1()).toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& String.valueOf(f4008.getTatxr2()).toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& String.valueOf(f4008.getTatxr3()).toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& String.valueOf(f4008.getTatxr4()).toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& String.valueOf(f4008.getTatxr5()).toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& String.valueOf(f4008.getId().getTaitm())
									.toLowerCase()
									.contains(valores.get(9).toLowerCase())) {
						lista.add(f4008);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4008 f4008) {
				String[] registros = new String[10];
				registros[0] = f4008.getId().getTatxa1();
				registros[1] = f4008.getTataxa();
				if (f4008.getTaeftj() != null)
					registros[2] = formatoFecha
							.format(transformarJulianaAGregoria(f4008
									.getTaeftj()));
				else
					registros[2] = "";
				registros[3] = formatoFecha
						.format(transformarJulianaAGregoriadeLong(f4008.getId()
								.getTaefdj()));
				if (f4008.getTatxr1() != null)
					registros[4] = String.valueOf(f4008.getTatxr1());
				else
					registros[4] = "";
				if (f4008.getTatxr2() != null)
					registros[5] = String.valueOf(f4008.getTatxr2());
				else
					registros[5] = "";
				if (f4008.getTatxr3() != null)
					registros[6] = String.valueOf(f4008.getTatxr3());
				else
					registros[6] = "";
				if (f4008.getTatxr4() != null)
					registros[7] = String.valueOf(f4008.getTatxr4());
				else
					registros[7] = "";
				if (f4008.getTatxr5() != null)
					registros[8] = String.valueOf(f4008.getTatxr5());
				else
					registros[8] = "";
				registros[9] = String.valueOf(f4008.getId().getTaitm());
				return registros;
			}
		};
		catalogoF4008.setParent(divCatalogoF4008);
	}
}
