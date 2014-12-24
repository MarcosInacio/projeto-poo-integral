package com.ufrpe.integrais.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.TrapezoidIntegrator;

import ac.essex.graphing.plotting.ContinuousFunctionPlotter;
import ac.essex.graphing.plotting.Graph;
import ac.essex.graphing.plotting.PlotSettings;
import ac.essex.graphing.swing.GraphPanel;
import ac.essex.graphing.swing.InteractiveGraphPanel;
import ac.essex.graphing.swing.SettingsUpdateListener;

import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.negocio.IIntegraisFachada;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public class EquacoesAdicionar extends JPanel implements MouseListener, ActionListener, SettingsUpdateListener {

	private static final long serialVersionUID = 1L;
	private JTextField textoEquacao;
	private JButton btnApagar, btnCompartilhar;
	
	private JLabel lblError, lblValorDaIntegral;
	
	private Graph graph;
	private GraphPanel graphPanel;
	
	private String Formula = "";
	
	private Map<JButton, String> mapearBotoes = new HashMap<>();
	
    protected double minX, minY, maxX, maxY;
    
    public static int Minimo = 0;
    public static int Maximo = 10;
    
    private IIntegraisFachada integraisFachada;

	public EquacoesAdicionar(IIntegraisFachada fachada) {
		setLayout(null);
		
		this.integraisFachada = fachada;

		JLabel lblMural = new JLabel("Adicionar equa\u00E7\u00E3o");
		lblMural.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMural.setBounds(0, 10, 210, 14);
		add(lblMural);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblError.setHorizontalAlignment(SwingConstants.RIGHT);
		lblError.setBounds(120, 10, 473, 14);
		add(lblError);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 34, 593, 1);
		add(separator);
		
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

		JButton btnVer = new JButton("Ver gráfico");
		btnVer.setBounds(496, 79, 97, 30);
		btnVer.setEnabled(false);
		add(btnVer);
		
		JLabel lblMnimo = new JLabel("M\u00EDnimo");
		lblMnimo.setBounds(496, 112, 38, 14);
		add(lblMnimo);
		
		//
		SpinnerNumberModel model1 = new SpinnerNumberModel(10, 0, 999, 1);  
		final JSpinner spinnerMaximo = new JSpinner(model1);
		//

		SpinnerNumberModel model2 = new SpinnerNumberModel(0, -999, 10, 1);  
		final JSpinner spinnerMinimo = new JSpinner(model2);
		spinnerMinimo.setBounds(496, 130, 97, 20);
		spinnerMinimo.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				Minimo = Integer.parseInt(spinnerMinimo.getValue().toString());

				SpinnerNumberModel model2 = new SpinnerNumberModel(Minimo, -999, Maximo, 1);  
				spinnerMinimo.setModel(model2);
				
				SpinnerNumberModel model = new SpinnerNumberModel(Integer.parseInt(spinnerMaximo.getValue().toString()), Minimo, 999, 1);  
				spinnerMaximo.setModel(model);
				
				graphPanel.setGraph(graph);

				calcularIntegral();
			}
		});
		add(spinnerMinimo);
		
		JLabel lblMximo = new JLabel("M\u00E1ximo");
		lblMximo.setBounds(496, 155, 38, 14);
		add(lblMximo);
		
		spinnerMaximo.setValue(10);
		spinnerMaximo.setBounds(496, 171, 97, 20);
		spinnerMaximo.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Maximo = Integer.parseInt(spinnerMaximo.getValue().toString());

				SpinnerNumberModel model2 = new SpinnerNumberModel(Minimo, -999, Maximo, 1);  
				spinnerMinimo.setModel(model2);
				
				SpinnerNumberModel model = new SpinnerNumberModel(Integer.parseInt(spinnerMaximo.getValue().toString()), Minimo, 999, 1);  
				spinnerMaximo.setModel(model);
				
				graphPanel.setGraph(graph);
				
				calcularIntegral();
			}
		});
		add(spinnerMaximo);
		
		lblValorDaIntegral = new JLabel("Valor da Integral: 0");
		lblValorDaIntegral.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValorDaIntegral.setBounds(0, 225, 500, 20);
		add(lblValorDaIntegral);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(0, 74, 486, 150);
		add(panel);
		panel.setLayout(null);
		
		JButton btnPI = new JButton("\u03C0");
		btnPI.setBounds(10, 11, 49, 23);
		btnPI.addMouseListener(this);
		panel.add(btnPI);
		mapearBotoes.put(btnPI, String.valueOf(Math.PI).substring(0, 4));
		
		JButton btnSen = new JButton("sen");
		btnSen.setBounds(10, 45, 49, 23);
		btnSen.addMouseListener(this);
		panel.add(btnSen);
		mapearBotoes.put(btnSen, "sin(");
		
		JButton btnCos = new JButton("cos");
		btnCos.setBounds(10, 79, 49, 23);
		btnCos.addMouseListener(this);
		panel.add(btnCos);
		mapearBotoes.put(btnCos, "cos(");
		
		JButton btnEuler = new JButton("e");
		btnEuler.setBounds(69, 11, 49, 23);
		btnEuler.addMouseListener(this);
		panel.add(btnEuler);
		mapearBotoes.put(btnEuler, String.valueOf(Math.E).substring(0, 4));
		
		JButton btnXN = new JButton("x\u207F");
		btnXN.setBounds(69, 45, 49, 23);
		btnXN.addMouseListener(this);
		panel.add(btnXN);
		mapearBotoes.put(btnXN, "x^");
		
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
		mapearBotoes.put(btnX3, "x^3");
		
		JButton btnX2 = new JButton("x\u00B2");
		btnX2.setBounds(128, 11, 49, 23);
		btnX2.addMouseListener(this);
		panel.add(btnX2);
		mapearBotoes.put(btnX2, "x^2");
		
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
		mapearBotoes.put(btnTan, "tan(");
		
		JButton btnRaiz = new JButton("\u221A");
		btnRaiz.setBounds(69, 113, 49, 23);
		btnRaiz.addMouseListener(this);
		panel.add(btnRaiz);
		mapearBotoes.put(btnRaiz, "sqrt(");
		
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
				
		btnApagar = new JButton("\u2190 Apagar");
		btnApagar.setBounds(364, 79, 108, 23);
		btnApagar.addMouseListener(this);
		panel.add(btnApagar);
			
		btnCompartilhar = new JButton("Compartilhar");
		btnCompartilhar.setEnabled(false);
		btnCompartilhar.setBounds(305, 113, 167, 23);
		btnCompartilhar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCompartilhar.addMouseListener(this);
		panel.add(btnCompartilhar);
		
		// Gráfico
		graphPanel = new InteractiveGraphPanel(this);
        
        PlotSettings p = new PlotSettings(-10, 10, -5, 5); 
        p.setPlotColor(Color.RED); 
        p.setGridSpacingX(1); 
        p.setGridSpacingY(1); 
        graph = new Graph(p); 
         
        graphPanel.setGraph(graph);
        graphPanel.setBounds(0, 250, 603, 300);

        add(graphPanel);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) { }

	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) { }

	@Override
	public void mousePressed(MouseEvent arg0) { }

	@Override
	public void mouseReleased(MouseEvent event) {
		JButton button = (JButton)event.getSource();
		
		if (button.equals(btnCompartilhar) && button.isEnabled()) {
			Equacao e = new Equacao(Formula, IntegraisFachada.UsuarioLogado.getId(), Minimo, Maximo);
			
			try {
				integraisFachada.cadastrarEquacao(e);
				JOptionPane.showMessageDialog(null, "Equação compartilhada com sucesso");
				
			} catch (ObjetoJaExistenteExcepitions exception) {
				JOptionPane.showMessageDialog(null, "Houve um error ao compartilhar a integral");
			}
		} else {
			if (button.equals(btnApagar)) {
				if (textoEquacao.getText().length() > 7) {
					textoEquacao.setText(textoEquacao.getText().substring(0, textoEquacao.getText().length() - 1));
				}
			} else if (mapearBotoes.containsKey(button)) {
				textoEquacao.setText(textoEquacao.getText() + mapearBotoes.get(button));
			} else {
				textoEquacao.setText(textoEquacao.getText() + button.getText());
			}
					
			Formula = textoEquacao.getText().substring(7);
			
			if (Formula.length() == 0) {
				btnCompartilhar.setEnabled(false);
				lblError.setText("Expressão inválida");
			} else {
				btnCompartilhar.setEnabled(true);
				lblError.setText("");
			}
			
			System.out.println(Formula);
			
			calcularIntegral();
			
			// Desenhar gráfico
			graph.functions.add(new ContinuousFunctionPlotter() {
				
				@Override
				public String getName() {
					return "Integral";
				}
				
				@Override
				public double getY(double x) {
					Expression e = null;
					double resultado = 0;
					
					try {
						e = new ExpressionBuilder(Formula).variable("x").build().setVariable("x", x);
						resultado = e.evaluate();
					} catch (Exception e1) {
						btnCompartilhar.setEnabled(false);
						lblError.setText("Expressão inválida.");
					}
					
					return resultado;
				}
			});
			
	        graphPanel.setGraph(graph);
		}
	}

	@Override
    public void graphUpdated(PlotSettings settings) {
        minX = settings.getMinX();
        minY = settings.getMinY();
        maxX = settings.getMaxX();
        maxY = settings.getMaxY();
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	private void calcularIntegral() {
		try {
			UnivariateFunction uf = new UnivariateFunction() {
				@Override
				public double value(double x) {
					return new ExpressionBuilder(Formula).variable("x").build().setVariable("x", x).evaluate();
				}
			};
			
			TrapezoidIntegrator trapezoid = new TrapezoidIntegrator();
			
			lblValorDaIntegral.setText("Valor da integral: " + (trapezoid.integrate(1000 * Math.abs(Maximo), uf, Minimo, Maximo)));
		} catch (Exception e2) {
			lblValorDaIntegral.setText("Valor da integral: Não foi possível calcular");
		}
	}
}
