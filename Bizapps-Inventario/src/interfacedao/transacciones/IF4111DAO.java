package interfacedao.transacciones;

import java.util.List;

import modelo.transacciones.F4111;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4111DAO extends JpaRepository<F4111, Long> {

	List<F4111> findByIldctOrderByIlukidAsc(String tipo);

	List<F4111> findByIldocAndIldct(Double ildoc, String tipo);

	@Query("select (SUM(f.iltrqt)) from F4111 f where f.ilitm=?1 and f.ilmcu=?2 and f.illocn=?3")
	double suma(double valor1, String valor2, String valor3);
}
