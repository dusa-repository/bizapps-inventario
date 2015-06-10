package servicio.maestros;

import interfacedao.maestros.IF0115DAO;

import java.util.List;

import modelo.maestros.F0115;
import modelo.pk.F0115PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0115")
public class SF0115 {

	@Autowired
	private IF0115DAO f0115DAO;

	public List<F0115> buscarTodosOrdenados() {
		return f0115DAO.findAllOrderByAban8dAsc();
	}

	public void guardar(F0115 f015) {
		f0115DAO.save(f015);
	}

	public void eliminarVarios(List<F0115> eliminarLista) {
		f0115DAO.delete(eliminarLista);
	}

	public void eliminarUno(F0115PK clave) {
		f0115DAO.delete(clave);
	}

	public List<F0115> buscarParaRegistrar(double doubleValue) {
		return f0115DAO.findByIdWpan8(doubleValue);
	}

	public List<F0115> buscarPorAn(double aban8) {
		return f0115DAO.findByIdWpan8(aban8);
	}
}
