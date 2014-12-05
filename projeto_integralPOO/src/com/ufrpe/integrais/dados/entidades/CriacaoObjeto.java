package com.ufrpe.integrais.dados.entidades;

import java.util.Date;

public class CriacaoObjeto {

	protected int id;
	protected Date dataCriacao;
	
	

	public CriacaoObjeto(int id, Date dataCriacao) {
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
