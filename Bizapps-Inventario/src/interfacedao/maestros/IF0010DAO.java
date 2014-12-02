package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0010;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF0010DAO extends JpaRepository<F0010, String> {

	@Query("select f from F0010 f order by f.ccco asc")
	List<F0010> findAllOrderByCccoAsc();

	List<F0010> findByCccrcd(String cvcrcd);

	List<F0010> findByCcco(String ccco);

	List<F0010> findByCcan8(double ccan8);

}
