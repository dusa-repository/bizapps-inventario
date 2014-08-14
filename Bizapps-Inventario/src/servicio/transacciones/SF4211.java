package servicio.transacciones;

import java.util.ArrayList;
import java.util.List;

import interfacedao.transacciones.IF4211DAO;

import modelo.pk.F4211PK;
import modelo.transacciones.F4211;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4211")
public class SF4211 {

	@Autowired
	private IF4211DAO f4211DAO;

	public List<F4211> buscarTodosOrdenados() {
		return f4211DAO.findAllById();
	}

	public void eliminarVarios(List<F4211> eliminarLista) {
		f4211DAO.delete(eliminarLista);
	}

	public void eliminarUno(F4211PK clave) {
		f4211DAO.delete(clave);
	}

	public List<F4211> buscarPorDocoYDcto(Double sddoco, String sddcto) {
		return f4211DAO
				.findByIdSddocoAndIdSddctoAndSdspattnOrderBySditmAsc(sddoco, sddcto, "Enviada");
	}

	public void guardar(F4211 f4211) {
		f4211DAO.save(f4211);
	}

	public void guardarVarios(List<F4211> guardados) {
		f4211DAO.save(guardados);
	}

	public List<F4211> buscarTodosOrdenadosUnicos() {
		List<Double> listaBuscada = f4211DAO.findDocoDistinct();
		List<F4211> lista = new ArrayList<F4211>();
		for (int i = 0; i < listaBuscada.size(); i++) {
			lista.add(buscarPorDocoYDcto(listaBuscada.get(i), "ET").get(0));
		}
		return lista;
	}

	public F4211 buscarPorDocoEItem(Double value, Double imitm) {
		return f4211DAO
				.findByIdSddocoAndSditm(value, imitm);
	}
}
