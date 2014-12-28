package com.ufrpe.integrais.negocio;

import java.util.List;

import com.ufrpe.integrais.dados.IRepositorioDesafio;
import com.ufrpe.integrais.dados.RepositorioDesafio;
import com.ufrpe.integrais.dados.entidades.Desafio;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.util.Constantes;

public class CadastroDesafios {

	private IRepositorioDesafio repositorioDesafios;

	public CadastroDesafios() {
		this.repositorioDesafios = RepositorioDesafio.getInstance();
	}

	public List<Desafio> procurarPorDesafiado(int idDesafiado) {
		return repositorioDesafios.procurarPorDesafiado(idDesafiado);
	}

	public void atualizarDesafio(Desafio d) throws ObjetoNaoExistenteExcepition {
		if (d == null) {
			throw new IllegalArgumentException(Constantes.PARAMETRO_INVALIDO);
		} else {
			Desafio retorno;

			retorno = this.repositorioDesafios.procurar(d.getId());

			if (retorno != null) {
				repositorioDesafios.atualizar(d);
			} else {
				throw new ObjetoNaoExistenteExcepition("", "", "");
			}
		}
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
