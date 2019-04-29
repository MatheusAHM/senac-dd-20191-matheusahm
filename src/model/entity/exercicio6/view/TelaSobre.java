package model.entity.exercicio6.view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class TelaSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
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
	public TelaSobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSobre.class
				.getResource("/model/entity/exercicio6/icons/icons8-cart\u00E3o-de-cr\u00E9dito-sem-contato.png")));
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 267, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][]", "[][][][][]"));

		JLabel lblNewLabel = new JLabel("Matheus");
		contentPane.add(lblNewLabel, "cell 1 1,alignx center");

		JLabel lblNewLabel_1 = new JLabel("Analise e desenvolvimento de sistemas");
		contentPane.add(lblNewLabel_1, "cell 1 2,alignx center");

		JLabel lblNewLabel_2 = new JLabel("28/04/2019");
		contentPane.add(lblNewLabel_2, "cell 1 3,alignx center");

		JLabel lblNewLabel_3 = new JLabel("Florian\u00F3polis");
		contentPane.add(lblNewLabel_3, "cell 1 4,alignx center");
	}

}
