package domain;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe que define caracteristicas dee contextos
 * @author ADS
 */

public class CaracteristicaContexto {
	
	private DescricaoCaracteristica car;
	private ValoresReferencia ref;
	private Sensor sensor;
	private Contexto cont;
	
	/**
	 * Construtor
	 */
	
	
	
	public CaracteristicaContexto(DescricaoCaracteristica car) {
		
		this.car = car;
		
	}
	
	
	
	/**
	 * Verificaa se a unid é compatível
	 * @param unid - A designacao da unidade
	 * @requires unid != null
	 */
	public boolean definirUnidadeCorrenteLeitura(String unid) {
		String abrev = car.obtemAbreviaturaUnidade();
		return abrev==unid;
		
		
	}
	
	
	/**
	 * Obtem o nome da descricao caracteristica
	 */
	public String nomeCaracteristica() {
		String res=car.obtemDesignacao();
		return res;
		
	}
	
	
	/**
	 * Obtem a abreviatura da unidade de medida
	 */
	public String abreviaturaUnidade() {
		String res = car.obtemAbreviaturaUnidade();
		return res;
		
	}
	
	
	/**
	 * Regista uma leitura
	 * @param ano -  ano atual
	 * @param mes - mes atual
	 * @param dia - dia atual
	 * @param valor - valor da leitura
	 * @requires - ano,mes,dia,valor !=null
	 */
	public void registarLeitura(int ano, int mes, int dia, double valor) {
		List<Leitura> res = new ArrayList<Leitura>();
		
		String abv = car.obtemAbreviaturaUnidade();
		Leitura lei = new Leitura (ano,mes,dia,valor,abv);
		
		res.add(lei);
		
		int k = ref.estahNoIntervalo(valor);
		
		if(k!=0) {
			
			//EventoAlerte alerta = new EventoAlerte();
			
			//PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(null);
			//propertyChangeSupport.firePropertyChange(abv, k, lei);
			
			
		}
		
		
		
		
	}
	
	
	
	/**
	 * Associa o sensor à caracteristicacontexto
	 * @param sens - o objeto sensor
	 * @requires sens != null
	 */
	public void associaSensor(Sensor sens) {
		
		
		setSensor(sens);
		
		
		
	}
	
	
	/**
	 * Regista os valores de referência
	 * @param min - valor minimo
	 * @param max - valor maximo
	 * @requires min,max != null
	 */
	public void registaValoresRef (int min,int max) {
		
		ValoresReferencia val = new ValoresReferencia(min,max);
		this.ref=val;
		
		
	}
	
	
	/**
	 * Adiciona como observador
	 * @param Contexto - objeto contexto
	 */
	public void addObserver(Contexto contexto) {
		
		
		
		
	}


	/**
	 * Obter sensor
	 */
	public Sensor getSensor() {
		return sensor;
	}


	/**
	 * DefineSensor
	 * @param sensor - objeto sensor
	 * @requires sensor != null
	 */
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}


	/**
	 * Obtem contexto
	 */
	public Contexto getCont() {
		return cont;
	}


	/**
	 * Define o contexto
	 * @param cont - objeto contexto
	 * @requires cont != null
	 */
	public void setCont(Contexto cont) {
		this.cont = cont;
	}

}
