package com.ufrpe.integrais.negocio;

import com.ufrpe.integrais.dados.IRepositorioMedalhas;
import com.ufrpe.integrais.dados.RepositorioMedalhas;
import com.ufrpe.integrais.dados.entidades.Medalha;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.util.Constantes;

public class CadastroMedalhas {

	private IRepositorioMedalhas repositorioMedalhas;

	public CadastroMedalhas() {

		this.repositorioMedalhas = RepositorioMedalhas.getInstance();
	}

	public void cadastrarMedalha(Medalha m) throws ObjetoJaExistenteExcepitions {
		if (m == null) {
			throw new IllegalArgumentException(Constantes.PARAMETRO_INVALIDO);
		} else {
			Medalha retorno;

			retorno = this.repositorioMedalhas.procurar(m.getId());

			if (retorno == null) {
				repositorioMedalhas.cadastrar(m);
			} else {
				throw new ObjetoJaExistenteExcepitions(m);
			}
		}
	}
}
