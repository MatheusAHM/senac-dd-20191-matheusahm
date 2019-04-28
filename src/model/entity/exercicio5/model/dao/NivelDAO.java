package model.entity.exercicio5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.exercicio4.model.vo.NivelVO;

public class NivelDAO {
	
	public ArrayList<NivelVO> consultarNivelVO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<NivelVO> niveis = new ArrayList<NivelVO>();
		String query = "SELECT * FROM nivel";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				NivelVO nivel = new NivelVO();
				nivel.setId(resultado.getInt(1));
				nivel.setDescricao(resultado.getString(2));
				niveis.add(nivel);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de consulta de nivel");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return niveis;
	}
}
