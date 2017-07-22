package br.com.projetos.projeto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ProjetoRepository extends CrudRepository<Projeto, Long>{
    @RestResource(exported = false)
    @Override
    void delete(Long id);
    
    @Override
    default void delete(Projeto projeto) {
    	System.out.println("Deleting project with status: "+projeto.status());
    	if(!Projeto.UNDELETABLE_STAGES.contains(projeto.status()))
    		delete(projeto.id());
    	else
    		throw new UndeletableStatusException("Esse projeto não pode ser apagado pois está no status "+projeto.status() );
    }
}
