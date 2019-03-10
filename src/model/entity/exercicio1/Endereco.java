package model.entity.exercicio1;

public class Endereco {

	private String rua;
	private int cep;
	private String cidade;
	private String estado;

	public Endereco() {
		super();
	}

	public Endereco(String rua, int cep, String cidade, String estado) {
		super();
		this.rua = rua;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
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

}
