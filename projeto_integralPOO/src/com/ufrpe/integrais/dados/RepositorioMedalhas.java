package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.Medalha;

public class RepositorioMedalhas extends Repositorio<Medalha> implements IRepositorioMedalhas {

	private static RepositorioMedalhas repositorioMedalhas;

	private RepositorioMedalhas() {
		super("Medalha");
	}

	public static RepositorioMedalhas getInstance() {
		if (repositorioMedalhas == null) {
			repositorioMedalhas = new RepositorioMedalhas();
		}

		return repositorioMedalhas;
	}

	@Override
	public void cadastrar(Medalha entidade) {
		super.cadastrar(entidade);
	}
	
	@Override
	public void remover(Medalha entidade) {
		super.remover(entidade);
	}
	
	@Override
	public Medalha procurar(int id) {
		return super.procurar(id);
	}
}
