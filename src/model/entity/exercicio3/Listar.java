package model.entity.exercicio3;

import javax.swing.JOptionPane;

public class Listar {

	public void menuListar() {

		Pessoa p1 = new Pessoa(1, "Andre", "andre@andre.com", "123", "normal");
		Pessoa p2 = new Pessoa(2, "Marcia", "marcia@marcia.com.br", "123", "admin");
		Pessoa pessoas[] = { p1, p2 };

		String listaPessoas = "Lista de pessoas cadastradas:\n ________________________\n";
		for (int i = 0; i < pessoas.length; i++) {
			listaPessoas = listaPessoas + pessoas[i].toString() + "\n________________________\n";

		}

		JOptionPane.showMessageDialog(null, listaPessoas);

	}
}
