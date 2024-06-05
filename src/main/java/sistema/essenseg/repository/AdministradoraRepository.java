package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Operadora;

import java.util.List;

public interface AdministradoraRepository extends JpaRepository<Administradora, Long> {
    boolean existsByNome(String nome    );

    @Query("SELECT a FROM Administradora a ORDER BY a.id ASC")
    List<Administradora> findAll();

}
