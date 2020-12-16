package pe.com.arland.cliente1.registro.entity;
public abstract class VehiculoAutomovilBase 
{ 
  protected String modelo; 
  protected String color; 
  protected int potencia; 
  protected double espacio; 
 
  public VehiculoAutomovilBase(String modelo, String color, int 
    potencia, double espacio) 
  { 
    this.modelo = modelo; 
    this.color = color; 
    this.potencia = potencia; 
    this.espacio = espacio; 
  } 
 
  public abstract void mostrarCaracteristicas(); 
} 

