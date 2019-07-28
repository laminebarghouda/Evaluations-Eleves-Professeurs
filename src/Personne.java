package notesElevesProfesseurs;

/* Réponse à la Question 1
On va utiliser le concept d'héritage ici pour présenter la généricité entre les deux classes Eleve et Professeur qui possède des attributs et des méthodes en commun.
il sera aisé de réutiliser des composants existants et de leur ajouter un comportement.
Un gain de temps de développement, amélioration de la qualité du code, création de hiérarchies de classes reflétant précisément le domaine d'étude sont bien les avantages
de l’utilisation de l’héritage.
De plus, la modification de la superclasse (Personne) impliquera la modification automatique de toutes les sous-classes (Eleve et Professeur)
*/


public class Personne {
    private String nom;
    private  String prenom;

    // Constructeur
    public Personne(String nom,String prenom){
        this.nom=nom;
        this.prenom=prenom;
    }
    // Accesseur en lecture à l'attribut nom
    public String getNom(){
        return nom;
    }

    // Accesseur en lecture à l'attribut prenom
    public String getPrenom(){
        return prenom;
    }

    // Rédefinition de la méthode toString
    @Override
    public String toString(){
        return "("+prenom+", "+nom+")";
    }

    // Rédefinition de la méthode hashCode
    @Override
    public int hashCode() {
        return nom.hashCode() * prenom.hashCode();
    }
}
