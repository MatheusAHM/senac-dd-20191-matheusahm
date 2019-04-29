package model.entity.exercicio6.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	CadastroCliente cadastroCliente = null;
	ListarProduto listarProduto = null;
	ExcluirProduto excluirProduto = null;
	AlterarProduto alterarProduto = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					// Inicializa a tela principal MAXIMIZADA
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Principal.class.getResource("/model/entity/exercicio6/icons/icons8-gr\u00E1fico.png")));
		setTitle("Menu Cadastral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 700);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes
				.setIcon(new ImageIcon(Principal.class.getResource("/model/entity/exercicio6/icons/icons8-fila.png")));
		menuBar.add(mnClientes);

		JMenuItem cadastrarCliente = new JMenuItem("Cadastrar");
		cadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroCliente = new CadastroCliente();
				desktopPane.add(cadastroCliente);
				cadastroCliente.show();
			}
		});
		cadastrarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));

		cadastrarCliente.setIcon(new ImageIcon(Principal.class
				.getResource("/model/entity/exercicio6/icons/icons8-adicionar-usu\u00E1rio-masculino.png")));
		mnClientes.add(cadastrarCliente);

		JMenuItem listarCliente = new JMenuItem("Listar");
		listarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
		listarCliente.setIcon(
				new ImageIcon(Principal.class.getResource("/model/entity/exercicio6/icons/icons8-card\u00E1pio.png")));
		mnClientes.add(listarCliente);

		JMenuItem relatorioCliente = new JMenuItem("Relat\u00F3rio");
		relatorioCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK));
		relatorioCliente.setIcon(new ImageIcon(
				Principal.class.getResource("/model/entity/exercicio6/icons/icons8-documento-regular.png")));
		mnClientes.add(relatorioCliente);

		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setIcon(
				new ImageIcon(Principal.class.getResource("/model/entity/exercicio6/icons/icons8-comprar.png")));
		menuBar.add(mnProdutos);

		JMenuItem listarPr = new JMenuItem("Listar");
		listarPr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarProduto = new ListarProduto();
				desktopPane.add(listarPr);
				listarProduto.show();
			}
		});
		listarPr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.SHIFT_MASK));
		listarPr.setIcon(
				new ImageIcon(Principal.class.getResource("/model/entity/exercicio6/icons/icons8-card\u00E1pio.png")));
		mnProdutos.add(listarPr);

		JMenuItem exProduto = new JMenuItem("Excluir");
		exProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirProduto = new ExcluirProduto();
				desktopPane.add(excluirProduto);
				excluirProduto.show();
			}
		});
		exProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.SHIFT_MASK));
		exProduto.setIcon(new ImageIcon(Principal.class
				.getResource("/model/entity/exercicio6/icons/icons8-\u00E0-esquerda-dentro-de-um-c\u00EDrculo.png")));
		mnProdutos.add(exProduto);

		JMenuItem altProduto = new JMenuItem("Alterar");
		altProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarProduto = new AlterarProduto();
				desktopPane.add(alterarProduto);
				alterarProduto.show();
			}
		});
		altProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.SHIFT_MASK));
		altProduto.setIcon(new ImageIcon(
				Principal.class.getResource("/model/entity/exercicio6/icons/icons8-gr\u00E1fico-combinado.png")));
		mnProdutos.add(altProduto);

		JMenu mnFuncionarios = new JMenu("Funcion\u00E1rios");
		mnFuncionarios.setIcon(
				new ImageIcon(Principal.class.getResource("/model/entity/exercicio6/icons/icons8-treinamento.png")));
		menuBar.add(mnFuncionarios);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(Principal.class
				.getResource("/model/entity/exercicio6/icons/icons8-cart\u00E3o-de-cr\u00E9dito-sem-contato.png")));
		menuBar.add(mnSobre);

		JMenuItem manualSobre = new JMenuItem("Manual");
		manualSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		manualSobre.setIcon(new ImageIcon(Principal.class
				.getResource("/model/entity/exercicio6/icons/icons8-gerente-de-informa\u00E7\u00F5es-do-cliente.png")));
		mnSobre.add(manualSobre);

		JMenuItem ajudaSobre = new JMenuItem("Ajuda");
		ajudaSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAjuda a = new TelaAjuda();
				a.setVisible(true);
				if (a.isVisible() == true) {
					ajudaSobre.setEnabled(false);
				}
			}
		});
		ajudaSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
		ajudaSobre.setIcon(new ImageIcon(
				Principal.class.getResource("/model/entity/exercicio6/icons/icons8-suporte-on-line-filled.png")));
		mnSobre.add(ajudaSobre);

		JMenuItem autoresSobre = new JMenuItem("Autores");
		autoresSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSobre s = new TelaSobre();
				s.setVisible(true);
				if (s.isVisible() == true) {
					autoresSobre.setEnabled(false);
				}
			}
		});
		autoresSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		autoresSobre.setIcon(new ImageIcon(
				Principal.class.getResource("/model/entity/exercicio6/icons/icons8-\u0441harlie-\u0441haplin.png")));
		mnSobre.add(autoresSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[600.00,grow]", "[][519.00,grow]"));

		JLabel lblSistemaDeGerenciamentoDeVendas = new JLabel("Sistema de gerenciamento de vendas");
		contentPane.add(lblSistemaDeGerenciamentoDeVendas, "cell 0 0,alignx center");

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, "cell 0 1,grow");
	}
}
