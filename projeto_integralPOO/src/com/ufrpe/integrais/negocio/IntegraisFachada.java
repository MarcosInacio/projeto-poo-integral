package com.ufrpe.integrais.negocio;

import java.util.List;

import com.ufrpe.integrais.dados.entidades.Amizade;
import com.ufrpe.integrais.dados.entidades.AmizadeSituacao;
import com.ufrpe.integrais.dados.entidades.Desafio;
import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.EquacaoComentario;
import com.ufrpe.integrais.dados.entidades.EquacaoCurtir;
import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;

public class IntegraisFachada implements IIntegraisFachada {
	private CadastroUsuarios cadastroUsuarios;
	private CadastroEquacoes cadastroEquacoes;
	private CadastroAmizades cadastroAmizades;
	private CadastroDesafios cadastroDesafios;
	
	public static Usuario UsuarioLogado;
	
	public IntegraisFachada() {
		cadastroUsuarios = new CadastroUsuarios();
		cadastroEquacoes = new CadastroEquacoes();
		cadastroAmizades = new CadastroAmizades();
		cadastroDesafios = new CadastroDesafios();
	}
	
	public void cadastrarUsuario(Usuario usuario) throws ObjetoJaExistenteExcepitions {
		cadastroUsuarios.cadastrarUsuario(usuario);
	}

	public Usuario procurarUsuario(int id) throws ObjetoNaoExistenteExcepition {
		return cadastroUsuarios.procurarUsuario(id);
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

	public List<Equacao> procurarEquacoes(int idUsuario) throws ObjetoJaExistenteExcepitions {
		return cadastroEquacoes.procurarEquacoesPorUsuario(idUsuario);
	}
	
	public List<EquacaoComentario> procurarEquacaoComentarios(int idEquacao) throws ObjetoJaExistenteExcepitions {
		return cadastroEquacoes.procurarEquacoesComentarios(idEquacao);
	}
	
	public List<Usuario> procurarUsuarios(String nome) throws ObjetoNaoExistenteExcepition {
		return cadastroUsuarios.procurarUsuarios(nome);
	}
	
	public List<Usuario> procurarAmigos(int id) throws ObjetoNaoExistenteExcepition {
		return cadastroUsuarios.procurarAmigos(cadastroAmizades.verificarAmigos(id));
	}
	
	public void cadastrarEquacao(Equacao equacao) throws ObjetoJaExistenteExcepitions {
		cadastroEquacoes.cadastrarEquacoes(equacao);
	}
	
	public void cadastrarEquacaoCurtida(EquacaoCurtir equacaoCurtir) throws ObjetoJaExistenteExcepitions {
		cadastroEquacoes.cadastrarEquacaoCurtida(equacaoCurtir);
	}

	public void cadastrarEquacaoComentario(EquacaoComentario equacaoComentario) throws ObjetoJaExistenteExcepitions {
		cadastroEquacoes.cadastrarEquacaoComentario(equacaoComentario);
	}

	public int equacaoCurtidas(int idEquacao) {
		return cadastroEquacoes.equacaoCurtidas(idEquacao);
	}
	
	public int equacaoComentarios(int idEquacao) {
		return cadastroEquacoes.equacaoComentarios(idEquacao);
	}
	
	public void cadastrarAmizade(Amizade amizade) throws ObjetoJaExistenteExcepitions {
		cadastroAmizades.cadastrarAmizade(amizade);
	}
	
	public void atualizarAmizade(Amizade amizade) throws ObjetoNaoExistenteExcepition {
		cadastroAmizades.atualizarAmizade(amizade);
	}
	
	public AmizadeSituacao verificarAmizade(int idUsuario1, int idUsuario2) {
		return cadastroAmizades.verificarAmizade(idUsuario1, idUsuario2);
	}
	
	public List<Amizade> verificarPedencias(int idUsuario2) {
		return cadastroAmizades.verificarPedencias(idUsuario2);
	}
	
	public void removerAmizade(int idUsuario1, int idUsuario2) {
		cadastroAmizades.removerAmizade(idUsuario1, idUsuario2);
	}

	@Override
	public void cadastrarDesafio(Desafio d) throws ObjetoJaExistenteExcepitions {
		cadastroDesafios.cadastrarDesafio(d);
	}

	@Override
	public void atualizarDesafio(Desafio d) throws ObjetoNaoExistenteExcepition {
		cadastroDesafios.atualizarDesafio(d);
	}
	
	public List<Desafio> procurarPorDesafiado(int idDesafiado) {
		return cadastroDesafios.procurarPorDesafiado(idDesafiado);
	}
}
