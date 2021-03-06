package controlador.transacciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.generico.Generico;
import modelo.maestros.F00021;
import modelo.maestros.F0006;
import modelo.maestros.F0101;
import modelo.maestros.F4100;
import modelo.maestros.F4101;
import modelo.maestros.F41021;
import modelo.maestros.F4105;
import modelo.pk.F00021PK;
import modelo.pk.F41021PK;
import modelo.pk.F4105PK;
import modelo.transacciones.F4111;
import modelo.transacciones.F4211;

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
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;
import componentes.utils.Validador;
import controlador.maestros.CGenerico;

public class CF4111 extends CGenerico {

	private static final long serialVersionUID = -3406820146315915655L;
	@Wire
	private Doublebox txtDoc;
	@Wire
	private Datebox dtbFechaTransaccion;
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
	@Wire
	private Textbox txtUbicacion2;
	@Wire
	private Doublebox txtOrden;
	@Wire
	private Button btnBuscarUbicacion2;
	@Wire
	private Label lblUbicacion2;
	@Wire
	private Label lblF0101;
	@Wire
	private Label lblF0101Dynamic;
	@Wire
	private Longbox txtF0101;
	@Wire
	private Button btnBuscarF0101;
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
	private Label lblDisponibilidad;
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
	@Wire
	private Row rowPedido;
	@Wire
	private Button btnBuscarPedido;
	@Wire
	private Doublebox txtPedido;
	@Wire
	private Label lblPedido;
	@Wire
	private Div catalogoPedidoF4211;
	@Wire
	private Button btnAgregarItems;
	@Wire
	private Groupbox gpxItems;
	@Wire
	private Row rowBoton;

