package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Medalha extends Entidade implements Serializable {
	private String medalha;
	private String descricao;

	
	public Medalha(int id, Date dataCriacao, String medalha, String descricao) {
		super(id, dataCriacao);
		this.medalha = medalha;
		this.descricao = descricao;
	}

	public String getMedalha() {
		return medalha;
	}

	public void setMedalha(String medalha) {
		this.medalha = medalha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
