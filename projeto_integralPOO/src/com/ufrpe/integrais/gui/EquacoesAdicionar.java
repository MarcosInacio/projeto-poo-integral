package com.ufrpe.integrais.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class EquacoesAdicionar extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textoEquacao;
	private JButton btnApagar;

	/**
	 * Create the panel.
	 */
	public EquacoesAdicionar() {
		setLayout(null);
		
		JLabel lblMural = new JLabel("Adicionar equa\u00E7\u00E3o");
		lblMural.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMural.setBounds(0, 10, 210, 14);
		add(lblMural);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 34, 593, 1);
		add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 235, 593, 200);
		add(panel_1);
		panel_1.setLayout(null);
		
		textoEquacao = new JTextField();
		textoEquacao.setText("f(x) = ");
		textoEquacao.setEditable(false);
		textoEquacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoEquacao.setBounds(0, 46, 486, 30);
		add(textoEquacao);
		textoEquacao.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(496, 46, 97, 30);
		add(btnLimpar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(0, 74, 486, 150);
		add(panel);
		panel.setLayout(null);
		
		JButton btnPI = new JButton("\u03C0");
		btnPI.setBounds(10, 11, 49, 23);
		btnPI.addMouseListener(this);
		panel.add(btnPI);
		
		JButton btnSen = new JButton("sen");
		btnSen.setBounds(10, 45, 49, 23);
		btnSen.addMouseListener(this);
		panel.add(btnSen);
		
		JButton btnCos = new JButton("cos");
		btnCos.setBounds(10, 79, 49, 23);
		btnCos.addMouseListener(this);
		panel.add(btnCos);
		
		JButton btnEuler = new JButton("e");
		btnEuler.setBounds(69, 11, 49, 23);
		btnEuler.addMouseListener(this);
		panel.add(btnEuler);
		
		JButton btnXN = new JButton("x\u207F");
		btnXN.setBounds(69, 45, 49, 23);
		btnXN.addMouseListener(this);
		panel.add(btnXN);
		
		JButton btnX = new JButton("x");
		btnX.setBounds(69, 79, 49, 23);
		btnX.addMouseListener(this);
		panel.add(btnX);
		
		JButton btnParAbr = new JButton("(");
		btnParAbr.setBounds(128, 79, 49, 23);
		btnParAbr.addMouseListener(this);
		panel.add(btnParAbr);
		
		JButton btnX3 = new JButton("x\u00B3");
		btnX3.setBounds(128, 45, 49, 23);
		btnX3.addMouseListener(this);
		panel.add(btnX3);
		
		JButton btnX2 = new JButton("x\u00B2");
		btnX2.setBounds(128, 11, 49, 23);
		btnX2.addMouseListener(this);
		panel.add(btnX2);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(187, 11, 49, 23);
		btn7.addMouseListener(this);
		panel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(246, 11, 49, 23);
		btn8.addMouseListener(this);
		panel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(305, 11, 49, 23);
		btn9.addMouseListener(this);
		panel.add(btn9);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(305, 45, 49, 23);
		btn6.addMouseListener(this);
		panel.add(btn6);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(246, 45, 49, 23);
		btn5.addMouseListener(this);
		panel.add(btn5);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(187, 45, 49, 23);
		btn4.addMouseListener(this);
		panel.add(btn4);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(187, 79, 49, 23);
		btn1.addMouseListener(this);
		panel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(246, 79, 49, 23);
		btn2.addMouseListener(this);
		panel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(305, 79, 49, 23);
		btn3.addMouseListener(this);
		panel.add(btn3);
		
		JButton btnTan = new JButton("tan");
		btnTan.setBounds(10, 113, 49, 23);
		btnTan.addMouseListener(this);
		panel.add(btnTan);
		
		JButton btnRaiz = new JButton("\u221A");
		btnRaiz.setBounds(69, 113, 49, 23);
		btnRaiz.addMouseListener(this);
		panel.add(btnRaiz);
		
		JButton btnParFec = new JButton(")");
		btnParFec.setBounds(128, 113, 49, 23);
		btnParFec.addMouseListener(this);
		panel.add(btnParFec);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(187, 113, 49, 23);
		btn0.addMouseListener(this);
		panel.add(btn0);
		
		JButton btnPonto = new JButton(".");
		btnPonto.setBounds(246, 113, 49, 23);
		btnPonto.addMouseListener(this);
		panel.add(btnPonto);
		
		JButton btnMais = new JButton("+");
		btnMais.setBounds(423, 45, 49, 23);
		btnMais.addMouseListener(this);
		panel.add(btnMais);
		
		JButton btnMenos = new JButton("-");
		btnMenos.setBounds(364, 45, 49, 23);
		btnMenos.addMouseListener(this);
		panel.add(btnMenos);
		
		JButton btnDivisao = new JButton("/");
		btnDivisao.setBounds(364, 11, 49, 23);
		btnDivisao.addMouseListener(this);
		panel.add(btnDivisao);
		
		JButton btnMultiplicacao = new JButton("*");
		btnMultiplicacao.setBounds(423, 11, 49, 23);
		btnMultiplicacao.addMouseListener(this);
		panel.add(btnMultiplicacao);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(305, 113, 167, 23);
		btnContinuar.addMouseListener(this);
		panel.add(btnContinuar);
		
		btnApagar = new JButton("\u2190 Apagar");
		btnApagar.setBounds(364, 79, 108, 23);
		btnApagar.addMouseListener(this);
		panel.add(btnApagar);
		
		JLabel lblMnimo = new JLabel("M\u00EDnimo");
		lblMnimo.setBounds(0, 454, 38, 14);
		add(lblMnimo);
		
		JLabel lblMximo = new JLabel("M\u00E1ximo");
		lblMximo.setBounds(0, 482, 38, 14);
		add(lblMximo);
		
		JLabel lblValorDaIntegral = new JLabel("Valor da Integral: 20,57");
		lblValorDaIntegral.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValorDaIntegral.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorDaIntegral.setBounds(433, 450, 160, 20);
		add(lblValorDaIntegral);
		
		JButton btnCompartilhar = new JButton("Compartilhar");
		btnCompartilhar.setBounds(433, 478, 160, 23);
		add(btnCompartilhar);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(48, 451, 97, 20);
		add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(48, 479, 97, 20);
		add(spinner_1);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if (event.getSource().equals(btnApagar)) {
			if (textoEquacao.getText().length() > 7) {
				textoEquacao.setText(textoEquacao.getText().substring(0, textoEquacao.getText().length() - 1));
			}
		} else {
			textoEquacao.setText(textoEquacao.getText() + ((JButton)event.getSource()).getText());
		}
	}
}
