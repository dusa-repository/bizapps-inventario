package interfacedao.maestros;

import java.util.List;

import modelo.maestros.F49041;
import modelo.pk.F49041PK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  IF49041DAO extends JpaRepository<F49041, F49041PK> {

	List<F49041> findByVsmcu(String vsmcu);

	List<F49041> findByIdVsstfn(double vsstfn);

	List<F49041> findByVsvehi(String vsvehi);



}
