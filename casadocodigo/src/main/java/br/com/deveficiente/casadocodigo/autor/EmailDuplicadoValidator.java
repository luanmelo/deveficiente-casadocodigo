package br.com.deveficiente.casadocodigo.autor;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmailDuplicadoValidator implements Validator {

	private AutorRepository repository;
	
	public EmailDuplicadoValidator(AutorRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoAutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoAutorForm autor = (NovoAutorForm) target;
		Optional<Autor> emailAutorExistente = repository.findByEmail(autor.getEmail());
		
		if(emailAutorExistente.isPresent()){
			errors.rejectValue("email", null, "Email já cadastrado.");
		}

	}
}
