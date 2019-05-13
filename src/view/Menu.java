package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import entidade.Autor;
import entidade.Biblioteca;
import entidade.Endereco;
import entidade.Livro;
import entidade.Obra;
import entidade.Revista;
import excecao.BibliotecaException;

/**
 * Representa o menu principal da aplicação Biblioteca.
 * 
 * @author Adriano de Melo
 * @author Vilmar César Pereira Júnior
 *
 */
public class Menu {
	// Constantes com as opcoes de menu
	private static final int OPCAO_MENU_CADASTRAR_LIVRO = 1;
	private static final int OPCAO_MENU_CADASTRAR_REVISTA = 2;
	private static final int OPCAO_MENU_CALCULAR_QUANTIDADE_OBRAS = 3;
	private static final int OPCAO_MENU_IDENTIFICAR_OBRA_MAIS_ANTIGA = 4;
	private static final int OPCAO_MENU_IDENTIFICAR_AUTOR_MAIS_NOVO = 5;
	private static final int OPCAO_MENU_SAIR = 6;

	// Atributos
	private Scanner teclado = new Scanner(System.in);
	private Biblioteca biblio = criarBiblioteca();

	public void apresentarMenu() {

		this.mostrarOpcoesMenu();

		int opcao = Integer.parseInt(teclado.next());
		while (opcao != OPCAO_MENU_SAIR) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_LIVRO: {
				try {
					Livro novoLivro = cadastrarLivro();
					cadastrarObra(novoLivro);
				} catch (BibliotecaException e) {
					System.out.println("Deu erro! Causa: " + e.getMessage() + "\n");
				}

				break;
			}
			case OPCAO_MENU_CADASTRAR_REVISTA: {
				try {
					Revista novaRevista = cadastrarRevista();
					cadastrarObra(novaRevista);
				} catch (BibliotecaException e) {
					System.out.println("Deu erro! Causa: " + e.getMessage() + "\n");
				}

				break;
			}
			case OPCAO_MENU_CALCULAR_QUANTIDADE_OBRAS: {
				biblio.calcularQuantidadeObras();
				break;
			}
			case OPCAO_MENU_IDENTIFICAR_OBRA_MAIS_ANTIGA: {
				try {
					biblio.identificarObraMaisAntiga();
				} catch (BibliotecaException e) {
					System.out.println("Deu erro! Causa: " + e.getMessage() + "\n");
				}
				break;
			}
			case OPCAO_MENU_IDENTIFICAR_AUTOR_MAIS_NOVO: {
				try {
					biblio.identificarAutorMaisNovo();
				} catch (BibliotecaException e) {
					System.out.println("Deu erro! Causa: " + e.getMessage() + "\n");
				}
				break;
			}
			default: {
				System.out.println("\nOpção Inválida");
			}
			}
			this.mostrarOpcoesMenu();

