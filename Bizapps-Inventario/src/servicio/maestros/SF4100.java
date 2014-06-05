package servicio.maestros;

import interfacedao.maestros.IF4100DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4100")
public class SF4100 {

	@Autowired
	private IF4100DAO f4100DAO;
}
