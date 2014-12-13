package com.ufrpe.integrais.negocio;

import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;

public interface IIntegraisFachada {
	void cadastrarUsuario(Usuario usuario) throws ObjetoJaExistenteExcepitions;
	void atualizarUsuario(Usuario usuario) throws ObjetoNaoExistenteExcepition;
	Usuario procurarUsuario(String email) throws ObjetoNaoExistenteExcepition;
	Usuario procurarUsuario(String email, String senha) throws ObjetoNaoExistenteExcepition;
}
