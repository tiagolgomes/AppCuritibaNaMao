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

import java.util.List;

import br.opet.tds172a.projetointerdisciplinar.model.UsuarioModel;
import br.opet.tds172a.projetointerdisciplinar.vo.Estabelecimento;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe UsuarioController para realizar as solicitações do usuário no Menu
 * Usuário.
 *
 */
public class UsuarioController {
	
	private UsuarioModel usuarioModel;
	
	/**
	 * Método construtor da classe UsuarioController
	 * 
	 */
	public UsuarioController() {
		usuarioModel = new UsuarioModel();
	}
	
	int deucerto;
	
	public boolean cadastrarEstabelecimento(Estabelecimento estabelecimentoNovo, Usuario usuario) {
		boolean deuCerto = false;
		deuCerto = usuarioModel.cadastrarEstabelecimento(estabelecimentoNovo, usuario);
		return deuCerto;
	}
	
	public boolean cadastrarUsuario(Usuario usuarioNovo) {
		boolean deuCerto = false;
		deuCerto = usuarioModel.cadastrarUsuario(usuarioNovo);
		return deuCerto;
	}
	
	public List<Estabelecimento> consultarEstabelecimento(Estabelecimento estabelecimentoConsultar) {
		List<Estabelecimento> listaEstabelecimentos = null;
		listaEstabelecimentos = usuarioModel.consultarEstabelecimento(estabelecimentoConsultar);
		return listaEstabelecimentos;
	}
	
	public List<Usuario> consultarUsuario(Usuario usuarioConsultar) {
		List<Usuario> listaUsuario = null;
		listaUsuario = usuarioModel.consultarUsuario(usuarioConsultar);
		return listaUsuario;
	}
	
	public boolean alterarEstabelecimento(Estabelecimento estabelecimentoAlterar, String dadoEstabelecimentoAlterar, String dadoEstabelecimento) {
		boolean deuCerto = false;
		deuCerto = usuarioModel.alterarEstabelecimento(estabelecimentoAlterar, dadoEstabelecimentoAlterar, dadoEstabelecimento);
		return deuCerto;
	}
	
	public boolean alterarUsuario(Usuario usuarioAlterar, String dadoUsuarioAlterar, String dadoUsuario) {
		boolean deuCerto = false;
		deuCerto = usuarioModel.alterarUsuario(usuarioAlterar, dadoUsuarioAlterar, dadoUsuario);
		return deuCerto;
	}
	
	public boolean excluirEstabelecimento(Estabelecimento estabelecimentoExcluir) {
		boolean deuCerto = false;
		deuCerto = usuarioModel.excluirEstabelecimento(estabelecimentoExcluir);
		return deuCerto;
	}
	
	public boolean excluirUsuario(Usuario usuarioExcluir) {
		boolean deuCerto = false;
		deuCerto = usuarioModel.excluirUsuario(usuarioExcluir);
		return deuCerto;
	}

	public Usuario buscarUsuario(int idUsuario) {
		Usuario buscarUsuario = usuarioModel.buscarUsuario(idUsuario);
		return buscarUsuario;
	}

	public int consultarQuantidadeEstabelecimento(Usuario usuarioExcluir) {
		int qtoEstab = usuarioModel.consultarQuantidadeEstabelecimento(usuarioExcluir);
		return qtoEstab;
	}

	public boolean verificarProprioEstabelecimento(Estabelecimento estabelecimentoExcluir, Usuario usuario) {
		boolean deuCerto = false;
		deuCerto = usuarioModel.verificarProprioEstabelecimento(estabelecimentoExcluir, usuario);
		return deuCerto;
	}

}
