package servicio.maestros;

import java.util.ArrayList;
import java.util.List;

import interfacedao.maestros.IF0006DAO;
import interfacedao.transacciones.IF4111DAO;
import modelo.maestros.F0004;
import modelo.maestros.F0006;
import modelo.maestros.F0010;
import modelo.maestros.F4101;
import modelo.pk.F0004PK;



import modelo.transacciones.F4111;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("SF0006")
public class SF0006 {

	@Autowired
	private IF0006DAO f0006DAO;
	@Autowired
	private IF4111DAO f4111DAO;

	public List<F0006> buscarTodosOrdenados(){
		return f0006DAO.findAllOrderByMcmcu();
	}

	public void guardar(F0006 fooo6) {
		f0006DAO.save(fooo6);
	}

	public void eliminarVarios(List<F0006> eliminar) {
		f0006DAO.delete(eliminar);
	}

	public void eliminarUno(String clave) {
		f0006DAO.delete(clave);
	}
	
	public F0006 buscar(String value) {
		return f0006DAO.findOne(value);

	}
	public List<F0006> buscarMcmu(String value) {
		return f0006DAO.findByMcmcu(value);
	}

	public List<F0006> buscarPorMco(String ccco) {
		return f0006DAO.findByMcco(ccco);
	}
	
	public List<F0006> buscarPorMcan8(double mcan8) {
		return f0006DAO.findByMcan8(mcan8);
	}
	
	

	public void guardarVarios(List<F0006> almacenes) {
		f0006DAO.save(almacenes);
	}

	public List<F0006> buscarTodosOrdenadosPorDoc(String string, Double claveDoc) {
		List<String> lista = f4111DAO.findDisctincMcuByIldocAndIldct(claveDoc, string);
		List<F0006> retorna = new ArrayList<F0006>();
		for (int i = 0; i < lista.size(); i++) {
			F0006 f = buscar(lista.get(i));
			retorna.add(f);
		}
		return retorna;
	}

}
