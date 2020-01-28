package br.com.deveficiente.casadocodigo.livro;

public class LivroDTO {

	private Long id;
	private String titulo;

	public LivroDTO(Livro livro) {
		id = livro.getId();
		titulo = livro.getTitulo();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
}
