package pe.com.arland.ventas1.ms.comprobante.main;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;                                               
import org.mockito.Mockito;                                             
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.junit.platform.runner.JUnitPlatform;
import pe.com.arland.cliente1.registro.entity.FacturaEntity;
import pe.com.arland.cliente1.registro.entity.ItemComprobanteEntity;

//JUNIT4
@RunWith(MockitoJUnitRunner.class)
//JUNIT5
//@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
public class DataMockitoTests {

	    //@InjectMocks
	    //private FacturaRepository facturaService;
	 
	    @Mock
	    private FacturaRepository facturaService;
	 
	    @Test
	    public void testCallMocks() {
	        when(facturaService.findAll()).thenReturn(todasLasFaturas());
	        
	        
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
					  "EMP0023" , new Date(),new Date() ,"01" ,itemList,  14850*0.18,"22039393949"));
			  
			  facturaList.add(new FacturaEntity("20100010202","01","0020",(long) 346 , 14850.0 , "CLI0002" , 
					  "EMP0001" , new Date(),new Date() ,"01" ,itemList,  14850*0.18,"10299293999"));
			  return facturaList;
	    };
	 

}
