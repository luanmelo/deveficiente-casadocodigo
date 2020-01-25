package br.com.deveficiente.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.deveficiente.casadocodigo.categoria.Categoria;
import br.com.deveficiente.casadocodigo.categoria.CategoriaInexistenteException;
import br.com.deveficiente.casadocodigo.categoria.CategoriaRepository;

public class NovoLivroForm {

	@NotBlank
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull
	@Min(value = 20)
	private BigDecimal preco;
	
	@NotNull
	@Min(value = 100)
	private int numeroPaginas;
	
	@NotBlank
	private String isbn;
	
	@Future
	private LocalDateTime dataPublicacao;
	
	@NotNull
	private Long idCategoria;

	public Livro novoLivro(CategoriaRepository categoriaRepository) {
		Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
		if(!categoria.isPresent()) {
			throw new CategoriaInexistenteException("Categoria informada não existe");
		}
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria.get());
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setDataPostagem(LocalDateTime dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}


}
