package com.ufrpe.integrais.dados.entidades;

import java.util.Date;

public class Entidade {

	protected int id;
	protected Date dataCriacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
