package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;

public class Equacao extends Entidade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String formula;
	private int idUsuario;
	private int minimo;
	private int maximo;

	public Equacao(String formula, int idUsuario, int minimo, int maximo) {
		this.formula = formula;
		this.idUsuario = idUsuario;
		this.minimo = minimo;
		this.maximo = maximo;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
