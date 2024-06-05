package sistema.essenseg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import sistema.essenseg.dto.administradora.DadosAdministradoraDTO;
import sistema.essenseg.dto.operadora.DadosOperadoraDTO;
import sistema.essenseg.dto.plano.DadosPlanoDTO;
import sistema.essenseg.dto.relacionamento.DadosRelacionamentoDTO;
import sistema.essenseg.service.*;

import java.math.BigDecimal;

@Component
public class CadastroAutomatico implements ApplicationRunner {


	@Autowired
	OperadoraService opService;
	@Autowired
	AdministradoraService admService;
	@Autowired
	PlanoService planoService;
	@Autowired
	RelacionamentoService relacionamentoService;


	@Override
	public void run(ApplicationArguments args) {
		try{

			this.opService.cadastrar(new DadosOperadoraDTO(null, "Ideal Saúde")); //ID 1
			this.opService.cadastrar(new DadosOperadoraDTO(null, "Univida")); //ID 2
			this.opService.cadastrar(new DadosOperadoraDTO(null, "Hapivida")); //ID 3
			this.opService.cadastrar(new DadosOperadoraDTO(null, "Blue")); //ID 4
			this.opService.cadastrar(new DadosOperadoraDTO(null, "Ceam Brasil")); //ID 5

			this.admService.cadastrar(new DadosAdministradoraDTO("EasyPlan")); //ID 1
			this.admService.cadastrar(new DadosAdministradoraDTO("Qualicorp")); //ID 2
			this.admService.cadastrar(new DadosAdministradoraDTO("Corpe")); //ID 3
			this.admService.cadastrar(new DadosAdministradoraDTO("Alter")); //ID 4
			this.admService.cadastrar(new DadosAdministradoraDTO("CTESK")); //ID 5
			this.admService.cadastrar(new DadosAdministradoraDTO("Afflix")); //ID 6
			this.admService.cadastrar(new DadosAdministradoraDTO("Bitlife")); //ID 7
			this.admService.cadastrar(new DadosAdministradoraDTO("Capital Beneficios")); //ID 8

			relacionamentoService.relacionar(new DadosRelacionamentoDTO(1L, 1L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(1L, 3L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(1L, 4L));

			relacionamentoService.relacionar(new DadosRelacionamentoDTO(2L, 7L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(2L, 8L));

			relacionamentoService.relacionar(new DadosRelacionamentoDTO(3L, 3L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(3L, 4L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(3L, 6L));

			relacionamentoService.relacionar(new DadosRelacionamentoDTO(4L, 2L));

			relacionamentoService.relacionar(new DadosRelacionamentoDTO(5L, 1L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(5L, 2L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(5L, 5L));

			this.planoService.cadastrar(new DadosPlanoDTO(1L, "Ideal Cuidado 10", new BigDecimal("10")));
			this.planoService.cadastrar(new DadosPlanoDTO(1L, "Ideal Cuidado 20", new BigDecimal("20")));
            this.planoService.cadastrar(new DadosPlanoDTO(1L, "Ideal Cuidado 30", new BigDecimal("30")));
			this.planoService.cadastrar(new DadosPlanoDTO(2L, "Exato QC", new BigDecimal("40")));
			this.planoService.cadastrar(new DadosPlanoDTO(4L, "Joy QC", new BigDecimal("20")));
			this.planoService.cadastrar(new DadosPlanoDTO(4L, "Joy QP", new BigDecimal("20")));
			this.planoService.cadastrar(new DadosPlanoDTO(5L, "Bronze QC", new BigDecimal("10")));
			this.planoService.cadastrar(new DadosPlanoDTO(5L, "Bronze QP", new BigDecimal("40")));
            this.planoService.cadastrar(new DadosPlanoDTO(5L, "Bronze Plus QP", new BigDecimal("20")));

		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}
}
