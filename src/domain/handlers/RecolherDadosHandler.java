package domain.handlers;


import java.util.ArrayList;

import java.util.List;

import domain.CatalogoContextos;
import domain.Tecnico;
import domain.Utilizador;
import domain.Contexto;
import domain.Par;
import domain.interfaces.IRecolherDadosHandler;

/**
 * Classe que define RecolherDadosHandler
 * @author ADS
 */

public class RecolherDadosHandler implements IRecolherDadosHandler {
	private CatalogoContextos catcont;
	private Utilizador utz;
	private Contexto ctx;
	private String nomecaracteristica;
	
	/**
	 * Construtor
	 */
	public RecolherDadosHandler(Utilizador utz, CatalogoContextos cat) {
		
		this.catcont=cat;
		this.utz=utz;
	}
	
	
	
	/**
	 * Indica o contexto e returna true caso dê para selecionar esse contexto e false caso contrário
	 * @param nome - nome do conmtexto
	 * @requires nome != null
	 */
	public boolean indicarContexto(String nome) {
		boolean b = false;
		ctx = catcont.obtemContexto(nome);
		if(ctx!=null) {
			
			
			
			b = utz.estahAssociado(ctx);
			System.out.println("RecolherDados: Nome do contexto: "+nome);
			
		}
		
		return (ctx!=null && b);
		
		
	}
	
	
	/**
	 * Indica a caracteristica e a unidade de medida , retorna true caso sejam possíveis ambos e false caso contrário
	 * @param cat - nome da caracteristica
	 * @param uni -  nome da unidade de medida
	 * @requires cat,uni != null
	 */
	public boolean indicarCaracteristica(String cat,String uni) {
		boolean b = ctx.definirCaractUnidCorrente(cat,uni);
		if(b) {
			this.setNomecaracteristica(cat);
		}
		this.setNomecaracteristica(null);
		return b;
	}
	
	
	/**
	 * Obtem uma lista de nomes das caracteristicas disponiveis e unidade de medida correspondentes
	 */
	public List<String> obtemCaracteristicasUnidades (){
		
		
		List<Par<String,String>> res = ctx.obtemCaracteristicaUnidades();
		
		List<String> resultado = new ArrayList<>();
		
		for(Par<String,String> elem : res) {
			String combinado = elem.primeiro() + "-" + elem.segundo();
	        resultado.add(combinado);
			
			
		}
		
		return resultado;
	}
	
	
	
	/**
	 * Registar leitura
	 * @param ano -  int ano atual da leitura
	 * @param mes - int mes atual
	 * @param dia - int dia atual
	 * @param valor - double valor da leitura
	 * @requires ano,mes,dia,valor != null
	 */
	public void indicarLeitura(int ano,int mes, int dia,  double valor) {
		
		ctx.registarLeitura(ano,mes,dia,valor);
		
		
		
		
		
		
		
	}
	
	
	/**
	 * Cancelar a recolha dos dados manual atual
	 */
	@Override
	public void cancelar() {
		
	}

	
	/**
	 * Devolve uma lista de nomes dos contextos ao qual o utilizador autenticado estah associado
	 */
	@Override
	public Iterable<String> iniciarRecolha() {
		if(utz instanceof Tecnico) {
			Iterable<String> res = new ArrayList<String>();
			for(String i : utz.nomesContextosAssociados()) {
				((ArrayList<String>) res).add(i);
				
			}
			
		return res;
			
		}
		
		return null;
	}


	
	/**
	 * Obtem o nome da caracteristica
	 */
	public String getNomecaracteristica() {
		return nomecaracteristica;
	}


	/**
	 * Define o nome da carcteristica
	 * @param nomecaracteristica - nome da caracteristica
	 * @requires nomecaracteristica != null
	 */
	public void setNomecaracteristica(String nomecaracteristica) {
		this.nomecaracteristica = nomecaracteristica;
	}


	
}
