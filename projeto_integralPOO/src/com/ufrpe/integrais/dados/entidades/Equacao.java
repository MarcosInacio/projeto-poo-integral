package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Equacao extends CriacaoObjeto implements Serializable {
	private String formula;
	private Usuario usuario;
	

	public Equacao(int id, Date dataCriacao, String formula, Usuario usuario) {
		super(id, dataCriacao);
		this.formula = formula;
		this.usuario = usuario;
	}

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
