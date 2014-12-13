package com.ufrpe.integrais.negocio;

import com.ufrpe.integrais.dados.IRepositorioEquacoes;
import com.ufrpe.integrais.dados.RepositorioEquacoes;
import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.util.Constantes;

public class CadastroEquacoes {

	private IRepositorioEquacoes repositorioEquacoes;

	public CadastroEquacoes() {
		this.repositorioEquacoes = RepositorioEquacoes.getInstance();
	}

	public void cadastrarEquacoes(Equacao e)
			throws ObjetoJaExistenteExcepitions {

		if (e == null) {
			throw new IllegalArgumentException(Constantes.PARAMETRO_INVALIDO);
		} else {
			Equacao retorno;

			retorno = this.repositorioEquacoes.procurar(e.getId());

			if (retorno == null) {
				repositorioEquacoes.cadastrar(e);
			} else {
				throw new ObjetoJaExistenteExcepitions(e);
			}
		}
	}
}
