package br.com.projetos.pessoa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
