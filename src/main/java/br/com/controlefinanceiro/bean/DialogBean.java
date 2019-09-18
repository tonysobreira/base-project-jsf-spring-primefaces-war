package br.com.controlefinanceiro.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;

import br.com.controlefinanceiro.constants.DialogsConstantes;

@ManagedBean
@ViewScoped
public class DialogBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 5848658652257093332L;

	private String text;
	
	@PostConstruct
	public void init() {
		this.text = "";
	}

	public void openDialog() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("draggable", false);
		options.put("resizable", false);

		openDialog(DialogsConstantes.DIALOG_EXAMPLE, options, null);
	}

	public void closeDialog() {
		closeDialog(DialogsConstantes.DIALOG_EXAMPLE);
	}
	
	public void onReturnDialog() {
		addMessage(FacesMessage.SEVERITY_INFO, "Text", this.text);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
