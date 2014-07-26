package componentes;

import org.zkoss.zul.Messagebox;

public class Mensaje {
	public static String almacenNoExiste ="El Codigo del Almacen no Existe.";
	public static String claveSYNoEsta = "El Codigo de Producto no Existe.";
	public static String claveRTNoEsta = "El Codigo Definido por el Usuario no Existe.";
	public static String guardado = "Registro Guardado Exitosamente.";
	public static String claveUsada = "La Clave ha sido Usada por Otro Registro.";
	public static String camposVacios = "Debe Llenar Todos lo Campos Requeridos.";
	public static String noSeleccionoItem = "No ha seleccionado ningun Item";
	public static String noHayRegistros = "No se Encontraron Registros";
	public static String editarSoloUno = "Solo puede Editar un Item a la vez, "
	+ "Seleccione un (1) solo Item y Repita la Operacion";
	public static String deseaEliminar = "�Desea Eliminar el Registro?";
	public static String eliminado = "Registro Eliminado Exitosamente";
	public static String estaEditando = "No ha culminado la Edicion, �Desea Continuar Editando?";
	public static String noSeleccionoRegistro = "No ha seleccionado ningun Registro";
	public static String exportar = "�Desea exportar los datos de la lista a formato CSV?";
	public static String enUso = "La interfaz esta siendo usada";
	public static String articuloNoExiste = "El Codigo del Articulo no Existe.";
	public static String correoInvalido = "El Correo es Invalido.";
	public static String telefonoInvalido = "El n�mero de Tel�fono es invalido.";
	public static String contrasennasInvalidas = "Las contrase�as no coinciden.";
	public static String camposVaciosItem = "Debe Llenar Todos lo Campos Requeridos, de la seccion de Articulo (**).";
	public static String noPoseeExistencia= "No posee existencia suficiente para realizar la transaccion";
	
	public void mensajeInformacion(String msj) {
	      Messagebox.show(msj, "Informacion",
					Messagebox.OK, Messagebox.INFORMATION);
		}
	
	public void mensajeAlerta(String msj) {
	      Messagebox.show(msj, "Alerta",
					Messagebox.OK, Messagebox.EXCLAMATION);
		}

		public void mensajeError(String msj) {
	      Messagebox.show(msj, "Error",
					Messagebox.OK, Messagebox.ERROR);
		}
}