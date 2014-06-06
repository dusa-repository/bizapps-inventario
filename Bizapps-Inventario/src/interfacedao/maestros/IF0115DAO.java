package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0101;
import modelo.maestros.F0115;
import modelo.pk.F0115PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF0115DAO extends JpaRepository<F0115, F0115PK> {

	@Query("select f from F0115 f order by f.id.wpan8 asc")
	List<F0115> findAllOrderByAban8dAsc();

	@Query("select f from F0115 f where f.id.wpan8 =?1")
	List<F0115> findByIdWpan8(double doubleValue);
	
}
