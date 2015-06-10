package servicio.maestros;

import interfacedao.maestros.IF0008DAO;

import java.util.List;

import modelo.maestros.F0008;
import modelo.pk.F0008PK;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public F0008 buscar(String value, long value2) {
		F0008PK clave = new F0008PK();
		clave.setCddtpn(value);
		clave.setCddfyj(value2) ;
		return f0008DAO.findOne(clave);
	}
	
	
	
}