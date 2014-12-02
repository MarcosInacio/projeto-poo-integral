package com.ufrpe.integrais.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import com.ufrpe.integrais.dados.entidades.Desafio;


@SuppressWarnings("serial")
public class RepositorioDesafio implements IRepositorioDesafio , Serializable {

	private static RepositorioDesafio desafio;
	private LinkedList<Desafio> listaDesafios;

	private RepositorioDesafio() {

		this.listaDesafios = new LinkedList<Desafio>();

	}
	
	public LinkedList<Desafio> getListaDesafios(){
		
		return this.listaDesafios; 
		
	}
	
	
	public static RepositorioDesafio getInstance(){
		
		if(desafio == null){
			
			desafio = lerDoArquivo();
			
		}
		
		return desafio;
	}
	
	
	
	
	private static RepositorioDesafio lerDoArquivo(){
		
		RepositorioDesafio repositorioLocal = null;
		
		File in = new File ("desafio.dat");
		FileInputStream fis =  null;
		ObjectInputStream ois =  null;
		
		
		try{
			
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			
			repositorioLocal = (RepositorioDesafio)o;
			
		}catch(Exception e){
			
			repositorioLocal = new RepositorioDesafio();
			
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
		
		
		if(desafio == null){
			
			return;
		}
		
		File out = new File("desafio.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try{
			
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(desafio);
			
			
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
	
	


	public void cadastrar(Desafio d) {
		
		listaDesafios.add(d);
		
	}
	

	public Desafio procurar(Desafio des){

		Desafio aux = null;

		for (Desafio d : listaDesafios) {

			if (d.getDesafiante().equals(des.getDesafiante()) && d.getDesafiado().equals(des.getDesafiado())
					&& d.getEquacao().equals(des.getEquacao())) {

				aux = d;
				break;
			}
		}
		
		return aux;
	}
	
	

	public void remover(Desafio des){


			listaDesafios.remove(des);

	}
	
	
}


