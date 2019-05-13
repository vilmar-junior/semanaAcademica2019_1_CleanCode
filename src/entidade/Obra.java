package entidade;

/**
 * Representa uma obra na biblioteca.
 * 
 * Classe abstrata, logo não pode instanciar objetos.
 * 
 * @author Adriano de Melo
 * @author Vilmar César Pereira Júnior
 *
 */
public abstract class Obra {

	private String titulo;
	private int edicao;
	private int ano;
	private Autor escritor;

	public Obra(String titulo, int edicao, int ano, Autor escritor) {
		super();
		this.titulo = titulo;
		this.edicao = edicao;
		this.ano = ano;
		this.escritor = escritor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Autor getEscritor() {
		return escritor;
	}

	public void setEscritor(Autor escritor) {
		this.escritor = escritor;
	}

	@Override
	public String toString() {
		return "\nTítulo: " + this.getTitulo() + "\n" + "Edição: " + this.getEdicao() + "\n" + "Ano: " + this.getAno()
				+ "\n" + "Escritor(a): \n" + this.getEscritor().toString();
	}
}