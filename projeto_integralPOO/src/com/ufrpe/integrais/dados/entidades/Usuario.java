package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Usuario extends Entidade implements Serializable {

	private String nome;
	private String email;
	private String senha;
	private String universidade;
	private String curso;
	private ImageIcon foto;
	
	public Usuario(String nome, String email, String senha,
			String universidade, String curso) {
		
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.universidade = universidade;
		this.curso = curso;
	}

	public String getUniversidade() {
		return universidade;
	}

	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ImageIcon getFoto() {
		return foto;
	}

	public void setFoto(ImageIcon foto) {
		this.foto = foto;
	}	
}
