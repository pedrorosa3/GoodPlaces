package domain.alertas;

import domain.Utilizador;


/**
 * Classe que define o SysoutAlerteAdapter
 * @author ADS
 */

public abstract class SysoutAlerteAdapter implements IAlerteAdapter {
	
	
	/**
	 * Envia alertas para o terminal
	 * @param u - objeto Utilizador
	 * @param evento - objeto EventoAlerte
	 * @requires u,evento != null
	 */
	public void enviaAlerte(Utilizador u , EventoAlerte evento) {
		
		System.out.println("oi");
		
	}

}
