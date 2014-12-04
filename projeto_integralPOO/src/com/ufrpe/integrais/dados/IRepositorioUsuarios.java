package com.ufrpe.integrais.dados;

import java.util.LinkedList;

import com.ufrpe.integrais.dados.entidades.Usuario;

public interface IRepositorioUsuarios {
	
	 void cadastrar(Usuario u);
	 Usuario procurar(String email , String senha);
	 LinkedList<Usuario> getListaUsuarios();
	 void remover(Usuario retorno);

}
