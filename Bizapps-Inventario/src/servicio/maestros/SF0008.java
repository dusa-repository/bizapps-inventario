package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF0008DAO;
import modelo.maestros.F0004;
import modelo.maestros.F0008;
import modelo.pk.F0008PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("SF0008")
public class SF0008 {

	@Autowired
	private IF0008DAO f0008DAO;


	public void guardar(F0008 fooo8) {
		f0008DAO.save(fooo8);
	}
	
	public void eliminarVarios(List<F0008> eliminar) {
		f0008DAO.delete(eliminar);
	}

	public void eliminarUno(F0008PK clave) {
		f0008DAO.delete(clave);
	}

	public List<F0008> buscarDTPN(String value) {
		return f0008DAO.findByIdCddtpn(value);
	}
	
	public List<F0008> buscarTodosOrdenados() {
		return f0008DAO.findAllOrderByIdCddtpn();
	}
	
	
}