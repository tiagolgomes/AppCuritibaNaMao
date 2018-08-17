package br.opet.tds172a.projetointerdisciplinar.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "navegabilidadeBean", eager = true)
@SessionScoped
public class NavegabilidadeBean implements Serializable {

	private static final long serialVersionUID = -597155735598949715L;

	public NavegabilidadeBean() {

	}

	// PÁGINAS GENÉRICAS

	public String carregarPaginaIndex() {
		return "/paginas/index";
	}

	public String carregarPaginaCadastrarNovoUsuario() {
		return "/paginas/novoUsuario/novoUsuario";
	}

	public String carregarPaginaLogin() {
		return "/paginas/login/login";
	}

	// MENU DE ACORDO COM TIPO DE USUÁRIO

	public String carregarMenuAdministrador() {
		return "/paginas/menu/menuAdministrador";
	}

	public String carregarMenuPromoter() {
		return "/paginas/menu/menuPromoter";
	}

	public String carregarMenuUsuario() {
		return "/paginas/menu/menuUsuario";
	}

	// PÁGINAS RELACIONADAS AO MENU DO ADMINISTRADOR

	public String carregarMenuAdministradorNovoEstabelecimento() {
		return "/paginas/menu/administrador/cadastrarEstabelecimento";
	}

	public String carregarMenuAdministradorNovoUsuario() {
		return "/paginas/menu/administrador/cadastrarUsuario";
	}

	public String carregarMenuAdministradorConsultarEstabelecimento() {
		return "/paginas/menu/administrador/consultarEstabelecimento";
	}

	public String carregarMenuAdministradorConsultarUsuario() {
		return "/paginas/menu/administrador/consultarUsuario";
	}

	public String carregarMenuAdministradorAlterarEstabelecimento() {
		return "/paginas/menu/administrador/alterarEstabelecimento";
	}

	public String carregarMenuAdministradorAlterarUsuario() {
		return "/paginas/menu/administrador/alterarUsuario";
	}

	public String carregarMenuAdministradorExcluirEstabelecimento() {
		return "/paginas/menu/administrador/excluirEstabelecimento";
	}

	public String carregarMenuAdministradorExcluirUsuario() {
		return "/paginas/menu/administrador/excluirUsuario";
	}

	// PÁGINAS RELACIONADAS AO MENU DO PROMOTER

	public String carregarMenuPromoterNovoEstabelecimento() {
		return "/paginas/menu/promoter/cadastrarEstabelecimento";
	}

	public String carregarMenuPromoterConsultarEstabelecimento() {
		return "/paginas/menu/promoter/consultarEstabelecimento";
	}

	public String carregarMenuPromoterConsultarUsuario() {
		return "/paginas/menu/promoter/consultarUsuario";
	}

	public String carregarMenuPromoterAlterarEstabelecimento() {
		return "/paginas/menu/promoter/alterarEstabelecimento";
	}

	public String carregarMenuPromoterAlterarUsuario() {
		return "/paginas/menu/promoter/alterarUsuario";
	}

	public String carregarMenuPromoterExcluirEstabelecimento() {
		return "/paginas/menu/promoter/excluirEstabelecimento";
	}

	public String carregarMenuPromoterExcluirUsuario() {
		return "/paginas/menu/promoter/excluirUsuario";
	}

	// PÁGINAS RELACIONADAS AO MENU DO USÁRIO

	public String carregarMenuUsuarioConsultarEstabelecimento() {
		return "/paginas/menu/usuario/consultarEstabelecimento";
	}

	public String carregarMenuUsuarioConsultarUsuario() {
		return "/paginas/menu/usuario/consultarUsuario";
	}

	public String carregarMenuUsuarioAlterarUsuario() {
		return "/paginas/menu/usuario/alterarUsuario";
	}

	public String carregarMenuUsuarioExcluirUsuario() {
		return "/paginas/menu/usuario/excluirUsuario";
	}

}
