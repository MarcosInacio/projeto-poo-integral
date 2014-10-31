package com.ufrpe.integrais.dados.entidades;

import java.util.Date;

public class Desafio extends Entidade {
	protected Usuario desafiante;
	protected Usuario desafiado;
	protected Equacao equacao;
	protected Date DataCriacao;
	protected Date DataResposta;

	public Usuario getDesafiante() {
		return desafiante;
	}

	public void setDesafiante(Usuario desafiante) {
		this.desafiante = desafiante;
	}

	public Usuario getDesafiado() {
		return desafiado;
	}

	public void setDesafiado(Usuario desafiado) {
		this.desafiado = desafiado;
	}

	public Equacao getEquacao() {
		return equacao;
	}

	public void setEquacao(Equacao equacao) {
		this.equacao = equacao;
	}

	public Date getDataCriacao() {
		return DataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		DataCriacao = dataCriacao;
	}

	public Date getDataResposta() {
		return DataResposta;
	}

	public void setDataResposta(Date dataResposta) {
		DataResposta = dataResposta;
	}

}
