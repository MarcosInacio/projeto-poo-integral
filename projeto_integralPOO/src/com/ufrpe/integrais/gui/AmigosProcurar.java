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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.ufrpe.integrais.dados.entidades.Amizade;
import com.ufrpe.integrais.dados.entidades.AmizadeSituacao;
import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public class AmigosProcurar extends Painel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPanel painel;

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
		
		textField = new JTextField();
		textField.setBounds(0, 46, 494, 25);
		add(textField);
		textField.setColumns(10);
		
		painel = new JPanel();
		painel.setLayout(null);
		
		final JLabel lblResultadosEncontrados = new JLabel("Nenhum resultado encontrado");
		final JSeparator separator_3 = new JSeparator();
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(504, 46, 89, 25);
		btnProcurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (textField.getText().length() > 0) {
					try {
						List<Usuario> usuarios = fachada.procurarUsuarios(textField.getText());
						if (usuarios.contains(IntegraisFachada.UsuarioLogado))
							usuarios.remove(IntegraisFachada.UsuarioLogado);
						
						if (usuarios.size() > 0) {
							if (getComponents()[getComponentCount() - 1] instanceof JScrollPane) {
								remove(getComponentCount() - 1);
								painel.removeAll();
							}
							
							lblResultadosEncontrados.setVisible(true);
							lblResultadosEncontrados.setText(usuarios.size() + " resultados encontrados");
							separator_3.setVisible(true);
							
							for (int i = 0; i < usuarios.size(); i++) {
								carregarUsuarios(usuarios.get(i), i);
							}

							painel.setBounds(0, 130, 633, 60 * usuarios.size());
							painel.setPreferredSize(new Dimension(633, 60 * usuarios.size()));
							
							JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
							scroll.setViewportView(painel);
							scroll.setBounds(0, 130, 614, 410);
							scroll.setSize(614, 410);
							scroll.setBorder(null);

							add(scroll);
						} else {
							lblResultadosEncontrados.setText("Nenhum resultado encontrado");
							lblResultadosEncontrados.setVisible(false);
							separator_3.setVisible(false);
						}
					} catch (ObjetoNaoExistenteExcepition e1) {
						lblResultadosEncontrados.setText("Nenhum resultado encontrado");
						lblResultadosEncontrados.setVisible(false);
						separator_3.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Digite o nome ou as iniciais de quem deseja procurar");
				}
			}
		});
		add(btnProcurar);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 82, 593, 1);
		add(separator_2);
		
		lblResultadosEncontrados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultadosEncontrados.setBounds(0, 94, 210, 14);
		lblResultadosEncontrados.setVisible(false);
		add(lblResultadosEncontrados);
		
		separator_3.setBounds(0, 118, 593, 1);
		separator_3.setVisible(false);
		add(separator_3);
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
		
		if (fachada.verificarAmizade(IntegraisFachada.UsuarioLogado.getId(), usuario.getId()) == null) {
			final JButton btnRemoverDosMeus = new JButton("Adicionar como amigo");
			btnRemoverDosMeus.setBounds(434, 27 + (74 * indice), 159, 23);
			btnRemoverDosMeus.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					try {
						Amizade am = new Amizade(IntegraisFachada.UsuarioLogado.getId(), usuario.getId(), AmizadeSituacao.Pendente); 
						fachada.cadastrarAmizade(am);
						
						JOptionPane.showMessageDialog(null, "Pedido enviado com sucesso");
						btnRemoverDosMeus.setVisible(false);						
					} catch (ObjetoJaExistenteExcepitions e1) {
						JOptionPane.showMessageDialog(null, "Houve um error ao solicitar a amizade");
					}
				}
			});
			painel.add(btnRemoverDosMeus);
		}
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 61 + (74 * indice), 593, 2);
		painel.add(separator_1);
		
		JButton btnVerPerfil = new JButton("Ver perfil");
		btnVerPerfil.setBounds(434, 74 * indice, 159, 23);
		painel.add(btnVerPerfil);
	}

	@Override
	public void carregarPainel() { }
}
