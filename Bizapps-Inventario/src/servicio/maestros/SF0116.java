package servicio.maestros;

import interfacedao.maestros.IF0116DAO;
import modelo.maestros.F0116;
import modelo.pk.F0116PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0116")
public class SF0116 {

	@Autowired
	private IF0116DAO f0116DAO;

	public F0116 buscar(F0116PK clave) {
		return f0116DAO.findOne(clave);
	}

	public void guardar(F0116 f0116) {
		f0116DAO.save(f0116);
	}
}
