package pe.com.arland.ventas1.ms.comprobante.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"pe.com.arland.cliente1.registro.entity",
		"pe.com.arland.ventas1.repository.mongodb",
		"pe.com.arland.ventas1.ms.comprobante.ws.rest",
		"pe.com.arland.cliente1.registro.component",
		"pe.com.arland.cliente1.registro.service",

		})
public class GestionarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionarApplication.class, args);
		
		System.out.println("Hello World");
	}

}
