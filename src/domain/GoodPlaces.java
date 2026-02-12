package domain;


import domain.handlers.CriarCaracteristicaHandler;

import domain.handlers.LoginHandler;
import domain.handlers.LogoutHandler;
import domain.handlers.RecolherDadosHandler;
import domain.interfaces.IGoodPlaces;
import services.SessionManager;

/**
 * Classe que define o objeto inicial da aplicacao
 * 
 * @author ADS
 */
public class GoodPlaces implements IGoodPlaces {
	private CatalogoDescricaoCaracteristicas catDescrCaract;
	private CatalogoContextos catContexts;
	private CatalogoUtilizadores catUser;
	private CatalogoTiposSensor catTiposSensor;
	private CatalogoUnidades catUnidades;
	private SessionManager	sessionManager;
	

    /**
     * Construtor
     */
	public GoodPlaces() {
    	catUser = new CatalogoUtilizadores();       // Ja' sao criados alguns utilizadore
    	catUnidades = new CatalogoUnidades();       // Ja' sao criadas algumas unidades
    	catTiposSensor = new CatalogoTiposSensor();
    	catDescrCaract = new CatalogoDescricaoCaracteristicas();
    	catContexts = new CatalogoContextos();
    	sessionManager = SessionManager.getInstance();
    	// Criar alguns objetos necessarios para testar os casos de uso UC6
    	// e UC11 porque os outros casos de uso não estao ainda implementados:
    	catTiposSensor.loadSomeTipoSensor(catUnidades); // Cria 4 Tipos de sensor e sensores associados
    	catDescrCaract.loadSomeDescCar(catTiposSensor, catUnidades);  // Cria 2 caracteristicas
    	catContexts.loadSomeContexts(catDescrCaract, catUser);   // Cria dois contextos
    }
    
	
	
	/**
	 * Obtem o nome do utilizador autenticado
	 */
	@Override
	public String obtemTipoUserAutenticado() {
		return getAuthenticatedUser().getClass().getName().substring(7);
	}
	
	
	/**
	 * Obtem uma intancia do objeto LoginHandler
	 */
	public LoginHandler obtemLoginHandler() {
		
		LoginHandler h= new LoginHandler(catUser,sessionManager);
		return h;
		
	}
	
	
	/**
	 * Obtem uma instancia do LogoutHandler
	 */
	public  LogoutHandler obtemLogoutHandler() {
		
		 LogoutHandler	h= new LogoutHandler(sessionManager);
		 
		 return h;
		
	}
	
	
	
	/**
	 * Obtem o objeto Utilizador que está autenticado 
	 */
	private Utilizador getAuthenticatedUser() {
		
		String nome =  sessionManager.getAuthenticatedUser();
		
		Utilizador utz = catUser.obtemUtilizador(nome);
		
		return utz;
		
		
		
	}
	
	
	/**
	 * Obtem uma instância do objeto CriarCaracteristicaHandler
	 */
	public CriarCaracteristicaHandler obtemCriarCaracteristicaHandler() {
		
		Utilizador utz = getAuthenticatedUser();
		if (utz instanceof Tecnico ) {
			CriarCaracteristicaHandler u = new CriarCaracteristicaHandler(catUnidades,catDescrCaract,catTiposSensor);
			return u;
			
			
		}
		return null;
		
		
		
	}
	
	/**
	 * Obtem uma instância do objeto RecolherDadosHandler
	 */
	public RecolherDadosHandler obtemRecolherDadosHandler() {
		
		Utilizador utz = getAuthenticatedUser();
		
		if(utz instanceof Tecnico) {
			RecolherDadosHandler u = new RecolherDadosHandler(utz,catContexts);
			return u;
		}
		return null;
	}
	
	
	/**
	 * Obtem o catalogo das unidades de medida
	 */
	public CatalogoUnidades obtemCatalogoUnidades() {
		
		
		return catUnidades;
		
	}

}
