package br.com.controlefinanceiro.facade;

import java.util.List;

import br.com.controlefinanceiro.model.Permissao;
import br.com.controlefinanceiro.model.Usuario;

public interface ICFFacade {

	/******************** USUÁRIO ***********************/

	public Usuario salvarUsuario(Usuario usuario);

	public List<Usuario> findAllUsuario();

	public Usuario findUsuarioByPk(Integer pk);

	public Usuario getUsuarioLogado();

	/******************** FIM USUÁRIO ***********************/

	/******************** PERMISSÃO ***********************/

	public Permissao findPermissaoByNome(String nome);

	/******************** FIM PERMISSÃO ***********************/

}
