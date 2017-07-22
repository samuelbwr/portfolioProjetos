package br.com.projetos.pessoa;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public class PessoaStubs {

	public static Pessoa 
	INVALID_PESSOA = Pessoa.builder().cpf("123").build(),
	
	MINIMAL_PESSOA = Pessoa.builder().nome("Nome da pessoa 1").build(),
	FULL_PESSOA = MINIMAL_PESSOA.cpf("123")
		.dataNascimento( GregorianCalendar.from(LocalDate.of(1990, 1, 1).atStartOfDay(ZoneId.systemDefault())).getTime())
		.funcionario(false),
	FUNCIONARIO = FULL_PESSOA.funcionario(true),
	
	ANOTHER_MINIMAL_PESSOA = Pessoa.builder().nome("Nome da pessoa 2").build(),
	ANOTHER_FULL_PESSOA = ANOTHER_MINIMAL_PESSOA.cpf("124").dataNascimento( GregorianCalendar.from(LocalDate.of(1990, 2, 1).atStartOfDay(ZoneId.systemDefault())).getTime()),
	ANOTHER_FUNCIONARIO = ANOTHER_FULL_PESSOA.funcionario(true);
}
