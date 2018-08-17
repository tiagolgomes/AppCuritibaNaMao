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
 * Classe Estabelecimento que contém o objeto Establecimento, seus atributos e
 * métodos contrutor, de retorno e atribuição de seus valores (gets e sets).
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
	 * Atributo que representa o endereço do Estabelecimento.
	 */
	private String endereçoEstabelecimento;
	
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
	 * Método construtor da classe Estabelecimento.
	 */
	public Estabelecimento() {
	}

	/**
	 * @param idEstabelecimento
	 * @param idCategoriaEstabelecimento
	 * @param nomeEstabelecimento
	 * @param endereçoEstabelecimento
	 * @param cidadeEstabelecimento
	 * @param dddEstabelecimento
	 * @param telefoneEstabelecimento
	 * @param emailEstabelecimento
	 * @param estiloEstabelecimento
	 * @param valorEstabelecimento
	 */
	public Estabelecimento(int idEstabelecimento, int idCategoriaEstabelecimento, String nomeEstabelecimento,
			String endereçoEstabelecimento, String cidadeEstabelecimento, int dddEstabelecimento,
			int telefoneEstabelecimento, String emailEstabelecimento, String estiloEstabelecimento,
			double valorEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
		this.idCategoriaEstabelecimento = idCategoriaEstabelecimento;
		this.nomeEstabelecimento = nomeEstabelecimento;
		this.endereçoEstabelecimento = endereçoEstabelecimento;
		this.cidadeEstabelecimento = cidadeEstabelecimento;
		this.dddEstabelecimento = dddEstabelecimento;
		this.telefoneEstabelecimento = telefoneEstabelecimento;
		this.emailEstabelecimento = emailEstabelecimento;
		this.estiloEstabelecimento = estiloEstabelecimento;
		this.valorEstabelecimento = valorEstabelecimento;
	}

	/**
	 * Método que retorna o ID do Estabelecimento.
	 * @return idEstabelecimento
	 */
	public int getIdEstabelecimento() {
		return idEstabelecimento;
	}

	/**
	 * Método que atribui o valor do ID do Estabelecimento.
	 * @param int idEstabelecimento
	 */
	public void setIdEstabelecimento(int idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	/**
	 * Método que retorna a Categoria do Estabelecimento.
	 * @return categoriaEstabelecimento
	 */
	public int getIdCategoriaEstabelecimento() {
		return idCategoriaEstabelecimento;
	}

	/**
	 * Método que atribui o valor da Categoria do Estabelecimento.
	 * @param String categoriaEstabelecimento
	 */
	public void setIdCategoriaEstabelecimento(int idCategoriaEstabelecimento) {
		this.idCategoriaEstabelecimento = idCategoriaEstabelecimento;
	}

	/**
	 * Método que retorna o Nome do Estabelecimento.
	 * @return nomeEstabelecimento
	 */
	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	/**
	 * Método que atribui o valor do Nome do Estabelecimento.
	 * @param String nomeEstabelecimento
	 */
	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	/**
	 * Método que retorna o Endereço do Estabelecimento.
	 * @return endereçoEstabelecimento
	 */
	public String getEndereçoEstabelecimento() {
		return endereçoEstabelecimento;
	}

	/**
	 * Método que atribui o valor do Endereço do Estabelecimento.
	 * @param String endereçoEstabelecimento
	 */
	public void setEndereçoEstabelecimento(String endereçoEstabelecimento) {
		this.endereçoEstabelecimento = endereçoEstabelecimento;
	}

	/**
	 * Método que retorna a Cidade do Estabelecimento.
	 * @return cidadeEstabelecimento
	 */
	public String getCidadeEstabelecimento() {
		return cidadeEstabelecimento;
	}

	/**
	 * Método que atribui o valor da Cidade do Estabelecimento.
	 * @param String cidadeEstabelecimento
	 */
	public void setCidadeEstabelecimento(String cidadeEstabelecimento) {
		this.cidadeEstabelecimento = cidadeEstabelecimento;
	}

	/**
	 * Método que retorna o DDD do Estabelecimento.
	 * @return dddEstabelecimento
	 */
	public int getDddEstabelecimento() {
		return dddEstabelecimento;
	}

	/**
	 * Método que atribui o valor do DDD do Estabelecimento.
	 * @param int dddEstabelecimento
	 */
	public void setDddEstabelecimento(int dddEstabelecimento) {
		this.dddEstabelecimento = dddEstabelecimento;
	}

	/**
	 * Método que retorna o telefone do Estabelecimento.
	 * @return telefoneEstabelecimento
	 */
	public int getTelefoneEstabelecimento() {
		return telefoneEstabelecimento;
	}

	/**
	 * Método que atribui o valor do Telefone do Estabelecimento.
	 * @param int telefoneEstabelecimento
	 */
	public void setTelefoneEstabelecimento(int telefoneEstabelecimento) {
		this.telefoneEstabelecimento = telefoneEstabelecimento;
	}

	/**
	 * Método que retorna o email do Estabelecimento.
	 * @return emailEstabelecimento
	 */
	public String getEmailEstabelecimento() {
		return emailEstabelecimento;
	}

	/**
	 * Método que atribui o valor do email do Estabelecimento.
	 * @param String emailEstabelecimento
	 */
	public void setEmailEstabelecimento(String emailEstabelecimento) {
		this.emailEstabelecimento = emailEstabelecimento;
	}

	/**
	 * Método que retorna o tipo do Estabelecimento.
	 * @return tipoEstabelecimento
	 */
	public String getEstiloEstabelecimento() {
		return estiloEstabelecimento;
	}

	/**
	 * Método que atribui o valor do tipo do Estabelecimento.
	 * @param String tipoEstabelecimento
	 */
	public void setEstiloEstabelecimento(String tipoEstabelecimento) {
		this.estiloEstabelecimento = tipoEstabelecimento;
	}

	/**
	 * Método que retorna o valor do Estabelecimento.
	 * @return valorEstabelecimento
	 */
	public double getValorEstabelecimento() {
		return valorEstabelecimento;
	}

	/**
	 * Método que atribui o valor do Valor do Estabelecimento.
	 * @param String valorEstabelecimento
	 */
	public void setValorEstabelecimento(double valorEstabelecimento) {
		this.valorEstabelecimento = valorEstabelecimento;
	}	

}
