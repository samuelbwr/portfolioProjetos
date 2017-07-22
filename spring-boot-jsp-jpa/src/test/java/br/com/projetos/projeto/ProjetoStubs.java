package br.com.projetos.projeto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;


public class ProjetoStubs {

	public static String UNDELETABLE_STATUS = "iniciado";
	
	public static Projeto 
		INVALID_PROJETO = Projeto.builder().descricao("Algum projeto").build(),
		MINIMAL_PROJETO = Projeto.builder().nome("Nome do Projeto").build(),
		UNFINISHED_PROJETO = MINIMAL_PROJETO.dataInicio(GregorianCalendar.from(LocalDate.of(2017, 1, 1).atStartOfDay(ZoneId.systemDefault())).getTime()).nome("Nome do Projeto")
				.dataPrevisao(GregorianCalendar.from(LocalDate.of(2017, 2, 1).atStartOfDay(ZoneId.systemDefault())).getTime()).descricao("Projeto completo").orcamento(1f).risco("alto")
				.status("ativo"),
		FULL_PROJETO = UNFINISHED_PROJETO.dataFim(GregorianCalendar.from(LocalDate.of(2017, 2, 1).atStartOfDay(ZoneId.systemDefault())).getTime());
}
