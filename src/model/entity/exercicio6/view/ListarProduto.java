package model.entity.exercicio6.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

public class ListarProduto extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProduto frame = new ListarProduto();
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
	public ListarProduto() {
		setTitle("Lista de Produtos");
		setFrameIcon(new ImageIcon(
				ListarProduto.class.getResource("/model/entity/exercicio6/icons/icons8-card\u00E1pio.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[][5px][grow]"));

		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JLabel lblFiltro = new JLabel("Filtragem:");
		getContentPane().add(lblFiltro, "flowx,cell 0 0");

		JComboBox comboBox = new JComboBox();
		getContentPane().add(comboBox, "cell 0 0,growx");

		JButton btnListarPorF = new JButton("Listar por F/");
		getContentPane().add(btnListarPorF, "cell 0 0");
		getContentPane().add(btnListarTodos, "cell 0 0");

		table = new JTable();
		getContentPane().add(table, "cell 0 2,grow");

	}

}
