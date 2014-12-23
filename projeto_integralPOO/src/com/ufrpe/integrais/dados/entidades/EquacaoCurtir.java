package com.ufrpe.integrais.dados.entidades;

public class EquacaoCurtir extends Entidade {
	private static final long serialVersionUID = 1L;

	private int idEquacao;
	private int idUsuario;
	
	public EquacaoCurtir() {
		
	}

	public int getIdEquacao() {
		return idEquacao;
	}

	public void setIdEquacao(int idEquacao) {
		this.idEquacao = idEquacao;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
