package com.ufrpe.integrais.negocio;

import com.ufrpe.integrais.dados.IRepositorioDesafio;
import com.ufrpe.integrais.dados.RepositorioDesafio;
import com.ufrpe.integrais.dados.entidades.Desafio;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.util.Constantes;

public class CadastroDesafios {

	private IRepositorioDesafio repositorioDesafios;

	public CadastroDesafios() {
		this.repositorioDesafios = RepositorioDesafio.getInstance();
	}

	public void cadastrarDesafio(Desafio d) throws ObjetoJaExistenteExcepitions {
		if (d == null) {
			throw new IllegalArgumentException(Constantes.PARAMETRO_INVALIDO);
		} else {
			Desafio retorno;

			retorno = this.repositorioDesafios.procurar(d.getId());

			if (retorno == null) {
				repositorioDesafios.cadastrar(d);
			} else {

				throw new ObjetoJaExistenteExcepitions(d);
			}
		}
	}
}
