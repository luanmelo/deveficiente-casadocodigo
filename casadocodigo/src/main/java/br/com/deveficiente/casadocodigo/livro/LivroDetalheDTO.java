package br.com.deveficiente.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.deveficiente.casadocodigo.categoria.Categoria;

public class LivroDetalheDTO {

	private Long id;
	private String titulo;
	private Categoria categoria;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String isbn;
	private LocalDateTime dataPublicacao;
	private int numeroPaginas;

	public LivroDetalheDTO(Livro livro) {
		id = livro.getId();
		titulo = livro.getTitulo();
		categoria = livro.getCategoria();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		isbn = livro.getIsbn();
		dataPublicacao = livro.getDataPublicacao();
		numeroPaginas = livro.getNumeroPaginas();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

}
