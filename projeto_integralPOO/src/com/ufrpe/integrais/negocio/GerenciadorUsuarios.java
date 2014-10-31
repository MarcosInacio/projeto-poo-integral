package com.ufrpe.integrais.negocio;

import java.util.List;

import com.ufrpe.integrais.dados.RepositorioEquacoes;
import com.ufrpe.integrais.dados.RepositorioUsuarios;
import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.Usuario;

public class GerenciadorUsuarios {
	private RepositorioUsuarios usuarios = new RepositorioUsuarios();
	private RepositorioEquacoes equacoes = new RepositorioEquacoes();
	
	public GerenciadorUsuarios() {
		
	}
	
	public void cadastrar(String nome, String email, String cpf, String senha) {
		Usuario u = new Usuario();
		u.setNome(nome);
		u.setEmail(email);
		u.setCpf(cpf);
		u.setSenha(senha);
		
		usuarios.cadastrar(u);
	}
	
	public Usuario login(String email, String senha) {
		return usuarios.procurar(email, senha);
	}
	
	public void cadastrarEquacao(String equacao, Usuario usuario) {
		Equacao e = new Equacao();
		e.setFormula(equacao);
		e.setUsuario(usuario);
		
		equacoes.cadastrar(e);
	}
	
	public List<Equacao> procurarEquacao(Usuario usuario) {
		return equacoes.procurar(usuario);
	}
}
