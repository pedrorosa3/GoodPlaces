package domain.alertas;

import domain.Utilizador;

/**
 * O interface que define as operacoes do sistema dos AlertesAdapters
 *
 * @author ADS
 */

public interface IAlerteAdapter {
	
	
	/**
	 * Envia alerta
	 * 
	 * @param u - Objeto do tipo Utilizador
	 * @param eu - Objeto do tipo IEventoAlerte
	 */
	void enviaAlerta(Utilizador u, IEventoAlerte eu);

}
