package com.ufrpe.integrais.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public class Amigos extends Painel {
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel lblMensagemVazio;
	
	public Amigos() {
		setLayout(null);

		JLabel lblMural = new JLabel("Seus amigos");
		lblMural.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMural.setBounds(0, 10, 210, 14);
		add(lblMural);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 34, 593, 1);
		add(separator);
		
		lblMensagemVazio = new JLabel("");
		lblMensagemVazio.setBounds(0, 46, 593, 14);
		add(lblMensagemVazio);

		painel = new JPanel();
		painel.setLayout(null);
	}

	@Override
	public void carregarPainel() {
		try {
			List<Usuario> usuarios = fachada.procurarAmigos(IntegraisFachada.UsuarioLogado.getId());
			
			for (int i = 0; i < usuarios.size(); i++) {
				if (usuarios.get(i).getId() == IntegraisFachada.UsuarioLogado.getId()) {
					usuarios.remove(i);
				}
			}
			
			if (usuarios.size() > 0) {
				if (getComponents()[getComponentCount() - 1] instanceof JScrollPane) {
					remove(getComponentCount() - 1);
					painel.removeAll();
				}
				
				for (int i = 0; i < usuarios.size(); i++) {
					carregarUsuarios(usuarios.get(i), i);
				}

				painel.setBounds(0, 46, 633, 60 * usuarios.size());
				painel.setPreferredSize(new Dimension(633, 60 * usuarios.size()));
				
				JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				scroll.setViewportView(painel);
				scroll.setBounds(0, 46, 614, 410);
				scroll.setSize(614, 410);
				scroll.setBorder(null);

				add(scroll);
			} else {
				if (getComponents()[getComponentCount() - 1] instanceof JScrollPane) {
					remove(getComponentCount() - 1);
					painel.removeAll();
				}
				
				lblMensagemVazio.setText("Nenhum amigo encontrado.");
			}
		} catch (ObjetoNaoExistenteExcepition e) {

		}
	}
	
	public void carregarUsuarios(final Usuario usuario, int indice) {
		JLabel panel = new JLabel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 74 * indice, 50, 50);
		painel.add(panel);
		
		if (usuario.getFoto() != null) {
			Image img = usuario.getFoto().getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); 
			panel.setIcon(new ImageIcon(img));
		}
		
		JLabel lblGuilhermeMelo = new JLabel(usuario.getNome());
		lblGuilhermeMelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGuilhermeMelo.setBounds(56, 74 * indice, 200, 14);
		painel.add(lblGuilhermeMelo);
		
		try {
			JLabel lblEquaesCompartilhadas = new JLabel(fachada.procurarEquacoes(usuario.getId()).size() + " equa\u00E7\u00F5es compartilhadas");
			lblEquaesCompartilhadas.setBounds(56, 20 + (74 * indice), 200, 14);
			painel.add(lblEquaesCompartilhadas);
		} catch (ObjetoJaExistenteExcepitions e) {

		}
					
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 61 + (74 * indice), 593, 2);
		painel.add(separator_1);
		
		final JButton btnVerPerfil = new JButton("Ver perfil");
		btnVerPerfil.setBounds(400, 74 * indice, 193, 23);
		btnVerPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Perfil.UsuarioVisualizar = usuario;
				((Painel)Principal.panelContent.getComponent(1)).carregarPainel();
				Principal.cardLayout.show(Principal.panelContent, "PERFIL");
			}
		});
		painel.add(btnVerPerfil);

		final JButton btnRemoverDosMeus = new JButton("Remover dos meus amigos");
		btnRemoverDosMeus.setBounds(400, 26 + (74 * indice), 193, 23);
		btnRemoverDosMeus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				fachada.removerAmizade(IntegraisFachada.UsuarioLogado.getId(), usuario.getId());
				JOptionPane.showMessageDialog(null, "Amizade removida com sucesso");
				btnRemoverDosMeus.setEnabled(false);
			}
		});
		painel.add(btnRemoverDosMeus);
	}
}
