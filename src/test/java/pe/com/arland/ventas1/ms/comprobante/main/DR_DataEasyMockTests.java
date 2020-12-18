package pe.com.arland.ventas1.ms.comprobante.main;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;

import pe.com.arland.cliente1.registro.entity.FacturaEntity;
//import pe.com.arland.cliente1.registro.entity.FacturaEntity;
import pe.com.arland.cliente1.registro.entity.ItemComprobanteEntity;
//import pe.com.arland.ventas1.repository.mongodb.FacturaRepository;

//@RunWith(EasyMockRunner.class)
public class DR_DataEasyMockTests {

	    private FacturaRepository facturaService;
	    
	    @BeforeEach
	    public void setUp()
	    {
	    	//Llamamos al createMock método para crear un simulacro de la clase que queremos
	    	//facturaService = createMock( "facturaService", FacturaRepository.class );
	    	facturaService = EasyMock.createMock(FacturaRepository.class);
	    }
	 
	    @Test
	    public void testCallMocks() {
	    	facturaService = EasyMock.createMock(FacturaRepository.class);
	    	
	        expect(facturaService.findAll()).andReturn(todasLasFaturas());       
	        
	        replay(facturaService); 
	        
	        List<FacturaEntity> facturaListtotal  = facturaService.findAll();
	        int numFacturas =  facturaListtotal.size();
	        assertEquals(2,numFacturas);
	    }
	 
	    private List<FacturaEntity> todasLasFaturas() {
      	  //COLECCION DE ITEMS REFERENTES 
      	  ItemComprobanteEntity item1 = new ItemComprobanteEntity(1000, "P0001", "Item1", 20d, 24.5d, 50.0d);
			  ItemComprobanteEntity item2 = new ItemComprobanteEntity(1000, "P0003", "Item2", 90d, 23.5d, 88.0d);
			  List<ItemComprobanteEntity> itemList = new ArrayList<>();
			  itemList.add(item1);	
			  itemList.add(item1);
			  
			  //COLECCION DE FACTURAS
			  List<FacturaEntity> facturaList = new ArrayList<>();
			  
			  facturaList.add(new FacturaEntity("20100010202","01","0020",(long) 345 , 14850.0 , "CLI0002" , 
					  "EMP0023" , new Date(),new Date() ,"01", itemList, 14850*0.18,"22039393949" ));
			  
			  facturaList.add(new FacturaEntity("20100010202","01","0020",(long) 346 , 14850.0 , "CLI0002" , 
					  "EMP0001" , new Date(),new Date() ,"01",itemList,  14850*0.18,"10299293999"));
			  return facturaList;
	    };
	 
	    @AfterEach
	    public void tearDown()
	    {
	        verify( facturaService );                                  
	    }

}
