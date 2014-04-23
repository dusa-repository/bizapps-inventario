package componentes;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.event.KeyEvent;
import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Auxheader;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public abstract class Catalogo<Clase> extends Window {

	private static final long serialVersionUID = 1L;
	Listbox lsbCatalogo;

	public Catalogo(final Component cGenerico, String titulo,
			List<Clase> lista, String... campos) {
		super("", "2", false);
		this.setId("cmpCatalogo" + titulo);
		this.setStyle("background-header:#FF7925; background: #f4f2f2");
		setWidth("98%");
		crearLista(lista, campos);
		lsbCatalogo.addEventListener(Events.ON_SELECT,
				new EventListener<Event>() {

					@Override
					public void onEvent(Event arg0) throws Exception {
						Events.postEvent(cGenerico, new Event("onSeleccion"));
					}
				});
	}

	public void crearLista(List<Clase> lista, String[] campos) {
		Hbox hbxBusqueda = new Hbox();
		final Separator separador1 = new Separator();
		final Separator separador2 = new Separator();
		lsbCatalogo = new Listbox();
		lsbCatalogo.setMold("paging");
		lsbCatalogo.setPagingPosition("top");
		lsbCatalogo.setPageSize(10);
		final Auxhead cabecera = new Auxhead();
		Listhead lhdEncabezado = new Listhead();
		for (int i = 0; i < campos.length; i++) {
			final Textbox cajaTexto = new Textbox();
			cajaTexto.setContext(campos[i]);
			cajaTexto.addEventListener(Events.ON_OK,
					new EventListener<KeyEvent>() {
						@Override
						public void onEvent(KeyEvent e) throws Exception {
							List<String> valores = new ArrayList<>();
							for (int i = 0; i < cabecera.getChildren().size(); i++) {
								Auxheader cabeceraFila = (Auxheader) cabecera
										.getChildren().get(i);
								Textbox te = (Textbox) cabeceraFila
										.getChildren().get(0);
								valores.add(te.getValue());
							}
							;
							String valor = cajaTexto.getValue();
							List<Clase> listaNueva = buscar(valores);
							lsbCatalogo.setModel(new ListModelList<Clase>(
									listaNueva));
							lsbCatalogo.setMultiple(false);
							lsbCatalogo.setCheckmark(false);
							lsbCatalogo.setMultiple(true);
							lsbCatalogo.setCheckmark(true);
							cajaTexto.setValue(valor);
						}
					});
			cajaTexto.setPlaceholder("Filtrado");
			Auxheader cabeceraFila = new Auxheader();
			cabeceraFila.appendChild(cajaTexto);
			cabecera.appendChild(cabeceraFila);
			lhdEncabezado.appendChild(new Listheader(campos[i]));
		}
		lsbCatalogo.appendChild(cabecera);
		lsbCatalogo.appendChild(lhdEncabezado);
		cabecera.setVisible(true);
		lhdEncabezado.setVisible(true);
		lsbCatalogo.setModel(new ListModelList<Clase>(lista));
		lsbCatalogo.setItemRenderer(new ListitemRenderer<Clase>() {

			@Override
			public void render(Listitem fila, Clase objeto, int arg2)
					throws Exception {
				fila.setValue(objeto);
				String[] registros = crearRegistros(objeto);
				for (int i = 0; i < registros.length; i++) {
					Listcell celda = new Listcell(registros[i]);
					celda.setParent(fila);
				}
			}
		});
		lsbCatalogo.setMultiple(false);
		lsbCatalogo.setCheckmark(false);
		lsbCatalogo.setMultiple(true);
		lsbCatalogo.setCheckmark(true);

		this.appendChild(separador1);
		this.appendChild(hbxBusqueda);
		this.appendChild(separador2);
		this.appendChild(lsbCatalogo);
	}

	/**
	 * Metodo que permite llamar un servicio dependiendo el controlador que
	 * busque, es decir que haga un filtro dentro del catalogo, ayudando asi al
	 * usuario a encontrar el registro buscado con mayor facilidad
	 */
	protected abstract List<Clase> buscar(List<String> valores);

	/**
	 * Metodo que permite por cada controlador indicar cuales son los registros
	 * que quiere mostrar en su catalogo, formando una matriz de String
	 */
	protected abstract String[] crearRegistros(Clase objeto);

	public Clase objetoSeleccionadoDelCatalogo() {
		return lsbCatalogo.getSelectedItem().getValue();
	}

	public Listbox getListbox() {
		return lsbCatalogo;
	}
}