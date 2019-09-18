package br.com.controlefinanceiro.rn.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.controlefinanceiro.dao.UsuarioDao;
import br.com.controlefinanceiro.model.Usuario;
import br.com.controlefinanceiro.rn.UsuarioRn;

@Service("usuarioRn")
public class UsuarioRnImpl implements UsuarioRn, Serializable {

	private static final long serialVersionUID = -1621595283024453461L;

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioDao.salvarUsuario(usuario);
	}

	@Override
	@Transactional
	public List<Usuario> findAllUsuario() {
		return usuarioDao.findAllUsuario();
	}

	@Override
	@Transactional
	public Usuario findUsuarioByPk(Integer pk) {
		return usuarioDao.findUsuarioByPk(pk);
	}

	@Override
	public Usuario getUsuarioLogado() {
		Usuario usuario = null;

		try {
			usuario = usuarioDao.getUsuarioLogado();
		} catch (NoResultException nre) {
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

}
