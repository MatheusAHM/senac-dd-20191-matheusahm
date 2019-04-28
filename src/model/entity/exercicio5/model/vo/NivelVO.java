package model.entity.exercicio5.model.vo;

public class NivelVO {

	private int id;
	private String descricao;

	public NivelVO(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public NivelVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Método reescrito com o objetivo de mostrar um texto agradável
	 * no combobox na tela.
	 */
	
	@Override
	public String toString() {
		return this.descricao + " (" + this.id + ")";
	}
}