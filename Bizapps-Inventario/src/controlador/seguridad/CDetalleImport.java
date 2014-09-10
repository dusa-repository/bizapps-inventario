package controlador.seguridad;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.maestros.F0006;
import modelo.maestros.F0010;
import modelo.maestros.F4100;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import componentes.Catalogo;
import componentes.Mensaje;

import controlador.maestros.CGenerico;

public class CDetalleImport extends CGenerico {

	private static final long serialVersionUID = 7255740920348645706L;
	@Wire
	private Window wdwDetalle;
	@Wire
	private Div divCatalogoF0006;
	@Wire
	private Div divCatalogoF4100;
	@Wire
	private Div divCatalogoF0010;
	@Wire
	private Textbox txtEmpresa;
	@Wire
	private Label lblEmpresa;
	@Wire
	private Textbox txtPlanta;
	@Wire
	private Label lblPlanta;
	@Wire
	private Textbox txtUbicacion;
	@Wire
	private Label lblUbicacion;
	private Label lblEmpresaDetalle;
	private Label lblPlantaDetalle;
	private Label lblUbicacionDetalle;
	private String empresa = "";
	private String almacen = "";
	private String ubicacion = "";
	Catalogo<F0006> catalogoF0006;
	Catalogo<F4100> catalogoF4100;
	Catalogo<F0010> catalogoF0010;
	private String mcu = "";
	private String ccoA = "";
	private CImportar controlador = new CImportar();

	@Override
	public void inicializar() throws IOException {
		HashMap<String, Object> map = (HashMap<String, Object>) Sessions
				.getCurrent().getAttribute("detalle");
		if (map != null) {
			if (!map.get("empresa").equals("")) {
				empresa = (String) map.get("empresa");
				F0010 ob = servicioF0010.buscar(empresa);
				txtEmpresa.setValue(empresa);
				ccoA = empresa;
				lblEmpresa.setValue(ob.getCcname());
			}
			if (!map.get("almacen").equals("")) {
				almacen = (String) map.get("almacen");
				F0006 ob = servicioF0006.buscar(almacen);
				txtPlanta.setValue(almacen);
				mcu = almacen;
				lblPlanta.setValue(ob.getMcdl01());
			}
			if (!map.get("ubicacion").equals("")) {
				ubicacion = (String) map.get("ubicacion");
				txtUbicacion.setValue(ubicacion);
			}
			lblEmpresaDetalle = (Label) map.get("empresaEtiqueta");
			lblPlantaDetalle = (Label) map.get("almacenEtiqueta");
			lblUbicacionDetalle = (Label) map.get("ubicacionEtiqueta");
			map.clear();
			map = null;
		}
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
		catalogoF4100.setParent(divCatalogoF4100);
		catalogoF4100.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF4100")
	public void seleccionarCatalogo() {
		F4100 f4100 = catalogoF4100.objetoSeleccionadoDelCatalogo();
		setearUbicacion(f4100, txtUbicacion, lblUbicacion);
		catalogoF4100.setParent(null);
	}

	private void setearUbicacion(F4100 f4100, Textbox txtUbicacion22,
			Label lblUbicacion22) {
		txtUbicacion22.setValue(f4100.getId().getLmlocn());
		lblUbicacion22.setValue(f4100.getId().getLmlocn());

	}

	@Listen("onClick = #btnBuscarPlanta")
	public void mostrarCatalogoF0006() {
		List<F0006> lista = new ArrayList<F0006>();
		lista = servicioF0006.buscarPorMco(ccoA);
		final List<F0006> unidades = lista;
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
			mcu = f06.getMcmcu();
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

	@Listen("onClick = #btnBuscarEmpresa")
	public void mostrarCatalogoF0010() {
		final List<F0010> lista = servicioF0010.buscarTodosOrdenados();
		catalogoF0010 = new Catalogo<F0010>(divCatalogoF0010, "F0010", lista,
				true, false, false, "Codigo", "Nombre", "Nº Periodo", "Patron",
				"Inicio año Fiscal", "Periodo LM", "Inicio año C/P",
				"Periodo C/P", "Inicio año C/C", "Periodo C/C") {

			@Override
			protected List<F0010> buscar(List<String> valores) {

				List<F0010> lista2 = new ArrayList<F0010>();

				for (F0010 f0010 : lista) {
					String ccdot = "";
					if (f0010.getCcdot1() != null)
						ccdot = f0010.getCcdot1();
					if (f0010.getCcco().toLowerCase()
							.startsWith(valores.get(0))
							&& f0010.getCcname().toLowerCase()
									.startsWith(valores.get(1))
							&& String.valueOf(f0010.getCcpnc()).toLowerCase()
									.startsWith(valores.get(2))
							&& ccdot.toLowerCase().startsWith(valores.get(3))
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
		catalogoF0010.setParent(divCatalogoF0010);
		catalogoF0010.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0010")
	public void seleccionF0010() {
		F0010 f0010 = catalogoF0010.objetoSeleccionadoDelCatalogo();
		setteaEmpresa(f0010, txtEmpresa, lblEmpresa);
		ccoA = f0010.getCcco();
		catalogoF0010.setParent(null);
	}

	@Listen("onChange = #txtEmpresa")
	public void buscarNombreEmpresa() {
		F0010 f06 = new F0010();
		f06 = servicioF0010.buscar(txtEmpresa.getValue());
		if (f06 != null) {
			setteaEmpresa(f06, txtEmpresa, lblEmpresa);
			ccoA = f06.getCcco();
		} else {
			msj.mensajeAlerta(Mensaje.noHayRegistros);
			txtEmpresa.setValue("");
			txtEmpresa.setFocus(true);
			lblEmpresa.setValue("");
		}
	}

	private void setteaEmpresa(F0010 f0010, Textbox txtEmpresa12,
			Label lblEmpresa12) {
		txtEmpresa12.setValue(f0010.getCcco());
		lblEmpresa12.setValue(f0010.getCcname());
	}

	@Listen("onClick = #btnSalir")
	public void salir() {
		wdwDetalle.onClose();
	}

	@Listen("onClick = #btnGuardar")
	public void guardar() {
		if (validar()) {
			empresa = txtEmpresa.getValue();
			almacen = txtPlanta.getValue();
			ubicacion = txtUbicacion.getValue();
			controlador.actualizar(empresa, almacen, ubicacion,
					lblEmpresaDetalle, lblPlantaDetalle, lblUbicacionDetalle);
			salir();
		} else
			msj.mensajeError(Mensaje.camposVacios);
	}

	private boolean validar() {
		if (txtEmpresa.getText().compareTo("") != 0
				|| txtPlanta.getText().compareTo("") != 0
				|| txtUbicacion.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

}
