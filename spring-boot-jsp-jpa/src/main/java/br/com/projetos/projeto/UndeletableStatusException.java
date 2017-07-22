package br.com.projetos.projeto;

public class UndeletableStatusException extends RuntimeException{
	
	public UndeletableStatusException(String message) {
		super(message);
	}

}
