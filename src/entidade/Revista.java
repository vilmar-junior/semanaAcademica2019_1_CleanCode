package entidade;

/**
 * Representa uma revista na biblioteca.
 * 
 * @author Adriano de Melo
 * @author Vilmar César Pereira Júnior
 *
 */
public class Revista extends Obra {

	private int periodicidadePublicacao;

	public Revista(String titulo, int edicao, int ano, Autor escritor, int periodicidadePublicacao) {
		super(titulo, edicao, ano, escritor);
		this.periodicidadePublicacao = periodicidadePublicacao;
	}

	public int getPeriodicidadePublicacao() {
		return periodicidadePublicacao;
	}

	public void setPeriodicidadePublicacao(int periodicidadePublicacao) {
		this.periodicidadePublicacao = periodicidadePublicacao;
	}

	@Override
	public String toString() {
		return "\nTítulo: " + this.getTitulo() + "\n" + "Edição: " + this.getEdicao() + "\n" + "Ano: " + this.getAno()
				+ "\n" + "Escritor(a): \n" + this.getEscritor().toString() + "\n" + "Periodicidade: "
				+ this.getPeriodicidadePublicacao() + " dias \n";
	}
}