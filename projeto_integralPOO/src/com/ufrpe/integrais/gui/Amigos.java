package com.ufrpe.integrais.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class Amigos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Amigos() {
		setLayout(null);

		JLabel lblMural = new JLabel("Seus amigos");
		lblMural.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMural.setBounds(0, 10, 210, 14);
		add(lblMural);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 34, 593, 1);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 46, 50, 50);
		add(panel);
		
		JLabel lblGuilhermeMelo = new JLabel("Guilherme Melo");
		lblGuilhermeMelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGuilhermeMelo.setBounds(56, 46, 200, 14);
		add(lblGuilhermeMelo);
		
		JLabel lblEquaesCompartilhadas = new JLabel("12 equa\u00E7\u00F5es compartilhadas");
		lblEquaesCompartilhadas.setBounds(56, 66, 200, 14);
		add(lblEquaesCompartilhadas);
		
		JButton btnRemoverDosMeus = new JButton("Remover dos meus amigos");
		btnRemoverDosMeus.setBounds(434, 73, 159, 23);
		add(btnRemoverDosMeus);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 107, 593, 2);
		add(separator_1);
		
		JButton btnVerPerfil = new JButton("Ver perfil");
		btnVerPerfil.setBounds(434, 46, 159, 23);
		add(btnVerPerfil);
		
	}

}
