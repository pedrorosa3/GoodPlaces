package domain;
/**
 * Classe que define Leitura
 * @author ADS
 */
public class Leitura {
	
	private int ano;
	private int mes;
	private int dia;
	private double valor;
	private String abreviatura;
	
	/**
	 * Construtor
	 */
	public Leitura(int ano,int mes,int dia,double valor,String abreviatura) {
		this.setAno(ano);
		this.setMes(mes);
		this.setDia(dia);
		this.setValor(valor);
		this.setAbreviatura(abreviatura);
		
		
		
	}

	/**
	 * Obtem ano
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * Define ano
	 * @param ano - int ano
	 * @requires ano != null
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * Obtem mes
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * Define mes
	 * @param mes - int mes
	 * @requires mes != null
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}

	/**
	 * Obtem dia
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * Define dia
	 * @param dia - int dia
	 * @requires dia != null
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}

	/**
	 * Obtem valor da leitura
	 */
	public double getValor() {
		return valor;
	}

	
	/**
	 * Define valor da leitura
	 * @param valor - double valor
	 * @requires valor != null
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * Obtem abreviatura
	 */
	public String getAbreviatura() {
		return abreviatura;
	}

	
	/**
	 * Define abreviatura
	 * @param abreviatura - string abreviatura
	 * @requires abreviatura != null
	 */
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	
	
	
	

}
