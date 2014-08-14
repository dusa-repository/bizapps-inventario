package interfacedao.transacciones;

import java.util.List;

import modelo.pk.F4211PK;
import modelo.transacciones.F4211;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4211DAO extends JpaRepository<F4211, F4211PK> {


	@Query("Select f from F4211 f order by f.id.sddoco asc, f.id.sddcto asc, f.id.sdkcoo asc")
	List<F4211> findAllById();

	List<F4211> findByIdSddocoAndIdSddctoOrderBySditmAsc(Double sddoco,
			String sddcto);

}
