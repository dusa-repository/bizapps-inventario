package servicio.maestros;


import interfacedao.maestros.IF41002DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF41002")
public class SF41002 {
	
	@Autowired
	private IF41002DAO f41002DAO;

}
