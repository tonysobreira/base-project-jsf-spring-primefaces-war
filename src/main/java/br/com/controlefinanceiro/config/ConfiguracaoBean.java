package br.com.controlefinanceiro.config;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;

import br.com.controlefinanceiro.bean.BaseBean;

@ManagedBean
@ApplicationScoped
public class ConfiguracaoBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -4737665106741891079L;
	
	private String tema;
	
	@PostConstruct
	public void init() {
		tema = "omega";
	}
	
	public void trocarTema() {
		System.out.println("Tema selecionado: " + tema);
		
		addMessage(FacesMessage.SEVERITY_INFO, "Tema Selecionado", tema);
	}
	
	// TODO
	public void trocarSenha() {
		
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
