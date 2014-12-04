package com.ufrpe.integrais.dados.entidades.excesoes;


@SuppressWarnings("serial")
public class ObjetoNaoExistenteExcepition extends Exception{
	
	private String detalhe1;
	private String detalhe2;
	
	public ObjetoNaoExistenteExcepition(String especificacao,String detalhe1 ,String detalhe2){
		
		super( especificacao+ "não existe no sistema!\n Detalhe:"+detalhe1+"\n"+detalhe2+"\n");
		
		this.setDetalhe1(detalhe1);
		this.setDetalhe2(detalhe2);
		
	}

	public String getDetalhe1() {
		return detalhe1;
	}

	public void setDetalhe1(String detalhe1) {
		this.detalhe1 = detalhe1;
	}

	public String getDetalhe2() {
		return detalhe2;
	}

	public void setDetalhe2(String detalhe2) {
		this.detalhe2 = detalhe2;
	}



}
