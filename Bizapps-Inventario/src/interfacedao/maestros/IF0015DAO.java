package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0008;
import modelo.maestros.F0015;
import modelo.pk.F0015PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF0015DAO extends JpaRepository<F0015, F0015PK> {

	List<F0015> findByIdCxcrcd(String value);

}