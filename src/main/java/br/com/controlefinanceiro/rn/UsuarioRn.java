package br.com.controlefinanceiro.rn;

import java.util.List;

import br.com.controlefinanceiro.model.Usuario;

public interface UsuarioRn {
	
	public Usuario salvarUsuario(Usuario usuario);
	
	public List<Usuario> findAllUsuario();
	
	public Usuario findUsuarioByPk(Integer pk);
	
	public Usuario getUsuarioLogado();

}
