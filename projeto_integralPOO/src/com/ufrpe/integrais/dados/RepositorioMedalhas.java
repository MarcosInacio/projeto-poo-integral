package com.ufrpe.integrais.dados;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import com.ufrpe.integrais.dados.entidades.Medalha;




public class RepositorioMedalhas  implements IRepositorioMedalhas{

	private LinkedList<Medalha> medalhas;
    private static RepositorioMedalhas repositorioMedalhas;
	
	
	private RepositorioMedalhas() {

		medalhas = new LinkedList<Medalha>();

	}
	
   public static RepositorioMedalhas getInstance(){
		
		if(repositorioMedalhas == null){
			
			repositorioMedalhas = lerDoArquivo();
			
		}
		
		return repositorioMedalhas;
	}
	
	
	
	 private static RepositorioMedalhas lerDoArquivo(){
			

	    	RepositorioMedalhas repositorioLocal = null;
	    		
	    		File in = new File ("medalhas.dat");
	    		FileInputStream fis =  null;
	    		ObjectInputStream ois =  null;
	    		
	    		
	    		try{
	    			
	    			fis = new FileInputStream(in);
	    			ois = new ObjectInputStream(fis);
	    			Object o = ois.readObject();
	    			
	    			repositorioLocal = (RepositorioMedalhas)o;
	    			
	    		}catch(Exception e){
	    			
	    			repositorioLocal = new RepositorioMedalhas();
	    			
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
	    		
	    		
	    		if(repositorioMedalhas == null){
	    			
	    			return;
	    		}
	    		
	    		File out = new File("medalhas.dat");
	    		FileOutputStream fos = null;
	    		ObjectOutputStream oos = null;
	    		
	    		try{
	    			
	    			fos = new FileOutputStream(out);
	    			oos = new ObjectOutputStream(fos);
	    			oos.writeObject(repositorioMedalhas);
	    			
	    			
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
	public LinkedList<Medalha> getListaMedalhas() {
		// TODO Auto-generated method stub
		return medalhas;
	}



	@Override
	public void remover(Medalha m) {
		
		medalhas.remove(m);
		
	}

	@Override
	public void cadastrar(Medalha m) {
		
		medalhas.add(m);
		
	}

	@Override
	public Medalha procurar(String m) {
		
		Medalha aux = null;
		
		for (Medalha med : medalhas) {

			if (med.getMedalha().equals(m) ) {

				aux = med;
				break;
			}
		}
		
		return aux;
		
	}
}
