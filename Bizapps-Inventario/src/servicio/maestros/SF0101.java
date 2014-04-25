package servicio.maestros;

import interfacedao.maestros.IF0101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0101")
public class SF0101 {

	@Autowired
	private IF0101 f0101DAO;
}
