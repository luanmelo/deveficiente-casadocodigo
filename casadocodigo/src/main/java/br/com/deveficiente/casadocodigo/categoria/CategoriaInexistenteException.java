package br.com.deveficiente.casadocodigo.categoria;

public class CategoriaInexistenteException extends RuntimeException {

	private static final long serialVersionUID = 2335659439775542280L;

	public CategoriaInexistenteException(String msg) {
		super(msg);
	}

}
