package com.ufrpe.integrais.negocio;

import java.util.List;

import com.ufrpe.integrais.dados.IRepositorioEquacoes;
import com.ufrpe.integrais.dados.IRepositorioEquacoesComentarios;
import com.ufrpe.integrais.dados.IRepositorioEquacoesCurtidas;
import com.ufrpe.integrais.dados.RepositorioEquacoes;
import com.ufrpe.integrais.dados.RepositorioEquacoesComentario;
import com.ufrpe.integrais.dados.RepositorioEquacoesCurtidas;
import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.EquacaoComentario;
import com.ufrpe.integrais.dados.entidades.EquacaoCurtir;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.util.Constantes;

public class CadastroEquacoes {

	private IRepositorioEquacoes repositorioEquacoes;
	private IRepositorioEquacoesCurtidas repositorioEquacoesCurtidas;
	private IRepositorioEquacoesComentarios repositorioEquacoesComentarios;

	public CadastroEquacoes() {
		this.repositorioEquacoes = RepositorioEquacoes.getInstance();
		this.repositorioEquacoesCurtidas = RepositorioEquacoesCurtidas.getInstance();
		this.repositorioEquacoesComentarios = RepositorioEquacoesComentario.getInstance();
	}

	public int equacaoCurtidas(int idEquacao) {
		return this.repositorioEquacoesCurtidas.quantidadeCurtidas(idEquacao);
	}

	public int equacaoComentarios(int idEquacao) {
		return this.repositorioEquacoesComentarios.quantidadeComentarios(idEquacao);
	}

	public List<Equacao> procurarEquacoesPorUsuario(int idUser)
			throws ObjetoJaExistenteExcepitions {

		return this.repositorioEquacoes.procurarPorUsuario(idUser);
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

	public void cadastrarEquacaoCurtida(EquacaoCurtir e)
			throws ObjetoJaExistenteExcepitions {

		if (e == null) {
			throw new IllegalArgumentException(Constantes.PARAMETRO_INVALIDO);
		} else {
			EquacaoCurtir retorno;

			retorno = this.repositorioEquacoesCurtidas.procurar(e.getId());

			if (retorno == null) {
				repositorioEquacoesCurtidas.cadastrar(e);
			} else {
				throw new ObjetoJaExistenteExcepitions(e);
			}
		}
	}

	public void cadastrarEquacaoComentario(EquacaoComentario e)
			throws ObjetoJaExistenteExcepitions {

		if (e == null) {
			throw new IllegalArgumentException(Constantes.PARAMETRO_INVALIDO);
		} else {
			EquacaoComentario retorno;

			retorno = this.repositorioEquacoesComentarios.procurar(e.getId());

			if (retorno == null) {
				repositorioEquacoesComentarios.cadastrar(e);
			} else {
				throw new ObjetoJaExistenteExcepitions(e);
			}
		}
	}
}
