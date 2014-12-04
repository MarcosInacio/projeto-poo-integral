package com.ufrpe.integrais.negocio;

import com.ufrpe.integrais.dados.IRepositorioDesafio;
import com.ufrpe.integrais.dados.RepositorioDesafio;
import com.ufrpe.integrais.dados.entidades.Desafio;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;

public class CadastroDesafios {
	
	private IRepositorioDesafio repositorioDesafios;
	
	
	public CadastroDesafios(){
		
		
		this.repositorioDesafios = RepositorioDesafio.getInstance();
		
	}
	
	
	
	public void cadastrarDesafio(Desafio d)throws ObjetoJaExistenteExcepitions {
		
		
		 if (d == null) {
	            throw new IllegalArgumentException("Parâmetro inválido");
	            
	            
	     }else{
		
		
		Desafio retorno;
		
	     retorno = this.repositorioDesafios.procurar(d.getDesafiante().getNome() , d.getDesafiado().getNome());
		
	     if(retorno== null){
	    	 
	    	 
	    	 repositorioDesafios.cadastrar(d);
	    	 RepositorioDesafio.salvarNoArquivo();
	    	 
	     }else{
	    	 
	    	 throw new ObjetoJaExistenteExcepitions(d);
	     }
	     
	     }
	}
	
	
	public Desafio procurarDesafio(String desafiante , String desafiado) throws ObjetoNaoExistenteExcepition{
		
		
		Desafio retorno = repositorioDesafios.procurar(desafiante , desafiado);
		
		
		if(retorno == null){
			
			throw new ObjetoNaoExistenteExcepition("desafio",desafiante, desafiado);
		}
		
		return retorno;
	}
	
	
	
	public void removerDesafio(String desafiante , String desafiado)throws ObjetoNaoExistenteExcepition{
		
		
		Desafio retorno = repositorioDesafios.procurar(desafiante , desafiado);
		
		if(retorno != null){
		
		repositorioDesafios.remover(retorno);	
   	    RepositorioDesafio.salvarNoArquivo();
   	    
		}else{
					
		throw new ObjetoNaoExistenteExcepition("desafio",desafiante, desafiado);
			
		}
		
		
	}
	
	
	public void atualizarDesafio(String desafiante , String desafiado, Desafio novo)throws ObjetoNaoExistenteExcepition{
		
		Desafio retorno = repositorioDesafios.procurar(desafiante , desafiado);
		
		if(retorno!= null){
			
			repositorioDesafios.getListaDesafios().set(repositorioDesafios.getListaDesafios().indexOf(retorno),novo);
			RepositorioDesafio.salvarNoArquivo();
		
		}else{
			
			throw new ObjetoNaoExistenteExcepition("desafio",desafiante, desafiado);
		}
		
	}
	

}
