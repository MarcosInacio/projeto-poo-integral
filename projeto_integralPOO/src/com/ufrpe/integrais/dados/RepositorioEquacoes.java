import java.util.ArrayList;


public class RepositorioEquacoes {
	
	
private ArrayList<Equacao>equacoes;
	
	
	public RepositorioUsuarios() {
	
	equacoes = new ArrayList<Equacao>()
	
	}
	
	
	public void  cadastrar(Equacao e){
		
	 equacoes.add(e);
	}
	
	
	public Equacao procurar(String formula){
		
		Equacao aux = null;
		
		for(Equacao e : equacoes){
			
			if(e.getFormula().equals(formula)){
				
				aux = e;
				break;
			}
		}
		
		return aux;
	}
	
	
	public void remover(String formula){
		
		
		Usuario aux = procurar(formula);
		
		if(aux!= null){
			
			
			usuarios.remove(aux);
		
		
	}
	


}
