package com.ufrpe.integrais.gui;

import java.util.ArrayList;
import java.util.List;

import com.ufrpe.integrais.dados.entidades.Equacao;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.negocio.IntegraisFachada;

public class EquacoesUsuario extends Equacoes{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1931713785409420637L;
	
	
	public void carregarPainel(){
	
	List<Equacao> listaEquacoes = new ArrayList<>();
	
	
	if(IntegraisFachada.UsuarioLogado != null ){
	
	 try {
		listaEquacoes = fachada.procurarEquacoes(IntegraisFachada.UsuarioLogado.getId());
	} catch (ObjetoJaExistenteExcepitions e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	
	}
	
     equacoes = listaEquacoes;
     nomeDaTela = "Suas Equações";
     LigarBotao = true;
     this.carregarTela();
}

}
