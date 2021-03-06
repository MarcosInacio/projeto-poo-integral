package com.ufrpe.integrais.dados.entidades;

import java.util.Date;

public class Notificacao extends Entidade {
	private static final long serialVersionUID = 1L;

	private Usuario de;
	private Usuario para;
	private Date data;
	private String mensagem;
	private Desafio desafio;

	public Notificacao(int id, Date dataCriacao, Usuario de, Usuario para,
			Date data, String mensagem, Desafio desafio) {
		super(id, dataCriacao);
		this.de = de;
		this.para = para;
		this.data = data;
		this.mensagem = mensagem;
		this.desafio = desafio;
	}

	public Usuario getDe() {
		return de;
	}

	public void setDe(Usuario de) {
		this.de = de;
	}

	public Usuario getPara() {
		return para;
	}

	public void setPara(Usuario para) {
		this.para = para;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Desafio getDesafio() {
		return desafio;
	}

	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
	}

}
