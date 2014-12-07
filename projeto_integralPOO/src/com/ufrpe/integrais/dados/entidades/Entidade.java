package com.ufrpe.integrais.dados.entidades;

import java.util.Date;

public class Entidade {

	protected int id = -1;
	protected Date dataCriacao;

	public Entidade() {
		
	}
	
	public Entidade(int id, Date dataCriacao) {
		this.id = id;
		this.dataCriacao = dataCriacao;
	}

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