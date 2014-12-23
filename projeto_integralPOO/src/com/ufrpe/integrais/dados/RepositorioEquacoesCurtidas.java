package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.EquacaoCurtir;

public class RepositorioEquacoesCurtidas extends Repositorio<EquacaoCurtir> implements IRepositorioEquacoesCurtidas {

	private static IRepositorioEquacoesCurtidas instance;
	
	public RepositorioEquacoesCurtidas() {
		super("EquacaoCurtir");
	}

	public static IRepositorioEquacoesCurtidas getInstance() {
		if (instance == null) {
			instance = new RepositorioEquacoesCurtidas();
		}

		return instance;
	}
	
	@Override
	public void cadastrar(EquacaoCurtir entidade) {
		super.cadastrar(entidade);
	}
	
	@Override
	public EquacaoCurtir procurar(int id) {
		return super.procurar(id);
	}
	
	public int quantidadeCurtidas(int idEquacao) {
		int tamanho = 0;

		for (EquacaoCurtir entidade: lista) {
			if (entidade.getIdEquacao() == idEquacao) {
				tamanho++;
			}
		}

		return tamanho;
	}
	
	@Override
	public void remover(EquacaoCurtir entidade) {
		super.remover(entidade);
	}
	
	@Override
	public EquacaoCurtir atualizar(EquacaoCurtir entidade) {
		return super.atualizar(entidade);
	}
}
