package sistema.essenseg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import sistema.essenseg.dto.segurado.FiltrosSeguradoDTO;
import sistema.essenseg.model.segurado.Segmentacao;
import sistema.essenseg.model.segurado.Segurado;

public interface SeguradoRepository extends JpaRepository<Segurado, Long>, Repository<Segurado, Long> {

    @Query("""
            SELECT s
            FROM Segurado s
            WHERE (:#{#filtro.filtroGlobal} IS NULL
            OR s.dadosPessoaisSegurado.nome LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosEspecificosCliente.cpf LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosEspecificosEmpresa.nomeFantasia LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosEspecificosEmpresa.cnpj LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosEspecificosEmpresa.atvEconomica LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosEspecificosEmpresa.razaoSocial LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosPessoaisSegurado.email LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosPessoaisSegurado.telefone LIKE %:#{#filtro.filtroGlobal}%)
            AND (:segmentacao IS NULL OR s.dadosContratacaoSegurado.segmentacao = :segmentacao)
            AND (:#{#filtro.administradoraId} IS NULL OR s.dadosContratacaoSegurado.administradora.id = :#{#filtro.administradoraId})
            AND (:#{#filtro.operadoraId} IS NULL OR s.dadosContratacaoSegurado.operadora.id = :#{#filtro.operadoraId})
            AND (:#{#filtro.dataNascimento1} IS NULL OR s.dadosPessoaisSegurado.dataNascimento > :#{#filtro.dataNascimento1})
            AND (:#{#filtro.dataNascimento2} IS NULL OR s.dadosPessoaisSegurado.dataNascimento < :#{#filtro.dataNascimento2})
            AND (:#{#filtro.dataVigencia1} IS NULL OR s.dadosContratacaoSegurado.vigencia > :#{#filtro.dataVigencia1})
            AND (:#{#filtro.dataVigencia2} IS NULL OR s.dadosContratacaoSegurado.vigencia < :#{#filtro.dataVigencia2})
            ORDER BY s.dadosPessoaisSegurado.nome ASC
    """)
    Page<Segurado> findAll(@Param("filtro") FiltrosSeguradoDTO filtros, Pageable pageable, @Param("segmentacao") Segmentacao segmentacao);

    @Override
    @Query("SELECT s FROM Segurado s ORDER BY s.dadosPessoaisSegurado.nome ASC")
    Page<Segurado> findAll(Pageable pageable);
}
