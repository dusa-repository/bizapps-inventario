package interfacedao.transacciones;

import java.util.List;

import modelo.transacciones.F4111;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IF4111DAO extends JpaRepository<F4111, Long> {

	List<F4111> findByIldctOrderByIlukidAsc(String tipo);

	List<F4111> findByIldocAndIldct(Double ildoc, String tipo);

}
