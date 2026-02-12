package domain;

/**
 * Classe que define DescricaoCaracteristica
 * @author ADS
 */

public class DescricaoCaracteristica {
	private String designacao;
	private TipoSensor sensor;
	private UnidadeMedida medida;
	
	/**
	 * Construtor
	 */
	public DescricaoCaracteristica(String designacao) {
		
		this.designacao=designacao;
		
	}
	
	/**
	 * Associa Tipo de sensor
	 * @param sensor - objeto TipoSensor
	 * @requires sensor != null
	 */
	public void associaTipoSensor(TipoSensor sensor) {
		
		this.sensor=sensor;
	}
	
	
	/**
	 * Associa unidade de medida
	 * @param med - objeto UnidadeMedida
	 * @requires med != null
	 */
	public void defineUnidadeMedida(UnidadeMedida med) {
		
		this.medida=med;	
		
	}
	
	
	/**
	 * Obtem designacao do objeto
	 */
	public String obtemDesignacao() {
		return designacao;
		
	}
	
	
	/**
	 * Obtem a abreviatura da unidade de medida associada ao objeto
	 */
	public String obtemAbreviaturaUnidade() {
		String res= medida.obtemAbreviatura();
		return res;
		
	}
	
	
	/**
	 * Obtem o tipoSensor associado ao objeto
	 */
	public TipoSensor obtemTipoSensor() {
		return sensor;
		
	}
	

}
