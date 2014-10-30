import java.util.ArrayList;


public class RepositorioDesafio {

	
private ArrayList<Desafio>desafios;
	
	
	public RepositorioUsuarios() {
	
	desafios = new ArrayList<Desafio>();
	
	}
	
	
	public void  cadastrar(Desafio d){
		
	 desafios.add(d);
	}
	
	
	public Desafio procurar(Usuario u1 , Usuario u2 , Equacao e){
		
	    Equacao  aux = null;
		
		for(Desafio d : desafios){
			
			if(d.getDesafiante().equals(u1)&& d.getDesafiado().equals(u2) && d.getEquacao().equals(e)){
				
				aux = d;
				break;
			}
		}
		
		return aux;
	}
	
	
	public void remover(Usuario u1 , Usuario u2 , Equacao e){
		
		
		Usuario aux = procurar(Usuario u1 , Usuario u2 , Equacao e);
		
		if(aux!= null){
			
			
			usuarios.remove(aux);

	}


}
