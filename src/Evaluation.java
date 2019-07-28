package notesElevesProfesseurs;


public class Evaluation implements Comparable<Evaluation> {
    private String matiere; // Nom de la matière
    private double note;
    private Eleve corrige;
    private Professeur correcteur;

    //Constructeur
    public Evaluation(String matiere,double note,Eleve corrige,Professeur correcteur){
        this.matiere=matiere;
        this.note=note;
        this.corrige=corrige;
        this.correcteur=correcteur;
    }

    // Accesseur en lecture à l'attribut matiere
    public String getMatiere(){
        return matiere;
    }

    // Accesseur en écriture à l'attribut note
    public void setNote(Double note){
        this.note=note;
    }

    // Accesseur en lecture à l'attribut note
    public double getNote(){
        return note;
    }

    // Accesseur en lecture à l'attribut correcteur
    public Professeur getCorrecteur(){
        return correcteur;
    }


    // Redéfinition de la méthode toString
    @Override
    public String toString(){
        return "("+"("+corrige.getPrenom()+", "+corrige.getNom()+")"+" "+"("+correcteur.getPrenom()+", "+correcteur.getNom()+")"+" "+matiere+" "+note+")";
    }

    // Comparer deux notes (Utilisé pour classer les notes d'un élève donnée et extraire le médiane)
    @Override
    public int compareTo(Evaluation e) {
        if(note>e.getNote())
            return 1;
        else if (note==e.getNote())
            return 0;
        else
            return -1;
    }
}
