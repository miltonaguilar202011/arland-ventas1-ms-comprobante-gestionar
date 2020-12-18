package pe.com.arland.cliente1.registro.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comprobantes")
public class FacturaEntity extends ComprobanteBase {
	
	@Id
	private String id;

	private Double importeIVA;
	private String idContribuyenteCliente;
	public Double getImporteIVA() {
		return importeIVA;
	}
	public void setImporteIVA(Double importeIVA) {
		this.importeIVA = importeIVA;
	}
	public String getIdContribuyenteCliente() {
		return idContribuyenteCliente;
	}
	public void setIdContribuyenteCliente(String idContribuyenteCliente) {
		this.idContribuyenteCliente = idContribuyenteCliente;
	}
	
	public FacturaEntity() {}
	
	public FacturaEntity(String idContribuyente, String tipoComprobante, String serieComprobante,
			Long numeroComprobante, Double montoComprobante, String idCliente, String idEmpleado, Date fechaRegistro,
			Date fechaCancelacion, String estadoComprobante, 
			List<ItemComprobanteEntity> items, 
			Double importeIVA,
			String idContribuyenteCliente) {
		super(idContribuyente, tipoComprobante, serieComprobante, numeroComprobante, montoComprobante, idCliente,
				idEmpleado, fechaRegistro, fechaCancelacion, estadoComprobante
				, items
				);
		this.importeIVA = importeIVA;
		this.idContribuyenteCliente = idContribuyenteCliente;
	}

	
	@Override
	public String toString() {
		return "FacturaEntity [id=" + id + 
				", importeIVA=" + importeIVA + 
				", idContribuyenteCliente="	+ idContribuyenteCliente +  
				",idContribuyente=" + super.getIdContribuyente() +
				", tipoComprobante=" + super.getTipoComprobante() 	+ 
				", serieComprobante=" + super.getSerieComprobante() + 
				", numeroComprobante=" + super.getNumeroComprobante() + 
				", montoComprobante=" + super.getMontoComprobante() + 
				", idCliente=" + super.getIdCliente() + 
				", idEmpleado=" + super.getIdEmpleado() + 
				", fechaRegistro=" + super.getFechaRegistro() + 
				", fechaCancelacion=" + super.getFechaCancelacion() + 
				", estadoComprobante="+ super.getEstadoComprobante() +
				"]";

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	
}
