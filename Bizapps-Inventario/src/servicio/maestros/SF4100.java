package servicio.maestros;

import java.util.ArrayList;
import java.util.List;

import interfacedao.maestros.IF4100DAO;
import interfacedao.transacciones.IF4111DAO;
import modelo.maestros.F0006;
import modelo.maestros.F4100;
import modelo.pk.F4100PK;
import modelo.transacciones.F4111;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4100")
public class SF4100 {

	@Autowired
	private IF4100DAO f4100DAO;
	@Autowired
	private IF4111DAO f4111DAO;

	public void guardar(F4100 f4100) {
		f4100DAO.save(f4100);

	}

	public List<F4100> buscarTodosOrdenados() {

		return f4100DAO.findAllOrderByMcu();
	}

	public void eliminarVarios(List<F4100> eliminarLista) {
		f4100DAO.delete(eliminarLista);
	}

	public void eliminarUno(F4100PK clave) {
		f4100DAO.delete(clave);
	}

	public List<F4100> buscarTodosOrdenadosPorMcu(String mcu) {
		return f4100DAO.findByIdLmmcuOrderByIdLmmcuAsc(mcu);
	}

	public List<F4100> buscarPorMcu(String clave) {
		return f4100DAO.findByIdLmmcu(clave);
	}

	public void guardarVarios(List<F4100> ubicaciones) {
		f4100DAO.save(ubicaciones);
	}

	public F4100 buscarPorMcuYLoc(String almacenRef, String ubicacionRef) {
		return f4100DAO.findByIdLmmcuAndIdLmlocn(almacenRef, ubicacionRef);
	}

	public List<F4100> buscarTodosOrdenadosPorDoc(String string,
			Double claveDoc, String mcu) {
		List<F4111> lista = f4111DAO.findByIldocAndIldctAndIlmcu(claveDoc,
				string, mcu);
		List<F4100> retorna = new ArrayList<F4100>();
		for (int i = 0; i < lista.size(); i++) {
			F4100 f = buscarPorMcuYLoc(mcu, lista.get(i).getIllocn());
			retorna.add(f);
		}
		return retorna;
	}
}
