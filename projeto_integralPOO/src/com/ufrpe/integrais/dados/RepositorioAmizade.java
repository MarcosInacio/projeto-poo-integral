package com.ufrpe.integrais.dados;

import java.util.ArrayList;
import java.util.List;

import com.ufrpe.integrais.dados.entidades.Amizade;
import com.ufrpe.integrais.dados.entidades.AmizadeSituacao;

public class RepositorioAmizade extends Repositorio<Amizade> implements IRepositorioAmizade {

	private static RepositorioAmizade repositorioAmizade;

	private RepositorioAmizade() {
		super("Amizade");
	}

	public static RepositorioAmizade getInstance() {
		if (repositorioAmizade == null) {
			repositorioAmizade = new RepositorioAmizade();
		}

		return repositorioAmizade;
	}

	@Override
	public void cadastrar(Amizade entidade) {
		super.cadastrar(entidade);
	}
	
	@Override
	public void remover(Amizade entidade) {
		super.remover(entidade);
	}
	
	@Override
	public Amizade procurar(int id) {
		return super.procurar(id);
	}
	
	@Override
	public List<Amizade> verificarPedencias(int idUsuario2) {
		List<Amizade> amz = new ArrayList<>();
		
		for (int i = 0; i < lista.size(); i++) {
			Amizade amizade = (Amizade)lista.get(i);
			
			if (amizade.getIdUsuario2() == idUsuario2 && amizade.getSituacao() == AmizadeSituacao.Pendente) {
				amz.add(amizade);
			}
		}

		return amz;
	}
	
	@Override
	public AmizadeSituacao verificarAmizade(int idUsuario1, int idUsuario2) {
		for (int i = 0; i < lista.size(); i++) {
			Amizade amizade = (Amizade)lista.get(i);
			
			if ((amizade.getIdUsuario1() == idUsuario1 && amizade.getIdUsuario2() == idUsuario2) || 
				(amizade.getIdUsuario1() == idUsuario2 && amizade.getIdUsuario2() == idUsuario1)) {
				return amizade.getSituacao();
			}
		}

		return null;
	}
}
