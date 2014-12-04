package com.ufrpe.integrais.dados;

import java.util.LinkedList;

import com.ufrpe.integrais.dados.entidades.Equacao;


public interface IRepositorioEquacoes {
	
	void cadastrar(Equacao e);
	Equacao procurar(String formula , String nome);
	LinkedList<Equacao> getListaEquacao();
	void remover(Equacao e);
	

}
