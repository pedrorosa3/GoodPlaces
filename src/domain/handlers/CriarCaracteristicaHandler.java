package domain.handlers;

import java.util.ArrayList;
import java.util.List;

import domain.CatalogoDescricaoCaracteristicas;
import domain.CatalogoTiposSensor;
import domain.CatalogoUnidades;
import domain.DescricaoCaracteristica;
import domain.TipoSensor;
import domain.UnidadeMedida;
import domain.interfaces.ICriarCaracteristicaHandler;

/**
 * Classe que define CriarCaracteristicaHandler
 * @author ADS
 */
public class CriarCaracteristicaHandler implements ICriarCaracteristicaHandler {
	
	private DescricaoCaracteristica descricao;
	private CatalogoUnidades catuni;
	private CatalogoDescricaoCaracteristicas catcaract;
	private CatalogoTiposSensor cattipsens;
	private TipoSensor tip;
	
	/**
	 * Construtor
	 */
	public CriarCaracteristicaHandler(CatalogoUnidades cat,CatalogoDescricaoCaracteristicas cat1,CatalogoTiposSensor cat2) {
		this.catuni=cat;
		this.catcaract=cat1;
		this.cattipsens=cat2;
		
	}

	/**
	 * Cria uma caracteristica e retorna true caso a criacao seja bem sucedida e false cao dê algum erro
	 * @param desig - A designacao da caracteristica
	 * @requires desig != null
	 */
	public boolean criarCaracteristica(String desig) {
		boolean b = catcaract.existeCaracteristica(desig);
		if (b!=true) {
			DescricaoCaracteristica dc= new DescricaoCaracteristica(desig);
			this.descricao=dc;
			
			
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	/**
	 * Obter os tiposSensor existentes
	 */
	public List<String>obterTiposSensor(){
		
		List<String> result= new ArrayList <String>();
		 for(String i : cattipsens.nomesTiposSensor()) {
			 result.add(i);
			 
		 }
		
		return result;
	}
	
	
	/**
	 * Indicar o tipoSensor e retorna true caso possa ser o escolhido e false caso contrário
	 * @param tipo - A designacao do tipoSensor
	 * @requires tipo != null
	 */
	public boolean indicarTipoSensor( String tipo) {
		TipoSensor ts=cattipsens.obtemTipoSensor(tipo);
		if (ts!=null) {
			descricao.associaTipoSensor(ts);
			this.tip=ts;
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	
	/**
	 * Obtem a abreviatura das unidades de medida do tipo do sensor escolhido
	 */
	public Iterable<String> obterUnidadesMedida(){
		
		UnidadeMedida result= tip.obtemNomeUnidades();
		List<String> unilist= new ArrayList<String>();
		String abr=result.obtemAbreviatura();
		unilist.add(abr);
		
		return unilist;
					
	}
	
	
	/**
	 * Indicar a Unidade pretendida , retorna true caso dê para ser a escolhida e false caso contrário
	 * @param uni - A designacao da unidade
	 * @requires uni != null
	 */
	public boolean indicarUnidade(String uni) {
		
		UnidadeMedida res= catuni.obtemUnidade(uni);
		if(res!=null) {
			descricao.defineUnidadeMedida(res);
			return true;
			
		}
		else {
			return false;
		}
			
		
	}
	
	
	/**
	 * Confirmar a criacao e adicionar ao catalogo a caracteristica
	 */
	public void confirmar() {
		
		catcaract.adicionaCaracteristica(descricao);
		
		
	}
	
	
	
	/**
	 * Cancelar a criaçao da caracteristica
	 */
	public void cancelar() {
		
		
		
	}

}
