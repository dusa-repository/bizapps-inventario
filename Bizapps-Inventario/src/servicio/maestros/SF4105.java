package servicio.maestros;

import interfacedao.maestros.IF4105DAO;

import modelo.maestros.F4105;
import modelo.pk.F4105PK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4105")
public class SF4105 {

	@Autowired
	private IF4105DAO iF4105DAO;

	public void guardar(F4105 f4105) {
		iF4105DAO.saveAndFlush(f4105);
	}

	public F4105 buscar(F4105PK claveCostoUnitario) {
		return iF4105DAO.findOne(claveCostoUnitario);
	}

}
