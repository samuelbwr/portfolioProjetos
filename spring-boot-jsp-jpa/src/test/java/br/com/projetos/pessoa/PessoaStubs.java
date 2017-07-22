package br.com.projetos.pessoa;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public class PessoaStubs {

	public static Pessoa 
	INVALID_PESSOA = Pessoa.builder().cpf("123").build(),
	MINIMAL_PESSOA = Pessoa.builder().nome("Nome do Projeto").build(),
	FULL_PESSOA = MINIMAL_PESSOA.cpf("123").dataNascimento( GregorianCalendar.from(LocalDate.of(2017, 1, 1).atStartOfDay(ZoneId.systemDefault())).getTime()),
	FUNCTIONARIO = FULL_PESSOA.funcionario(true);
}
