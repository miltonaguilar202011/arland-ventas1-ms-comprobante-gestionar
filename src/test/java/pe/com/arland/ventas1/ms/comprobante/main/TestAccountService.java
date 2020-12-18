package pe.com.arland.ventas1.ms.comprobante.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pe.com.arland.cliente1.registro.entity.Account;
import pe.com.arland.cliente1.registro.entity.FacturaEntity;
import pe.com.arland.cliente1.registro.service.AccountService;
import pe.com.arland.cliente1.registro.service.MockAccountManager;


@ExtendWith(SpringExtension.class)
@SpringBootTest 
//@ContextConfiguration(classes = GestionarApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class TestAccountService {
	  

	 @Test
	 public void testTransferOk() {
		 
		  //1 CONFIGURACION . SE ESTABLECE CON AYUDA DEL MOCK LAS CONDICIONES 
	      MockAccountManager mockAccountManager = new MockAccountManager(); 
	      
	      Account senderAccount = new Account("1", 200);                    
	      Account beneficiaryAccount = new Account("2", 100);               
	      
	      mockAccountManager.addAccount("1", senderAccount);                
	      mockAccountManager.addAccount("2", beneficiaryAccount);           
	      
	      AccountService accountService = new AccountService();             
	      
	      accountService.setAccountManager(mockAccountManager);
	      
	      //2 EJECUCION
	      accountService.transfer("1", "2", 50);                            
	      
	      //3 EVALUACION 
	      assertEquals(150, senderAccount.getBalance());                    
	      assertEquals(150, beneficiaryAccount.getBalance());               
	   }
	}
