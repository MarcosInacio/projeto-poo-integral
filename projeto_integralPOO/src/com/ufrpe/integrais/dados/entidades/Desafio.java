package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;
import java.util.Date;

public class Desafio extends Entidade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int idDesafiante;
	protected int idDesafiado;
	protected String equacao;
	protected Date dataResposta;
	protected String solucao;
	protected int minimo;
	protected int maximo;
	
	public Desafio() {
	
	}
	
	public Desafio(int desafiante, int desafiador, String equacao, Date resposta, String solucao, int minimo, int maximo) {
		this.idDesafiado = desafiador;
		this.idDesafiante = desafiante;
		this.equacao = equacao;
		this.dataResposta = resposta;
		this.solucao = solucao;
		
		this.minimo = minimo;
		this.maximo = maximo;
	}
	
	public int getIdDesafiante() {
		return idDesafiante;
	}
	
	public void setIdDesafiante(int idDesafiante) {
		this.idDesafiante = idDesafiante;
	}
	
	public int getIdDesafiado() {
		return idDesafiado;
	}
	
	public void setIdDesafiado(int idDesafiado) {
		this.idDesafiado = idDesafiado;
	}
	
	public String getEquacao() {
		return equacao;
	}
	
	public void setEquacao(String equacao) {
		this.equacao = equacao;
	}
	
	public Date getDataResposta() {
		return dataResposta;
	}
	
	public void setDataResposta(Date dataResposta) {
		this.dataResposta = dataResposta;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
}
