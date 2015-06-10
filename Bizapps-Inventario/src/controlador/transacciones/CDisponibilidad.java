package controlador.transacciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0006;
import modelo.maestros.F4101;
import modelo.maestros.F41021;
import modelo.pk.F41021PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.catalogos.CatalogoF0006;
import componentes.catalogos.CatalogoF4101;
import componentes.catalogos.CatalogoGenerico;

import controlador.maestros.CGenerico;

public class CDisponibilidad extends CGenerico {
	
	private static final long serialVersionUID = 3977613268049701768L;
	@Wire
	private Doublebox txtItem;
	@Wire
	private Label lblItem;
	@Wire
	private Textbox txtPlanta;
	@Wire
	private Textbox txtUM;
	@Wire
	private Label lblPlanta;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Div divVDisponibilidad;
	@Wire
	private Div divCatalogoF4101;
	@Wire
	private Div divCatalogoF0006;
	@Wire
	private Div catalogoDisponibilidad;
	@Wire
	private Div botoneraDisponibilidad;
	@Wire
	private Checkbox chkResumen;
	@Wire
	private Checkbox chkCeros;
	Botonera botonera;
	CatalogoGenerico<F0006> catalogoF0006;
	CatalogoGenerico<F4101> catalogoF4101;
	CatalogoGenerico<F41021> catalogo;
	List<F41021> lista = new ArrayList<F41021>();
	String mcu = "";

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
		mostrarCatalogo();

		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void salir() {

				cerrarVentana(divVDisponibilidad, titulo, tabs);
			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void limpiar() {
				lblItem.setValue("");
				lblPlanta.setValue("");
				txtItem.setValue(null);
				txtUM.setValue("");
				txtPlanta.setValue("");
				lista = new ArrayList<F41021>();
				catalogo.actualizarLista(lista);
				chkCeros.setChecked(false);
				chkResumen.setChecked(false);
				mcu = "";
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
					lista.clear();
					String planta = "";
					if (txtPlanta.getText().compareTo("") != 0)
						planta = txtPlanta.getValue();
					else
						planta = "%";
					List<F41021> buscados = new ArrayList<F41021>();
					if (chkCeros.isChecked())
						buscados = servicioF41021.buscarPorItemMcuSinCeros(
								planta, txtItem.getValue());
					else
						buscados = servicioF41021.buscarPorItemMcu(planta,
								txtItem.getValue());

					if (!buscados.isEmpty()) {
						String mcu = buscados.get(0).getId().getLimcu();
						double valorMcu = 0;
						double valorTotal = 0;
						if (!chkResumen.isChecked()) {
							for (int i = 0; i < buscados.size(); i++) {
								if (mcu.equals(buscados.get(i).getId()
										.getLimcu())) {
									lista.add(buscados.get(i));
									valorMcu = valorMcu
											+ buscados.get(i).getLipqoh();
								} else {
									F41021PK pk = new F41021PK();
									F41021 f41021 = new F41021();
									pk.setLiitm(buscados.get(i).getId()
											.getLiitm());
									pk.setLilotn("");
									pk.setLimcu(mcu);
									pk.setLilocn("TOTAL");
									f41021.setId(pk);
									f41021.setLiupmj(buscados.get(i)
											.getLiupmj());
									f41021.setLipqoh(valorMcu);
									valorTotal = valorTotal + valorMcu;
									lista.add(f41021);
									valorMcu = 0;
									mcu = buscados.get(i).getId().getLimcu();
									i--;
								}
							}
						} else {
							for (int i = 0; i < buscados.size(); i++) {
								if (mcu.equals(buscados.get(i).getId()
										.getLimcu())) {
									valorMcu = valorMcu
											+ buscados.get(i).getLipqoh();
								} else {
									F41021PK pk = new F41021PK();
									F41021 f41021 = new F41021();
									pk.setLiitm(buscados.get(i).getId()
											.getLiitm());
									pk.setLilotn("");
									pk.setLimcu(mcu);
									pk.setLilocn("TOTAL");
									f41021.setId(pk);
									f41021.setLiupmj(buscados.get(i)
											.getLiupmj());
									f41021.setLipqoh(valorMcu);
									valorTotal = valorTotal + valorMcu;
									lista.add(f41021);
									valorMcu = 0;
									mcu = buscados.get(i).getId().getLimcu();
									i--;
								}
							}
						}
						F41021PK pk = new F41021PK();
						F41021 f41021 = new F41021();
						pk.setLiitm(buscados.get(buscados.size() - 1).getId()
								.getLiitm());
						pk.setLilotn("");
						pk.setLimcu(mcu);
						pk.setLilocn("TOTAL");
						f41021.setId(pk);
						f41021.setLiupmj(buscados.get(buscados.size() - 1)
								.getLiupmj());
						f41021.setLipqoh(valorMcu);
						valorTotal = valorTotal + valorMcu;
						lista.add(f41021);
						pk = new F41021PK();
						f41021 = new F41021();
						pk.setLiitm(buscados.get(buscados.size() - 1).getId()
								.getLiitm());
						pk.setLilotn("");
						pk.setLimcu("");
						pk.setLilocn("TOTAL General");
						f41021.setId(pk);
						f41021.setLiupmj(buscados.get(buscados.size() - 1)
								.getLiupmj());
						f41021.setLipqoh(valorTotal);
						lista.add(f41021);

					} else
						Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
					catalogo.actualizarLista(lista);
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
		botoneraDisponibilidad.appendChild(botonera);
	}

	protected boolean validar() {
		if (txtItem.getText().compareTo("") == 0) {
			Mensaje.mensajeAlerta(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	private void mostrarCatalogo() {

		final List<F41021> listObjetos = lista;
		catalogo = new CatalogoGenerico<F41021>(catalogo, "F41021",
				listObjetos, false, false, false, "Ubicacion",
				"Sucursal/Almacen", "Existencia Fisica", "Disponible",
				"Fecha Ultima Recepcion") {

			@Override
			protected List<F41021> buscar(List<String> valores) {

				List<F41021> listObjetos2 = new ArrayList<F41021>();

				for (F41021 objeto : listObjetos) {
					if (objeto.getId().getLilocn().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& objeto.getId().getLimcu().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& String.valueOf(objeto.getLipqoh().longValue())
									.toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& String.valueOf(objeto.getLipqoh().longValue())
									.toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& formatoFecha
									.format(transformarJulianaAGregoria(objeto
											.getLiupmj())).toLowerCase()
									.contains(valores.get(4).toLowerCase())) {
						listObjetos2.add(objeto);
					}
				}
				return listObjetos2;
			}

			@Override
			protected String[] crearRegistros(F41021 objeto) {
				String[] registros = new String[5];
				registros[0] = objeto.getId().getLilocn();
				registros[1] = objeto.getId().getLimcu();
				registros[2] = String.valueOf(objeto.getLipqoh().longValue());
				registros[3] = String.valueOf(objeto.getLipqoh().longValue());
				registros[4] = formatoFecha
						.format(transformarJulianaAGregoria(objeto.getLiupmj()));
				;
				return registros;
			}
		};
		Listbox lista = (Listbox) catalogo.getChildren().get(3);
		lista.setMold("default");
		lista.setPagingPosition("both");
		lista.setRows(10);
		catalogo.setParent(catalogoDisponibilidad);
	}

	@Listen("onClick = #btnBuscarPlanta")
	public void mostrarCatalogoF0006() {
		List<F0006> unidades = servicioF0006.buscarTodosOrdenados();
		catalogoF0006 = new CatalogoF0006(divCatalogoF0006, "Catalogo de Sucursales (F0006)",
				unidades, true, "Unidad Negocio", "Descripcion", "Nivel det",
				"Cta", "Tipo UN", "LM Auxiliar Inactivo", "Mto Cons", "CAT 01",
				"CAT 02", "CAT 03", "CAT 04", "CAT 05", "CAT 06");
		catalogoF0006.setParent(divCatalogoF0006);
		Listbox list = (Listbox) catalogoF0006.getChildren().get(1);
		list.setEmptyMessage("No existen registros");
		catalogoF0006.doModal();
	}

	@Listen("onChange = #txtPlanta; onOK = #txtPlanta ")
	public void buscarNombreSucursal() {
		F0006 f06 = new F0006();
		f06 = servicioF0006.buscar(txtPlanta.getValue());
		if (f06 != null) {
			mcu = f06.getMcmcu();
			txtPlanta.setValue(String.valueOf(f06.getMcmcu()));
			lblPlanta.setValue(f06.getMcdl01());
		} else {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			mcu = "";
			txtPlanta.setValue("");
			txtPlanta.setFocus(true);
			lblPlanta.setValue("");
		}

	}

	@Listen("onSeleccion = #divCatalogoF0006")
	public void seleccionF0006() {
		F0006 f0006 = catalogoF0006.objetoSeleccionadoDelCatalogo();
		txtPlanta.setValue(String.valueOf(f0006.getMcmcu()));
		lblPlanta.setValue(f0006.getMcdc());
		mcu = f0006.getMcmcu();
		catalogoF0006.setParent(null);
	}

	@Listen("onClick = #btnBuscarItem")
	public void mostrarCatalogoF4101() {
		List<F4101> listF41011 = new ArrayList<F4101>();
		if (!mcu.equals(""))
			listF41011 = servicioF4101.buscarTodosOrdenadosPorMcu(mcu);
		else
			listF41011 = servicioF4101.buscarTodosOrdenados();
		final List<F4101> listF4101 = listF41011;
		catalogoF4101 = new CatalogoF4101(divCatalogoF4101,
				"Catalogo de Articulos (F4101)", listF4101, true, "Codigo",
				"Descripcion");
		catalogoF4101.setParent(divCatalogoF4101);
		Listbox list = (Listbox) catalogoF4101.getChildren().get(1);
		if (!mcu.equals(""))
			list.setEmptyMessage("No existen Items asociados a la Sucursal seleccionada");
		else
			list.setEmptyMessage("No existen registros");
		catalogoF4101.doModal();
	}

	@Listen("onChange = #txtItem; onOK = #txtItem")
	public void buscarNombreItem() {
		if (servicioF4101.buscar(txtItem.getValue()) != null) {
			F4101 f4101 = servicioF4101.buscar(txtItem.getValue());
			Double doble = f4101.getImitm();
			txtItem.setValue(doble.longValue());
			lblItem.setValue(f4101.getImdsc1());
			txtUM.setValue(f4101.getImuom1());
		} else {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			txtItem.setValue(null);
			txtItem.setFocus(true);
			lblItem.setValue("");
		}
	}

	@Listen("onSeleccion = #divCatalogoF4101")
	public void seleccionF4101() {
		F4101 f4101 = catalogoF4101.objetoSeleccionadoDelCatalogo();
		Double doble = f4101.getImitm();
		txtItem.setValue(doble.longValue());
		lblItem.setValue(f4101.getImdsc1());
		txtUM.setValue(f4101.getImuom1());
		catalogoF4101.setParent(null);
	}

}
