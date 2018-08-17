package br.opet.tds172a.projetointerdisciplinar.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.opet.tds172a.projetointerdisciplinar.controller.CadastrarNovoUsuarioController;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

@Named("cadastrarNovoUsuarioBean")
@SessionScoped

public class CadastrarNovoUsuarioBean implements Serializable {

	private static final long serialVersionUID = -5984265005407567705L;
	
	private Usuario usuario;
	
	private CadastrarNovoUsuarioController cadastrarNovoUsuarioController;

	public CadastrarNovoUsuarioBean() {
		this.setUsuario(new Usuario());
		this.cadastrarNovoUsuarioController = new CadastrarNovoUsuarioController();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String validarCadastro() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		boolean deuCerto;
		deuCerto = this.cadastrarNovoUsuarioController.validarCadastro(usuario);
		if(deuCerto) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cadastro realizado com sucesso.", null));
			this.usuario = new Usuario();
			return "/paginas/index";
		}
		else {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível realizar o cadastro, tente mais tarde. ", null));
			this.usuario = new Usuario();
			return "/paginas/novoUsuario/novoUsuario";
		}
	}
}
