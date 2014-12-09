package com.ufrpe.integrais.negocio;

import com.ufrpe.integrais.dados.IRepositorioMedalhas;
import com.ufrpe.integrais.dados.RepositorioMedalhas;
import com.ufrpe.integrais.dados.entidades.Medalha;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;

public class CadastroMedalhas {

	private IRepositorioMedalhas repositorioMedalhas;

	public CadastroMedalhas() {

		this.repositorioMedalhas = RepositorioMedalhas.getInstance();
	}

	public void cadastrarMedalha(Medalha m) throws ObjetoJaExistenteExcepitions {
		if (m == null) {
			throw new IllegalArgumentException("Parâmetro inválido");
		} else {
			Medalha retorno;

			retorno = this.repositorioMedalhas.procurar(m.getMedalha());

			if (retorno == null) {
				repositorioMedalhas.cadastrar(m);
			} else {
				throw new ObjetoJaExistenteExcepitions(m);
			}
		}
	}

	public Medalha procurarMedalha(String especificacao)
			throws ObjetoNaoExistenteExcepition {

		Medalha retorno = repositorioMedalhas.procurar(especificacao);

		if (retorno == null) {

			throw new ObjetoNaoExistenteExcepition("Medalha", especificacao, "");
		}

		return retorno;
	}

	public void removerMedalha(String especificacao)
			throws ObjetoNaoExistenteExcepition {

		Medalha retorno = repositorioMedalhas.procurar(especificacao);

		if (retorno != null) {
			repositorioMedalhas.remover(retorno);
		} else {
			throw new ObjetoNaoExistenteExcepition("Medalha", especificacao, "");
		}

	}

	public void atualizarMedalha(String especificacao, Medalha novo)
			throws ObjetoNaoExistenteExcepition {

		Medalha retorno = repositorioMedalhas.procurar(especificacao);

		if (retorno != null) {
/*
			repositorioMedalhas.getListaMedalhas().set(
					repositorioMedalhas.getListaMedalhas().indexOf(retorno),
					novo);
			RepositorioMedalhas.salvarNoArquivo();
*/
		} else {

			throw new ObjetoNaoExistenteExcepition("Medalha", especificacao, "");
		}

	}

}
