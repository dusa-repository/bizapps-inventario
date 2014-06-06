package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0115;
import modelo.maestros.F01151;
import modelo.pk.F01151PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF01151DAO extends JpaRepository<F01151, F01151PK> {

	@Query("select f from F01151 f order by f.id.eaan8 asc")
	List<F01151> findAllOrderByAban8dAsc();
	
	@Query("select f from F01151 f where f.id.eaan8 =?1")
	List<F01151> findByIdEaan8(double doubleValue);
}
