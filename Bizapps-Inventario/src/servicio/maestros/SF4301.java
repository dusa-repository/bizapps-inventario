package servicio.maestros;

import interfacedao.maestros.IF4301DAO;

import java.util.List;

import modelo.maestros.F0015;
import modelo.maestros.F4301;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4301")
public class SF4301 {

	@Autowired
	private IF4301DAO iF4301DAO;

	public void guardar(F4301 f4301) {
		iF4301DAO.save(f4301);
	}

	public List<F4301> buscarTodosOrdenados() {
		return iF4301DAO.findAllOrderByIdPhdoco();
	}
	
	public List<F4301> buscarDOCO(Double value) {
		return iF4301DAO.findByIdPhdoco(value);
	}

}
