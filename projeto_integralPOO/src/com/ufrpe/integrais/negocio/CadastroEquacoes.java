package com.ufrpe.integrais.negocio;

import com.ufrpe.integrais.dados.IRepositorioEquacoes;
import com.ufrpe.integrais.dados.RepositorioEquacoes;
import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;

public class CadastroEquacoes {
	
	
	private IRepositorioEquacoes repositorioEquacoes;
	
	 
	public CadastroEquacoes(){
		
		this.repositorioEquacoes = RepositorioEquacoes.getInstance();
	}
	
	
	public void cadastrarEquacoes(Equacao e)throws ObjetoJaExistenteExcepitions {
		
		
		 if (e == null) {
	            throw new IllegalArgumentException("Parâmetro inválido");
	            
	            
	     }else{
		
		
		 Equacao retorno;
		
	     retorno = this.repositorioEquacoes.procurar(e.getFormula(), e.getUsuario().getNome());
		
	     if(retorno== null){
	    	 
	    	 
	    	 repositorioEquacoes.cadastrar(e);
	    	 RepositorioEquacoes.salvarNoArquivo();
	    	 
	     }else{
	    	 
	    	 throw new ObjetoJaExistenteExcepitions(e);
	     }
	     
	     }
	}
	
	
	
    public Equacao procurarEquacao(String formula , String nome ) throws ObjetoNaoExistenteExcepition{
		
		
		Equacao retorno = repositorioEquacoes.procurar(formula ,nome);
		
		
		if(retorno == null){
			
			throw new ObjetoNaoExistenteExcepition("Equacao",formula,nome);
		}
		
		return retorno;
	}
	
    
    
    public void removerEquacao(String formula , String nome)throws ObjetoNaoExistenteExcepition{
		
		
		Equacao retorno = repositorioEquacoes.procurar(formula , nome);
		
		if(retorno != null){
		
		repositorioEquacoes.remover(retorno);	
   	    RepositorioEquacoes.salvarNoArquivo();
   	    
		}else{
					
		throw new ObjetoNaoExistenteExcepition("Equação",formula, nome);
			
		}
		
		
	}
    
    
    
   public void atualizarMedalha(String formula, String nome , Equacao novo)throws ObjetoNaoExistenteExcepition{
		
		Equacao retorno = repositorioEquacoes.procurar(formula , nome);
		
		if(retorno!= null){
			
			repositorioEquacoes.getListaEquacao().set(repositorioEquacoes.getListaEquacao().indexOf(retorno),novo);
			RepositorioEquacoes.salvarNoArquivo();
		
		}else{
			
			throw new ObjetoNaoExistenteExcepition("Equacao",formula, nome);
		}
		
	}
    
    
    

}


