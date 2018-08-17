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
package br.opet.tds172a.projetointerdisciplinar.util.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarUltimaIdEstabelecimentoDAO {
	
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "123";
	
	/**
	 * Método construtor da classe ConsultarUltimaIdUsuario
	 * 
	 */
	public ConsultarUltimaIdEstabelecimentoDAO() {
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
	 * @return int idEstabelecimento
	 */
	public int maximoIdEstabelecimento() {
		Connection connection = null;
		int idEstabelecimento = 0;
		try {
			// ABRIR A CONEXAO
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = null;
			// INICIO DO CONTROLE TRANSACIONAL
			connection.setAutoCommit(false);
			// PREPARAR A QUERY
			String strQuery = "SELECT MAX(IDESTABELECIMENTO) AS ULTIMOESTABELECIMENTO "
						+ "FROM ESTABELECIMENTO";
			pstmt = connection.prepareStatement(strQuery);
			// EXECUTAR A QUERY
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				idEstabelecimento = resultSet.getInt("ULTIMOESTABELECIMENTO");
			}
			return idEstabelecimento;
		} catch (SQLException e) {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.rollback();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return idEstabelecimento;
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
