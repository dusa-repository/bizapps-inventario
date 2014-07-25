package servicio.maestros;

import interfacedao.maestros.IF4108DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4108")
public class SF4108 {

	@Autowired
	private IF4108DAO iF4108DAO;
}
