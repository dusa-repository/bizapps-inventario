package servicio.maestros;


import interfacedao.maestros.IF41002DAO;

import java.util.List;

import modelo.maestros.F41002;
import modelo.pk.F41002PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF41002")
public class SF41002 {
	
	@Autowired
	private IF41002DAO f41002DAO;

	public void guardar(F41002 f41002) {
		 f41002DAO.save(f41002);
		
	}

	public List<F41002> buscarTodosOrdenados() {
		return f41002DAO.findAllOrderByUMITM();
	}

	public void eliminarVarios(List<F41002> eliminarLista) {
		 f41002DAO.delete(eliminarLista);
		
	}

	public void eliminarUno(F41002PK clave) {
		 f41002DAO.delete(clave);
		
	}

	public List<F41002> buscarPorItm(double clave) {
		return f41002DAO.findByIdUmitm(clave);
	}

}
