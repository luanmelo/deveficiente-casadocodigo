package br.com.deveficiente.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value = "/api/livro")
	public List<LivroDTO> listarTodosLivros() {
		return livroRepository.findAll().stream()
				.map(LivroDTO::new)
				.collect(Collectors.toList());
	}

	@GetMapping(value = "/api/livro/{id}")
	public LivroDetalheDTO detalharLivroPorId(@PathVariable("id") Long id) {
		Livro livro = livroRepository.findById(id).orElseThrow(() -> new LivroInexistenteException("Livro não encontrado."));
		return new LivroDetalheDTO(livro);
	}


}
