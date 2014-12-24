package com.ufrpe.integrais.negocio;

import java.util.List;

import com.ufrpe.integrais.dados.IRepositorioAmizade;
import com.ufrpe.integrais.dados.RepositorioAmizade;
import com.ufrpe.integrais.dados.entidades.Amizade;
import com.ufrpe.integrais.dados.entidades.AmizadeSituacao;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.util.Constantes;

public class CadastroAmizades {

	private IRepositorioAmizade repositorioAmizade;

	public CadastroAmizades() {
		this.repositorioAmizade = RepositorioAmizade.getInstance();
	}
	
	public AmizadeSituacao verificarAmizade(int idUsuario1, int idUsuario2) {
		return repositorioAmizade.verificarAmizade(idUsuario1, idUsuario2);
	}
	
	public List<Amizade> verificarPedencias(int idUsuario2) {
		return repositorioAmizade.verificarPedencias(idUsuario2);
	}

	public void cadastrarAmizade(Amizade m) throws ObjetoJaExistenteExcepitions {
		if (m == null) {
			throw new IllegalArgumentException(Constantes.PARAMETRO_INVALIDO);
		} else {
			Amizade retorno;

			retorno = this.repositorioAmizade.procurar(m.getId());

			if (retorno == null) {
				repositorioAmizade.cadastrar(m);
			} else {
				throw new ObjetoJaExistenteExcepitions(m);
			}
		}
	}
}
