package pe.com.arland.ventas1.ms.comprobante.ws.rest;

public class Saludo {
	  private final long id;
	  private final String mesajeSaludo;

	  public Saludo(long id, String content) {
	    this.id = id;
	    this.mesajeSaludo = content;
	  }

	  public long getId() {
	    return id;
	  }

	  public String getContent() {
	    return mesajeSaludo;
	  }
}
