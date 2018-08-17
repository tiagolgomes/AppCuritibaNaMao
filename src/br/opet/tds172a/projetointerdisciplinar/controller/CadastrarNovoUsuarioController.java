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

import br.opet.tds172a.projetointerdisciplinar.model.CadastrarNovoUsuarioModel;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe CadastrarNovoUsuarioController para validar a efetivação do cadastro de um
 * novo usuário no sistema.
 *
 */
public class CadastrarNovoUsuarioController {
	
	private CadastrarNovoUsuarioModel cadastrarNovoUsuarioModel;
	
	/**
	 * Método construtor da classe CadastrarNovoUsuarioController
	 * 
	 */
	public CadastrarNovoUsuarioController() {
		this.cadastrarNovoUsuarioModel = new CadastrarNovoUsuarioModel();
	}
	
	/**
	 * Método para Validar o Cadastro de um novo usuário no sistema por meio da 
	 * conexão com a Classe CadastrarNovoUsuarioModel.
	 * @param usuario
	 * @return boolean deuCerto - confirmação ou não do cadastro no sistema
	 */
	public boolean validarCadastro(Usuario usuario) {
		return cadastrarNovoUsuarioModel.validarCadastro(usuario);
	}

}
