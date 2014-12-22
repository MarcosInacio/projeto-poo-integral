package com.ufrpe.integrais.gui;

import java.util.HashMap;
import java.util.Map;

import com.ufrpe.integrais.util.Constantes;

public class GerenciadorTelas {
	private Map<String, Tela> telas = new HashMap<>();
	
	public GerenciadorTelas() {
		telas.put(Constantes.LOGIN, new Login());
		telas.put(Constantes.CADASTRAR_USUARIO, new CadastrarUsuario());
		telas.put(Constantes.ESQUECI_SENHA, new EsqueciSenha());
		telas.put(Constantes.PRINCIPAL, new Principal());
	}
	
	public Tela getTela(String nomeTela) {
		Tela t = telas.get(nomeTela);
		t.carregarTela();
		t.setVisible(true);
		return t;
	}
}
