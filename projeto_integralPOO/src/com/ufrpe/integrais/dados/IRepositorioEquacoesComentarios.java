package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.EquacaoComentario;

public interface IRepositorioEquacoesComentarios {
	void cadastrar(EquacaoComentario entidade);

	void remover(EquacaoComentario entidade);

	EquacaoComentario procurar(int id);

	int quantidadeComentarios(int idEquacao);
}
