/**
 * Projeto Interdisciplinar: Curitiba na Mão
 * Realizado para curso de Análise e Desenvolvimento de Sistemas
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
package br.opet.tds172a.projetointerdisciplinar.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe LogarDAO para fazer a conexão com o banco de dados para o login de
 * acesso de um Usuário Cadastrado no sistema.
 *
 */
public class LogarDAO {
	
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "123";

	public Usuario efetuarLogin(Usuario usuario) {
		
		Connection connection = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// ABRIR A CONEXAO COM O BANCO DE DADOS
			
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			PreparedStatement pstmt = null;
			
			// PREPARAR A QUERY
			
			String strQuery = "SELECT "
					+ "IDUSUARIO, "
					+ "IDTIPO_USUARIO, "
					+ "NOME_USUARIO, "
					+ "CIDADE_USUARIO, "
					+ "DDD_TELEFONE_USUARIO, "
					+ "TELEFONE_USUARIO, "
					+ "EMAIL_USUARIO, "
					+ "LOGIN_USUARIO, "
					+ "SENHA_USUARIO "
					+ "FROM SYSTEM.USUARIO "
					+ "WHERE LOGIN_USUARIO = ? "
					+ "AND SENHA_USUARIO = ?";
			
			pstmt = connection.prepareStatement(strQuery);
			
			pstmt.setString(1, usuario.getLoginUsuario());
			pstmt.setString(2, usuario.getSenhaUsuario());
			
			// EXECUTAR
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				
				usuario.setIdUsuario(resultSet.getInt("IDUSUARIO"));
				usuario.setIdTipoUsuario(resultSet.getInt("IDTIPO_USUARIO"));
				usuario.setNomeUsuario(resultSet.getString("NOME_USUARIO"));
				usuario.setCidadeUsuario(resultSet.getString("CIDADE_USUARIO"));
				usuario.setDddUsuario(resultSet.getInt("DDD_TELEFONE_USUARIO"));
				usuario.setTelefoneUsuario(resultSet.getInt("TELEFONE_USUARIO"));
				usuario.setEmailUsuario(resultSet.getString("EMAIL_USUARIO"));
				usuario.setLoginUsuario(resultSet.getString("LOGIN_USUARIO"));
				usuario.setSenhaUsuario(resultSet.getString("SENHA_USUARIO"));
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
			usuario = null;

		} catch (SQLException e) {
			
			try {
				
				if (connection != null && !connection.isClosed()) {
				
					connection.rollback();
					
					usuario = null;
				}
				
			} catch (Exception e1) {

				e1.printStackTrace();
				
				usuario = null;

			}
			
		} finally {
			
			try {
				
				// FECHAR A CONEXAO
				
				if(connection != null && !connection.isClosed()) {
					connection.close();
					
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		return usuario;
		
	}
	
}
