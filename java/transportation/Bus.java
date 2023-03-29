package transportation;

public class Bus implements IVehicle {
  private int numBus;
  private int vitesseBus;

  public int getNumBus() {
    return numBus;
  }

  public void setNumBus(int numBus) {
    this.numBus = numBus;
  }

  public int getVitesseBus() {
    return vitesseBus;
  }

  public void setVitesseBus(int vitesseBus) {
    this.vitesseBus = vitesseBus;
  }

  public Bus(int numBus) {
    setNumBus(numBus);
    setVitesseBus(0);
  }

  @Override
  public void freiner(int a) {
    if (getVitesseBus() >= a) {
      setVitesseBus(0);
    } else {
      setVitesseBus(vitesseBus -= a);
    }
  }

  @Override
  public void accelerer(int b) {
    setVitesseBus(vitesseBus += b);
  }

  @Override 
  public String toString(){
    return "Le bus numéro : "+getNumBus()+" roule à "+getVitesseBus()+" km/h";
  }
}