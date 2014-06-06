package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF4008DAO;

import modelo.maestros.F4008;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4008")
public class SF4008 {

	@Autowired
	private IF4008DAO f4008DAO;

	public List<F4008> buscarTodosOrdenados() {
		return f4008DAO.findAllOrderById();
	}
}
