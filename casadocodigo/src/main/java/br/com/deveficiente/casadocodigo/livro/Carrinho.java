package br.com.deveficiente.casadocodigo.livro;

import java.util.HashSet;
import java.util.Set;

public class Carrinho {
	
	private int idCarrinho = 0;

	private Set<CarrinhoLivroDTO> livrosCarrinho = new HashSet<CarrinhoLivroDTO>();
	
	public void adicionarLivroNoCarrinho(Livro livro) {
		livrosCarrinho.add(new CarrinhoLivroDTO(livro));
	}
	
	public Carrinho() {
		idCarrinho++;
	}
	
	public Set<CarrinhoLivroDTO> getLivrosCarrinho() {
		return livrosCarrinho;
	}

	public int getIdCarrinho() {
		return idCarrinho;
	}

	@Override
	public String toString() {
		return "Carrinho [idCarrinho=" + idCarrinho + ", livrosCarrinho=" + livrosCarrinho + "]";
	}
}
