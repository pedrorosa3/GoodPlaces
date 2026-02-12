package domain;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.alertas.AlerteAdapterFactory;
import domain.alertas.IAlerteAdapter;
import domain.alertas.IEventoAlerte;
/**
 * Classe que define Utilizador
 * @author ADS
 */
public abstract class Utilizador {
	
	private String nome;
	private String pwd;
	private String email;
	private Map<String,Contexto> contextosAssociado;

	/**
	 * Construtor
	 */
	public Utilizador (String nome) {
		this.contextosAssociado = new HashMap<>();
		this.nome = nome;		
	}
	
	
	/**
	 * Define a password do Utilizador
	 * @param pwd2 - string da password 
	 * @requires pwd2 != null
	 */
	public void definirPassword(String pwd2) {
		this.pwd = pwd2;		
	}
	
	
	/**
	 * Obtem nome do utilizador
	 */
	public String obtemNome() {
		return nome;
	}
	
	
	/**
	 * Obtem password do utilizador
	 */
	public String obtemPassword() {
		return pwd;
	}
	
	
	/**
	 * Verifica se a password introduzida estah correta
	 * @param pwd2 - string
	 * @requires pwd2 != null
	 */
	public boolean pwdCorreta(String pwd2) {
		
		return pwd2.equals(pwd);
	}
	
	
	
	/**
	 * Associa o utilizador a um contexto
	 * @param contCorr - objeto Contexto
	 * @requires contCorr != null
	 */
	public void ficasAssociado(Contexto contCorr) {
		contextosAssociado.put(contCorr.obtemDesignacao(), contCorr);
		contCorr.addObserver(this);		
	}
	
	
	/**
	 * Devolve uma lista de nomes dos contextos ao qual o utilizador estah associado
	 */
	public List<String> nomesContextosAssociados(){
		
		List<String> res = new ArrayList<String>();
		for(Contexto value: contextosAssociado.values()) {
			
			String nome = value.obtemDesignacao();
			res.add(nome);
			
		}
			
		return res;
		
		
	}
	
	
	/**
	 * Verifica se o utilizador estah associado a um dado contexto
	 * @param ctx - objeto Contexto
	 * @requires ctx != null
	 */
	public boolean estahAssociado(Contexto ctx) {
		boolean flag=false;
		for(Contexto cont : contextosAssociado.values()) {
			if (cont == ctx) {
				flag=true;
			}
				
		}
		return flag;
		
	}
	
	
	/**
	 * Envia alerta aos utilizadores caso ocorraalterações nos contextos aos quais eles estao associados
	 * @param eu - objeto PropertyChangeEvent
	 * @requires eu != null
	 */
	public void propertyChange(PropertyChangeEvent eu) {
		IAlerteAdapter res =AlerteAdapterFactory.getAlerteAdapter();
		res.enviaAlerta(this,(IEventoAlerte) eu);
		
		
		
	}

	
	/**
	 * Obtem o mail do utilizador
	 */
	public String getEmail() {
		return email;
	}

	
	/**
	 * Define o mail do utilizador
	 * @param email - string com o mail
	 * @requires email != null
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
