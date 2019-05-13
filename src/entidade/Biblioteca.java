package entidade;

import java.util.ArrayList;

import excecao.BibliotecaException;

/**
 * Representa uma biblioteca.
 * 
 * @author Adriano de Melo
 * @author Vilmar César Pereira Júnior
 *
 */
public class Biblioteca {

	private String nome;
	private ArrayList<Obra> obras;
	private Endereco enderecoBiblioteca;

	public Biblioteca() {
		super();
	}

	public Biblioteca(String nome, ArrayList<Obra> obras, Endereco enderecoBiblioteca) {
		super();
		this.nome = nome;
		this.obras = obras;
		this.enderecoBiblioteca = enderecoBiblioteca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Obra> getObras() {
		return obras;
	}

	public void setObras(ArrayList<Obra> obras) {
		this.obras = obras;
	}

	public Endereco getEnderecoBiblioteca() {
		return enderecoBiblioteca;
	}

	public void setEnderecoBiblioteca(Endereco enderecoBiblioteca) {
		this.enderecoBiblioteca = enderecoBiblioteca;
	}

	public void calcularQuantidadeObras() {

		System.out.println("A biblioteca possui " + this.getObras().size() + " obras.\n");
	}

	public void identificarObraMaisAntiga() throws BibliotecaException {

		if (this.getObras() != null && !this.getObras().isEmpty()) {
			int indice = -1;
			int maiorAno = this.getObras().get(0).getAno();
			for (int i = 0; i < this.getObras().size(); i++) {
				if (this.getObras().get(i).getAno() < maiorAno) {
					maiorAno = this.getObras().get(i).getAno();
					indice = i;
				}
			}
			System.out.println("A Obra mais antiga é: " + this.getObras().get(indice).toString());
		} else {
			throw new BibliotecaException("Biblioteca está sem obras!");
		}
	}

	public void identificarAutorMaisNovo() throws BibliotecaException {
		if (this.getObras() != null && !this.getObras().isEmpty()) {
			int indice = 0;
			int menorIdade = this.getObras().get(0).getEscritor().calcularIdade();
			for (int i = 1; i < this.getObras().size(); i++) {
				if (this.getObras().get(i).getEscritor().calcularIdade() < menorIdade) {
					menorIdade = this.getObras().get(i).getEscritor().calcularIdade();
					indice = i;
				}
			}
			System.out.println("O Autor mais novo: \n" + this.getObras().get(indice).getEscritor().toString());
		} else {
			throw new BibliotecaException("Biblioteca está sem obras!");
		}
	}

	public void identificarEnderecoAutor(String nome) {
		for (int i = 0; i < this.getObras().size(); i++) {
			if (this.getObras().get(i).getEscritor().getNome().equalsIgnoreCase(nome)) {
				System.out.println("O endereço do Autor é: \n"
						+ this.getObras().get(i).getEscritor().getEnderecoAutor().toString());
				break;
			}
		}
	}
}