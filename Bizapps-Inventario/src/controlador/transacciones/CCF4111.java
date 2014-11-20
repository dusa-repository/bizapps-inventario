package controlador.transacciones;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0005;
import modelo.maestros.F0006;
import modelo.maestros.F4008;
import modelo.maestros.F4100;
import modelo.maestros.F4101;
import modelo.maestros.F41021;
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
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.BuscadorUDC;
import componentes.Catalogo;
import componentes.Mensaje;
import controlador.maestros.CGenerico;

public class CCF4111 extends CGenerico {

	private static final long serialVersionUID = 1113088528652686287L;
	@Wire
	private Div divbuscadorTipo;
	BuscadorUDC buscadorTipo;
	@Wire
	private Datebox dtbDesde;
	@Wire
	private Datebox dtbHasta;
	@Wire
	private Doublebox txtItem;
	@Wire
	private Label lblItem;
	@Wire
	private Textbox txtPlanta;
	@Wire
	private Label lblPlanta;
	@Wire
	private Textbox txtUbicacion;
	@Wire
	private Label lblUbicacion;
	@Wire
	private Textbox txtLote;
	@Wire
	private Label lblLote;
	@Wire
	private Doublebox txtExistencia;
	@Wire
	private Doublebox txtValor;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Div divVCF4111;
	@Wire
	private Div divCatalogoF4101;
	@Wire
	private Div divCatalogoF4100;
	@Wire
	private Div divCatalogoF0006;
	@Wire
	private Div divCatalogoF4008;
	@Wire
	private Div catalogoCF4111;
	@Wire
	private Div botoneraCF4111;
	Botonera botonera;
	Catalogo<F0006> catalogoF0006;
	Catalogo<F4100> catalogoF4100;
	Catalogo<F4101> catalogoF4101;
	Catalogo<F4008> catalogoF4008;
	Catalogo<F4111> catalogo;
	private String titulo = "";
	List<F4111> lista = new ArrayList<F4111>();
	String mcu = "";

	@Override
	public void inicializar() throws IOException {
		txtExistencia.setDisabled(true);
		txtValor.setDisabled(true);
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
		txtItem.setFocus(true);
		mostrarCatalogo();
		cargarBuscador();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void salir() {
				cerrarVentana(divVCF4111, titulo, tabs);
			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void limpiar() {
				lblItem.setValue("");
				lblLote.setValue("");
				lblPlanta.setValue("");
				lblUbicacion.setValue("");
				txtExistencia.setValue(null);
				txtItem.setValue(null);
				txtLote.setValue("");
				txtPlanta.setValue("");
				txtUbicacion.setValue("");
				txtValor.setValue(null);
				buscadorTipo.settearCampo(null);
				lista = new ArrayList<F4111>();
				catalogo.actualizarLista(lista);
			}

			@Override
			public void guardar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void buscar() {
				if (validar()) {
					String planta = "";
					if (txtPlanta.getText().compareTo("") != 0)
						planta = txtPlanta.getValue();
					else
						planta = "%";
					String ubicacion = "";
					if (txtUbicacion.getText().compareTo("") != 0)
						ubicacion = txtUbicacion.getValue();
					else
						ubicacion = "%";
					String lote = "";
					if (txtLote.getText().compareTo("") != 0)
						lote = txtLote.getValue();
					else
						lote = "%";
					String tipo = "";
					if (buscadorTipo.obtenerCaja().compareTo("") != 0)
						tipo = buscadorTipo.obtenerCaja();
					else
						tipo = "%";
					Double item = txtItem.getValue();
					BigDecimal ilvpej1 = transformarGregorianoAJulia(dtbDesde
							.getValue());
					BigDecimal ilvpej2 = transformarGregorianoAJulia(dtbHasta
							.getValue());
					lista = servicioF4111.buscarEntreFechasItemMcuLocnDct(
							ilvpej1, ilvpej2, item, planta, ubicacion, lote,
							tipo);
					catalogo.actualizarLista(lista);
					double cantidad = 0, valor = 0;
					for (int i = 0; i < lista.size(); i++) {
						valor = valor + lista.get(i).getIlpaid();
						cantidad = cantidad + lista.get(i).getIltrqt();
					}
					txtExistencia.setValue(cantidad);
					txtValor.setValue(valor);
					if (lista.isEmpty())
						msj.mensajeAlerta(Mensaje.noHayRegistros);
				}
			}

			@Override
			public void ayuda() {
				// TODO Auto-generated method stub

			}

			@Override
			public void annadir() {
				// TODO Auto-generated method stub

			}
		};
		botonera.getChildren().get(0).setVisible(false);
		Button guardar = (Button) botonera.getChildren().get(1);
		guardar.setLabel("Buscar");
		guardar.setImage("/public/imagenes/botones/buscar.png");
		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(4).setVisible(false);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botoneraCF4111.appendChild(botonera);
	}

