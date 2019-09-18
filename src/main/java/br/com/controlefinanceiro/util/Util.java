package br.com.controlefinanceiro.util;

import java.util.Collection;

import org.springframework.security.core.context.SecurityContextHolder;

public class Util {

	public static boolean isEmptyOrNull(Object o) {

		if (o == null) {
			return true;
		} else if (o instanceof String) {
			String s = (String) o;
			if (s.trim().equals("")) {
				return true;
			}
		}

		return false;

	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmptyOrNull(Collection o) {

		if (o == null) {
			return true;
		} else if (o.isEmpty()) {
			return true;
		}

		return false;
	}

	public static String getEmailUsuarioLogado() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
