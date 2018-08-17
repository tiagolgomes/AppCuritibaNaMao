package br.opet.tds172a.projetointerdisciplinar.util.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.opet.tds172a.projetointerdisciplinar.vo.Estabelecimento;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

public class VerificarProprioEstabelecimentoDAO {
	
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "123";
	
	public VerificarProprioEstabelecimentoDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean verificarProprioEstab(Estabelecimento estabelecimentoExcluir, Usuario usuario) {
		Connection connection = null;
		boolean deuCerto;
		int qtoEstab = 0;
		try {
			// ABRIR A CONEXAO
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = null;
			// INICIO DO CONTROLE TRANSACIONAL
			connection.setAutoCommit(false);
			// PREPARAR A QUERY
			String strQuery = "SELECT COUNT(CRIACAO_ESTABELECIMENTO) AS QUANTIDADE_ESTABELECIMENTO "
					+ "FROM USUARIO_ESTABELECIMENTO "
					+ "WHERE IDUSUARIO = ? "
					+ "AND IDESTABELECIMENTO = ?";
			pstmt = connection.prepareStatement(strQuery);
			pstmt.setInt(1, usuario.getIdUsuario());
			pstmt.setInt(2, estabelecimentoExcluir.getIdEstabelecimento());
			// EXECUTAR A QUERY
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				qtoEstab = resultSet.getInt("QUANTIDADE_ESTABELECIMENTO");
			}			
		} catch (SQLException e) {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.rollback();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				// FECHAR A CONEXAO COM O BANCO DE DADOS
				if(connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (qtoEstab == 1) {
			deuCerto = true;
		}
		else {
			deuCerto = false;
		}
		return deuCerto;
	}		
}
