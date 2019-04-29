package model.entity.exercicio6.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ExcluirProduto extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirProduto frame = new ExcluirProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExcluirProduto() {
		setFrameIcon(new ImageIcon(ExcluirProduto.class
				.getResource("/model/entity/exercicio6/icons/icons8-\u00E0-esquerda-dentro-de-um-c\u00EDrculo.png")));
		setTitle("Exclus\u00E3o de Produto");
		setBounds(100, 100, 450, 189);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de barras do produto:");
		getContentPane().add(lblCdigoDeBarras, "cell 0 1,alignx trailing");

		textField = new JTextField();
		getContentPane().add(textField, "cell 1 1,growx");
		textField.setColumns(10);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnExcluir, "cell 1 3 1 2");

	}

}
