package com.ufrpe.integrais.dados;

import java.util.List;

import com.ufrpe.integrais.dados.entidades.Equacao;


public interface IRepositorioEquacoes {
	void cadastrar(Equacao e);
	void remover(Equacao e);
	Equacao procurar(int id);
	List<Equacao> procurarPorUsuario(int id);
}
