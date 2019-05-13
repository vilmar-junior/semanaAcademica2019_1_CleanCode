package entidade;

/**
 * Representa um livro na biblioteca.
 * 
 * @author Adriano de Melo
 * @author Vilmar César Pereira Júnior
 *
 */
public class Livro extends Obra {

	public Livro(String titulo, int edicao, int ano, Autor escritor) {
		super(titulo, edicao, ano, escritor);
	}
}