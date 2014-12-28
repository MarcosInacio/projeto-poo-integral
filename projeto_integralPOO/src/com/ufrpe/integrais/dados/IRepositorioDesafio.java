package com.ufrpe.integrais.dados;

import java.util.List;

import com.ufrpe.integrais.dados.entidades.Desafio;

public interface IRepositorioDesafio {
	 void cadastrar(Desafio d);
	 void remover(Desafio d);
	 Desafio procurar(int id);
	 Desafio atualizar(Desafio entidade);
	 List<Desafio> procurarPorDesafiado(int id);
}
