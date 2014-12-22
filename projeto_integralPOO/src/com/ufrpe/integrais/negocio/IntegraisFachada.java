package com.ufrpe.integrais.negocio;

import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;

public class IntegraisFachada implements IIntegraisFachada {
	private CadastroUsuarios cadastroUsuarios;
	private CadastroEquacoes cadastroEquacoes;
	
	public static Usuario UsuarioLogado;
	
	public IntegraisFachada() {
		cadastroUsuarios = new CadastroUsuarios();
	}
	
	public void cadastrarUsuario(Usuario usuario) throws ObjetoJaExistenteExcepitions {
		cadastroUsuarios.cadastrarUsuario(usuario);
	}

	public Usuario procurarUsuario(String email, String senha) throws ObjetoNaoExistenteExcepition {
		return cadastroUsuarios.procurarUsuario(email, senha);
	}

	public Usuario procurarUsuario(String email) throws ObjetoNaoExistenteExcepition {
		return cadastroUsuarios.procurarUsuario(email);
	}

	public void atualizarUsuario(Usuario usuario) throws ObjetoNaoExistenteExcepition {
		cadastroUsuarios.atualizarUsuario(usuario);
	}
	
	public void cadastrarEquacao(Equacao equacao) throws ObjetoJaExistenteExcepitions {
		cadastroEquacoes.cadastrarEquacoes(equacao);
	}
}
