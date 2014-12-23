package com.ufrpe.integrais.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ufrpe.integrais.util.Constantes;
import com.ufrpe.integrais.util.Funcoes;

public class CadastrarUsuario extends Tela {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public  CadastrarUsuario () {
		

		setTitle("Integrais - Cadastrar Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(Funcoes.centroDaTela(Constantes.CADASTRO_WIDTH, Constantes.CADASTRO_HEIGHT));

		contentPane = new PanelInformacao(false);
		add(contentPane);
		
	}



}
