package pe.com.arland.ventas1.ms.comprobante.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Como siempre, vamos importando todos los objetos que necesitemos. 
// A diferencia EasyMock, el JMock marco no se basa en ninguna característica de importación estática.
import org.jmock.Expectations;                                          
import org.jmock.Mockery;                                              
import org.jmock.junit5.JUnit5Mockery;                                 


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import pe.com.arland.cliente1.registro.entity.Account;
import pe.com.arland.cliente1.registro.service.AccountManager;
import pe.com.arland.cliente1.registro.service.AccountService;

public class TestAccountServiceJMock
{

	// JUnit5 proporciona una forma programática de registrar extensiones. 
	// Para JMock, de esta manera se anota un campo de instancia no privado JUnit5Mockery 
	// con @RegisterExtension.  
	// El objeto de contexto nos sirve para crear simulaciones y definir expectativas 
    @RegisterExtension                                                  
    Mockery context = new JUnit5Mockery();                             
	
	//Declaramos el AccountManager que nos gustaría burlarnos (Reemplar)
   // Al igual que EasyMock, el marco principal de JMock solo proporciona burlas de interfaces.
    private AccountManager mockAccountManager;                         

	//En el @BeforeEach método que se ejecuta antes de cada uno de los @Test métodos, 
    //creamos el simulacro mediante programación mediante el objeto de contexto.
    @BeforeEach
    public void setUp()
    {
        mockAccountManager = context.mock( AccountManager.class );      
    }
	

    @Test
    public void testTransferOk()
    {
    	//Como en listados anteriores, declaramos dos cuentas entre 
    	//las que vamos a transferir dinero
        Account senderAccount = new Account( "1", 200 );                
        Account beneficiaryAccount = new Account( "2", 100 );           
 
        //Comenzamos a declarar las expectativas construyendo un nuevo
        //objeto Expectations
        context.checking( new Expectations()                            
        {
            {
            	//Declaramos la primera expectativa y cada expectativa tiene la forma
                oneOf( mockAccountManager ).findAccountForUser( "1" );  
                will( returnValue( senderAccount ) );                   
                oneOf( mockAccountManager ).findAccountForUser( "2" );
                will( returnValue( beneficiaryAccount ) );
 
                oneOf( mockAccountManager ).updateAccount( senderAccount );
                oneOf( mockAccountManager ).updateAccount( beneficiaryAccount );
            }
        } );
 
        AccountService accountService = new AccountService();
        accountService.setAccountManager( mockAccountManager );
        
        //Iniciar la transferencia de una cuenta a la otra 
        accountService.transfer( "1", "2", 50 );                        
 
        //y luego afirmar los resultados esperados
        assertEquals( 150, senderAccount.getBalance() );                
        assertEquals( 150, beneficiaryAccount.getBalance() );          
    }

}