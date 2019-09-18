package br.com.controlefinanceiro.dao;

import br.com.controlefinanceiro.model.Permissao;

public interface PermissaoDao {

	public Permissao findPermissaoByNome(String nome);

}
