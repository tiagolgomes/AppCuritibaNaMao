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
package br.opet.tds172a.projetointerdisciplinar.model;

import br.opet.tds172a.projetointerdisciplinar.model.DAO.LogarDAO;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe LogarModel para validar o login de um usuário no sistema.
 *
 */
public class LogarModel {
	
	private LogarDAO logarDAO;
	
	/**
	 * Método construtor da classe LogarModel
	 * 
	 */
	public LogarModel() {
		
		this.logarDAO = new LogarDAO();
		
	}

	public Usuario efetuarLogin(Usuario usuario) {
		
		return this.logarDAO.efetuarLogin(usuario);
	}

}
