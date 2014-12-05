package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
public class DesafioAberto extends Desafio implements Serializable {
	private String solucao;
	private String resposta;
	

	public DesafioAberto(int id, Date dataCriacao, Usuario desafiante,
			Usuario desafiado, Equacao equacao, Date dataCriacao2,
			Date dataResposta, String solucao, String resposta) {
		super(id, dataCriacao, desafiante, desafiado, equacao, dataCriacao2,
				dataResposta);
		this.solucao = solucao;
		this.resposta = resposta;
	}

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
