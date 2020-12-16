package pe.com.arland.cliente1.registro.entity;

public class ScooterElectricidadEntity extends VehiculoScooterBase 
{ 
  public ScooterElectricidadEntity(String modelo, String color, 
    int potencia) 
  { 
    super(modelo, color, potencia);
  } 
 
  public void mostrarCaracteristicas() 
  { 
    System.out.println("Scooter electrica de modelo: " + 
      modelo + " de color: " + color +  
      " de potencia: " + potencia); 
  } 
 
} 
