package servicio.maestros;

import interfacedao.maestros.IF4930DAO;

import java.util.List;

import modelo.maestros.F4930;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4930")
public class SF4930 {

	@Autowired
	private IF4930DAO f4930DAO;

	public List<F4930> buscarTodosOrdenados() {
		return f4930DAO.findAll();
	}

	public void guardar(F4930 f4930) {
		f4930DAO.save(f4930);
	}

	public void eliminarVarios(List<F4930> eliminar) {
		f4930DAO.delete(eliminar);
	}

	public void eliminarUno(String clave) {
		f4930DAO.delete(clave);
	}
	
	public F4930 buscar(String clave){
		return f4930DAO.findByVmvehi(clave);

	}
	
	public List<F4930> buscarPorMcu(String vmmcu) {
		return f4930DAO.findByVmmcu(vmmcu);
	}
	
	public List<F4930> buscarPorVmvown(double vmvown) {
		return f4930DAO.findByVmvown(vmvown);
	}
	
	public List<F4930> buscarPorVmvtyp(String vmvtyp) {
		return f4930DAO.findByVmvtyp(vmvtyp);
	}

	
}