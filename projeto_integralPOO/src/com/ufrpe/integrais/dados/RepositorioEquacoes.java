package com.ufrpe.integrais.dados;

import java.util.ArrayList;
import java.util.List;

import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.Usuario;

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

	public List<Equacao> procurar(Usuario usuario) {
		List<Equacao> eq = new ArrayList<Equacao>();

		for (Equacao e : equacoes) {
			if (e.getUsuario().equals(usuario)) {
				eq.add(e);
			}
		}

		return eq;
	}

	public void remover(String formula) {
		Equacao aux = procurar(formula);

		if (aux != null) {
			equacoes.remove(aux);
		}
	}
}
