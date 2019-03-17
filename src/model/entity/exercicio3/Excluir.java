package model.entity.exercicio3;

import javax.swing.JOptionPane;

public class Excluir {

	public void menuExcluir() {
		Pessoa p1 = new Pessoa(1, "Andre", "andre@andre.com", "123", "normal");
		Pessoa p2 = new Pessoa(2, "Marcia", "marcia@marcia.com.br", "123", "admin");
		Pessoa pessoas[] = { p1, p2 };

		int excluirId = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da pessoa para excluir"));

		for (int i = 0; i < pessoas.length; i++) {
			if (pessoas[i].getId() == excluirId) {
				int idselecionado = pessoas[i].getId();
				JOptionPane.showConfirmDialog(null,
						"id escolhido para exclusão: " + idselecionado + "\nvocê tem certeza?");

			}
		}
	}
}
