package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Usuario extends Entidade implements Serializable{

	private String nome;
	private String email;
	private String senha;
	private String universidade;
	private String curso;
	private String dataNascimento;
	
	
	
	public Usuario(int id,  Date data ,  String nome, String email, String senha,
			String universidade, String curso, String dataNascimento) {
		super(id , data);
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.universidade = universidade;
		this.curso = curso;
		this.dataNascimento = dataNascimento;
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


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	
}
