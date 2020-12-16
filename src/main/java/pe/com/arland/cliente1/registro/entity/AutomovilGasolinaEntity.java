package pe.com.arland.cliente1.registro.entity;

public class AutomovilGasolinaEntity extends VehiculoAutomovilBase 
{ 
  public AutomovilGasolinaEntity(String modelo, String 
    color, int potencia, double espacio)  
  {
    super(modelo,  color, potencia, espacio);
  }
 
  public void mostrarCaracteristicas() 
  { 
    System.out.println( 
      "Automovil de gasolina de modelo: " + modelo +  
      " de color: " + color + " de potencia: " + 
      potencia + " de espacio: " + espacio); 
  } 
}

