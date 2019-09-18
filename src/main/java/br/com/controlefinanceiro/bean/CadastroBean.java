package br.com.controlefinanceiro.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import br.com.controlefinanceiro.model.Usuario;
import br.com.controlefinanceiro.util.CryptoUtil;
import br.com.controlefinanceiro.util.Util;

@ManagedBean
@SessionScoped
public class CadastroBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 925736215818479352L;

	private String email;
	private String senha;
	private String nome;

	public void salvarUsuario() {
		Usuario usuario = new Usuario();
		
		usuario.setNome(this.nome);

		usuario.setEmail(this.email);

		try {
			usuario.setSenha(CryptoUtil.encryptAES(this.senha));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		usuario.setAtivo(Boolean.TRUE);

		Usuario u = getFacade().salvarUsuario(usuario);
		
		if (!Util.isEmptyOrNull(u)) {
			addMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário " + u.getNome() + " cadastrado com sucesso!");
		}
		
	}
	
	public void finalizar() {
		redirectToPage("../publico/login.xhtml");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
