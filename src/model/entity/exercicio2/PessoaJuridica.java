package model.entity.exercicio2;

public class PessoaJuridica extends Cliente {

	private String cnpj;
	
	public PessoaJuridica (String nome, Date dataNascimento, Cidade cidade, Double saldo, String cnpj) {
		super(nome, dataNascimento, cidade, saldo);
		this.cnpj = cnpj;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
