package servicio.maestros;

import interfacedao.maestros.IF0115DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0115")
public class SF0115 {

	@Autowired
	private IF0115DAO f0115DAO;
}
