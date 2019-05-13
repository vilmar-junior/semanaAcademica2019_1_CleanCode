package entidade;

import java.time.LocalDate;
import java.time.Period;

/**
 * Representa o autor de uma obra.
 * 
 * @author Adriano de Melo
 * @author Vilmar César Pereira Júnior
 *
 */
public class Autor {

	private String nome;
	private LocalDate dataNascimento;
	private Endereco enderecoAutor;

	public Autor() {
		super();
	}

	public Autor(String nome, LocalDate dataNascimento, Endereco enderecoAutor) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.enderecoAutor = enderecoAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEnderecoAutor() {
		return enderecoAutor;
	}

	public void setEnderecoAutor(Endereco enderecoAutor) {
		this.enderecoAutor = enderecoAutor;
	}

	public int calcularIdade() {
		LocalDate dataAtual = LocalDate.now();
		return Period.between(this.getDataNascimento(), dataAtual).getYears();
	}

	public String toString() {
		return "Nome: " + this.getNome() + "\n" + "Data de nascimento: " + this.getDataNascimento() + "\n"
				+ this.getEnderecoAutor();
	}
}