package com.ufrpe.integrais.dados;

import java.util.LinkedList;

import com.ufrpe.integrais.dados.entidades.Desafio;

public interface IRepositorioDesafio {
	
	 void cadastrar(Desafio d);
	 Desafio procurar(String desafiante, String desafiado);
	 void remover(Desafio d);
	 LinkedList<Desafio> getListaDesafios();
	
}
