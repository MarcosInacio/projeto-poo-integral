package com.ufrpe.integrais.dados;

import java.util.LinkedList;
import java.util.List;

import com.ufrpe.integrais.dados.entidades.Usuario;

public interface IRepositorioUsuarios {
	void cadastrar(Usuario entidade);

	void remover(Usuario entidade);

	Usuario atualizar(Usuario entidade);

	Usuario procurar(int id);

	Usuario procurar(String email);
	
	List<Usuario> procurarPorNome(String nome);

	Usuario procurar(String email, String senha);

	LinkedList<Usuario> getLista();
}
