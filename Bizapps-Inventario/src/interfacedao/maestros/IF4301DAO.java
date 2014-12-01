package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0015;
import modelo.maestros.F4301;
import modelo.pk.F4301PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4301DAO extends JpaRepository<F4301, F4301PK> {

	@Query("Select f from F4301 f order by f.id.phdoco asc")
	List<F4301> findAllOrderByIdPhdoco();
	
	List<F4301> findByIdPhdoco(Double value);

}
