package com.ufrpe.integrais.dados.entidades;


public class Amizade extends Entidade {
	private static final long serialVersionUID = 1L;
	
	// idUsuario1 é o usuário que solicitou a amizade
	// Logo, o idUsuario2, deve receber uma notificação, e confirmar, ou não, a solicitação
	private int idUsuario1;
	private int idUsuario2;
	private AmizadeSituacao situacao;
	
	public Amizade() {
		
	}

	public Amizade(int amigo1, int amigo2, AmizadeSituacao situacao) {
		super();
		this.idUsuario1 = amigo1;
		this.idUsuario2 = amigo2;
		this.situacao = situacao;
	}
	
	public int getIdUsuario1() {
		return idUsuario1;
	}

	public void setIdUsuario1(int idUsuario1) {
		this.idUsuario1 = idUsuario1;
	}

	public int getIdUsuario2() {
		return idUsuario2;
	}

	public void setIdUsuario2(int idUsuario2) {
		this.idUsuario2 = idUsuario2;
	}

	public AmizadeSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(AmizadeSituacao situacao) {
		this.situacao = situacao;
	}
}
