package br.com.deveficiente.casadocodigo.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@InitBinder
	public void init (WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new NomeCategoriaDuplicado(categoriaRepository));
	}

	@PostMapping(value = "/api/categoria")
	public void novaCategoria(@RequestBody @Valid NovaCategoriaForm form) {
		Categoria categoria = form.novaCategoria();
		categoriaRepository.save(categoria);
	}

}
