package pe.com.arland.cliente1.registro.entity;

import java.util.Date;
import java.util.List;

public class BoletaEntity extends ComprobanteBase  {

	public BoletaEntity(String idContribuyente, String tipoComprobante, String serieComprobante, Long numeroComprobante,
			Double montoComprobante, String idCliente, String idEmpleado, Date fechaRegistro, Date fechaCancelacion,
			String estadoComprobante
			, List<ItemComprobanteEntity> items
			) {
		super(idContribuyente, tipoComprobante, serieComprobante, numeroComprobante, montoComprobante, idCliente, idEmpleado,
				fechaRegistro, fechaCancelacion, estadoComprobante
				, items
				);
		// TODO Auto-generated constructor stub
	}

}
