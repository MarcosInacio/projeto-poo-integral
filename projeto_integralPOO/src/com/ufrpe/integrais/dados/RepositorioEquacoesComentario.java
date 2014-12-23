package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.EquacaoComentario;

public class RepositorioEquacoesComentario extends Repositorio<EquacaoComentario> implements IRepositorioEquacoesComentarios {

	private static IRepositorioEquacoesComentarios instance;
	
	public RepositorioEquacoesComentario() {
		super("EquacaoComentario");
	}

	public static IRepositorioEquacoesComentarios getInstance() {
		if (instance == null) {
			instance = new RepositorioEquacoesComentario();
		}

		return instance;
	}
	
	@Override
	public void cadastrar(EquacaoComentario entidade) {
		super.cadastrar(entidade);
	}
	
	@Override
	public EquacaoComentario procurar(int id) {
		return super.procurar(id);
	}
		
	@Override
	public void remover(EquacaoComentario entidade) {
		super.remover(entidade);
	}
	
	@Override
	public EquacaoComentario atualizar(EquacaoComentario entidade) {
		return super.atualizar(entidade);
	}

	@Override
	public int quantidadeComentarios(int idEquacao) {
		int tamanho = 0;

		for (EquacaoComentario entidade: lista) {
			if (entidade.getIdEquacao() == idEquacao) {
				tamanho++;
			}
		}

		return tamanho;
	}
}
