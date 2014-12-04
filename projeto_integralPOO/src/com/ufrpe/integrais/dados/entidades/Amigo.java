package com.ufrpe.integrais.dados.entidades;

public class Amigo extends CriacaoObjeto {
	private Usuario amigo1;
	private Usuario amigo2;
	private AmigoSituacao situacao;

	public Usuario getAmigo1() {
		return amigo1;
	}

	public void setAmigo1(Usuario amigo1) {
		this.amigo1 = amigo1;
	}

	public Usuario getAmigo2() {
		return amigo2;
	}

	public void setAmigo2(Usuario amigo2) {
		this.amigo2 = amigo2;
	}

	public AmigoSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(AmigoSituacao situacao) {
		this.situacao = situacao;
	}

}
