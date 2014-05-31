package controlador.maestros;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import modelo.seguridad.Arbol;
import modelo.seguridad.Grupo;
import modelo.seguridad.Usuario;

import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Image;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import arbol.CArbol;

import componentes.Botonera;
import componentes.Catalogo;
import componentes.Validador;

public class CUsuario extends CGenerico {

	private static final long serialVersionUID = 7879830599305337459L;
	@Wire
	private Button btnSiguientePestanna;
	@Wire
	private Button btnAnteriorPestanna;
	@Wire
	private Tab tabBasicos;
	@Wire
	private Tab tabUsuarios;
	@Wire
	private Div divUsuario;
	@Wire
	private Div botoneraUsuario;
	@Wire
	private Div catalogoUsuario;
	@Wire
	private Textbox txtNombreUsuario;
	@Wire
	private Textbox txtCedulaUsuario;
	@Wire
	private Textbox txtApellidoUsuario;
	@Wire
	private Textbox txtNombre2Usuario;
	@Wire
	private Textbox txtApellido2Usuario;
	@Wire
	private Textbox txtFichaUsuario;
	@Wire
	private Textbox txtTelefonoUsuario;
	@Wire
	private Textbox txtCorreoUsuario;
	@Wire
	private Textbox txtDireccionUsuario;
	@Wire
	private Textbox txtLicenciaCUsuario;
	@Wire
	private Textbox txtLicenciaMUsuario;
	@Wire
	private Textbox txtLicenciaIUsuario;
	@Wire
	private Textbox txtLoginUsuario;
	@Wire
	private Textbox txtPasswordUsuario;
	@Wire
	private Textbox txtPassword2Usuario;
	@Wire
	private Spinner spnTiempoUsuario;
	@Wire
	private Spinner spnCitasUsuario;
	@Wire
	private Combobox cmbEspecialidad;
	@Wire
	private Combobox cmbUnidad;
	@Wire
	private Button btnBuscarUsuario;
	@Wire
	private Listbox ltbGruposDisponibles;
	@Wire
	private Listbox ltbGruposAgregados;
	@Wire
	private Radiogroup rdbSexoUsuario;
	@Wire
	private Radio rdoSexoFUsuario;
	@Wire
	private Radio rdoSexoMUsuario;
	@Wire
	private Image imagen;
	@Wire
	private Fileupload fudImagenUsuario;
	@Wire
	private Media media;
	Botonera botonera;
	private CArbol cArbol = new CArbol();
	long id = 0;
	Catalogo<Usuario> catalogo;
	List<Grupo> gruposDisponibles = new ArrayList<Grupo>();
	List<Grupo> gruposOcupados = new ArrayList<Grupo>();
	URL url = getClass().getResource("usuario.png");

