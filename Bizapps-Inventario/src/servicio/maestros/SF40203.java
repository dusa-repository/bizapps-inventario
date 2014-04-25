package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF40203DAO;

import modelo.maestros.F40203;
import modelo.pk.F40203PK;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("SF40203")
public class SF40203 {

	@Autowired
	private IF40203DAO f40203DAO;

	public List<F40203> buscarTodosContado() {
		return f40203DAO.findAll();
	}

}
