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
package br.opet.tds172a.projetointerdisciplinar.model;

import br.opet.tds172a.projetointerdisciplinar.model.DAO.LogarDAO;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe LogarModel para validar o login de um usu�rio no sistema.
 *
 */
public class LogarModel {
	
	private LogarDAO logarDAO;
	
	/**
	 * M�todo construtor da classe LogarModel
	 * 
	 */
	public LogarModel() {
		
		this.logarDAO = new LogarDAO();
		
	}

	public Usuario efetuarLogin(Usuario usuario) {
		
		return this.logarDAO.efetuarLogin(usuario);
	}

}
