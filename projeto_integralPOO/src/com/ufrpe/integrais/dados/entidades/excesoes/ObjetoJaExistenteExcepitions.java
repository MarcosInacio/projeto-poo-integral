package com.ufrpe.integrais.dados.entidades.excesoes;

import com.ufrpe.integrais.dados.entidades.Entidade;

@SuppressWarnings("serial")
public class ObjetoJaExistenteExcepitions extends Exception {
 
	private Entidade objeto;
	
	
	public ObjetoJaExistenteExcepitions(Entidade c) {
			
		
		super(" Objeto já existe, Cadastro não realizado.\n Detalhes:\n"+c.toString()+"\n");
		this.setObjeto(c);
	}


	public Entidade getObjeto() {
		return objeto;
	}


	public void setObjeto(Entidade objeto) {
		this.objeto = objeto;
	}

	
	
	
	
	
	
	
}
