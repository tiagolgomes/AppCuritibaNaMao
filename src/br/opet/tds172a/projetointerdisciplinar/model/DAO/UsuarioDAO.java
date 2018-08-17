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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.opet.tds172a.projetointerdisciplinar.util.DAO.ConsultarQuantidadeEstabelecimentosDAO;
import br.opet.tds172a.projetointerdisciplinar.util.DAO.ConsultarUltimaIdEstabelecimentoDAO;
import br.opet.tds172a.projetointerdisciplinar.util.DAO.ConsultarUltimaIdUsuarioDAO;
import br.opet.tds172a.projetointerdisciplinar.util.DAO.VerificarProprioEstabelecimentoDAO;
import br.opet.tds172a.projetointerdisciplinar.vo.Estabelecimento;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe UsuarioDAO para fazer a conexão com o banco de dados para realizar as
 * solicitações do usuário no menuUsuario, como alteração, consulta e exclusão
 * de dados.
 *
 */
public class UsuarioDAO {
	
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "123";
	
	public UsuarioDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean cadastrarEstabelecimento(Estabelecimento estabelecimentoNovo, Usuario usuario) {
		ConsultarUltimaIdEstabelecimentoDAO lastId = new ConsultarUltimaIdEstabelecimentoDAO();
		int novoId = lastId.maximoIdEstabelecimento();
		novoId++;
		estabelecimentoNovo.setIdEstabelecimento(novoId);
		Connection connection = null;
		boolean deuCerto = false;
		try {
			// ABRIR A CONEXAO
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = null;
			// INICIO DO CONTROLE TRANSACIONAL
			connection.setAutoCommit(false);
			// PREPARAR A QUERY
			String strQuery = "INSERT INTO ESTABELECIMENTO (" 
					+ "IDESTABELECIMENTO, "
					+ "IDCATEGORIA_ESTABELECIMENTO, " 
					+ "NOME_ESTABELECIMENTO, " 
					+ "ENDERECO_ESTABELECIMENTO, " 
					+ "CIDADE_ESTABELECIMENTO, " 
					+ "DDD_TELEFONE_ESTABELECIMENTO, " 
					+ "TELEFONE_ESTABELECIMENTO, "
					+ "EMAIL_ESTABELECIMENTO, "
					+ "ESTILO_ESTABELECIMENTO, "
					+ "VALOR_ESTABELECIMENTO" 
					+ ") VALUES (?,?,?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(strQuery);
			pstmt.setInt(1, estabelecimentoNovo.getIdEstabelecimento());
			pstmt.setInt(2, estabelecimentoNovo.getIdCategoriaEstabelecimento());
			pstmt.setString(3, estabelecimentoNovo.getNomeEstabelecimento());
			pstmt.setString(4, estabelecimentoNovo.getEndereçoEstabelecimento());
			pstmt.setString(5, estabelecimentoNovo.getCidadeEstabelecimento());
			pstmt.setInt(6, estabelecimentoNovo.getDddEstabelecimento());
			pstmt.setInt(7, estabelecimentoNovo.getTelefoneEstabelecimento());
			pstmt.setString(8, estabelecimentoNovo.getEmailEstabelecimento());
			pstmt.setString(9, estabelecimentoNovo.getEstiloEstabelecimento());
			pstmt.setDouble(10, estabelecimentoNovo.getValorEstabelecimento());
			// EXECUTAR A QUERY
			pstmt.executeUpdate();
			
			String strQuery2 = "INSERT INTO USUARIO_ESTABELECIMENTO ("
					+ "IDUSUARIO, "
					+ "IDESTABELECIMENTO, "
					+ "CRIACAO_ESTABELECIMENTO"
					+ ") VALUES (?,?,?)";
			Date dataCriacao = new Date();	
			String strDataCriacao = dataCriacao.toString();
	
			pstmt = connection.prepareStatement(strQuery2);
			pstmt.setInt(1, usuario.getIdUsuario());
			pstmt.setInt(2, estabelecimentoNovo.getIdEstabelecimento());
			pstmt.setString(3, strDataCriacao);
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

	public boolean cadastrarUsuario(Usuario usuarioNovo) {
		ConsultarUltimaIdUsuarioDAO lastId = new ConsultarUltimaIdUsuarioDAO();
		int novoId = lastId.maximoIdUsuario();
		novoId++;
		usuarioNovo.setIdUsuario(novoId);
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
			
			pstmt.setInt(1, usuarioNovo.getIdUsuario());
			pstmt.setInt(2, usuarioNovo.getIdTipoUsuario());
			pstmt.setString(3, usuarioNovo.getNomeUsuario());
			pstmt.setString(4, usuarioNovo.getCidadeUsuario());
			pstmt.setInt(5, usuarioNovo.getDddUsuario());
			pstmt.setInt(6, usuarioNovo.getTelefoneUsuario());
			pstmt.setString(7, usuarioNovo.getEmailUsuario());
			pstmt.setString(8, usuarioNovo.getLoginUsuario());
			pstmt.setString(9, usuarioNovo.getSenhaUsuario());
			
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
	
	public List<Estabelecimento> consultarEstabelecimento(Estabelecimento estabelecimentoConsultar) {
		Connection connection = null;
		List<Estabelecimento> listaRecuperada = null;
		
		String strQuery;
		
		int idEstabelecimento;
		int idCategoriaEstabelecimento;
		String nomeEstabelecimento;
		String endereçoEstabelecimento;
		String cidadeEstabelecimento;
		int dddEstabelecimento;
		int telefoneEstabelecimento;
		String emailEstabelecimento;
		String estiloEstabelecimento;
		double valorEstabelecimento;
		
		try {
			// ABRIR A CONEXAO
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = null;
			// INICIO DO CONTROLE TRANSACIONAL
			connection.setAutoCommit(false);
			
			if (estabelecimentoConsultar == null) {
				// PREPARAR A QUERY
				strQuery = "SELECT * "
						+ "FROM ESTABELECIMENTO";
				pstmt = connection.prepareStatement(strQuery);
				// EXECUTAR A QUERY
				ResultSet resultSet = pstmt.executeQuery();
				listaRecuperada = new ArrayList<Estabelecimento>();
				while (resultSet.next()) {
					idEstabelecimento = resultSet.getInt("IDESTABELECIMENTO");
					idCategoriaEstabelecimento = resultSet.getInt("IDCATEGORIA_ESTABELECIMENTO");
					nomeEstabelecimento = resultSet.getString("NOME_ESTABELECIMENTO");
					endereçoEstabelecimento = resultSet.getString("ENDERECO_ESTABELECIMENTO");
					cidadeEstabelecimento = resultSet.getString("CIDADE_ESTABELECIMENTO");
					dddEstabelecimento = resultSet.getInt("DDD_TELEFONE_ESTABELECIMENTO");
					telefoneEstabelecimento = resultSet.getInt("TELEFONE_ESTABELECIMENTO");
					emailEstabelecimento = resultSet.getString("EMAIL_ESTABELECIMENTO");
					estiloEstabelecimento = resultSet.getString("ESTILO_ESTABELECIMENTO");
					valorEstabelecimento = resultSet.getDouble("VALOR_ESTABELECIMENTO");
					listaRecuperada.add(new Estabelecimento(idEstabelecimento, idCategoriaEstabelecimento, nomeEstabelecimento, endereçoEstabelecimento, cidadeEstabelecimento, dddEstabelecimento, telefoneEstabelecimento, emailEstabelecimento, estiloEstabelecimento, valorEstabelecimento));
				}
				return listaRecuperada;
			}
			else if (estabelecimentoConsultar.getIdEstabelecimento() != 0) {
				// PREPARAR A QUERY
				strQuery = "SELECT * "
						+ "FROM ESTABELECIMENTO "
						+ "WHERE IDESTABELECIMENTO = ?";
				pstmt = connection.prepareStatement(strQuery);
				pstmt.setInt(1, estabelecimentoConsultar.getIdEstabelecimento());
				// EXECUTAR A QUERY
				ResultSet resultSet = pstmt.executeQuery();
				listaRecuperada = new ArrayList<Estabelecimento>();
				while (resultSet.next()) {
					idEstabelecimento = resultSet.getInt("IDESTABELECIMENTO");
					idCategoriaEstabelecimento = resultSet.getInt("IDCATEGORIA_ESTABELECIMENTO");
					nomeEstabelecimento = resultSet.getString("NOME_ESTABELECIMENTO");
					endereçoEstabelecimento = resultSet.getString("ENDERECO_ESTABELECIMENTO");
					cidadeEstabelecimento = resultSet.getString("CIDADE_ESTABELECIMENTO");
					dddEstabelecimento = resultSet.getInt("DDD_TELEFONE_ESTABELECIMENTO");
					telefoneEstabelecimento = resultSet.getInt("TELEFONE_ESTABELECIMENTO");
					emailEstabelecimento = resultSet.getString("EMAIL_ESTABELECIMENTO");
					estiloEstabelecimento = resultSet.getString("ESTILO_ESTABELECIMENTO");
					valorEstabelecimento = resultSet.getDouble("VALOR_ESTABELECIMENTO");
					listaRecuperada.add(new Estabelecimento(idEstabelecimento, idCategoriaEstabelecimento, nomeEstabelecimento, endereçoEstabelecimento, cidadeEstabelecimento, dddEstabelecimento, telefoneEstabelecimento, emailEstabelecimento, estiloEstabelecimento, valorEstabelecimento));
				}
				return listaRecuperada;
			}
			else if (estabelecimentoConsultar.getIdCategoriaEstabelecimento() != 0) {
				// PREPARAR A QUERY
				strQuery = "SELECT * "
						+ "FROM ESTABELECIMENTO "
						+ "WHERE IDCATEGORIA_ESTABELECIMENTO = ?";
				pstmt = connection.prepareStatement(strQuery);
				pstmt.setInt(1, estabelecimentoConsultar.getIdCategoriaEstabelecimento());
				// EXECUTAR A QUERY
				ResultSet resultSet = pstmt.executeQuery();
				listaRecuperada = new ArrayList<Estabelecimento>();
				while (resultSet.next()) {
					idEstabelecimento = resultSet.getInt("IDESTABELECIMENTO");
					idCategoriaEstabelecimento = resultSet.getInt("IDCATEGORIA_ESTABELECIMENTO");
					nomeEstabelecimento = resultSet.getString("NOME_ESTABELECIMENTO");
					endereçoEstabelecimento = resultSet.getString("ENDERECO_ESTABELECIMENTO");
					cidadeEstabelecimento = resultSet.getString("CIDADE_ESTABELECIMENTO");
					dddEstabelecimento = resultSet.getInt("DDD_TELEFONE_ESTABELECIMENTO");
					telefoneEstabelecimento = resultSet.getInt("TELEFONE_ESTABELECIMENTO");
					emailEstabelecimento = resultSet.getString("EMAIL_ESTABELECIMENTO");
					estiloEstabelecimento = resultSet.getString("ESTILO_ESTABELECIMENTO");
					valorEstabelecimento = resultSet.getDouble("VALOR_ESTABELECIMENTO");
					listaRecuperada.add(new Estabelecimento(idEstabelecimento, idCategoriaEstabelecimento, nomeEstabelecimento, endereçoEstabelecimento, cidadeEstabelecimento, dddEstabelecimento, telefoneEstabelecimento, emailEstabelecimento, estiloEstabelecimento, valorEstabelecimento));
				}
				return listaRecuperada;
			}
			else {
				System.out.println("Erro!!!");
				return null;
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
			return null;
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
	
	public List<Usuario> consultarUsuario(Usuario usuarioConsultar) {
		Connection connection = null;
		List<Usuario> listaRecuperada = null;
		
		String strQuery;
		
		int idUsuario;
		int idTipoUsuario;
		String nomeUsuario;
		String cidadeUsuario;
		int dddUsuario;
		int telefoneUsuario;
		String emailUsuario;
		String loginUsuario;
		String senhaUsuario;
		
		try {
			// ABRIR A CONEXAO
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = null;
			// INICIO DO CONTROLE TRANSACIONAL
			connection.setAutoCommit(false);
			
			if (usuarioConsultar == null) {
				// PREPARAR A QUERY
				strQuery = "SELECT * "
						+ "FROM USUARIO";
				pstmt = connection.prepareStatement(strQuery);
				// EXECUTAR A QUERY
				ResultSet resultSet = pstmt.executeQuery();
				listaRecuperada = new ArrayList<Usuario>();
				while (resultSet.next()) {
					idUsuario = resultSet.getInt("IDUSUARIO");
					idTipoUsuario = resultSet.getInt("IDTIPO_USUARIO");
					nomeUsuario = resultSet.getString("NOME_USUARIO");
					cidadeUsuario = resultSet.getString("CIDADE_USUARIO");
					dddUsuario = resultSet.getInt("DDD_TELEFONE_USUARIO");
					telefoneUsuario = resultSet.getInt("TELEFONE_USUARIO");
					emailUsuario = resultSet.getString("EMAIL_USUARIO");
					loginUsuario = resultSet.getString("LOGIN_USUARIO");
					senhaUsuario = resultSet.getString("SENHA_USUARIO");
					listaRecuperada.add(new Usuario(idUsuario, idTipoUsuario, nomeUsuario, cidadeUsuario, dddUsuario, telefoneUsuario, emailUsuario, loginUsuario, senhaUsuario));
				}
				return listaRecuperada;
			}
			else if (usuarioConsultar.getIdTipoUsuario() != 0) {
				// PREPARAR A QUERY
				strQuery = "SELECT * "
						+ "FROM USUARIO "
						+ "WHERE IDTIPO_USUARIO = ?";
				pstmt = connection.prepareStatement(strQuery);
				pstmt.setInt(1, usuarioConsultar.getIdTipoUsuario());
				// EXECUTAR A QUERY
				ResultSet resultSet = pstmt.executeQuery();
				listaRecuperada = new ArrayList<Usuario>();
				while (resultSet.next()) {
					idUsuario = resultSet.getInt("IDUSUARIO");
					idTipoUsuario = resultSet.getInt("IDTIPO_USUARIO");
					nomeUsuario = resultSet.getString("NOME_USUARIO");
					cidadeUsuario = resultSet.getString("CIDADE_USUARIO");
					dddUsuario = resultSet.getInt("DDD_TELEFONE_USUARIO");
					telefoneUsuario = resultSet.getInt("TELEFONE_USUARIO");
					emailUsuario = resultSet.getString("EMAIL_USUARIO");
					loginUsuario = resultSet.getString("LOGIN_USUARIO");
					senhaUsuario = resultSet.getString("SENHA_USUARIO");
					listaRecuperada.add(new Usuario(idUsuario, idTipoUsuario, nomeUsuario, cidadeUsuario, dddUsuario, telefoneUsuario, emailUsuario, loginUsuario, senhaUsuario));
				}
				return listaRecuperada;
			}
			else if (usuarioConsultar.getIdUsuario() != 0) {
				// PREPARAR A QUERY
				strQuery = "SELECT * "
						+ "FROM USUARIO "
						+ "WHERE IDUSUARIO = ?";
				pstmt = connection.prepareStatement(strQuery);
				pstmt.setInt(1, usuarioConsultar.getIdUsuario());
				// EXECUTAR A QUERY
				ResultSet resultSet = pstmt.executeQuery();
				listaRecuperada = new ArrayList<Usuario>();
				while (resultSet.next()) {
					idUsuario = resultSet.getInt("IDUSUARIO");
					idTipoUsuario = resultSet.getInt("IDTIPO_USUARIO");
					nomeUsuario = resultSet.getString("NOME_USUARIO");
					cidadeUsuario = resultSet.getString("CIDADE_USUARIO");
					dddUsuario = resultSet.getInt("DDD_TELEFONE_USUARIO");
					telefoneUsuario = resultSet.getInt("TELEFONE_USUARIO");
					emailUsuario = resultSet.getString("EMAIL_USUARIO");
					loginUsuario = resultSet.getString("LOGIN_USUARIO");
					senhaUsuario = resultSet.getString("SENHA_USUARIO");
					listaRecuperada.add(new Usuario(idUsuario, idTipoUsuario, nomeUsuario, cidadeUsuario, dddUsuario, telefoneUsuario, emailUsuario, loginUsuario, senhaUsuario));
				}
				return listaRecuperada;
			}
			else {
				System.out.println("Erro!!!");
				return null;
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
			return null;
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

	public boolean alterarEstabelecimento(Estabelecimento estabelecimentoAlterar, String dadoEstabelecimentoAlterar, String dadoEstabelecimento) {
		boolean deuCerto = false;
		Connection connection = null;
		try {
			// ABRIR A CONEXAO
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = null;
			// INICIO DO CONTROLE TRANSACIONAL
			connection.setAutoCommit(false);
			// PREPARAR A QUERY
			String strQuery;
			if (dadoEstabelecimentoAlterar == "DDD_TELEFONE_ESTABELECIMENTO" || dadoEstabelecimentoAlterar == "TELEFONE_ESTABELECIMENTO") {
				int dddTelefone = Integer.parseInt(dadoEstabelecimento);
				strQuery = "UPDATE ESTABELECIMENTO "
						+ "SET "
						+ dadoEstabelecimentoAlterar + " = '" + dddTelefone + "' WHERE IDESTABELECIMENTO = ?";
			}
			else if (dadoEstabelecimentoAlterar == "VALOR_ESTABELECIMENTO") {
				double valor = Double.parseDouble(dadoEstabelecimento);
				strQuery = "UPDATE ESTABELECIMENTO "
						+ "SET "
						+ dadoEstabelecimentoAlterar + " = '" + valor + "' WHERE IDESTABELECIMENTO = ?";
			}
			else {
				strQuery = "UPDATE ESTABELECIMENTO "
						+ "SET "
						+ dadoEstabelecimentoAlterar + " = '" + dadoEstabelecimento + "' WHERE IDESTABELECIMENTO = ?";
			}
			pstmt = connection.prepareStatement(strQuery);
			pstmt.setInt(1, estabelecimentoAlterar.getIdEstabelecimento());
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

	public boolean alterarUsuario(Usuario usuarioAlterar, String dadoUsuarioAlterar, String dadoUsuario) {
		boolean deuCerto = false;
		Connection connection = null;
		try {
			// ABRIR A CONEXAO
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = null;
			// INICIO DO CONTROLE TRANSACIONAL
			connection.setAutoCommit(false);
			// PREPARAR A QUERY
			String strQuery;
			if (dadoUsuarioAlterar == "DDD_TELEFONE_USUARIO" || dadoUsuarioAlterar == "TELEFONE_USUARIO") {
				int dddTelefone = Integer.parseInt(dadoUsuario);
				strQuery = "UPDATE USUARIO "
						+ "SET "
						+ dadoUsuarioAlterar + " = '" + dddTelefone + "' WHERE IDUSUARIO = ?";
			}
			else {
				strQuery = "UPDATE USUARIO "
						+ "SET "
						+ dadoUsuarioAlterar + " = '" + dadoUsuario + "' WHERE IDUSUARIO = ?";
			}
			pstmt = connection.prepareStatement(strQuery);
			pstmt.setInt(1, usuarioAlterar.getIdUsuario());
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

	public boolean excluirEstabelecimento(Estabelecimento estabelecimentoExcluir) {
		boolean deuCerto = false;
		Connection connection = null;
		try {
			// ABRIR A CONEXAO
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = null;
			// INICIO DO CONTROLE TRANSACIONAL
			connection.setAutoCommit(false);
			// PREPARAR A QUERY
			String strQuery = "DELETE FROM USUARIO_ESTABELECIMENTO WHERE IDESTABELECIMENTO = ?";
			pstmt = connection.prepareStatement(strQuery);
			pstmt.setInt(1, estabelecimentoExcluir.getIdEstabelecimento());
			// EXECUTAR A QUERY
			pstmt.executeUpdate();
			connection.commit();
			
			// PREPARAR A QUERY
			String strQuery2 = "DELETE FROM ESTABELECIMENTO WHERE IDESTABELECIMENTO = ?";
			pstmt = connection.prepareStatement(strQuery2);
			pstmt.setInt(1, estabelecimentoExcluir.getIdEstabelecimento());
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

	public boolean excluirUsuario(Usuario usuarioExcluir) {
		boolean deuCerto = false;
		Connection connection = null;
		try {
			// ABRIR A CONEXAO
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = null;
			// INICIO DO CONTROLE TRANSACIONAL
			connection.setAutoCommit(false);
			// PREPARAR A QUERY
			String strQuery = "DELETE FROM USUARIO WHERE IDUSUARIO = ?";
			pstmt = connection.prepareStatement(strQuery);
			pstmt.setInt(1, usuarioExcluir.getIdUsuario());
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

	public Usuario buscarUsuario(int idUsuario) {
		Usuario usuarioBuscado;
		Connection connection = null;
		try {
			// ABRIR A CONEXAO
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = null;
			// INICIO DO CONTROLE TRANSACIONAL
			connection.setAutoCommit(false);
			// PREPARAR A QUERY
			String strQuery = "SELECT * FROM USUARIO WHERE IDUSUARIO = ?";
			pstmt = connection.prepareStatement(strQuery);
			pstmt.setInt(1, idUsuario);
			// EXECUTAR A QUERY
			ResultSet resultSet = pstmt.executeQuery();
			usuarioBuscado = new Usuario();
			while (resultSet.next()) {
				usuarioBuscado.setIdUsuario(resultSet.getInt("IDUSUARIO"));
				usuarioBuscado.setIdTipoUsuario(resultSet.getInt("IDTIPO_USUARIO"));
				usuarioBuscado.setNomeUsuario(resultSet.getString("NOME_USUARIO"));
				usuarioBuscado.setCidadeUsuario(resultSet.getString("CIDADE_USUARIO"));
				usuarioBuscado.setDddUsuario(resultSet.getInt("DDD_TELEFONE_USUARIO"));
				usuarioBuscado.setTelefoneUsuario(resultSet.getInt("TELEFONE_USUARIO"));
				usuarioBuscado.setEmailUsuario(resultSet.getString("EMAIL_USUARIO"));
				usuarioBuscado.setLoginUsuario(resultSet.getString("LOGIN_USUARIO"));
				usuarioBuscado.setSenhaUsuario(resultSet.getString("SENHA_USUARIO"));
			}
			return usuarioBuscado;
		} catch (SQLException e) {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.rollback();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return null;
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

	public int consultarQuantidadeEstabelecimento(Usuario usuarioExcluir) {
		ConsultarQuantidadeEstabelecimentosDAO consultarQuantidadeEstabelecimentosDAO = new ConsultarQuantidadeEstabelecimentosDAO();
		int qtoEstab = consultarQuantidadeEstabelecimentosDAO.consultQtoEstabPorUsuario(usuarioExcluir);
		return qtoEstab;
	}

	public boolean verificarProprioEstabelecimento(Estabelecimento estabelecimentoExcluir, Usuario usuario) {
		VerificarProprioEstabelecimentoDAO verificarProprioEstabelecimentoDAO = new VerificarProprioEstabelecimentoDAO();
		boolean deuCerto = verificarProprioEstabelecimentoDAO.verificarProprioEstab(estabelecimentoExcluir, usuario);
		return deuCerto;
	}
}
