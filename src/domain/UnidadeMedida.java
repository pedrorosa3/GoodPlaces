package domain;
/**
 * Classe que define UnidadeMedida
 * @author ADS
 */
public class UnidadeMedida {
	

	private String designacao;
	private String abreviatura;
	
	
	
	/**
	 * Construtor
	 */
	
	public UnidadeMedida(String nome, String abrev) {
		designacao = nome;
		abreviatura = abrev;
	}
	
	
	/**
	 * Obtem a abreviatura desta UnidadeMedida
	 */
	public String obtemAbreviatura() {
		return abreviatura;
	}
	
	
	/**
	 * Representação textual do objeto UnidadeMedida
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(designacao + "     " + abreviatura + "\n");
		return sb.toString();
	}
}
