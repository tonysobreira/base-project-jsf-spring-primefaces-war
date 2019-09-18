package br.com.controlefinanceiro.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@SessionScoped
public class LoginBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 7413858190206623738L;

	private String email;
	private String senha;

	@Autowired
	private AuthenticationManager authenticationManager;

	public void login() {

		try {

			Authentication authRequest = new UsernamePasswordAuthenticationToken(this.email, this.senha);
			Authentication authentication = authenticationManager.authenticate(authRequest);
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			
			redirectToPage("../restrito/paginainicial.xhtml");
		} catch (BadCredentialsException be) {
			// Exceção para credenciais inválidas
			
			// Growl
			addMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "Email/Senha Errado!");
			
			// Dialog
			//showDialog(FacesMessage.SEVERITY_WARN, "Aviso!", "Email/Senha Errado!");
			
			//be.printStackTrace();
		}

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

}
