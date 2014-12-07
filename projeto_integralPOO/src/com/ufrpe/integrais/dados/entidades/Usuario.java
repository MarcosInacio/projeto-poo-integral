package com.ufrpe.integrais.dados.entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario extends Entidade implements Serializable{

	private String nome;
	private String cpf;
	private String email;
	private String senha;
	
	public Usuario() {
		
	}

	public Usuario(String nome, String cpf, String email, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Usuario) {
			if (((Usuario) obj).getCpf().equals(cpf)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
