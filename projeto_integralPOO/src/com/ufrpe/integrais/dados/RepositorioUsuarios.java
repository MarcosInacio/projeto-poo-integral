package com.ufrpe.integrais.dados;

import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.util.Funcoes;

public class RepositorioUsuarios extends Repositorio<Usuario> implements IRepositorioUsuarios {

	private static IRepositorioUsuarios instance;

	private RepositorioUsuarios() {
		super("Usuario");
	}

	public static IRepositorioUsuarios getInstance() {
		if (instance == null) {
			instance = new RepositorioUsuarios();
		}

		return instance;
	}
	
	@Override
	public void cadastrar(Usuario entidade) {
		entidade.setSenha(Funcoes.criptografar(entidade.getSenha()));
		super.cadastrar(entidade);
	}
	
	@Override
	public Usuario procurar(int id) {
		return super.procurar(id);
	}
	
	@Override
	public void remover(Usuario entidade) {
		super.remover(entidade);
	}

	public Usuario procurar(String email, String senha) {
		Usuario aux = null;
		
		senha = Funcoes.criptografar(senha);
		
		for (int i = 0; i < lista.size(); i++) {
			Usuario usuario = (Usuario)lista.get(i);
			
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				aux = usuario;
				break;
			}
		}

		return aux;
	}
}