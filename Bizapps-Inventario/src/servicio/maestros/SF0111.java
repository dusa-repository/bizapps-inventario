package servicio.maestros;

import interfacedao.maestros.IF0111DAO;
import modelo.maestros.F0111;
import modelo.pk.F0111PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0111")
public class SF0111 {

	@Autowired
	private IF0111DAO f0111DAO;

	public F0111 buscar(F0111PK clave2) {
		return f0111DAO.findOne(clave2);
	}

	public void guardar(F0111 f0111) {
		f0111DAO.save(f0111);
	}
}
