package br.com.projetos.projeto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.ValidationException;

import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RestResource;

import br.com.projetos.pessoa.Pessoa;
import br.com.projetos.projeto.validator.OnlyFuncionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@Table(name="projeto")
@Data
@ToString(exclude= {"membros"})
@NoArgsConstructor
@Builder(toBuilder=true)
@AllArgsConstructor
@Accessors(chain = true)
public class Projeto {
	
	final static List<String> UNDELETABLE_STAGES = Arrays.asList("iniciado", "encerrado", "em andamento");
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(length=200)
	@NotNull
	private String nome;
	
	@Column(name="data_inicio")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Column(name="data_previsao")
	@Temporal(TemporalType.DATE)
	private Date dataPrevisao;
	
	@Column(name="data_fim")
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	@Column(length=5000)
	private String descricao;
	
	@Column(length=45)
	private String status;
	
	private Float orcamento;
	
	@Column(length=45)
	private String risco;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false, cascade= {CascadeType.MERGE,CascadeType.REMOVE, CascadeType.DETACH})
	@JoinColumn(name="idgerente")
	private Pessoa gerente;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade= {CascadeType.MERGE,CascadeType.REMOVE, CascadeType.DETACH})
    @JoinTable(name = "membros",
            joinColumns = @JoinColumn(name = "idprojeto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idpessoa", referencedColumnName = "id"))
	@OnlyFuncionario
	private List<Pessoa> membros;
		
}
