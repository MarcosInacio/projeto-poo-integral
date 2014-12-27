package com.ufrpe.integrais.dados;

import java.util.List;

import com.ufrpe.integrais.dados.entidades.Amizade;
import com.ufrpe.integrais.dados.entidades.AmizadeSituacao;

public interface IRepositorioAmizade {
	void cadastrar(Amizade entidade);

	void remover(int idUsuario1, int idUsuario2);
	
	Amizade atualizar(Amizade entidade);

	Amizade procurar(int id);
	
	AmizadeSituacao verificarAmizade(int idUsuario1, int idUsuario2);

	List<Amizade> verificarPedencias(int idUsuario2);

	List<Amizade> verificarAmigos(int idUsuario2);
}
