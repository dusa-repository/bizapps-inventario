package interfacedao.maestros;

import java.math.BigDecimal;
import java.util.List;

import modelo.maestros.F41021;
import modelo.pk.F41021PK;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF41021DAO extends JpaRepository<F41021, F41021PK> {

	@Query("select distinct f.id.liitm from F41021 f where f.id.limcu = ?1")
	List<Double> buscarItemDistintos(String value);

//	@Query("select f from F41021 f where f.liupmj <= ?1 order by f.id.limcu asc, f.id.lilocn asc, (select a.imdsc1 from F4101 a where a.imitm = f.id.liitm) asc")

	@Query(value="select * from F41021 f where f.liupmj <= ?1 order by f.limcu asc, f.lilocn asc, "
			+ "(select a.IMDSC1 from F4101 a where a.imitm = f.liitm) asc", nativeQuery = true)
	List<F41021> findByLiupmjBeforeNow(BigDecimal desde);

	@Query(value="select * from F41021 f where f.liupmj <= ?1 and f.lipqoh <> 0 order by f.limcu asc, f.lilocn asc, "
			+ "(select a.IMDSC1 from F4101 a where a.imitm = f.liitm) asc", nativeQuery = true)
	List<F41021> findByLiupmjBeforeNowExistencia(BigDecimal hasta);

	List<F41021> findByIdLimcuLikeAndIdLiitm(String planta, Double value, Sort o);

	List<F41021> findByIdLimcuLikeAndIdLiitmAndLipqohNot(String planta,
			Double value, Double valor, Sort o);

}
