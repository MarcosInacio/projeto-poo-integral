package com.ufrpe.integrais.gui;

import javax.swing.JPanel;

import com.ufrpe.integrais.negocio.IIntegraisFachada;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public class Painel extends JPanel {

	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 7008426009316924279L;
	protected IIntegraisFachada fachada;
	
	public Painel() {
		
			this.fachada = new IntegraisFachada();
	}

}
