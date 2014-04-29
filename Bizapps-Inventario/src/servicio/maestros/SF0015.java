package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF0015DAO;
import modelo.maestros.F0015;
import modelo.pk.F0015PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("SF0015")
public class SF0015 {

	@Autowired
	private IF0015DAO f0015DAO;


	public void guardar(F0015 foo15) {
		f0015DAO.save(foo15);
	}
	
	public void eliminarVarios(List<F0015> eliminar) {
		f0015DAO.delete(eliminar);
	}

	public void eliminarUno(F0015PK clave) {
		f0015DAO.delete(clave);
	}

	public List<F0015> buscarCRCD(String value) {
		return f0015DAO.findByIdCxcrcd(value);
	}
	
	
}