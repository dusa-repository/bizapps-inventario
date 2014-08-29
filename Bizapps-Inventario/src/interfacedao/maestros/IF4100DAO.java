package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F4100;
import modelo.pk.F4100PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4100DAO extends JpaRepository<F4100, F4100PK> {

	@Query("Select f from F4100 f order by f.id.lmmcu asc")
	List<F4100> findAllOrderByMcu();

	List<F4100> findByIdLmmcu(String valor);

	List<F4100> findByIdLmmcuOrderByIdLmmcuAsc(String mcu);

	F4100 findByIdLmmcuAndIdLmlocn(String almacenRef, String ubicacionRef);
}
