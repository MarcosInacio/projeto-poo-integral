package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.Equacao;


public interface IRepositorioEquacoes {
	void cadastrar(Equacao e);
	void remover(Equacao e);
	Equacao procurar(int id);
}
