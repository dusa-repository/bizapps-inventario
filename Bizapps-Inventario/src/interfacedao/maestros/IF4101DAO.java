package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F4101;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4101DAO extends JpaRepository<F4101, Double> {

	@Query("Select f from F4101 f order by f.imdsc1 asc")
	List<F4101> findAllAndOrderByIMDSC1();

	

}

