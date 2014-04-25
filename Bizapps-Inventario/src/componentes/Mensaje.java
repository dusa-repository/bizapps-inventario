package componentes;

import org.zkoss.zul.Messagebox;

public class Mensaje {
	public static String claveSYNoEsta = "El Codigo de Producto no Existe.";
	public static String claveRTNoEsta = "El Codigo Definido por el Usuario no Existe.";
	public static String guardado = "Registro Guardado Exitosamente.";
	public static String claveUsada = "La Clave ha sido Usada por Otro Registro.";
	public static String camposVacios = "Debe Llenar Todos lo Campos.";
	public static String noSeleccionoItem = "No ha seleccionado ningun Item";
	public static String noHayRegistros = "No se Encontraron Registros";
	public static String editarSoloUno = "Solo puede Editar un Item a la vez, "
	+ "Seleccione un (1) solo Item y Repita la Operacion";
	public static String deseaEliminar = "¿Desea Eliminar el Registro?";
	public static String eliminado = "Registro Eliminado Exitosamente";
	public static String estaEditando = "No ha culminado la Edicion, ¿Desea Continuar Editando?";
	public static String noSeleccionoRegistro = "No ha seleccionado ningun Registro";
	
	
	public void mensajeInformacion(String msj) {
	      Messagebox.show(msj, "Informacion",
					Messagebox.OK, Messagebox.EXCLAMATION);
		}

		public void mensajeAlerta(String msj) {
	      Messagebox.show(msj, "Alerta",
					Messagebox.OK, Messagebox.ERROR);
		}
}