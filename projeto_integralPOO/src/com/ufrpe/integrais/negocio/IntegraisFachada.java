package com.ufrpe.integrais.negocio;

import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;

public class IntegraisFachada implements IIntegraisFachada {
	private CadastroUsuarios cadastroUsuarios;
	
	public static Usuario UsuarioLogado = null;
	
	public IntegraisFachada() {
		cadastroUsuarios = new CadastroUsuarios();
	}
	
	public void cadastrarUsuario(Usuario usuario) throws ObjetoJaExistenteExcepitions {
		cadastroUsuarios.cadastrarUsuario(usuario);
	}

	public Usuario procurarUsuario(String email, String senha) throws ObjetoNaoExistenteExcepition {
		return cadastroUsuarios.procurarUsuario(email, senha);
	}
}
