package br.com.deveficiente.casadocodigo.categoria;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NomeCategoriaDuplicado implements Validator {

	private CategoriaRepository categoriaRepository;
	
	public NomeCategoriaDuplicado(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovaCategoriaForm form = (NovaCategoriaForm) target;
		Optional<Categoria> categoriaDuplicada = categoriaRepository.findByNome(form.getNome());
		
		if(categoriaDuplicada.isPresent()) {
			errors.rejectValue("Nome", null, "Nome da categoria já existente.");
		}
	}

}
