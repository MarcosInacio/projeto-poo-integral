package com.ufrpe.integrais.dados.entidades.excesoes;

import com.ufrpe.integrais.dados.entidades.CriacaoObjeto;

@SuppressWarnings("serial")
public class ObjetoJaExistenteExcepitions extends Exception {
 
	private CriacaoObjeto objeto;
	
	
	public ObjetoJaExistenteExcepitions(CriacaoObjeto c) {
			
		
		super(" Objeto já existe, Cadastro não realizado.\n Detalhes:\n"+c.toString()+"\n");
		this.setObjeto(c);
	}


	public CriacaoObjeto getObjeto() {
		return objeto;
	}


	public void setObjeto(CriacaoObjeto objeto) {
		this.objeto = objeto;
	}

	
	
	
	
	
	
	
}
