package com.ufrpe.integrais.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import ac.essex.graphing.plotting.ContinuousFunctionPlotter;
import ac.essex.graphing.plotting.Graph;
import ac.essex.graphing.plotting.PlotSettings;
import ac.essex.graphing.swing.GraphPanel;
import ac.essex.graphing.swing.InteractiveGraphPanel;
import ac.essex.graphing.swing.SettingsUpdateListener;

import com.ufrpe.integrais.dados.entidades.Desafio;
import com.ufrpe.integrais.dados.entidades.DesafioAberto;
import com.ufrpe.integrais.dados.entidades.DesafioMultiplaEscolha;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.negocio.IntegraisFachada;
import com.ufrpe.integrais.util.Funcoes;

public class Desafios extends Painel implements SettingsUpdateListener {
	public Desafios() {
	}

	private static final long serialVersionUID = 1L;
	private JPanel painel;

	@Override
	public void carregarPainel() {
		this.removeAll();
		
		setLayout(null);
		
		this.painel = new JPanel();
		this.painel.setLayout(null);
		
		JLabel lblMural = new JLabel("Seus desafios");
		lblMural.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMural.setBounds(0, 10, 210, 14);
		add(lblMural);
					
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 34, 593, 1);
		add(separator);
		
		if (IntegraisFachada.UsuarioLogado != null) {
			List<Desafio> equacoes = fachada.procurarPorDesafiado(IntegraisFachada.UsuarioLogado.getId());
							
			Collections.sort(equacoes);
			Collections.reverse(equacoes);
			
			for (int i = 0; i < equacoes.size(); i++) {
				campo(equacoes.get(i), i);
			}
			
			this.painel.setBounds(0, 0, 633, 354 * equacoes.size());
			this.painel.setPreferredSize(new Dimension(633, 354 * equacoes.size()));
			
			JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroll.setViewportView(painel);
			scroll.setBounds(0, 46, 614, 495);
			scroll.setSize(614, 495);
			scroll.setBorder(null);
			
			add(scroll);
		}	
	}
	
	public void campo(final Desafio equacao, int indice) {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 354 * indice, 633, 354);
		panelPrincipal.setPreferredSize(new Dimension(633, 354));
		panelPrincipal.setLayout(null);
		
		JLabel lblGuilhermeMeloCompartilhou = new JLabel(Funcoes.formatarDataExtenso(equacao.getDataCriacao()));
		lblGuilhermeMeloCompartilhou.setBounds(0, 0, 583, 14);
		panelPrincipal.add(lblGuilhermeMeloCompartilhou);
		
		/**/
		// Gráfico
		GraphPanel graphPanel = new InteractiveGraphPanel(this);
        
        PlotSettings p = new PlotSettings(-10, 10, -3, 3); 
        p.setPlotColor(Color.RED); 
        p.setGridSpacingX(1); 
        p.setGridSpacingY(1); 
        Graph graph = new Graph(p); 
        
        graph.functions.add(new ContinuousFunctionPlotter(equacao.getMinimo(), equacao.getMaximo()) {
			@Override
			public String getName() {
				return "Integral";
			}
			
			@Override
			public double getY(double x) {
				Expression e = null;
				double resultado = 0;
				
				try {
					e = new ExpressionBuilder(equacao.getEquacao()).variable("x").build().setVariable("x", x);
					resultado = e.evaluate();
				} catch (Exception e1) {
					
				}
				
				return resultado;
			}
		});
         
        graphPanel.setGraph(graph);
        graphPanel.setBounds(0, 25, 593, 150);

        panelPrincipal.add(graphPanel);
		/**/

		JButton btnVer = new JButton("Ver gráfico");
		btnVer.setBounds(0, 177, 100, 23);
		panelPrincipal.add(btnVer);
	
		JLabel mensagem = new JLabel();
		mensagem.setBounds(110, 177, 500, 20);
		mensagem.setText("Qual a integral da função acima, com máximo em: " + equacao.getMaximo() + " e mínimo em: " + equacao.getMinimo() + "?");
		panelPrincipal.add(mensagem);
		
		if (equacao instanceof DesafioAberto) {
			final DesafioAberto desafioAberto = (DesafioAberto) equacao;
		
			JLabel res = new JLabel();
			res.setBounds(0, 200, 500, 20);
			res.setText("Digite sua resposta");
			panelPrincipal.add(res);
			
			final JTextField resposta = new JTextField();
			resposta.setBounds(0, 230, 200, 20);
			panelPrincipal.add(resposta);
			
			JButton btn1 = new JButton("Responder");
			btn1.setBounds(210, 230, 100, 20);
			btn1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (resposta.getText().equals(desafioAberto.getResposta())) {
						desafioAberto.setDataResposta(new Date());
						try {
							fachada.atualizarDesafio(desafioAberto);
							
							JOptionPane.showMessageDialog(null, "Desafio respondido.");
						} catch (ObjetoNaoExistenteExcepition e1) {
							JOptionPane.showMessageDialog(null, "Houve um error ao responder o desafio.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Resposta errada.");
					}
				}
			});
			panelPrincipal.add(btn1);
		} else {
			final DesafioMultiplaEscolha desafioAberto = (DesafioMultiplaEscolha) equacao;
			
			JLabel res = new JLabel();
			res.setBounds(0, 200, 500, 20);
			res.setText("Escolha sua resposta");
			panelPrincipal.add(res);
			
			final ButtonGroup group = new ButtonGroup();
			final JRadioButton[] buttons = new JRadioButton[desafioAberto.getRespostas().size()];
			for (int i = 0; i < desafioAberto.getRespostas().size(); i++) {
				JRadioButton r1 = new JRadioButton(desafioAberto.getRespostas().get(i));
				r1.setBounds(0, 220 + (20 * i), 200, 20);
				
				group.add(r1);
				buttons[i] = r1;
				
				panelPrincipal.add(r1);
			}
			
			JButton btn1 = new JButton("Responder");
			btn1.setBounds(210, 230, 100, 20);
			btn1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					int indice = -1;
					for (int i = 0; i < buttons.length; i++) {
						if (buttons[i].isSelected()) {
							indice = i;
						}
					}
					
					if (indice == -1) {
						JOptionPane.showMessageDialog(null, "Selecione alguma das respostas.");
					} else {
						if (buttons[indice].getText().equals(desafioAberto.getSolucao())) {
							desafioAberto.setDataResposta(new Date());
							try {
								fachada.atualizarDesafio(desafioAberto);
								
								JOptionPane.showMessageDialog(null, "Desafio respondido.");
							} catch (ObjetoNaoExistenteExcepition e1) {
								JOptionPane.showMessageDialog(null, "Houve um error ao responder o desafio.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Resposta errada.");
						}
					}
				}
			});
			panelPrincipal.add(btn1);
		}
		
		painel.add(panelPrincipal);
	}

	@Override
	public void graphUpdated(PlotSettings settings) {
		
	}
}