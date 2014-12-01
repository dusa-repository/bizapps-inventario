package servicio.maestros;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import interfacedao.maestros.IF41021DAO;
import modelo.maestros.F4101;
import modelo.maestros.F41021;
import modelo.pk.F41021PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

		List<String> ordenar = new ArrayList<String>();
		ordenar.add("id.limcu");
		ordenar.add("id.lilocn");
		ordenar.add("id.liitm");
		Sort o = new Sort(Sort.Direction.ASC, ordenar);
		return iF41021DAO.findByLiupmjBeforeNow(desde);
	}

	public List<F41021> buscarHastaFechaExistencia2(BigDecimal hasta) {
		return iF41021DAO.findByLiupmjBeforeNowExistencia(hasta);
	}

	public List<F41021> buscarPorItemMcuSinCeros(String planta, Double value) {
		List<String> ordenar = new ArrayList<String>();
		ordenar.add("idLimcu");
		Sort o = new Sort(Sort.Direction.ASC, ordenar);
		Double valor = (double) 0;
		return iF41021DAO.findByIdLimcuLikeAndIdLiitmAndLipqohNot(planta,
				value, valor, o);
	}

	public List<F41021> buscarPorItemMcu(String planta, Double value) {

		List<String> ordenar = new ArrayList<String>();
		ordenar.add("idLimcu");
		Sort o = new Sort(Sort.Direction.ASC, ordenar);
		return iF41021DAO.findByIdLimcuLikeAndIdLiitm(planta, value, o);
	}
}
