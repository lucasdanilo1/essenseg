package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.essenseg.model.Anexo;

import java.util.List;

public interface AnexoRepository extends JpaRepository<Anexo, Long> {

    List<Anexo> findAllBySeguradoId(Long seguradoId);

}
