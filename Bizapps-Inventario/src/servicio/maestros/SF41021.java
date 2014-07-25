package servicio.maestros;

import interfacedao.maestros.IF41021DAO;

import modelo.maestros.F41021;
import modelo.pk.F41021PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF41021")
public class SF41021 {

	@Autowired
	private IF41021DAO iF41021DAO;

	public F41021 buscar(F41021PK claveSaldo) {
		return iF41021DAO.findOne(claveSaldo);
	}

	public void guardar(F41021 f41021) {
		iF41021DAO.saveAndFlush(f41021);
	}
}
