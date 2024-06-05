package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sistema.essenseg.model.Operadora;

import java.util.List;

public interface OperadoraRepository extends JpaRepository<Operadora, Long> {
    boolean existsByNome(String nome);

    @Query("SELECT o FROM Operadora o ORDER BY o.id ASC")
    List<Operadora> findAll();
}
