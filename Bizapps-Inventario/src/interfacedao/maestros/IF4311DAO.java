package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F4311;
import modelo.pk.F4311PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4311DAO extends JpaRepository<F4311, F4311PK> {

	@Query("Select f from F4311 f order by f.id.pddoco asc")
	List<F4311> findAllOrderByIdPddoco();
	
	List<F4311> findByIdPddocoAndIdPddctoAndIdPdkcooAndIdPdsfxoOrderByIdPddocoAsc(double phdoco, String phdcto, String phkcoo, String phsfxo); 

}
