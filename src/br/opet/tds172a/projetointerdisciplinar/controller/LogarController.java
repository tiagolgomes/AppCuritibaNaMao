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
package br.opet.tds172a.projetointerdisciplinar.controller;

import br.opet.tds172a.projetointerdisciplinar.model.LogarModel;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe LogarController para validar a efetiva��o do login de um usu�rio no
 * sistema.
 *
 */
public class LogarController {
	
	private LogarModel logarModel;
	
	/**
	 * M�todo construtor da classe LogarController
	 * 
	 */
	public LogarController() {
		
		this.logarModel = new LogarModel();
		
	}

	public Usuario efetuarLogin(Usuario usuario) {
		
		return this.logarModel.efetuarLogin(usuario);
		
	}

}
