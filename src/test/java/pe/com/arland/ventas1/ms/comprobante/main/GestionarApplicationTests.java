package pe.com.arland.ventas1.ms.comprobante.main;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
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
	
	@Test
	public void main() {
		String valorTexto = "'Hello World'";
		ExpressionParser parser = new SpelExpressionParser();
		System.out.println("************* Value ****************");
		Expression exp4 = parser.parseExpression(valorTexto);
		String message4 = (String) exp4.getValue();
		System.out.println(parser.parseExpression(valorTexto).getValue());
		System.out.println("Mensaje: "+ message4);
		
		System.out.println("************* Concat ****************");
		Expression exp3 = parser.parseExpression(valorTexto+".concat('!')");
		String message3 = (String) exp3.getValue();
		System.out.println(message3);
		
		
		System.out.println("************* Bytes ****************");
		Expression exp2 = parser.parseExpression(valorTexto+".bytes");
		byte[] bytes = (byte[]) exp2.getValue();
		for(int i=0;i<bytes.length;i++){
			System.out.println(bytes[i]+" ");
			}
		
		System.out.println("************* UpperCase ****************");
		Expression exp1 = parser.parseExpression("new String("+valorTexto+").toUpperCase()");
		String message1 = exp1.getValue(String.class);
		System.out.println(message1);
			
		System.out.println("************* Length ****************");
		Expression exp = parser.parseExpression(valorTexto+".bytes.length");
		int length = (Integer) exp.getValue();
		System.out.println(length);
		
	}
	@Value("\"#{'${findFactura.idEmpleado}'}\"")
	@Test
	public void main2() {
		System.out.println("************* Prueba2 ****************");
		Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("5fda2ae4f84f295fea58363d"));
        FacturaEntity findFactura = mongoOps.findOne(query, FacturaEntity.class);
        System.out.println("IdEmpleado: "+ findFactura.getIdEmpleado());
        
	}
}
