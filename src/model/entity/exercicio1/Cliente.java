package model.entity.exercicio1;

public class Cliente {

	private String nome;
	private int cpf;
	private int[] telefone;
	private Endereco endereco;

	public Cliente() {
		super();
	}

	public Cliente(String nome, int cpf, int[] telefone, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int[] getTelefone() {
		return telefone;
	}

	public void setTelefone(int[] telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
