package servicio.maestros;

import interfacedao.maestros.IF40205DAO;

import java.util.List;

import modelo.maestros.F40205;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF40205")
public class SF40205 {

	@Autowired
	private IF40205DAO f40205DAO;

	public void guardar(F40205 f40) {
		f40205DAO.save(f40);
	}

	public List<F40205> buscarTodosOrdenados() {
		return f40205DAO.findAllOrderByAban8dAsc();
	}

	public void eliminarVarios(List<F40205> eliminarLista) {
		f40205DAO.delete(eliminarLista);
	}

	public void eliminarUno(String clave) {
		f40205DAO.delete(clave);
	}

	public Object buscar(String value) {
		return f40205DAO.findOne(value);
	}

	public boolean comparar(String value) {
		return f40205DAO.exists(value);
	}
}
