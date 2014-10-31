package com.ufrpe.integrais.dados;

import java.util.ArrayList;

import com.ufrpe.integrais.dados.entidades.Equacao;

public class RepositorioEquacoes {

	private ArrayList<Equacao> equacoes;

	public RepositorioEquacoes() {

		equacoes = new ArrayList<Equacao>();

	}

	public void cadastrar(Equacao e) {

		equacoes.add(e);
	}

	public Equacao procurar(String formula) {

		Equacao aux = null;

		for (Equacao e : equacoes) {

			if (e.getFormula().equals(formula)) {

				aux = e;
				break;
			}
		}

		return aux;
	}

	public void remover(String formula) {

		Equacao aux = procurar(formula);

		if (aux != null) {

			equacoes.remove(aux);

		}

	}

}
