package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.Usuario;


public interface IRepositorioUsuarios {
	void cadastrar(Usuario entidade);
	void remover(Usuario entidade);
	Usuario procurar(int id);
	Usuario procurar(String email, String senha);
}
