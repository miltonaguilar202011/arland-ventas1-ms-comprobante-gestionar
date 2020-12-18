package pe.com.arland.ventas1.ms.comprobante.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//Como siempre, vamos importando todos los objetos que necesitemos. 
//A diferencia EasyMock, el JMock marco no se basa en ninguna característica de importación estática.
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import pe.com.arland.cliente1.registro.entity.FacturaEntity;
import pe.com.arland.cliente1.registro.entity.ItemComprobanteEntity;
import pe.com.arland.ventas1.ms.comprobante.main.FacturaRepository;

public class GV_TestFacturaServiceJMock {

	// JUnit5 proporciona una forma programática de registrar extensiones.
	// Para JMock, de esta manera se anota un campo de instancia no privado
	// JUnit5Mockery
	// con @RegisterExtension.
	// El objeto de contexto nos sirve para crear simulaciones y definir
	// expectativas
	@RegisterExtension
	Mockery context = new JUnit5Mockery();

	// Declaramos el AccountManager que nos gustaría burlarnos (Reemplar)
// Al igual que EasyMock, el marco principal de JMock solo proporciona burlas de interfaces.
	private FacturaRepository mockFacturaRepository;

	// En el @BeforeEach método que se ejecuta antes de cada uno de los @Test
	// métodos,
	// creamos el simulacro mediante programación mediante el objeto de contexto.
	@BeforeEach
	public void setUp() {
		mockFacturaRepository = context.mock(FacturaRepository.class);
	}

	@Test
	public void testOk() {
		// Como en listados anteriores, declaramos dos cuentas entre
		// las que vamos a transferir dinero

		
		// Comenzamos a declarar las expectativas construyendo un nuevo
		// objeto Expectations
		context.checking(new Expectations() {
			{
				// Declaramos la primera expectativa y cada expectativa tiene la forma
				oneOf(mockFacturaRepository).findById("abc001");
				will(returnValue(getFactura1()));
			}
		});

        FacturaEntity factura  = mockFacturaRepository.findById("abc001").get();
        assertEquals( "abc001", factura.getId());
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