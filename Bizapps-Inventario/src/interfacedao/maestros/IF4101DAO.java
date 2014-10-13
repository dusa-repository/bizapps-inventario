package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F4101;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4101DAO extends JpaRepository<F4101, Double> {

	@Query("Select f from F4101 f order by f.imdsc1 asc")
	List<F4101> findAllAndOrderByIMDSC1();

	F4101 findByReferencia(long l);

	List<F4101> findByImitmIn(List<Double> lista);

	@Query("select fa from F4101 fa where fa.imitm in (select distinct f.id.liitm from F41021 f where f.id.limcu = ?1)")
	List<F4101> buscarPorMcu(String value);
}

