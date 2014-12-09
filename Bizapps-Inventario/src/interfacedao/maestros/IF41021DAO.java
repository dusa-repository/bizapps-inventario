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

	@Query("select v from F41021 v where v.id.limcu like ?1 and v.lipqoh > "
			+ "(select f.ibanpl from F4102 f where f.id.ibmcu = v.id.limcu and f.id.ibitm = v.id.liitm) "
			+ "order by v.id.limcu asc, v.id.lilocn asc")
	List<F41021> findByMaxExistence(String company);
	
	@Query("select v from F41021 v where v.id.limcu like ?1 and v.lipqoh < "
			+ "(select f.ibavrt from F4102 f where f.id.ibmcu = v.id.limcu and f.id.ibitm = v.id.liitm) "
			+ "order by v.id.limcu asc, v.id.lilocn asc")
	List<F41021> findByMinExistence(String company);

	@Query("select v from F41021 v where v.id.limcu like ?1 and v.lipqoh < "
			+ "(select f.ibbqty from F4102 f where f.id.ibmcu = v.id.limcu and f.id.ibitm = v.id.liitm) "
			+ "order by v.id.limcu asc, v.id.lilocn asc")
	List<F41021> findByMinOrder(String company);

	@Query("select v from F41021 v where v.id.limcu like ?1 and v.lipqoh < "
			+ "(select f.ibcarp from F4102 f where f.id.ibmcu = v.id.limcu and f.id.ibitm = v.id.liitm) "
			+ "order by v.id.limcu asc, v.id.lilocn asc")
	List<F41021> findByMinSecurityStock(String company);

}
