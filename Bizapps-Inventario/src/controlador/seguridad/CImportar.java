package controlador.seguridad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F0010;
import modelo.maestros.F4100;
import modelo.maestros.F4101;
import modelo.maestros.F41021;
import modelo.maestros.F4105;
import modelo.pk.F4100PK;
import modelo.pk.F41021PK;
import modelo.pk.F4105PK;
import modelo.transacciones.F4111;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.A;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tab;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.Validador;

import controlador.maestros.CGenerico;

public class CImportar extends CGenerico {

	private static final long serialVersionUID = -7298493613443147836L;
	@Wire
	private Div botoneraImportar;
	@Wire
	private Div divImportar;
	@Wire
	private Label lblNombreEmpresa;
	@Wire
	private org.zkoss.zul.Row rowEmpresa;
	@Wire
	private Label lblNombreAlmacen;
	@Wire
	private org.zkoss.zul.Row rowAlmacen;
	@Wire
	private Label lblNombreUbicacion;
	@Wire
	private org.zkoss.zul.Row rowUbicacion;
	@Wire
	private Label lblNombreArticulo;
	@Wire
	private org.zkoss.zul.Row rowArticulo;
	@Wire
	private Label lblNombreZ;
	@Wire
	private org.zkoss.zul.Row rowZ;
	private Media mediaEmpresa;
	private Media mediaAlmacen;
	private Media mediaUbicacion;
	private Media mediaArticulo;
	private Media mediaZ;
	Botonera botonera;
	private String archivoConError = "Existe un error en el siguiente archivo adjunto: ";
	private String archivoVacio = "El siguiente archivo no posee registros, por lo tanto no fue importado.";
	private String udcNoEncontrada = "La siguiente UDC no fue encontrada.";
	private String errorLongitud = "La siguiente ubicacion excede el limite establecido de longitud:";
	private String valorNoEncontrado = "El valor que hace referencia no se ha encontrado en la tabla:";
	private boolean errorGeneral = false;

	@Override
	public void inicializar() throws IOException {
		HashMap<String, Object> map = (HashMap<String, Object>) Sessions
				.getCurrent().getAttribute("mapaGeneral");
		if (map != null) {
			if (map.get("tabsGenerales") != null) {
				tabs = (List<Tab>) map.get("tabsGenerales");
				map.clear();
				map = null;
			}
		}
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
			}

			@Override
			public void salir() {
				cerrarVentana(divImportar, "Importar", tabs);
			}

			@Override
			public void reporte() {
			}

			@Override
			public void limpiar() {
				if (rowAlmacen.getChildren().size() == 4) {
					A linea = (A) rowAlmacen.getChildren().get(3);
					Events.postEvent("onClick", linea, null);
				}
				if (rowArticulo.getChildren().size() == 4) {
					A linea = (A) rowArticulo.getChildren().get(3);
					Events.postEvent("onClick", linea, null);
				}
				if (rowEmpresa.getChildren().size() == 4) {
					A linea = (A) rowEmpresa.getChildren().get(3);
					Events.postEvent("onClick", linea, null);
				}
				if (rowUbicacion.getChildren().size() == 4) {
					A linea = (A) rowUbicacion.getChildren().get(3);
					Events.postEvent("onClick", linea, null);
				}
				if (rowZ.getChildren().size() == 4) {
					A linea = (A) rowZ.getChildren().get(3);
					Events.postEvent("onClick", linea, null);
				}
			}

