package domain.handlers;

import domain.CatalogoUtilizadores;

import domain.Utilizador;
import domain.interfaces.ILoginHandler;
import services.SessionManager;
/**
 * Classe que define LoginHandler
 * @author ADS
 */

public class LoginHandler implements ILoginHandler {
	
	private CatalogoUtilizadores catutzs;
	private SessionManager sessionManager;
	/**
	 * Construtor
	 */
	public LoginHandler(CatalogoUtilizadores utz,SessionManager session) {
		
		this.sessionManager=session;
		this.catutzs=utz;
		
	}
	
	
	
	/**
	 * Tenta dar login e retorna true caso o login seja bem sucedida e false cao dê algum erro
	 * @param nome - nome do utilizador
	 * @param psw - password do utilizador
	 * @requires nome,psw != null
	 */
    public boolean login (String nome, String psw) {
    	
   
   
        Utilizador u = catutzs.obtemUtilizador(nome);
        
        
        		
        if (u != null) {
        	
        	
        	boolean b = u.pwdCorreta(psw);
        	
        	
        	if (b == true) {
        		
        		
        		sessionManager.createSession(nome);
        		return true;
        	}
        	
        	else {
        		
        		return false;
        	}
        	
        }
        else {
        	
        	return false;
     
        }
        
    }

}
  
    