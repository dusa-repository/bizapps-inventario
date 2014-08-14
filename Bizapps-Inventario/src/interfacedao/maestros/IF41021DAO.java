package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F41021;
import modelo.pk.F41021PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF41021DAO extends JpaRepository<F41021, F41021PK> {

	@Query("select distinct f.id.liitm from F41021 f where f.id.limcu = ?1")
	List<Double> buscarItemDistintos(String value);

}
