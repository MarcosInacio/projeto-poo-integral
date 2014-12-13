package com.ufrpe.integrais.gui;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorTelas {
	private Map<String, Tela> telas = new HashMap<>();
	
	public Tela getTela(Tela tela) {
		if (!telas.containsKey(tela.nomeDaTela)) {
			telas.put(tela.nomeDaTela, tela);
		}
		
		telas.get(tela.nomeDaTela).setVisible(true);

		return telas.get(tela.nomeDaTela);
	}
}
