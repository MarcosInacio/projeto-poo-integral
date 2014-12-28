package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;
import java.util.Date;

public class DesafioAberto extends Desafio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String resposta;

	public DesafioAberto(int desafiante, int desafiador, String equacao, Date dataResposta, String solucao, String resposta, int minimo, int maximo) {
		super(desafiante, desafiador, equacao, dataResposta, solucao, minimo, maximo);
		this.resposta = resposta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
