package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IF00021DAO;

import modelo.maestros.F00021;
import modelo.pk.F00021PK;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("SF00021")
public class SF00021 {

	@Autowired
	private IF00021DAO f00021DAO;

	public List<F00021> buscarTodosContado() {
		return f00021DAO.findAll();
	}

}
