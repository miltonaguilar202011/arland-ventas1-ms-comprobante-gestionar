package pe.com.arland.ventas1.ms.comprobante.main;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.com.arland.cliente1.registro.component.MessageComponent;

@SpringBootApplication(scanBasePackages={
		"pe.com.arland.cliente1.registro.entity",
		"pe.com.arland.ventas1.repository.mongodb",
		"pe.com.arland.ventas1.ms.comprobante.ws.rest",
		"pe.com.arland.cliente1.registro.component",
		"pe.com.arland.cliente1.registro.service",

		})
public class GestionarApplication {

	
	final Logger log = LoggerFactory.getLogger(GestionarApplication.class);
	
	@Autowired
    public MessageComponent messageComponent;

    @PostConstruct
    private void setup() {
        log.info("*** {} ***", messageComponent.getMessage());
    }
	
	public static void main(String[] args) {
		SpringApplication.run(GestionarApplication.class, args);
		
		System.out.println("Hello World");
	}

}
