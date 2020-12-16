package pe.com.arland.cliente1.registro.entity;

public class ItemComprobanteEntity {

	private Integer ordItem;
	private String idProducto;
	private String detalle;
	private Double cantidad;
	private Double costoUnitario;
	private Double importeParcial;
	
	public Integer getOrdItem() {
		return ordItem;
	}

	public void setOrdItem(Integer ordItem) {
		this.ordItem = ordItem;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(Double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public Double getImporteParcial() {
		return importeParcial;
	}

	public void setImporteParcial(Double importeParcial) {
		this.importeParcial = importeParcial;
	}

	public ItemComprobanteEntity(Integer ordItem, String idProducto, String detalle, Double cantidad,
			Double costoUnitario, Double importeParcial) {
		super();
		this.ordItem = ordItem;
		this.idProducto = idProducto;
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
		this.importeParcial = importeParcial;
	}



}
