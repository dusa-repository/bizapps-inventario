package servicio.maestros;

import interfacedao.maestros.IF40205DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF40205")
public class SF40205 {

	@Autowired
	private IF40205DAO f40205DAO;
}
