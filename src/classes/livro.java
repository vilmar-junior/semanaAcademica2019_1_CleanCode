package classes;

/**
 * Representa um livro na biblioteca.
 * 
 * @author Adriano de Melo
 * @author Vilmar César Pereira Júnior
 *
 */
public class livro extends Obra {

	public livro(String titulo, int edicao, int ano, Autor escritor) {
		super(titulo, edicao, ano, escritor);
	}
}