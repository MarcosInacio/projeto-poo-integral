package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DesafioAberto extends Desafio implements Serializable {
	private String solucao;
	private String resposta;
	

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}
