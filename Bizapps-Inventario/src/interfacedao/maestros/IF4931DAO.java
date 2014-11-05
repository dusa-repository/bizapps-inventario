package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F4931;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4931DAO extends JpaRepository<F4931, String> {

	@Query("Select f from F4931 f order by f.vgvtyp asc")
	List<F4931> findAllOrderByIdVgvtyp();

}
