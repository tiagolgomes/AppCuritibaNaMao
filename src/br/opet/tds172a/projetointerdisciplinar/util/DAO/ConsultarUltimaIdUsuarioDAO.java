/**
 * Projeto Interdisciplinar: Curitiba na M�o
 * Realizado para curso de An�lise e Desenvolvimento de Sistemas
 * Turma TDS172A - UniOpet
 * 
 * @author Tiago de Lacerda Gomes
 * @author Vanessa Niro Machado
 * 
 * @since 02-05-2018
 * 
 * @version 1.0
 * 
 */
package br.opet.tds172a.projetointerdisciplinar.util.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe ConsultaUltimaIdUsuario para definir o ID do usu�rio a ser criado
 * seguindo a sequ�ncia de IDs de Usu�rios do Banco de Dados.
 *
 */
public class ConsultarUltimaIdUsuarioDAO {
	
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "123";
	
	/**
	 * M�todo construtor da classe ConsultarUltimaIdUsuario
	 * 
	 */
	public ConsultarUltimaIdUsuarioDAO() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 * M�todo para determinar o ID do Usu�rio que est� sendo criado. Sempre um
	 * n�mero a mais que o �ltimo usu�rio cadastrado no banco de dados.
	 * 
	 * @return int idUsuario
	 */
	public int maximoIdUsuario() {
		
		Connection connection = null;
		
		int idUsuario = 0;
		
		try {
			
			// ABRIR A CONEXAO
			
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			PreparedStatement pstmt = null;
			
			// INICIO DO CONTROLE TRANSACIONAL
			
			connection.setAutoCommit(false);
			
			// PREPARAR A QUERY
			
			String strQuery = "SELECT MAX(IDUSUARIO) AS ULTIMOUSUARIO FROM USUARIO";
			
			pstmt = connection.prepareStatement(strQuery);
			
			// EXECUTAR A QUERY
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				
				idUsuario = resultSet.getInt("ULTIMOUSUARIO");
				
			}
			
			return idUsuario;
			
		} catch (SQLException e) {
			
			try {
				
				if (connection != null && !connection.isClosed()) {
				
					connection.rollback();
				}
				
			} catch (Exception e1) {

				e1.printStackTrace();
				
			}
			
			e.printStackTrace();
			
			return idUsuario;
			
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
