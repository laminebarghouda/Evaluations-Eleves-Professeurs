package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collections;

public class Promotion{
    private String nom; // Nom de la promotion
    ArrayList<Eleve> eleves; // liste des élèves de la promotion

    // Constructeur
    public Promotion(String nom){
        this.nom = nom;
        eleves = new ArrayList<Eleve>();
    }


    // Accesseur en lecture à l'attribut nom
    public String getNom(){
        return nom;
    }

    /// Accesseur en écriture à l'attribut nom
    public void setNom(String nom){
        this.nom=nom;
    }

    // Accesseur en lecture à l'attribut la collection eleves
    public ArrayList<Eleve> getEleves(){
        return eleves;
    }

    // Rechercher un élève dans une promotion par son ID
    public Eleve rechercher(int id){
        for (int i=0;i<eleves.size();i++){
            if(eleves.get(i).getID() == id)
                return eleves.get(i);
        }
        return null;
    }
    // Classer les élèves dans l'ordre croissant selon leurs moyennes et en cas d'égalité selon l'ordre decroissant de leurs médianes
    public String trierEleves(){
        String result= "**** "+ nom+" ****\n";
        ArrayList<Eleve> aux = eleves;
        Collections.sort(eleves);
        for (int i=0;i<aux.size();i++)
            result+=aux.get(i).getPrenom() + " "+ aux.get(i).getNom() + " "+ aux.get(i).moyenne() + " " + aux.get(i).mediane()+"\n";
        return  result;
    }


    // Rédefinition de la méthode toString
    public String toString(){
        String result = nom + "\n";
        for (int i=0;i<eleves.size();i++){
            result+=eleves.get(i).getNom()+" " + eleves.get(i).getPrenom()+"\n";
        }
        return result;
    }

    // Ajouter un élève à la promotion
    public void add(Eleve e){
        eleves.add(e);
        e.setPromotion(this);
    }

}
