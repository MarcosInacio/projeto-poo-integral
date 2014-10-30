import java.util.ArrayList;


public class RepositorioMedalhas {
	
	
private ArrayList<Medalha>medalhas;
	
	
	public RepositorioUsuarios() {
	
	medalhas = new ArrayList<Medalha>();
	
	}
	
	
	public void  cadastrar(Medalha m){
		
	 medalhas.add(m);
	}
	
	
	public Equacao procurar(String medalha){
		
		Medalha aux = null;
		
		for(Medalha m : medalhas){
			
			if(m.getMedalha().equals(medalha)){
				
				aux = m;
				break;
			}
		}
		
		return aux;
	}
	
	
	public void remover(String medalha){
		
		
		Usuario aux = procurar(medalha);
		
		if(aux!= null){
			
			
			usuarios.remove(aux);

	}


}