	Botonera botonera;
	CatalogoGenerico<F4111> catalogo;
	CatalogoGenerico<F4111> catalogoEmergente;
	CatalogoGenerico<F4211> catalogoF4211;
	CatalogoGenerico<F0006> catalogoF0006;
	CatalogoGenerico<F4100> catalogoF4100;
	CatalogoGenerico<F4101> catalogoF4101;
	CatalogoGenerico<F0101> catalogoF0101;
	private String idBotonF0006 = "";
	private String idBotonF4100 = "";
	private List<Generico> lista = new ArrayList<Generico>();
	private String tipo = "";
	double id = (double) 0;
	private String mcu = "";
	private String mcu2 = "";
	private Double claveDoc = null;
	private Double clave41 = null;
	private String versionCronica = null;
	protected List<F4111> listaGeneral = new ArrayList<F4111>();
	private String loc = "";
	private Double orden = null;

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
				map.clear();
				map = null;
			}
		}
		btnBuscarUbicacion1
				.setTooltiptext("Debe seleccionar una Sucursal para visualizar las ubicaciones");
		btnBuscarItem.setTooltiptext("Catalogo de Items");
		btnBuscarF0101.setTooltiptext("Catalogo de Direcciones");
		btnBuscarF4111P.setTooltiptext("Catalogo de Ordenes");
		btnBuscarPedido.setTooltiptext("Catalogo de Pedidos");
		btnBuscarPlanta1.setTooltiptext("Catalogo de Sucursales");
		btnBuscarPlanta2.setTooltiptext("Catalogo de Sucursales");
		switch (titulo) {
		case "Entre Localidades":
			btnBuscarItem
					.setTooltiptext("Debe seleccionar una Sucursal para visualizar los items");
			btnBuscarUbicacion2
					.setTooltiptext("Debe seleccionar una Sucursal para visualizar las ubicaciones");
			rowF0101.setVisible(false);
			rowPlanta2.setVisible(false);
			txtTipo.setValue("IT");
			tipo = "IT";
			Listheader cabeza1 = (Listheader) ltbItems.getChildren().get(0)
					.getChildren().get(6);
			cabeza1.setVisible(true);
			break;
		case "Entre Almacenes":
			btnBuscarUbicacion1
					.setTooltiptext("Debe seleccionar un Pedido para visualizar las ubicaciones");
			btnBuscarItem
					.setTooltiptext("Debe seleccionar un Pedido para visualizar los items");
			txtPlanta1
					.setTooltiptext("Debe seleccionar un Pedido para visualizar la Sucursal");
			txtPlanta2
					.setTooltiptext("Debe seleccionar un Pedido para visualizar la Sucursal");
			txtUbicacion2
					.setTooltiptext("Debe seleccionar un Pedido para visualizar la Ubicacion");
			rowF0101.setVisible(false);
			txtTipo.setValue("ET");
			tipo = "ET";
			Listheader cabeza2 = (Listheader) ltbItems.getChildren().get(0)
					.getChildren().get(6);
			cabeza2.setVisible(true);
			rowPedido.setVisible(true);
			btnBuscarPlanta1.setVisible(false);
			btnBuscarPlanta2.setVisible(false);
			btnBuscarUbicacion2.setVisible(false);
			txtPlanta1.setDisabled(true);
			txtPlanta2.setDisabled(true);
			txtUbicacion2.setDisabled(true);
			break;
		case "De Cantidad":
			btnBuscarItem
					.setTooltiptext("Debe seleccionar una Sucursal para visualizar los items");
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
			btnBuscarItem
					.setTooltiptext("Debe seleccionar una Sucursal para visualizar los items");
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
			lblNombreUbicacion2.setVisible(false);
			btnBuscarUbicacion2.setVisible(false);
			lblNombreUbicacion.setValue("Ubicacion");
			txtTipo.setValue("I4");
			tipo = "I4";
			break;
		case "Despacho a Paciente":
			btnBuscarItem
					.setTooltiptext("Debe seleccionar un Pedido para visualizar los items");
			rowPedido.setVisible(true);
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
		case "Despacho a Paciente Cronico":
			btnBuscarItem
					.setTooltiptext("Debe seleccionar una Sucursal para visualizar los items");
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
			txtTipo.setValue("MC");
			tipo = "MC";
			break;
		case "Devolucion a Proveedor":
			btnBuscarUbicacion1
					.setTooltiptext("Debe seleccionar una Orden y una Sucursal para visualizar las ubicaciones");
			btnBuscarItem
					.setTooltiptext("Debe seleccionar una Orden y una Ubicacion para visualizar los items");
			txtPlanta1.setReadonly(true);
			txtPlanta1.setTooltiptext("Seleccione una Sucursal del Catalogo");
			btnBuscarPlanta1
					.setTooltiptext("Debe seleccionar una Orden para visualizar las sucursales");
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
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {

						mostrarGroupbox();
						F4111 f4111 = catalogo.objetoSeleccionadoDelCatalogo();
						List<F4111> listF4111 = servicioF4111.buscarPorDoc(
								f4111.getIldoc(), tipo);
						txtDoc.setValue(f4111.getIldoc());
						if (f4111.getIldoco() != null)
							txtOrden.setValue(f4111.getIldoco());
						if (f4111.getIlan8() != null) {
							txtF0101.setValue(f4111.getIlan8().longValue());
							lblF0101.setValue(servicioF0101.buscar(
									f4111.getIlan8().longValue()).getAbalph());
						}
						txtPlanta1.setValue(f4111.getIlmcu());
						if (servicioF0006.buscar(f4111.getIlmcu()) != null)
							lblPlanta1.setValue(servicioF0006.buscar(
									f4111.getIlmcu()).getMcdl01());
						txtPlanta2.setValue(f4111.getIlmmcu());
						if (servicioF0006.buscar(f4111.getIlmmcu()) != null)
							lblPlanta2.setValue(servicioF0006.buscar(
									f4111.getIlmmcu()).getMcdl01());
						if (tipo.equals("OV")) {
							txtPlanta2.setValue(f4111.getIlmcu());
							if (servicioF0006.buscar(f4111.getIlmcu()) != null)
								lblPlanta2.setValue(servicioF0006.buscar(
										f4111.getIlmcu()).getMcdl01());
						}
						txtExplicacion.setValue(f4111.getIltrex());
						dtbFechaLm.setValue(transformarJulianaAGregoria(f4111
								.getIltrdj()));
						dtbFechaTransaccion
								.setValue(transformarJulianaAGregoria(f4111
										.getIlcrdj()));

						if (f4111.getIldoc() != null) {
							Double codigo = f4111.getIldoc();
							txtF4111P.setValue(codigo.longValue());
							lblF4111P.setValue(f4111.getIltrex());
						}

						if (!listF4111.isEmpty()) {
							for (int i = 0; i < listF4111.size(); i++) {
								if (listF4111.get(i).getIlitm() != null) {

									F4101 f4101 = servicioF4101
											.buscar(listF4111.get(i).getIlitm());
									if (f4101 != null) {
										Generico generico = new Generico(
												listF4111.get(i).getIlitm(),
												f4101.getImdsc1(),
												f4101.getImuom1(), listF4111
														.get(i).getIlmcu(), "",
												listF4111.get(i).getIlmmcu(),
												"",
												listF4111.get(i).getIltrqt()
														.intValue(), listF4111
														.get(i).getIluncs());
										generico.setValor11(listF4111.get(i)
												.getIlpaid());
										lista.add(generico);
									}
								}
							}
							ltbItems.setModel(new ListModelList<Generico>(lista));
							ltbItems.renderAll();
						}
						mostrarBotones(false);
						abrirRegistro();
						botonera.getChildren().get(3).setVisible(false);
					} else
						Mensaje.mensajeAlerta(Mensaje.editarSoloUno);
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
				if (validar()) {

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
							// if (lista.size() == 0) {
							// f4111 = new F4111();
							// f4111.setIlukid(id);
							// f4111.setIlmcu(txtPlanta1.getValue());
							// f4111.setIlmmcu(txtPlanta2.getValue());
							// Integer inte = spnCantidad.getValue();
							// if (!tipo.equals("OV")) {
							// if (!tipo.equalsIgnoreCase("IA"))
							// inte = inte * -1;
							// }
							// f4111.setIltrqt(inte.doubleValue());
							// f4111.setIldoc(txtDoc.getValue());
							// f4111.setIldoco(txtOrden.getValue());
							// f4111.setIltrdj(transformarGregorianoAJulia(dtbFechaLm
							// .getValue()));
							// f4111.setIlcrdj(transformarGregorianoAJulia(dtbFechaTransaccion
							// .getValue()));
							// f4111.setIluser(nombreUsuarioSesion());
							// f4111.setIlvpej(transformarGregorianoAJulia(fecha));
							// f4111.setIlicu(Double.valueOf(horaAuditoria));
							// f4111.setIldct(txtTipo.getValue());
							// f4111.setIltrex(txtExplicacion.getValue());
							// f4111.setIluncs((double) 0);
							// f4111.setIlpaid((double) (inte * 0));
							// f4111.setIllotn("");
							// servicioF4111.guardar(f4111);
							// }
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
								if (versionCronica == null)
									f4111.setIldct(txtTipo.getValue());
								else
									f4111.setIldct("MC");
								if (orden != null)
									f4111.setIltrno(orden);
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
								f41021.setLiupmj(transformarGregorianoAJulia(dtbFechaTransaccion
										.getValue()));
								servicioF41021.guardar(f41021);
								// actualizo los costos

								if (!tipo.equals("MK")) {
									if (!tipo.equals("IT")) {
										if (!tipo.equals("MC")) {
											servicioF4105
													.actualizarCostoPromedio(
															claveCostoUnitario,
															inte,
															cantidadAnterior,
															costoUnitario,
															costoUnitarioAnterior);
										}
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
									// f4111.setIluncs(costo2);
									f4111.setIluncs(costoUnitario);
									f4111.setIltrqt(inte.doubleValue() * (-1));
									// f4111.setIlpaid(costo2
									// * (inte.doubleValue() * (-1)));
									f4111.setIlpaid(total);
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
									if (tipo.equals("ET")) {
										servicioF4105.actualizarCostoPromedio(
												claveCostoUnitario,
												(inte * -1), cantidadAnterior,
												costoUnitario,
												costoUnitarioAnterior);
										guardarPedido(numero);
									}
									f410212.setLiupmj(transformarGregorianoAJulia(dtbFechaTransaccion
											.getValue()));
									servicioF41021.guardar(f410212);
									// guardo en la tabla de saldo y si
									// es ajuste de costo sigo
								}

								// if (tipo.equals("MC"))
								// guardarPedido(numero);
								if (tipo.equals("MK") || versionCronica != null)
									guardarPedido(numero);
								if (tipo.equals("I4")) {
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
						}
					}
					synchronized (this) {
						nextNumber = true;
						notifyAll();
					}

					listaGeneral = servicioF4111
							.buscarTodosOrdenadosPorTipo(tipo);
					catalogo.actualizarLista(listaGeneral);

					Mensaje.mensajeInformacion(Mensaje.guardado);
					limpiar();

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
				// TODO Auto-generated method stub

			}

			@Override
			public void annadir() {
				abrirRegistro();
				mostrarBotones(false);
				botonera.getChildren().get(3).setVisible(true);
			}
		};

		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botonera.getChildren().get(4).setVisible(false);
		botoneraF4111.appendChild(botonera);
	}

	protected void guardarPedido(Double numero) {
		String dct = tipo;
		if (versionCronica != null)
			dct = "MC";
		List<F4211> f421 = servicioF4211.buscarPorDocoYDcto(
				txtPedido.getValue(), dct);
		for (int j = 0; j < f421.size(); j++) {
			if (numero.equals(f421.get(j).getSditm())) {
				f421.get(j).setSdspattn("Procesada");
			}
		}
		servicioF4211.guardarVarios(f421);
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
		if (lista.size() == 0) {
			Mensaje.mensajeError("Debe agregar al menos un Item");
			return false;
		} else {
			switch (tipo) {
			case "OV":
				if (txtDoc.getText().compareTo("") == 0
						|| txtOrden.getText().compareTo("") == 0
						|| txtF0101.getText().compareTo("") == 0
						|| txtPlanta2.getText().compareTo("") == 0) {
					Mensaje.mensajeError(Mensaje.camposVacios);
					return false;
				} else
					return true;
			case "ET":
				if (txtDoc.getText().compareTo("") == 0
						|| txtPlanta1.getText().compareTo("") == 0
						|| txtPlanta2.getText().compareTo("") == 0) {
					Mensaje.mensajeError(Mensaje.camposVacios);
					return false;
				} else
					return true;
			case "IT":
				if (txtDoc.getText().compareTo("") == 0
						|| txtPlanta1.getText().compareTo("") == 0) {
					Mensaje.mensajeError(Mensaje.camposVacios);
					return false;
				} else
					return true;
			case "IA":
			case "I4":
				if (txtDoc.getText().compareTo("") == 0
						|| txtPlanta1.getText().compareTo("") == 0) {
					Mensaje.mensajeError(Mensaje.camposVacios);
					return false;
				} else
					return true;
			case "MC":
			case "MK":
				if (txtDoc.getText().compareTo("") == 0
						|| txtPlanta1.getText().compareTo("") == 0
						|| txtExplicacion.getText().compareTo("") == 0) {
					Mensaje.mensajeError(Mensaje.camposVacios);
					return false;
				} else
					return true;
			default:
				if (txtDoc.getText().compareTo("") == 0
						|| txtPlanta1.getText().compareTo("") == 0
						|| txtF0101.getText().compareTo("") == 0) {
					Mensaje.mensajeError(Mensaje.camposVacios);
					return false;
				} else
					return true;
			}
		}
	}

	protected void limpiarCampos() {
		orden = null;
		mcu = "";
		mcu2 = "";
		loc = "";
		versionCronica = null;
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
		lblPlanta1.setValue("");
		lblPlanta2.setValue("");
		lblUbicacion1.setValue("");
		lblUbicacion2.setValue("");
		lblPedido.setValue("");
		lblF4111P.setValue("");
		lblF0101.setValue("");
		txtF4111P.setValue(null);
		txtF4111P.setDisabled(false);
		txtPedido.setValue(null);
		lblPedido.setValue("");
	}

	protected void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(!bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(0).setVisible(bol);
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
				|| txtUM2.getText().compareTo("") != 0
				|| txtPedido.getText().compareTo("") != 0
				|| txtF0101.getText().compareTo("") != 0
				|| txtF4111P.getText().compareTo("") != 0
				|| txtOrden.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	protected boolean validarSeleccion() {
		List<F4111> seleccionados = catalogo.obtenerSeleccionados();
		if (seleccionados == null) {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			return false;
		} else {
			if (seleccionados.isEmpty()) {
				Mensaje.mensajeAlerta(Mensaje.noSeleccionoItem);
				return false;
			} else {
				return true;
			}
		}
	}

	private void mostrarCatalogo() {

		listaGeneral = servicioF4111.buscarTodosOrdenadosPorTipo(tipo);
		catalogo = new CatalogoGenerico<F4111>(catalogoF4111, "F4111",
				listaGeneral, false, true, true, "Numero Documento",
				"Tipo doc", "Fecha LM", "Explicacion", "Sucursal/planta",
				"Fecha transaccion") {

			@Override
			protected List<F4111> buscar(List<String> valores) {
				List<F4111> unidadnegocio = new ArrayList<F4111>();

				for (F4111 unidad : listaGeneral) {
					String dct = "", iltrex = "", stringMcu = "";
					if (unidad.getIldct() != null)
						dct = unidad.getIldct();
					if (unidad.getIltrex() != null)
						iltrex = unidad.getIltrex();
					if (unidad.getIlmcu() != null)
						stringMcu = unidad.getIlmcu();
					Double doc = (double) 0;
					if (unidad.getIldoc() != null)
						doc = unidad.getIldoc();
					if (String.valueOf(doc.longValue()).toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& dct.toLowerCase().contains(
									valores.get(1).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(unidad
											.getIltrdj())).toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& iltrex.toLowerCase().contains(
									valores.get(3).toLowerCase())
							&& stringMcu.toLowerCase().contains(
									valores.get(4).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(unidad
											.getIlcrdj())).toLowerCase()
									.contains(valores.get(5).toLowerCase())) {
						unidadnegocio.add(unidad);
					}
				}
				return unidadnegocio;
			}

			@Override
			protected String[] crearRegistros(F4111 negocio) {
				String[] registros = new String[6];
				registros[0] = String.valueOf(negocio.getIldoc().longValue());
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
		Long l = txtF0101.getValue();
		if (l == null)
			l = (long) 0;
		final List<F4111> unidades = servicioF4111
				.buscarTodosOrdenadosPorProveedor("OV", l.doubleValue());
		catalogoEmergente = new CatalogoGenerico<F4111>(catalogoF4111Emergente,
				"Catalogo de Ordenes (F4111P)", unidades, true, false, false,
				"Numero de Orden", "Tipo doc", "Fecha LM", "Explicacion",
				"Sucursal/planta", "Fecha transaccion") {

			@Override
			protected List<F4111> buscar(List<String> valores) {

				List<F4111> unidadnegocio = new ArrayList<F4111>();

				for (F4111 unidad : unidades) {
					if (String.valueOf(unidad.getIldoc().longValue())
							.toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& unidad.getIldct().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(unidad
											.getIltrdj())).toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& unidad.getIltrex().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& unidad.getIlmcu().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(unidad
											.getIlcrdj())).toLowerCase()
									.contains(valores.get(5))) {
						unidadnegocio.add(unidad);
					}
				}
				return unidadnegocio;
			}

			@Override
			protected String[] crearRegistros(F4111 negocio) {
				String[] registros = new String[6];
				registros[0] = String.valueOf(negocio.getIldoc().longValue());
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
		catalogoEmergente.setParent(catalogoF4111Emergente);
		Listbox list = (Listbox) catalogoEmergente.getChildren().get(1);
		list.setEmptyMessage("Debe seleccionar un Proveedor para visualizar las Ordenes");
		catalogoEmergente.doModal();
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
		List<F4100> listF4100 = new ArrayList<F4100>();
		if (tipo.equalsIgnoreCase("OV"))
			listF4100 = servicioF4100.buscarTodosOrdenadosPorMcu(mcu);
		else {
			if (idBotonF4100.equals("btnBuscarUbicacion1"))
				if (tipo.equals("DP"))
					listF4100 = servicioF4100.buscarTodosOrdenadosPorDoc("OV",
							claveDoc, mcu);
				else
					listF4100 = servicioF4100.buscarTodosOrdenadosPorMcu(mcu);
			else {
				if (tipo.equalsIgnoreCase("IT"))
					listF4100 = servicioF4100.buscarTodosOrdenadosPorMcu(mcu);
				else
					listF4100 = servicioF4100.buscarTodosOrdenadosPorMcu(mcu2);
			}
		}
		final List<F4100> listF41002 = listF4100;
		catalogoF4100 = new CatalogoGenerico<F4100>(catalogoUbicacionF4100,
				"Catalogo de Ubicaciones (F4100)", listF41002, true, false,
				false, "Cod. Sucursal/planta", "Sucursal/planta", "Fecha acta",
				"Ubicacion", "Zona alm", "Zona acopio", "Zona reabast",
				"Detalle", "Pasillo", "Bin", "Ubic 3", "Ubic 4", "Ubic 5",
				"Ubic 6", "Ubic 7", "Ubic 8", "Ubic 9", "Ubic 10",
				"Art/Lote mixtos", "Ubic temp") {

			@Override
			protected List<F4100> buscar(List<String> valores) {
				List<F4100> listF4100_2 = new ArrayList<F4100>();

				for (F4100 f4100 : listF41002) {
					F0006 f0006 = servicioF0006
							.buscar(f4100.getId().getLmmcu());
					String mcdc = "";
					if (f0006.getMcdl01() != null)
						mcdc = f0006.getMcdl01();
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
							.contains(valores.get(0).toLowerCase())
							&& mcdc.toLowerCase().contains(
									valores.get(1).toLowerCase())
							&& String
									.valueOf(
											transformarJulianaAGregoria(f4100
													.getLmupmj()))
									.toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& f4100.getId().getLmlocn().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f4100.getLmpzon().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& f4100.getLmkzon().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& f4100.getLmzonr().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& f4100.getLmlldl().toLowerCase()
									.contains(valores.get(7).toLowerCase())
							// poner campos pasillo y bin
							&& num3.toLowerCase().contains(
									valores.get(10).toLowerCase())
							&& num4.toLowerCase().contains(
									valores.get(11).toLowerCase())
							&& num5.toLowerCase().contains(
									valores.get(12).toLowerCase())
							&& num6.toLowerCase().contains(
									valores.get(13).toLowerCase())
							&& num7.toLowerCase().contains(
									valores.get(14).toLowerCase())
							&& num8.toLowerCase().contains(
									valores.get(15).toLowerCase())
							&& num9.toLowerCase().contains(
									valores.get(16).toLowerCase())
							&& num10.toLowerCase().contains(
									valores.get(17).toLowerCase())
							&& f4100.getLmmixl().toLowerCase()
									.contains(valores.get(18).toLowerCase())
							&& f4100.getLmstag().toLowerCase()
									.contains(valores.get(19).toLowerCase())) {
						listF4100_2.add(f4100);
					}
				}
				return listF4100_2;
			}

			@Override
			protected String[] crearRegistros(F4100 f4100) {

				F0006 f0006 = servicioF0006.buscar(f4100.getId().getLmmcu());
				String[] registros = new String[20];
				registros[0] = String.valueOf(f4100.getId().getLmmcu());
				if (f0006 != null)
					registros[1] = f0006.getMcdl01();
				if (f4100.getLmupmj() != null)
					registros[2] = formatoFecha
							.format((transformarJulianaAGregoria(f4100
									.getLmupmj())));
				else
					registros[2] = "";
				registros[3] = String.valueOf(f4100.getId().getLmlocn());
				registros[4] = f4100.getLmpzon();
				registros[5] = f4100.getLmkzon();
				registros[6] = f4100.getLmzonr();
				registros[7] = f4100.getLmlldl();
				registros[8] = "";
				registros[9] = "";
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
		Listbox list = (Listbox) catalogoF4100.getChildren().get(1);
		if (tipo.equals("ET"))
			list.setEmptyMessage("Debe seleccionar un Pedido para visualizar las ubicaciones");
		else {
			if (tipo.equals("DP"))
				list.setEmptyMessage("Debe seleccionar una Orden y una Sucursal para visualizar las ubicaciones");
			else
				list.setEmptyMessage("Debe seleccionar una Sucursal para visualizar las ubicaciones");
		}
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
		loc = f4100.getId().getLmlocn();
		txtUbicacion22.setValue(f4100.getId().getLmlocn());
		lblUbicacion22.setValue(f4100.getId().getLmlocn());
		calcularDisponibilidad(txtItem.getValue(), loc, txtPlanta1.getValue());

	}

	@Listen("onClick = #btnBuscarPlanta1,#btnBuscarPlanta2")
	public void mostrarCatalogoF0006(Event evento) {
		Button boton = (Button) evento.getTarget();
		idBotonF0006 = boton.getId();
		List<F0006> sucursales = new ArrayList<F0006>();
		if (tipo.equals("DP"))
			sucursales = servicioF0006.buscarTodosOrdenadosPorDoc("OV",
					claveDoc);
		else
			sucursales = servicioF0006.buscarTodosOrdenados();
		final List<F0006> unidades = sucursales;
		catalogoF0006 = new CatalogoGenerico<F0006>(catalogoSucursalF0006,
				"Catalogo de Sucursales (F0006)", unidades, true, false, false,
				"Unidad Negocio", "Descripcion", "Nivel det", "Cta", "Tipo UN",
				"LM Auxiliar Inactivo", "Mto Cons", "CAT 01", "CAT 02",
				"CAT 03", "CAT 04", "CAT 05", "CAT 06") {

			@Override
			protected List<F0006> buscar(List<String> valores) {

				List<F0006> unidadnegocio = new ArrayList<F0006>();

				for (F0006 unidad : unidades) {
					String mcdc = "";
					if (unidad.getMcdc() != null)
						mcdc = unidad.getMcdc();
					if (unidad.getMcmcu().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& unidad.getMcdl01().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& unidad.getMcldm().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& unidad.getMcco().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& unidad.getMcstyl().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& unidad.getMcfmod().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& unidad.getMcsbli().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& unidad.getMcrp01().toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& unidad.getMcrp02().toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& unidad.getMcrp03().toLowerCase()
									.contains(valores.get(9).toLowerCase())
							&& unidad.getMcrp04().toLowerCase()
									.contains(valores.get(10).toLowerCase())
							&& unidad.getMcrp05().toLowerCase()
									.contains(valores.get(11).toLowerCase())
							&& unidad.getMcrp06().toLowerCase()
									.contains(valores.get(12).toLowerCase())) {
						unidadnegocio.add(unidad);
					}
				}
				return unidadnegocio;
			}

			@Override
			protected String[] crearRegistros(F0006 negocio) {
				String[] registros = new String[13];
				registros[0] = negocio.getMcmcu();
				registros[1] = negocio.getMcdl01();
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
		Listbox list = (Listbox) catalogoF0006.getChildren().get(1);
		if (!tipo.equals("DP"))
			list.setEmptyMessage("No existen registros");
		else
			list.setEmptyMessage("Debe seleccionar una Orden para visualizar las Sucursales");
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

	@Listen("onOK = #txtPlanta1 ; onChange = #txtPlanta1")
	public void buscar() {
		F0006 f06 = new F0006();
		f06 = servicioF0006.buscar(txtPlanta1.getValue());
		if (f06 != null) {
			setearPlanta(f06, txtPlanta1, lblPlanta1);
		} else {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			txtPlanta1.setValue("");
			txtPlanta1.setFocus(true);
			lblPlanta1.setValue("");
		}

	}

	@Listen("onOK = #txtPlanta2 ; onChange = #txtPlanta2")
	public void buscarNombreSucursal(Event evento) {
		F0006 f06 = new F0006();
		f06 = servicioF0006.buscar(txtPlanta2.getValue());
		if (f06 != null) {
			setearPlanta(f06, txtPlanta2, lblPlanta2);
		} else {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			txtPlanta2.setValue("");
			txtPlanta2.setFocus(true);
			lblPlanta2.setValue("");
		}
	}

	private void setearPlanta(F0006 f06, Textbox txtPlanta12, Label lblPlanta12) {
		limpiarCamposItem();
		loc = "";
		txtPlanta12.setValue(f06.getMcmcu());
		lblPlanta12.setValue(f06.getMcdl01());
	}

	@Listen("onClick = #btnBuscarPedido")
	public void mostrarCatalogoPedido() {
		List<F4211> listF00052 = new ArrayList<F4211>();
		if (tipo.equals("ET"))
			listF00052 = servicioF4211.buscarTodosOrdenadosUnicos("ET");
		else {
			listF00052 = servicioF4211.buscarTodosOrdenadosUnicos("MK");
			listF00052.addAll(servicioF4211.buscarTodosOrdenadosUnicos("MC"));
		}
		final List<F4211> listF0005 = listF00052;
		String orden = "";
		if (tipo.equals("ET"))
			orden = "N� Orden";
		else
			orden = "N� de Recipe";
		catalogoF4211 = new CatalogoGenerico<F4211>(catalogoPedidoF4211,
				"Catalogo de Pedidos (F4211)", listF0005, true, false, false,
				orden, "Tipo ord", "Cia ord", "Compa�ia", "Sucursal/Planta",
				"Articulo", "Cantidad", "Total", "Fecha") {

			@Override
			protected List<F4211> buscar(List<String> valores) {

				List<F4211> listF0005_2 = new ArrayList<F4211>();

				for (F4211 f0005 : listF0005) {
					Double valor = (double) 0;
					if (tipo.equals("ET"))
						valor = f0005.getId().getSddoco();
					else
						valor = f0005.getSddoc();
					if (String.valueOf(valor.longValue()).toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f0005.getId().getSddcto().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& String.valueOf(f0005.getId().getSdlnid())
									.toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& f0005.getId().getSdkcoo().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f0005.getSdmcu().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& String.valueOf(f0005.getSditm()).toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& String.valueOf(f0005.getSdpqor()).toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& String.valueOf(f0005.getSdecst()).toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(f0005
											.getSddrqj())).toLowerCase()
									.contains(valores.get(8).toLowerCase())) {
						listF0005_2.add(f0005);
					}
				}
				return listF0005_2;
			}

			@Override
			protected String[] crearRegistros(F4211 f0005) {
				Double valor = (double) 0;
				if (tipo.equals("ET"))
					valor = f0005.getId().getSddoco();
				else
					valor = f0005.getSddoc();
				String[] registros = new String[9];
				registros[0] = String.valueOf(valor.longValue());
				registros[1] = f0005.getId().getSddcto();
				registros[2] = String.valueOf(f0005.getId().getSdlnid());
				registros[3] = f0005.getId().getSdkcoo();
				registros[4] = f0005.getSdmcu();
				registros[5] = String.valueOf(f0005.getSditm());
				registros[6] = String.valueOf(f0005.getSdpqor());
				registros[7] = String.valueOf(f0005.getSdecst());
				if (f0005.getSddrqj() != null)
					registros[8] = formatoFecha
							.format(transformarJulianaAGregoria(f0005
									.getSddrqj()));
				return registros;
			}
		};
		catalogoF4211.setParent(catalogoPedidoF4211);
		Listbox list = (Listbox) catalogoF4211.getChildren().get(1);
		list.setEmptyMessage("No existen registros");
		catalogoF4211.doModal();
	}

	@Listen("onSeleccion = #catalogoPedidoF4211")
	public void seleccionarCatalogoPedido() {
		F4211 f42 = catalogoF4211.objetoSeleccionadoDelCatalogo();
		if (tipo.equals("MK")) {
			txtDoc.setValue(f42.getSddoc());
			if (f42.getSdacom() != null)
				txtExplicacion.setValue(f42.getSdacom());
		}
		if (f42.getId().getSddcto().equals("MC"))
			versionCronica = "MC";
		else
			versionCronica = null;
		txtExplicacion.setValue(f42.getSdzon());
		txtPedido.setValue(f42.getId().getSddoco());
		orden = f42.getSddoc();
		lblPedido.setValue(f42.getSdco());
		txtPlanta1.setValue(f42.getSdmcu());
		mcu = f42.getSdmcu();
		txtPlanta2.setValue(f42.getSdemcu());
		catalogoF4211.setParent(null);
	}

	@Listen("onClick = #btnBuscarItem")
	public void mostrarCatalogoF4101() {
		List<F4101> listF41011 = new ArrayList<F4101>();
		List<F4101> listF41012 = new ArrayList<F4101>();
		Boolean todos = false;
		if (versionCronica == null) {
			if (tipo.equals("ET")) {
				listF41011 = servicioF4101.buscarTodosOrdenadosPorSolicitud(
						txtPedido.getValue(), "ET");
			} else {
				if (tipo.equals("MK"))
					listF41011 = servicioF4101
							.buscarTodosOrdenadosPorSolicitud(
									txtPedido.getValue(), "MK");
				else {
					if (!tipo.equals("DP"))
						if (!tipo.equals("OV")) {
							todos = true;
							listF41011 = servicioF4101
									.buscarTodosOrdenadosPorMcu(txtPlanta1
											.getValue());
							listF41012 = servicioF4101
									.buscarPorMcuResumen(txtPlanta1.getValue());
						} else {
							todos = true;
							listF41012 = servicioF4101.buscarTodosDiez();
							listF41011 = servicioF4101.buscarTodosOrdenados();
						}
					else
						listF41011 = servicioF4101.buscarTodosOrdenadosPorDoc(
								"OV", claveDoc, loc);
				}
			}
		} else
			listF41011 = servicioF4101.buscarTodosOrdenadosPorSolicitud(
					txtPedido.getValue(), "MC");
		final List<F4101> listBusqueda = listF41011;
		List<F4101> listCabecera = listF41011;
		if (todos)
			listCabecera = listF41012;
		String descripcion = "";
		if (tipo.equals("ET") || tipo.equals("MK") || versionCronica != null) {
			descripcion = "Cantidad Solicitada";
		} else {
			if (tipo.equals("DP"))
				descripcion = "Cantidad Recibida";
			else
				descripcion = "Descripcion";
		}
		catalogoF4101 = new CatalogoGenerico<F4101>(catalogoItemF4101,
				"Catalogo de Articulos (F4101)", listCabecera, true, false,
				false, "N�mero art�culo", "Descripcion", descripcion,
				"Texto b�squeda", "Tipo l�nea", "Tipo alm", "C�digo vta 1") {

			@Override
			protected List<F4101> buscar(List<String> valores) {

				List<F4101> lista = new ArrayList<F4101>();

				for (F4101 f4101 : listBusqueda) {
					F4211 f = new F4211();
					F4111 v = new F4111();
					String cantidad = "";
					if (tipo.equals("ET") || tipo.equals("MK")
							|| versionCronica != null) {
						f = servicioF4211.buscarPorDocoEItem(
								txtPedido.getValue(), f4101.getImitm());
						cantidad = f.getSdpqor().toString();
					} else {
						if (tipo.equals("DP")) {
							v = servicioF4111.buscarTodosOrdenadosPorDoc("OV",
									claveDoc, f4101.getImitm(), loc);
							if (v != null)
								cantidad = String.valueOf(v.getIltrqt()
										.longValue());
							else
								cantidad = f4101.getImdsc2();
						} else
							cantidad = f4101.getImdsc2();
					}
					String valor = "";
					if (f4101.getImsrp1() != null)
						valor = f4101.getImsrp1();
					if (f4101.getImlitm().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f4101.getImdsc1().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& cantidad.toLowerCase().contains(
									valores.get(2).toLowerCase())
							&& f4101.getImsrtx().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f4101.getImlnty().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& f4101.getImstkt().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& valor.toLowerCase().contains(
									valores.get(6).toLowerCase())) {
						lista.add(f4101);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4101 f4101) {
				F4211 f = new F4211();
				F4111 v = new F4111();
				String cantidad = "";
				if (tipo.equals("ET") || tipo.equals("MK")
						|| versionCronica != null) {
					f = servicioF4211.buscarPorDocoEItem(txtPedido.getValue(),
							f4101.getImitm());
					cantidad = f.getSdpqor().toString();
				} else {
					if (tipo.equals("DP")) {
						v = servicioF4111.buscarTodosOrdenadosPorDoc("OV",
								claveDoc, f4101.getImitm(), loc);
						if (v != null)
							cantidad = String
									.valueOf(v.getIltrqt().longValue());
						else
							cantidad = f4101.getImdsc2();
					} else
						cantidad = f4101.getImdsc2();
				}
				String[] registros = new String[7];
				registros[0] = f4101.getImlitm();
				registros[1] = f4101.getImdsc1();
				registros[2] = cantidad;
				registros[3] = f4101.getImsrtx();
				registros[4] = f4101.getImlnty();
				registros[5] = f4101.getImstkt();
				registros[6] = f4101.getImsrp1();
				return registros;
			}
		};
		catalogoF4101.setParent(catalogoItemF4101);
		Listbox list = (Listbox) catalogoF4101.getChildren().get(1);
		switch (tipo) {
		case "ET":
		case "MK":
			list.setEmptyMessage("Debe seleccionar un Pedido para visualizar los items");
			break;
		case "DP":
			if (claveDoc == null)
				list.setEmptyMessage("Debe seleccionar una Orden para visualizar los items");
			else {
				if (loc.equals(""))
					list.setEmptyMessage("Debe seleccionar una Ubicacion para visualizar los items");
				else
					list.setEmptyMessage("No existen registros");
			}
			break;
		case "IA":
		case "I4":
		case "IT":
		case "MC":
			list.setEmptyMessage("Debe seleccionar una Sucursal para visualizar los items");
			break;
		default:
			list.setEmptyMessage("No existen registros");
			break;
		}
		catalogoF4101.doModal();
	}

	@Listen("onSeleccion = #catalogoItemF4101")
	public void seleccionarItem() {
		F4101 f4101 = catalogoF4101.objetoSeleccionadoDelCatalogo();
		llenarCamposItem(f4101);
		catalogoF4101.setParent(null);
	}

	@Listen("onChange = #txtItem; onOK=#txtItem ")
	public void buscarNombreItem() {
		F4101 f4101 = servicioF4101.buscar(txtItem.getValue());
		if (f4101 != null) {
			llenarCamposItem(f4101);
		} else {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
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
		if (tipo.equals("ET") || tipo.equals("MK") || versionCronica != null) {
			F4211 f42 = servicioF4211.buscarPorDocoEItem(txtPedido.getValue(),
					f4101.getImitm());
			spnCantidad.setValue(f42.getSdpqor().intValue());
			txtUbicacion2.setValue(f42.getSdlocn());
			lblUbicacion2.setValue(f42.getSdlocn());
		}
		if (clave41 != null) {
			F4111 f = servicioF4111.buscarTodosOrdenadosPorDoc("OV", claveDoc,
					f4101.getImitm(), loc);
			spnCosto.setValue(f.getIluncs());
			spnCantidad.setValue(f.getIltrqt().intValue());
		}
		calcularDisponibilidad(txtItem.getValue(), loc, txtPlanta1.getValue());
	}

	private void calcularDisponibilidad(Double value, String loc2, String value2) {
		if (tipo.equals("OV"))
			value2 = txtPlanta2.getValue();
		F41021PK clave = new F41021PK();
		clave.setLiitm(value);
		clave.setLilocn(loc2);
		clave.setLimcu(value2);
		clave.setLilotn("");
		F41021 buscado = servicioF41021.buscar(clave);
		if (buscado != null)
			if (buscado.getLipqoh() != null)
				lblDisponibilidad.setValue(String.valueOf(buscado.getLipqoh()
						.intValue()));
			else
				lblDisponibilidad.setValue(String.valueOf(0));
	}

	@Listen("onClick = #btnBuscarF0101")
	public void mostrarCatalogoDireccion() {

		List<F0101> listF41011 = new ArrayList<F0101>();
		if (!tipo.equals("DP"))
			listF41011 = servicioF0101.buscarTodosOrdenados();
		else
			listF41011 = servicioF0101.buscarProveedorConOrden("OV");
		final List<F0101> listF0101 = listF41011;
		catalogoF0101 = new CatalogoGenerico<F0101>(catalogoDireccionF0101,
				"Catalogo de Proveedores (F0101)", listF0101, true, false,
				false, "N� direccion", "Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal") {

			@Override
			protected List<F0101> buscar(List<String> valores) {

				List<F0101> lista = new ArrayList<F0101>();

				for (F0101 f01 : listF0101) {
					if (String.valueOf(f01.getAban8().longValue())
							.toLowerCase().contains(valores.get(0))
							&& f01.getAbalph().toLowerCase()
									.contains(valores.get(1))
							&& f01.getAbalky().toLowerCase()
									.contains(valores.get(2))
							&& f01.getAbsic().toLowerCase()
									.contains(valores.get(3))
							&& f01.getAbat1().toLowerCase()
									.contains(valores.get(4))
							&& f01.getAbtax().toLowerCase()
									.contains(valores.get(5))) {
						lista.add(f01);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0101 f013) {
				String[] registros = new String[6];
				registros[0] = String.valueOf(f013.getAban8().longValue());
				registros[1] = f013.getAbalph();
				registros[2] = f013.getAbalky();
				registros[3] = f013.getAbsic();
				registros[4] = f013.getAbat1();
				registros[5] = f013.getAbtax();
				return registros;
			}
		};
		catalogoF0101.setParent(catalogoDireccionF0101);
		Listbox list = (Listbox) catalogoF0101.getChildren().get(1);
		list.setEmptyMessage("No existen registros");
		catalogoF0101.doModal();
	}

	@Listen("onSeleccion = #catalogoDireccionF0101")
	public void seleccionarCatalogoDireccion() {
		F0101 f0101 = catalogoF0101.objetoSeleccionadoDelCatalogo();
		setearValores(f0101);
		catalogoF0101.setParent(null);
	}

	public void setearValores(F0101 f0101) {
		if (tipo.equals("DP")) {
			txtF4111P.setValue(null);
			lblF4111P.setValue("");
			claveDoc = null;
			clave41 = null;
		}
		if (tipo.equals("DP") || tipo.equals("OV")) {
			ltbItems.getItems().clear();
			ltbItems.renderAll();
			lista.clear();
		}
		loc = "";
		limpiarCamposItem();
		Double doble = f0101.getAban8();
		txtF0101.setValue(doble.longValue());
		lblF0101.setValue(f0101.getAbalph());
	}

	@Listen("onChange = #txtF0101; onOK = #txtF0101")
	public void buscarNombre() {
		if (txtF0101.getValue() != null) {
			F0101 f0101 = servicioF0101.buscar(txtF0101.getValue());
			if (f0101 != null) {
				setearValores(f0101);
			} else {
				Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
				txtF0101.setValue(null);
				txtF0101.setFocus(true);
				lblF0101.setValue("");
			}
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
			if (calcular(txtPlanta1)) {
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
					if (!tipo.equals("DP") && !tipo.equals("I4")) {
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
				Generico modelo = new Generico(item, itemNombre, um, ubicacion,
						"", ubicacion2, "", cantidad, costoIn);
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
			}
		} else
			Mensaje.mensajeError(Mensaje.camposVaciosItem);
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
				Mensaje.mensajeAlerta(Mensaje.editarSoloUno);
		} else
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
	}

	private void limpiarCamposItem() {
		txtItem.setValue(null);
		lblItem.setValue("");
		txtUbicacion2.setValue("");
		lblUbicacion2.setValue("");
		if (!tipo.equals("DP")) {
			txtUbicacion1.setValue("");
			lblUbicacion1.setValue("");
		}
		txtUM.setValue("");
		txtUM2.setValue("");
		spnCantidad.setValue(0);
		spnCosto.setValue((double) 0);
		spnCantidad2.setValue(0);
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
				Mensaje.mensajeAlerta(Mensaje.editarSoloUno);
		} else
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
	}

	public boolean calcular(Textbox txtPlanta22) {
		if (!tipo.equals("OV")) {
			Integer cantidad = spnCantidad.getValue();
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
			if (suma - cantidad < 0) {
				spnCantidad.setValue(Double.valueOf(suma).intValue());
				Mensaje.mensajeError(Mensaje.noPoseeExistencia);
				return false;
			} else
				return true;
		} else
			return true;
	}

	@Listen("onClick = #btnAgregarItems")
	public void mostrarGroupbox() {
		gpxItems.setVisible(true);
		rowBoton.setVisible(false);

	}

	@Listen("onChange=#txtDoc")
	public void validarDoc() {
		Double doc = txtDoc.getValue();
		List<F4111> lista2 = servicioF4111.buscarPorDoc(doc, tipo);
		if (!lista2.isEmpty()) {
			F4111 f4111 = lista2.get(0);
			txtDoc.setValue(f4111.getIldoc());
			if (f4111.getIldoco() != null)
				txtOrden.setValue(f4111.getIldoco());
			if (f4111.getIlan8() != null)
				txtF0101.setValue(f4111.getIlan8().longValue());
			txtPlanta1.setValue(f4111.getIlmcu());
			txtPlanta2.setValue(f4111.getIlmmcu());
			txtExplicacion.setValue(f4111.getIltrex());
			if (f4111.getIltrdj() != null)
				dtbFechaLm.setValue(transformarJulianaAGregoria(f4111
						.getIltrdj()));
			if (f4111.getIlcrdj() != null)
				dtbFechaTransaccion.setValue(transformarJulianaAGregoria(f4111
						.getIlcrdj()));
			for (int i = 0; i < lista2.size(); i++) {
				if (lista2.get(i).getIlitm() != null) {

					F4101 f4101 = servicioF4101
							.buscar(lista2.get(i).getIlitm());
					Generico generico = new Generico(lista2.get(i).getIlitm(),
							f4101.getImdsc1(), f4101.getImuom1(), lista2.get(i)
									.getIlmcu(), "", lista2.get(i).getIlmmcu(),
							"", lista2.get(i).getIltrqt().intValue(), lista2
									.get(i).getIluncs());
					generico.setValor11(lista2.get(i).getIlpaid());
					lista.add(generico);
				}
				ltbItems.setModel(new ListModelList<Generico>(lista));
				ltbItems.renderAll();
			}
			mostrarBotones(false);
			abrirRegistro();
			botonera.getChildren().get(3).setVisible(false);
			mostrarGroupbox();
		}
	}

	@Listen("onChange = #txtExplicacion; onOK = #txtExplicacion")
	public void referenciaDoc() {
		if (tipo.equals("MC")) {
			if (txtExplicacion != null) {
				if (txtExplicacion.getValue().compareTo("") != 0) {
					if (Validador.validarNumero(txtExplicacion.getValue())) {
						boolean sigue = true;
						Integer cont = 0;
						while (sigue) {
							cont++;
							List<F4111> lista2 = servicioF4111.buscarPorDoc(
									Double.valueOf(txtExplicacion.getValue())
											+ cont.doubleValue(), tipo);
							if (lista2.isEmpty())
								sigue = false;
						}
						txtDoc.setValue(Double.valueOf(txtExplicacion
								.getValue()) + cont.doubleValue());
						txtDoc.setTooltiptext("Se ha colocado un valor sugerido para el numero de documento, basandose en los datos del paciente que ha introducido");
					} else
						txtDoc.setValue(0);
				} else
					txtDoc.setValue(0);
			}
		}
	}
}
