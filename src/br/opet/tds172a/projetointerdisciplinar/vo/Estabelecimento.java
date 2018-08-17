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
 * Classe Estabelecimento que cont�m o objeto Establecimento, seus atributos e
 * m�todos contrutor, de retorno e atribui��o de seus valores (gets e sets).
 *
 */
public class Estabelecimento {
	
	/**
	 * Atributo que representa o Id do Estabelecimento.
	 */
	private int idEstabelecimento;
	/**
	 * Atributo que representa a Categoria do Estabelecimento.
	 */
	private int idCategoriaEstabelecimento;
	
	/**
	 * Atributo que representa o Nome do Estabelecimento.
	 */
	private String nomeEstabelecimento;
	
	/**
	 * Atributo que representa o endere�o do Estabelecimento.
	 */
	private String endere�oEstabelecimento;
	
	/**
	 * Atributo que representa a cidade do Estabelecimento.
	 */
	private String cidadeEstabelecimento;
	
	/**
	 * Atributo que representa o DDD do Estabelecimento.
	 */
	private int dddEstabelecimento;
	
	/**
	 * Atributo que representa o telefone do Estabelecimento.
	 */
	private int telefoneEstabelecimento;
	
	/**
	 * Atributo que representa o email do Estabelecimento.
	 */
	private String emailEstabelecimento;
	
	/**
	 * Atributo que representa o tipo do Estabelecimento.
	 */
	private String estiloEstabelecimento;
	
	/**
	 * Atributo que representa o valor de entrada do Estabelecimento.
	 */
	private double valorEstabelecimento;
	
	/**
	 * M�todo construtor da classe Estabelecimento.
	 */
	public Estabelecimento() {
	}

	/**
	 * @param idEstabelecimento
	 * @param idCategoriaEstabelecimento
	 * @param nomeEstabelecimento
	 * @param endere�oEstabelecimento
	 * @param cidadeEstabelecimento
	 * @param dddEstabelecimento
	 * @param telefoneEstabelecimento
	 * @param emailEstabelecimento
	 * @param estiloEstabelecimento
	 * @param valorEstabelecimento
	 */
	public Estabelecimento(int idEstabelecimento, int idCategoriaEstabelecimento, String nomeEstabelecimento,
			String endere�oEstabelecimento, String cidadeEstabelecimento, int dddEstabelecimento,
			int telefoneEstabelecimento, String emailEstabelecimento, String estiloEstabelecimento,
			double valorEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
		this.idCategoriaEstabelecimento = idCategoriaEstabelecimento;
		this.nomeEstabelecimento = nomeEstabelecimento;
		this.endere�oEstabelecimento = endere�oEstabelecimento;
		this.cidadeEstabelecimento = cidadeEstabelecimento;
		this.dddEstabelecimento = dddEstabelecimento;
		this.telefoneEstabelecimento = telefoneEstabelecimento;
		this.emailEstabelecimento = emailEstabelecimento;
		this.estiloEstabelecimento = estiloEstabelecimento;
		this.valorEstabelecimento = valorEstabelecimento;
	}

	/**
	 * M�todo que retorna o ID do Estabelecimento.
	 * @return idEstabelecimento
	 */
	public int getIdEstabelecimento() {
		return idEstabelecimento;
	}

	/**
	 * M�todo que atribui o valor do ID do Estabelecimento.
	 * @param int idEstabelecimento
	 */
	public void setIdEstabelecimento(int idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	/**
	 * M�todo que retorna a Categoria do Estabelecimento.
	 * @return categoriaEstabelecimento
	 */
	public int getIdCategoriaEstabelecimento() {
		return idCategoriaEstabelecimento;
	}

	/**
	 * M�todo que atribui o valor da Categoria do Estabelecimento.
	 * @param String categoriaEstabelecimento
	 */
	public void setIdCategoriaEstabelecimento(int idCategoriaEstabelecimento) {
		this.idCategoriaEstabelecimento = idCategoriaEstabelecimento;
	}

	/**
	 * M�todo que retorna o Nome do Estabelecimento.
	 * @return nomeEstabelecimento
	 */
	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	/**
	 * M�todo que atribui o valor do Nome do Estabelecimento.
	 * @param String nomeEstabelecimento
	 */
	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	/**
	 * M�todo que retorna o Endere�o do Estabelecimento.
	 * @return endere�oEstabelecimento
	 */
	public String getEndere�oEstabelecimento() {
		return endere�oEstabelecimento;
	}

	/**
	 * M�todo que atribui o valor do Endere�o do Estabelecimento.
	 * @param String endere�oEstabelecimento
	 */
	public void setEndere�oEstabelecimento(String endere�oEstabelecimento) {
		this.endere�oEstabelecimento = endere�oEstabelecimento;
	}

	/**
	 * M�todo que retorna a Cidade do Estabelecimento.
	 * @return cidadeEstabelecimento
	 */
	public String getCidadeEstabelecimento() {
		return cidadeEstabelecimento;
	}

	/**
	 * M�todo que atribui o valor da Cidade do Estabelecimento.
	 * @param String cidadeEstabelecimento
	 */
	public void setCidadeEstabelecimento(String cidadeEstabelecimento) {
		this.cidadeEstabelecimento = cidadeEstabelecimento;
	}

	/**
	 * M�todo que retorna o DDD do Estabelecimento.
	 * @return dddEstabelecimento
	 */
	public int getDddEstabelecimento() {
		return dddEstabelecimento;
	}

	/**
	 * M�todo que atribui o valor do DDD do Estabelecimento.
	 * @param int dddEstabelecimento
	 */
	public void setDddEstabelecimento(int dddEstabelecimento) {
		this.dddEstabelecimento = dddEstabelecimento;
	}

	/**
	 * M�todo que retorna o telefone do Estabelecimento.
	 * @return telefoneEstabelecimento
	 */
	public int getTelefoneEstabelecimento() {
		return telefoneEstabelecimento;
	}

	/**
	 * M�todo que atribui o valor do Telefone do Estabelecimento.
	 * @param int telefoneEstabelecimento
	 */
	public void setTelefoneEstabelecimento(int telefoneEstabelecimento) {
		this.telefoneEstabelecimento = telefoneEstabelecimento;
	}

	/**
	 * M�todo que retorna o email do Estabelecimento.
	 * @return emailEstabelecimento
	 */
	public String getEmailEstabelecimento() {
		return emailEstabelecimento;
	}

	/**
	 * M�todo que atribui o valor do email do Estabelecimento.
	 * @param String emailEstabelecimento
	 */
	public void setEmailEstabelecimento(String emailEstabelecimento) {
		this.emailEstabelecimento = emailEstabelecimento;
	}

	/**
	 * M�todo que retorna o tipo do Estabelecimento.
	 * @return tipoEstabelecimento
	 */
	public String getEstiloEstabelecimento() {
		return estiloEstabelecimento;
	}

	/**
	 * M�todo que atribui o valor do tipo do Estabelecimento.
	 * @param String tipoEstabelecimento
	 */
	public void setEstiloEstabelecimento(String tipoEstabelecimento) {
		this.estiloEstabelecimento = tipoEstabelecimento;
	}

	/**
	 * M�todo que retorna o valor do Estabelecimento.
	 * @return valorEstabelecimento
	 */
	public double getValorEstabelecimento() {
		return valorEstabelecimento;
	}

	/**
	 * M�todo que atribui o valor do Valor do Estabelecimento.
	 * @param String valorEstabelecimento
	 */
	public void setValorEstabelecimento(double valorEstabelecimento) {
		this.valorEstabelecimento = valorEstabelecimento;
	}	

}
