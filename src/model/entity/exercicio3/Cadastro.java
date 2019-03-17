package model.entity.exercicio3;

import javax.swing.JOptionPane;

public class Cadastro {

	public void menuCadastro() {
		String nome = "Digitar nome";
		String email = "Digitar email";
		String senha = "Digitar senha";
		String nivel = "1 - admin OU 2 - normal";

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(JOptionPane.showInputDialog(nome));
		pessoa.setEmail(JOptionPane.showInputDialog(email));
		pessoa.setSenha(JOptionPane.showInputDialog(senha));
		pessoa.setNivel(JOptionPane.showInputDialog(nivel));
		JOptionPane.showMessageDialog(null, pessoa.toString());
		
	}

}
