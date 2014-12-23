package com.ufrpe.integrais.negocio;

import java.util.List;

import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.EquacaoComentario;
import com.ufrpe.integrais.dados.entidades.EquacaoCurtir;
import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;

public interface IIntegraisFachada {
	// Usuários
	void cadastrarUsuario(Usuario usuario) throws ObjetoJaExistenteExcepitions;
	void atualizarUsuario(Usuario usuario) throws ObjetoNaoExistenteExcepition;
	Usuario procurarUsuario(String email) throws ObjetoNaoExistenteExcepition;
	Usuario procurarUsuario(String email, String senha) throws ObjetoNaoExistenteExcepition;
	
	// Equações
	void cadastrarEquacao(Equacao equacao) throws ObjetoJaExistenteExcepitions;
	List<Equacao> procurarEquacoes(int idUsuario) throws ObjetoJaExistenteExcepitions;
	
	int equacaoCurtidas(int idEquacao);
	int equacaoComentarios(int idEquacao);
	
	void cadastrarEquacaoCurtida(EquacaoCurtir equacaoCurtir) throws ObjetoJaExistenteExcepitions;
	void cadastrarEquacaoComentario(EquacaoComentario equacaoComentario) throws ObjetoJaExistenteExcepitions;
}
