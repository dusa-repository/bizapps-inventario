package servicio.maestros;

import interfacedao.maestros.IF01151DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF01151")
public class SF01151 {

	@Autowired
	private IF01151DAO f01151DAO;
}
