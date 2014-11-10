package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF0004DAO;
import interfacedao.maestros.IF49041DAO;

import modelo.maestros.F0004;
import modelo.maestros.F49041;
import modelo.pk.F0004PK;
import modelo.pk.F49041PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("SF49041")
public class SF49041 {

	@Autowired
	private IF49041DAO f49041DAO;

	public List<F49041> buscarTodosOrdenados() {
		return f49041DAO.findAll();
	}

	public F49041 buscar(double value, String value2, long value3) {
		F49041PK clave = new  F49041PK();
		clave.setVsstfn(value);
		clave.setVsshft(value2);
		clave.setVseftj(value3);
		return f49041DAO.findOne(clave);
	}

	public void guardar(F49041 f49041) {
		f49041DAO.save(f49041);
	}

	public void eliminarVarios(List<F49041> eliminar) {
		f49041DAO.delete(eliminar);
	}

	public void eliminarUno(F49041PK clave) {
		f49041DAO.delete(clave);
	}

	
}
