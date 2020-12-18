package pe.com.arland.cliente1.registro.service;

import pe.com.arland.cliente1.registro.entity.Account;

// INTERFASE DE GESTOR DE CUENTAS - SU IMPLEMENTACION PUEDE SER CON JNDI O CUALQUIER REPOSITORIO
public interface AccountManager {
	  Account findAccountForUser(String userId);
      void updateAccount(Account account);
}
