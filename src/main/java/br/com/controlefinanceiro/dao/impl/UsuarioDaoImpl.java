package br.com.controlefinanceiro.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.controlefinanceiro.dao.AbstractJpaRepository;
import br.com.controlefinanceiro.dao.UsuarioDao;
import br.com.controlefinanceiro.model.Usuario;
import br.com.controlefinanceiro.util.LoggerUtils;
import br.com.controlefinanceiro.util.Util;

@Repository("usuarioDao")
public class UsuarioDaoImpl extends AbstractJpaRepository<Usuario, Integer> implements UsuarioDao {

	@Autowired
	private DataSource dataSource;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public Usuario salvarUsuario(Usuario usuario) {
		Usuario u = this.create(usuario);
		LoggerUtils.getLogger(UsuarioDaoImpl.class).info("Usuário criado com sucesso!");
		return u;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public List<Usuario> findAllUsuario() {
		
		StringBuilder jpql = new StringBuilder();

		jpql.append(" SELECT u FROM Usuario u ");
		jpql.append(" WHERE u.ativo is true ");
		jpql.append(" ORDER BY u.nome");

		Query query = this.getEntityManager().createQuery(jpql.toString());

		List<Usuario> usuarioList = query.getResultList();

		return usuarioList;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public Usuario findUsuarioByPk(Integer pk) {
		return this.getById(Usuario.class, pk);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public Usuario getUsuarioLogado() throws Exception {
		Usuario usuario = null;
		String emailUsuarioLogado = Util.getEmailUsuarioLogado();
		
		StringBuilder jpql = new StringBuilder();

		jpql.append(" SELECT u FROM Usuario u ");
		jpql.append(" WHERE u.email = :email ");

		Query query = this.getEntityManager().createQuery(jpql.toString());
		query.setParameter("email", emailUsuarioLogado);
		
		try {
			usuario = (Usuario) query.getSingleResult();
		} catch (NoResultException nre) {
			throw nre;
		} catch (Exception e) {
			throw e;
		}
		
		return usuario;
	}

}
