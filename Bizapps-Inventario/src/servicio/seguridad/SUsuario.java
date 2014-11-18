package servicio.seguridad;

import interfacedao.seguridad.IUsuarioDAO;

import java.util.List;

import modelo.maestros.F00021;
import modelo.seguridad.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("SUsuario")
public class SUsuario {

	@Autowired
	private IUsuarioDAO usuarioDAO;
	

	public List<Usuario> buscarTodos() {
		return usuarioDAO.findAll();
	}
	
	@Transactional
	public Usuario buscarUsuarioPorId(String codigo) {
		return usuarioDAO.findByCedula(codigo);
	}

	public void guardar(Usuario usuario) {
		usuarioDAO.save(usuario);
	}

	@Transactional
	public Usuario buscarUsuarioPorNombre(String nombre) {
		return usuarioDAO.findByLogin(nombre);
	}

	@Transactional
	public Usuario buscarPorCedula(String value) {
		return usuarioDAO.findByCedula(value);
	}

	public void eliminar(Usuario usuario) {
		usuarioDAO.delete(usuario);
	}

	public Usuario buscarPorCedulayCorreo(String value, String value2) {
		return usuarioDAO.findByCedulaAndEmail(value, value2);
	}
	public Usuario buscarPorLogin(String value) {
		return usuarioDAO.findByLogin(value);
	}

}