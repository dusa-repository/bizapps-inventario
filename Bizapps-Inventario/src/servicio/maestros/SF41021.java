package servicio.maestros;

import java.math.BigDecimal;
import java.util.List;

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

	public List<F41021> buscarHastaFecha2(BigDecimal desde) {
		return iF41021DAO.findByLiupmjBeforeNow(desde);
	}

	public List<F41021> buscarHastaFechaExistencia2(BigDecimal hasta) {
		return iF41021DAO.findByLiupmjBeforeNowExistencia(hasta);
	}
}
