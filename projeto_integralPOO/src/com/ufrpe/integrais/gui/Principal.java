package com.ufrpe.integrais.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public class Principal extends Tela {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	public static JPanel panelContent;
	
	// Menu
	private JMenuItem mntmInicio;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmSair;
	private JMenuItem mntmMeuPerfil;
	private JMenuItem mntmMinhasEquaes;
	private JMenuItem mntmEditarPerfil;
	private JMenuItem mntmMeusAmigos;
	private JMenuItem mntmProcurarAmigos;
	private JMenuItem mntmAdicionarEquao;
	private JMenuItem mntmMinhasEquaes_1;
	private JMenuItem mntmEquaesDosMeus;
	private JMenuItem mntmMaisAcessadas;
	private JMenuItem mntmMaisCurtidas;
	private JMenuItem mntmSobre;
	private JLabel lblNewLabel_1;
	
	public  static CardLayout cardLayout;

	private Map<String, Integer> mapearTelas = new HashMap<>(); 

	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		menuBar.add(mnArquivo);
		
		mntmInicio = new JMenuItem("Inicio", new ImageIcon("imagens/house.png"));
		mntmInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("INICIO");
			}
		});
		mntmInicio.setEnabled(false);
		mnArquivo.add(mntmInicio);
		
		mntmSalvar = new JMenuItem("Salvar", new ImageIcon("imagens/disk.png"));
		mntmSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Salvo com sucesso");
			}
		});
		mnArquivo.add(mntmSalvar);
		
		JSeparator separator_1 = new JSeparator();
		mnArquivo.add(separator_1);
		
		mntmSair = new JMenuItem("Sair", new ImageIcon("imagens/cross.png"));
		mntmSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.exit(0);
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnPerfil = new JMenu("Perfil");
		mnPerfil.setMnemonic('P');
		menuBar.add(mnPerfil);
		
		mntmMeuPerfil = new JMenuItem("Meu perfil", new ImageIcon("imagens/status_online.png"));
		mntmMeuPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("PERFIL");
			}
		});
		mnPerfil.add(mntmMeuPerfil);
		
		mntmMinhasEquaes = new JMenuItem("Minhas equa\u00E7\u00F5es", new ImageIcon("imagens/sum.png"));
		mntmMinhasEquaes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("EQUACOES");
			}
		});
		mnPerfil.add(mntmMinhasEquaes);
		
		mntmEditarPerfil = new JMenuItem("Editar perfil", new ImageIcon("imagens/status_offline.png"));
		mntmEditarPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("PERFILEDITAR");
			}
		});
		mnPerfil.add(mntmEditarPerfil);
		
		JMenu mnAmigos = new JMenu("Amigos");
		mnAmigos.setMnemonic('m');
		menuBar.add(mnAmigos);
		
		mntmMeusAmigos = new JMenuItem("Meus amigos", new ImageIcon("imagens/group_2.png"));
		mntmMeusAmigos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("AMIGOS");
			}
		});
		mnAmigos.add(mntmMeusAmigos);
		
		mntmProcurarAmigos = new JMenuItem("Procurar amigos", new ImageIcon("imagens/group_gear_2.png"));
		mntmProcurarAmigos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("AMIGOSPROCURAR");
			}
		});
		mnAmigos.add(mntmProcurarAmigos);
		
		JMenu mnEquaes = new JMenu("Equa\u00E7\u00F5es");
		menuBar.add(mnEquaes);
		
		mntmAdicionarEquao = new JMenuItem("Adicionar equa\u00E7\u00E3o", new ImageIcon("imagens/sum.png"));
		mntmAdicionarEquao.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("EQUACOESADICIONAR");
			}
		});
		mnEquaes.add(mntmAdicionarEquao);
		
		JSeparator separator_3 = new JSeparator();
		mnEquaes.add(separator_3);
		
		mntmMinhasEquaes_1 = new JMenuItem("Minhas equa\u00E7\u00F5es", new ImageIcon("imagens/sum.png"));
		mntmMinhasEquaes_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("EQUACOES");
			}
		});
		mnEquaes.add(mntmMinhasEquaes_1);
		
		mntmEquaesDosMeus = new JMenuItem("Equa\u00E7\u00F5es dos meus amigos", new ImageIcon("imagens/sum.png"));
		mntmEquaesDosMeus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("INICIO");
			}
		});
		mnEquaes.add(mntmEquaesDosMeus);
		
		JSeparator separator_2 = new JSeparator();
		mnEquaes.add(separator_2);
		
		mntmMaisAcessadas = new JMenuItem("Mais acessadas", new ImageIcon("imagens/sum.png"));
		mntmMaisAcessadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("INICIO");
			}
		});
		mnEquaes.add(mntmMaisAcessadas);
		
		mntmMaisCurtidas = new JMenuItem("Mais curtidas", new ImageIcon("imagens/sum.png"));
		mntmMaisCurtidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("INICIO");
			}
		});
		mnEquaes.add(mntmMaisCurtidas);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setMnemonic('j');
		menuBar.add(mnAjuda);
		
		mntmSobre = new JMenuItem("Sobre", new ImageIcon("imagens/information.png"));
		mntmSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Sobre s = new Sobre();
				s.setVisible(true);
			}
		});
		mnAjuda.add(mntmSobre);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		panelContent = new JPanel();
		panelContent.setBounds(181, 10, 614, 541);
		panelContent.setLayout(new CardLayout(0, 0));
		
		mapearTelas.put("INICIO", 0);
		mapearTelas.put("PERFIL", 1);
		mapearTelas.put("PERFILEDITAR", 2);
		mapearTelas.put("AMIGOS", 3);
		mapearTelas.put("AMIGOSPROCURAR", 4);
		mapearTelas.put("EQUACOES", 5);
		mapearTelas.put("EQUACOESADICIONAR", 6);

		panelContent.add(new Inicio(), "INICIO", 0);
		panelContent.add(new Perfil(), "PERFIL", 1);
		panelContent.add(new AtualizarCadastro(), "PERFILEDITAR", 2);
		panelContent.add(new Amigos(), "AMIGOS", 3);
		panelContent.add(new AmigosProcurar(), "AMIGOSPROCURAR", 4);
		panelContent.add(new Equacoes(), "EQUACOES", 5);
		panelContent.add(new EquacoesAdicionar(Tela.fachada), "EQUACOESADICIONAR", 6);
		
		cardLayout = (CardLayout)panelContent.getLayout();
		
		contentPane.add(panelContent);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 150, 180);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		
		if (IntegraisFachada.UsuarioLogado != null) {
			
			Image img = IntegraisFachada.UsuarioLogado.getFoto().getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
			lblNewLabel_1.setIcon(new ImageIcon(img));
			lblNewLabel_1.setIcon(new ImageIcon(img));
		}
				
		lblNewLabel_1.setBounds(0, 0, 150, 154);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Mudar foto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String local="";
				
				javax.swing.JFileChooser jfc = new javax.swing.JFileChooser();  
				jfc.setMultiSelectionEnabled(false);  
				jfc.setDialogTitle("Selecione sua foto");  
				jfc.setFileFilter(new FileNameExtensionFilter("JPG, GIF e PNG", "jpg", "gif", "png","bmp"));
				jfc.showOpenDialog(null);
								
				local = jfc.getSelectedFile().getAbsolutePath();
				Image img = new ImageIcon(local).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
				lblNewLabel_1.setIcon(new ImageIcon(img));
				
				IntegraisFachada.UsuarioLogado.setFoto(new ImageIcon(local));
				
				try {
					fachada.atualizarUsuario(IntegraisFachada.UsuarioLogado);
				} catch (ObjetoNaoExistenteExcepition e) {
					
				}
			}
		});
		btnNewButton.setBounds(0, 152, 150, 28);
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(170, 10, 1, 520);
		contentPane.add(separator);
		
		if(IntegraisFachada.UsuarioLogado!= null){
		
		JLabel lblPauloMenezes = new JLabel(IntegraisFachada.UsuarioLogado.getNome());
		lblPauloMenezes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPauloMenezes.setBounds(10, 201, 150, 14);
		contentPane.add(lblPauloMenezes);
		
		JLabel lblNewLabel = new JLabel(IntegraisFachada.UsuarioLogado.getCurso());
		lblNewLabel.setBounds(10, 221, 150, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblUfrpe = new JLabel(IntegraisFachada.UsuarioLogado.getUniversidade());
		lblUfrpe.setBounds(10, 241, 150, 14);
		contentPane.add(lblUfrpe);
		
		}else{
			
		
			JLabel lblPauloMenezes = new JLabel();
			lblPauloMenezes.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPauloMenezes.setBounds(10, 201, 150, 14);
			contentPane.add(lblPauloMenezes);
			
			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setBounds(10, 221, 150, 14);
			contentPane.add(lblNewLabel);
			
			JLabel lblUfrpe = new JLabel();
			lblUfrpe.setBounds(10, 241, 150, 14);
			contentPane.add(lblUfrpe);	
			
		}
		
		
	}
	
	private void navegar(String pagina) {
		if (panelContent.getComponent(mapearTelas.get(pagina)) instanceof Painel) {
			((Painel)panelContent.getComponent(mapearTelas.get(pagina))).carregarPainel();
		}
		
		cardLayout.show(panelContent, pagina);
		
		if (pagina.equals("INICIO")) {
			mntmInicio.setEnabled(false);
		} else {
			mntmInicio.setEnabled(true);
		}
	}
}
