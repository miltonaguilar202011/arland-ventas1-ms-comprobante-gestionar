package pe.com.arland.cliente1.registro.service;

import java.util.HashMap;
import java.util.Map;

import pe.com.arland.cliente1.registro.entity.Account;

//MOCK QUE IMPLEMENTA LA INTERFASE Y PERMITE LA INCLUSION INTERMEDIA DE PRUEBAS 
public class MockAccountManager implements AccountManager {

	//SOPORTE DE PERSISTENCIA
	private Map<String, Account> accounts = new HashMap<String, Account>();

	
	// METODOS DE PERSISTENCIA IMPLEMENTADOS
	public void addAccount(String userId, Account account) {               
        this.accounts.put(userId, account);                              
    }                                                                    
 
    public Account findAccountForUser(String userId) {                 
        return this.accounts.get(userId);                              
    }                                                                    
 
    // METODOS QUE PODRIAN NO ESTARLO Y SIMPLEMENTE NO HACEN NADA
    public void updateAccount(Account account) {                       
       // do nothing                                                    
    }                                                                    


}
