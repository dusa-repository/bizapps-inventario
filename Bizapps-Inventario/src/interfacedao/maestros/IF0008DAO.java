package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0008;
import modelo.pk.F0008PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF0008DAO extends JpaRepository<F0008, F0008PK> {

	@Query("Select f from F0008 f order by f.id.cddtpn asc")
	List<F0008> findAllOrderByIdCddtpn();
	
	List<F0008> findByIdCddtpn(String value);

	

}