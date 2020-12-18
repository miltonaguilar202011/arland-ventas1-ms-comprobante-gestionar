package pe.com.arland.cliente1.registro.service;

import pe.com.arland.cliente1.registro.entity.Account;


// ESTE ES EL SERVICIO QUE ESTA SOPORTADO POR UN ACUNT MANAGER QUE PUDO HABER SIDO UN SOPORTE DE DATOS
public class AccountService {
	
	//SOPORTE DE PERSISTENCIA
	private AccountManager accountManager;
	 
	
	// METODOS DEL SERVICIO
	public void setAccountManager(AccountManager manager) {
	      this.accountManager = manager;
	    }
	 
	public void transfer(String senderId, String beneficiaryId, long amount) {
	      Account sender = accountManager.findAccountForUser(senderId);
	      Account beneficiary = accountManager.findAccountForUser(beneficiaryId);
	 
	      sender.debit(amount);
	      beneficiary.credit(amount);
	      this.accountManager.updateAccount(sender);
	      this.accountManager.updateAccount(beneficiary);
	}
}
