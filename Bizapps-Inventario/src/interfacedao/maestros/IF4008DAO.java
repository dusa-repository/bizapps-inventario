package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F4008;
import modelo.pk.F4008PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4008DAO extends JpaRepository<F4008, F4008PK> {

	@Query("Select f from F4008 f order by f.id.tatxa1 asc, f.tataxa asc")
	List<F4008> findAllOrderById();

	//List<F4008> findByIdTatxa1(String txa1);


}
