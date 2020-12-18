package pe.com.arland.ventas1.ms.comprobante.main;

//importaciones de la librer�a EasyMock que necesitamos /Dependemos en gran medida de las importaciones est�ticas.
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pe.com.arland.cliente1.registro.entity.FacturaEntity;
import pe.com.arland.cliente1.registro.entity.ItemComprobanteEntity;
import pe.com.arland.ventas1.ms.comprobante.main.FacturaRepository;

public class GV_TestFacturaServiceEasyMock {
	// Declaramos el objeto que nos gustar�a simular
	// Tenga en cuenta que nuestro AccountManager es una interfaz.
	// La raz�n es simple: el marco b�sico de EasyMock solo puede simular objetos de
	// interfaz.
	private FacturaRepository mockFacturaRepository;

	@BeforeEach
	public void setUp() {
		// Llamamos al createMock m�todo para crear un simulacro de la clase que
		// queremos
		mockFacturaRepository = createMock("mockFacturaRepository", FacturaRepository.class);
	}

	@Test
	public void testOk() {
		// creamos dos objetos de cuenta que usaremos en nuestras pruebas

		// Start defining the expectations

		//mockFacturaRepository.save(getFactura1());
		//mockFacturaRepository.save(getFactura2());

		// declaramos las expectativas de dos formas. Cuando el tipo
		// de retorno del m�todo es nulo, lo llamamos en el objeto simulado
		// o cuando el m�todo devuelve cualquier tipo de objeto, usamos los
		// expect-andReturn m�todos de la API EasyMock

		expect(mockFacturaRepository.findById("abc001")).andReturn(getFactura1());

        //Cuando terminamos de definir las expectativas, llamamos al replay m�todo. 
        //El replay m�todo pasa el simulacro desde la fase en la que registramos el m�todo que esperamos 
        //que sea llamado hasta donde probamos. 
        //Antes, simplemente registr�bamos el comportamiento, pero el objeto no funcionaba como una simulaci�n. 
        //Despu�s de llamar replay, el objeto funciona como se esperaba
        replay(mockFacturaRepository);                                   
 
        FacturaEntity factura  = mockFacturaRepository.findById("abc001").get();
        assertNotNull(factura);
 
	}

	// El @AfterEach m�todo que se ejecuta despu�s de cada @Test m�todo contiene la
	// verificaci�n de las expectativas.
	// Con EasyMock, podemos llamar al m�todo verify con cualquier objeto simulado
	// para verificar que las expectativas de llamada al m�todo que declaramos se
	// activaron.
	// Incluir la verificaci�n en el @AfterEach m�todo nos permite introducir nuevas
	// pruebas f�cilmente,
	// y de ahora en adelante confiaremos en la ejecuci�n del verify m�todo.
	@AfterEach
	public void tearDown() {
		verify(mockFacturaRepository);
	}

	private Optional<FacturaEntity> getFactura1() {
		// COLECCION DE ITEMS REFERENTES
		ItemComprobanteEntity item1 = new ItemComprobanteEntity(1000, "P0001", "Item1", 20d, 24.5d, 50.0d);
		ItemComprobanteEntity item2 = new ItemComprobanteEntity(1000, "P0003", "Item2", 90d, 23.5d, 88.0d);
		List<ItemComprobanteEntity> itemList = new ArrayList<>();
		itemList.add(item1);
		itemList.add(item2);

		// COLECCION DE FACTURAS
		FacturaEntity factura = new FacturaEntity("20100010202", "01", "0020", (long) 345, 14850.0, "CLI0002",
				"EMP0023", new Date(), new Date(), "01", itemList, 14850 * 0.18, "22039393949");
		factura.setId("abc001");
		Optional<FacturaEntity> f = Optional.ofNullable(factura);
		return f;
	};

}