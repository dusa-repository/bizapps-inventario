package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0013;
import modelo.maestros.F0101;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF0101 extends JpaRepository<F0101, Double> {

	@Query("select f from F0101 f order by f.aban8 asc")
	List<F0101> findAllOrderByAban8dAsc();

}
