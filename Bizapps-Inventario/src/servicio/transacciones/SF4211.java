package servicio.transacciones;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import interfacedao.transacciones.IF4211DAO;
import modelo.pk.F4211PK;
import modelo.transacciones.F4211;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("SF4211")
public class SF4211 {

	@Autowired
	private IF4211DAO f4211DAO;

	public List<F4211> buscarTodosOrdenados() {
		return f4211DAO.findAllById();
	}

	public void eliminarVarios(List<F4211> eliminarLista) {
		f4211DAO.delete(eliminarLista);
	}

	public void eliminarUno(F4211PK clave) {
		f4211DAO.delete(clave);
	}

	public List<F4211> buscarPorDocoYDcto(Double sddoco, String sddcto) {
		return f4211DAO.findByIdSddocoAndIdSddctoAndSdspattnOrderBySditmAsc(
				sddoco, sddcto, "Enviada");
	}

	public void guardar(F4211 f4211) {
		f4211DAO.save(f4211);
	}

	public void guardarVarios(List<F4211> guardados) {
		f4211DAO.save(guardados);
	}

	public List<F4211> buscarTodosOrdenadosUnicos(String et) {
		return f4211DAO.findUniques(et);
	}

	public F4211 buscarPorDocoEItem(Double value, Double imitm) {
		return f4211DAO.findByIdSddocoAndSditm(value, imitm);
	}

	public List<F4211> buscarEntreFechasYEstado(BigDecimal desde,
			BigDecimal hasta, String string) {
		List<String> ordenar = new ArrayList<String>();
		ordenar.add("id.sddcto");
		ordenar.add("sddoc");
		ordenar.add("sditm");
		Sort o = new Sort(Sort.Direction.ASC, ordenar);
		return f4211DAO.findBySddrqjBetweenAndSdspattn(desde, hasta, string);
	}

	public List<F4211> buscarEntreFechasYEstadoYTipo(BigDecimal desde,
			BigDecimal hasta, String string, String tipo) {
		List<String> ordenar = new ArrayList<String>();
		ordenar.add("id.sddcto");
		ordenar.add("sddoc");
		ordenar.add("sditm");
		Sort o = new Sort(Sort.Direction.ASC, ordenar);
		return f4211DAO.findBySddrqjBetweenAndSdspattnAndIdSddcto(desde, hasta,
				string, tipo);
	}
}
