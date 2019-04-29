package model.entity.exercicio6.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class TelaAjuda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAjuda frame = new TelaAjuda();
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
	public TelaAjuda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaAjuda.class.getResource("/model/entity/exercicio6/icons/icons8-suporte-on-line-filled.png")));
		setTitle("Ajuda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 195);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow]", "[][][][grow][grow]"));

		JLabel lblFavorNo = new JLabel("1. Favor n\u00E3o trolar o programa");
		contentPane.add(lblFavorNo, "cell 3 1");

		JLabel lblUsarDireitinho = new JLabel("2. Usar direitinho");
		contentPane.add(lblUsarDireitinho, "cell 3 2");

		JTextPane txtpnHttpssupportmicrosoftcomptbr = new JTextPane();
		txtpnHttpssupportmicrosoftcomptbr.setEditable(false);
		txtpnHttpssupportmicrosoftcomptbr.setText("https://support.microsoft.com/pt-br");
		contentPane.add(txtpnHttpssupportmicrosoftcomptbr, "cell 3 3,grow");
	}

}