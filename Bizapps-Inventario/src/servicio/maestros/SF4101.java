package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF4101DAO;
import modelo.maestros.F0008;
import modelo.maestros.F4101;
import modelo.pk.F0008PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4101")
public class SF4101 {

	@Autowired
	private IF4101DAO f4101DAO;

	public void guardar(F4101 f4101) {
		f4101DAO.save(f4101);
	}
	
	public void eliminarVarios(List<F4101> eliminar) {
		f4101DAO.delete(eliminar);
	}

	public void eliminarUno(double umitm) {
		f4101DAO.delete(umitm);
	}
	
	public F4101 buscar(double umitm) {
		return f4101DAO.findOne(umitm);
	}

	public List<F4101> buscarTodosOrdenados() {

		return f4101DAO.findAllAndOrderByIMDSC1();
	}
	
	
	

}
