package people;

public class EnseignentChercheur extends Personne implements IChercheur{

  private String[] publications;
  private int pos;

  public EnseignentChercheur(String nomPersonne, String prenomPersonne, int agePersonne){
    super(nomPersonne, prenomPersonne, agePersonne);
    publications = new String[10];
    pos = 0;
  }

  public void ajuterPublication(String publication){
    if (pos < 10) publications[pos++] = publication;
  } 

  public String getPublications(){
    String listePublications = "";
    
    for (int i = 0; i < pos; i++){
      listePublications = listePublications + publications[i] + ", ";
    }
    return listePublications;   
  }

  public String toString(){
    return (super.toString() + ", Liste de publications : " + getPublications());

  }

}
