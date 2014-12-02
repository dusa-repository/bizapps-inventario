package servicio.maestros;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import interfacedao.maestros.IF0101DAO;

import modelo.maestros.F0101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0101")
public class SF0101 {

	@Autowired
	private IF0101DAO f0101DAO;

	public void guardar(F0101 f01) {
		f0101DAO.save(f01);
	}

	public List<F0101> buscarTodosOrdenados() {
		return f0101DAO.findAllOrderByAban8dAsc();
	}

	public void eliminarVarios(List<F0101> eliminarLista) {
		f0101DAO.delete(eliminarLista);
	}

	public void eliminarUno(double clave) {
		f0101DAO.delete(clave);
	}

	public F0101 buscar(double parseLong) {
		return f0101DAO.findOne(parseLong);
	}

	public List<F0101> buscarPorAns(double aban8) {
		return f0101DAO.findByAban81OrAban82OrAban83OrAban84OrAban85OrAban86(
				aban8, aban8, aban8, aban8, aban8, aban8);
	}
	
	public List<F0101> buscarPorAbmcu(String abmcu) {
		return f0101DAO.findByAbmcu(abmcu);
	}
	
	
	public List<F0101> buscarProveedorConOrden(String string) {
		List<Double> codigosAn8 = f0101DAO.buscarProveedorConOrden(string);
		List<F0101> fs = new ArrayList<F0101>();
		for (Iterator<Double> iterator = codigosAn8.iterator(); iterator
				.hasNext();) {
			Double double1 = (Double) iterator.next();
			fs.add(buscar(double1));
		}
		return fs;
	}
}
