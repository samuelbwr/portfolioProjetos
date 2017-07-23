package br.com.projetos.pessoa;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import static br.com.projetos.pessoa.PessoaStubs.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projetos.projeto.ProjetoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaRepositoryTest {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private ProjetoRepository projetoRepository;

	@Before
	public void before() {
		projetoRepository.deleteAll();
		pessoaRepository.deleteAll();
	}

	@Test
	public void testAddPessoa() throws Exception {
		Pessoa pessoa = pessoaRepository.save(FULL_PESSOA);
		assertThat(pessoa.getId()).isGreaterThan(0l);
	}
	
	@Test
	public void testAddPessoaFunctionario() throws Exception {
		Pessoa pessoa = pessoaRepository.save(FUNCIONARIO);
		assertThat(pessoa.getId()).isGreaterThan(0l);
		assertThat(pessoa.isFuncionario()).isTrue();
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testAddInvalidPessoa() throws Exception {
		pessoaRepository.save(INVALID_PESSOA);
	}
}
