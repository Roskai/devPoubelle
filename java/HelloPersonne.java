import people.*;

public class HelloPersonne{

  public static void main(String[] args) {
   Personne personne = new Personne("Dupont", "Jean", 20);
   System.out.println("Hello Personne " + personne);

   Etudiant etudiant = new Etudiant("Perez", "Juan", 30, 15.0f);
   System.out.println("Hello Personne " + etudiant);

   System.out.println("Total de personnes " + Personne.getNombrePersonnes());
  }
}