package br.opet.tds172a.projetointerdisciplinar.bean;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import br.opet.tds172a.projetointerdisciplinar.controller.LogarController;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;


@ManagedBean(name = "logarBean", eager = true)
@SessionScoped
public class LogarBean implements Serializable {
	
	private static final long serialVersionUID = 3426885213664173025L;
	
	private Usuario usuario; 
	
	private LogarController logarController;
	
	private static final int ADMINISTRADOR = 1;
	private static final int PROMOTER = 2;
	private static final int USUARIO = 3;

	public LogarBean() {
		this.setUsuario(new Usuario());
		this.logarController = new LogarController();
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String efetuarLogin() {
		
		FacesContext contexto = FacesContext.getCurrentInstance();

		this.usuario = this.logarController.efetuarLogin(usuario);

		if (this.usuario == null) {
			this.usuario = new Usuario();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou Senha Inválidos!", null));
			return "/paginas/login/login";
		} 
		
		else {

			if(this.usuario.getIdTipoUsuario() == ADMINISTRADOR) {
				return "/paginas/menu/menuAdministrador";
			}
			else if (this.usuario.getIdTipoUsuario() == PROMOTER) {
				return "/paginas/menu/menuPromoter";
			}
			else if (this.usuario.getIdTipoUsuario() == USUARIO) {
				return "/paginas/menu/menuUsuario";
			}
			else {
				this.usuario = new Usuario();
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou Senha Inválidos!", null));
				return "/paginas/login/login";
			}
		}
	}
	
	public String efetuarLogout() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		this.usuario = new Usuario();
		contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Logout realizado!", null));
		return "/paginas/index";
	}
	
	public String voltarLogin() {
		this.usuario = new Usuario();
		return "/paginas/index";
	}

}
