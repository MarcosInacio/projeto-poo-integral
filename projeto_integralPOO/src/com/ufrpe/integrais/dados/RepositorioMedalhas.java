package com.ufrpe.integrais.dados;

import java.util.ArrayList;

import com.ufrpe.integrais.dados.entidades.Medalha;

public class RepositorioMedalhas {

	private ArrayList<Medalha> medalhas;

	public RepositorioMedalhas() {

		medalhas = new ArrayList<Medalha>();

	}

	public void cadastrar(Medalha m) {

		medalhas.add(m);
	}

	public Medalha procurar(String medalha) {

		Medalha aux = null;

		for (Medalha m : medalhas) {

			if (m.getMedalha().equals(medalha)) {

				aux = m;
				break;
			}
		}

		return aux;
	}

	public void remover(String medalha) {

		Medalha aux = procurar(medalha);

		if (aux != null) {

			medalhas.remove(aux);

		}

	}
}
