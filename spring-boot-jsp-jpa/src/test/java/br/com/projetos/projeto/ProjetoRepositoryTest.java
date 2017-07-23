package br.com.projetos.projeto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import javax.validation.ConstraintViolationException;

import static br.com.projetos.projeto.ProjetoStubs.*;
import static br.com.projetos.pessoa.PessoaStubs.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projetos.pessoa.PessoaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjetoRepositoryTest {

	static final String DESCRIPTION = "Other description";

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Before
	public void before() {
		projetoRepository.deleteAll();
		pessoaRepository.deleteAll();
	}

	@Test
	public void testAddFullProjeto() throws Exception {
		FULL_PROJETO.setGerente(pessoaRepository.save(FULL_PESSOA));
		Projeto projeto = projetoRepository.save(FULL_PROJETO);
		assertThat(projeto.getId()).isGreaterThan(0l);
	}

	@Test
	public void testUpdateProjeto() {
		FULL_PROJETO.setGerente(pessoaRepository.save(FULL_PESSOA));
		Projeto projeto = projetoRepository.save(FULL_PROJETO);
		projeto.setDescricao(DESCRIPTION);
		projetoRepository.save(projeto);
		assertThat(projetoRepository.findOne(projeto.getId()).getDescricao()).isEqualTo(DESCRIPTION);
	}

	@Test
	public void testDeletingProjeto() {
		FULL_PROJETO.setGerente(pessoaRepository.save(FULL_PESSOA));
		Projeto projeto = projetoRepository.save(FULL_PROJETO);
		projetoRepository.delete(projeto.getId());
		assertThat(projetoRepository.findOne(projeto.getId())).isNull();
	}

	@Test
	public void testAddingMembroToProjeto() {
		FULL_PROJETO.setGerente(pessoaRepository.save(FULL_PESSOA));
		FULL_PROJETO.setMembros(Arrays.asList(pessoaRepository.save(FUNCIONARIO)));
		Projeto projeto = projetoRepository.save(FULL_PROJETO);
		assertThat(projetoRepository.findOne(projeto.getId()).getMembros().size()).isEqualTo(1);
	}

	@Test
	public void testRemovingMembroFromProjeto() {
		FULL_PROJETO.setGerente(pessoaRepository.save(FULL_PESSOA));
		FULL_PROJETO
				.setMembros(Arrays.asList(pessoaRepository.save(FUNCIONARIO), pessoaRepository.save(ANOTHER_FUNCIONARIO)));
		Projeto projeto = projetoRepository.save(FULL_PROJETO);
		assertThat(projetoRepository.findOne(projeto.getId()).getMembros().size()).isEqualTo(2);
		projeto.getMembros().remove(1);
		projetoRepository.save(projeto);
		assertThat(projetoRepository.findOne(projeto.getId()).getMembros().size()).isEqualTo(1);
	}

	@Test(expected=UndeletableStatusException.class)
	public void testTryDeletingProjetoInUndeletableStatus() throws Exception {
		FULL_PROJETO.setGerente(pessoaRepository.save(FULL_PESSOA));
		FULL_PROJETO.setStatus(UNDELETABLE_STATUS);
		Projeto projeto = projetoRepository.save(FULL_PROJETO);
		projetoRepository.delete(projeto);
		assertThat(projetoRepository.findOne(projeto.getId())).isNotNull();
	}

	@Test(expected = ConstraintViolationException.class)
	public void testAddInvalidProjeto() {
		projetoRepository.save(INVALID_PROJETO);
	}
}
