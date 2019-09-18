package br.com.controlefinanceiro.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@SessionScoped
public class UsuarioBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 8305131161062061972L;
	
	public String getNomeUsuario() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			return SecurityContextHolder.getContext().getAuthentication().getName();
		}

		return "";
	}

}
