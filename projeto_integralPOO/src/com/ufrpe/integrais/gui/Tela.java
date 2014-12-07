package com.ufrpe.integrais.gui;

import javax.swing.JFrame;

import com.ufrpe.integrais.negocio.IIntegraisFachada;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public abstract class Tela extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected IIntegraisFachada fachada;
		
	public Tela() {
		fachada = new IntegraisFachada();
	}
}
