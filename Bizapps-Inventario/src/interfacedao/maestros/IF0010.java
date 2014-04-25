package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0010;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF0010 extends JpaRepository<F0010, String> {

	@Query("select f from F0010 f order by f.ccco asc")
	List<F0010> findAllOrderByCccoAsc();

}
