package servicio.maestros;

import java.util.List;
import interfacedao.maestros.IF4930DAO;

import modelo.maestros.F4930;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("SF4930")
public class SF4930 {

	@Autowired
	private IF4930DAO f4930DAO;

	public List<F4930> buscarTodosOrdenados() {
		return f4930DAO.findAll();
	}

	public void guardar(F4930 f4930) {
		f4930DAO.save(f4930);
	}

	public void eliminarVarios(List<F4930> eliminar) {
		f4930DAO.delete(eliminar);
	}

	public void eliminarUno(String clave) {
		f4930DAO.delete(clave);
	}
	
	public F4930 buscar(String clave){
		return f4930DAO.findByVmvehi(clave);

	}

	
}