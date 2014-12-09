package com.ufrpe.integrais.gui;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.ufrpe.integrais.util.Constantes;
import com.ufrpe.integrais.util.Funcoes;

public class CadastrarUsuario extends Tela {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the frame.
	 */
	public CadastrarUsuario() {
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 100, 167, 25);
		contentPane.add(textField);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(11, 134, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCadastrarUsurio = new JLabel("Cadastrar Usu\u00E1rio");
		lblCadastrarUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarUsurio.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCadastrarUsurio.setBounds(10, 11, 374, 58);
		contentPane.add(lblCadastrarUsurio);
		
		JButton btnCriarConta = new JButton("Criar conta");
		btnCriarConta.setBounds(285, 325, 89, 25);
		contentPane.add(btnCriarConta);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(394, 183, 190, 25);
		contentPane.add(passwordField_1);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(394, 158, 46, 14);
		contentPane.add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 153, 364, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUniversidade = new JLabel("Universidade");
		lblUniversidade.setBounds(394, 211, 62, 14);
		contentPane.add(lblUniversidade);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(394, 233, 190, 25);
		contentPane.add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(187, 100, 190, 25);
		contentPane.add(textField_2);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(187, 84, 77, 14);
		contentPane.add(lblSobrenome);
		
		JLabel lblSenha_1 = new JLabel("Senha");
		lblSenha_1.setBounds(10, 184, 46, 14);
		contentPane.add(lblSenha_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 200, 167, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(187, 200, 190, 25);
		contentPane.add(textField_4);
		
		JLabel lblRepitaASenha = new JLabel("Repita a senha");
		lblRepitaASenha.setBounds(187, 184, 77, 14);
		contentPane.add(lblRepitaASenha);
		
		JLabel lblUniversidade_1 = new JLabel("Universidade");
		lblUniversidade_1.setBounds(10, 233, 77, 14);
		contentPane.add(lblUniversidade_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 249, 167, 25);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(187, 249, 190, 25);
		contentPane.add(textField_6);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(187, 233, 77, 14);
		contentPane.add(lblCurso);
		
		JButton btnVoltas = new JButton("Voltar");
		btnVoltas.setBounds(187, 326, 89, 25);
		contentPane.add(btnVoltas);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 285, 138, 14);
		contentPane.add(lblDataDeNascimento);

		try {
			MaskFormatter mf1 = new MaskFormatter("###-###-###");
		    mf1.setPlaceholderCharacter('_');
			
			JFormattedTextField dataNascimento = new JFormattedTextField(mf1);
			dataNascimento.setBounds(10, 301, 167, 25);
			
			contentPane.add(dataNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
