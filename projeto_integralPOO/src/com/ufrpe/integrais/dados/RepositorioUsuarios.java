 package com.ufrpe.integrais.dados;

import java.util.ArrayList;
import java.util.List;

import com.ufrpe.integrais.dados.entidades.Amizade;
import com.ufrpe.integrais.dados.entidades.AmizadeSituacao;
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
	
	@Override
	public Usuario atualizar(Usuario entidade) {
		return super.atualizar(entidade);
	}

	public Usuario procurar(String email) {
		Usuario aux = null;
		
		for (int i = 0; i < lista.size(); i++) {
			Usuario usuario = (Usuario)lista.get(i);
			
			if (usuario.getEmail().equals(email)) {
				aux = usuario;
				break;
			}
		}

		return aux;
	}
	
	public List<Usuario> procurarPorNome(String nome) {
		List<Usuario> aux = new ArrayList<>();
		
		for (int i = 0; i < lista.size(); i++) {
			Usuario usuario = (Usuario)lista.get(i);
			
			if (usuario.getNome().toLowerCase().contains(nome.toLowerCase())) {
				aux.add(usuario);
			}
		}

		return aux;
	}
	
	public List<Usuario> procurarAmigos(List<Amizade> amigos) {
		List<Usuario> aux = new ArrayList<>();
		
		for (int j = 0; j < amigos.size(); j++) {
			if (amigos.get(j).getSituacao() == AmizadeSituacao.Confirmado) {
				for (int i = 0; i < lista.size(); i++) {
					if (amigos.get(j).getIdUsuario1() == lista.get(i).getId() || amigos.get(j).getIdUsuario2() == lista.get(i).getId()) {
						aux.add(lista.get(i));
					}
				}
			}
		}

		return aux;
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