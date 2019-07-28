package notesElevesProfesseurs;

import java.util.Scanner;

public class Professeur extends Personne{

    // Constructeur
    public Professeur(String nom,String prenom){
        super(nom,prenom); // Appel de la constructeur du superclasse Personne
    }

    // Rechercher un élève par son ID dans une promotion donnée
    public Eleve rechercher(Promotion p,int id){
        for (int i=0;i<p.getEleves().size();i++){
            if(p.getEleves().get(i).getID() == id)
                return p.getEleves().get(i);
        }
        return null;
    }

    // Modifier des notes des évaluations d'un élève
    public void setNote(Promotion p, int id,Double note,int indice){
        Eleve e = rechercher(p,id);
        // Si l’élève recherché n’existe pas, l’exception IllegalStateException est lancée
        if(e==null)
            throw new IllegalStateException();
        // si l’élève existe et si la note existe aussi alors est modifiée.
        else if((e!= null)&&(e.getEvaluations().get(indice)!= null)){
            e.getEvaluations().get(indice).setNote(note);
        }
        // si l’élève existe et si la note n’existe pas
        else{
            System.out.println(" Evaluation d'indice" + indice + " est inexsistance ! Saisir le nom de la matière \t");
            Scanner sc = new Scanner(System.in);
            String matiere = sc.nextLine();
            e.addEvaluation(matiere,note,this);
        }
    }
}
