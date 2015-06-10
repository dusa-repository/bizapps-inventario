package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F40205;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF40205DAO extends JpaRepository<F40205, String> {

	@Query("select f from F40205 f order by f.lflnty asc")
	List<F40205> findAllOrderByAban8dAsc();
}
