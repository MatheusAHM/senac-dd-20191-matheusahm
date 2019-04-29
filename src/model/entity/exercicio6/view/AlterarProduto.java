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

public class AlterarProduto extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarProduto frame = new AlterarProduto();
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
	public AlterarProduto() {
		setFrameIcon(new ImageIcon(
				AlterarProduto.class.getResource("/model/entity/exercicio6/icons/icons8-gr\u00E1fico-combinado.png")));
		setTitle("Alterac\u00E3o de produto");
		setBounds(100, 100, 272, 222);
		getContentPane().setLayout(new MigLayout("", "[][174.00]", "[10px][][10px][][10px][][][]"));

		JLabel lblNome = new JLabel("Nome:");
		getContentPane().add(lblNome, "flowx,cell 1 1");

		textField = new JTextField();
		getContentPane().add(textField, "cell 1 1,growx");
		textField.setColumns(10);

		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		getContentPane().add(lblPreco, "flowx,cell 1 3");

		textField_1 = new JTextField();
		getContentPane().add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("C\u00F3digo P/:");
		getContentPane().add(lblNewLabel, "flowx,cell 1 5");

		textField_2 = new JTextField();
		getContentPane().add(textField_2, "cell 1 5,growx");
		textField_2.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		getContentPane().add(btnSalvar, "cell 1 7,growx");

	}

}
