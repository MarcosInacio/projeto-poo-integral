package com.ufrpe.integrais.gui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.UIManager;

import com.ufrpe.integrais.util.Constantes;

public class GerenciadorTelas {

	private static Map<String, Tela> telas = new HashMap<>();

	public GerenciadorTelas() {
		telas.put(Constantes.LOGIN, new Login());
		telas.put(Constantes.CADASTRAR_USUARIO, new CadastrarUsuario());
		telas.put(Constantes.ESQUECI_SENHA, new EsqueciSenha());
		telas.put(Constantes.PRINCIPAL, new Principal());
	}

	public static void getTela(String telaFechar, String telaAbrir) {
		telas.get(telaFechar).setVisible(false);
		
		if (telas.get(telaAbrir) instanceof Principal) {
			((Principal)telas.get(telaAbrir)).carregarTela();
		}
		
		telas.get(telaAbrir).setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			new GerenciadorTelas();

			getTela(Constantes.CADASTRAR_USUARIO, Constantes.LOGIN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
