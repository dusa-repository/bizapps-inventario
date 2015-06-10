package servicio.maestros;

import interfacedao.maestros.IF4102DAO;

import java.util.ArrayList;
import java.util.List;

import modelo.maestros.F4102;
import modelo.pk.F4102PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("SF4102")
public class SF4102 {

	@Autowired
	private IF4102DAO f4102DAO;

	public void guardar(F4102 objeto) {
		f4102DAO.save(objeto);
	}

	public List<F4102> buscarTodosOrdenados() {
		List<String> ordenar = new ArrayList<String>();
		ordenar.add("id.ibmcu");
		ordenar.add("id.ibitm");
		Sort o = new Sort(Sort.Direction.ASC, ordenar);
		return f4102DAO.findAll(o);
	}

	public void eliminarVarios(List<F4102> eliminarLista) {
		f4102DAO.delete(eliminarLista);
	}

	public void eliminarUno(F4102PK clave) {
		f4102DAO.delete(clave);
	}

	public F4102 buscar(F4102PK id) {
		return f4102DAO.findOne(id);
	}
}
