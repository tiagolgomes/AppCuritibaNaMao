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

import br.opet.tds172a.projetointerdisciplinar.model.CadastrarNovoUsuarioModel;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe CadastrarNovoUsuarioController para validar a efetiva��o do cadastro de um
 * novo usu�rio no sistema.
 *
 */
public class CadastrarNovoUsuarioController {
	
	private CadastrarNovoUsuarioModel cadastrarNovoUsuarioModel;
	
	/**
	 * M�todo construtor da classe CadastrarNovoUsuarioController
	 * 
	 */
	public CadastrarNovoUsuarioController() {
		this.cadastrarNovoUsuarioModel = new CadastrarNovoUsuarioModel();
	}
	
	/**
	 * M�todo para Validar o Cadastro de um novo usu�rio no sistema por meio da 
	 * conex�o com a Classe CadastrarNovoUsuarioModel.
	 * @param usuario
	 * @return boolean deuCerto - confirma��o ou n�o do cadastro no sistema
	 */
	public boolean validarCadastro(Usuario usuario) {
		return cadastrarNovoUsuarioModel.validarCadastro(usuario);
	}

}
