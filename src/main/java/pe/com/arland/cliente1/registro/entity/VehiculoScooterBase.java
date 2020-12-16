package pe.com.arland.cliente1.registro.entity;

public abstract class VehiculoScooterBase 
{ 
  protected String modelo; 
  protected String color; 
  protected int potencia; 
 
  public VehiculoScooterBase(String modelo, String color, int 
    potencia) 
  { 
    this.modelo = modelo; 
    this.color = color; 
    this.potencia = potencia; 
  } 
  public abstract void mostrarCaracteristicas(); 
} 
 
