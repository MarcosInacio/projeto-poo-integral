package com.ufrpe.integrais.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
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
import javax.swing.text.MaskFormatter;

import com.ufrpe.integrais.util.Constantes;
import com.ufrpe.integrais.util.Funcoes;


public class CadastrarUsuario extends Tela implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldSobreNome;
	private JTextField textFieldUniversidade;
	private JTextField textFieldCurso;
	private JPasswordField passwordField_senha;
	private JPasswordField passwordField_repSenha;
	private Map<JTextField, Boolean> camposPreenchidos =  new HashMap<>();
	private JButton btnCriarConta;

	/**
	 * Create the frame.
	 * 
	 * 
	 */

	public CadastrarUsuario() {		
		this.nomeDaTela = "CadastrarUsuario";
		
		setTitle("Integrais - Cadastrar Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(Funcoes.centroDaTela(Constantes.CADASTRO_WIDTH,
				Constantes.CADASTRO_HEIGHT));

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 84, 46, 14);
		contentPane.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {

				String caracteres = "0987654321";

				if (caracteres.contains(event.getKeyChar() + "")) {

					JOptionPane.showMessageDialog(null,
							"Só permitido letras !!");
					event.consume();
				}

			}
		});

		textFieldNome.setColumns(10);
		textFieldNome.setBounds(10, 100, 167, 25);
		textFieldNome.addKeyListener(this);
		contentPane.add(textFieldNome);
		camposPreenchidos.put(textFieldNome, false);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(11, 134, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblCadastrarUsurio = new JLabel("Cadastrar Usu\u00E1rio");
		lblCadastrarUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarUsurio.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCadastrarUsurio.setBounds(10, 11, 374, 58);
		contentPane.add(lblCadastrarUsurio);

		btnCriarConta = new JButton("Criar conta");
		btnCriarConta.setToolTipText("preencha todos os campos ");
		btnCriarConta.setEnabled(false);
		btnCriarConta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				if(Funcoes.validarEmail(textFieldEmail.getText())){
				
				if(new String(passwordField_senha.getPassword()).equals(new String(passwordField_repSenha.getPassword()))  ){
				
					
					
					
				}else{
					
					
					JOptionPane.showMessageDialog(null, Constantes.REPETIRSENHA_OBRIGATORIO);
				}
				
				}else{
					
					JOptionPane.showMessageDialog(null,Constantes.EMAIL_INVALIDO);
				}

			}

		});

		btnCriarConta.setBounds(285, 325, 89, 25);
		contentPane.add(btnCriarConta);


		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(394, 158, 46, 14);
		contentPane.add(lblSenha);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(10, 153, 364, 25);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.addKeyListener(this);
		camposPreenchidos.put(textFieldEmail, false);
		
		JLabel lblUniversidade = new JLabel("Universidade");
		lblUniversidade.setBounds(394, 211, 62, 14);
		contentPane.add(lblUniversidade);


		textFieldSobreNome = new JTextField();
		textFieldSobreNome.addKeyListener(this);
		textFieldSobreNome.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321";
				if (caracteres.contains(e.getKeyChar() + "")) {

					JOptionPane.showMessageDialog(null,
							"Só permitido letras !");
					e.consume();
				}

			}
		});

		textFieldSobreNome.setColumns(10);
		textFieldSobreNome.setBounds(187, 100, 190, 25);
		contentPane.add(textFieldSobreNome);
		camposPreenchidos.put(textFieldSobreNome, false);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(187, 84, 77, 14);
		contentPane.add(lblSobrenome);

		JLabel lblSenha_1 = new JLabel("Senha");
		lblSenha_1.setBounds(10, 184, 46, 14);
		contentPane.add(lblSenha_1);

		JLabel lblRepitaASenha = new JLabel("Repita a senha");
		lblRepitaASenha.setBounds(187, 184, 77, 14);
		contentPane.add(lblRepitaASenha);

		JLabel lblUniversidade_1 = new JLabel("Universidade");
		lblUniversidade_1.setBounds(10, 233, 77, 14);
		contentPane.add(lblUniversidade_1);

		textFieldUniversidade = new JTextField();
		textFieldUniversidade.setColumns(10);
		textFieldUniversidade.setBounds(10, 249, 167, 25);
		contentPane.add(textFieldUniversidade);
		textFieldUniversidade.addKeyListener(this);
		camposPreenchidos.put(textFieldUniversidade, false);
		
		textFieldCurso = new JTextField();
		textFieldCurso.setColumns(10);
		textFieldCurso.setBounds(187, 249, 190, 25);
		contentPane.add(textFieldCurso);
		textFieldCurso.addKeyListener(this);
		camposPreenchidos.put(textFieldCurso, false);

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(187, 233, 77, 14);
		contentPane.add(lblCurso);

		JButton btnVoltas = new JButton("Voltar");
		btnVoltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login login = new Login();
				login.setVisible(true);

				CadastrarUsuario.this.setVisible(false);

			}
		});
		btnVoltas.setBounds(187, 326, 89, 25);
		contentPane.add(btnVoltas);

		try {
			MaskFormatter mf1 = new MaskFormatter(
					"          #####/#####  /#####");
			mf1.setPlaceholderCharacter('_');

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		passwordField_senha = new JPasswordField();
		passwordField_senha.setBounds(10, 206, 167, 25);
		contentPane.add(passwordField_senha);
		passwordField_senha.addKeyListener(this);
		camposPreenchidos.put(passwordField_senha, false);

		passwordField_repSenha = new JPasswordField();
		passwordField_repSenha.setBounds(187, 206, 187, 25);
		contentPane.add(passwordField_repSenha);
		passwordField_repSenha.addKeyListener(this);
		camposPreenchidos.put(passwordField_repSenha,false);
		
	}
	
	private void campoPreenchido(JTextField field) {
		
		
		if (!field.getText().isEmpty()) {
			camposPreenchidos.put(field, true);
		} else {
			camposPreenchidos.put(field, false);
		}
		
		
		boolean resultado = true;
		
		if (camposPreenchidos.size() >= 7) {
			for (JTextField v : camposPreenchidos.keySet()) {
				if (!camposPreenchidos.get(v)) {
					resultado = false;
				}
			}
		} else {
			resultado = false;
		}
		
		if (resultado) {
			btnCriarConta.setEnabled(true);
			btnCriarConta.setToolTipText("");
		} else {
			btnCriarConta.setEnabled(false);
			btnCriarConta.setToolTipText("Preencha todos os campos");
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(textFieldNome)) {
			campoPreenchido(textFieldNome);
		} else if (e.getSource().equals(textFieldSobreNome)) {
			campoPreenchido(textFieldSobreNome);
		} else if (e.getSource().equals(textFieldEmail)) {
			campoPreenchido(textFieldEmail);
		} else if (e.getSource().equals(textFieldUniversidade)) {
			campoPreenchido(textFieldUniversidade);
		} else if (e.getSource().equals(textFieldCurso)) {
			campoPreenchido(textFieldCurso);
		} else if (e.getSource().equals(passwordField_senha)) {
			campoPreenchido(passwordField_senha);
		} else if (e.getSource().equals(passwordField_repSenha)) {
			campoPreenchido(passwordField_repSenha);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
