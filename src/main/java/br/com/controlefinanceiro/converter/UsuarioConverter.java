package br.com.controlefinanceiro.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.controlefinanceiro.bean.UsuarioBean;
import br.com.controlefinanceiro.model.Usuario;
import br.com.controlefinanceiro.util.Util;

@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1, String value) {

		if (value != null && value.trim().length() > 0) {
			try {
				UsuarioBean bean = (UsuarioBean) context.getELContext().getELResolver().getValue(context.getELContext(),
						null, "extratoBean");
				return bean.getFacade().findUsuarioByPk(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
						"Não foi possível encontrar um usuário."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {

		if (!Util.isEmptyOrNull(object)) {
			return String.valueOf(((Usuario) object).getPkUsuario());
		} else {
			return null;
		}
	}

}
