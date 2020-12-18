package pe.com.arland.ventas1.ms.comprobante.main;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;   

//Como es habitual, comenzamos importando todos los objetos que necesitamos
//Este ejemplo no se basa en funciones de importación estáticas.
import org.mockito.Mock;                                               
import org.mockito.Mockito;                                             
import org.mockito.junit.jupiter.MockitoExtension;

import pe.com.arland.cliente1.registro.entity.Account;
import pe.com.arland.cliente1.registro.service.AccountManager;
import pe.com.arland.cliente1.registro.service.AccountService;                      
 
//Extendemos esta prueba usando MockitoExtension  
//@ExtendWith es una anotación repetible que se utiliza para registrar extensiones
//para la clase de prueba anotada o el método de prueba. 


@ExtendWith(MockitoExtension.class)                                     
public class TestAccountServiceMockito
{
 
	// Para este ejemplo de Mockito, 
	//solo notaremos que esta extensión es necesaria para crear objetos simulados a 
	//través de anotaciones . 
	//Este código le dice a Mockito que cree un objeto de tipo simulado AccountManager. 
    @Mock                                                               
    private AccountManager mockAccountManager;                         
 
    @Test
    public void testTransferOk()
    {
        //Como en los listados anteriores, declaramos dos cuentas entre 
        //las que vamos a transferir dinero 
        Account senderAccount = new Account( "1", 200 );                
        Account beneficiaryAccount = new Account( "2", 100 );           
 
        //Comenzamos declarando las expectativas usando el método when  
        //Además, utilizamos el lenient método para modificar el rigor de la burla de objetos. 
        //Sin este método, solo se permite una declaración de expectativa para el mismo
        //findAccountForUser método, mientras que necesitamos dos (una para el "1"
        //argumento y otra para el "2" argumento)
        Mockito.lenient()
           .when(mockAccountManager.findAccountForUser("1"))            
           .thenReturn(senderAccount);                                 
        Mockito.lenient()                                              
           .when(mockAccountManager.findAccountForUser("2"))            
           .thenReturn(beneficiaryAccount);                             
 
        AccountService accountService = new AccountService();
        accountService.setAccountManager( mockAccountManager );
        
        //Iniciamos la transferencia de una cuenta a otra 
        accountService.transfer( "1", "2", 50 );                        
 
      //Afirmamos los resultados esperados 
        assertEquals( 150, senderAccount.getBalance() );                
        assertEquals( 150, beneficiaryAccount.getBalance() );           
    }
    
}
