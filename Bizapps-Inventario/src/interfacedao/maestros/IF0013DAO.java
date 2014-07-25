package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0013;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF0013DAO extends JpaRepository<F0013, String> {

	@Query("select f from F0013 f order by f.cvcrcd asc")
	List<F0013> findAllOrderByCvcrcdAsc();

}
