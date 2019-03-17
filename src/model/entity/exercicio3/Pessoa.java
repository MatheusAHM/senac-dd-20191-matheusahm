package model.entity.exercicio3;

public class Pessoa {

	private int id;
	private String nome;
	private String email;
	private String senha;
	private String nivel;

	public Pessoa(int id, String nome, String email, String senha, String nivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nivel = nivel;
	}

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Id: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nSenha: " + senha + "\nNivel: " + nivel;
	}

}
