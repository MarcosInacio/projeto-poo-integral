package com.ufrpe.integrais.gui;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.negocio.IntegraisFachada;
import com.ufrpe.integrais.util.Constantes;
import com.ufrpe.integrais.util.Funcoes;

public class Login extends Tela implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textEmail;
	private JPasswordField textSenha;
	private JButton btnEsqueciSenha;
	private JButton btnCriarConta;
	private JButton btnEntrar;
	private Map<JTextField, Boolean> camposPreenchidos =  new HashMap<>();

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
		textEmail.addKeyListener(this);
		contentPane.add(textEmail);
		camposPreenchidos.put(textEmail, false);
		
		// Senha
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 116, 46, 14);
		contentPane.add(lblSenha);
		
		// Texto senha
		textSenha = new JPasswordField();
		textSenha.setBounds(59, 113, 190, 25);
		textSenha.addKeyListener(this);
		contentPane.add(textSenha);
		camposPreenchidos.put(textSenha, false);
		
		// Botão entrar
		btnEntrar = new JButton("Entrar");
		btnEntrar.setToolTipText("Preencha todos os campos !");
		btnEntrar.setEnabled(false);
		btnEntrar.setBounds(160, 144, 89, 25);
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {	
				if (btnEntrar.isEnabled()) {
					if (Funcoes.validarEmail(textEmail.getText())) {
						try {
							IntegraisFachada.UsuarioLogado = fachada.procurarUsuario(textEmail.getText(), new String(textSenha.getPassword()));
							
							Login.this.setVisible(false);
	
							GerenciadorTelas.getTela(Constantes.LOGIN,Constantes.PRINCIPAL);
						} catch (ObjetoNaoExistenteExcepition e) {
							JOptionPane.showMessageDialog(Login.this, Constantes.USUARIO_NAO_ENCONTRADO);
						}
					} else {
						JOptionPane.showMessageDialog(Login.this, Constantes.EMAIL_INVALIDO);
					}
				}
			}
		});
		
		contentPane.add(btnEntrar);
		
		// botão criar conta
		btnCriarConta = new JButton("Criar conta");
		btnCriarConta.setBounds(259, 80, 125, 25);
		btnCriarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {			
				Login.this.setVisible(false);
				
				GerenciadorTelas.getTela(Constantes.LOGIN, Constantes.CADASTRAR_USUARIO);
			}
		});
		contentPane.add(btnCriarConta);
		
		// Botão esqueci a senha
		btnEsqueciSenha = new JButton("Esqueceu a senha?");
		btnEsqueciSenha.setBounds(259, 113, 125, 25);
		btnEsqueciSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {			
				Login.this.setVisible(false);
				
				GerenciadorTelas.getTela(Constantes.LOGIN,Constantes.ESQUECI_SENHA);
			}
		});
		contentPane.add(btnEsqueciSenha);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	private void verificarCampos(JTextField field){
		

		boolean resultado = true;
		
		if (!field.getText().isEmpty()) {
			camposPreenchidos.put(field, true);
		} else {
			camposPreenchidos.put(field, false);
		}
		
		
		if (camposPreenchidos.size() >= 2) {
			for (JTextField v : camposPreenchidos.keySet()) {
				if (!camposPreenchidos.get(v)) {
					resultado = false;
				}
			}
		} else {
			resultado = false;
		}
		
		if (resultado) {
			btnEntrar.setEnabled(true);
			btnEntrar.setToolTipText("");
		} else {
			btnEntrar.setEnabled(false);
			btnEntrar.setToolTipText("Preencha todos os campos");
		}
		
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		
		
		if(e.getSource().equals(textEmail)){
			
			
			verificarCampos(textEmail);
			
		}else if (e.getSource().equals(textSenha)){
			
			verificarCampos(textSenha);
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
