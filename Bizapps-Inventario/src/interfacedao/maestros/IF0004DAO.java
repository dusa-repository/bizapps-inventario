package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0004;
import modelo.pk.F0004PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF0004DAO extends JpaRepository<F0004, F0004PK> {

	List<F0004> findByDtcdlStartingWithAllIgnoreCase(String valor);

	List<F0004> findByDtdl01StartingWithAllIgnoreCase(String valor);

}
