package model.entity.exercicio5.view;

import javax.swing.JOptionPane;

public class Menu {

	public static final int OPCAO_MENU_CADASTRO = 1;
	public static final int OPCAO_MENU_EXCLUIR = 2;
	public static final int OPCAO_MENU_LISTAR = 3;

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.menuSelecao();
	}
	
	public void menuSelecao() {

		String selecao = "Cadastro de cliente: \n" + "------------------ \n" + "1 - Cadastrar \n" + "2 - Excluir \n" + "3 - Listar \n" + "------------------ \n" + " DIGITAR outro valor numerico para sair \n " + " ";

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
			ExcluirGUI.main(null);
			break;
		}
		case OPCAO_MENU_LISTAR: {
			ListagemGUI.main(null);
			break;
		}
		}

	}

}