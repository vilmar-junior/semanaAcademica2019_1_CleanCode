package entidade;

/**
 * Representa o endereço de um autor ou uma biblioteca.
 * 
 * @author Adriano de Melo
 * @author Vilmar César Pereira Júnior
 *
 */
public class Endereco {

	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;

	public Endereco(String rua, int numero, String bairro, String cidade, String estado) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String toString() {
		return "Endereço: \n" + "Rua: " + this.getRua() + ", número: " + this.getNumero() + ".\n" + "Bairro: "
				+ this.getBairro() + "\n" + "Cidade: " + this.getCidade() + "\n" + "Estado: " + this.getEstado() + "\n";
	}
}
