package com.ufrpe.integrais.negocio;

import com.ufrpe.integrais.dados.IRepositorioUsuarios;
import com.ufrpe.integrais.dados.RepositorioUsuarios;
import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;

public class CadastroUsuarios {
	
	private IRepositorioUsuarios repositosioUsuarios;
	
	
	public CadastroUsuarios(){
		
		
		repositosioUsuarios = RepositorioUsuarios.getInstance();
		
	}
	
	
   public void cadastrarUsuario(Usuario u)throws ObjetoJaExistenteExcepitions {
		
	   if (u == null) {
           throw new IllegalArgumentException("Parâmetro inválido");
       
	   }else{
	   
		Usuario retorno;
		
	     retorno = this.repositosioUsuarios.procurar(u.getEmail(), u.getSenha());
		
	     if(retorno == null){
	    	 
	    	 
	    	 repositosioUsuarios.cadastrar(u);
	    	 RepositorioUsuarios.salvarNoArquivo();
	    	 
	     }else{
	    	 
	    	 throw new ObjetoJaExistenteExcepitions(u);
	     }
	}
	
   }
   
   
   public Usuario procurarUsuario(String email , String senha) throws ObjetoNaoExistenteExcepition {
		
		
		Usuario retorno = repositosioUsuarios.procurar(email, senha);
		
		
		if(retorno == null){
			
			throw new ObjetoNaoExistenteExcepition("Usuario:", email , senha);
		}
		
		return retorno;
	}
	
   
   
   public void removerUsuario(String email ,String senha) throws ObjetoNaoExistenteExcepition{
	   
	   	Usuario retorno = repositosioUsuarios.procurar(email, senha);
	   
	   if(retorno!= null){
		   
		   repositosioUsuarios.remover(retorno);
		   RepositorioUsuarios.salvarNoArquivo();
		   
	   }else{
		   
		   throw new ObjetoNaoExistenteExcepition("Usuario:",email, senha);
	   }
	   
   }
   
   
   
   public Usuario loginUsuario(String email ,String senha) throws ObjetoNaoExistenteExcepition{
	   
	   Usuario retorno = repositosioUsuarios.procurar(email, senha);
	   
	   
	   if(retorno == null){
		   
		   throw new ObjetoNaoExistenteExcepition("Usuario:",email, senha);
		   
	   }
	   
	   return retorno;
   }
   
   
   
   
   public void atualizarCadastro(String email , String senha , Usuario novo) throws ObjetoNaoExistenteExcepition{
	   
	   
	   Usuario retorno = repositosioUsuarios.procurar(email, senha);
	   
	   
	   if(retorno != null){
		   
		repositosioUsuarios.getListaUsuarios().set(repositosioUsuarios.getListaUsuarios().indexOf(retorno), novo);   
		RepositorioUsuarios.salvarNoArquivo();

	   }else{
		   
		   throw  new ObjetoNaoExistenteExcepition("Usuario:",email, senha);
	   }
	   
   }

}
