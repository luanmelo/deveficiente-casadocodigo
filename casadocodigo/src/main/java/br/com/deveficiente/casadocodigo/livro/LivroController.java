package br.com.deveficiente.casadocodigo.livro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.casadocodigo.categoria.CategoriaRepository;

@RestController
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new TituloDuplicado(livroRepository),
					new IsbnDuplicado(livroRepository));
	}

	@PostMapping(value = "/api/livro")
	public void novoLivro(@RequestBody @Valid NovoLivroForm form) {
		Livro novo = form.novoLivro(categoriaRepository);
		livroRepository.save(novo);
	}

}
