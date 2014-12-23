package com.ufrpe.integrais.dados;

import java.util.LinkedList;

import com.ufrpe.integrais.dados.entidades.Usuario;

public interface IRepositorioUsuarios {
	void cadastrar(Usuario entidade);

	void remover(Usuario entidade);

	Usuario atualizar(Usuario entidade);

	Usuario procurar(int id);

	Usuario procurar(String email);

	Usuario procurar(String email, String senha);

	LinkedList<Usuario> getLista();
}
