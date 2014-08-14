package controlador.transacciones;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.generico.Generico;
import modelo.maestros.F00021;
import modelo.maestros.F0006;
import modelo.maestros.F0010;
import modelo.maestros.F0101;
import modelo.maestros.F4100;
import modelo.maestros.F4101;
import modelo.maestros.F41021;
import modelo.maestros.F4105;
import modelo.pk.F00021PK;
import modelo.pk.F41021PK;
import modelo.pk.F4105PK;
import modelo.transacciones.F4111;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;

import controlador.maestros.CGenerico;

public class CF4111 extends CGenerico {

	private static final long serialVersionUID = -3406820146315915655L;
	@Wire
	private Doublebox txtDoc;
	@Wire
	private Datebox dtbFechaTransaccion;
	// @Wire
	// private Div divbuscadorTipo;
	// BuscadorUDC buscadorTipo;
	@Wire
	private Textbox txtTipo;
	@Wire
	private Datebox dtbFechaLm;
	@Wire
	private Textbox txtExplicacion;
	@Wire
	private Textbox txtPlanta1;
	@Wire
	private Button btnBuscarPlanta1;
	@Wire
	private Label lblPlanta1;
	@Wire
	private Textbox txtPlanta2;
	@Wire
	private Button btnBuscarPlanta2;
	@Wire
	private Label lblPlanta2;
	@Wire
	private Doublebox txtItem;
	@Wire
	private Button btnBuscarItem;
	@Wire
	private Label lblItem;
	@Wire
	private Spinner spnCantidad;
	@Wire
	private Textbox txtUM;
	@Wire
	private Spinner spnCantidad2;
	@Wire
	private Textbox txtUM2;
	@Wire
	private Textbox txtUbicacion1;
	@Wire
	private Button btnBuscarUbicacion1;
	@Wire
	private Label lblUbicacion1;
	// @Wire
	// private Textbox txtLote1;
	// @Wire
	// private Button btnBuscarLote1;
	// @Wire
	// private Label lblLote1;
	@Wire
	private Textbox txtUbicacion2;
	@Wire
	private Doublebox txtOrden;
	@Wire
	private Button btnBuscarUbicacion2;
	@Wire
	private Label lblUbicacion2;
	// @Wire
	// private Textbox txtLote2;
	// @Wire
	// private Button btnBuscarLote2;
	@Wire
	private Label lblF0101;
	@Wire
	private Label lblF0101Dynamic;
	@Wire
	private Longbox txtF0101;
	@Wire
	private Button btnBuscarF0101;
	// @Wire
	// private Label lblLote2;
	@Wire
	private Listbox ltbItems;
	@Wire
	private Doublespinner spnCosto;
	@Wire
	private Label lblCosto;
	// --------------------
	@Wire
	private Button btnAgregar;
	@Wire
	private Button btnVer;
	@Wire
	private Button btnRemover;
	@Wire
	private Div divVF4111;
	@Wire
	private Div botoneraF4111;
	@Wire
	private Div catalogoF4111;
	@Wire
	private Div catalogoF4111Emergente;
	@Wire
	private Groupbox gpxDatosF4111;
	@Wire
	private Groupbox gpxRegistroF4111;
	@Wire
	private Div catalogoSucursalF0006;
	@Wire
	private Div catalogoUbicacionF4100;
	@Wire
	private Div catalogoLoteF4108;
	@Wire
	private Div catalogoItemF4101;
	@Wire
	private Div catalogoDireccionF0101;
	@Wire
	private Row rowPlanta1;
	@Wire
	private Row rowPlanta2;
	@Wire
	private Row rowF0101;
	@Wire
	private Hbox boxOrden;
	@Wire
	private Hbox boxCosto;
	@Wire
	private Hbox boxCantidad;
	@Wire
	private Hbox boxUbicacion2;
	@Wire
	private Label lblNombreUbicacion2;
	@Wire
	private Label lblNombreUbicacion;
	@Wire
	private Label lblCantidad;
	@Wire
	private Label lblCantidad2;
	@Wire
	private Label lblExplicacion;
	@Wire
	private Label lblExplicacionRequerida;
	@Wire
	private Row rowF4111P;
	@Wire
	private Longbox txtF4111P;
	@Wire
	private Button btnBuscarF4111P;
	@Wire
	private Label lblF4111P;
	Botonera botonera;
	Catalogo<F4111> catalogo;
	Catalogo<F4111> catalogoEmergente;
	Catalogo<F0006> catalogoF0006;
	Catalogo<F4100> catalogoF4100;
	Catalogo<F4101> catalogoF4101;
	Catalogo<F0101> catalogoF0101;
	Catalogo<F0010> catalogoF4108; // FALTA ESTE 4108
	private String idBotonF0006 = "";
	private String idBotonF4100 = "";
	private String idBotonF4108 = "";
	private List<Generico> lista = new ArrayList<Generico>();
	private String titulo = "";
	private String tipo = "";
	double id = (double) 0;
	private String mcu = "";
	private String mcu2 = "";
	private Double claveDoc = null;
	private Double clave41 = null;

	public String getTitulo() {
		return titulo;
	}

