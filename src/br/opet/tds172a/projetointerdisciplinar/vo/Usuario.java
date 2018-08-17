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

package br.opet.tds172a.projetointerdisciplinar.vo;

/**
 * Classe Estabelecimento que contém o objeto Usuario, seus atributos e
 * métodos construtor, de retorno e atribuição de seus valores (gets e sets).
 *
 */
public class Usuario {
	
	/**
	 * Atributo que representa o Id do Usuário.
	 */
	private int idUsuario;			// IDUSUARIO
	
	/**
	 * Atributo que representa o Id do Tipo Usuário.
	 */
	private int idTipoUsuario; 		// IDTIPO_USUARIO
	
	/**
	 * Atributo que representa o Tipo do Usuário.
	 */
	private String tipoUsuario;		// NOME_TIPO_USUARIO
	
	/**
	 * Atributo que representa o Nome do Usuário.
	 */
	private String nomeUsuario;		// NOME_USUARIO
	
	/**
	 * Atributo que representa a Cidade do Usuário.
	 */
	private String cidadeUsuario;	// CIDADE_USUARIO
	
	/**
	 * Atributo que representa o DDD do Usuário.
	 */
	private int dddUsuario;			// DDD_TELEFONE_USUARIO
	
	/**
	 * Atributo que representa o Telefone do Usuário.
	 */
	private int telefoneUsuario;	// TELEFONE_USUARIO
	
	/**
	 * Atributo que representa o Email do Usuário.
	 */
	private String emailUsuario;	// EMAIL_USUARIO
	
	/**
	 * Atributo que representa o Login do Usuário.
	 */
	private String loginUsuario;	// LOGIN_USUARIO
	
	/**
	 * Atributo que representa a senha do Usuário.
	 */
	private String senhaUsuario;	// SENHA_USUARIO
	
	
	/**
	 * Método construtor da classe Usuário.
	 */
	public Usuario() {	
		
	}
	
	/**
	 * Método construtor da classe Usuário.
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
	 * Método que retorna o ID do Usuário.
	 * @return idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Método que atribui o valor do ID do Usuário.
	 * @param int idUsuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	/**
	 * Método que retorna o ID Tipo do Usuário.
	 * @return idTipoUsuario
	 */
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	/**
	 * Método que atribui o valor do ID Tipo do Usuário.
	 * @param int idTipoUsuario
	 */
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	/**
	 * Método que retorna o Tipo do Usuário.
	 * @return tipoUsuario
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * Método que atribui o valor do Tipo do Usuário.
	 * @param String tipoUsuario
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * Método que retorna o Nome do Usuário.
	 * @return nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/**
	 * Método que atribui o valor do Nome do Usuário.
	 * @param String nomeUsuario
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * Método que retorna a Cidade do Usuário.
	 * @return cidadeUsuario
	 */
	public String getCidadeUsuario() {
		return cidadeUsuario;
	}

	/**
	 * Método que atribui o valor da Cidade do Usuário.
	 * @param String cidadeUsuario
	 */
	public void setCidadeUsuario(String cidadeUsuario) {
		this.cidadeUsuario = cidadeUsuario;
	}

	/**
	 * Método que retorna o DDD do Usuário.
	 * @return dddUsuario
	 */
	public int getDddUsuario() {
		return dddUsuario;
	}

	/**
	 * Método que atribui o valor do DDD do Usuário.
	 * @param int dddUsuario
	 */
	public void setDddUsuario(int dddUsuario) {
		this.dddUsuario = dddUsuario;
	}

	/**
	 * Método que retorna o Telefone do Usuário.
	 * @return telefoneUsuario
	 */
	public int getTelefoneUsuario() {
		return telefoneUsuario;
	}

	/**
	 * Método que atribui o valor do Telefone do Usuário.
	 * @param int telefoneUsuario
	 */
	public void setTelefoneUsuario(int telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	/**
	 * Método que retorna o Email do Usuário.
	 * @return emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}

	/**
	 * Método que atribui o valor do Email do Usuário.
	 * @param String emailUsuario
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	/**
	 * Método que retorna o Login do Usuário.
	 * @return loginUsuario
	 */
	public String getLoginUsuario() {
		return loginUsuario;
	}

	/**
	 * Método que atribui o valor do Login do Usuário.
	 * @param String loginUsuario
	 */
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	/**
	 * Método que retorna a Senha do Usuário.
	 * @return senhaUsuario
	 */
	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	/**
	 * Método que atribui o valor da Senha do Usuário.
	 * @param String senhaUsuario
	 */
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

}
