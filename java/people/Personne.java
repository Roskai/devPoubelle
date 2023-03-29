package people;

public class Personne {
  private String nom;
  private String prenom;
  private int age;
  private int id;

  // Static Attribute
  private static int lastID = 0;

  public Personne(String nomPersonne, String prenomPersonne, int agePersonne){
    setNom(nomPersonne);
    setPrenom(prenomPersonne);
    setAge(agePersonne);
    id = lastID++;
  }

  // Static Methods 
  public static int getNombrePersonnes(){
    return lastID;
  }

  public String toString(){
    String output = "ID: " + id + ", Nom: "+nom+", Prenom:"+prenom+ ", Age:" +age;
    return output; 
  }

  public void setNom(String nomPersonne){
    nom = nomPersonne;
  }

  public void setPrenom(String prenomPersonne){
    prenom = prenomPersonne;
  }

  public void setAge(int agePersonne){
    if(agePersonne > 0 && agePersonne < 100) age = agePersonne;
    else age = 0;
  }
}