package br.com.projetos.projeto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;


public interface ProjetoStubs {

	String UNDELETABLE_STATUS = "iniciado";
	
	Projeto 
		INVALID_PROJETO = Projeto.builder().descricao("Algum projeto").build(),
		MINIMAL_PROJETO = Projeto.builder().nome("Nome do Projeto").build(),
		UNFINISHED_PROJETO = new Projeto().setNome("Algum nome").setDataInicio(GregorianCalendar.from(LocalDate.of(2017, 1, 1).atStartOfDay(ZoneId.systemDefault())).getTime())
				.setNome("Nome do Projeto").setDescricao("Projeto completo").setOrcamento(1f).setRisco("alto")
				.setDataPrevisao(GregorianCalendar.from(LocalDate.of(2017, 2, 1).atStartOfDay(ZoneId.systemDefault())).getTime())
				.setStatus("ativo"),
		FULL_PROJETO = new Projeto().setNome("Algum nome").setDataInicio(GregorianCalendar.from(LocalDate.of(2017, 1, 1).atStartOfDay(ZoneId.systemDefault())).getTime())
				.setNome("Nome do Projeto").setDescricao("Projeto completo").setOrcamento(1f).setRisco("alto")
				.setDataPrevisao(GregorianCalendar.from(LocalDate.of(2017, 2, 1).atStartOfDay(ZoneId.systemDefault())).getTime())
				.setStatus("ativo").setDataFim(GregorianCalendar.from(LocalDate.of(2017, 2, 1).atStartOfDay(ZoneId.systemDefault())).getTime());
}
