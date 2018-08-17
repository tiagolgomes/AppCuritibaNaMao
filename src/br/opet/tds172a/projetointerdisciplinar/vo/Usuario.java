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

package br.opet.tds172a.projetointerdisciplinar.vo;

/**
 * Classe Estabelecimento que cont�m o objeto Usuario, seus atributos e
 * m�todos construtor, de retorno e atribui��o de seus valores (gets e sets).
 *
 */
public class Usuario {
	
	/**
	 * Atributo que representa o Id do Usu�rio.
	 */
	private int idUsuario;			// IDUSUARIO
	
	/**
	 * Atributo que representa o Id do Tipo Usu�rio.
	 */
	private int idTipoUsuario; 		// IDTIPO_USUARIO
	
	/**
	 * Atributo que representa o Tipo do Usu�rio.
	 */
	private String tipoUsuario;		// NOME_TIPO_USUARIO
	
	/**
	 * Atributo que representa o Nome do Usu�rio.
	 */
	private String nomeUsuario;		// NOME_USUARIO
	
	/**
	 * Atributo que representa a Cidade do Usu�rio.
	 */
	private String cidadeUsuario;	// CIDADE_USUARIO
	
	/**
	 * Atributo que representa o DDD do Usu�rio.
	 */
	private int dddUsuario;			// DDD_TELEFONE_USUARIO
	
	/**
	 * Atributo que representa o Telefone do Usu�rio.
	 */
	private int telefoneUsuario;	// TELEFONE_USUARIO
	
	/**
	 * Atributo que representa o Email do Usu�rio.
	 */
	private String emailUsuario;	// EMAIL_USUARIO
	
	/**
	 * Atributo que representa o Login do Usu�rio.
	 */
	private String loginUsuario;	// LOGIN_USUARIO
	
	/**
	 * Atributo que representa a senha do Usu�rio.
	 */
	private String senhaUsuario;	// SENHA_USUARIO
	
	
	/**
	 * M�todo construtor da classe Usu�rio.
	 */
	public Usuario() {	
		
	}
	
	/**
	 * M�todo construtor da classe Usu�rio.
	 * @param idUsuario
	 * @param idTipoUsuario
	 * @param tipoUsuario
	 * @param nomeUsuario
	 * @param cidadeUsuario
	 * @param dddUsuario
	 * @param telefoneUsuario
	 * @param emailUsuario
	 * @param loginUsuario
	 * @param senhaUsuario
	 */
	public Usuario(
			int idUsuario, 
			int idTipoUsuario,  
			String nomeUsuario, 
			String cidadeUsuario,
			int dddUsuario, 
			int telefoneUsuario, 
			String emailUsuario, 
			String loginUsuario, 
			String senhaUsuario) {
		this.idUsuario = idUsuario;
		this.idTipoUsuario = idTipoUsuario;
		this.nomeUsuario = nomeUsuario;
		this.cidadeUsuario = cidadeUsuario;
		this.dddUsuario = dddUsuario;
		this.telefoneUsuario = telefoneUsuario;
		this.emailUsuario = emailUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
	}

	/**
	 * M�todo que retorna o ID do Usu�rio.
	 * @return idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * M�todo que atribui o valor do ID do Usu�rio.
	 * @param int idUsuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	/**
	 * M�todo que retorna o ID Tipo do Usu�rio.
	 * @return idTipoUsuario
	 */
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	/**
	 * M�todo que atribui o valor do ID Tipo do Usu�rio.
	 * @param int idTipoUsuario
	 */
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	/**
	 * M�todo que retorna o Tipo do Usu�rio.
	 * @return tipoUsuario
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * M�todo que atribui o valor do Tipo do Usu�rio.
	 * @param String tipoUsuario
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * M�todo que retorna o Nome do Usu�rio.
	 * @return nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/**
	 * M�todo que atribui o valor do Nome do Usu�rio.
	 * @param String nomeUsuario
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * M�todo que retorna a Cidade do Usu�rio.
	 * @return cidadeUsuario
	 */
	public String getCidadeUsuario() {
		return cidadeUsuario;
	}

	/**
	 * M�todo que atribui o valor da Cidade do Usu�rio.
	 * @param String cidadeUsuario
	 */
	public void setCidadeUsuario(String cidadeUsuario) {
		this.cidadeUsuario = cidadeUsuario;
	}

	/**
	 * M�todo que retorna o DDD do Usu�rio.
	 * @return dddUsuario
	 */
	public int getDddUsuario() {
		return dddUsuario;
	}

	/**
	 * M�todo que atribui o valor do DDD do Usu�rio.
	 * @param int dddUsuario
	 */
	public void setDddUsuario(int dddUsuario) {
		this.dddUsuario = dddUsuario;
	}

	/**
	 * M�todo que retorna o Telefone do Usu�rio.
	 * @return telefoneUsuario
	 */
	public int getTelefoneUsuario() {
		return telefoneUsuario;
	}

	/**
	 * M�todo que atribui o valor do Telefone do Usu�rio.
	 * @param int telefoneUsuario
	 */
	public void setTelefoneUsuario(int telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	/**
	 * M�todo que retorna o Email do Usu�rio.
	 * @return emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}

	/**
	 * M�todo que atribui o valor do Email do Usu�rio.
	 * @param String emailUsuario
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	/**
	 * M�todo que retorna o Login do Usu�rio.
	 * @return loginUsuario
	 */
	public String getLoginUsuario() {
		return loginUsuario;
	}

	/**
	 * M�todo que atribui o valor do Login do Usu�rio.
	 * @param String loginUsuario
	 */
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	/**
	 * M�todo que retorna a Senha do Usu�rio.
	 * @return senhaUsuario
	 */
	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	/**
	 * M�todo que atribui o valor da Senha do Usu�rio.
	 * @param String senhaUsuario
	 */
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

}
