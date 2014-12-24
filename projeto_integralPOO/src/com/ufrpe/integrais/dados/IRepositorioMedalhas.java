package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.Medalha;

public interface IRepositorioMedalhas {
	void cadastrar(Medalha entidade);

	void remover(Medalha entidade);

	Medalha procurar(int id);
}
