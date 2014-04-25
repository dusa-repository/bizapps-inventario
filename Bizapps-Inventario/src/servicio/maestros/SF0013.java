package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF0013;

import modelo.maestros.F0013;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0013")
public class SF0013 {

	@Autowired
	private IF0013	f0013DAO;

	public List<F0013> buscarTodosOrdenados() {
		return f0013DAO.findAllOrderByCvcrcdAsc();
	}

	public F0013 buscar(String txtCCCRCDF0010) {
		return f0013DAO.findOne(txtCCCRCDF0010);
	}

	public void guardar(F0013 f0013) {
		f0013DAO.saveAndFlush(f0013);
	}

	public void eliminarVarios(List<F0013> eliminarLista) {
		f0013DAO.delete(eliminarLista);
	}

	public void eliminarUno(String clave) {
		f0013DAO.delete(clave);
	}
}
