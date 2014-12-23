package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.EquacaoCurtir;

public interface IRepositorioEquacoesCurtidas {
	void cadastrar(EquacaoCurtir entidade);

	void remover(EquacaoCurtir entidade);

	EquacaoCurtir procurar(int id);

	int quantidadeCurtidas(int idEquacao);
}
