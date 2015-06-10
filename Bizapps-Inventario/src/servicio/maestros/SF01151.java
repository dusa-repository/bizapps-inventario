package servicio.maestros;

import interfacedao.maestros.IF01151DAO;

import java.util.List;

import modelo.maestros.F01151;
import modelo.pk.F01151PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF01151")
public class SF01151 {

	@Autowired
	private IF01151DAO f01151DAO;

	public List<F01151> buscarTodosOrdenados() {
		return f01151DAO.findAllOrderByAban8dAsc();
	}

	public void guardar(F01151 f015) {
		f01151DAO.save(f015);
	}

	public void eliminarVarios(List<F01151> eliminarLista) {
		f01151DAO.delete(eliminarLista);
	}

	public void eliminarUno(F01151PK clave) {
		f01151DAO.delete(clave);
	}

	public List<F01151> buscarParaRegistrar(double doubleValue) {
		return f01151DAO.findByIdEaan8(doubleValue);
	}

	public List<F01151> buscarPorAn(double aban8) {
		return f01151DAO.findByIdEaan8(aban8);
	}
}
