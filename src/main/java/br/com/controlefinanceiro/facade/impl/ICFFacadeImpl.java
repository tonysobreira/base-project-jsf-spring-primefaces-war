package br.com.controlefinanceiro.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.controlefinanceiro.constants.RolesConstantes;
import br.com.controlefinanceiro.facade.ICFFacade;
import br.com.controlefinanceiro.model.Permissao;
import br.com.controlefinanceiro.model.Usuario;
import br.com.controlefinanceiro.rn.PermissaoRn;
import br.com.controlefinanceiro.rn.UsuarioRn;

@Service("facade")
public class ICFFacadeImpl implements ICFFacade {

	private UsuarioRn usuarioRn;
	private PermissaoRn permissaoRn;

	@Autowired
	public ICFFacadeImpl(@Qualifier("usuarioRn") final UsuarioRn usuarioRn,
			@Qualifier("permissaoRn") final PermissaoRn permissaoRn) {
		this.usuarioRn = usuarioRn;
		this.permissaoRn = permissaoRn;
	}

	/******************** USUÁRIO ***********************/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public Usuario salvarUsuario(Usuario usuario) {

		Set<Permissao> permissoes = new HashSet<Permissao>();
		Permissao permissao = findPermissaoByNome(RolesConstantes.ROLE_USUARIO);
		permissoes.add(permissao);
		usuario.setPermissoes(permissoes);

		return this.usuarioRn.salvarUsuario(usuario);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public List<Usuario> findAllUsuario() {
		return this.usuarioRn.findAllUsuario();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public Usuario findUsuarioByPk(Integer pk) {
		return this.usuarioRn.findUsuarioByPk(pk);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public Usuario getUsuarioLogado() {
		return this.usuarioRn.getUsuarioLogado();
	}

	/******************** FIM USUÁRIO ***********************/

	/******************** PERMISSÃO ***********************/

	@Override
	public Permissao findPermissaoByNome(String nome) {
		return permissaoRn.findPermissaoByNome(nome);
	}

	/******************** FIM PERMISSÃO ***********************/

}
