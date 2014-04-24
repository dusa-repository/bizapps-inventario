package componentes;

import org.zkoss.zul.Messagebox;

public class Mensaje {
	public static String guardado = "Registro Guardado Exitosamente.";
	public static String claveUsada = "Ya existe esta Clave.";
	
	public void registroGuardado(String msj) {
	      Messagebox.show(msj, "Informacion",
					Messagebox.OK, Messagebox.EXCLAMATION);
		}

		public void claveUsada(String msj) {
	      Messagebox.show(msj, "Alerta",
					Messagebox.OK, Messagebox.ERROR);
		}
}