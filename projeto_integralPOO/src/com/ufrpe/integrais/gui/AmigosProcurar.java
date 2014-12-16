package com.ufrpe.integrais.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class AmigosProcurar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AmigosProcurar() {
		setLayout(null);

		JLabel lblMural = new JLabel("Procurar amigos");
		lblMural.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMural.setBounds(0, 10, 210, 14);
		add(lblMural);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 34, 593, 1);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 130, 50, 50);
		add(panel);
		
		JLabel lblGuilhermeMelo = new JLabel("Guilherme Melo");
		lblGuilhermeMelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGuilhermeMelo.setBounds(56, 130, 200, 14);
		add(lblGuilhermeMelo);
		
		JLabel lblEquaesCompartilhadas = new JLabel("12 equa\u00E7\u00F5es compartilhadas");
		lblEquaesCompartilhadas.setBounds(56, 150, 200, 14);
		add(lblEquaesCompartilhadas);
		
		JButton btnRemoverDosMeus = new JButton("Remover dos meus amigos");
		btnRemoverDosMeus.setBounds(434, 157, 159, 23);
		add(btnRemoverDosMeus);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 191, 593, 2);
		add(separator_1);
		
		JButton btnVerPerfil = new JButton("Ver perfil");
		btnVerPerfil.setBounds(434, 130, 159, 23);
		add(btnVerPerfil);
		
		textField = new JTextField();
		textField.setBounds(0, 46, 494, 25);
		add(textField);
		textField.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(504, 46, 89, 25);
		add(btnProcurar);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 82, 593, 1);
		add(separator_2);
		
		JLabel lblResultadosEncontrados = new JLabel("1 resultado encontrados");
		lblResultadosEncontrados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultadosEncontrados.setBounds(0, 94, 210, 14);
		add(lblResultadosEncontrados);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 118, 593, 1);
		add(separator_3);
	}

}
