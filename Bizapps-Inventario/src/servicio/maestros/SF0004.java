package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF0004DAO;

import modelo.maestros.F0004;
import modelo.pk.F0004PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("SF0004")
public class SF0004 {

	@Autowired
	private IF0004DAO f0004DAO;

	public List<F0004> filtroDl01(String valor) {
		return f0004DAO.findByDtdl01StartingWithAllIgnoreCase(valor);
	}

	public List<F0004> filtroCdl(String valor) {
		return f0004DAO.findByDtcdlStartingWithAllIgnoreCase(valor);
	}

	public List<F0004> buscarTodosContado() {
		return f0004DAO.findAll();
	}

	public F0004 buscar(String value, String value2) {
		F0004PK clave = new F0004PK();
		clave.setDtsy(value);
		clave.setDtrt(value2);
		return f0004DAO.findOne(clave);
	}

	public void guardar(F0004 fooo4) {
		f0004DAO.save(fooo4);
	}
}
