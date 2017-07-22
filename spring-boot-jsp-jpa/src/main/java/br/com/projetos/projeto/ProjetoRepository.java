package br.com.projetos.projeto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjetoRepository extends CrudRepository<Projeto, Long>{

}
