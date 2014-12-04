package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Medalha extends CriacaoObjeto implements Serializable {
	private String medalha;
	private String descricao;

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
