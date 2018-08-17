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
import java.sql.SQLException;

import br.opet.tds172a.projetointerdisciplinar.util.DAO.ConsultarUltimaIdUsuarioDAO;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe CadastrarNovoUsuarioDAO para fazer a conexão com o banco de dados para
 * inserir os dados do Novo Usuário Cadastrado no sistema.
 *
 */
public class CadastrarNovoUsuarioDAO {

	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "123";
	
	/**
	 * Método construtor da classe CadastrarNovoUsuarioDAO
	 * 
	 */
	public CadastrarNovoUsuarioDAO() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Método para validar o cadastro do novo usuário no sistema.
	 * 
	 * @param usuario
	 * @return boolean deuCerto - confirmação ou não do cadastro no sistema
	 */
	public boolean validarCadastro(Usuario usuario) {
		
		ConsultarUltimaIdUsuarioDAO lastId = new ConsultarUltimaIdUsuarioDAO();
		
		int novoId = lastId.maximoIdUsuario();
		
		novoId++;
		
		usuario.setIdUsuario(novoId);
	
		Connection connection = null;
		
		boolean deuCerto = false;
		
		try {
			
			// ABRIR A CONEXAO
			
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			PreparedStatement pstmt = null;
			
			// INICIO DO CONTROLE TRANSACIONAL
			
			connection.setAutoCommit(false);
			
			// PREPARAR A QUERY
			
			String strQuery = "INSERT INTO USUARIO (" 
					+ "IDUSUARIO, "
					+ "IDTIPO_USUARIO, " 
					+ "NOME_USUARIO, " 
					+ "CIDADE_USUARIO, " 
					+ "DDD_TELEFONE_USUARIO, " 
					+ "TELEFONE_USUARIO, "
					+ "EMAIL_USUARIO, "
					+ "LOGIN_USUARIO, "
					+ "SENHA_USUARIO" 
					+ ") VALUES (?,?,?,?,?,?,?,?,?)";
			
			pstmt = connection.prepareStatement(strQuery);
			
			pstmt.setInt(1, usuario.getIdUsuario());
			pstmt.setInt(2, usuario.getIdTipoUsuario());
			pstmt.setString(3, usuario.getNomeUsuario());
			pstmt.setString(4, usuario.getCidadeUsuario());
			pstmt.setInt(5, usuario.getDddUsuario());
			pstmt.setInt(6, usuario.getTelefoneUsuario());
			pstmt.setString(7, usuario.getEmailUsuario());
			pstmt.setString(8, usuario.getLoginUsuario());
			pstmt.setString(9, usuario.getSenhaUsuario());
			
			// EXECUTAR A QUERY
			
			pstmt.executeUpdate();
			
			connection.commit();
			connection.setAutoCommit(true);
			
			deuCerto = true;
			
		} catch (SQLException e) {
			
			try {
				
				if (connection != null && !connection.isClosed()) {
				
					connection.rollback();
				}
				
			} catch (Exception e1) {

				e1.printStackTrace();
				
			}
			
			e.printStackTrace();
			
			deuCerto = false;
			
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
		
		return deuCerto;

	}

}
