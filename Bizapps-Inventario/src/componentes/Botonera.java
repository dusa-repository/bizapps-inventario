package componentes;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Hbox;

public abstract class Botonera extends Hbox {

	public Botonera() {
		super();
		Button btnSeleccionar = new Button();
		Button btnBuscar = new Button();
		Button btnAnnadir = new Button();
		Button btnGuardar = new Button();
		Button btnEliminar = new Button();
		Button btnLimpiar = new Button();
		Button btnReporte = new Button();
		Button btnSalir = new Button();
		Button btnAyuda = new Button();

		this.appendChild(btnSeleccionar);
		this.appendChild(btnBuscar);
		this.appendChild(btnAnnadir);
		this.appendChild(btnGuardar);
		this.appendChild(btnEliminar);
		this.appendChild(btnLimpiar);
		this.appendChild(btnReporte);
		this.appendChild(btnSalir);
		this.appendChild(btnAyuda);

		btnSeleccionar.setSrc("/public/imagenes/botones/seleccionar.png");
		btnBuscar.setSrc("/public/imagenes/botones/buscar.png");
		btnAnnadir.setSrc("/public/imagenes/botones/annadir.png");
		btnGuardar.setSrc("/public/imagenes/botones/guardar.png");
		btnEliminar.setSrc("/public/imagenes/botones/eliminar.png");
		btnLimpiar.setSrc("/public/imagenes/botones/limpiar.png");
		btnReporte.setSrc("/public/imagenes/botones/reporte.png");
		btnSalir.setSrc("/public/imagenes/botones/salir.png");
		btnAyuda.setSrc("/public/imagenes/botones/ayuda.png");

		btnSeleccionar.setOrient("vertical");
		btnSeleccionar.setDir("reverse");
		btnBuscar.setOrient("vertical");
		btnBuscar.setDir("reverse");
		btnAnnadir.setOrient("vertical");
		btnAnnadir.setDir("reverse");
		btnGuardar.setOrient("vertical");
		btnGuardar.setDir("reverse");
		btnEliminar.setOrient("vertical");
		btnEliminar.setDir("reverse");
		btnLimpiar.setOrient("vertical");
		btnLimpiar.setDir("reverse");
		btnReporte.setOrient("vertical");
		btnReporte.setDir("reverse");
		btnSalir.setOrient("vertical");
		btnSalir.setDir("reverse");
		btnAyuda.setOrient("vertical");
		btnAyuda.setDir("reverse");
		
		btnAyuda.setStyle("font-size: 10px");
		btnEliminar.setStyle("font-size: 10px");
		btnAnnadir.setStyle("font-size: 10px");
		btnGuardar.setStyle("font-size: 10px");
		btnBuscar.setStyle("font-size: 10px");
		btnLimpiar.setStyle("font-size: 10px");
		btnSalir.setStyle("font-size: 10px");
		btnReporte.setStyle("font-size: 10px");
		btnSeleccionar.setStyle("font-size: 10px");
		
		btnSeleccionar.setLabel("Seleccionar");
		btnBuscar.setLabel("Buscar");
		btnAnnadir.setLabel("AÒadir");
		btnGuardar.setLabel("Guardar");
		btnEliminar.setLabel("Eliminar");
		btnLimpiar.setLabel("Limpiar");
		btnReporte.setLabel("Reporte");
		btnSalir.setLabel("Salir");
		btnAyuda.setLabel("Ayuda");

		btnSeleccionar.setTooltiptext("Seleccionar");
		btnBuscar.setTooltiptext("Buscar");
		btnAnnadir.setTooltiptext("AÒadir");
		btnGuardar.setTooltiptext("Guardar");
		btnEliminar.setTooltiptext("Eliminar");
		btnLimpiar.setTooltiptext("Limpiar");
		btnReporte.setTooltiptext("Reporte");
		btnSalir.setTooltiptext("Salir");
		btnAyuda.setTooltiptext("Ayuda");


		btnSeleccionar.addEventListener(Events.ON_CLICK,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						seleccionar();
					}
				});
		btnBuscar.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				buscar();
			}

		});
		btnAnnadir.addEventListener(Events.ON_CLICK,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						annadir();
					}

				});
		btnGuardar.addEventListener(Events.ON_CLICK,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						guardar();
					}

				});

		btnEliminar.addEventListener(Events.ON_CLICK,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						eliminar();
					}
				});
		btnLimpiar.addEventListener(Events.ON_CLICK,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						limpiar();
					}
				});
		btnReporte.addEventListener(Events.ON_CLICK,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						reporte();
					}
				});
		btnSalir.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				salir();
			}
		});
		btnAyuda.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				ayuda();
			}
		});
	}

	/**
	 * Metodo que guarda un registro nuevo si no a sido guardado con
	 * anterioridad, de ser as√≠ se modifica aquellos datos que el usuario
	 * cambie
	 */
	public abstract void seleccionar();

	public abstract void buscar();

	public abstract void annadir();

	public abstract void guardar();

	/**
	 * Metodo que limpia todos los campos para darle la libertad al usuario de
	 * a√±adir un nuevo registro o seleccionar uno ya existente
	 */
	public abstract void limpiar();

	public abstract void reporte();

	/**
	 * Metodo que permite cerrar el div que se genera al entrar a la vista
	 */
	public abstract void salir();

	/**
	 * Metodo que permite la eliminacion de un registro siempre y cuando no este
	 * asociado a otra entidad
	 */
	public abstract void eliminar();

	public abstract void ayuda();
}