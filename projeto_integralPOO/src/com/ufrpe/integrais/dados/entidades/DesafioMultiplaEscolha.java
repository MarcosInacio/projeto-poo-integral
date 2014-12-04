package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DesafioMultiplaEscolha extends Desafio implements Serializable {
	private String resposta;
	private ArrayList<String> respostas = new ArrayList<String>();

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public ArrayList<String> getRespostas() {
		return respostas;
	}

	public void setRespostas(ArrayList<String> respostas) {
		this.respostas = respostas;
	}

}
