package com.ufrpe.integrais.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.alee.laf.WebLookAndFeel;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.negocio.IntegraisFachada;
import com.ufrpe.integrais.util.Constantes;
import com.ufrpe.integrais.util.Funcoes;

public class Login extends Tela {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textEmail;
	private JPasswordField textSenha;
	private JButton btnEsqueciSenha;
	private JButton btnCriarConta;
	private JButton btnEntrar;

	/**
	 * Launch the application.
	 *
    public static void main(String[] args) {
		try 
	    {
			WebLookAndFeel.install();
			
			Login frame = new Login();
			frame.setVisible(true);
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    }
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		setTitle("Integrais - Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(Funcoes.centroDaTela(Constantes.LOGIN_WIDTH, Constantes.LOGIN_HEIGHT));

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		// Título
		JLabel lblTititulo = new JLabel("Integrais");
		lblTititulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTititulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTititulo.setBounds(10, 11, 374, 58);
		contentPane.add(lblTititulo);
		
		// E-mail
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 84, 46, 14);
		contentPane.add(lblEmail);
		
		// Texto e-mail
		textEmail = new JTextField();
		textEmail.setBounds(59, 81, 190, 25);
		textEmail.setColumns(10);
		contentPane.add(textEmail);
		
		// Senha
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 116, 46, 14);
		contentPane.add(lblSenha);
		
		// Texto senha
		textSenha = new JPasswordField();
		textSenha.setBounds(59, 113, 190, 25);
		contentPane.add(textSenha);
		
		// Botão entrar
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(160, 144, 89, 25);
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (textEmail.getText() != null && textEmail.getText().length() > 0) {
					if (textSenha.getPassword() != null && textSenha.getPassword().length > 0) {
						if (Funcoes.validarEmail(textEmail.getText())) {
							try {
								IntegraisFachada.UsuarioLogado = fachada.procurarUsuario(textEmail.getText(), textSenha.getPassword().toString());
								
								Principal principal = new Principal();
								principal.setVisible(true);
								
								Login.this.setVisible(false);
								
							} catch (ObjetoNaoExistenteExcepition e) {
								JOptionPane.showMessageDialog(Login.this, Constantes.USUARIO_NAO_ENCONTRADO);
							}
						} else {
							JOptionPane.showMessageDialog(Login.this, Constantes.EMAIL_INVALIDO);
						}
					} else {
						JOptionPane.showMessageDialog(Login.this, Constantes.SENHA_OBRIGATORIO);
					}
				} else {
					JOptionPane.showMessageDialog(Login.this, Constantes.EMAIL_OBRIGATORIO);
				}
			}
		});
		
		contentPane.add(btnEntrar);
		
		// botão criar conta
		btnCriarConta = new JButton("Criar conta");
		btnCriarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				TelaCadastrarUsuario cadastrarUsuario = new TelaCadastrarUsuario();
				cadastrarUsuario.setVisible(true);
				
				Login.this.setVisible(false);
			}
		});
		btnCriarConta.setBounds(259, 80, 125, 25);
		contentPane.add(btnCriarConta);
		
		// Botão esqueci a senha
		btnEsqueciSenha = new JButton("Esqueceu a senha?");
		btnEsqueciSenha.setBounds(259, 113, 125, 25);
		contentPane.add(btnEsqueciSenha);
	}
}
