package com.ufrpe.integrais.gui;

import java.util.ArrayList;
import java.util.List;

import com.ufrpe.integrais.dados.entidades.Amizade;
import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public class EquacoesMural extends Equacoes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 535705242190507990L;
	
	
	public EquacoesMural(){
		

		List<Equacao> listaEquacoes = new ArrayList<>();
		
		
		if(IntegraisFachada.UsuarioLogado != null ){
		
			List<Amizade> listaAmigos = fachada.verificarAmizades(IntegraisFachada.UsuarioLogado.getId()); 
			
			for(Amizade a : listaAmigos){
				
				if(a.getIdUsuario1() == IntegraisFachada.UsuarioLogado.getId()){
					
					try {
						listaEquacoes.addAll(fachada.procurarEquacoes(a.getIdUsuario2()));
						
					} catch (ObjetoJaExistenteExcepitions e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
					
				}else{
					
					try {
						listaEquacoes.addAll(fachada.procurarEquacoes(a.getIdUsuario1()));
						
					} catch (ObjetoJaExistenteExcepitions e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			}
			
		}
		
		this.equacoes = listaEquacoes;
		this.carregarPainel();
	}
	
	

}