	@Override
	public void inicializar() throws IOException {
		HashMap<String, Object> map = (HashMap<String, Object>) Sessions
				.getCurrent().getAttribute("mapaGeneral");
		if (map != null) {
			if (map.get("tabsGenerales") != null) {
				tabs = (List<Tab>) map.get("tabsGenerales");
				titulo = (String) map.get("titulo");
				System.out.println(titulo);
				System.out.println(tabs.size());
				map.clear();
				map = null;
			}
		}
		switch (titulo) {
		case "Entre Localidades":
			rowF0101.setVisible(false);
			rowPlanta2.setVisible(false);
			txtTipo.setValue("IT");
			tipo = "IT";
			Listheader cabeza1 = (Listheader) ltbItems.getChildren().get(0)
					.getChildren().get(6);
			cabeza1.setVisible(true);
			break;
		case "Entre Almacenes":
			rowF0101.setVisible(false);
			txtTipo.setValue("ET");
			tipo = "ET";
			Listheader cabeza2 = (Listheader) ltbItems.getChildren().get(0)
					.getChildren().get(6);
			cabeza2.setVisible(true);
			
			break;
		case "De Cantidad":
			rowF0101.setVisible(false);
			boxUbicacion2.setVisible(false);
			txtUbicacion2.setVisible(false);
			rowPlanta2.setVisible(false);
			lblNombreUbicacion2.setVisible(false);
			btnBuscarUbicacion2.setVisible(false);
			lblNombreUbicacion.setValue("Ubicacion");
			txtTipo.setValue("IA");
			spnCantidad.setConstraint("min -99999999 max 99999999");
			tipo = "IA";
			break;
		case "De Costo":
			rowF0101.setVisible(false);
			boxCosto.setVisible(true);
			lblCosto.setVisible(true);
			spnCosto.setVisible(true);
			rowPlanta2.setVisible(false);
			boxUbicacion2.setVisible(false);
			txtUbicacion2.setVisible(false);
			lblCantidad.setVisible(false);
			spnCantidad.setVisible(false);
			boxCantidad.setVisible(false);
			lblCantidad2.setVisible(false);
			spnCantidad2.setVisible(false);
			lblNombreUbicacion2.setVisible(false);
			btnBuscarUbicacion2.setVisible(false);
			lblNombreUbicacion.setValue("Ubicacion");
			txtTipo.setValue("I4");
			tipo = "I4";
			break;
		case "Despacho a Paciente":
			lblExplicacion.setValue("Datos Paciente");
			lblExplicacionRequerida.setVisible(true);
			lblF0101Dynamic.setValue("Paciente");
			rowF0101.setVisible(false);
			rowPlanta2.setVisible(false);
			boxUbicacion2.setVisible(false);
			txtUbicacion2.setVisible(false);
			lblNombreUbicacion2.setVisible(false);
			btnBuscarUbicacion2.setVisible(false);
			lblNombreUbicacion.setValue("Ubicacion");
			txtTipo.setValue("MK");
			tipo = "MK";
			break;
		case "Devolucion a Proveedor":
			rowF4111P.setVisible(true);
			lblF0101Dynamic.setValue("Proveedor");
			boxCosto.setVisible(true);
			lblCosto.setVisible(true);
			spnCosto.setVisible(true);
			spnCosto.setReadonly(true);
			spnCosto.setButtonVisible(false);
			rowPlanta2.setVisible(false);
			boxUbicacion2.setVisible(false);
			txtUbicacion2.setVisible(false);
			lblNombreUbicacion2.setVisible(false);
			btnBuscarUbicacion2.setVisible(false);
			lblNombreUbicacion.setValue("Ubicacion");
			txtTipo.setValue("DP");
			tipo = "DP";
			break;
		case "Por orden de Compra":
			boxCosto.setVisible(true);
			lblCosto.setVisible(true);
			spnCosto.setVisible(true);
			lblF0101Dynamic.setValue("Proveedor");
			rowPlanta1.setVisible(false);
			txtTipo.setValue("OV");
			txtUbicacion2.setVisible(false);
			boxUbicacion2.setVisible(false);
			lblNombreUbicacion2.setVisible(false);
			btnBuscarUbicacion2.setVisible(false);
			lblNombreUbicacion.setValue("Ubicacion");
			boxOrden.setVisible(true);
			txtOrden.setVisible(true);
			tipo = "OV";
			break;
		}
		txtDoc.setFocus(true);
		mostrarCatalogo();
		// List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
		// "DT");
		// ----------------------------- Acomodar UDC
		// buscadorTipo = new BuscadorUDC("Tipo Documento", 10, listaF0005,
		// true,
		// false, false, "00", "DT") {
		// @Override
		// protected F0005 buscar() {
		// return servicioF0005.buscar("00", "DT",
		// buscadorTipo.obtenerCaja());
		// }
		// };
		// divbuscadorTipo.appendChild(buscadorTipo);
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						System.out.println("hola");
						F4111 f4111 = catalogo.objetoSeleccionadoDelCatalogo();
						List<F4111> listF4111 = servicioF4111.buscarPorDoc(
								f4111.getIldoc(), tipo);
						txtDoc.setValue(f4111.getIldoc());
						if (f4111.getIldoco() != null)
							txtOrden.setValue(f4111.getIldoco());
						if (f4111.getIlan8() != null)
							txtF0101.setValue(f4111.getIlan8().longValue());
						txtPlanta1.setValue(f4111.getIlmcu());
						txtPlanta2.setValue(f4111.getIlmmcu());
						txtExplicacion.setValue(f4111.getIltrex());
						dtbFechaLm.setValue(transformarJulianaAGregoria(f4111
								.getIltrdj()));
						dtbFechaTransaccion
								.setValue(transformarJulianaAGregoria(f4111
										.getIlcrdj()));
						for (int i = 0; i < listF4111.size(); i++) {
							F4101 f4101 = servicioF4101.buscar(listF4111.get(i)
									.getIlitm());
							Generico generico = new Generico(listF4111.get(i)
									.getIlitm(), f4101.getImdsc1(),
									f4101.getImuom1(), listF4111.get(i)
											.getIlmcu(), "", listF4111.get(i)
											.getIlmmcu(), "", listF4111.get(i)
											.getIltrqt().intValue(), listF4111
											.get(i).getIluncs());
							generico.setValor11(listF4111.get(i).getIlpaid());
							lista.add(generico);
						}
						ltbItems.setModel(new ListModelList<Generico>(lista));
						ltbItems.renderAll();
						mostrarBotones(false);
						abrirRegistro();
						botonera.getChildren().get(3).setVisible(false);
					} else
						msj.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF4111, titulo, tabs);
			}

			@Override
			public void reporte() {
			}

			@Override
			public void limpiar() {
				botonera.getChildren().get(3).setVisible(true);
				mostrarBotones(false);
				limpiarCampos();
			}

			@Override
			public void guardar() {
				boolean guardar = true;
				if (id == 0)
					guardar = validar();
				if (guardar) {

					synchronized (this) {
						while (!nextNumber) {
							try {
								wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
						nextNumber = false;
						try {
							// if (id == 0) {
							// id = numeroSiguiente();
							// }
							// termina el next number

							F4111 f4111 = new F4111();
							// No selecciona items
							if (lista.size() == 0) {
								f4111 = new F4111();
								f4111.setIlukid(id);
								f4111.setIlmcu(txtPlanta1.getValue());
								f4111.setIlmmcu(txtPlanta2.getValue());
								Integer inte = spnCantidad.getValue();
								if (!tipo.equals("OV")) {
									if (!tipo.equalsIgnoreCase("IA"))
										inte = inte * -1;
								}
								f4111.setIltrqt(inte.doubleValue());
								f4111.setIldoc(txtDoc.getValue());
								f4111.setIldoco(txtOrden.getValue());
								f4111.setIltrdj(transformarGregorianoAJulia(dtbFechaLm
										.getValue()));
								f4111.setIlcrdj(transformarGregorianoAJulia(dtbFechaTransaccion
										.getValue()));
								f4111.setIluser(nombreUsuarioSesion());
								f4111.setIlvpej(transformarGregorianoAJulia(fecha));
								f4111.setIlicu(Double.valueOf(horaAuditoria));
								f4111.setIldct(txtTipo.getValue());
								f4111.setIltrex(txtExplicacion.getValue());
								f4111.setIluncs((double) 0);
								f4111.setIlpaid((double) (inte * 0));
								f4111.setIllotn("");
								servicioF4111.guardar(f4111);
							}
							// Selecciona items
							for (int i = 0; i < lista.size(); i++) {
								Generico modelo = lista.get(i);
								Double numero = modelo.getValor1();
								int cantidad = modelo.getValor8();
								String um = modelo.getValor3();
								String ubicacion1 = modelo.getValor4();
								String ubicacion2 = modelo.getValor6();
								Double costoActualizar = modelo.getValor10();
								f4111 = new F4111();
								f4111.setIluser(nombreUsuarioSesion());
								f4111.setIlvpej(transformarGregorianoAJulia(fecha));
								f4111.setIlicu(Double.valueOf(horaAuditoria));
								f4111.setIlukid(numeroSiguiente());
								f4111.setIldoc(txtDoc.getValue());
								f4111.setIldoco(txtOrden.getValue());
								f4111.setIltrdj(transformarGregorianoAJulia(dtbFechaLm
										.getValue()));
								f4111.setIlcrdj(transformarGregorianoAJulia(dtbFechaTransaccion
										.getValue()));
								f4111.setIldct(txtTipo.getValue());
								f4111.setIltrex(txtExplicacion.getValue());
								f4111.setIllotn("");
								String mcu = "";
								String mcu2 = "";
								// si es ov intercambio las F0006
								if (tipo.equalsIgnoreCase("OV")) {
									mcu = txtPlanta2.getValue();
									mcu2 = txtPlanta1.getValue();
								} else {
									mcu = txtPlanta1.getValue();
									mcu2 = txtPlanta2.getValue();
								}
								f4111.setIlmcu(mcu);
								if (tipo.equalsIgnoreCase("IT"))
									mcu2 = mcu;
								f4111.setIlmmcu(mcu2);
								f4111.setIllocn(ubicacion1);
								f4111.setIlasid(ubicacion2);
								f4111.setIlitm(numero);
								f4111.setIltrum(um);
								// busco el an8
								if (txtF0101.getText().compareTo("") != 0) {
									Long valor = txtF0101.getValue();
									f4111.setIlan8(valor.doubleValue());
								}
								// busco el costo unitario
								F4105 f4105 = new F4105();
								F4105PK claveCostoUnitario = new F4105PK();
								claveCostoUnitario.setCoitm(numero);
								claveCostoUnitario.setComcu(mcu);
								claveCostoUnitario.setColocn("");
								claveCostoUnitario.setColotn("");
								claveCostoUnitario.setColedg("02");
								f4105 = servicioF4105
										.buscar(claveCostoUnitario);
								Double costoUnitarioAnterior = (double) 0;
								Double costoUnitario = (double) 0;
								if (f4105 != null) {
									costoUnitario = f4105.getCouncs();
									costoUnitarioAnterior = f4105.getCouncs();
								}

								if (tipo.equalsIgnoreCase("OV")
										|| tipo.equalsIgnoreCase("DP")) {
									costoUnitario = costoActualizar;
								}

								if (tipo.equals("I4"))
									f4111.setIluncs(costoActualizar);
								else
									f4111.setIluncs(costoUnitario);
								// si es orden de compra o ajuste por
								// cantidad sera negativa la cantidad
								Integer inte = cantidad;
								if (!tipo.equals("OV")) {
									if (!tipo.equalsIgnoreCase("IA"))
										inte = inte * -1;
								}
								System.out.println(tipo);
								System.out.println(inte);
								f4111.setIltrqt(inte.doubleValue());
								Double total = inte * costoUnitario;
								if (tipo.equals("I4"))
									f4111.setIlpaid(costoActualizar);
								else
									f4111.setIlpaid(total);
								servicioF4111.guardar(f4111);
								// guardo en el cardex y actualizo en la
								// tabla de saldo
								F41021PK claveSaldo = new F41021PK();
								claveSaldo.setLiitm(numero);
								claveSaldo.setLilocn(ubicacion1);
								claveSaldo.setLilotn("");
								claveSaldo.setLimcu(mcu);
								F41021 f41021 = servicioF41021
										.buscar(claveSaldo);
								double cantidadAnterior = 0;
								if (f41021 != null) {
									cantidadAnterior = f41021.getLipqoh();
									f41021.setLipqoh(f41021.getLipqoh() + inte);
								} else {
									f41021 = new F41021();
									f41021.setId(claveSaldo);
									f41021.setLipqoh(inte.doubleValue());
								}
								servicioF41021.guardar(f41021);
								// actualizo los costos

								if (!tipo.equals("MK")) {
									if (!tipo.equals("IT")) {
										servicioF4105.actualizarCostoPromedio(
												claveCostoUnitario, inte,
												cantidadAnterior,
												costoUnitario,
												costoUnitarioAnterior);
									}
								}
								if (tipo.equals("OV")) {
									claveCostoUnitario.setColedg("01");
									servicioF4105.actualizarUltimoCosto(
											claveCostoUnitario, costoUnitario);
								}
								// guardo en la tabla de saldo y si es
								// transaccion sigo con esto
								if (tipo.equals("ET") || tipo.equals("IT")) {
									// busco el costo del segundo item
									claveCostoUnitario = new F4105PK();
									claveCostoUnitario.setCoitm(numero);
									claveCostoUnitario.setComcu(mcu2);
									claveCostoUnitario.setColocn("");
									claveCostoUnitario.setColotn("");
									claveCostoUnitario.setColedg("02");
									f4105 = servicioF4105
											.buscar(claveCostoUnitario);
									Double costo2 = (double) 0;
									System.out.println("objeto" + f4105);
									costoUnitarioAnterior = (double) 0;
									if (f4105 != null) {
										costoUnitarioAnterior = f4105
												.getCouncs();
										costo2 = f4105.getCouncs();
									}
									Double total2 = inte * costo2;
									// <Nuevooo
									f4111 = new F4111();
									f4111.setIluser(nombreUsuarioSesion());
									f4111.setIlvpej(transformarGregorianoAJulia(fecha));
									f4111.setIlicu(Double
											.valueOf(horaAuditoria));
									f4111.setIlukid(numeroSiguiente());
									f4111.setIldoc(txtDoc.getValue());
									f4111.setIldoco(txtOrden.getValue());
									f4111.setIltrdj(transformarGregorianoAJulia(dtbFechaLm
											.getValue()));
									f4111.setIlcrdj(transformarGregorianoAJulia(dtbFechaTransaccion
											.getValue()));
									f4111.setIldct(txtTipo.getValue());
									f4111.setIltrex(txtExplicacion.getValue());
									f4111.setIllotn("");
									f4111.setIlmcu(mcu2);
									f4111.setIlmmcu(mcu);
									f4111.setIllocn(ubicacion2);
									f4111.setIlasid(ubicacion1);
									f4111.setIlitm(numero);
									f4111.setIltrum(um);
									f4111.setIluncs(costo2);
									f4111.setIltrqt(inte.doubleValue() * (-1));
									f4111.setIlpaid(costo2
											* (inte.doubleValue() * (-1)));
									servicioF4111.guardar(f4111);

									// >Nuevoooo

									// busco en la tabla de saldo
									claveSaldo = new F41021PK();
									claveSaldo.setLiitm(numero);
									claveSaldo.setLilocn(ubicacion2);
									claveSaldo.setLimcu(mcu2);
									claveSaldo.setLilotn("");
									F41021 f410212 = servicioF41021
											.buscar(claveSaldo);
									if (f410212 != null) {
										cantidadAnterior = f410212.getLipqoh();
										f410212.setLipqoh(f410212.getLipqoh()
												+ (inte * (-1)));
									} else {
										f410212 = new F41021();
										f410212.setId(claveSaldo);
										f410212.setLipqoh(inte.doubleValue()
												* (-1));
									}
									if (tipo.equals("ET"))
										servicioF4105.actualizarCostoPromedio(
												claveCostoUnitario,
												(inte * -1), cantidadAnterior,
												costoUnitario,
												costoUnitarioAnterior);
									System.out.println("valor" + total2);
									servicioF41021.guardar(f410212);
									// guardo en la tabla de saldo y si
									// es ajuste de costo sigo
								}
								if (tipo.equals("I4")) {
									System.out.println("entro");
									// busco el costo por si se embasura
									// por alla
									claveCostoUnitario = new F4105PK();
									claveCostoUnitario.setCoitm(numero);
									claveCostoUnitario.setComcu(mcu);
									claveCostoUnitario.setColocn("");
									claveCostoUnitario.setColotn("");
									claveCostoUnitario.setColedg("02");
									f4105 = servicioF4105
											.buscar(claveCostoUnitario);
									System.out.println(f4105);
									if (f4105 != null)
										f4105.setCouncs(costoActualizar);
									else {
										f4105 = new F4105();
										f4105.setId(claveCostoUnitario);
										f4105.setCouncs(costoActualizar);
									}
									servicioF4105.guardar(f4105);
								}
							}
						} catch (Exception a) {
							nextNumber = true;
							a.printStackTrace();
							System.out.println("error");
						}
					}
					synchronized (this) {
						nextNumber = true;
						notifyAll();
					}
					catalogo.actualizarLista(servicioF4111
							.buscarTodosOrdenadosPorTipo(tipo));
					msj.mensajeInformacion(Mensaje.guardado);
					limpiar();

				} else
					msj.mensajeAlerta(Mensaje.camposVacios);
			}

			@Override
			public void eliminar() {
				if (gpxDatosF4111.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
					}
				} else {
					/* Elimina un solo registro */
					if (id != 0) {
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
				botonera.getChildren().get(3).setVisible(true);
			}
		};
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(4).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF4111.appendChild(botonera);
	}

	protected double numeroSiguiente() {
		double numeroNext = servicioF00021.Numero("6", "JE");
		if (numeroNext != 0) {
			id = numeroNext + 1;
			F00021 f021 = servicioF00021.buscar("6", "JE");
			f021.setNln001(id);
			servicioF00021.guardar(f021);
		} else {
			id = 1;
			F00021 f021 = new F00021();
			F00021PK clave21 = new F00021PK();
			clave21.setNldct("JE");
			clave21.setNlkco("6");
			clave21.setNlctry((double) 0);
			clave21.setNlfy((double) 0);
			f021.setId(clave21);
			f021.setNln001(id);
			servicioF00021.guardar(f021);
		}
		return id;
	}

	protected boolean validar() {
		switch (tipo) {
		case "OV":
			if (txtDoc.getText().compareTo("") == 0
					|| txtOrden.getText().compareTo("") == 0
					|| txtF0101.getText().compareTo("") == 0
					|| txtPlanta2.getText().compareTo("") == 0)
				return false;
			else
				return true;
		case "ET":
			if (txtDoc.getText().compareTo("") == 0
					|| txtPlanta1.getText().compareTo("") == 0
					|| txtPlanta2.getText().compareTo("") == 0)
				return false;
			else
				return true;
		case "IT":
			if (txtDoc.getText().compareTo("") == 0
					|| txtPlanta1.getText().compareTo("") == 0)
				return false;
			else
				return true;
		case "IA":
		case "I4":
			if (txtDoc.getText().compareTo("") == 0
					|| txtPlanta1.getText().compareTo("") == 0)
				return false;
			else
				return true;
		case "MK":
			if (txtDoc.getText().compareTo("") == 0
					|| txtPlanta1.getText().compareTo("") == 0
					|| txtExplicacion.getText().compareTo("") == 0)
				return false;
			else
				return true;
		default:
			if (txtDoc.getText().compareTo("") == 0
					|| txtPlanta1.getText().compareTo("") == 0
					|| txtF0101.getText().compareTo("") == 0)
				return false;
			else
				return true;
		}
	}

	protected void limpiarCampos() {
		txtDoc.setValue(null);
		txtOrden.setValue(null);
		txtExplicacion.setValue("");
		txtF0101.setValue(null);
		txtPlanta1.setValue("");
		txtPlanta2.setValue("");
		limpiarCamposItem();
		ltbItems.getItems().clear();
		lista.clear();
		claveDoc = null;
		clave41 = null;
	}

	protected void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(bol);
		botonera.getChildren().get(0).setVisible(bol);
		// botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
	}

	@Listen("onOpen = #gpxRegistroF4111")
	public void abrirRegistro() {
		botonera.getChildren().get(3).setVisible(true);
		gpxDatosF4111.setOpen(false);
		gpxRegistroF4111.setOpen(true);
		mostrarBotones(false);
	}

	@Listen("onOpen = #gpxDatosF4111")
	public void abrirCatalogo() {
		gpxDatosF4111.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatosF4111.setOpen(false);
								gpxRegistroF4111.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									botonera.getChildren().get(3)
											.setVisible(false);
									gpxDatosF4111.setOpen(true);
									gpxRegistroF4111.setOpen(false);
									limpiarCampos();
									habilitarTextClave();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			botonera.getChildren().get(3).setVisible(false);
			gpxDatosF4111.setOpen(true);
			gpxRegistroF4111.setOpen(false);
			mostrarBotones(true);
		}
	}

	protected void habilitarTextClave() {
		if (txtDoc.isDisabled())
			txtDoc.setDisabled(false);
	}

	private boolean camposEditando() {
		if (txtDoc.getText().compareTo("") != 0
				|| txtExplicacion.getText().compareTo("") != 0
				|| txtItem.getText().compareTo("") != 0
				|| txtPlanta1.getText().compareTo("") != 0
				|| txtPlanta2.getText().compareTo("") != 0
				|| txtUbicacion1.getText().compareTo("") != 0
				|| txtUbicacion2.getText().compareTo("") != 0
				|| txtUM.getText().compareTo("") != 0
				|| txtUM2.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	protected boolean validarSeleccion() {
		List<F4111> seleccionados = catalogo.obtenerSeleccionados();
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

	private void mostrarCatalogo() {
		final List<F4111> unidades = servicioF4111
				.buscarTodosOrdenadosPorTipo(tipo);
		catalogo = new Catalogo<F4111>(catalogoF4111, "F4111", unidades, false,
				true, true, "Numero Documento", "Tipo doc", "Fecha LM",
				"Explicacion", "Sucursal/planta", "Fecha transaccion") {

			@Override
			protected List<F4111> buscar(List<String> valores) {

				List<F4111> unidadnegocio = new ArrayList<F4111>();

				for (F4111 unidad : unidades) {
					if (unidad.getIldoc().toString().toLowerCase()
							.startsWith(valores.get(0))
							&& unidad.getIldct().toLowerCase()
									.startsWith(valores.get(1))
							&& formatoFecha
									.format(transformarJulianaAGregoria(unidad
											.getIltrdj())).toLowerCase()
									.startsWith(valores.get(2))
							&& unidad.getIltrex().toLowerCase()
									.startsWith(valores.get(3))
							&& unidad.getIlmcu().toLowerCase()
									.startsWith(valores.get(4))
							&& formatoFecha
									.format(transformarJulianaAGregoria(unidad
											.getIlcrdj())).toLowerCase()
									.startsWith(valores.get(5))) {
						unidadnegocio.add(unidad);
					}
				}
				return unidadnegocio;
			}

			@Override
			protected String[] crearRegistros(F4111 negocio) {
				String[] registros = new String[6];
				registros[0] = negocio.getIldoc().toString();
				registros[1] = negocio.getIldct();
				registros[2] = formatoFecha
						.format(transformarJulianaAGregoria(negocio.getIltrdj()));
				registros[3] = negocio.getIltrex();
				registros[4] = negocio.getIlmcu();
				registros[5] = formatoFecha
						.format(transformarJulianaAGregoria(negocio.getIlcrdj()));
				return registros;
			}
		};
		catalogo.setParent(catalogoF4111);
	}

	@Listen("onClick=#btnBuscarF4111P")
	public void mostrarCatalogoEmergente() {
		System.out.println("entro");
		if (txtF0101.getText().compareTo("") != 0) {
			Long l = txtF0101.getValue();
			final List<F4111> unidades = servicioF4111
					.buscarTodosOrdenadosPorProveedor("OV", l.doubleValue());
			catalogoEmergente = new Catalogo<F4111>(catalogoF4111Emergente,
					"F4111P", unidades, true, false, false, "Numero Documento",
					"Tipo doc", "Fecha LM", "Explicacion", "Sucursal/planta",
					"Fecha transaccion") {

				@Override
				protected List<F4111> buscar(List<String> valores) {

					List<F4111> unidadnegocio = new ArrayList<F4111>();

					for (F4111 unidad : unidades) {
						if (unidad.getIldoc().toString().toLowerCase()
								.startsWith(valores.get(0))
								&& unidad.getIldct().toLowerCase()
										.startsWith(valores.get(1))
								&& formatoFecha
										.format(transformarJulianaAGregoria(unidad
												.getIltrdj())).toLowerCase()
										.startsWith(valores.get(2))
								&& unidad.getIltrex().toLowerCase()
										.startsWith(valores.get(3))
								&& unidad.getIlmcu().toLowerCase()
										.startsWith(valores.get(4))
								&& formatoFecha
										.format(transformarJulianaAGregoria(unidad
												.getIlcrdj())).toLowerCase()
										.startsWith(valores.get(5))) {
							unidadnegocio.add(unidad);
						}
					}
					return unidadnegocio;
				}

				@Override
				protected String[] crearRegistros(F4111 negocio) {
					String[] registros = new String[6];
					registros[0] = negocio.getIldoc().toString();
					registros[1] = negocio.getIldct();
					registros[2] = formatoFecha
							.format(transformarJulianaAGregoria(negocio
									.getIltrdj()));
					registros[3] = negocio.getIltrex();
					registros[4] = negocio.getIlmcu();
					registros[5] = formatoFecha
							.format(transformarJulianaAGregoria(negocio
									.getIlcrdj()));
					return registros;
				}
			};
			catalogoEmergente.setParent(catalogoF4111Emergente);
			catalogoEmergente.doModal();
		} else
			msj.mensajeAlerta(Mensaje.seleccionarProveedor);
	}

	@Listen("onSeleccion = #catalogoF4111Emergente")
	public void seleccionarEmergente() {
		limpiarCamposItem();
		F4111 f41 = catalogoEmergente.objetoSeleccionadoDelCatalogo();
		Double codigo = f41.getIldoc();
		txtF4111P.setValue(codigo.longValue());
		lblF4111P.setValue(f41.getIltrex());
		claveDoc = codigo;
		clave41 = f41.getIlukid();
		txtF4111P.setDisabled(true);
		catalogoEmergente.setParent(null);
	}

	@Listen("onClick = #btnBuscarUbicacion1,#btnBuscarUbicacion2")
	public void mostrarCatalogoF4100(Event evento) {
		Button boton = (Button) evento.getTarget();
		idBotonF4100 = boton.getId();
		// final List<F4100> listF4100 = servicioF4100.buscarTodosOrdenados();
		List<F4100> listF4100 = new ArrayList<F4100>();
		if (tipo.equalsIgnoreCase("OV"))
			listF4100 = servicioF4100.buscarTodosOrdenadosPorMcu(mcu);
		else {
			if (idBotonF4100.equals("btnBuscarUbicacion1"))
				listF4100 = servicioF4100.buscarTodosOrdenadosPorMcu(mcu);
			else {
				if (tipo.equalsIgnoreCase("IT"))
					listF4100 = servicioF4100.buscarTodosOrdenadosPorMcu(mcu);
				else
					listF4100 = servicioF4100.buscarTodosOrdenadosPorMcu(mcu2);
			}
		}
		final List<F4100> listF41002 = listF4100;
		catalogoF4100 = new Catalogo<F4100>(catalogoUbicacionF4100, "F4100",
				listF41002, true, false, false, "Cod. Sucursal/planta",
				"Sucursal/planta", "Fecha acta", "Ubicacion", "Zona alm",
				"Zona acopio", "Zona reabast", "Detalle", "Pasillo", "Bin",
				"Ubic 3", "Ubic 4", "Ubic 5", "Ubic 6", "Ubic 7", "Ubic 8",
				"Ubic 9", "Ubic 10", "Art/Lote mixtos", "Ubic temp") {

			@Override
			protected List<F4100> buscar(List<String> valores) {
				List<F4100> listF4100_2 = new ArrayList<F4100>();

				for (F4100 f4100 : listF41002) {
					F0006 f0006 = servicioF0006
							.buscar(f4100.getId().getLmmcu());
					String mcdc = "";
					if (f0006.getMcdc() != null)
						mcdc = f0006.getMcdc();
					String num3 = "", num4 = "", num5 = "", num6 = "", num7 = "", num8 = "", num9 = "", num10 = "";
					if (f4100.getLmla03() != null)
						num3 = f4100.getLmla03();
					if (f4100.getLmla04() != null)
						num4 = f4100.getLmla04();
					if (f4100.getLmla05() != null)
						num5 = f4100.getLmla05();
					if (f4100.getLmla06() != null)
						num6 = f4100.getLmla06();
					if (f4100.getLmla07() != null)
						num7 = f4100.getLmla07();
					if (f4100.getLmla08() != null)
						num8 = f4100.getLmla08();
					if (f4100.getLmla09() != null)
						num9 = f4100.getLmla09();
					if (f4100.getLmla10() != null)
						num10 = f4100.getLmla10();
					if (String.valueOf(f4100.getId().getLmmcu()).toLowerCase()
							.startsWith(valores.get(0))
							&& mcdc.toLowerCase().startsWith(valores.get(1))
							&& String
									.valueOf(
											transformarJulianaAGregoria(f4100
													.getLmupmj()))
									.toLowerCase().startsWith(valores.get(2))
							&& f4100.getId().getLmlocn().toLowerCase()
									.startsWith(valores.get(3))
							&& f4100.getLmpzon().toLowerCase()
									.startsWith(valores.get(4))
							&& f4100.getLmkzon().toLowerCase()
									.startsWith(valores.get(5))
							&& f4100.getLmzonr().toLowerCase()
									.startsWith(valores.get(6))
							&& f4100.getLmlldl().toLowerCase()
									.startsWith(valores.get(7))
							// poner campos pasillo y bin
							&& num3.toLowerCase().startsWith(valores.get(10))
							&& num4.toLowerCase().startsWith(valores.get(11))
							&& num5.toLowerCase().startsWith(valores.get(12))
							&& num6.toLowerCase().startsWith(valores.get(13))
							&& num7.toLowerCase().startsWith(valores.get(14))
							&& num8.toLowerCase().startsWith(valores.get(15))
							&& num9.toLowerCase().startsWith(valores.get(16))
							&& num10.toLowerCase().startsWith(valores.get(17))
							&& f4100.getLmmixl().toLowerCase()
									.startsWith(valores.get(18))
							&& f4100.getLmstag().toLowerCase()
									.startsWith(valores.get(19))) {
						listF4100_2.add(f4100);
					}
				}
				return listF4100_2;
			}

			@Override
			protected String[] crearRegistros(F4100 f4100) {

				F0006 f0006 = servicioF0006.buscar(f4100.getId().getLmmcu());
				BigDecimal a = null;
				if (f4100.getLmupmj() != null)
					a = f4100.getLmupmj();
				String[] registros = new String[20];
				registros[0] = String.valueOf(f4100.getId().getLmmcu());
				registros[1] = f0006.getMcdc();
				registros[2] = String.valueOf(transformarJulianaAGregoria(a));
				registros[3] = String.valueOf(f4100.getId().getLmlocn());
				registros[4] = f4100.getLmpzon();
				registros[5] = f4100.getLmkzon();
				registros[6] = f4100.getLmzonr();
				registros[7] = f4100.getLmlldl();
				registros[8] = "no se";
				registros[9] = "no se";
				registros[10] = f4100.getLmla03();
				registros[11] = f4100.getLmla04();
				registros[12] = f4100.getLmla05();
				registros[13] = f4100.getLmla06();
				registros[14] = f4100.getLmla07();
				registros[15] = f4100.getLmla08();
				registros[16] = f4100.getLmla09();
				registros[17] = f4100.getLmla10();
				registros[18] = f4100.getLmmixl();
				registros[19] = f4100.getLmstag();
				return registros;
			}
		};
		catalogoF4100.setParent(catalogoUbicacionF4100);
		catalogoF4100.doModal();
	}

	@Listen("onSeleccion = #catalogoUbicacionF4100")
	public void seleccionarCatalogo() {
		F4100 f4100 = catalogoF4100.objetoSeleccionadoDelCatalogo();
		switch (idBotonF4100) {
		case "btnBuscarUbicacion1":
			setearUbicacion(f4100, txtUbicacion1, lblUbicacion1);
			break;
		case "btnBuscarUbicacion2":
			setearUbicacion(f4100, txtUbicacion2, lblUbicacion2);
			break;
		default:
			break;
		}
		catalogoF4100.setParent(null);
	}

	private void setearUbicacion(F4100 f4100, Textbox txtUbicacion22,
			Label lblUbicacion22) {
		txtUbicacion22.setValue(f4100.getId().getLmlocn());
		lblUbicacion22.setValue(f4100.getId().getLmlocn());

	}

	@Listen("onClick = #btnBuscarPlanta1,#btnBuscarPlanta2")
	public void mostrarCatalogoF0006(Event evento) {
		Button boton = (Button) evento.getTarget();
		idBotonF0006 = boton.getId();
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoF0006 = new Catalogo<F0006>(catalogoSucursalF0006, "F0006",
				unidades, true, false, false, "Unidad Negocio", "Descripcion",
				"Nivel det", "Cta", "Tipo UN", "LM Auxiliar Inactivo",
				"Mto Cons", "CAT 01", "CAT 02", "CAT 03", "CAT 04", "CAT 05",
				"CAT 06") {

			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					String mcdc = "";
					if (unidad.getMcdc() != null)
						mcdc = unidad.getMcdc();
					if (unidad.getMcmcu().toLowerCase()
							.startsWith(valores.get(0))
							&& mcdc.toLowerCase().startsWith(valores.get(1))
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
		catalogoF0006.setParent(catalogoSucursalF0006);
		catalogoF0006.doModal();
	}

	@Listen("onSeleccion = #catalogoSucursalF0006")
	public void seleccionarSucursal() {
		F0006 f06 = catalogoF0006.objetoSeleccionadoDelCatalogo();
		switch (idBotonF0006) {
		case "btnBuscarPlanta1":
			setearPlanta(f06, txtPlanta1, lblPlanta1);
			mcu = f06.getMcmcu();
			txtUbicacion1.setValue("");
			lblUbicacion1.setValue("");
			break;
		case "btnBuscarPlanta2":
			setearPlanta(f06, txtPlanta2, lblPlanta2);
			if (tipo.equalsIgnoreCase("OV")) {
				txtUbicacion1.setValue("");
				lblUbicacion1.setValue("");
				mcu = f06.getMcmcu();
			} else {
				mcu2 = f06.getMcmcu();
				txtUbicacion2.setValue("");
				lblUbicacion2.setValue("");
			}
			break;
		default:
			break;
		}

		catalogoF0006.setParent(null);
	}

	@Listen("onChange = #txtPlanta1, #txtPlanta2")
	public void buscarNombreSucursal(Event evento) {
		F0006 f06 = new F0006();
		Longbox txt = (Longbox) evento.getTarget();
		switch (txt.getId()) {
		case "txtPlanta1":
			f06 = servicioF0006.buscar(txtPlanta1.getValue());
			if (f06 != null) {
				setearPlanta(f06, txtPlanta1, lblPlanta1);
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				txtPlanta1.setValue("");
				txtPlanta1.setFocus(true);
				lblPlanta1.setValue("");
			}
			break;
		case "txtPlanta2":
			f06 = servicioF0006.buscar(txtPlanta2.getValue());
			if (f06 != null) {
				setearPlanta(f06, txtPlanta2, lblPlanta2);
			} else {
				msj.mensajeAlerta(Mensaje.noHayRegistros);
				txtPlanta2.setValue("");
				txtPlanta2.setFocus(true);
				lblPlanta2.setValue("");
			}
			break;
		}
	}

	private void setearPlanta(F0006 f06, Textbox txtPlanta12, Label lblPlanta12) {
		limpiarCamposItem();
		txtPlanta12.setValue(f06.getMcmcu());
		lblPlanta12.setValue(f06.getMcdl01());
	}

	@Listen("onClick = #btnBuscarItem")
	public void mostrarCatalogoF4101() {
		List<F4101> listF41011 = new ArrayList<F4101>();
		if (!tipo.equals("DP"))
			if (!tipo.equals("OV"))
				listF41011 = servicioF4101.buscarTodosOrdenadosPorMcu(txtPlanta1.getValue());
			else
				listF41011 = servicioF4101.buscarTodosOrdenados();
		else
			listF41011 = servicioF4101.buscarTodosOrdenadosPorDoc("OV",
					claveDoc);
		final List<F4101> listF4101 = listF41011;
		catalogoF4101 = new Catalogo<F4101>(catalogoItemF4101, "F4101",
				listF4101, true, false, false, "Número artículo",
				"Descripción", "Descripción 2", "Texto búsqueda", "Tipo línea",
				"Tipo alm", "Código vta 1") {

			@Override
			protected List<F4101> buscar(List<String> valores) {

				List<F4101> lista = new ArrayList<F4101>();

				for (F4101 f4101 : listF4101) {
					if (f4101.getImlitm().toLowerCase()
							.startsWith(valores.get(0))
							&& f4101.getImdsc1().toLowerCase()
									.startsWith(valores.get(1))
							&& f4101.getImdsc2().toLowerCase()
									.startsWith(valores.get(2))
							&& f4101.getImsrtx().toLowerCase()
									.startsWith(valores.get(3))
							&& f4101.getImlnty().toLowerCase()
									.startsWith(valores.get(4))
							&& f4101.getImstkt().toLowerCase()
									.startsWith(valores.get(5))
							&& f4101.getImsrp1().toLowerCase()
									.startsWith(valores.get(6))) {
						lista.add(f4101);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4101 f4101) {
				String[] registros = new String[7];
				registros[0] = f4101.getImlitm();
				registros[1] = f4101.getImdsc1();
				registros[2] = f4101.getImdsc2();
				registros[3] = f4101.getImsrtx();
				registros[4] = f4101.getImlnty();
				registros[5] = f4101.getImstkt();
				registros[6] = f4101.getImsrp1();
				return registros;
			}
		};
		catalogoF4101.setParent(catalogoItemF4101);
		catalogoF4101.doModal();
	}

	@Listen("onSeleccion = #catalogoItemF4101")
	public void seleccionarItem() {
		F4101 f4101 = catalogoF4101.objetoSeleccionadoDelCatalogo();
		llenarCamposItem(f4101);
		catalogoF4101.setParent(null);
	}

	@Listen("onChange = #txtItem")
	public void buscarNombreItem() {
		F4101 f4101 = servicioF4101.buscar(txtItem.getValue());
		if (f4101 != null) {
			llenarCamposItem(f4101);
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtItem.setValue(null);
			txtItem.setFocus(true);
			txtUM.setValue("");
			txtUM2.setValue("");
			lblItem.setValue("");
		}
	}

	private void llenarCamposItem(F4101 f4101) {
		limpiarCamposItem();
		txtItem.setValue(f4101.getImitm());
		txtUM.setValue(f4101.getImuom1());
		txtUM2.setValue(f4101.getImuom2());
		lblItem.setValue(f4101.getImdsc1());
		System.out.println(clave41 + "clave");
		if (clave41 != null) {
			System.out.println(clave41 + "clave");
			F4111 f = servicioF4111.buscar(clave41);
			spnCosto.setValue(f.getIluncs());
		}
	}

	@Listen("onClick = #btnBuscarF0101")
	public void mostrarCatalogoDireccion() {

		List<F0101> listF41011 = new ArrayList<F0101>();
		if (!tipo.equals("DP"))
			listF41011 = servicioF0101.buscarTodosOrdenados();
		else
			listF41011 = servicioF0101.buscarProveedorConOrden("OV");
		final List<F0101> listF0101 = listF41011;
		catalogoF0101 = new Catalogo<F0101>(catalogoDireccionF0101,
				"CatalogoF0013", listF0101, true, false, false, "Nº direccion",
				"Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal") {

			@Override
			protected List<F0101> buscar(List<String> valores) {

				List<F0101> lista = new ArrayList<F0101>();

				for (F0101 f01 : listF0101) {
					if (String.valueOf(f01.getAban8()).toLowerCase()
							.startsWith(valores.get(0))
							&& f01.getAbalph().toLowerCase()
									.startsWith(valores.get(1))
							&& f01.getAbalky().toLowerCase()
									.startsWith(valores.get(2))
							&& f01.getAbsic().toLowerCase()
									.startsWith(valores.get(3))
							&& f01.getAbat1().toLowerCase()
									.startsWith(valores.get(4))
							&& f01.getAbtax().toLowerCase()
									.startsWith(valores.get(5))) {
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
		catalogoF0101.setParent(catalogoDireccionF0101);
		catalogoF0101.doModal();
	}

	@Listen("onSeleccion = #catalogoDireccionF0101")
	public void seleccionarCatalogoDireccion() {
		F0101 f0101 = catalogoF0101.objetoSeleccionadoDelCatalogo();
		setearValores(f0101);
		catalogoF0101.setParent(null);
	}

	public void setearValores(F0101 f0101) {
		if(tipo.equals("DP")){
			txtF4111P.setValue(null);
			lblF4111P.setValue("");
			claveDoc = null;
			clave41 = null;
		}
		if(tipo.equals("DP")||tipo.equals("OV")){
			ltbItems.getItems().clear();
			ltbItems.renderAll();
			lista.clear();
		}
		limpiarCamposItem();
		Double doble = f0101.getAban8();
		txtF0101.setValue(doble.longValue());
		lblF0101.setValue(f0101.getAbalph());
	}
	@Listen("onChange = #txtF0101")
	public void buscarNombre() {
		F0101 f0101 = servicioF0101.buscar(txtF0101.getValue());
		if (f0101 != null) {
			setearValores(f0101);
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtF0101.setValue(null);
			txtF0101.setFocus(true);
			lblF0101.setValue("");
		}
	}

	public boolean validarItems() {
		switch (tipo) {
		case "OV":
			if (txtItem.getText().compareTo("") == 0
					|| txtPlanta2.getText().compareTo("") == 0
					|| txtUbicacion1.getText().compareTo("") == 0
					|| spnCantidad.getValue() == 0 || spnCosto.getValue() == 0)
				return false;
			else
				return true;
		case "ET":
			if (txtItem.getText().compareTo("") == 0
					|| txtPlanta1.getText().compareTo("") == 0
					|| txtPlanta2.getText().compareTo("") == 0
					|| txtUbicacion1.getText().compareTo("") == 0
					|| txtUbicacion2.getText().compareTo("") == 0
					|| spnCantidad.getValue() == 0)
				return false;
			else
				return true;
		case "IT":
			if (txtItem.getText().compareTo("") == 0
					|| txtPlanta1.getText().compareTo("") == 0
					|| txtUbicacion1.getText().compareTo("") == 0
					|| txtUbicacion2.getText().compareTo("") == 0
					|| spnCantidad.getValue() == 0)
				return false;
			else
				return true;
		case "I4":
			if (txtItem.getText().compareTo("") == 0
					|| txtPlanta1.getText().compareTo("") == 0
					|| txtUbicacion1.getText().compareTo("") == 0
					|| spnCosto.getValue() == 0)
				return false;
			else
				return true;
		default:
			if (txtItem.getText().compareTo("") == 0
					|| txtPlanta1.getText().compareTo("") == 0
					|| txtUbicacion1.getText().compareTo("") == 0
					|| spnCantidad.getValue() == 0)
				return false;
			else
				return true;
		}
	}

	@Listen("onClick = #btnAgregar")
	public void annadirLista() {
		if (validarItems()) {
			Double item = txtItem.getValue();
			String itemNombre = lblItem.getValue();
			int cantidad = spnCantidad.getValue();
			double costo = spnCosto.getValue();
			String um = txtUM.getValue();
			String ubicacion = txtUbicacion1.getValue();
			String ubicacion2 = txtUbicacion2.getValue();
			String mcu = txtPlanta1.getValue();
			F4105 f4105 = new F4105();
			if (tipo.equals("OV")) {
				mcu = txtPlanta2.getValue();
				f4105 = null;
			} else {
				if (!tipo.equals("DP")) {
					F4105PK claveCostoUnitario = new F4105PK();
					claveCostoUnitario.setCoitm(item);
					claveCostoUnitario.setComcu(mcu);
					claveCostoUnitario.setColocn("");
					claveCostoUnitario.setColotn("");
					claveCostoUnitario.setColedg("02");
					f4105 = servicioF4105.buscar(claveCostoUnitario);
				} else
					f4105 = null;
				mcu = txtPlanta1.getValue();
			}
			double costoIn = 0;
			if (f4105 != null)
				costoIn = f4105.getCouncs();
			else
				costoIn = costo;
			double valorTotal = costoIn * cantidad;
			Generico modelo = new Generico(item, itemNombre, um, ubicacion, "",
					ubicacion2, "", cantidad, costoIn);
			modelo.setValor11(valorTotal);

			for (int i = 0; i < ltbItems.getItemCount(); i++) {
				Listitem listItem = ltbItems.getItemAtIndex(i);
				Generico modeloLista = listItem.getValue();
				if (modeloLista.getValor1().equals(item)
						&& modeloLista.getValor4().equals(ubicacion)) {
					ltbItems.removeItemAt(i);
					lista.remove(modeloLista);
					ltbItems.renderAll();
					i = ltbItems.getItemCount();
				}
			}
			lista.add(modelo);
			ltbItems.setModel(new ListModelList<Generico>(lista));
			ltbItems.renderAll();
			limpiarCamposItem();
		} else
			msj.mensajeAlerta(Mensaje.camposVaciosItem);
	}

	@Listen("onClick = #btnVer")
	public void seleccionarItemLista() {
		if (ltbItems.getItemCount() != 0) {
			if (ltbItems.getSelectedItems().size() == 1) {
				Listitem listItem = ltbItems.getSelectedItem();
				Generico modelo = listItem.getValue();
				Double numero = modelo.getValor1();
				String descripcion = modelo.getValor2();
				int cantidad = modelo.getValor8();
				double costo = modelo.getValor10();
				String um = modelo.getValor3();
				String ubicacion1 = modelo.getValor4();
				String ubicacion2 = modelo.getValor6();
				limpiarCamposItem();
				txtItem.setValue(numero);
				lblItem.setValue(descripcion);
				spnCantidad.setValue(cantidad);
				spnCosto.setValue(costo);
				txtUbicacion1.setValue(ubicacion1);
				txtUbicacion2.setValue(ubicacion2);
				txtUM.setValue(um);
				ltbItems.removeItemAt(listItem.getIndex());
				lista.remove(modelo);
				ltbItems.renderAll();
			} else
				msj.mensajeAlerta(Mensaje.editarSoloUno);
		} else
			msj.mensajeAlerta(Mensaje.noHayRegistros);
	}

	private void limpiarCamposItem() {
		txtItem.setValue(null);
		lblItem.setValue("");
		txtUbicacion1.setValue("");
		txtUbicacion2.setValue("");
		lblUbicacion1.setValue("");
		lblUbicacion2.setValue("");
		txtUM.setValue("");
		txtUM2.setValue("");
		spnCantidad.setValue(0);
		spnCosto.setValue((double) 0);
	}

	@Listen("onClick = #btnRemover")
	public void removerItem() {
		if (ltbItems.getItemCount() != 0) {
			if (ltbItems.getSelectedItems().size() == 1) {
				Listitem listItem = ltbItems.getSelectedItem();
				Generico modelo = listItem.getValue();
				int i = listItem.getIndex();
				ltbItems.removeItemAt(i);
				lista.remove(modelo);
				ltbItems.renderAll();
			} else
				msj.mensajeAlerta(Mensaje.editarSoloUno);
		} else
			msj.mensajeAlerta(Mensaje.noHayRegistros);
	}

	@Listen("onChange=#spnCantidad,#txtPlanta1,#txtUbicacion1,#txtItem")
	public void sumar() {
		if (!tipo.equals("OV")) {
			System.out.println(tipo);
			if (txtItem.getText().compareTo("") != 0
					|| txtPlanta1.getText().compareTo("") != 0
					|| txtUbicacion1.getText().compareTo("") != 0)
				calcular(txtPlanta1);
		}
	}

	private void calcular(Textbox txtPlanta22) {
		Integer cantidad = spnCantidad.getValue();
		// Double suma = servicioF4111.sumar(txtItem.getValue(),
		// txtPlanta22.getValue(), txtUbicacion1.getValue());
		if (tipo.equals("IA"))
			cantidad = cantidad * -1;
		F41021PK claveSaldo = new F41021PK();
		claveSaldo.setLiitm(txtItem.getValue());
		claveSaldo.setLilocn(txtUbicacion1.getValue());
		claveSaldo.setLimcu(txtPlanta22.getValue());
		claveSaldo.setLilotn("");
		F41021 f = servicioF41021.buscar(claveSaldo);
		double suma = 0;
		if (f != null)
			suma = f.getLipqoh();
		System.out.println("suma" + suma);
		if (suma - cantidad < 0) {
			spnCantidad.setValue(0);
			spnCantidad.setFocus(true);
			msj.mensajeError(Mensaje.noPoseeExistencia);
		}
	}

}
