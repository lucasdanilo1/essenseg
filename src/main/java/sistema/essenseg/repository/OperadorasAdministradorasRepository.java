package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.OperadoraAdministradora;

import java.util.List;

public interface OperadorasAdministradorasRepository extends JpaRepository<OperadoraAdministradora, Long> {

    @Query("select oa.administradora from OperadoraAdministradora oa where oa.operadora.id = :operadoraId")
    List<Administradora> findAdministradorasByOperadoraId(@Param("operadoraId") Long operadoraId);

    @Query(value = "SELECT * FROM operadora_administradora ORDER BY operadora_id", nativeQuery = true)
    List<OperadoraAdministradora> findAll();

    @Query(""" 
           SELECT a FROM Administradora a WHERE NOT EXISTS
           (SELECT oa FROM OperadoraAdministradora oa WHERE oa.administradora = a AND oa.operadora.id = :operadoraId)
            """)
    List<Administradora> findAdministradoraSemRelacaoComOperadora(@Param("operadoraId") Long operadoraId);

}
