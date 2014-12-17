package com.ufrpe.integrais.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends Tela {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panelContent;
	
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
	
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Principal frame = new Principal();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		menuBar.add(mnArquivo);
		
		mntmInicio = new JMenuItem("Inicio");
		mntmInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("INICIO");
			}
		});
		mntmInicio.setEnabled(false);
		mnArquivo.add(mntmInicio);
		
		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Salvo com sucesso");
			}
		});
		mnArquivo.add(mntmSalvar);
		
		JSeparator separator_1 = new JSeparator();
		mnArquivo.add(separator_1);
		
		mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		JMenu mnPerfil = new JMenu("Perfil");
		mnPerfil.setMnemonic('P');
		menuBar.add(mnPerfil);
		
		mntmMeuPerfil = new JMenuItem("Meu perfil");
		mntmMeuPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("PERFIL");
			}
		});
		mnPerfil.add(mntmMeuPerfil);
		
		mntmMinhasEquaes = new JMenuItem("Minhas equa\u00E7\u00F5es");
		mntmMinhasEquaes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("EQUACOES");
			}
		});
		mnPerfil.add(mntmMinhasEquaes);
		
		mntmEditarPerfil = new JMenuItem("Editar perfil");
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
		
		mntmMeusAmigos = new JMenuItem("Meus amigos");
		mntmMeusAmigos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("AMIGOS");
			}
		});
		mnAmigos.add(mntmMeusAmigos);
		
		mntmProcurarAmigos = new JMenuItem("Procurar amigos");
		mntmProcurarAmigos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("AMIGOSPROCURAR");
			}
		});
		mnAmigos.add(mntmProcurarAmigos);
		
		JMenu mnEquaes = new JMenu("Equa\u00E7\u00F5es");
		menuBar.add(mnEquaes);
		
		mntmAdicionarEquao = new JMenuItem("Adicionar equa\u00E7\u00E3o");
		mntmAdicionarEquao.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("EQUACOESADICIONAR");
			}
		});
		mnEquaes.add(mntmAdicionarEquao);
		
		JSeparator separator_3 = new JSeparator();
		mnEquaes.add(separator_3);
		
		mntmMinhasEquaes_1 = new JMenuItem("Minhas equa\u00E7\u00F5es");
		mntmMinhasEquaes_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("EQUACOES");
			}
		});
		mnEquaes.add(mntmMinhasEquaes_1);
		
		mntmEquaesDosMeus = new JMenuItem("Equa\u00E7\u00F5es dos meus amigos");
		mntmEquaesDosMeus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("INICIO");
			}
		});
		mnEquaes.add(mntmEquaesDosMeus);
		
		JSeparator separator_2 = new JSeparator();
		mnEquaes.add(separator_2);
		
		mntmMaisAcessadas = new JMenuItem("Mais acessadas");
		mntmMaisAcessadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				navegar("INICIO");
			}
		});
		mnEquaes.add(mntmMaisAcessadas);
		
		mntmMaisCurtidas = new JMenuItem("Mais curtidas");
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
		
		mntmSobre = new JMenuItem("Sobre");
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
		panelContent.setBounds(181, 10, 603, 531);
		panelContent.setLayout(new CardLayout(0, 0));

		panelContent.add(new Inicio(), "INICIO");
		panelContent.add(new Perfil(), "PERFIL");
		panelContent.add(new PerfilEditar(), "PERFILEDITAR");
		panelContent.add(new Amigos(), "AMIGOS");
		panelContent.add(new AmigosProcurar(), "AMIGOSPROCURAR");
		panelContent.add(new Equacoes(), "EQUACOES");
		panelContent.add(new EquacoesAdicionar(), "EQUACOESADICIONAR");
		
		cardLayout = (CardLayout)panelContent.getLayout();
		
		contentPane.add(panelContent);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 150, 180);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon("C:\\Users\\Guilherme\\Documents\\Guilherme\\relator_sem_foto_masculino.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 150, 154);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Mudar foto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String local="";
				
				javax.swing.JFileChooser jfc = new javax.swing.JFileChooser();  
				jfc.setMultiSelectionEnabled(false);  
				jfc.setDialogTitle("Selecione a foto do Colaborador");  
				jfc.setFileFilter(new FileNameExtensionFilter("JPG, GIF e PNG", "jpg", "gif", "png","bmp"));
				jfc.showOpenDialog(null);
				
				
				local = jfc.getSelectedFile().getAbsolutePath();
				Image img = new ImageIcon(local).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
				lblNewLabel_1.setIcon(new ImageIcon(img));
				
				
			}
		});
		btnNewButton.setBounds(0, 152, 150, 28);
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(170, 10, 1, 520);
		contentPane.add(separator);
		
		JLabel lblPauloMenezes = new JLabel("Paulo Menezes");
		lblPauloMenezes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPauloMenezes.setBounds(10, 201, 150, 14);
		contentPane.add(lblPauloMenezes);
		
		JLabel lblNewLabel = new JLabel("Ci\u00EAncias da Computa\u00E7\u00E3o");
		lblNewLabel.setBounds(10, 221, 150, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblUfrpe = new JLabel("UFRPE");
		lblUfrpe.setBounds(10, 241, 150, 14);
		contentPane.add(lblUfrpe);
	}
	
	private void navegar(String pagina) {
		cardLayout.show(panelContent, pagina);
		
		if (pagina.equals("INICIO")) {
			mntmInicio.setEnabled(false);
		} else {
			mntmInicio.setEnabled(true);
		}
	}
}