	private void cargarBuscador() {
		List<F0005> listaF0005 = servicioF0005.buscarParaUDCOrdenados("00",
				"DT");
		buscadorTipo = new BuscadorUDC("Tipo Documento", 2, listaF0005, false,
				false, false, "00", "DT") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "DT",
						buscadorTipo.obtenerCaja());
			}
		};
		divbuscadorTipo.appendChild(buscadorTipo);
	}

	protected boolean validar() {
		if (txtItem.getText().compareTo("") == 0) {
			Mensaje.mensajeAlerta(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	private void mostrarCatalogo() {
		final List<F4111> objetos = lista;
		catalogo = new Catalogo<F4111>(catalogoCF4111, "CF4111", objetos,
				false, true, true, "Numero Documento", "Tipo doc", "Fecha",
				"Sucursal/planta", "Cantidad", "UM", "Costo Unitario",
				"Costo Total", "Ubicacion", "Lote") {

			@Override
			protected List<F4111> buscar(List<String> valores) {

				List<F4111> unidadnegocio = new ArrayList<F4111>();

				for (F4111 objeto : lista) {
					if (String.valueOf(objeto.getIldoc().longValue())
							.toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& objeto.getIldct().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(objeto
											.getIlvpej())).toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& objeto.getIlmcu().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& String.valueOf(objeto.getIltrqt()).toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& objeto.getIltrum().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& String.valueOf(objeto.getIluncs()).toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& String.valueOf(objeto.getIlpaid()).toLowerCase()
									.contains(valores.get(7).toLowerCase())
							&& objeto.getIllocn().toLowerCase()
									.contains(valores.get(8).toLowerCase())
							&& objeto.getIllotn().toLowerCase()
									.contains(valores.get(9).toLowerCase())) {
						unidadnegocio.add(objeto);
					}
				}
				return unidadnegocio;
			}

			@Override
			protected String[] crearRegistros(F4111 objeto) {
				String[] registros = new String[10];
				registros[0] = String.valueOf(objeto.getIldoc().longValue());
				registros[1] = objeto.getIldct();
				registros[2] = formatoFecha
						.format(transformarJulianaAGregoria(objeto.getIlvpej()));
				registros[3] = objeto.getIlmcu();
				registros[4] = String.valueOf(objeto.getIltrqt());
				registros[5] = objeto.getIltrum();
				registros[6] = String.valueOf(objeto.getIluncs());
				registros[7] = String.valueOf(objeto.getIlpaid());
				registros[8] = objeto.getIllocn();
				registros[9] = objeto.getIllotn();
				return registros;
			}
		};
		catalogo.setParent(catalogoCF4111);
	}

	@Listen("onClick = #btnBuscarPlanta")
	public void mostrarCatalogoF0006() {
		final List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoF0006 = new Catalogo<F0006>(divCatalogoF0006, "F0006",
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
							.contains(valores.get(0).toLowerCase())
							&& mcdc.toLowerCase().contains(
									valores.get(1).toLowerCase())
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
		catalogoF0006.setParent(divCatalogoF0006);
		catalogoF0006.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0006")
	public void seleccionarSucursal() {
		F0006 f06 = catalogoF0006.objetoSeleccionadoDelCatalogo();
		setearPlanta(f06, txtPlanta, lblPlanta);
		mcu = f06.getMcmcu();
		txtUbicacion.setValue("");
		lblUbicacion.setValue("");
		catalogoF0006.setParent(null);
	}

	@Listen("onChange = #txtPlanta")
	public void buscarNombreSucursal() {
		F0006 f06 = new F0006();
		f06 = servicioF0006.buscar(txtPlanta.getValue());
		if (f06 != null) {
			setearPlanta(f06, txtPlanta, lblPlanta);
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtPlanta.setValue("");
			txtPlanta.setFocus(true);
			lblPlanta.setValue("");
		}

	}

	private void setearPlanta(F0006 f06, Textbox txtPlanta12, Label lblPlanta12) {
		txtPlanta12.setValue(f06.getMcmcu());
		lblPlanta12.setValue(f06.getMcdl01());
	}

	@Listen("onClick = #btnBuscarUbicacion")
	public void mostrarCatalogoF4100() {
		final List<F4100> listF41002 = servicioF4100
				.buscarTodosOrdenadosPorMcu(mcu);
		catalogoF4100 = new Catalogo<F4100>(divCatalogoF4100, "F4100",
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
		catalogoF4100.setParent(divCatalogoF4100);
		catalogoF4100.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF4100")
	public void seleccionarCatalogo() {
		F4100 f4100 = catalogoF4100.objetoSeleccionadoDelCatalogo();
		setearUbicacion(f4100, txtUbicacion, lblUbicacion);
		catalogoF4100.setParent(null);
	}

	@Listen("onChange = #txtUbicacion")
	public void buscarNombreUbicacion() {
		F4100 f4100 = servicioF4100.buscarPorMcuYLoc(mcu,
				txtUbicacion.getValue());
		if (f4100 != null) {
			setearUbicacion(f4100, txtUbicacion, lblUbicacion);
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtUbicacion.setValue("");
			txtUbicacion.setFocus(true);
			lblUbicacion.setValue("");
		}
	}

	private void setearUbicacion(F4100 f4100, Textbox txtUbicacion22,
			Label lblUbicacion22) {
		txtUbicacion22.setValue(f4100.getId().getLmlocn());
		lblUbicacion22.setValue(f4100.getId().getLmlocn());

	}

	@Listen("onClick = #btnBuscarItem")
	public void mostrarCatalogoF4101() {
		List<F4101> listF41011 = new ArrayList<F4101>();
		if (!mcu.equals(""))
			listF41011 = servicioF4101.buscarTodosOrdenadosPorMcu(mcu);
		else
			listF41011 = servicioF4101.buscarTodosOrdenados();
		final List<F4101> listF4101 = listF41011;
		catalogoF4101 = new Catalogo<F4101>(divCatalogoF4101, "F4101",
				listF4101, true, false, false, "Número artículo",
				"Descripcion", "Texto búsqueda", "Tipo línea", "Tipo alm",
				"Código vta 1") {

			@Override
			protected List<F4101> buscar(List<String> valores) {

				List<F4101> lista = new ArrayList<F4101>();

				for (F4101 f4101 : listF4101) {
					String valor = "";
					if (f4101.getImsrp1() != null)
						valor = f4101.getImsrp1();
					if (f4101.getImlitm().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f4101.getImdsc1().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& f4101.getImsrtx().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& f4101.getImlnty().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f4101.getImstkt().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& valor.toLowerCase().contains(
									valores.get(5).toLowerCase())) {
						lista.add(f4101);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F4101 f4101) {
				String valor = "";
				if (f4101.getImsrp1() != null)
					valor = f4101.getImsrp1();
				String[] registros = new String[6];
				registros[0] = f4101.getImlitm();
				registros[1] = f4101.getImdsc1();
				registros[2] = f4101.getImsrtx();
				registros[3] = f4101.getImlnty();
				registros[4] = f4101.getImstkt();
				registros[5] = valor;
				return registros;
			}
		};
		catalogoF4101.setParent(divCatalogoF4101);
		catalogoF4101.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF4101")
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
			lblItem.setValue("");
		}
	}

	private void llenarCamposItem(F4101 f4101) {
		txtItem.setValue(f4101.getImitm());
		lblItem.setValue(f4101.getImdsc1());
	}

}