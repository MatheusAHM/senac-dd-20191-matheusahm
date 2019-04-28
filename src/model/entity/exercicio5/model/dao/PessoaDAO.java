package model.entity.exercicio5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.exercicio5.model.vo.NivelVO;
import model.entity.exercicio5.model.vo.PessoaVO;

public class PessoaDAO {

	public boolean verificarRegistroNomePessoaDAO(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM pessoa WHERE nome like '" + nome + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência " + "de Pessoa por Nome. Causa: "
					+ e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarPessoaDAO(PessoaVO pessoaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO pessoa (nome, email, senha, idnivel) VALUES ('" + pessoaVO.getNome() + "', '"
				+ pessoaVO.getEmail() + "', '" + pessoaVO.getSenha() + "'," + pessoaVO.getNivel().getId() + ")";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query de cadastro de pessoa. " + "Causa:" + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirPessoaDAO(PessoaVO pessoaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM pessoa WHERE nome = '" + pessoaVO.getNome() + "'";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de exclusão de pessoa." + "Causa:" + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public ArrayList<PessoaVO> listarPessoaDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<PessoaVO> pessoas = new ArrayList<PessoaVO>();
		String query = "SELECT * FROM pessoa inner join nivel where nivel.idnivel = pessoa.idnivel";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				PessoaVO pessoaVO = new PessoaVO();
				pessoaVO.setId(resultado.getInt(1));
				pessoaVO.setNome(resultado.getString(2));
				pessoaVO.setEmail(resultado.getString(3));
				pessoaVO.setSenha(resultado.getString(4));
				NivelVO nivel = new NivelVO();
				nivel.setDescricao(resultado.getString(7));
				pessoaVO.setNivel(nivel);
				pessoas.add(pessoaVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de consulta de pessoa");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pessoas;
	}

	public ArrayList<PessoaVO> listarNivelPessoaDAO(String nivel) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<PessoaVO> pessoas = new ArrayList<PessoaVO>();
		String query = "SELECT * FROM pessoa INNER JOIN nivel WHERE "
				+ "nivel.idnivel = pessoa.idnivel HAVING descricao = '" + nivel + "'";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				PessoaVO nivelPessoaVO = new PessoaVO();
				nivelPessoaVO.setNome(resultado.getString(2));
				nivelPessoaVO.setEmail(resultado.getString(3));
				nivelPessoaVO.setSenha(resultado.getString(4));
				NivelVO nivel1 = new NivelVO();
				nivel1.setDescricao(resultado.getString(7));
				nivelPessoaVO.setNivel(nivel1);
				pessoas.add(nivelPessoaVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de consulta de pessoa por nivel");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pessoas;
	}

	public ArrayList<PessoaVO> listarNomePessoaDAO(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<PessoaVO> pessoas = new ArrayList<PessoaVO>();
		String query = "SELECT * FROM pessoa INNER JOIN nivel WHERE "
				+ "nivel.idnivel = pessoa.idnivel HAVING nome LIKE '%" + nome + "%'";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				PessoaVO nomePessoaVO = new PessoaVO();
				nomePessoaVO.setNome(resultado.getString(2));
				nomePessoaVO.setEmail(resultado.getString(3));
				nomePessoaVO.setSenha(resultado.getString(4));
				NivelVO nivel = new NivelVO();
				nivel.setDescricao(resultado.getString(7));
				nomePessoaVO.setNivel(nivel);
				pessoas.add(nomePessoaVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de pessoa por nome");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pessoas;
	}

	public List<PessoaVO> consultarPessoaVO() {
		// TODO Auto-generated method stub
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<PessoaVO> pessoasVO = new ArrayList<PessoaVO>();
		String query = "SELECT * FROM pessoa";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				PessoaVO pessoaVO = new PessoaVO();
				pessoaVO.setNome(resultado.getString(2));
				pessoaVO.setEmail(resultado.getString(3));
				pessoasVO.add(pessoaVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta por nome");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pessoasVO;
	}

	public PessoaVO validarPessoaVO(String email, String senha) {
		// TODO Auto-generated method stub
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		PessoaVO pessoaVO = new PessoaVO();
		String query = "SELECT * FROM pessoa WHERE email = '" + email + "' AND senha = '" + senha + "'";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				pessoaVO.setNome(resultado.getString(2));
				pessoaVO.setEmail(resultado.getString(3));
				NivelVO nivelVO = new NivelVO();
				nivelVO.setId(resultado.getInt(5));
				pessoaVO.setNivel(nivelVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de validação");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pessoaVO;
	}

	public boolean validarEmail(String email) {
		// TODO Auto-generated method stub
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM pessoa WHERE email = '" + email + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de validação de email");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}
}