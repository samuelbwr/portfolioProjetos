package br.com.projetos.pessoa;

import static org.assertj.core.api.Assertions.assertThat;
import static br.com.projetos.pessoa.PessoaStubs.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaRepositoryTest {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Before
	public void before() {
		pessoaRepository.deleteAll();
	}

	@Test
	public void testAddPessoa() throws Exception {
		Pessoa pessoa = pessoaRepository.save(FULL_PESSOA);
		assertThat(pessoa.id()).isGreaterThan(0l);
	}

}
