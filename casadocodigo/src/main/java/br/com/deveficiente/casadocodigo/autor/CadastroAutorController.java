package br.com.deveficiente.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroAutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping(value = "/api/autor")
	public void novoAutor(@RequestBody @Valid NovoAutorForm form) {
		Autor autor = form.novoAutor();
		autorRepository.save(autor);
	}
 
}
