package interfacedao.transacciones;

import java.math.BigDecimal;
import java.util.List;

import modelo.pk.F4211PK;
import modelo.transacciones.F4211;

import org.springframework.data.domain.Sort;
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

	List<F4211> findBySddrqjBetweenAndSdspattn(BigDecimal desde,
			BigDecimal hasta, String string, Sort o);

	List<F4211> findBySddrqjBetweenAndSdspattnAndIdSddcto(BigDecimal desde,
			BigDecimal hasta, String string, String tipo, Sort o);

}
