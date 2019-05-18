package classes;

import java.time.LocalDate;
import java.time.Period;
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
	private ArrayList<Obra> lista;
	private End enderecoBiblioteca;

	public Biblioteca() {
		super();
	}

	public Biblioteca(String nome, ArrayList<Obra> lista, End enderecoBiblioteca) {
		super();
		this.nome = nome;
		this.lista = lista;
		this.enderecoBiblioteca = enderecoBiblioteca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Obra> getObras() {
		return lista;
	}

	public void setObras(ArrayList<Obra> obras) {
		this.lista = obras;
	}

	public End getEnderecoBiblioteca() {
		return enderecoBiblioteca;
	}

	public void setEnderecoBiblioteca(End enderecoBiblioteca) {
		this.enderecoBiblioteca = enderecoBiblioteca;
	}

	public void calcularQuantidadeObras() {
		System.out.println("A biblioteca possui " + this.getObras().size() + " obras.\n");
	}

	public void MaisAntiga() throws BibliotecaException {
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

	public void maisNovo() throws BibliotecaException {
		if (this.getObras() != null && !this.getObras().isEmpty()) {
			int indice = 0;
			Obra obraAtual = this.getObras().get(0);

			// Calcula a idade do autor
			LocalDate dataAtual = LocalDate.now();
			int menorIdade = Period.between(obraAtual.getEscritor().getDataNascimento(), dataAtual).getYears();

			for (int i = 1; i < this.getObras().size(); i++) {
				obraAtual = this.getObras().get(i);

				// Calcula a idade do autor
				int idadeAutorAtual = Period.between(obraAtual.getEscritor().getDataNascimento(), dataAtual).getYears();

				if (idadeAutorAtual < menorIdade) {
					// Calcula a idade do autor e atribui como a menor
					menorIdade = Period.between(obraAtual.getEscritor().getDataNascimento(), dataAtual).getYears();
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