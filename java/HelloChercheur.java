import people.*;

public class HelloChercheur {
  
  public static void main(String[] args){
    IChercheur ensChercheur = new EnseignentChercheur("Dupont", "Jean", 20);

    System.out.println("Hello Chercheur "+ ensChercheur);
    System.out.println();

    ensChercheur.ajuterPublication("Using Interfaces in Java, Dupont J., 2021");

    System.out.println("Hello Chercheur "+ensChercheur);
    System.out.println();
    System.out.println("Total de personnes: " +Personne.getNombrePersonnes());
  }
}