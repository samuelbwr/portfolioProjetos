package br.com.projetos.projeto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="projetos")
public interface ProjetoRepository extends CrudRepository<Projeto, Long>{
    @RestResource(exported = false)
    @Override
    void delete(Long id);
    
    @Override
    default void delete(Projeto projeto) {
    	System.out.println("Deleting project with status: "+projeto.getStatus());
    	if(!Projeto.UNDELETABLE_STAGES.contains(projeto.getStatus()))
    		delete(projeto.getId());
    	else
    		throw new UndeletableStatusException("Esse projeto não pode ser apagado pois está no status "+projeto.getStatus() );
    }
}
