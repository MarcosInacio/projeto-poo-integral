package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.Usuario;


public interface IRepositorioUsuarios {
	Usuario procurar(String email, String senha);
}
