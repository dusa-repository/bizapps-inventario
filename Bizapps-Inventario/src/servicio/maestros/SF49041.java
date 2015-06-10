package servicio.maestros;

import interfacedao.maestros.IF49041DAO;

import java.util.List;

import modelo.maestros.F49041;
import modelo.pk.F49041PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF49041")
public class SF49041 {

	@Autowired
	private IF49041DAO f49041DAO;

	public List<F49041> buscarTodosOrdenados() {
		return f49041DAO.findAll();
	}

	public F49041 buscar(double value, String value2, long value3) {
		F49041PK clave = new  F49041PK();
		clave.setVsstfn(value);
		clave.setVsshft(value2);
		clave.setVseftj(value3);
		return f49041DAO.findOne(clave);
	}

	public void guardar(F49041 f49041) {
		f49041DAO.save(f49041);
	}

	public void eliminarVarios(List<F49041> eliminar) {
		f49041DAO.delete(eliminar);
	}

	public void eliminarUno(F49041PK clave) {
		f49041DAO.delete(clave);
	}
	
	public List<F49041> buscarPorMcu(String vsmcu) {
		return f49041DAO.findByVsmcu(vsmcu);
	}
	
	public List<F49041> buscarPorVsstfn(double vsstfn) {
		return f49041DAO.findByIdVsstfn(vsstfn);
	}
	
	
	public List<F49041> buscarPorVsvehi(String vsvehi) {
		return f49041DAO.findByVsvehi(vsvehi);
	}


}
