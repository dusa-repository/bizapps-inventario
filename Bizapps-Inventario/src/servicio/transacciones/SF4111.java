package servicio.transacciones;

import java.util.List;

import interfacedao.transacciones.IF4111DAO;

import modelo.transacciones.F4111;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4111")
public class SF4111 {

	@Autowired
	private IF4111DAO iF4111DAO;

	public List<F4111> buscarTodosOrdenadosPorTipo(String tipo) {
		return iF4111DAO.findByIldctOrderByIlukidAsc(tipo);
	}

	public void guardar(F4111 f4111) {
		iF4111DAO.saveAndFlush(f4111);
	}

	public List<F4111> buscarPorDoc(Double ildoc, String tipo) {
		return iF4111DAO.findByIldocAndIldct(ildoc, tipo);
	}

	public Double sumar(Double value, String value2, String value3) {
		return iF4111DAO.suma(value, value2, value3);
	}
}
