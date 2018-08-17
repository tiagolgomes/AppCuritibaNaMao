package br.opet.tds172a.projetointerdisciplinar.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.opet.tds172a.projetointerdisciplinar.controller.UsuarioController;
import br.opet.tds172a.projetointerdisciplinar.vo.Estabelecimento;
import br.opet.tds172a.projetointerdisciplinar.vo.Usuario;

@ManagedBean(name = "usuarioBean", eager = true)
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = -2521337241959806514L;
	
	private static final int ADMINISTRADOR = 1;
	private static final int PROMOTER = 2;
	//private static final int USUARIO = 3;
	
	private UsuarioController usuarioController;
	
	// CRIAÇÃO DO CROSSBEAN e CRIAÇÃO DO GET e SET
	
	@ManagedProperty(value = "#{logarBean}")
	private LogarBean logarBean;
	
	public LogarBean getLogarBean() {
		return logarBean;
	}

	public void setLogarBean(LogarBean logarBean) {
		this.logarBean = logarBean;
	}

	public Usuario getUsuario() {
		return logarBean.getUsuario();
	}
	
	public void setUsuarioBean(Usuario usuario) {
		logarBean.setUsuario(usuario);
	}
	
	// CRIAÇÃO DE OBJETOS AUXILIARES

	private Usuario usuarioNovo;
	private Usuario usuarioConsultar;
	private Usuario usuarioAlterar;
	private Usuario usuarioExcluir;
	private Estabelecimento estabelecimentoNovo;
	private Estabelecimento estabelecimentoConsultar;
	private Estabelecimento estabelecimentoAlterar;
	private Estabelecimento estabelecimentoExcluir;
	
	private List<Usuario> listaUsuarios;
	private List<Estabelecimento> listaEstabelecimentos;
	
	private String dadoEstabelecimentoAlterar;
	private String dadoEstabelecimento;
	private String dadoUsuarioAlterar;
	private String dadoUsuario;
	
	// GET E SET OBJETOS AUXILIARES
	
	public Usuario getUsuarioNovo() {
		return usuarioNovo;
	}

	public void setUsuarioNovo(Usuario novoUsuario) {
		this.usuarioNovo = novoUsuario;
	}
	
	public Usuario getUsuarioConsultar() {
		return usuarioConsultar;
	}

	public void setUsuarioConsultar(Usuario usuarioConsultar) {
		this.usuarioConsultar = usuarioConsultar;
	}

	public Usuario getUsuarioAlterar() {
		return usuarioAlterar;
	}

	public void setUsuarioAlterar(Usuario usuarioAlterar) {
		this.usuarioAlterar = usuarioAlterar;
	}
	
	public Usuario getUsuarioExcluir() {
		return usuarioExcluir;
	}

	public void setUsuarioExcluir(Usuario excluirUsuario) {
		this.usuarioExcluir = excluirUsuario;
	}
	
	public Estabelecimento getEstabelecimentoNovo() {
		return estabelecimentoNovo;
	}

	public void setEstabelecimentoNovo(Estabelecimento estabelecimentoNovo) {
		this.estabelecimentoNovo = estabelecimentoNovo;
	}

	public Estabelecimento getEstabelecimentoConsultar() {
		return estabelecimentoConsultar;
	}

	public void setEstabelecimentoConsultar(Estabelecimento estabelecimentoConsultar) {
		this.estabelecimentoConsultar = estabelecimentoConsultar;
	}

	public Estabelecimento getEstabelecimentoAlterar() {
		return estabelecimentoAlterar;
	}

	public void setEstabelecimentoAlterar(Estabelecimento estabelecimentoAlterar) {
		this.estabelecimentoAlterar = estabelecimentoAlterar;
	}

	public Estabelecimento getEstabelecimentoExcluir() {
		return estabelecimentoExcluir;
	}

	public void setEstabelecimentoExcluir(Estabelecimento estabelecimentoExcluir) {
		this.estabelecimentoExcluir = estabelecimentoExcluir;
	}
	
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Estabelecimento> getListaEstabelecimentos() {
		return listaEstabelecimentos;
	}

	public void setListaEstabelecimentos(List<Estabelecimento> listaEstabelecimentos) {
		this.listaEstabelecimentos = listaEstabelecimentos;
	}
	
	public String getDadoEstabelecimentoAlterar() {
		return dadoEstabelecimentoAlterar;
	}

	public void setDadoEstabelecimentoAlterar(String dadoEstabelecimentoAlterar) {
		this.dadoEstabelecimentoAlterar = dadoEstabelecimentoAlterar;
	}
	
	public String getDadoEstabelecimento() {
		return dadoEstabelecimento;
	}

	public void setDadoEstabelecimento(String dadoEstabelecimento) {
		this.dadoEstabelecimento = dadoEstabelecimento;
	}

	public String getDadoUsuarioAlterar() {
		return dadoUsuarioAlterar;
	}

	public void setDadoUsuarioAlterar(String dadoUsuarioAlterar) {
		this.dadoUsuarioAlterar = dadoUsuarioAlterar;
	}
	
	public String getDadoUsuario() {
		return dadoUsuario;
	}

	public void setDadoUsuario(String dadoUsuario) {
		this.dadoUsuario = dadoUsuario;
	}
	
	// MÉTODO CONSTRUTOR DA CLASSE

	public UsuarioBean() {
		this.usuarioController = new UsuarioController();
		
		this.usuarioNovo = new Usuario();
		this.usuarioConsultar = new Usuario();
		this.usuarioAlterar = new Usuario();
		this.usuarioExcluir = new Usuario();
		this.estabelecimentoNovo = new Estabelecimento();
		this.estabelecimentoConsultar = new Estabelecimento();
		this.estabelecimentoAlterar = new Estabelecimento();
		this.estabelecimentoExcluir = new Estabelecimento();
		
		this.listaUsuarios = new ArrayList<Usuario>();
		this.listaEstabelecimentos = new ArrayList<Estabelecimento>();
		
		setDadoEstabelecimentoAlterar(null);
		setDadoEstabelecimento(null);
		setDadoUsuarioAlterar(null);
		setDadoUsuario(null);
		
	}
	
	// MÉTODO NOVO ESTABELECIMENTO
	
	public String cadastrarNovoEstabelecimento() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		boolean deuCerto;
		String siteRetorno;
		System.out.println(logarBean.getUsuario().getIdUsuario());
		deuCerto = this.usuarioController.cadastrarEstabelecimento(estabelecimentoNovo, logarBean.getUsuario());
		if(deuCerto) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cadastro realizado com sucesso.", null));
			this.estabelecimentoNovo = new Estabelecimento();
			if (logarBean.getUsuario().getIdUsuario() == ADMINISTRADOR) {
				siteRetorno = "/paginas/menu/menuAdministrador";
			}
			else {
				siteRetorno = "/paginas/menu/menuPromoter";
			}
		}
		else {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível realizar o cadastro, tente mais tarde. ", null));
			this.estabelecimentoNovo = new Estabelecimento();
			if (logarBean.getUsuario().getIdUsuario() == ADMINISTRADOR) {
				siteRetorno = "/paginas/menu/menuAdministrador";
			}
			else {
				siteRetorno = "/paginas/menu/menuPromoter";
			}
		}
		return siteRetorno;
	}
	
	// MÉTODO NOVO USUÁRIO
	
	public String fazerCadastroNovoUsuario() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		boolean deuCerto;
		deuCerto = this.usuarioController.cadastrarUsuario(usuarioNovo);
		if(deuCerto) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cadastro realizado com sucesso.", null));
			this.usuarioNovo = new Usuario();
			return "/paginas/menu/menuAdministrador";
		}
		else {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível realizar o cadastro, tente mais tarde. ", null));
			this.usuarioNovo = new Usuario();
			return "/paginas/menu/menuAdministrador";
		}
	}
	
	// MÉTODO CONSULTAR ESTABELECIMENTO
	
	public void consultarEstabelecimentoId() {
		consultarEstabelecimento(estabelecimentoConsultar);
		this.estabelecimentoConsultar = new Estabelecimento();
	}
	
	public void consultarEstabelecimentoCategoria() {
		consultarEstabelecimento(estabelecimentoConsultar);
		this.estabelecimentoConsultar = new Estabelecimento();
	}
	
	public void consultarEstabelecimentoLista() {
		estabelecimentoConsultar = null;
		consultarEstabelecimento(estabelecimentoConsultar);
		this.estabelecimentoConsultar = new Estabelecimento();
	}
	
	public void consultarEstabelecimento(Estabelecimento estabelecimentoConsultar){
		FacesContext contexto = FacesContext.getCurrentInstance();
		listaEstabelecimentos = usuarioController.consultarEstabelecimento(estabelecimentoConsultar);
		if (listaEstabelecimentos == null) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foram encontrados Estabelecimentos.", null));
		}
		this.estabelecimentoConsultar = new Estabelecimento();
	}
	
	// MÉTODO CONSULTAR USUÁRIO
	
	public void consultarUsuarioId() {
		consultarUsuario(usuarioConsultar);
		this.usuarioConsultar = new Usuario();
	}
	
	public void consultarUsuarioTipo() {
		consultarUsuario(usuarioConsultar);
		this.usuarioConsultar = new Usuario();
	}
	
	public void consultarUsuarioLista() {
		usuarioConsultar = null;
		consultarUsuario(usuarioConsultar);
		this.usuarioConsultar = new Usuario();
	}
	
	public void consultarUsuarioProprio() {
		usuarioConsultar.setIdUsuario(logarBean.getUsuario().getIdUsuario());
		consultarUsuario(usuarioConsultar);
		this.usuarioConsultar = new Usuario();
	}
	
	public void consultarUsuario(Usuario usuarioConsultar) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		listaUsuarios = usuarioController.consultarUsuario(usuarioConsultar);
		if (listaUsuarios == null) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foram encontrados Usuários.", null));
		}
		this.usuarioConsultar = new Usuario();
	}
	
	// MÉTODO ALTERAR ESTABELECIMENTO
	
	public void alterarEstabelecimentoCarregarMetodo() {
		alterarEstabelecimento(estabelecimentoAlterar, dadoEstabelecimentoAlterar, dadoEstabelecimento);
	}
	
	public void alterarEstabelecimento(Estabelecimento estabelecimentoAlterar, String dadoEstabelecimentoAlterar, String dadoEstabelecimento) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		boolean deuCerto;
		boolean proprioEstabelecimento;
		if (logarBean.getUsuario().getIdTipoUsuario() == ADMINISTRADOR) {
			deuCerto = usuarioController.alterarEstabelecimento(estabelecimentoAlterar, dadoEstabelecimentoAlterar, dadoEstabelecimento);
			if (deuCerto) {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estabelecimento alterado com Sucesso!", null));
			}
			else {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possível alterar Estabelecimento, tente mais tarde.", null));
			}
		}
		else {
			proprioEstabelecimento = usuarioController.verificarProprioEstabelecimento(estabelecimentoAlterar, logarBean.getUsuario());
			if (proprioEstabelecimento) {
				deuCerto = usuarioController.alterarEstabelecimento(estabelecimentoAlterar, dadoEstabelecimentoAlterar, dadoEstabelecimento);
				if (deuCerto) {
					contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estabelecimento alterado com Sucesso!", null));
				}
				else {
					contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possível alterar Estabelecimento, tente mais tarde.", null));
				}
			}
			else {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível alterar Estabelecimento, pois não está vinculado a seu Usuário.", null));
			}
		}
		this.estabelecimentoAlterar = new Estabelecimento();
		this.dadoEstabelecimentoAlterar = null;
		this.dadoEstabelecimento = null;
	}
	
	// MÉTODO ALTERAR USUÁRIO
	
	public void alterarUsuarioCarregarMetodo() {
		alterarUsuario(usuarioAlterar, dadoUsuarioAlterar, dadoUsuario);
	}
	
	public void alterarUsuario(Usuario usuarioAlterar, String dadoUsuarioAlterar, String dadoUsuario) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		boolean deuCerto;
		if (logarBean.getUsuario().getIdTipoUsuario() == ADMINISTRADOR) {
			deuCerto = usuarioController.alterarUsuario(usuarioAlterar, dadoUsuarioAlterar, dadoUsuario);
			if (deuCerto) {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário alterado com Sucesso!", null));
			}
			else {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possível alterar o Usuário, tente mais tarde.", null));
			}
		}
		else {
			usuarioAlterar.setIdUsuario(logarBean.getUsuario().getIdUsuario());
			deuCerto = usuarioController.alterarUsuario(usuarioAlterar, dadoUsuarioAlterar, dadoUsuario);
			if (deuCerto) {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário alterado com Sucesso!", null));
			}
			else {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possível alterar o Usuário, tente mais tarde.", null));
			}
			}
		this.usuarioAlterar = new Usuario();
		this.dadoUsuarioAlterar = null;
		this.dadoUsuario = null;
	}
	
	// MÉTODO EXCLUIR ESTABELECIMENTO
	
	public void excluirEstabelecimentoCarregarMetodo() {
		excluirEstabelecimento(estabelecimentoExcluir, logarBean.getUsuario());
	}
	
	public boolean excluirEstabelecimento(Estabelecimento estabelecimentoExcluir, Usuario usuario) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		boolean deuCerto;
		boolean proprioEstabelecimento;
		if (logarBean.getUsuario().getIdTipoUsuario() == ADMINISTRADOR) {
			deuCerto = usuarioController.excluirEstabelecimento(estabelecimentoExcluir);
			if (deuCerto) {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estabelecimento excluído com Sucesso!", null));
			}
			else {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possível excluir Estabelecimento, tente mais tarde.", null));
			}
		}
		else {
			proprioEstabelecimento = usuarioController.verificarProprioEstabelecimento(estabelecimentoExcluir, logarBean.getUsuario());
			if (proprioEstabelecimento) {
				deuCerto = usuarioController.excluirEstabelecimento(estabelecimentoExcluir);
				if (deuCerto) {
					contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estabelecimento excluído com Sucesso!", null));
				}
				else {
					contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possível excluir Estabelecimento, tente mais tarde.", null));
				}
			}
			else {
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível excluir Estabelecimento, pois não está vinculado a seu Usuário.", null));
			}
		}
		this.estabelecimentoExcluir = new Estabelecimento();
		return false;
	}
	
	// MÉTODO EXCLUIR USUÁRIO
	
	public String excluirPorId() {
		String siteRetorno = excluirUsuario(usuarioExcluir);
		this.usuarioExcluir = new Usuario();
		return siteRetorno; 
	}
	
	public String excluirASiMesmo() {
		usuarioExcluir.setIdUsuario(logarBean.getUsuario().getIdUsuario());
		String siteRetorno = excluirUsuario(usuarioExcluir);
		this.usuarioExcluir = new Usuario();
		return siteRetorno; 
	} 
	
	private String excluirUsuario(Usuario usuarioExcluir) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		boolean deuCerto;
		String siteRetorno;
		int qtoEstab = consultarQuantidadeEstabelecimento(usuarioExcluir);
		if(qtoEstab == 0) {
			if(logarBean.getUsuario().getIdTipoUsuario() == ADMINISTRADOR) {
				if(logarBean.getUsuario().getIdUsuario() == usuarioExcluir.getIdUsuario()) {
					deuCerto = usuarioController.excluirUsuario(usuarioExcluir);
					if(deuCerto) {
						logarBean.setUsuario(new Usuario());
						contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Conta excluída com Sucesso!", null));
						siteRetorno = "/paginas/index";
					}
					else {
						contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível excluir Usuário, tente novamente mais tarde.", null));
						siteRetorno = "/paginas/menu/administrador/excluirUsuario";
					}
				}
				else {
					System.out.println(usuarioExcluir.getIdUsuario());
					deuCerto = usuarioController.excluirUsuario(usuarioExcluir);
					if(deuCerto) {
						contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário excluido com Sucesso!", null));
						siteRetorno = "/paginas/menu/administrador/excluirUsuario";
					}
					else {
						contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível excluir Usuário, tente novamente mais tarde.", null));
						siteRetorno = "/paginas/menu/administrador/excluirUsuario";
					}
				}
			}
			else {
				deuCerto = usuarioController.excluirUsuario(usuarioExcluir);
				if(deuCerto) {
					logarBean.setUsuario( new Usuario());
					contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Conta excluída com Sucesso!", null));
					siteRetorno = "/paginas/index";
				}
				else {
					contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível excluir Usuário, tente novamente mais tarde.", null));
					if (logarBean.getUsuario().getIdTipoUsuario() == PROMOTER) {
						siteRetorno = "/paginas/menu/menuPromoter";
					}
					else {
						siteRetorno = "/paginas/menu/menuUsuario";
					}
				}
			}
		}
		else {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não é possível excluir Usuário, pois há Estabelecimentos vinculados a ele.", null));
			if(logarBean.getUsuario().getIdTipoUsuario() == ADMINISTRADOR) {
				siteRetorno = "/paginas/menu/administrador/excluirUsuario";
			}
			else if (logarBean.getUsuario().getIdTipoUsuario() == PROMOTER) {
				siteRetorno = "/paginas/menu/menuPromoter";
			}
			else {
				siteRetorno = "/paginas/menu/menuUsuario";
			}
		}
		return siteRetorno;
	}
	
	// MÉTODOS AUXILIARES
	
	private int consultarQuantidadeEstabelecimento(Usuario usuarioExcluir) {
		int qtoEstab;
		qtoEstab = usuarioController.consultarQuantidadeEstabelecimento(usuarioExcluir);
		return qtoEstab;
	}
	
}
