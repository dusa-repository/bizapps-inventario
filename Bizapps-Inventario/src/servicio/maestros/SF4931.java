package servicio.maestros;

import interfacedao.maestros.IF4931DAO;

import java.util.List;

import modelo.maestros.F4931;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4931")
public class SF4931 {

	@Autowired
	private IF4931DAO iF4931DAO;

	public void guardar(F4931 f4931) {
		iF4931DAO.save(f4931);
	}

	public List<F4931> buscarTodosOrdenados() {
		return iF4931DAO.findAllOrderByIdVgvtyp();
	}

}
