package com.ufrpe.integrais.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import com.ufrpe.integrais.dados.entidades.Equacao;



public class RepositorioEquacoes implements IRepositorioEquacoes{
	
	private LinkedList<Equacao> equacoes;
    private static RepositorioEquacoes repositorioEquacoes;
	
	
	private RepositorioEquacoes() {
		
		this.equacoes = new LinkedList<Equacao>();
	}
	
	
	
	public static RepositorioEquacoes getInstance(){
		
		if(repositorioEquacoes == null){
			
			
			repositorioEquacoes = lerDoArquivo();
			
		}
		
	    return repositorioEquacoes;
	}
	
	
 
    
    private static RepositorioEquacoes lerDoArquivo(){
		

    	RepositorioEquacoes repositorioLocal = null;
    		
    		File in = new File ("equacoes.dat");
    		FileInputStream fis =  null;
    		ObjectInputStream ois =  null;
    		
    		
    		try{
    			
    			fis = new FileInputStream(in);
    			ois = new ObjectInputStream(fis);
    			Object o = ois.readObject();
    			
    			repositorioLocal = (RepositorioEquacoes)o;
    			
    		}catch(Exception e){
    			
    			repositorioLocal = new RepositorioEquacoes();
    			
    		}finally{
    			
    			if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {/* Silent exception */
                    }
                }
    			
    		}
    		
    		return repositorioLocal;
    	}
    	
    	
      
      
    	public static void salvarNoArquivo(){
    		
    		
    		if(repositorioEquacoes == null){
    			
    			return;
    		}
    		
    		File out = new File("equacoes.dat");
    		FileOutputStream fos = null;
    		ObjectOutputStream oos = null;
    		
    		try{
    			
    			fos = new FileOutputStream(out);
    			oos = new ObjectOutputStream(fos);
    			oos.writeObject(repositorioEquacoes);
    			
    			
    		}catch(Exception e){
    			
    			e.printStackTrace();
    		
    		}finally{
    			
    			if(oos!= null){
    				
    				try{
    				oos.close();
    				
    				}catch(Exception e){
    					
    					;
    				}
    			}
    		}
    		
    	}
    	


	@Override
	public Equacao procurar(String formula, String nome) {
		
		
		Equacao aux = null;

		for (Equacao e : equacoes) {

			if (e.getUsuario().getNome().equals(nome) && e.getFormula().equals(formula)) {

				aux = e;
				break;
			}
		}
		
		return aux;
	}


	@Override
	public void remover(Equacao e) {
		
		
		equacoes.remove(e);
		
	}



	@Override
	public void cadastrar(Equacao e) {
		
		
		equacoes.add(e);
		
	}



	@Override
	public LinkedList<Equacao> getListaEquacao() {
		
		return equacoes;
	}
}
