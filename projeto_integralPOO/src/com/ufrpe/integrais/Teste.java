package com.ufrpe.integrais;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.negocio.GerenciadorUsuarios;

public class Teste {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		
		boolean logado = false;
		Usuario usuario = null;

		GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
		
		while (opcao != 3) {
			System.out.println("###################################");
			System.out.println("#---------------------------------#");
			System.out.println("#-----------Integrais-------------#");
			System.out.println("#---------------------------------#");
			System.out.println("###################################");
			
			System.out.println();
			
			if (!logado) {
				System.out.println("[1] - Cadastrar usu�rio");
				System.out.println("[2] - Fazer login");
				System.out.println("[3] - Sair");
				
				System.out.println();
				
				System.out.print("Digite uma op��o: ");
				
				opcao = scanner.nextInt();
				
				if (opcao == 1) {
					 System.out.println("#---------------------#");
					 System.out.println("#--Cadastrar usu�rio--#");
					 System.out.println("#---------------------#");
					 
					 String nome = JOptionPane.showInputDialog("Digite seu nome");
					 String cpf = JOptionPane.showInputDialog("Digite seu CPF");
					 String email = JOptionPane.showInputDialog("Digite seu e-mail");
					 String senha = JOptionPane.showInputDialog("Digite sua senha");
					 
					 gerenciadorUsuarios.cadastrar(nome, email, cpf, senha);
					 
					 System.out.println("Usu�rio " + nome + " adicionado com sucesso!");
					 System.out.println();
				} else if (opcao == 2) {
					 System.out.println("#---------#");
					 System.out.println("#--Login--#");
					 System.out.println("#---------#");

					 String email = JOptionPane.showInputDialog("Digite seu e-mail");
					 String senha = JOptionPane.showInputDialog("Digite sua senha");
					 
					 Usuario u = gerenciadorUsuarios.login(email, senha);
					 if (u != null) {
						 System.out.println("Usu�rio " + u.getNome() + " logado com sucesso!");
						 System.out.println();
						 
						 usuario = u;
						 
						 logado = true;
					 } else {
						 System.out.println("Usu�rio n�o encontrado");
						 System.out.println();
						 
						 logado = false;
					 }
				}
			} else {
				System.out.println("Bem vindo " + usuario.getNome());
				
				System.out.println("[1] - Cadastrar equa��o");
				System.out.println("[2] - Ver minhas equa��es");
				System.out.println("[3] - Sair");

				System.out.println();
				
				System.out.print("Digite uma op��o: ");
				
				opcao = scanner.nextInt();
				
				if (opcao == 1) {
					 System.out.println("#---------------------#");
					 System.out.println("#--Cadastrar equa��o--#");
					 System.out.println("#---------------------#");
					 
					 String equacao = JOptionPane.showInputDialog("Digite sua equa��o");
					 
					 gerenciadorUsuarios.cadastrarEquacao(equacao, usuario);
					 
					 System.out.println("Equa��o adicionada com sucesso.");
				} else if (opcao == 2) {
					 System.out.println("#------------------#");
					 System.out.println("#--Minhas equa��o--#");
					 System.out.println("#------------------#");
					 
					 System.out.println();
					 
					 for (Equacao e : gerenciadorUsuarios.procurarEquacao(usuario)) {
						 System.out.println(e.getFormula());
					 }
					 
					 System.out.println();
				} else if (opcao == 3) {
					usuario = null;
					logado = false;
				}
			}
		}
		
		scanner.close();
	}

}
