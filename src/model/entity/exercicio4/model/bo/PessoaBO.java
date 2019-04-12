package model.entity.exercicio4.model.bo;

import java.util.ArrayList;
import java.util.List;

import model.entity.exercicio4.model.dao.PessoaDAO;
import model.entity.exercicio4.model.vo.NivelVO;
import model.entity.exercicio4.model.vo.PessoaVO;

public class PessoaBO {

	public String cadastrarPessoaBO(String nome, String email,String senha, NivelVO nivel, String confirmarSenha) {
		String mensagem = "";
		PessoaDAO pessoaDAO = new PessoaDAO();

		if (pessoaDAO.verificarRegistroNomePessoaDAO(nome)) {
			mensagem = "Já existe um cadastro para: " + nome;
		}

		if (nome.trim().length() < 3) {
			mensagem = "Nome com menos de 3 caracteres";
		}

		String[] parts = email.split("@");
		if (parts.length != 2) {
			mensagem = "Email invalido, verificar novamente";
		}

		if (senha.length() < 6) {
			mensagem = "Senha com quantidade de digitos menor que 6(seis)";
		}

		if (!confirmarSenha.equals(senha)) {
			mensagem = "senha não confere, verificar novamente";
		}

		if (mensagem == "") {
			PessoaVO pessoaVO = new PessoaVO(nome, email, senha, nivel);

			int persistencia = pessoaDAO.cadastrarPessoaDAO(pessoaVO);

			if (persistencia == 1) {
				mensagem = "Cadastro salvo";
			} else if (persistencia == 0) {
				mensagem = "Cadastro não realizado, erro ao salvar";
			}
		}

		return mensagem;
	}

	public String excluirPessoaBO(PessoaVO pessoaVO) {
		String mensagem = "";
		PessoaDAO pessoaDAO = new PessoaDAO();
		if (pessoaDAO.verificarRegistroNomePessoaDAO(pessoaVO.getNome())) {
			int persistencia = pessoaDAO.excluirPessoaDAO(pessoaVO);
			if (persistencia == 1) {
				mensagem = "Cadastro excluido";
			} else {
				mensagem = "Não possivel excluir o cadastro";
			}
		} else {
			mensagem = "erro na base de dados, cadastro inexistente";
		}
		return mensagem;
	}

	public ArrayList<PessoaVO> listarPessoaBO() {
		
		PessoaDAO listarPessoas = new PessoaDAO();
		return listarPessoas.listarPessoaDAO();
	}
	
	public ArrayList<PessoaVO> listarNivelBO(String nivel) {
		
		PessoaDAO listarNivelDAO = new PessoaDAO();
		return listarNivelDAO.listarNivelPessoaDAO(nivel);
	}
	
	public ArrayList<PessoaVO> listarNomeBO(String nome) {
		
		PessoaDAO listarNomeDAO = new PessoaDAO();
		return listarNomeDAO.listarNomePessoaDAO(nome);
	}
	
	public List<PessoaVO> consultarPessoasBO() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.consultarPessoaVO();
	}
	
	public PessoaVO validarPessoaBO(String email, String senha) {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
			
		PessoaVO pessoaVO = new PessoaVO();
		pessoaVO = pessoaDAO.validarPessoaVO(email, senha);
		
		return pessoaVO;
	}
}
