package com.ufrpe.integrais.dados;

import java.util.LinkedList;

import com.ufrpe.integrais.dados.entidades.Medalha;

public interface IRepositorioMedalhas {

	
	void cadastrar(Medalha m);
	 Medalha procurar(String m);
	 LinkedList<Medalha> getListaMedalhas();
	 void remover(Medalha m);

}
