package model.entity.exercicio4.view;

import javax.swing.JOptionPane;

public class Menu {

	public static final int OPCAO_MENU_CADASTRO = 1;
	public static final int OPCAO_MENU_EXCLUIR = 2;
	public static final int OPCAO_MENU_LISTAR = 3;

	public void menuSelecao() {

		String selecao = "Cadastro de cliente: \n" + "1 - Cadastrar \n" + "2 - Excluir \n" + "3 - Listar todos";

		String opcaoSelecao = JOptionPane.showInputDialog(selecao);

		try {
			int opcao = Integer.parseInt(opcaoSelecao);
			escolhaTela(opcao);
		} catch (NumberFormatException nExp) {
			JOptionPane.showMessageDialog(null, "Informe uma opção valida");
			menuSelecao();
		}
	}

	private static void escolhaTela(int opcao) {
		switch (opcao) {
		case OPCAO_MENU_CADASTRO: {
			CadastroGUI.main(null);
			break;
		}
		case OPCAO_MENU_EXCLUIR: {
			
			break;
		}
		case OPCAO_MENU_LISTAR: {
			
			break;
		}
		}

	}

}