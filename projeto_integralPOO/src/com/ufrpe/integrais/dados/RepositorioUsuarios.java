package com.ufrpe.integrais.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import com.ufrpe.integrais.dados.entidades.Usuario;


@SuppressWarnings("serial")
public class RepositorioUsuarios implements IRepositorioUsuarios , Serializable{

	private static RepositorioUsuarios instance;
	private LinkedList<Usuario> listaUsuarios;

	
	private RepositorioUsuarios() {

		this.listaUsuarios = new LinkedList<Usuario>();

	}
	
	
	
	public LinkedList<Usuario> getListaUsuarios(){
		
		return this.listaUsuarios; 
		
	}	
	

	
   public static RepositorioUsuarios getInstance(){
		
		if(instance == null){
			
			instance = lerDoArquivo();
			
		}
		
		return instance;
	}
	
	
	

  private static RepositorioUsuarios lerDoArquivo(){
		

	RepositorioUsuarios repositorioLocal = null;
		
		File in = new File ("usuarios.dat");
		FileInputStream fis =  null;
		ObjectInputStream ois =  null;
		
		
		try{
			
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			
			repositorioLocal = (RepositorioUsuarios)o;
			
		}catch(Exception e){
			
			repositorioLocal = new RepositorioUsuarios();
			
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
		
		
		if(instance == null){
			
			return;
		}
		
		File out = new File("usuarios.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try{
			
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
			
			
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
	

   public void cadastrar(Usuario u) {
		
		listaUsuarios.add(u);
		
	}
	

	public Usuario procurar(String email , String senha){

		Usuario aux = null;

		for (Usuario u : listaUsuarios) {

			if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {

				aux = u;
				break;
			}
		}
		
		return aux;
	}
	
	

	public void remover(Usuario u){


			listaUsuarios.remove(u);

	}

}
