package excecao;

public class BibliotecaException extends Exception {

	private static final long serialVersionUID = 268949789374138991L;

	public BibliotecaException(String mensagem) {
		super(mensagem);
	}

	public BibliotecaException(String mensagem, Exception ex) {
		super(mensagem, ex);
	}
}