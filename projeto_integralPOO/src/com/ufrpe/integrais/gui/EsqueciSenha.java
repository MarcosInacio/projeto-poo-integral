package com.ufrpe.integrais.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.util.Constantes;
import com.ufrpe.integrais.util.Funcoes;

public class EsqueciSenha extends Tela {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEmail;

	public EsqueciSenha() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(Funcoes.centroDaTela(Constantes.LOGIN_WIDTH, Constantes.LOGIN_HEIGHT));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Título
		JLabel lblTititulo = new JLabel("Integrais");
		lblTititulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTititulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTititulo.setBounds(10, 11, 374, 58);
		contentPane.add(lblTititulo);
		
		JLabel lblDigiteSeuEmail = new JLabel("Digite seu e-mail:");
		lblDigiteSeuEmail.setBounds(10, 80, 101, 14);
		contentPane.add(lblDigiteSeuEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(10, 105, 364, 25);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnRecuperar = new JButton("Recuperar");
		btnRecuperar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textEmail.getText() != null && textEmail.getText().length() > 0 && Funcoes.validarEmail(textEmail.getText())) {
					try {
						Usuario usuario = fachada.procurarUsuario(textEmail.getText());
						Random gerador = new Random();
						String senha = String.valueOf(gerador.nextInt(999999));
						
						JOptionPane.showMessageDialog(null, "Sua nova senha é: " + senha + ", ao entrar no sistema vá em alterar senha.");
						
						usuario.setSenha(Funcoes.criptografar(senha));
						
						fachada.atualizarUsuario(usuario);

						EsqueciSenha.this.setVisible(false);
						GerenciadorTelas.getTela(Constantes.ESQUECI_SENHA,Constantes.PRINCIPAL);
						
					} catch (ObjetoNaoExistenteExcepition e1) {
						JOptionPane.showMessageDialog(null, "E-mail não encontrado");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Digite um e-mail válido");
				}
			}
		});
		btnRecuperar.setBounds(285, 147, 89, 23);
		contentPane.add(btnRecuperar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EsqueciSenha.this.setVisible(false);
				GerenciadorTelas.getTela(Constantes.ESQUECI_SENHA,Constantes.LOGIN);
			}
		});
		btnVoltar.setBounds(186, 147, 89, 23);
		contentPane.add(btnVoltar);
	}
}
