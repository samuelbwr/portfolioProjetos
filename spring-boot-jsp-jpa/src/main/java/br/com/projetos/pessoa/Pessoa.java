package br.com.projetos.pessoa;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "pessoa")
@Data
@NoArgsConstructor
@Builder(toBuilder=true)
@AllArgsConstructor
@Accessors(fluent = true, chain= true)
public class Pessoa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(length=100)
	@NotNull
	private String nome;
	
	@Column(name="datanascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(length=14)
	private String cpf;
	
	private Boolean funcionario;
	
}
