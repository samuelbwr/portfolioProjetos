package br.com.projetos.pessoa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@RepositoryRestResource(path="pessoas")
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
