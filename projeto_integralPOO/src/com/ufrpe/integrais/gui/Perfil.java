package com.ufrpe.integrais.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Perfil extends JPanel {

	private static final long serialVersionUID = 1L;
	

	/**
	 * Create the panel.
	 */
	public Perfil() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(84, 11, 70, 14);
		add(lblNome);
		
		JLabel lblPauloMenezes = new JLabel("Paulo Menezes");
		lblPauloMenezes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPauloMenezes.setBounds(160, 11, 180, 14);
		add(lblPauloMenezes);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(84, 31, 70, 14);
		add(lblEmail);
		
		JLabel lblPaulohgmenezesgmailcom = new JLabel("paulo.hgmenezes@gmail.com");
		lblPaulohgmenezesgmailcom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPaulohgmenezesgmailcom.setBounds(160, 31, 180, 14);
		add(lblPaulohgmenezesgmailcom);
		
		JLabel lblUniversidade = new JLabel("Universidade:");
		lblUniversidade.setBounds(84, 51, 70, 14);
		add(lblUniversidade);
		
		JLabel lblUfrpe = new JLabel("UFRPE");
		lblUfrpe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUfrpe.setBounds(160, 51, 180, 14);
		add(lblUfrpe);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(84, 71, 70, 14);
		add(lblCurso);
		
		JLabel lblCinciasDaComputao = new JLabel("Ci\u00EAncias da Computa\u00E7\u00E3o");
		lblCinciasDaComputao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCinciasDaComputao.setBounds(160, 71, 180, 14);
		add(lblCinciasDaComputao);
		
		JButton btnEditarPerfil = new JButton("Editar Perfil");
		btnEditarPerfil.setBounds(504, 6, 89, 23);
		add(btnEditarPerfil);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 93, 593, 10);
		add(separator);
		
		JLabel lblHistricoDeAtividades = new JLabel("Hist\u00F3rico de atividades");
		lblHistricoDeAtividades.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHistricoDeAtividades.setBounds(0, 102, 200, 14);
		add(lblHistricoDeAtividades);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 11, 74, 74);
		add(panel);

	}

}
