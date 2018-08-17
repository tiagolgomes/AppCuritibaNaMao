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

import br.opet.tds172a.projetointerdisciplinar.model.DAO.CadastrarNovoUsuarioDAO;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe CadastrarNovoUsuarioModel para validar a efetivação do cadastro de um
 * novo usuário no sistema.
 *
 */
public class CadastrarNovoUsuarioModel {
	
	private CadastrarNovoUsuarioDAO cadastrarNovoUsuarioDAO;
	
	/**
	 * Método construtor da classe CadastrarNovoUsuarioModel
	 * 
	 */
	public CadastrarNovoUsuarioModel() {
		this.cadastrarNovoUsuarioDAO = new CadastrarNovoUsuarioDAO();
	}

	/**
	 * Método para Validar o Cadastro de um novo usuário no sistema por meio da 
	 * conexão com a Classe CadastrarNovoUsuarioDAO.
	 * @param usuario
	 * @return boolean deuCerto - confirmação ou não do cadastro no sistema
	 */
	public boolean validarCadastro(Usuario usuario) {
		boolean deuCerto = cadastrarNovoUsuarioDAO.validarCadastro(usuario);
		return deuCerto;
	}

}
