package com.ufrpe.integrais.dados;

import java.util.ArrayList;

import com.ufrpe.integrais.dados.entidades.Desafio;
import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.Usuario;


public class RepositorioDesafio {

	
private ArrayList<Desafio> desafios;
	
	
	public RepositorioDesafio() {
	
	desafios = new ArrayList<Desafio>();
	
	}
	
	
	public void  cadastrar(Desafio d){
		
	 desafios.add(d);
	}
	
	
	public Desafio procurar(Usuario u1 , Usuario u2 , Equacao e){
		
	    Desafio  aux = null;
		
		for(Desafio d : desafios){
			
			if(d.getDesafiante().equals(u1)&& d.getDesafiado().equals(u2) && d.getEquacao().equals(e)){
				
				aux = d;
				break;
			}
		}
		
		return aux;
	}
	
	
	public void remover(Usuario u1 , Usuario u2 , Equacao e){
		
		
		Desafio aux = procurar( u1 , u2 , e);
		
		if(aux!= null){
			
			
			desafios.remove(aux);

	}


  }
}
