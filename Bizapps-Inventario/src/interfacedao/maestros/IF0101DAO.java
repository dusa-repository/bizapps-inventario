package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F0101;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF0101DAO extends JpaRepository<F0101, Double> {

	@Query("select f from F0101 f order by f.aban8 asc")
	List<F0101> findAllOrderByAban8dAsc();

	List<F0101> findByAban81OrAban82OrAban83OrAban84OrAban85OrAban86(
			double aban8, double aban82, double aban83, double aban84,
			double aban85, double aban86);

	@Query("select distinct fa.ilan8 from F4111 fa where fa.ildct=?1")
	List<Double> buscarProveedorConOrden(String string);

	List<F0101> findByAbmcu(String abmcu);


}
