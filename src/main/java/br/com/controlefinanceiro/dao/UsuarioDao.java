package br.com.controlefinanceiro.dao;

import java.util.List;

import br.com.controlefinanceiro.model.Usuario;

public interface UsuarioDao {

	public Usuario salvarUsuario(Usuario usuario);

	public List<Usuario> findAllUsuario();

	public Usuario findUsuarioByPk(Integer pk);

	public Usuario getUsuarioLogado() throws Exception;

}
