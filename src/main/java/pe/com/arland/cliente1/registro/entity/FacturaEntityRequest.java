package pe.com.arland.cliente1.registro.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class FacturaEntityRequest  {

	private String id;

	private Double importeIVA;
	private String idContribuyenteCliente;
	public Double getImporteIVA() {
		return importeIVA;
	}
	private String idContribuyente;
	private String tipoComprobante;
	private String serieComprobante;
	private Long numeroComprobante;
	private Double montoComprobante;
	private String idCliente;
	private String idEmpleado;
	private Date fechaRegistro;
	private Date fechaCancelacion;
	private String estadoComprobante;
	
	private List<ItemComprobanteEntity> items  = new ArrayList<ItemComprobanteEntity>();
	public void setImporteIVA(Double importeIVA) {
		this.importeIVA = importeIVA;
	}
	public String getIdContribuyenteCliente() {
		return idContribuyenteCliente;
	}
	public void setIdContribuyenteCliente(String idContribuyenteCliente) {
		this.idContribuyenteCliente = idContribuyenteCliente;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdContribuyente() {
		return idContribuyente;
	}
	public void setIdContribuyente(String idContribuyente) {
		this.idContribuyente = idContribuyente;
	}
	public String getTipoComprobante() {
		return tipoComprobante;
	}
	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public String getSerieComprobante() {
		return serieComprobante;
	}
	public void setSerieComprobante(String serieComprobante) {
		this.serieComprobante = serieComprobante;
	}
	public Long getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(Long numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	public Double getMontoComprobante() {
		return montoComprobante;
	}
	public void setMontoComprobante(Double montoComprobante) {
		this.montoComprobante = montoComprobante;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}
	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
	public String getEstadoComprobante() {
		return estadoComprobante;
	}
	public void setEstadoComprobante(String estadoComprobante) {
		this.estadoComprobante = estadoComprobante;
	}
	public List<ItemComprobanteEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemComprobanteEntity> items) {
		this.items = items;
	}
	
	

	


	
}
