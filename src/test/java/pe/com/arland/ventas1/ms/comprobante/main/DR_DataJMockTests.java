package pe.com.arland.ventas1.ms.comprobante.main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import pe.com.arland.cliente1.registro.entity.FacturaEntity;
import pe.com.arland.cliente1.registro.entity.ItemComprobanteEntity;
//import pe.com.arland.ventas1.repository.mongodb.FacturaRepository;


public class DR_DataJMockTests {

		@RegisterExtension                                                  
	    Mockery context = new JUnit5Mockery();
	 
	    private FacturaRepository facturaService;
	    
	    @BeforeEach
	    public void setUp()
	    {
	    	facturaService = context.mock( FacturaRepository.class );      
	    }
	 
	    @Test
	    public void testCallMocks() {
	    	facturaService = context.mock( FacturaRepository.class );
	    	context.checking( new Expectations()                            
	        {
	            {
	            	//Declaramos la primera expectativa y cada expectativa tiene la forma
	                oneOf( facturaService ).findAll();  
	                will( returnValue( todasLasFaturas() ));
	            }
	        } );
	    	
	        
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
					  "EMP0023" , new Date(),new Date() ,"01", itemList, 14850*0.18,"22039393949"));
			  
			  facturaList.add(new FacturaEntity("20100010202","01","0020",(long) 346 , 14850.0 , "CLI0002" , 
					  "EMP0001" , new Date(),new Date() ,"01", itemList, 14850*0.18,"10299293999"));
			  return facturaList;
	    };
	 

}
