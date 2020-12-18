package pe.com.arland.ventas1.ms.comprobante.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pe.com.arland.cliente1.registro.entity.Account;
import pe.com.arland.cliente1.registro.service.AccountManager;
import pe.com.arland.cliente1.registro.service.AccountService;

//importaciones de la librer�a EasyMock que necesitamos /Dependemos en gran medida de las importaciones est�ticas.
import static org.easymock.EasyMock.createMock;                         
import static org.easymock.EasyMock.replay;                            
import static org.easymock.EasyMock.expect;                             
import static org.easymock.EasyMock.verify;                            


public class TestAccountServiceEasyMock
{
	//Declaramos el objeto que nos gustar�a simular 
	//Tenga en cuenta que nuestro AccountManager es una interfaz. 
	//La raz�n es simple: el marco b�sico de EasyMock solo puede simular objetos de interfaz.
    private AccountManager mockAccountManager;                          
 

    @BeforeEach
    public void setUp()
    {
    	//Llamamos al createMock m�todo para crear un simulacro de la clase que queremos
        mockAccountManager = createMock( "mockAccountManager",AccountManager.class ); 
    }

    @Test
    public void testTransferOk()
    {
    	//creamos dos objetos de cuenta que usaremos en nuestras pruebas 
        Account senderAccount = new Account( "1", 200 );                
        Account beneficiaryAccount = new Account( "2", 100 );           
 
        // Start defining the expectations
        mockAccountManager.updateAccount(senderAccount);              
        mockAccountManager.updateAccount(beneficiaryAccount);         
 
        //declaramos las expectativas de dos formas. Cuando el tipo 
        //de retorno del m�todo es nulo, lo llamamos en el objeto simulado 
        //o cuando el m�todo devuelve cualquier tipo de objeto, usamos los expect-andReturn m�todos de la API EasyMock
        expect(mockAccountManager.findAccountForUser("1")).andReturn(senderAccount);       
        expect(mockAccountManager.findAccountForUser("2")).andReturn(beneficiaryAccount);  
        
        //Cuando terminamos de definir las expectativas, llamamos al replay m�todo. 
        //El replay m�todo pasa el simulacro desde la fase en la que registramos el m�todo que esperamos 
        //que sea llamado hasta donde probamos. 
        //Antes, simplemente registr�bamos el comportamiento, pero el objeto no funcionaba como una simulaci�n. 
        //Despu�s de llamar replay, el objeto funciona como se esperaba
        replay(mockAccountManager);                                   
 
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager); 
        
        //Llamamos al transfer m�todo para transferir algo de dinero entre las dos cuentas
        accountService.transfer( "1", "2", 50 );                        
 
        //Afirmamos el resultado esperado
        assertEquals( 150, senderAccount.getBalance() );                
        assertEquals( 150, beneficiaryAccount.getBalance() );           
    }
 
    //El @AfterEach m�todo que se ejecuta despu�s de cada @Test m�todo contiene la verificaci�n de las expectativas.
    //Con EasyMock, podemos llamar al  m�todo verify con cualquier objeto simulado 
    // para verificar que las expectativas de llamada al m�todo que declaramos se activaron. 
    //Incluir la verificaci�n en el @AfterEach m�todo nos permite introducir nuevas pruebas f�cilmente,
    //y de ahora en adelante confiaremos en la ejecuci�n del verify m�todo.
    @AfterEach
    public void tearDown()
    {
        verify( mockAccountManager );                                  
    }

}