	@Override
	public void inicializar() throws IOException {

		llenarListas(null);

		try {
			imagen.setContent(new AImage(url));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		botonera = new Botonera (){
			@Override
			public void salir() {
				cerrarVentana(divUsuario, "Usuario");
			}

			@Override
			public void limpiar() {
				ltbGruposAgregados.getItems().clear();
				ltbGruposDisponibles.getItems().clear();
				txtApellidoUsuario.setValue("");
				txtApellido2Usuario.setValue("");
				txtCedulaUsuario.setValue("");
				txtCorreoUsuario.setValue("");
				txtDireccionUsuario.setValue("");
				txtLoginUsuario.setValue("");
				txtPasswordUsuario.setValue("");
				txtPassword2Usuario.setValue("");
				txtNombreUsuario.setValue("");
				txtNombre2Usuario.setValue("");
				txtTelefonoUsuario.setValue("");
				rdoSexoFUsuario.setChecked(false);
				rdoSexoMUsuario.setChecked(false);
				try {
					imagen.setContent(new AImage(url));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				id = 0;
				llenarListas(null);
			}

			@Override
			public void guardar() {
				if (validar()) {
					Set<Grupo> gruposUsuario = new HashSet<Grupo>();
					for (int i = 0; i < ltbGruposAgregados.getItemCount(); i++) {
						Grupo grupo = ltbGruposAgregados.getItems().get(i)
								.getValue();
						gruposUsuario.add(grupo);
					}
					String cedula = txtCedulaUsuario.getValue();
					String correo = txtCorreoUsuario.getValue();
					String direccion = txtDireccionUsuario.getValue();
					String login = txtLoginUsuario.getValue();
					String password = txtPasswordUsuario.getValue();
					String nombre = txtNombreUsuario.getValue();
					String apellido = txtApellidoUsuario.getValue();
					String nombre2 = txtNombre2Usuario.getValue();
					String apellido2 = txtApellido2Usuario.getValue();
					String telefono = txtTelefonoUsuario.getValue();
					String sexo = "";
					if (rdoSexoFUsuario.isChecked())
						sexo = "F";
					else
						sexo = "M";
					byte[] imagenUsuario = null;
					if (media instanceof org.zkoss.image.Image) {
						imagenUsuario = imagen.getContent().getByteData();

					} else {
						try {
							imagen.setContent(new AImage(url));
						} catch (IOException e) {
							e.printStackTrace();
						}
						imagenUsuario = imagen.getContent().getByteData();
					}
							
					Usuario usuario = new Usuario (cedula, correo, login, password, imagenUsuario, true, 
							fechaHora, gruposUsuario, nombre, apellido, nombre2, apellido2, sexo, telefono, direccion);

					servicioUsuario.guardar(usuario);
					limpiar();
					Messagebox.show("Registro Guardado Exitosamente",
							"Informacion", Messagebox.OK,
							Messagebox.INFORMATION);
				}
			}

			@Override
			public void eliminar() {
				if (id != 0) {
					Messagebox.show("¿Esta Seguro de Eliminar el Usuario?",
							"Alerta", Messagebox.OK | Messagebox.CANCEL,
							Messagebox.QUESTION,
							new org.zkoss.zk.ui.event.EventListener<Event>() {
								public void onEvent(Event evt)
										throws InterruptedException {
									if (evt.getName().equals("onOK")) {
										Usuario usuario = servicioUsuario
												.buscarUsuarioPorId(id);
										servicioUsuario.eliminar(usuario);
										limpiar();
										Messagebox
												.show("Registro Eliminado Exitosamente",
														"Informacion",
														Messagebox.OK,
														Messagebox.INFORMATION);

									}
								}
							});
				} else
					Messagebox.show("No ha Seleccionado Ningun Registro",
							"Alerta", Messagebox.OK, Messagebox.EXCLAMATION);

			}

			@Override
			public void seleccionar() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void buscar() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void annadir() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void ayuda() {
				// TODO Auto-generated method stub
				
			}
		};
		botonera.getChildren().get(0).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botoneraUsuario.appendChild(botonera);
	}

	/* Validaciones de pantalla para poder realizar el guardar */
	public boolean validar() {
		if (txtApellidoUsuario.getText().compareTo("") == 0
				|| txtApellido2Usuario.getText().compareTo("") == 0
				|| txtNombre2Usuario.getText().compareTo("") == 0
				|| txtCedulaUsuario.getText().compareTo("") == 0
				|| txtCorreoUsuario.getText().compareTo("") == 0
				|| txtDireccionUsuario.getText().compareTo("") == 0
				|| txtLoginUsuario.getText().compareTo("") == 0
				|| txtNombreUsuario.getText().compareTo("") == 0
				|| txtPassword2Usuario.getText().compareTo("") == 0
				|| txtPasswordUsuario.getText().compareTo("") == 0
				|| txtTelefonoUsuario.getText().compareTo("") == 0
				|| (!rdoSexoFUsuario.isChecked() && !rdoSexoMUsuario
						.isChecked())) {
			Messagebox.show("Debe Llenar Todos los Campos", "Informacion",
					Messagebox.OK, Messagebox.INFORMATION);
			return false;
		} else {
			if (!Validador.validarCorreo(txtCorreoUsuario.getValue())) {
				Messagebox.show("Correo Invalido", "Informacion",
						Messagebox.OK, Messagebox.INFORMATION);
				return false;
			} else {
				if (!Validador.validarTelefono(txtTelefonoUsuario.getValue())) {
					Messagebox.show("Telefono Invalido", "Informacion",
							Messagebox.OK, Messagebox.INFORMATION);
					return false;
				} else {
					if (!Validador.validarNumero(txtCedulaUsuario.getValue())) {
						Messagebox.show("Cedula Invalida", "Informacion",
								Messagebox.OK, Messagebox.INFORMATION);
						return false;
						} else {
							if (!txtPasswordUsuario.getValue().equals(
									txtPassword2Usuario.getValue())) {
								Messagebox.show("No coinciden las contraseñas",
										"Informacion", Messagebox.OK,
										Messagebox.INFORMATION);
								return false;
							} else
								return true;
						}
					}
				}

			}
		}
	

	/* Valida que los passwords sean iguales */
	@Listen("onChange = #txtPassword2Usuario")
	public void validarPassword() {
		if (!txtPasswordUsuario.getValue().equals(
				txtPassword2Usuario.getValue())) {
			Messagebox.show("No coinciden las contraseñas", "Informacion",
					Messagebox.OK, Messagebox.INFORMATION);
		}
	}

	/* Valida el numero telefonico */
	@Listen("onChange = #txtTelefonoUsuario")
	public void validarTelefono() {
		if (!Validador.validarTelefono(txtTelefonoUsuario.getValue())) {
			Messagebox.show("Telefono Invalido", "Informacion", Messagebox.OK,
					Messagebox.INFORMATION);
		}
	}

	/* Valida el correo electronico */
	@Listen("onChange = #txtCorreoUsuario")
	public void validarCorreo() {
		if (!Validador.validarCorreo(txtCorreoUsuario.getValue())) {
			Messagebox.show("Correo Invalido", "Informacion", Messagebox.OK,
					Messagebox.INFORMATION);
		}
	}

	/* Valida la cedula */
	@Listen("onChange = #txtCedulaUsuario")
	public void validarCedula() {
		if (!Validador.validarNumero(txtCedulaUsuario.getValue())) {
			Messagebox.show("Cedula Invalida", "Informacion", Messagebox.OK,
					Messagebox.INFORMATION);
		}
	}

	/* LLena las listas dado un usario */
	public void llenarListas(Usuario usuario) {
		gruposDisponibles = servicioGrupo.buscarTodos();
		if (usuario == null) {
			ltbGruposDisponibles.setModel(new ListModelList<Grupo>(
					gruposDisponibles));
		} else {
			gruposOcupados = servicioGrupo.buscarGruposDelUsuario(usuario);
			ltbGruposAgregados
					.setModel(new ListModelList<Grupo>(gruposOcupados));
			if (!gruposOcupados.isEmpty()) {
				List<Long> ids = new ArrayList<Long>();
				for (int i = 0; i < gruposOcupados.size(); i++) {
					long id = gruposOcupados.get(i).getIdGrupo();
					ids.add(id);
				}
				gruposDisponibles = servicioGrupo.buscarGruposDisponibles(ids);
				ltbGruposDisponibles.setModel(new ListModelList<Grupo>(
						gruposDisponibles));
			}
		}
		ltbGruposAgregados.setMultiple(false);
		ltbGruposAgregados.setCheckmark(false);
		ltbGruposAgregados.setMultiple(true);
		ltbGruposAgregados.setCheckmark(true);

		ltbGruposDisponibles.setMultiple(false);
		ltbGruposDisponibles.setCheckmark(false);
		ltbGruposDisponibles.setMultiple(true);
		ltbGruposDisponibles.setCheckmark(true);
	}

	/* Permite subir una imagen a la vista */
	@Listen("onUpload = #fudImagenUsuario")
	public void processMedia(UploadEvent event) {
		media = event.getMedia();
		imagen.setContent((org.zkoss.image.Image) media);

	}

	/*
	 * Permite mover uno o varios elementos seleccionados desde la lista de la
	 * izquierda a la lista de la derecha
	 */
	@Listen("onClick = #pasar1")
	public void moverDerecha() {
		// gruposDisponibles = servicioGrupo.buscarTodos();
		List<Listitem> listitemEliminar = new ArrayList<Listitem>();
		List<Listitem> listItem = ltbGruposDisponibles.getItems();
		if (listItem.size() != 0) {
			for (int i = 0; i < listItem.size(); i++) {
				if (listItem.get(i).isSelected()) {
					Grupo grupo = listItem.get(i).getValue();
					gruposDisponibles.remove(grupo);
					gruposOcupados.add(grupo);
					ltbGruposAgregados.setModel(new ListModelList<Grupo>(
							gruposOcupados));
					listitemEliminar.add(listItem.get(i));
				}
			}
		}
		for (int i = 0; i < listitemEliminar.size(); i++) {
			ltbGruposDisponibles.removeItemAt(listitemEliminar.get(i)
					.getIndex());
		}
		ltbGruposAgregados.setMultiple(false);
		ltbGruposAgregados.setCheckmark(false);
		ltbGruposAgregados.setMultiple(true);
		ltbGruposAgregados.setCheckmark(true);
	}

	/*
	 * Permite mover uno o varios elementos seleccionados desde la lista de la
	 * derecha a la lista de la izquierda
	 */
	@Listen("onClick = #pasar2")
	public void moverIzquierda() {
		List<Listitem> listitemEliminar = new ArrayList<Listitem>();
		List<Listitem> listItem2 = ltbGruposAgregados.getItems();
		if (listItem2.size() != 0) {
			for (int i = 0; i < listItem2.size(); i++) {
				if (listItem2.get(i).isSelected()) {
					Grupo grupo = listItem2.get(i).getValue();
					gruposOcupados.remove(grupo);
					gruposDisponibles.add(grupo);
					ltbGruposDisponibles.setModel(new ListModelList<Grupo>(
							gruposDisponibles));
					listitemEliminar.add(listItem2.get(i));
				}
			}
		}
		for (int i = 0; i < listitemEliminar.size(); i++) {
			ltbGruposAgregados.removeItemAt(listitemEliminar.get(i).getIndex());
		}
		ltbGruposDisponibles.setMultiple(false);
		ltbGruposDisponibles.setCheckmark(false);
		ltbGruposDisponibles.setMultiple(true);
		ltbGruposDisponibles.setCheckmark(true);
	}

	/* Busca si existe un usuario con la misma cedula nombre escrita */
	@Listen("onChange = #txtCedulaUsuario")
	public void buscarPorCedula() {
		Usuario usuario = servicioUsuario.buscarPorCedula(txtCedulaUsuario
				.getValue());
		if (usuario != null)
			llenarCampos(usuario);
	}

	/*
	 * Selecciona un usuario del catalogo y llena los campos con la informacion
	 */
	@Listen("onSeleccion = #catalogoUsuario")
	public void seleccion() {
		Usuario usuario = catalogo.objetoSeleccionadoDelCatalogo();
		llenarCampos(usuario);
		catalogo.setParent(null);
	}

	/* LLena los campos del formulario dado un usuario */
	public void llenarCampos(Usuario usuario) {
		txtCedulaUsuario.setValue(usuario.getCedula());
		txtCorreoUsuario.setValue(usuario.getEmail());
		txtDireccionUsuario.setValue(usuario.getDireccion());
		txtLoginUsuario.setValue(usuario.getLogin());
		txtPasswordUsuario.setValue(usuario.getPassword());
		txtPassword2Usuario.setValue(usuario.getPassword());
		txtNombreUsuario.setValue(usuario.getPrimerNombre());
		txtNombre2Usuario.setValue(usuario.getSegundoNombre());
		txtApellidoUsuario.setValue(usuario.getPrimerApellido());
		txtApellido2Usuario.setValue(usuario.getSegundoApellido());
		txtTelefonoUsuario.setValue(usuario.getTelefono());
		String sexo = usuario.getSexo();
		if (sexo.equals("F"))
			rdoSexoFUsuario.setChecked(true);
		else
			rdoSexoMUsuario.setChecked(true);
		BufferedImage imag;
		if (usuario.getImagen() != null) {
			try {
				imag = ImageIO.read(new ByteArrayInputStream(usuario
						.getImagen()));
				imagen.setContent(imag);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		txtCedulaUsuario.setDisabled(true);
		id = Long.valueOf(usuario.getCedula());
		llenarListas(usuario);
	}

	/* Abre la pestanna de datos de usuario */
	@Listen("onClick = #btnSiguientePestanna")
	public void siguientePestanna() {
		tabUsuarios.setSelected(true);
	}

	/* Abre la pestanna de datos basicos */
	@Listen("onClick = #btnAnteriorPestanna")
	public void anteriorPestanna() {
		tabBasicos.setSelected(true);
	}


	/* Abre la vista de Grupos */
	@Listen("onClick = #btnAbrirGrupo")
	public void abrirGrupo() {
		Arbol arbolItem = servicioArbol.buscarPorNombreArbol("Grupo");
		cArbol.abrirVentanas(arbolItem);
	}
}
