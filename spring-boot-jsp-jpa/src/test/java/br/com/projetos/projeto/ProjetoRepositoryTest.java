package br.com.projetos.projeto;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import static br.com.projetos.projeto.ProjetoStubs.*;
import static br.com.projetos.pessoa.PessoaStubs.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projetos.pessoa.PessoaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
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
		FULL_PROJETO.gerente(pessoaRepository.save( FULL_PESSOA ));
		Projeto projeto = projetoRepository.save( FULL_PROJETO );
        assertThat(projeto.id()).isGreaterThan(0l);
    }
	
	@Test
    public void testUpdateProjeto() throws Exception {		
		FULL_PROJETO.gerente(pessoaRepository.save( FULL_PESSOA ));
		Projeto projeto = projetoRepository.save( FULL_PROJETO );
		projeto.descricao( DESCRIPTION );
        projetoRepository.save( projeto );
        assertThat(projetoRepository.findOne(projeto.id()).descricao()).isEqualTo( DESCRIPTION );
    }
	
	@Test(expected=ConstraintViolationException.class)
    public void testFailToAddInvalidProjeto() throws Exception {
		projetoRepository.save(INVALID_PROJETO);
    }
}
