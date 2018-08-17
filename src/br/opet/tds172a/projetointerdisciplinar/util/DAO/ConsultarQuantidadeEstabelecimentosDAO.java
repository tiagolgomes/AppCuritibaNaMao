package br.opet.tds172a.projetointerdisciplinar.util.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

public class ConsultarQuantidadeEstabelecimentosDAO {
	
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "123";
	
	/**
	 * Método construtor da classe ConsultarUltimaIdUsuario
	 * 
	 */
	public ConsultarQuantidadeEstabelecimentosDAO() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Método para determinar o ID do Usuário que está sendo criado. Sempre um
	 * número a mais que o último usuário cadastrado no banco de dados.
	 * 
	 * @return int idUsuario
	 */
	public int consultQtoEstabPorUsuario(Usuario usuarioExcluir) {
		
		Connection connection = null;
		
		int qtoEstab = 0;
		
		try {
			
			// ABRIR A CONEXAO
			
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			PreparedStatement pstmt = null;
			
			// INICIO DO CONTROLE TRANSACIONAL
			
			connection.setAutoCommit(false);
			
			// PREPARAR A QUERY
			
			String strQuery = "SELECT COUNT(IDESTABELECIMENTO) AS QUANTIDADE_ESTABELECIMENTO "
					+ "FROM USUARIO_ESTABELECIMENTO "
					+ "WHERE IDUSUARIO = ?";
			
			pstmt = connection.prepareStatement(strQuery);
			
			pstmt.setInt(1, usuarioExcluir.getIdUsuario());
			
			// EXECUTAR A QUERY
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				
				qtoEstab = resultSet.getInt("QUANTIDADE_ESTABELECIMENTO");
				
			}
			
			return qtoEstab;
			
		} catch (SQLException e) {
			
			try {
				
				if (connection != null && !connection.isClosed()) {
				
					connection.rollback();
				}
				
			} catch (Exception e1) {

				e1.printStackTrace();
				
			}
			
			e.printStackTrace();
			
			return qtoEstab;
			
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
		
	}

}
