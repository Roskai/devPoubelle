import transportation.*;

public class HelloVehicle{
  public static void main(String[] args){
    Bus monBus = new Bus (23);
    monBus.accelerer(45678);
    System.out.println(monBus);
  }
}