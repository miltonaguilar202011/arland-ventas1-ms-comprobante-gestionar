package pe.com.arland.ventas1.ms.comprobante.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pe.com.arland.cliente1.registro.entity.Account;
import pe.com.arland.cliente1.registro.service.AccountManager;
import pe.com.arland.cliente1.registro.service.AccountService;

//importaciones de la librería EasyMock que necesitamos /Dependemos en gran medida de las importaciones estáticas.
import static org.easymock.EasyMock.createMock;                         
import static org.easymock.EasyMock.replay;                            
import static org.easymock.EasyMock.expect;                             
import static org.easymock.EasyMock.verify;                            


public class TestAccountServiceEasyMock
{
	//Declaramos el objeto que nos gustaría simular 
	//Tenga en cuenta que nuestro AccountManager es una interfaz. 
	//La razón es simple: el marco básico de EasyMock solo puede simular objetos de interfaz.
    private AccountManager mockAccountManager;                          
 

    @BeforeEach
    public void setUp()
    {
    	//Llamamos al createMock método para crear un simulacro de la clase que queremos
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
        //de retorno del método es nulo, lo llamamos en el objeto simulado 
        //o cuando el método devuelve cualquier tipo de objeto, usamos los expect-andReturn métodos de la API EasyMock
        expect(mockAccountManager.findAccountForUser("1")).andReturn(senderAccount);       
        expect(mockAccountManager.findAccountForUser("2")).andReturn(beneficiaryAccount);  
        
        //Cuando terminamos de definir las expectativas, llamamos al replay método. 
        //El replay método pasa el simulacro desde la fase en la que registramos el método que esperamos 
        //que sea llamado hasta donde probamos. 
        //Antes, simplemente registrábamos el comportamiento, pero el objeto no funcionaba como una simulación. 
        //Después de llamar replay, el objeto funciona como se esperaba
        replay(mockAccountManager);                                   
 
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager); 
        
        //Llamamos al transfer método para transferir algo de dinero entre las dos cuentas
        accountService.transfer( "1", "2", 50 );                        
 
        //Afirmamos el resultado esperado
        assertEquals( 150, senderAccount.getBalance() );                
        assertEquals( 150, beneficiaryAccount.getBalance() );           
    }
 
    //El @AfterEach método que se ejecuta después de cada @Test método contiene la verificación de las expectativas.
    //Con EasyMock, podemos llamar al  método verify con cualquier objeto simulado 
    // para verificar que las expectativas de llamada al método que declaramos se activaron. 
    //Incluir la verificación en el @AfterEach método nos permite introducir nuevas pruebas fácilmente,
    //y de ahora en adelante confiaremos en la ejecución del verify método.
    @AfterEach
    public void tearDown()
    {
        verify( mockAccountManager );                                  
    }

}