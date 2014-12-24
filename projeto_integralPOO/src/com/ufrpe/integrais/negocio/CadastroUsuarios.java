package com.ufrpe.integrais.negocio;

import java.util.LinkedList;
import java.util.List;

import com.ufrpe.integrais.dados.IRepositorioUsuarios;
import com.ufrpe.integrais.dados.RepositorioUsuarios;
import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.util.Constantes;

public class CadastroUsuarios {

	private IRepositorioUsuarios repositosioUsuarios;
	private static final String NOME = "Usuario";

	public CadastroUsuarios() {
		repositosioUsuarios = RepositorioUsuarios.getInstance();
	}

	public LinkedList<Usuario> todosUsuarios() {
		return repositosioUsuarios.getLista();
	}

	public void cadastrarUsuario(Usuario usuario) 
			throws ObjetoJaExistenteExcepitions {
		
		if (usuario == null) {
			throw new IllegalArgumentException(Constantes.PARAMETRO_INVALIDO);
		} else {
			Usuario retorno;

			retorno = repositosioUsuarios.procurar(usuario.getEmail(), usuario.getSenha());

			if (retorno == null) {
				repositosioUsuarios.cadastrar(usuario);
			} else {
				throw new ObjetoJaExistenteExcepitions(usuario);
			}
		}
	}

	public List<Usuario> procurarUsuarios(String nome)
			throws ObjetoNaoExistenteExcepition {

		List<Usuario> retorno = repositosioUsuarios.procurarPorNome(nome);

		if (retorno == null) {
			throw new ObjetoNaoExistenteExcepition(NOME, "", "");
		}

		return retorno;
	}

	public Usuario procurarUsuario(String email, String senha)
			throws ObjetoNaoExistenteExcepition {

		Usuario retorno = repositosioUsuarios.procurar(email, senha);

		if (retorno == null) {
			throw new ObjetoNaoExistenteExcepition(NOME, email, senha);
		}

		return retorno;
	}

	public Usuario procurarUsuario(String email)
			throws ObjetoNaoExistenteExcepition {

		Usuario retorno = repositosioUsuarios.procurar(email);

		if (retorno == null) {
			throw new ObjetoNaoExistenteExcepition(NOME, email, "");
		}

		return retorno;
	}

	public Usuario procurarUsuario(int id)
			throws ObjetoNaoExistenteExcepition {

		Usuario retorno = repositosioUsuarios.procurar(id);

		if (retorno == null) {
			throw new ObjetoNaoExistenteExcepition(NOME, "", "");
		}

		return retorno;
	}

	public void removerUsuario(String email, String senha)
			throws ObjetoNaoExistenteExcepition {

		Usuario retorno = repositosioUsuarios.procurar(email, senha);

		if (retorno != null) {
			repositosioUsuarios.remover(retorno);
		} else {
			throw new ObjetoNaoExistenteExcepition(NOME, email, senha);
		}
	}

	public Usuario loginUsuario(String email, String senha)
			throws ObjetoNaoExistenteExcepition {

		Usuario retorno = repositosioUsuarios.procurar(email, senha);

		if (retorno == null) {
			throw new ObjetoNaoExistenteExcepition(NOME, email, senha);
		}

		return retorno;
	}

	public void atualizarUsuario(Usuario usuario)
			throws ObjetoNaoExistenteExcepition {

		Usuario retorno = repositosioUsuarios.atualizar(usuario);

		if (retorno == null) {
			throw new ObjetoNaoExistenteExcepition(NOME, "", "");
		}
	}
}
