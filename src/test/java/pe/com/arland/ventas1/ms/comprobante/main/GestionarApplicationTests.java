package pe.com.arland.ventas1.ms.comprobante.main;

import static org.junit.jupiter.api.Assertions.fail;

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
import pe.com.arland.cliente1.registro.entity.FacturaEntity;

@ExtendWith(SpringExtension.class)
@SpringBootTest 
//@ContextConfiguration(classes = GestionarApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class GestionarApplicationTests {

	@Autowired
	FacturaRepository facturaRepository;

	@Autowired
	MongoOperations mongoOps;
	  
	@Test
	 void contextLoads() {
		
		  String[] arrParComprobante = "20100010202-01-0020-348".split("-", 4);
	        String numeroRUC = arrParComprobante[0];
	        String tipoComprobante = arrParComprobante[1];
	        String serieComprobante = arrParComprobante[2];
	        String numeroComprobante = arrParComprobante[3];
	        long numComp = Long.parseLong(numeroComprobante);

	        Query query = new Query();

	        query.addCriteria(
	        		Criteria.where("idContribuyente").is(numeroRUC).
	        		and("tipoComprobante").is(tipoComprobante).
	        		and("serieComprobante").is(serieComprobante).
	        		and("numeroComprobante").is(numComp));
  
	        FacturaEntity facturaTest = mongoOps.findOne(query, FacturaEntity.class);
	        
	        Assert.isTrue(facturaTest.getMontoComprobante()>1000, "Factura no cumple condicion");

	}
	
	@EnabledIf(disabledReason = "#{'${spring.datasource.username}' != 'demo' }", value = "")
	@Test
	public void testIf1() {
	    fail("fail");
	}

	//@EnabledIf("#{systemProperties['java.version'].startsWith('1.8')}")
	@EnabledIf("#{systemProperties['os.name'].toLowerCase().contains('linux')}")
	@Test
	public void testIf2() {
	    fail("fail");
	}
}
