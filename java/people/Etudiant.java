package people;

public class Etudiant extends Personne{
  float note;

  public Etudiant(String nomPersonne, String prenomPersonne, int agePersonne, float noteEtudiant){
    super(nomPersonne, prenomPersonne, agePersonne);
    setNote(noteEtudiant);
  }

  public void setNote(float noteEtudiant){
    if(noteEtudiant > 0 && noteEtudiant < 20) note = noteEtudiant;
    else note = 0;
  }

  public String toString(){
    return(super.toString() + ", note: "+ note);
  }
}