			opcao = Integer.parseInt(teclado.next());
		}
	}

	/**
	 * Gera as opções do menu da aplicação.
	 */
	private void mostrarOpcoesMenu() {
		System.out.println("Biblioteca");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CADASTRAR_LIVRO + " - Cadastrar livro");
		System.out.println(OPCAO_MENU_CADASTRAR_REVISTA + " - Cadastrar revista");
		System.out.println(OPCAO_MENU_CALCULAR_QUANTIDADE_OBRAS + " - Calcular quantidade de obras");
		System.out.println(OPCAO_MENU_IDENTIFICAR_OBRA_MAIS_ANTIGA + " - Identificar a obra mais antiga");
		System.out.println(OPCAO_MENU_IDENTIFICAR_AUTOR_MAIS_NOVO + " - Identificar o autor mais novo");
		System.out.println(OPCAO_MENU_SAIR + " - Sair");
		System.out.print("\nDigite a Opção: ");
	}

	private Revista cadastrarRevista() throws BibliotecaException {
		teclado.nextLine();

		Revista novaRevista = null;
		int edicao = -1;
		int ano = -1;
		int periodicidadePublicacao = -1;

		System.out.print("\nDigite o título da revista: ");
		String titulo = teclado.nextLine();

		try {
			System.out.print("\nDigite o número da edição da revista: ");
			edicao = Integer.parseInt(teclado.nextLine());

			System.out.print("\nDigite o ano da revista: ");
			ano = Integer.parseInt(teclado.nextLine());

			System.out.print("\nDigite a periodicidade de publicação da revista (em dias): ");
			periodicidadePublicacao = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException e) {
			throw new BibliotecaException("'Edição', 'Ano' e 'Periodicidade' da revista devem ser valores INTEIROS.",
					e);
		}

		Autor autor = cadastrarAutor();

		novaRevista = new Revista(titulo, edicao, ano, autor, periodicidadePublicacao);
		return novaRevista;
	}

	private Livro cadastrarLivro() throws BibliotecaException {
		teclado.nextLine();

		Livro novoLivro = null;
		int edicao = -1;
		int ano = -1;

		System.out.print("\nDigite o título do livro: ");
		String titulo = teclado.nextLine();

		try {
			System.out.print("\nDigite o número da edição do livro: ");
			edicao = Integer.parseInt(teclado.nextLine());

			System.out.print("\nDigite o ano do livro: ");
			ano = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException e) {
			throw new BibliotecaException("'Edição' e 'Ano' do livro devem ser valores INTEIROS. \nCausa: ", e);
		}

		Autor autor = cadastrarAutor();

		novoLivro = new Livro(titulo, edicao, ano, autor);
		return novoLivro;
	}

	private Autor cadastrarAutor() throws BibliotecaException {
		Autor novoAutor = null;
		LocalDate dataNascimento = null;

		System.out.print("\nDigite o nome completo do autor: ");
		String nome = teclado.nextLine();

		try {
			System.out.print("\nDigite a data de nascimento do autor (dd/mm/aaaa): ");
			String anoDigitado = teclado.nextLine();

			DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dataNascimento = LocalDate.parse(anoDigitado, formatadorData);
		} catch (DateTimeParseException e) {
			throw new BibliotecaException("'Data de nascimento' deve ser informada no padrão (dd/mm/aaaa).", e);
		}

		Endereco endereco = cadastrarEndereco();

		novoAutor = new Autor(nome, dataNascimento, endereco);
		return novoAutor;
	}

	private Endereco cadastrarEndereco() throws BibliotecaException {
		int numero = -1;

		System.out.print("\nDigite o nome da rua do endereço do autor: ");
		String rua = teclado.nextLine();

		try {
			System.out.print("\nDigite o número da casa do endereço do autor: ");
			numero = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException e) {
			throw new BibliotecaException("'Número' da casa deve ser um valor INTEIROS.", e);
		}

		System.out.print("\nDigite o nome do bairro do endereço do autor: ");
		String bairro = teclado.nextLine();

		System.out.print("\nDigite o nome da cidade do endereço do autor: ");
		String cidade = teclado.nextLine();

		System.out.print("\nDigite o nome do estado do endereço do autor: ");
		String estado = teclado.nextLine();

		return new Endereco(rua, numero, bairro, cidade, estado);
	}

	private void cadastrarObra(Obra novaObra) {
		if (novaObra != null && biblio != null && biblio.getObras() != null) {
			biblio.getObras().add(novaObra);
		}
	}

	private static Biblioteca criarBiblioteca() {
		// Endereços Autores
		Endereco end1 = new Endereco("Rua dos Figos", 100, "Ingleses", "Florianopolis", "Santa Catarina");
		Endereco end2 = new Endereco("Rua das Laranjas", 200, "Aririú", "Palhoca", "Santa Catarina");
		Endereco end3 = new Endereco("Rua das Uvas", 300, "Pedra Branca", "Palhoca", "Santa Catarina");
		Endereco end4 = new Endereco("Rua das Melancias", 400, "Estreito", "Florianopolis", "Santa Catarina");

		// Endereço da Biblioteca
		Endereco end5 = new Endereco("Rua das Mangas", 600, "Centro", "Florianopolis", "Santa Catarina");

		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Escritores
		Autor autor1 = new Autor("Carlos Drummond", LocalDate.parse("31/10/1902", formatadorData), end1);
		Autor autor2 = new Autor("Machado de Assis", LocalDate.parse("21/06/1839", formatadorData), end2);
		Autor autor3 = new Autor("Cecilia Meireles", LocalDate.parse("07/11/1901", formatadorData), end3);
		Autor autor4 = new Autor("Oswald Andrade", LocalDate.parse("11/01/1890", formatadorData), end4);

		// Revistas
		Revista rev1 = new Revista("Veja", 60, 2012, autor1, 15);
		Revista rev2 = new Revista("Istoé", 80, 2013, autor2, 30);
		Revista rev3 = new Revista("Auto-Esporte", 20, 2011, autor3, 30);
		Revista rev4 = new Revista("Super Interessante", 100, 2010, autor4, 30);

		// Livros
		Livro livro1 = new Livro("Brejo das Almas", 8, 1983, autor1);
		Livro livro2 = new Livro("Quincas Borba", 1, 1892, autor2);
		Livro livro3 = new Livro("Colar de Carolina", 3, 1934, autor3);
		Livro livro4 = new Livro("Os Condenados", 7, 1941, autor4);

		ArrayList<Obra> obras = new ArrayList<Obra>();// { rev1, rev2, rev3, rev4, livro1, livro2, livro3, livro4 };
		obras.add(rev1);
		obras.add(rev2);
		obras.add(rev3);
		obras.add(rev4);
		obras.add(livro1);
		obras.add(livro2);
		obras.add(livro3);
		obras.add(livro4);

		// Biblioteca
		Biblioteca biblio = new Biblioteca("Biblioteca Central", obras, end5);

		return biblio;
	}
}