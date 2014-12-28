package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class DesafioMultiplaEscolha extends Desafio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> respostas = new ArrayList<String>();
	
	public DesafioMultiplaEscolha(int desafiante, int desafiador, String equacao, Date dataResposta, String solucao, ArrayList<String> respostas, int minimo, int maximo) {
		super(desafiante, desafiador, equacao, dataResposta, solucao, minimo, maximo);
		this.respostas = respostas;
	}

	public ArrayList<String> getRespostas() {
		return respostas;
	}

	public void setRespostas(ArrayList<String> respostas) {
		this.respostas = respostas;
	}

}
