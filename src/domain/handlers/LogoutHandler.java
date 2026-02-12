package domain.handlers;

import domain.interfaces.ILogoutHandler;
import services.SessionManager;

/**
 * Classe que define LogoutHandler
 * @author ADS
 */


public class LogoutHandler implements ILogoutHandler  {
	
	private SessionManager session;
	
	/**
	 * Construtor
	 */
	public LogoutHandler(SessionManager session) {
		
		this.session=session;
		
		
		
	}
	
	/**
	 * Dá o logout do utilizador autenticado
	 */
	public void logout(){
		
		session.deleteSession();
	}
}
