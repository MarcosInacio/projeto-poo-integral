package com.ufrpe.integrais.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Inicio extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Inicio() {
		setLayout(null);
		
		JLabel lblMural = new JLabel("Mural");
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
		
		JLabel lblGuilhermeMeloCompartilhou = new JLabel("Guilherme Melo compartilhou a integral");
		lblGuilhermeMeloCompartilhou.setBounds(56, 46, 527, 14);
		add(lblGuilhermeMeloCompartilhou);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(56, 71, 537, 150);
		add(panel_1);
		
		JLabel lblCurtidas = new JLabel("10 curtidas");
		lblCurtidas.setBounds(132, 227, 124, 14);
		add(lblCurtidas);
		
		JLabel lblComentrio = new JLabel("1 coment\u00E1rio");
		lblComentrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComentrio.setBounds(383, 227, 210, 14);
		add(lblComentrio);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setBounds(283, 252, 310, 40);
		add(textArea);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(504, 303, 89, 23);
		add(btnEnviar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(283, 329, 50, 50);
		add(panel_2);
		
		JLabel lblLeandroOntems = new JLabel("Leandro, ontem \u00E0s 15:30");
		lblLeandroOntems.setBounds(339, 329, 200, 14);
		add(lblLeandroOntems);
		
		JLabel lblAlgumComentrioo = new JLabel("Algum coment\u00E1rio \\o/");
		lblAlgumComentrioo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlgumComentrioo.setVerticalAlignment(SwingConstants.TOP);
		lblAlgumComentrioo.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlgumComentrioo.setBounds(339, 349, 254, 30);
		add(lblAlgumComentrioo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(56, 390, 537, 1);
		add(separator_1);
		
		JButton button = new JButton("Curtir");
		button.setBounds(56, 223, 66, 23);
		add(button);

	}
}
