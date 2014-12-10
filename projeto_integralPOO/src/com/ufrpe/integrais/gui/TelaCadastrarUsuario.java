package com.ufrpe.integrais.gui;

import java.awt.Font;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.util.Constantes;
import com.ufrpe.integrais.util.Funcoes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCadastrarUsuario extends Tela {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JPasswordField passwordField_1;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JTextField textFieldSobreNome;
	private JTextField textFieldUniversidade;
	private JTextField textFieldCurso;
	private JFormattedTextField textdataNascimento;
	private JPasswordField passwordField_senha;
	private JPasswordField passwordField_repSenha;

	/**
	 * Create the frame.
	 * 
	 * 
	 */
	
	
	
	public TelaCadastrarUsuario() {
		setTitle("Integrais - Cadastrar Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(Funcoes.centroDaTela(Constantes.CADASTRO_WIDTH, Constantes.CADASTRO_HEIGHT));

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
				
				String caracteres="0987654321";
				
				if(caracteres.contains(event.getKeyChar()+"")){
				
				JOptionPane.showMessageDialog(null,"Só permitido letras !!");	
				event.consume();
				}
				
			}
		});
		
		
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(10, 100, 167, 25);
		contentPane.add(textFieldNome);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(11, 134, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCadastrarUsurio = new JLabel("Cadastrar Usu\u00E1rio");
		lblCadastrarUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarUsurio.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCadastrarUsurio.setBounds(10, 11, 374, 58);
		contentPane.add(lblCadastrarUsurio);
		
		JButton btnCriarConta = new JButton("Criar conta");
		btnCriarConta.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(! textFieldNome.getText().isEmpty() && ! textFieldSobreNome.getText().isEmpty() ){
					
					if( ! textFieldEmail.getText().isEmpty()){
						
						if(! passwordField_senha.getPassword().toString().isEmpty()){
							
							if(! passwordField_repSenha.getPassword().toString().isEmpty()  ){
								
								if(! textFieldUniversidade.getText().isEmpty()) {
									
									if(! textFieldCurso.getText().isEmpty()){
										
										if(! textdataNascimento.getText().isEmpty() ){
											
											
								            if(Funcoes.validarEmail(textFieldEmail.getText())){
								            	
								            	
								            	try {
													
													 Calendar c = Calendar.getInstance();
													 Date data = c.getTime();
													 
													 Usuario u = new Usuario(11111,data ,textFieldNome.getText(),textFieldEmail.getText(), passwordField_senha.getPassword().toString(),
																textFieldUniversidade.getText(),textFieldCurso.getText(), textdataNascimento.getText());
													 
													 fachada.cadastrarUsuario(u); 
													 
								            	}catch(ObjetoJaExistenteExcepitions e1 ){
								            		
								            		
								            		JOptionPane.showMessageDialog(TelaCadastrarUsuario.this, Constantes.USUARIO_JA_EXISTE);
								            	}
								            	
								           	
								            	
								            }else{
								            	
								            	JOptionPane.showMessageDialog(TelaCadastrarUsuario.this, Constantes.EMAIL_INVALIDO);
								            }	
											
											
											
										}else{
											JOptionPane.showMessageDialog(null,Constantes.DATANASCIMENTO_OBRIGATORIO);
										}
				
										
									}else{
										JOptionPane.showConfirmDialog(null, Constantes.CURSO_OBRIGATORIO);
									}
									
								}else{
									JOptionPane.showMessageDialog(null, Constantes.UNIVERSIDADE_OBRIGATORIO);
								}
								
							}else{
								
								JOptionPane.showMessageDialog(null, Constantes.REPETIRSENHA_OBRIGATORIO);
							}
							
						}else{
							
							JOptionPane.showMessageDialog(null, Constantes.SENHA_OBRIGATORIO);
						}
						
						
					}else{
						
						
						JOptionPane.showMessageDialog(null,Constantes.EMAIL_OBRIGATORIO);
					}
					
					
				}else{
					
					JOptionPane.showMessageDialog(null,Constantes.NOME_OBRIGATORIO);
				}
				
			}
			
			
			
			
		});
		
		
		
		
		btnCriarConta.setBounds(285, 325, 89, 25);
		contentPane.add(btnCriarConta);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(394, 183, 190, 25);
		contentPane.add(passwordField_1);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(394, 158, 46, 14);
		contentPane.add(lblSenha);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(10, 153, 364, 25);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblUniversidade = new JLabel("Universidade");
		lblUniversidade.setBounds(394, 211, 62, 14);
		contentPane.add(lblUniversidade);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(394, 233, 190, 25);
		contentPane.add(passwordField);
		
		textFieldSobreNome = new JTextField();
		textFieldSobreNome.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyTyped(KeyEvent e) {
				
				String caracteres="0987654321";
				if(caracteres.contains(e.getKeyChar()+"")){
					
				JOptionPane.showMessageDialog(null, "Só permitido letras !!");	
				e.consume();
				}
				
			}
		});
		
		
		
		textFieldSobreNome.setColumns(10);
		textFieldSobreNome.setBounds(187, 100, 190, 25);
		contentPane.add(textFieldSobreNome);
		
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
		
		textFieldCurso = new JTextField();
		textFieldCurso.setColumns(10);
		textFieldCurso.setBounds(187, 249, 190, 25);
		contentPane.add(textFieldCurso);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(187, 233, 77, 14);
		contentPane.add(lblCurso);
		
		JButton btnVoltas = new JButton("Voltar");
		btnVoltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Login login = new Login();
				login.setVisible(true);
				
				TelaCadastrarUsuario.this.setVisible(false);
				
				
			}
		});
		btnVoltas.setBounds(187, 326, 89, 25);
		contentPane.add(btnVoltas);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 285, 138, 14);
		contentPane.add(lblDataDeNascimento);

		try {
			MaskFormatter mf1 = new MaskFormatter("          #####/#####  /#####");
		    mf1.setPlaceholderCharacter('_');
			
			textdataNascimento = new JFormattedTextField(mf1);
			textdataNascimento.setBounds(10, 301, 167, 25);
			
			contentPane.add(textdataNascimento);
			
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		passwordField_senha = new JPasswordField();
		passwordField_senha.setBounds(10, 206, 167, 25);
		contentPane.add(passwordField_senha);
		
		passwordField_repSenha = new JPasswordField();
		passwordField_repSenha.setBounds(187, 206, 187, 25);
		contentPane.add(passwordField_repSenha);
	}
}
