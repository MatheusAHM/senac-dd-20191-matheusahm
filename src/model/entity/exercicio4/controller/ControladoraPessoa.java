package model.entity.exercicio4.controller;

import java.util.ArrayList;

import model.entity.exercicio4.model.bo.PessoaBO;
import model.entity.exercicio4.model.dao.PessoaDAO;
import model.entity.exercicio4.model.vo.NivelVO;
import model.entity.exercicio4.model.vo.PessoaVO;

public class ControladoraPessoa {

	public String cadastarPessoaVOController(String nome, String email, String senha, NivelVO nivel, String confirmarSenha) {

		String mensagem = "";

		if (this.validar(nome)) {
		
		}
		if (this.validar(email)) {
			
		}
		if (this.validar(senha)) {
	}
		
		PessoaBO pessoaBO = new PessoaBO();
		mensagem = pessoaBO.cadastrarPessoaBO(nome, email, senha, nivel, confirmarSenha);
		
		return mensagem;
	}
	
	public String excluirPessoaVOController(PessoaVO pessoaVO) {
		
		String mensagem = "";
		
		PessoaBO pessoaBO = new PessoaBO();
		mensagem = pessoaBO.excluirPessoaBO(pessoaVO);
		
		return mensagem;
	}
	
	public ArrayList<PessoaVO> listarPessoaVOController() {
		
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.listarPessoaBO();
	}

	public ArrayList<PessoaVO> listarPessoaVONivelController(String nivel) {
		
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.listarNivelBO(nivel);
	}
	
	public ArrayList<PessoaVO> listarPessoaVONomeController(String nome) {
		
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.listarNomeBO(nome);
	}
	
	private boolean validar(String validar) {
		// TODO Auto-generated method stub
		if (validar == null || validar.trim() == "") {
			return false;
		} else {
			return true;
		}
	}

	public String validarPessoaVO(String email, String senha) {
		
		String mensagem = "";
		PessoaBO pessoaBO = new PessoaBO();
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		if(this.validar(email) && (this.validar(senha))) {
			if(pessoaDAO.validarEmail(email)) {
				if(pessoaBO.validarPessoaBO(email, senha).getNivel().getId() == 1) {
					mensagem = "";
				} else {
					mensagem = "falta nivel necessario(ADMIN)";
				}
			} else {
				mensagem = "não encontrado";
			}
		} else {
			mensagem = "dados incorretos";
		}
		return mensagem;
	}

}