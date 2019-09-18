package br.com.controlefinanceiro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cf_permissao")
public class Permissao implements Serializable {

	private static final long serialVersionUID = 1168839742884154062L;

	@Id
	@SequenceGenerator(name = "permissaoGenerator", sequenceName = "seq_cf_permissao", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissaoGenerator")
	private Integer pkpermissao;

	@Column(name = "nome")
	private String nome;

	public Integer getPkpermissao() {
		return pkpermissao;
	}

	public void setPkpermissao(Integer pkpermissao) {
		this.pkpermissao = pkpermissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
