package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Equacao extends Entidade implements Serializable {
	private String formula;
	private Usuario usuario;

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
