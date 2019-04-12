package model.entity.exercicio4.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.entity.exercicio4.controller.ControladoraPessoa;
import model.entity.exercicio4.model.vo.NivelVO;
import model.entity.exercicio4.model.vo.PessoaVO;


public class ListagemGUI {

	private JFrame frmConsultaDeSobremesas;
	private JTable tblSobremesas;
	private JButton button;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListagemGUI window = new ListagemGUI();
					window.frmConsultaDeSobremesas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListagemGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaDeSobremesas = new JFrame();
		frmConsultaDeSobremesas.setTitle("Consulta de sobremesas");
		frmConsultaDeSobremesas.setBounds(100, 100, 520, 390);
		frmConsultaDeSobremesas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultaDeSobremesas.getContentPane().setLayout(null);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Consultar a lista de sobremesas
				ControladoraPessoa controle = new ControladoraPessoa();
				ArrayList<PessoaVO> pessoas = controle.listarPessoaVOController();
				
				//Atualizar a tabela;
				atualizarTabela(pessoas);
			}
		});
		btnPesquisar.setBounds(10, 10, 280, 25);
		frmConsultaDeSobremesas.getContentPane().add(btnPesquisar);
		
		tblSobremesas = new JTable();
		limparTabela();
		
		tblSobremesas.setBounds(10, 46, 485, 295);
		frmConsultaDeSobremesas.getContentPane().add(tblSobremesas);
		
		button = new JButton("Pesquisar");
		button.setBounds(60, 80, 280, 25);
		frmConsultaDeSobremesas.getContentPane().add(button);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTabela();
			}
		});
		btnLimpar.setBounds(290, 10, 205, 25);
		frmConsultaDeSobremesas.getContentPane().add(btnLimpar);
	}

	protected void atualizarTabela(ArrayList<PessoaVO> pessoas) {
		//Limpa a tabela
		limparTabela();
		
		//Obtém o model da tabela
		DefaultTableModel model = (DefaultTableModel) tblSobremesas.getModel();
		
		//Percorre as sobremesas para adicionar linha a linha na tabela (JTable)
		for(PessoaVO pessoaVO: pessoas) {
			String[] novaLinha = new String[4];
			novaLinha[0] = pessoaVO.getId() +"";
			novaLinha[1] = pessoaVO.getNome();
			novaLinha[2] = pessoaVO.getEmail();
			//Adiciona a nova linha na tabela
			model.addRow(novaLinha);
		}
	}

	private void limparTabela() {
		tblSobremesas.setModel(new DefaultTableModel(
				new Object[][] {
					{"id", "Nome", "Email"},
				},
				new String[] {
					"id", "Nome", "Email"}
			));
	}
}