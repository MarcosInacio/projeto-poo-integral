package com.ufrpe.integrais.dados;

import java.util.ArrayList;
import java.util.List;

import com.ufrpe.integrais.dados.entidades.Desafio;

public class RepositorioDesafio extends Repositorio<Desafio> implements IRepositorioDesafio {

	private static IRepositorioDesafio desafio;

	private RepositorioDesafio() {
		super("Desafio");
	}

	public static IRepositorioDesafio getInstance() {
		if (desafio == null) {
			desafio = new RepositorioDesafio();
		}

		return desafio;
	}

	@Override
	public void remover(Desafio entidade) {
		super.remover(entidade);
	}
	
	@Override
	public Desafio procurar(int id) {
		return super.procurar(id);
	}
	
	public List<Desafio> procurarPorDesafiado(int id) {
		List<Desafio> aux = new ArrayList<>();
		
		for (int i = 0; i < lista.size(); i++) {
			Desafio desafio = (Desafio)lista.get(i);
			
			if (desafio.getIdDesafiado() == id) {
				aux.add(desafio);
			}
		}

		return aux;
	}
	
	@Override
	public Desafio atualizar(Desafio entidade) {
		return super.atualizar(entidade);
	}
}
