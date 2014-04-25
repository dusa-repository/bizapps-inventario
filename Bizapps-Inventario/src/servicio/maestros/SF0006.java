package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF0006DAO;

import modelo.maestros.F0006;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("SF0006")
public class SF0006 {

	@Autowired
	private IF0006DAO f0006DAO;

	public List<F0006> buscarTodosContado() {
		return f0006DAO.findAll();
	}

}
