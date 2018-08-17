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
package br.opet.tds172a.projetointerdisciplinar.controller;

import br.opet.tds172a.projetointerdisciplinar.model.LogarModel;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe LogarController para validar a efetivação do login de um usuário no
 * sistema.
 *
 */
public class LogarController {
	
	private LogarModel logarModel;
	
	/**
	 * Método construtor da classe LogarController
	 * 
	 */
	public LogarController() {
		
		this.logarModel = new LogarModel();
		
	}

	public Usuario efetuarLogin(Usuario usuario) {
		
		return this.logarModel.efetuarLogin(usuario);
		
	}

}
