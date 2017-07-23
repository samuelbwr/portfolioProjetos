package br.com.projetos.pessoa;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public interface PessoaStubs {

	Pessoa 
		INVALID_PESSOA = Pessoa.builder().cpf("123").build(),
		
		MINIMAL_PESSOA = Pessoa.builder().nome("Nome da pessoa 1").build(),
		FULL_PESSOA = new Pessoa().setNome("Nome da Pessoa 2").setCpf("123")
			.setDataNascimento( GregorianCalendar.from(LocalDate.of(1990, 1, 1).atStartOfDay(ZoneId.systemDefault())).getTime())
			.setFuncionario(false),
		FUNCIONARIO = new Pessoa().setNome("Nome da Pessoa 3").setCpf("123")
				.setDataNascimento( GregorianCalendar.from(LocalDate.of(1990, 1, 1).atStartOfDay(ZoneId.systemDefault())).getTime())
				.setFuncionario(true),
		
		ANOTHER_MINIMAL_PESSOA = Pessoa.builder().nome("Nome da pessoa 4").build(),
		ANOTHER_FULL_PESSOA = new Pessoa().setNome("Nome da Pessoa 5")
				.setCpf("124").setDataNascimento( GregorianCalendar.from(LocalDate.of(1990, 2, 1).atStartOfDay(ZoneId.systemDefault())).getTime())
				.setFuncionario(false),
		ANOTHER_FUNCIONARIO = new Pessoa().setNome("Nome da Pessoa 6")
				.setCpf("124").setDataNascimento( GregorianCalendar.from(LocalDate.of(1990, 2, 1).atStartOfDay(ZoneId.systemDefault())).getTime())
				.setFuncionario(true);
}
