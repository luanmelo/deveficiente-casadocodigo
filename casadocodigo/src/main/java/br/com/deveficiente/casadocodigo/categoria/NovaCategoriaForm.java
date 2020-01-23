package br.com.deveficiente.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaForm {

	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria novaCategoria() {
		return new Categoria(nome);
	}
}