			@Override
			public void guardar() {
				importarEmpresa();
				importarAlmacen();
				importarUbicacion();
				importarArticulo();
				importarZ();
				if (!errorGeneral) {
					msj.mensajeInformacion(Mensaje.guardadosArchivos);
					limpiar();
				}
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
			}
		};
		botonera.getChildren().get(0).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(4).setVisible(false);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botoneraImportar.appendChild(botonera);
	}

	@Listen("onUpload = #btnImportarEmpresa")
	public void cargarEmpresa(UploadEvent event) {
		mediaEmpresa = event.getMedia();
		if (mediaEmpresa != null && Validador.validarExcel(mediaEmpresa)) {
			lblNombreEmpresa.setValue(mediaEmpresa.getName());
			final A rm = new A("Remover");
			rm.addEventListener(Events.ON_CLICK,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event event) throws Exception {
							lblNombreEmpresa.setValue("");
							rm.detach();
							mediaEmpresa = null;
						}
					});
			rowEmpresa.appendChild(rm);
		} else
			msj.mensajeError(Mensaje.archivoExcel);
	}

	@Listen("onUpload = #btnImportarAlmacen")
	public void cargarAlmacen(UploadEvent event) {
		mediaAlmacen = event.getMedia();
		if (mediaAlmacen != null && Validador.validarExcel(mediaAlmacen)) {
			lblNombreAlmacen.setValue(mediaAlmacen.getName());
			final A rm = new A("Remover");
			rm.addEventListener(Events.ON_CLICK,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event event) throws Exception {
							lblNombreAlmacen.setValue("");
							rm.detach();
							mediaAlmacen = null;
						}
					});
			rowAlmacen.appendChild(rm);
		} else
			msj.mensajeError(Mensaje.archivoExcel);
	}

	@Listen("onUpload = #btnImportarUbicacion")
	public void cargarUbicacion(UploadEvent event) {
		mediaUbicacion = event.getMedia();
		if (mediaUbicacion != null && Validador.validarExcel(mediaUbicacion)) {
			lblNombreUbicacion.setValue(mediaUbicacion.getName());
			final A rm = new A("Remover");
			rm.addEventListener(Events.ON_CLICK,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event event) throws Exception {
							lblNombreUbicacion.setValue("");
							rm.detach();
							mediaUbicacion = null;
						}
					});
			rowUbicacion.appendChild(rm);
		} else
			msj.mensajeError(Mensaje.archivoExcel);
	}

	@Listen("onUpload = #btnImportarArticulo")
	public void cargarArticulo(UploadEvent event) {
		mediaArticulo = event.getMedia();
		if (mediaArticulo != null && Validador.validarExcel(mediaArticulo)) {
			lblNombreArticulo.setValue(mediaArticulo.getName());
			final A rm = new A("Remover");
			rm.addEventListener(Events.ON_CLICK,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event event) throws Exception {
							lblNombreArticulo.setValue("");
							rm.detach();
							mediaArticulo = null;
						}
					});
			rowArticulo.appendChild(rm);
		} else
			msj.mensajeError(Mensaje.archivoExcel);
	}

	@Listen("onUpload = #btnImportarZ")
	public void cargarZ(UploadEvent event) {
		mediaZ = event.getMedia();
		if (mediaZ != null && Validador.validarExcel(mediaZ)) {
			lblNombreZ.setValue(mediaZ.getName());
			final A rm = new A("Remover");
			rm.addEventListener(Events.ON_CLICK,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event event) throws Exception {
							lblNombreZ.setValue("");
							rm.detach();
							mediaZ = null;
						}
					});
			rowZ.appendChild(rm);
		} else
			msj.mensajeError(Mensaje.archivoExcel);
	}

	protected void importarZ() {

		if (mediaZ != null) {
			XSSFWorkbook workbook = null;
			try {
				workbook = new XSSFWorkbook(mediaZ.getStreamData());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			String mostrarError = "";
			if (rowIterator.hasNext()) {
				List<F4111> cardexs = new ArrayList<F4111>();
				int contadorRow = 0;
				boolean error = false;
				boolean errorLong = false;
				while (rowIterator.hasNext() && !error && !errorLong) {
					contadorRow = contadorRow + 1;
					Row row = rowIterator.next();
					F4100 ubicacion = new F4100();
					F0006 almacen = new F0006();
					F4101 articulo = new F4101();
					F4111 cardex = new F4111();
					Double idArticulo = null;
					Double cantidad = null;
					Double costo = null;
					Double almacenReferencia = (double) 0;
					String almacenRef = null;
					Double ubicacionReferencia = (double) 0;
					String ubicacionRef = null;
					Iterator<Cell> cellIterator = row.cellIterator();
					int contadorCell = 0;
					while (cellIterator.hasNext() && !error && !errorLong) {
						contadorCell = contadorCell + 1;
						Cell cell = cellIterator.next();
						switch (cell.getColumnIndex()) {
						case 0:
							if (cell.getCellType() == 0) {
								idArticulo = cell.getNumericCellValue();
							} else
								error = true;
							break;
						case 1:
							almacenRef = obtenerStringCualquiera(cell,
									almacenReferencia, almacenRef);
							if (almacenRef != null && almacenRef.length() > 12)
								errorLong = true;
							break;
						case 2:
							ubicacionRef = obtenerStringCualquiera(cell,
									ubicacionReferencia, ubicacionRef);
							if (ubicacionRef != null
									&& ubicacionRef.length() > 20)
								errorLong = true;
							break;
						case 3:
							if (cell.getCellType() == 0) {
								cantidad = cell.getNumericCellValue();
							} else
								error = true;
							break;
						case 4:
							if (cell.getCellType() == 0) {
								costo = cell.getNumericCellValue();
							} else
								error = true;
							break;
						default:
							break;
						}
					}
					if (!errorLong) {
						if (!error && almacenRef != null
								&& ubicacionRef != null && costo != null
								&& idArticulo != null && cantidad != null) {
							almacen = servicioF0006.buscar(almacenRef);
							if (almacen != null) {
								ubicacion = servicioF4100.buscarPorMcuYLoc(
										almacenRef, ubicacionRef);
								if (ubicacion != null) {
									articulo = servicioF4101.buscar(idArticulo);
									if (articulo != null) {
										cardex.setIluser(nombreUsuarioSesion());
										cardex.setIlvpej(transformarGregorianoAJulia(fecha));
										cardex.setIlicu(Double
												.valueOf(horaAuditoria));
										cardex.setIlukid(nextNumber("6", "JE"));
										cardex.setIldoc((double) 0);
										cardex.setIldct("Z0");
										cardex.setIltrex("Inicio de Inventario");
										cardex.setIllotn("");
										cardex.setIlmcu(almacenRef);
										cardex.setIllocn(ubicacionRef);
										cardex.setIlitm(idArticulo);
										cardex.setIltrum(articulo.getImuom1());
										cardex.setIluncs(costo);
										cardex.setIltrqt(cantidad);
										cardex.setIlpaid(cantidad * costo);
										cardexs.add(cardex);
									} else {
										mostrarError = mostrarError
												+ valorNoEncontrado
												+ " F4101. El valor es: "
												+ idArticulo
												+ ". Se encuentra en la Fila: "
												+ contadorRow;

										msj.mensajeError(valorNoEncontrado
												+ " F4101. El valor es: "
												+ idArticulo
												+ ". Se encuentra en la Fila: "
												+ contadorRow);
										error = true;
									}
								} else {
									mostrarError = mostrarError
											+ valorNoEncontrado
											+ " F4100. El valor es: "
											+ ubicacionRef + " y el Almacen:"
											+ almacenRef
											+ ". Se encuentra en la Fila: "
											+ contadorRow;

									msj.mensajeError(valorNoEncontrado
											+ " F4100. El valor es: "
											+ ubicacionRef + " y el Almacen:"
											+ almacenRef
											+ ". Se encuentra en la Fila: "
											+ contadorRow);
									error = true;
								}
							} else {
								mostrarError = mostrarError + valorNoEncontrado
										+ " F0006. El valor es: " + almacenRef
										+ ". Se encuentra en la Fila: "
										+ contadorRow;
								msj.mensajeError(valorNoEncontrado
										+ " F0006. El valor es: " + almacenRef
										+ ". Se encuentra en la Fila: "
										+ contadorRow);
								error = true;
							}
						} else {
							mostrarError = mostrarError + archivoConError
									+ lblNombreUbicacion.getValue()
									+ ". Fila: " + contadorRow + ". Columna: "
									+ contadorCell;

							msj.mensajeError(archivoConError
									+ lblNombreUbicacion.getValue()
									+ ". Fila: " + contadorRow + ". Columna: "
									+ contadorCell);
						}
					} else {
						mostrarError = mostrarError
								+ errorLongitud
								+ lblNombreUbicacion.getValue()
								+ ". Fila: "
								+ contadorRow
								+ ". Columna: "
								+ contadorCell
								+ ". Longitudes permitidas: campo1 20 y campo2 12";

						msj.mensajeError(errorLongitud
								+ lblNombreUbicacion.getValue()
								+ ". Fila: "
								+ contadorRow
								+ ". Columna: "
								+ contadorCell
								+ ". Longitudes permitidas: campo1 20 y campo2 12");
					}
				}
				if (!error) {
					for (int i = 0; i < cardexs.size(); i++) {
						// Saldo
						double cantidadAnterior = 0;
						F41021PK claveSaldo = new F41021PK();
						claveSaldo.setLiitm(cardexs.get(i).getIlitm());
						claveSaldo.setLilocn(cardexs.get(i).getIllocn());
						claveSaldo.setLilotn("");
						claveSaldo.setLimcu(cardexs.get(i).getIlmcu());
						F41021 f41021 = servicioF41021.buscar(claveSaldo);
						if (f41021 != null) {
							cantidadAnterior = f41021.getLipqoh();
							f41021.setLipqoh(f41021.getLipqoh()
									+ cardexs.get(i).getIltrqt());
						} else {
							f41021 = new F41021();
							f41021.setId(claveSaldo);
							f41021.setLipqoh(cardexs.get(i).getIltrqt());
						}
						servicioF41021.guardar(f41021);
						// Costos
						guardarCostoPromedio(cardexs.get(i), cantidadAnterior);
						F4105 f4105 = new F4105();
						F4105PK claveCostoUnitario = new F4105PK();
						claveCostoUnitario.setCoitm(cardexs.get(i).getIlitm());
						claveCostoUnitario.setComcu(cardexs.get(i).getIlmcu());
						claveCostoUnitario.setColocn("");
						claveCostoUnitario.setColotn("");
						claveCostoUnitario.setColedg("01");
						f4105.setId(claveCostoUnitario);
						f4105.setCouncs(cardexs.get(i).getIluncs());
						servicioF4105.guardar(f4105);
					}
					servicioF4111.guardarVarios(cardexs);
				} else
					errorGeneral = true;
			} else
				msj.mensajeAlerta(archivoVacio + " "
						+ lblNombreUbicacion.getValue());
		}
	}

	private void guardarCostoPromedio(F4111 cardex, double cantidadAnterior) {
		F4105 f4105 = new F4105();
		F4105PK claveCostoUnitario = new F4105PK();
		claveCostoUnitario.setCoitm(cardex.getIlitm());
		claveCostoUnitario.setComcu(cardex.getIlmcu());
		claveCostoUnitario.setColocn("");
		claveCostoUnitario.setColotn("");
		claveCostoUnitario.setColedg("02");
		f4105 = servicioF4105.buscar(claveCostoUnitario);
		if (f4105 != null) {
			servicioF4105.actualizarCostoPromedio(claveCostoUnitario, cardex
					.getIltrqt().intValue(), cantidadAnterior, cardex
					.getIluncs(), f4105.getCouncs());
		} else {
			f4105 = new F4105();
			f4105.setId(claveCostoUnitario);
			f4105.setCouncs(cardex.getIluncs());
			servicioF4105.guardar(f4105);
		}
	}

	protected void importarArticulo() {
		if (mediaArticulo != null) {
			XSSFWorkbook workbook = null;
			try {
				workbook = new XSSFWorkbook(mediaArticulo.getStreamData());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			if (rowIterator.hasNext()) {
				List<F4101> articulos = new ArrayList<F4101>();
				int contadorRow = 0;
				boolean error = false;
				boolean errorLong = false;
				while (rowIterator.hasNext() && !error && !errorLong) {
					contadorRow = contadorRow + 1;
					Row row = rowIterator.next();
					F0005 udc = new F0005();
					F0005 udc2 = new F0005();
					F4101 articulo = new F4101();
					Double idReferencia = (double) 0;
					String idRef = null;
					String nombre = null;
					Double udcReferencia = (double) 0;
					String campoUdc = null;
					Double udcReferencia2 = (double) 0;
					String campoUdc2 = null;
					Iterator<Cell> cellIterator = row.cellIterator();
					int contadorCell = 0;
					while (cellIterator.hasNext() && !error && !errorLong) {
						contadorCell = contadorCell + 1;
						Cell cell = cellIterator.next();
						switch (cell.getColumnIndex()) {
						case 0:
							idRef = obtenerStringCualquiera(cell, idReferencia,
									idRef);
							if (idRef != null && idRef.length() > 25)
								errorLong = true;
							break;
						case 1:
							if (cell.getCellType() == 1) {
								nombre = cell.getStringCellValue();
							} else
								error = true;
							if (nombre.length() > 30)
								errorLong = true;
							break;
						case 2:
							campoUdc = obtenerStringCualquiera(cell,
									udcReferencia, campoUdc);
							if (campoUdc.length() > 1)
								errorLong = true;
							break;
						case 3:
							campoUdc2 = obtenerStringCualquiera(cell,
									udcReferencia2, campoUdc2);
							if (campoUdc.length() > 2)
								errorLong = true;
							break;
						default:
							break;
						}
					}
					if (!errorLong) {
						if (!error && campoUdc != null && idRef != null
								&& nombre != null && campoUdc2 != null) {
							udc = servicioF0005.buscar("41", "I", campoUdc);
							if (udc != null) {
								udc2 = servicioF0005.buscar("00", "UM",
										campoUdc2);
								if (udc2 != null) {
									articulo.setImitm(nextNumber("4", "JE"));
									articulo.setImlitm(idRef);
									articulo.setImdsc1(nombre);
									articulo.setImuom1(campoUdc2);
									articulo.setImstkt(campoUdc);
									articulo.setImdsc2("");
									articulo.setImsrtx("");
									articulo.setImglpt("");
									articulo.setImlnty("");
									articulo.setImbpfg("");
									articulo.setImclev("");
									articulo.setImplev("");
									articulo.setImpplv("");
									articulo.setImpmth("");
									articulo.setImcmeth("");
									articulo.setImcmgl("");
									articulo.setIminmg("");
									articulo.setImifla("");
									articulo.setImtfla("");
									articulo.setImprgr("");
									articulo.setImrprc("");
									articulo.setImorpr("");
									articulo.setImdsgp("");
									articulo.setImuom2("");
									articulo.setImuom3("");
									articulo.setImuom4("");
									articulo.setImuom6("");
									articulo.setImuom8("");
									articulo.setImuom9("");
									articulo.setImuwum("");
									articulo.setImuvm1("");
									articulo.setImsrnr("");
									articulo.setImlots("");
									articulo.setImsrce("");
									articulo.setImcmdm("");
									articulo.setImlecm("");
									articulo.setImxdck("N");
									articulo.setImdual("N");
									articulo.setImdppo("N");
									articulo.setImback("N");
									articulo.setImckav("N");
									articulo.setImupmj(transformarGregorianoAJulia(fecha));
									// articulo.setImupmt(Double
									// .valueOf(horaAuditoria));
									articulo.setImuser("frivero");
									articulos.add(articulo);
								} else {
									msj.mensajeError(udcNoEncontrada + " 00,"
											+ "UM," + campoUdc2);
									error = true;
								}
							} else {
								msj.mensajeError(udcNoEncontrada + " 41,"
										+ "I," + campoUdc);
								error = true;
							}
						} else {
							msj.mensajeError(archivoConError
									+ lblNombreArticulo.getValue() + ". Fila: "
									+ contadorRow + ". Columna: "
									+ contadorCell);
							error = true;
						}
					} else {
						msj.mensajeError(errorLongitud
								+ lblNombreArticulo.getValue()
								+ ". Fila: "
								+ contadorRow
								+ ". Columna: "
								+ contadorCell
								+ ". Longitudes permitidas: campo1 25, campo2 30, campo3 1 y campo4 2");
						error = true;
					}
				}
				if (!error) {
					String nombre = "";
					for (int i = 0; i < articulos.size(); i++) {
						nombre = articulos.get(i).getImdsc1();
						if (i < articulos.size() - 1) {
							for (int j = i + 1; j < articulos.size(); j++) {
								if (articulos.get(j).getImdsc1().equals(nombre)) {
									articulos.get(j).setImdsc1(nombre + "2");
									j = articulos.size();
								}
							}
						}
					}
					servicioF4101.guardarVarios(articulos);
				} else
					errorGeneral = true;
			} else
				msj.mensajeAlerta(archivoVacio + " "
						+ lblNombreArticulo.getValue());
		}
	}

	protected void importarUbicacion() {
		if (mediaUbicacion != null) {
			XSSFWorkbook workbook = null;
			try {
				workbook = new XSSFWorkbook(mediaUbicacion.getStreamData());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			if (rowIterator.hasNext()) {
				List<F4100> ubicaciones = new ArrayList<F4100>();
				int contadorRow = 0;
				boolean error = false;
				boolean errorLong = false;
				while (rowIterator.hasNext() && !error && !errorLong) {
					contadorRow = contadorRow + 1;
					Row row = rowIterator.next();
					F4100 ubicacion = new F4100();
					F0006 almacen = new F0006();
					Double idReferencia = (double) 0;
					String idRef = null;
					Double almacenReferencia = (double) 0;
					String almacenRef = null;
					Iterator<Cell> cellIterator = row.cellIterator();
					int contadorCell = 0;
					while (cellIterator.hasNext() && !error && !errorLong) {
						contadorCell = contadorCell + 1;
						Cell cell = cellIterator.next();
						switch (cell.getColumnIndex()) {
						case 0:
							idRef = obtenerStringCualquiera(cell, idReferencia,
									idRef);
							if (idRef != null && idRef.length() > 20)
								errorLong = true;
							break;
						case 1:
							almacenRef = obtenerStringCualquiera(cell,
									almacenReferencia, almacenRef);
							if (almacenRef != null && almacenRef.length() > 12)
								errorLong = true;
							break;
						default:
							break;
						}
					}
					if (!errorLong) {
						if (!error && almacenRef != null && idRef != null) {
							almacen = servicioF0006.buscar(almacenRef);
							if (almacen != null) {
								F4100PK clave = new F4100PK();
								clave.setLmmcu(almacenRef);
								clave.setLmlocn(idRef);
								ubicacion.setId(clave);
								ubicacion
										.setLmupmj(transformarGregorianoAJulia(fecha));
								ubicacion.setLmpzon("");
								ubicacion.setLmkzon("");
								ubicacion.setLmzonr("");
								ubicacion.setLmlldl("");
								ubicacion.setLmmixl("");
								ubicacion.setLmstag("");
								ubicacion
										.setLmupmj(transformarGregorianoAJulia(fecha));
								// ubicacion.setLmupmt(Double.valueOf(horaAuditoria));
								ubicacion.setLmuser("frivero");
								ubicaciones.add(ubicacion);
							} else {
								msj.mensajeError(valorNoEncontrado
										+ " F0006. El valor es: " + almacenRef
										+ ". Fila: " + contadorRow
										+ ". Columna: " + contadorCell);
								error = true;
							}
						} else {
							msj.mensajeError(archivoConError
									+ lblNombreUbicacion.getValue()
									+ ". Fila: " + contadorRow + ". Columna: "
									+ contadorCell);
							error = true;
						}
					} else {
						msj.mensajeError(errorLongitud
								+ lblNombreUbicacion.getValue()
								+ ". Fila: "
								+ contadorRow
								+ ". Columna: "
								+ contadorCell
								+ ". Longitudes permitidas: campo1 20 y campo2 12");
						error = true;
					}
				}
				if (!error) {
					servicioF4100.guardarVarios(ubicaciones);
				} else
					errorGeneral = true;
			} else
				msj.mensajeAlerta(archivoVacio + " "
						+ lblNombreUbicacion.getValue());
		}
	}

	protected void importarAlmacen() {
		if (mediaAlmacen != null) {
			XSSFWorkbook workbook = null;
			try {
				workbook = new XSSFWorkbook(mediaAlmacen.getStreamData());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			if (rowIterator.hasNext()) {
				List<F0006> almacenes = new ArrayList<F0006>();
				int contadorRow = 0;
				boolean error = false;
				boolean errorLong = false;
				while (rowIterator.hasNext() && !error && !errorLong) {
					contadorRow = contadorRow + 1;
					Row row = rowIterator.next();
					F0010 empresa = new F0010();
					F0006 almacen = new F0006();
					Double idReferencia = (double) 0;
					String idRef = null;
					String nombre = null;
					Double empresaReferencia = (double) 0;
					String empresaRef = null;
					Iterator<Cell> cellIterator = row.cellIterator();
					int contadorCell = 0;
					while (cellIterator.hasNext() && !error && !errorLong) {
						contadorCell = contadorCell + 1;
						Cell cell = cellIterator.next();
						switch (cell.getColumnIndex()) {
						case 0:
							idRef = obtenerStringCualquiera(cell, idReferencia,
									idRef);
							if (idRef != null && idRef.length() > 12)
								errorLong = true;
							break;
						case 1:
							empresaRef = obtenerStringCualquiera(cell,
									empresaReferencia, empresaRef);
							if (empresaRef != null && empresaRef.length() > 5)
								errorLong = true;
							break;
						case 2:
							if (cell.getCellType() == 1) {
								nombre = cell.getStringCellValue();
								if (nombre.length() > 30)
									errorLong = true;
							} else
								error = true;
							break;
						default:
							break;
						}
					}
					if (!errorLong) {
						if (!error && empresaRef != null && idRef != null
								&& nombre != null) {
							empresa = servicioF0010.buscar(empresaRef);
							if (empresa != null) {
								almacen.setMcmcu(idRef);
								almacen.setMcco(empresaRef);
								almacen.setMcdl01(nombre);
								almacen.setMcldm("");
								almacen.setMcstyl("");
								almacen.setMcsbli("");
								almacen.setMcfmod("");
								almacen.setMcdl02("");
								almacen.setMcdl03("");
								almacen.setMcdl04("");
								almacen.setMcan8((double) 0);
								almacen.setMctxa1("");
								almacen.setMcmcus("");
								almacen.setMcpecc("");
								almacen.setMcrp01("");
								almacen.setMcrp02("");
								almacen.setMcrp03("");
								almacen.setMcrp04("");
								almacen.setMcrp05("");
								almacen.setMcrp06("");
								almacen.setMcrp07("");
								almacen.setMcrp08("");
								almacen.setMcrp09("");
								almacen.setMcrp10("");
								almacen.setMcrp11("");
								almacen.setMcrp12("");
								almacen.setMcrp13("");
								almacen.setMcrp14("");
								almacen.setMcrp15("");
								almacen.setMcrp16("");
								almacen.setMcrp17("");
								almacen.setMcrp18("");
								almacen.setMcrp19("");
								almacen.setMcrp20("");
								almacen.setMcrp21("");
								almacen.setMcrp22("");
								almacen.setMcrp23("");
								almacen.setMcrp24("");
								almacen.setMcrp25("");
								almacen.setMcrp26("");
								almacen.setMcrp27("");
								almacen.setMcrp28("");
								almacen.setMcrp29("");
								almacen.setMcrp30("");
								almacen.setMcupmj(transformarGregorianoAJulia(fecha));
								almacen.setMcupmt(Double.valueOf(horaAuditoria));
								almacen.setMcuser("frivero");
								almacenes.add(almacen);
							} else {
								msj.mensajeError(valorNoEncontrado
										+ " F0010. El valor es: " + empresaRef
										+ ". Fila: " + contadorRow
										+ ". Columna: " + contadorCell);
								error = true;
							}
						} else {
							msj.mensajeError(archivoConError
									+ lblNombreAlmacen.getValue() + ". Fila: "
									+ contadorRow + ". Columna: "
									+ contadorCell);
						}
					} else
						msj.mensajeError(errorLongitud
								+ lblNombreAlmacen.getValue()
								+ ". Fila: "
								+ contadorRow
								+ ". Columna: "
								+ contadorCell
								+ ". Longitudes permitidas: campo1 12, campo2 5 y campo3 30");
				}
				if (!error) {
					String nombre = "";
					for (int i = 0; i < almacenes.size(); i++) {
						nombre = almacenes.get(i).getMcdl01();
						if (i < almacenes.size() - 1) {
							for (int j = i + 1; j < almacenes.size(); j++) {
								if (almacenes.get(j).getMcdl01().equals(nombre)) {
									almacenes.get(j).setMcdl01(nombre + "2");
									j = almacenes.size();
								}
							}
						}
					}
					servicioF0006.guardarVarios(almacenes);
				} else
					errorGeneral = true;
			} else
				msj.mensajeAlerta(archivoVacio + " "
						+ lblNombreAlmacen.getValue());
		}
	}

	protected void importarEmpresa() {
		if (mediaEmpresa != null) {
			XSSFWorkbook workbook = null;
			try {
				workbook = new XSSFWorkbook(mediaEmpresa.getStreamData());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			if (rowIterator.hasNext()) {
				List<F0010> empresas = new ArrayList<F0010>();
				int contadorRow = 0;
				boolean error = false;
				boolean errorLong = false;
				while (rowIterator.hasNext() && !error && !errorLong) {
					contadorRow = contadorRow + 1;
					Row row = rowIterator.next();
					F0010 empresa = new F0010();
					F0005 udc = new F0005();
					Double idReferencia = (double) 0;
					String idRef = null;
					String nombre = null;
					Double udcReferencia = (double) 0;
					String campoUdc = null;
					Date fechaReferencia = null;
					Iterator<Cell> cellIterator = row.cellIterator();
					int contadorCell = 0;
					while (cellIterator.hasNext() && !error && !errorLong) {
						contadorCell = contadorCell + 1;
						Cell cell = cellIterator.next();
						switch (cell.getColumnIndex()) {
						case 0:
							idRef = obtenerStringCualquiera(cell, idReferencia,
									idRef);
							if (idRef.length() > 5)
								errorLong = true;
							break;
						case 1:
							if (cell.getCellType() == 1) {
								nombre = cell.getStringCellValue();
							} else
								error = true;
							if (nombre.length() > 255)
								errorLong = true;
							break;
						case 2:
							campoUdc = obtenerStringCualquiera(cell,
									udcReferencia, campoUdc);
							if (campoUdc.length() > 10)
								errorLong = true;
							break;
						case 3:
							if (cell.getCellType() == 0) {
								fechaReferencia = cell.getDateCellValue();
							} else
								error = true;
							break;
						default:
							break;
						}
					}
					if (!errorLong) {
						if (!error && campoUdc != null && idRef != null
								&& nombre != null && fechaReferencia != null) {
							udc = servicioF0005.buscar("H00", "DP", campoUdc);
							if (udc != null) {
								empresa.setCcco(idRef);
								empresa.setCcname(nombre);
								empresa.setCcdtpn(campoUdc);
								empresa.setCcarfj(transformarGregorianoAJulia(fechaReferencia));
								empresa.setCcdfyj(transformarGregorianoAJulia(fechaReferencia));
								empresa.setCcapfj(transformarGregorianoAJulia(fechaReferencia));
								empresa.setCcabin("0");
								empresa.setCcdprc("0");
								empresa.setCcbktx("");
								empresa.setCcdot2("");
								empresa.setCccald("");
								empresa.setCcpnc(0);
								empresa.setCcappn(0);
								empresa.setCcarpn(0);
								empresa.setCcpnf(0);
								empresa.setCcfry(0);
								empresa.setCcupmj(transformarGregorianoAJulia(fecha));
								empresa.setCcupmt(Double.valueOf(horaAuditoria));
								empresa.setCcuser("frivero");
								empresas.add(empresa);
							} else {
								msj.mensajeError(udcNoEncontrada + " H00,"
										+ "DP," + campoUdc);
								error = true;
							}
						} else {
							msj.mensajeError(archivoConError
									+ lblNombreEmpresa.getValue() + ". Fila: "
									+ contadorRow + ". Columna: "
									+ contadorCell);
						}
					} else
						msj.mensajeError(errorLongitud
								+ lblNombreEmpresa.getValue()
								+ ". Fila: "
								+ contadorRow
								+ ". Columna: "
								+ contadorCell
								+ ". Longitudes permitidas: campo1 5, campo2 255, campo3 10 y campo4 formatoFecha");
				}
				if (!error) {
					String nombre = "";
					for (int i = 0; i < empresas.size(); i++) {
						nombre = empresas.get(i).getCcname();
						if (i < empresas.size() - 1) {
							for (int j = i + 1; j < empresas.size(); j++) {
								if (empresas.get(j).getCcname().equals(nombre)) {
									empresas.get(j).setCcname(nombre + "2");
									j = empresas.size();
								}
							}
						}
					}
					servicioF0010.guardarVarios(empresas);
				} else
					errorGeneral = true;
			} else
				msj.mensajeAlerta(archivoVacio + " "
						+ lblNombreEmpresa.getValue());
		}
	}

	private String obtenerStringCualquiera(Cell cell, Double idReferencia,
			String idRef) {
		if (cell.getCellType() == 0) {
			idReferencia = cell.getNumericCellValue();
			if (idReferencia != null)
				return idRef = String.valueOf(idReferencia.longValue());
			else
				return null;
		} else {
			if (cell.getCellType() == 1) {
				if (!cell.getStringCellValue().equals("NULL"))
					return idRef = cell.getStringCellValue();
				else
					return null;
			}
			return null;
		}
	}

}
