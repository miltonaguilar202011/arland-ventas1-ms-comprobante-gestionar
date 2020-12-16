package pe.com.arland.ventas1.ms.comprobante.main;

import org.springframework.data.mongodb.repository.MongoRepository;

import pe.com.arland.cliente1.registro.entity.FacturaEntity;

public interface FacturaRepository  extends MongoRepository<FacturaEntity, String> {

}
