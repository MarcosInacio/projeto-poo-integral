package com.ufrpe.integrais.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ufrpe.integrais.util.Constantes;
import com.ufrpe.integrais.util.Funcoes;

public class Principal extends Tela {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(Funcoes.centroDaTela(Constantes.APPLICATION_WIDTH, Constantes.APPLICATION_HEIGHT));

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
