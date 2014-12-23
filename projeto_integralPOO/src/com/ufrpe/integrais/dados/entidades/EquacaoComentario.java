package com.ufrpe.integrais.dados.entidades;

public class EquacaoComentario extends Entidade {
	private static final long serialVersionUID = 1L;
	
	private int idUsuario;
	private int idEquacao;
	private String comentario;
	
	public EquacaoComentario() {
	
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdEquacao() {
		return idEquacao;
	}

	public void setIdEquacao(int idEquacao) {
		this.idEquacao = idEquacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
