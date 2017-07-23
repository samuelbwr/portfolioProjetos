package br.com.projetos.projeto.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.projetos.pessoa.Pessoa;
import lombok.extern.log4j.Log4j;

@Log4j
public class OnlyFuncionarioValidator implements ConstraintValidator<OnlyFuncionario, List<Pessoa>>  {

	@Override
	public void initialize(OnlyFuncionario constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(List<Pessoa> value, ConstraintValidatorContext context) {
		if(value == null)
			return true;
		for (Pessoa pessoa : value) {
			if(!pessoa.isFuncionario())
				return false;
		}
		return true;
	}
}
