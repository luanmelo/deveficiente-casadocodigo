package br.com.deveficiente.casadocodigo.livro;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

	Optional<Livro> findByTitulo(String titulo);

	Optional<Livro> findByIsbn(String isbn);
	
	@Override
	List<Livro> findAll();

}
