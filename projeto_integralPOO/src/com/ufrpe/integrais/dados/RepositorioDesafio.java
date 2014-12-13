package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.Desafio;

public class RepositorioDesafio extends Repositorio<Desafio> implements IRepositorioDesafio {

	private static IRepositorioDesafio desafio;

	private RepositorioDesafio() {
		super("Desafio");
	}

	public static IRepositorioDesafio getInstance() {
		if (desafio == null) {
			desafio = new RepositorioDesafio();
		}

		return desafio;
	}

	@Override
	public void remover(Desafio entidade) {
		super.remover(entidade);
	}
	
	@Override
	public Desafio procurar(int id) {
		return super.procurar(id);
	}
}
