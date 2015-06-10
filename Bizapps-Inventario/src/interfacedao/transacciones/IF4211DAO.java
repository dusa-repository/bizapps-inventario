package interfacedao.transacciones;

import java.math.BigDecimal;
import java.util.List;

import modelo.pk.F4211PK;
import modelo.transacciones.F4211;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4211DAO extends JpaRepository<F4211, F4211PK> {


	@Query("Select f from F4211 f where f.sdspattn='Enviada' order by f.id.sddoco asc, f.id.sddcto asc, f.id.sdkcoo asc")
	List<F4211> findAllById();

	@Query("select distinct(f.id.sddoco) from F4211 f where f.sdspattn='Enviada' and f.id.sddcto = ?1")
	List<Double> findDocoDistinct(String et);

	F4211 findByIdSddocoAndSditm(Double value, Double imitm);

	List<F4211> findByIdSddocoAndIdSddctoAndSdspattnOrderBySditmAsc(
			Double sddoco, String sddcto, String string);

	@Query(value="select * from F4211 f where f.sddrqj between ?1 and ?2 and f.sdspattn=?3 order by f.sddcto asc, "
			+ "f.sddoc asc, (select a.IMDSC1 from F4101 a where a.imitm = f.sditm) asc", nativeQuery = true)
	List<F4211> findBySddrqjBetweenAndSdspattn(BigDecimal desde,
			BigDecimal hasta, String string);

	@Query(value="select * from F4211 f where f.sddrqj between ?1 and ?2 and f.sdspattn=?3 and f.sddcto = ?4 order by f.sddcto asc, "
			+ "f.sddoc asc, (select a.IMDSC1 from F4101 a where a.imitm = f.sditm) asc", nativeQuery = true)
	List<F4211> findBySddrqjBetweenAndSdspattnAndIdSddcto(BigDecimal desde,
			BigDecimal hasta, String string, String tipo);

	@Query("select fd from F4211 fd where fd.id.sdlnid = (select coalesce(min(f.id.sdlnid), '0') from F4211 f where "
			+ "f.sdspattn='Enviada' and f.id.sddcto = ?1 and fd.id.sddoco = f.id.sddoco) "
			+ "and fd.sdspattn='Enviada' and fd.id.sddcto = ?1")
	List<F4211> findUniques(String et);

}
