package com.ufrpe.integrais.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

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
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.negocio.IntegraisFachada;
import com.ufrpe.integrais.util.Funcoes;

public abstract class Equacoes extends Painel implements SettingsUpdateListener {
	public Equacoes() {
	}

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	protected static List<Equacao>equacoes;
	protected String nomeDaTela; 
	protected boolean LigarBotao;

	
	public void carregarTela() {
	
		
			this.removeAll();
			
			setLayout(null);
			
			this.painel = new JPanel();
			this.painel.setLayout(null);
			
			JLabel lblMural = new JLabel(nomeDaTela);
			lblMural.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblMural.setBounds(0, 10, 210, 14);
			add(lblMural);
			
			if(LigarBotao == true){
				
			JButton btnAdicionar = new JButton("Adicionar");
			btnAdicionar.setBounds(504, 6, 89, 23);
			btnAdicionar.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent event) {
					Principal.cardLayout.show(Principal.panelContent, "EQUACOESADICIONAR");
				}
			});
			add(btnAdicionar);
			
			}
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 34, 593, 1);
			add(separator);
			
			if (IntegraisFachada.UsuarioLogado != null) {
				
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
	
	
	public void campo(final Equacao equacao, int indice) {
		
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 354 * indice, 633, 351);
		panelPrincipal.setPreferredSize(new Dimension(633, 354));
		panelPrincipal.setLayout(null);
		
		
		if(equacao.getUsuario().getFoto()!= null){
			
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 52 ,45);
		Image image = equacao.getUsuario().getFoto().getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		panelPrincipal.add(lblNewLabel);
		}
		
		
		JLabel lblNomeUsuario = new JLabel(equacao.getUsuario().getNome());
		lblNomeUsuario.setBounds(55,1, 400, 14);
		lblNomeUsuario.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
		panelPrincipal.add(lblNomeUsuario);
		
		JLabel lblGuilhermeMeloCompartilhou = new JLabel(Funcoes.formatarDataExtenso(equacao.getDataCriacao()));
		lblGuilhermeMeloCompartilhou.setBounds(55,17
				, 583, 14);
		panelPrincipal.add(lblGuilhermeMeloCompartilhou);
		
		/**/
		// Gráfico
		final GraphPanel graphPanel = new InteractiveGraphPanel(this);
        
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
        graphPanel.setBounds(0, 40, 593, 150);

        panelPrincipal.add(graphPanel);
		/**/

		JButton btnVer = new JButton("Ver gráfico");
		btnVer.setBounds(0, 200, 100, 23);
		
		btnVer.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mousePressed(MouseEvent event) {
				
				JFrame frame = new JFrame();
				frame.setSize(1000,500);
				frame.setContentPane(graphPanel);
		        frame.setVisible(true);
		        frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);

			}
			
		});
		panelPrincipal.add(btnVer);
		
		
		final JLabel lblCurtidas = new JLabel(this.fachada.equacaoCurtidas(equacao.getId()) + " curtidas");
		lblCurtidas.setBounds(186, 200, 124, 14);
		panelPrincipal.add(lblCurtidas);

		JButton btnCurtir = new JButton("Curtir");
		btnCurtir.setBounds(110, 200, 66, 23);
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
		lblComentrio.setBounds(383, 190, 210, 14);
		panelPrincipal.add(lblComentrio);
		
		final JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(0, 230, 310, 40);
		panelPrincipal.add(textArea);
		
		final JPanel painelComentarios = new JPanel();
		painelComentarios.setLayout(null);
		painelComentarios.setBounds(0, 0, 260, 60 * fachada.equacaoComentarios(equacao.getId()));
		painelComentarios.setPreferredSize(new Dimension(260, 60 * fachada.equacaoComentarios(equacao.getId())));
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(221, 280, 89, 23);
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
						
						carregarComentarios(painelComentarios, fachada.procurarEquacaoComentarios(equacao.getId()));
						
						textArea.setText("");
					} catch (ObjetoJaExistenteExcepitions e) {
						JOptionPane.showMessageDialog(null, "Digite seu comentário");
					}				
				}
			}
		});
		panelPrincipal.add(btnEnviar);
				
		try {
			carregarComentarios(painelComentarios, fachada.procurarEquacaoComentarios(equacao.getId()));
		} catch (ObjetoJaExistenteExcepitions e) {

		}
		
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
	
	private void carregarComentarios(JPanel painelComentarios, List<EquacaoComentario> comentarios) {
		for (int i = 0; i < comentarios.size(); i++) {
			JLabel panel_2 = new JLabel();
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_2.setBounds(0, (60 * i), 50, 50);

			try {
				if (fachada.procurarUsuario(comentarios.get(i).getIdUsuario()).getFoto() != null) {
					Image img = fachada.procurarUsuario(comentarios.get(i).getIdUsuario()).getFoto().getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); 
					panel_2.setIcon(new ImageIcon(img));
				}
	
				painelComentarios.add(panel_2);
			
				JLabel lblLeandroOntems = new JLabel(fachada.procurarUsuario(comentarios.get(i).getIdUsuario()).getNome() + ", " + Funcoes.tempoPassado(comentarios.get(i).getDataCriacao()));
				lblLeandroOntems.setBounds(56,  (60 * i), 200, 14);
				painelComentarios.add(lblLeandroOntems);
			} catch (ObjetoNaoExistenteExcepition e) {

			}
			
			JLabel lblAlgumComentrioo = new JLabel(comentarios.get(i).getComentario());
			lblAlgumComentrioo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblAlgumComentrioo.setVerticalAlignment(SwingConstants.TOP);
			lblAlgumComentrioo.setHorizontalAlignment(SwingConstants.LEFT);
			lblAlgumComentrioo.setBounds(56, 15 + (60 * i), 254, 30);
			painelComentarios.add(lblAlgumComentrioo);			
		}
	}
}
