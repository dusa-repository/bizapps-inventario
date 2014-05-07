package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF0101;

import modelo.maestros.F0101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0101")
public class SF0101 {

	@Autowired
	private IF0101 f0101DAO;

	public void guardar(F0101 f01) {
		f0101DAO.save(f01);
	}

	public List<F0101> buscarTodosOrdenados() {
		return f0101DAO.findAllOrderByAban8dAsc();
	}

	public void eliminarVarios(List<F0101> eliminarLista) {
		f0101DAO.delete(eliminarLista);
	}

	public void eliminarUno(long clave) {
		f0101DAO.delete(clave);
	}
}
