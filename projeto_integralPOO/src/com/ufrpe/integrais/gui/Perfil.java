package com.ufrpe.integrais.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public class Perfil extends Painel {

	private static final long serialVersionUID = 1L;
	public static Usuario UsuarioVisualizar = null;
	
	private JLabel panel;
	public JLabel lblNome, lblEmail, lblUniversidade, lblCurso;
	private JButton btnEditarPerfil;
	
	public Perfil() {
		setLayout(null);

		JLabel lblNom = new JLabel("Nome:");
		lblNom.setBounds(84, 11, 70, 14);
		add(lblNom);
		
		JLabel lblEmai = new JLabel("E-mail:");
		lblEmai.setBounds(84, 31, 70, 14);
		add(lblEmai);
		
		JLabel lblCurs = new JLabel("Curso:");
		lblCurs.setBounds(84, 71, 70, 14);
		add(lblCurs);
		
		JLabel lblUniversidad = new JLabel("Universidade:");
		lblUniversidad.setBounds(84, 51, 70, 14);
		add(lblUniversidad);	
		
		panel = new JLabel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 11, 74, 74);
		add(panel);
	
		lblNome = new JLabel();
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(160, 11, 180, 14);
		add(lblNome);
		
		lblEmail = new JLabel();
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(160, 31, 180, 14);
		add(lblEmail);
		
		lblUniversidade = new JLabel();
		lblUniversidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUniversidade.setBounds(160, 51, 180, 14);
		add(lblUniversidade);
		
		lblCurso = new JLabel();
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCurso.setBounds(160, 71, 180, 14);
		add(lblCurso);
		
		btnEditarPerfil = new JButton("Editar Perfil");
		btnEditarPerfil.setBounds(504, 6, 89, 23);
		add(btnEditarPerfil);
	}

	@Override
	public void carregarPainel() {
		if (UsuarioVisualizar == null) {
			lblNome.setText(IntegraisFachada.UsuarioLogado.getNome());
			lblEmail.setText(IntegraisFachada.UsuarioLogado.getEmail());
			lblUniversidade.setText(IntegraisFachada.UsuarioLogado.getUniversidade());
			lblCurso.setText(IntegraisFachada.UsuarioLogado.getCurso());
			
			btnEditarPerfil.setVisible(true);
			btnEditarPerfil.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					Principal.cardLayout.show(Principal.panelContent, "PERFILEDITAR");
				}
			});
			
			if (IntegraisFachada.UsuarioLogado.getFoto() != null) {
				Image img = IntegraisFachada.UsuarioLogado.getFoto().getImage().getScaledInstance(74, 74, Image.SCALE_DEFAULT); 
				panel.setIcon(new ImageIcon(img));
				panel.setVisible(true);
			} else {
				panel.setIcon(null);
			}
		} else {
			lblNome.setText(UsuarioVisualizar.getNome());
			lblEmail.setText(UsuarioVisualizar.getEmail());
			lblUniversidade.setText(UsuarioVisualizar.getUniversidade());
			lblCurso.setText(UsuarioVisualizar.getCurso());
			
			btnEditarPerfil.setVisible(false);
			
			if (UsuarioVisualizar.getFoto() != null) {
				Image img = UsuarioVisualizar.getFoto().getImage().getScaledInstance(74, 74, Image.SCALE_DEFAULT); 
				panel.setIcon(new ImageIcon(img));
				panel.setVisible(true);
			} else {
				panel.setIcon(null);
			}
		}
		
		UsuarioVisualizar = null;
	}
}
