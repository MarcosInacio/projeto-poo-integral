package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.Equacao;

public class RepositorioEquacoes extends Repositorio<Equacao> implements IRepositorioEquacoes {

	private static IRepositorioEquacoes repositorioEquacoes;

	private RepositorioEquacoes() {
		super("Equacao");
	}

	public static IRepositorioEquacoes getInstance() {
		if (repositorioEquacoes == null) {
			repositorioEquacoes = new RepositorioEquacoes();
		}

		return repositorioEquacoes;
	}
	
	@Override
	public void cadastrar(Equacao entidade) {
		super.cadastrar(entidade);
	}

	@Override
	public Equacao procurar(int id) {
		return super.procurar(id);
	}
	
	@Override
	public void remover(Equacao entidade) {
		super.remover(entidade);
	}
	
	@Override
	public Equacao atualizar(Equacao entidade) {
		// TODO Auto-generated method stub
		return super.atualizar(entidade);
	}
}
