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

import br.opet.tds172a.projetointerdisciplinar.model.DAO.CadastrarNovoUsuarioDAO;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe CadastrarNovoUsuarioModel para validar a efetiva��o do cadastro de um
 * novo usu�rio no sistema.
 *
 */
public class CadastrarNovoUsuarioModel {
	
	private CadastrarNovoUsuarioDAO cadastrarNovoUsuarioDAO;
	
	/**
	 * M�todo construtor da classe CadastrarNovoUsuarioModel
	 * 
	 */
	public CadastrarNovoUsuarioModel() {
		this.cadastrarNovoUsuarioDAO = new CadastrarNovoUsuarioDAO();
	}

	/**
	 * M�todo para Validar o Cadastro de um novo usu�rio no sistema por meio da 
	 * conex�o com a Classe CadastrarNovoUsuarioDAO.
	 * @param usuario
	 * @return boolean deuCerto - confirma��o ou n�o do cadastro no sistema
	 */
	public boolean validarCadastro(Usuario usuario) {
		boolean deuCerto = cadastrarNovoUsuarioDAO.validarCadastro(usuario);
		return deuCerto;
	}

}
