package servicio.maestros;

import interfacedao.maestros.IF4008DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4008")
public class SF4008 {

	@Autowired
	private IF4008DAO f4008DAO;
}
