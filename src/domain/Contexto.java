package domain;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.alertas.IEventoAlerte;


/**
 * Classe que define Contextos
 * @author ADS
 */

public class Contexto {
	
	private String designacao;
	private Map<String,CaracteristicaContexto> carcons;
	private CaracteristicaContexto cc;
	
    
	/**
	 * Construtor
	 */
	
	
	public Contexto(String desig) {
		carcons = new HashMap<>();
		designacao = desig;
		
	}
	
	
	/**
	 * Adiciona CaracteristicaContexto
	 * @param carCont - objeto caracteristicaContexto
	 * @requires carCont != null
	 */
	public void adicionaCaracteristica(CaracteristicaContexto carCont) {
		carcons.put(carCont.nomeCaracteristica(), carCont);
		carCont.addObserver(this);
	}
	
	
	/**
	 * Obtem designacao do contexto
	 */
	public String obtemDesignacao() {
		return designacao;
	}
	
	
	/**
	 * Verifica se a unidade de medida é compativel com o contexto e se a caracteristica contexto está associada ao contexto
	 * @param cont - A designacao do contexto
	 * @param med -  a designacao da unidade de medida
	 * @requires cont,med != null
	 */
	public boolean definirCaractUnidCorrente(String cont, String med) {
		
		boolean c = false;
		cc = carcons.get(cont);
		if (cc!=null) {
			
			c = cc.definirUnidadeCorrenteLeitura(med);
			
		}
		return cc!=null && c;
		
		
		
	}
	
	
	/**
	 * Obtem uma lista das caracteristicasCcontextos e respetivas unidades de medida
	 */
	public List<Par<String, String>> obtemCaracteristicaUnidades() {
		
		
		
		List<Par<String,String>> res = new ArrayList<Par<String,String>>();
		for(CaracteristicaContexto teste : carcons.values()) {
			String res1 = teste.nomeCaracteristica();
			String res2 = teste.abreviaturaUnidade();
			res.add(new Par<String,String>(res1,res2));
			
		}
		return res;
		
		
		
	}
	
	
	/**
	 * Regista leitura 
	 * @param ano - ano atual
	 * @param mes - mes atual
	 * @param dia - dia atual
	 * @param valor - valor da leitura
	 * @requires ano,mes,dia,valor != null
	 */
	public void registarLeitura(int ano, int mes, int dia, double valor) {
		
		cc.registarLeitura(ano,mes,dia,valor);
		
	}
	
	
	/**
	 * Verifica se houve alterações e notifica os envolventes
	 * @param eu - objeto propoertyChange
	 * @requires eu != null
	 */
	public void propertyChange(PropertyChangeEvent eu) {
		
		if(eu.getNewValue() instanceof IEventoAlerte) {
			
			PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(null);
			propertyChangeSupport.firePropertyChange(designacao, eu, eu);
			
		}
		
		
		
		
	}
	
	
	/**
	 * Adiciona como observador o utilizador
	 * @param utilizador - objeto utilizador
	 * @requires utilizador != null
	 */
	public void addObserver(Utilizador utilizador) {
		
		
	}
	
}
