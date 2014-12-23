package com.ufrpe.integrais.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import ac.essex.graphing.plotting.ContinuousFunctionPlotter;
import ac.essex.graphing.plotting.Graph;
import ac.essex.graphing.plotting.PlotSettings;
import ac.essex.graphing.swing.GraphPanel;
import ac.essex.graphing.swing.InteractiveGraphPanel;
import ac.essex.graphing.swing.SettingsUpdateListener;

import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.EquacaoComentario;
import com.ufrpe.integrais.dados.entidades.EquacaoCurtir;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public class Equacoes extends Painel implements SettingsUpdateListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;

	@Override
	public void carregarPainel() {
		try {
			this.removeAll();
			
			setLayout(null);
			
			this.painel = new JPanel();
			this.painel.setLayout(null);
			
			JLabel lblMural = new JLabel("Suas equa\u00E7\u00F5es");
			lblMural.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblMural.setBounds(0, 10, 210, 14);
			add(lblMural);
			
			JButton btnAdicionar = new JButton("Adicionar");
			btnAdicionar.setBounds(504, 6, 89, 23);
			add(btnAdicionar);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 34, 593, 1);
			add(separator);
			
			if (IntegraisFachada.UsuarioLogado != null) {
				List<Equacao> equacoes = fachada.procurarEquacoes(IntegraisFachada.UsuarioLogado.getId());
								
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
		} catch (ObjetoJaExistenteExcepitions e) {
			
		}	
	}
	
	public void campo(final Equacao equacao, int indice) {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 354 * indice, 633, 354);
		panelPrincipal.setPreferredSize(new Dimension(633, 354));
		panelPrincipal.setLayout(null);
		
		DateFormat dfmt = new SimpleDateFormat("EEEE, d MMMM yyyy 'às' H:m:s");  
		
		JLabel lblGuilhermeMeloCompartilhou = new JLabel(dfmt.format(equacao.getDataCriacao()));
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
					e = new ExpressionBuilder(equacao.getFormula()).variable("x").build().setVariable("x", x);
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
		
		final JLabel lblCurtidas = new JLabel(this.fachada.equacaoCurtidas(equacao.getId()) + " curtidas");
		lblCurtidas.setBounds(186, 181, 124, 14);
		panelPrincipal.add(lblCurtidas);

		JButton btnCurtir = new JButton("Curtir");
		btnCurtir.setBounds(110, 177, 66, 23);
		btnCurtir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				EquacaoCurtir equacaoCurtir = new EquacaoCurtir();
				equacaoCurtir.setIdEquacao(equacao.getId());
				equacaoCurtir.setIdUsuario(IntegraisFachada.UsuarioLogado.getId());
				
				try {
					fachada.cadastrarEquacaoCurtida(equacaoCurtir);
					
					lblCurtidas.setText(fachada.equacaoCurtidas(equacao.getId()) + " curtidas");
				} catch (ObjetoJaExistenteExcepitions e) {
					
				}
			}
		});
		panelPrincipal.add(btnCurtir);
		
		final JLabel lblComentrio = new JLabel(this.fachada.equacaoComentarios(equacao.getId()) + " coment\u00E1rio");
		lblComentrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComentrio.setBounds(383, 181, 210, 14);
		panelPrincipal.add(lblComentrio);
		
		final JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(0, 206, 310, 40);
		panelPrincipal.add(textArea);
		
		final JPanel painelComentarios = new JPanel();
		painelComentarios.setLayout(null);
		painelComentarios.setBounds(0, 0, 260, 60 * 3);
		painelComentarios.setPreferredSize(new Dimension(260, 60 * 3));
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(221, 257, 89, 23);
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				if (textArea.getText().toString().length() > 0) {
					EquacaoComentario equacaoComentario = new EquacaoComentario();
					equacaoComentario.setIdEquacao(equacao.getId());
					equacaoComentario.setIdUsuario(IntegraisFachada.UsuarioLogado.getId());
					equacaoComentario.setComentario(textArea.getText().toString());
					
					try {
						fachada.cadastrarEquacaoComentario(equacaoComentario);
						
						lblComentrio.setText(fachada.equacaoComentarios(equacao.getId()) + " coment\u00E1rio");
						
						carregarComentarios(painelComentarios, 5);
						
						textArea.setText("");
					} catch (ObjetoJaExistenteExcepitions e) {
						JOptionPane.showMessageDialog(null, "Digite seu comentário");
					}				
				}
			}
		});
		panelPrincipal.add(btnEnviar);
				
		carregarComentarios(painelComentarios, 3);
		
		JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setViewportView(painelComentarios);
		scroll.setBounds(320, 206, 260, 120);
		scroll.setSize(260, 120);
		scroll.setBorder(null);
		
		panelPrincipal.add(scroll);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 344, 593, 1);
		panelPrincipal.add(separator_1);
		
		painel.add(panelPrincipal);
	}

	@Override
	public void graphUpdated(PlotSettings settings) {
		
	}
	
	private void carregarComentarios(JPanel painelComentarios, int j) {
		for (int i = 0; i < j; i++) {
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_2.setBounds(0, (60 * i), 50, 50);
			painelComentarios.add(panel_2);
			
			JLabel lblLeandroOntems = new JLabel("Leandro, ontem \u00E0s 15:30");
			lblLeandroOntems.setBounds(56,  (60 * i), 200, 14);
			painelComentarios.add(lblLeandroOntems);
			
			JLabel lblAlgumComentrioo = new JLabel("Algum coment\u00E1rio \\o/");
			lblAlgumComentrioo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblAlgumComentrioo.setVerticalAlignment(SwingConstants.TOP);
			lblAlgumComentrioo.setHorizontalAlignment(SwingConstants.LEFT);
			lblAlgumComentrioo.setBounds(56, 15 + (60 * i), 254, 30);
			painelComentarios.add(lblAlgumComentrioo);			
		}
	}
}
