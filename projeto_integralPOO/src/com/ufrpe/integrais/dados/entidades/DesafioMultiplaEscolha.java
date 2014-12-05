package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("serial")
public class DesafioMultiplaEscolha extends Desafio implements Serializable {
	private String resposta;
	private ArrayList<String> respostas = new ArrayList<String>();
	
	

	public DesafioMultiplaEscolha(int id, Date dataCriacao, Usuario desafiante,
			Usuario desafiado, Equacao equacao, Date dataCriacao2,
			Date dataResposta, String resposta, ArrayList<String> respostas) {
		super(id, dataCriacao, desafiante, desafiado, equacao, dataCriacao2,
				dataResposta);
		this.resposta = resposta;
		this.respostas = respostas;
	}

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
