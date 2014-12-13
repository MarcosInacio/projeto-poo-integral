package com.ufrpe.integrais.gui;

import javax.swing.JFrame;

import com.alee.laf.WebLookAndFeel;
import com.ufrpe.integrais.negocio.IIntegraisFachada;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public abstract class Tela extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected IIntegraisFachada fachada;
	
	public static GerenciadorTelas gerenciadorTelas = new GerenciadorTelas();
	
	public String nomeDaTela;
		
	public Tela() {
		this.fachada = new IntegraisFachada();
	}
	
	public static void main(String[] args) {
		try 
	    {
			WebLookAndFeel.install();
			
			gerenciadorTelas.getTela(new Login());
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    }
	}
}
