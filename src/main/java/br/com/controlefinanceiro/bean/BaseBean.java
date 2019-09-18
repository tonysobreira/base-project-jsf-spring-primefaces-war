package br.com.controlefinanceiro.bean;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.controlefinanceiro.facade.ICFFacade;

public abstract class BaseBean {

	@Autowired
	private ICFFacade facade;

	public ICFFacade getFacade() {
		return facade;
	}

	public void setFacade(ICFFacade facade) {
		this.facade = facade;
	}
	
	/**
	 * Exibe mensagem em growl
	 * @param severity
	 * @param summary
	 * @param detail
	 */
	public void addMessage(Severity severity, String summary, String detail) {
		FacesMessage message = new FacesMessage(severity, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	/**
	 * Exibe mensagem em um dialog
	 * @param severity
	 * @param summary
	 * @param detail
	 */
	public void showDialog(Severity severity, String summary, String detail) {
		FacesMessage message = new FacesMessage(severity, summary, detail);
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	
	/**
	 * Executa JavaScript
	 * @param statement
	 */
	public void executeScript(String statement) {
		PrimeFaces.current().executeScript(statement);
	}
	
	/**
	 * Redireciona para uma página
	 * @param url
	 */
	public void redirectToPage(String url) {
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Abre uma view em um dialog dinâmico.
	 * @param outcome
	 * @param options
	 * @param params
	 */
	public void openDialog(String outcome, Map<String, Object> options, Map<String, List<String>> params) {
		PrimeFaces.current().dialog().openDynamic(outcome, options, params);
	}
	
	/**
	 * Fecha um dialog dinâmico.
	 * @param data
	 */
	public void closeDialog(Object data) {
		PrimeFaces.current().dialog().closeDynamic(data);
	}

}
