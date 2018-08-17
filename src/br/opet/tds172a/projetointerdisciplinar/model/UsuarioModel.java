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

import java.util.List;

import br.opet.tds172a.projetointerdisciplinar.model.DAO.UsuarioDAO;
import br.opet.tds172a.projetointerdisciplinar.vo.Estabelecimento;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

/**
 * Classe UsuarioModel para validar as solicitações do usuário.
 *
 */
public class UsuarioModel {
	
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Método construtor da classe UsuarioModel
	 * 
	 */
	public UsuarioModel() {
		this.usuarioDAO = new UsuarioDAO();
	}

	public boolean cadastrarEstabelecimento(Estabelecimento estabelecimentoNovo, Usuario usuario) {
		boolean deuCerto = false;
		deuCerto = usuarioDAO.cadastrarEstabelecimento(estabelecimentoNovo, usuario);
		return deuCerto;
	}

	public boolean cadastrarUsuario(Usuario usuarioNovo) {
		boolean deuCerto = false;
		deuCerto = usuarioDAO.cadastrarUsuario(usuarioNovo);
		return deuCerto;
	}
	
	public List<Estabelecimento> consultarEstabelecimento(Estabelecimento estabelecimentoConsultar) {
		List<Estabelecimento> listaEstabelecimentos = null;
		listaEstabelecimentos = usuarioDAO.consultarEstabelecimento(estabelecimentoConsultar);
		return listaEstabelecimentos;
	}
	
	public List<Usuario> consultarUsuario(Usuario usuarioConsultar) {
		List<Usuario> listaUsuario = null;
		listaUsuario = usuarioDAO.consultarUsuario(usuarioConsultar);
		return listaUsuario;
	}

	public boolean alterarEstabelecimento(Estabelecimento estabelecimentoAlterar, String dadoEstabelecimentoAlterar, String dadoEstabelecimento) {
		boolean deuCerto = false;
		deuCerto = usuarioDAO.alterarEstabelecimento(estabelecimentoAlterar, dadoEstabelecimentoAlterar, dadoEstabelecimento);
		return deuCerto;
	}

	public boolean alterarUsuario(Usuario usuarioAlterar, String dadoUsuarioAlterar, String dadoUsuario) {
		boolean deuCerto = false;
		deuCerto = usuarioDAO.alterarUsuario(usuarioAlterar, dadoUsuarioAlterar, dadoUsuario);
		return deuCerto;
	}

	public boolean excluirEstabelecimento(Estabelecimento estabelecimentoExcluir) {
		boolean deuCerto = false;
		deuCerto = usuarioDAO.excluirEstabelecimento(estabelecimentoExcluir);
		return deuCerto;
	}

	public boolean excluirUsuario(Usuario usuarioExcluir) {
		boolean deuCerto = false;
		deuCerto = usuarioDAO.excluirUsuario(usuarioExcluir);
		return deuCerto;
	}

	public Usuario buscarUsuario(int idUsuario) {
		Usuario buscarUsuario = usuarioDAO.buscarUsuario(idUsuario);
		return buscarUsuario;
	}

	public int consultarQuantidadeEstabelecimento(Usuario usuarioExcluir) {
		int qtoEstab = usuarioDAO.consultarQuantidadeEstabelecimento(usuarioExcluir);
		return qtoEstab;
	}

	public boolean verificarProprioEstabelecimento(Estabelecimento estabelecimentoExcluir, Usuario usuario) {
		boolean deuCerto = false;
		deuCerto = usuarioDAO.verificarProprioEstabelecimento(estabelecimentoExcluir, usuario);
		return deuCerto;
	}

}
