package model.entity.exercicio4.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entity.exercicio4.controller.ControladoraPessoa;
import model.entity.exercicio4.model.bo.PessoaBO;
import model.entity.exercicio4.model.vo.PessoaVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ExcluirGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private List<PessoaVO> pessoaVO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirGUI frame = new ExcluirGUI();
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
	public ExcluirGUI() {
		
		consultarPessoaVO();
		
		setTitle("Tela de exclus\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSelecionarCampoPara = new JLabel("Selecionar campo para exclus\u00E3o:");
		lblSelecionarCampoPara.setBounds(45, 35, 172, 14);
		contentPane.add(lblSelecionarCampoPara);

		JComboBox cbxPessoaVO = new JComboBox();
		cbxPessoaVO.setModel(new DefaultComboBoxModel (pessoaVO.toArray()));
		
		cbxPessoaVO.setSelectedIndex(-1);
		
		cbxPessoaVO.setBounds(55, 60, 342, 20);
		contentPane.add(cbxPessoaVO);

		JLabel lblAcessoDeAdmin = new JLabel("Acesso de ADMIN para habilitar exclus\u00E3o");
		lblAcessoDeAdmin.setBounds(45, 111, 275, 14);
		contentPane.add(lblAcessoDeAdmin);

		textField = new JTextField();
		textField.setBounds(92, 136, 305, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(55, 139, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(55, 167, 46, 14);
		contentPane.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(102, 167, 295, 20);
		contentPane.add(passwordField);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mensagem = "";
				
				ControladoraPessoa controladoraPessoa = new ControladoraPessoa();
				
				String email = textField.getText();
				String senha = lblSenha.getText();
				if(controladoraPessoa.validarPessoaVO(email,senha) == "") {
					controladoraPessoa.excluirPessoaVOController((PessoaVO) cbxPessoaVO.getSelectedItem());
					mensagem = "Usuario excuido com sucesso";
				}else {
					mensagem = controladoraPessoa.validarPessoaVO(email,senha);
				}
				JOptionPane.showMessageDialog(null, mensagem);
				
			}
		});
		btnExcluir.setBounds(179, 227, 89, 23);
		contentPane.add(btnExcluir);
	}

	private void consultarPessoaVO() {
		// TODO Auto-generated method stub
		PessoaBO pessoaBO = new PessoaBO();
		
		pessoaVO = new ArrayList<PessoaVO>();
		pessoaVO = pessoaBO.consultarPessoasBO();
	}
}
