package pe.com.arland.cliente1.registro.entity;

public class ScooterGasolinaEntity extends VehiculoScooterBase 
{ 
  public ScooterGasolinaEntity(String modelo, String color, 
    int potencia) 
  {
    super(modelo, color, potencia); 
  }
 
  public void mostrarCaracteristicas() 
  { 
    System.out.println("Scooter de gasolina de modelo: " + 
      modelo + " de color: " + color +  
      " de potencia: " + potencia); 
  } 
 
}
