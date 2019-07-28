package Date;

// C'est une Exception personalisé et lévé si la date de naissance d'un élève saisie par l'utilisateur est fausse
// Tout Exception doit hériter de la classe Exception dont son nom se termine par le mot "Exception"
public class WrongDateException extends Exception{
    public WrongDateException(){
      System.out.println("Date Invalide !");
    }
}
