package model.entity.exercicio5.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.entity.exercicio4.controller.ControladoraPessoa;
import model.entity.exercicio4.model.bo.NivelBO;
import model.entity.exercicio4.model.vo.NivelVO;
import net.miginfocom.swing.MigLayout;

/**
 * 
 * Tela de cadastro de usuários (item 1a da Atividade 4)
 * 
 * @author Vilmar César Pereira Júnior
 *
 */
public class CadastroGUI {

	private JFrame frmCadastroDeUsuarios;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JComboBox cbNivel;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmacaoSenha;
	private List<NivelVO> niveis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroGUI window = new CadastroGUI();
					window.frmCadastroDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// TODO consultar os níveis no banco (criei na mão aqui :D)
		consultarNiveis(); // TODO alterar esta chamada AQUI

		frmCadastroDeUsuarios = new JFrame();
		frmCadastroDeUsuarios.setTitle("Cadastro de usuários");
		frmCadastroDeUsuarios.setBounds(100, 100, 640, 480);
		frmCadastroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeUsuarios.getContentPane().setLayout(new MigLayout("", "[16.00][225.00px][39.00px][318.00px]",
				"[28px][28px][28px][28px][28px][35px][][][][][][][48.00]"));

		JLabel lblNome = new JLabel("Nome:");
		frmCadastroDeUsuarios.getContentPane().add(lblNome, "flowx,cell 1 1,alignx left,aligny center");

		JLabel lblEmail = new JLabel("Email:");
		frmCadastroDeUsuarios.getContentPane().add(lblEmail, "flowx,cell 3 1,alignx left,aligny center");

		txtEmail = new JTextField();
		frmCadastroDeUsuarios.getContentPane().add(txtEmail, "cell 3 1,grow");
		txtEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		frmCadastroDeUsuarios.getContentPane().add(lblSenha, "cell 1 3,alignx left,aligny center");

		pfSenha = new JPasswordField();
		frmCadastroDeUsuarios.getContentPane().add(pfSenha, "cell 1 3,grow");

		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				// 1 - Ler os valores digitados nos campos da tela

				// 2 - Chamar o método salvar(...) de UsuarioController, passando os valores
				// digitados

				// 3 - Mostrar a mensagem devolvida por UsuarioController na tela, por exemplo
				// com JOptionPane

				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String senha = pfSenha.getText();
				NivelVO nivel = (NivelVO) cbNivel.getSelectedItem();
				String senhaConfirmacao = pfConfirmacaoSenha.getText();

				ControladoraPessoa controladoraPessoa = new ControladoraPessoa();
				String mensagem = controladoraPessoa.cadastarPessoaVOController(nome, email, senha, nivel,
						senhaConfirmacao);
				JOptionPane.showMessageDialog(null, mensagem);

			}
		});

		JLabel lblConfirmaoDeSenha = new JLabel("Confirmação:");
		lblConfirmaoDeSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		frmCadastroDeUsuarios.getContentPane().add(lblConfirmaoDeSenha, "flowx,cell 3 3,alignx left,aligny center");

		JLabel lblNivel = new JLabel("Nível:");
		frmCadastroDeUsuarios.getContentPane().add(lblNivel, "flowx,cell 1 5,alignx left,aligny center");
		frmCadastroDeUsuarios.getContentPane().add(button, "cell 1 11 1 2,grow");

		txtNome = new JTextField();
		frmCadastroDeUsuarios.getContentPane().add(txtNome, "cell 1 1,grow");
		txtNome.setColumns(10);

		pfConfirmacaoSenha = new JPasswordField();
		frmCadastroDeUsuarios.getContentPane().add(pfConfirmacaoSenha, "cell 3 3,grow");

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtEmail.setText("");
				pfSenha.setText("");
				pfConfirmacaoSenha.setText("");
				cbNivel.setSelectedIndex(-1);
			}
		});
		frmCadastroDeUsuarios.getContentPane().add(btnLimpar, "cell 3 11 1 2,grow");

		// Novo componente: Combobox
		cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(niveis.toArray()));

		// Inicia sem nada selecionado no combo
		cbNivel.setSelectedIndex(-1);
		frmCadastroDeUsuarios.getContentPane().add(cbNivel, "cell 1 5,growx");
	}

	private void consultarNiveis() {

		NivelBO nivelBO = new NivelBO();

		niveis = new ArrayList<NivelVO>();
		niveis = nivelBO.consultarNivelBO();
	}
}