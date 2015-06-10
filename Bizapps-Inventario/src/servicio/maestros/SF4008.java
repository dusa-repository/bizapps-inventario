package servicio.maestros;

import interfacedao.maestros.IF4008DAO;

import java.util.List;

import modelo.maestros.F4008;
import modelo.pk.F4008PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4008")
public class SF4008 {

	@Autowired
	private IF4008DAO f4008DAO;

	public List<F4008> buscarTodosOrdenados() {
		return f4008DAO.findAllOrderById();
	}

	public void guardar(F4008 f408) {
		f4008DAO.save(f408);
		
	}
	
	public List<F4008> buscarPorTata1(double tata1) {
		return f4008DAO.findByTata1(tata1);
	}
	
	public void eliminarUno(F4008PK clave) {
		f4008DAO.delete(clave);
	}

	public void eliminarVarios(List<F4008> eliminarLista) {
		f4008DAO.delete(eliminarLista);
	}
	
	public List<F4008> buscarPorTaitm(double taitm) {
		return f4008DAO.findByIdTaitm(taitm);
	}
	


	/*
	public List<F4008> buscarPorTatxa1(String txa1) {
		return f4008DAO.findByIdTatxa1(txa1);
	}
	*/
}
