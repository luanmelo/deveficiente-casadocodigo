package br.com.deveficiente.casadocodigo.livro;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@GetMapping(value = "/api/carrinho/{id}")
	public String adicionarLivroCarrinho(@PathVariable("id") Long id, @CookieValue("carrinho") Optional<String> carrinho, HttpServletResponse response) {
		try {
			Carrinho novoCarrinho;
			if(carrinho.isPresent()) {
				novoCarrinho = new ObjectMapper().readValue(carrinho.get(), Carrinho.class);
			} else {
				novoCarrinho = new Carrinho();
			}
			novoCarrinho.adicionarLivroNoCarrinho(livroRepository.findById(id).get());
			Cookie cookie = new Cookie("carrinho", new ObjectMapper().writeValueAsString(novoCarrinho));
			response.addCookie(cookie);
			
			return novoCarrinho.toString();
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	//TODO Ainda falta fazer funcionar, no momento não encontra nenhum cookie :(
	@GetMapping(value = "/api/cookie/{id}")
	public String consultarCookie(@PathVariable("id") Long id ,HttpServletRequest request) {
	    Cookie name = WebUtils.getCookie(request, "carrinho");
	    if(name != null) {
	    	return name.getValue();
	    }
	    
	    return "No cookie found!";
	}



}
