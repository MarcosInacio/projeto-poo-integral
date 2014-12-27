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

import com.ufrpe.integrais.dados.entidades.Amizade;
import com.ufrpe.integrais.dados.entidades.AmizadeSituacao;
import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public class AmigosSolicitacoes extends Painel {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel lblMensagemVazio;

	public AmigosSolicitacoes() {
		setLayout(null);

		JLabel lblMural = new JLabel("Solicita\u00E7\u00F5es de amizades");
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
		List<Amizade> usuarios = fachada.verificarPedencias(IntegraisFachada.UsuarioLogado.getId());
		if (usuarios.contains(IntegraisFachada.UsuarioLogado))
			usuarios.remove(IntegraisFachada.UsuarioLogado);
		
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
			lblMensagemVazio.setText("Nenhuma solicitação de amizade pendente.");
		}
	}
	
	public void carregarUsuarios(final Amizade amizade, int indice) {
		JLabel panel = new JLabel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 74 * indice, 50, 50);
		painel.add(panel);
		
		try {
			final Usuario usuario = fachada.procurarUsuario(amizade.getIdUsuario1());
			
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

			final JButton btnRemoverDosMeus = new JButton("Recusar");
			
			final JButton btnVerPerfil = new JButton("Aceitar");
			btnVerPerfil.setBounds(488, 46, 105, 23);
			btnVerPerfil.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					try {
						if (btnVerPerfil.isEnabled()) {
							amizade.setSituacao(AmizadeSituacao.Confirmado);
							fachada.atualizarAmizade(amizade);
							
							btnVerPerfil.setEnabled(false);
							btnRemoverDosMeus.setEnabled(false);
							
							JOptionPane.showMessageDialog(null, "Pedido aceito com sucesso");
						}
					} catch (ObjetoNaoExistenteExcepition e1) {
						JOptionPane.showMessageDialog(null, "Houve um error ao confirmar a amizade");
					}
				}
			});
			add(btnVerPerfil);
			
			btnRemoverDosMeus.setBounds(488, 73, 105, 23);
			btnRemoverDosMeus.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					try {
						if (btnRemoverDosMeus.isEnabled()) {
							amizade.setSituacao(AmizadeSituacao.Cancelado);
							fachada.atualizarAmizade(amizade);
							
							btnVerPerfil.setEnabled(false);
							btnRemoverDosMeus.setEnabled(false);
							
							JOptionPane.showMessageDialog(null, "Pedido recusado com sucesso");
						}
					} catch (ObjetoNaoExistenteExcepition e1) {
						JOptionPane.showMessageDialog(null, "Houve um error ao confirmar a amizade");
					}
				}
			});
			add(btnRemoverDosMeus);
		} catch (ObjetoNaoExistenteExcepition e) {

		}
	}

}
