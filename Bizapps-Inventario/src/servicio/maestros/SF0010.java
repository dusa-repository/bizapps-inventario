package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF0010DAO;

import modelo.maestros.F0010;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0010")
public class SF0010 {

	@Autowired
	private IF0010DAO f0010DAO;

	public void guardar(F0010 f010) {
		System.out.println(f010.getCcco());
		f0010DAO.save(f010);
	}

	public List<F0010> buscarTodosOrdenados() {
		return f0010DAO.findAllOrderByCccoAsc();
	}

	public void eliminarVarios(List<F0010> eliminarLista) {
		f0010DAO.delete(eliminarLista);
	}

	public void eliminarUno(String clave) {
		f0010DAO.delete(clave);
	}

	public F0010 buscar(String value) {
		return f0010DAO.findOne(value);
	}

	public List<F0010> buscarPorDrdc(String cvcrcd) {
		return f0010DAO.findByCccrcd(cvcrcd);
	}

	public void guardarVarios(List<F0010> empresas) {
		f0010DAO.save(empresas);
	}
}
