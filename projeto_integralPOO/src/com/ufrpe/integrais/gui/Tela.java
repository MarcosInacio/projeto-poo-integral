package com.ufrpe.integrais.gui;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.ufrpe.integrais.negocio.IIntegraisFachada;
import com.ufrpe.integrais.negocio.IntegraisFachada;
import com.ufrpe.integrais.util.Constantes;

public abstract class Tela extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected IIntegraisFachada fachada;
	
	public static GerenciadorTelas gerenciadorTelas = new GerenciadorTelas();
	
	public String nomeDaTela;
		
	public Tela() {
		this.fachada = new IntegraisFachada();
	}
	
	public abstract void carregarTela();
	
	public static void main(String[] args) {
		try 
	    {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			gerenciadorTelas.getTela(Constantes.LOGIN);
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    }
	}
}
