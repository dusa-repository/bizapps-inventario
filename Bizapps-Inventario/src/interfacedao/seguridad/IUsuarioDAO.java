package interfacedao.seguridad;

import java.util.List;

import modelo.maestros.F00021;
import modelo.seguridad.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String nombre);

	Usuario findByCedula(String value);

	Usuario findByCedulaAndEmail(String value, String value2);
	
}