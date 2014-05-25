package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF4101DAO;
import modelo.maestros.F4101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4101")
public class SF4101 {

	@Autowired
	private IF4101DAO f4101DAO;
	
	
	

}
