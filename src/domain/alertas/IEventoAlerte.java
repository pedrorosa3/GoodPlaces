package domain.alertas;

/**
 * O interface que define as operacoes do sistema dos IEventoAlerte
 *
 * @author ADS
 */
public interface IEventoAlerte {
	/**
	 * Ano do alerta
	 */
	int ano();
	
	
	/**
	 * mes do alerta
	 */
	int mes();
	
	
	
	
	/**
	 * dia do alerta
	 */
	int dia();
	
	
	/**
	 * valor da leitura do alerta
	 */
	double valor();
	
	
	/**
	 * nome da unidade de medida do alerta
	 */
	String Unidade();
	
	
	/**
	 * nome da caracteristica do alerta
	 */
	String caracteristica();
	
	
	/**
	 * nome do contexto do alerta
	 */
	String contexto();
	
	
	/**
	 * mensagem do alerta
	 */
	String mensagem();
	
	
	/**
	 * Adicionar contexto ao alerta
	 * @param contexto -  nome do contexto
	 * @requires contexto!=null
	 */
	void AdicionaContexto(String contexto);
	
	

}
