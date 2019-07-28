package notesElevesProfesseurs;
import Date.*;
import java.util.*;
import Date.Date;

// l'mplémentation de l'interface comparable a permis de rédéfinir la méthode compareTo pour comparer les élèves selon leurs moyennes et en cas d'égalité selon le médiane
public class Eleve extends Personne implements Comparable<Eleve>{

    private final int ID = matricule +1; // ID fixe et unique
    Date naissance; // Date de naissance de l'élève
    ArrayList<Evaluation> evaluations; // List des évaluations de l'élève
    private static final int NB_EVALUATIONS =10;
    private static int matricule =0; // Incrémentation automatique de le matricule qui servira à défénir les ID unique de chaque élève
    private Promotion promotion; // Promotion à laquelle appartient l'élève

    // Constructeur
    public Eleve(String nom, String prenom,int jour,int mois,int annee) throws WrongDateException{
        super(nom,prenom); // Appel de la constructeur du superclasse Personne
        naissance = new Date(jour,mois,annee);
        matricule++;
        this.promotion = null;
        evaluations = new ArrayList<Evaluation>();
    }

    // Accesseur en lecture à l'attribut ID
    public int getID(){
        return ID;
    }

    // Accesseur en lecture à l'arraylist evaluations
    public ArrayList<Evaluation> getEvaluations(){
        return evaluations;
    }

    // Accesseur en écriture à l'attribut promotion
    public void setPromotion(Promotion promotion){
        this.promotion=promotion;
    }

    // Calcul de la moyenne d'un élève
    public float moyenne() {
        float moy = 0;
        // Si l'élève n'a aucune note, l’exception IllegalStateException est lancée
        if (evaluations.size() == 0) {
            throw new IllegalStateException();
        }
        // Calcul de Moyenne
        else {
         for(int i=0;i<evaluations.size();i++){
             moy +=(evaluations.get(i).getNote()) / (evaluations.size());
         }
        }
        return moy;

    }

    // Calcul du médiane de notes d'un élève
    public double mediane(){
        double med = 0;
        // Si l'élève n'a aucune note, l’exception IllegalStateException est lancée
        if (evaluations.size() == 0) {
            throw new IllegalStateException();
        }
        // Calcul de Medine
        else {
            ArrayList<Evaluation> aux = evaluations;
            // Trier les notes pour déterminer leur médiane
            Collections.sort(aux);
            // le point de milieu dépendera de la parité du nombre de notes
            int pointMed =0;
            // Nombre de note pair
            if(aux.size()%2 == 0) {
                pointMed = aux.size() / 2;
                med = (aux.get(pointMed-1).getNote()+aux.get(pointMed).getNote()) / 2;
            }
            else {
                // Nombre de notes impair
                pointMed = (aux.size() +1) / 2;
                med = aux.get(pointMed-1).getNote();
            }

        }
        return med;

    }

    //  Ranger dans une instance de la classe HashSet,  l'ensemble des correcteurs ayant évalué un élève
    public HashSet<Professeur> getCorrecteurs(){
        HashSet<Professeur> correcteurs = new HashSet<Professeur>() {
            @Override
            public String toString() {
                // rédéfinition de la méthode toString de telle sorte qu'une collection de professeurs sera affichée
                HashSet<Professeur> correcteurs = new HashSet<Professeur>();
                for(int i = 0;i<evaluations.size();i++) {
                    if (!correcteurs.contains(evaluations.get(i).getCorrecteur()))
                        correcteurs.add(evaluations.get(i).getCorrecteur());
                }
                String result = "[";
                Iterator<Professeur> professeurIterator = correcteurs.iterator();
                while (professeurIterator.hasNext())
                    result += professeurIterator.next().toString() + " ,";
                result = result.substring(0, result.length() - 2) + "]";
                return result;
            }
        };

        // Extraire l'ensemble de correcteurs ayant evalué un élève sans redondance
        for(int i = 0;i<evaluations.size();i++) {
            if (!correcteurs.contains(evaluations.get(i).getCorrecteur()))
                correcteurs.add(evaluations.get(i).getCorrecteur());
        }

        return correcteurs;
    }

    // Redefinition de la méthode toString
    @Override
    public String toString() {
        String result = super.toString();
        result+=" ID: "+ID+"\n";
        result+="Promotion : "+promotion.getNom()+"\n";
        result+="notes : ";
        for(int i=0;i<evaluations.size();i++)
            result+=evaluations.get(i).getMatiere()+" "+evaluations.get(i).getNote()+" ";
        result+="\n";
        result+="moyenne = " + moyenne() + "\n";
        result+="mediane = " + mediane() + "\n";
        result+="correcteur(s): "+getCorrecteurs().toString();

        return result;
    }

    // Deux élèves sont un même s'il possèdent le même ID
    public boolean equals(Eleve e) {
        if (ID == e.getID())
        return true;
        else
            return false;
    }

     // Redéfinition de la méthode hashCode
    @Override
    public int hashCode() {
        return super.hashCode() * ID;
    }


    // Ajouter une nouvelle évaluation à l'élève sans dépasser les 10 évaluations possible
    public void addEvaluation(String matiere, Double note, Professeur p) {
        if(evaluations.size()<NB_EVALUATIONS)
        evaluations.add(new Evaluation(matiere,note,this,p));
    }

   // Comparer deux élèves selon leurs moyennes et en cas d'égalité selon leurs médiannes
    // C'est une méthode implémenté de l'interface Comparable
    @Override
    public int compareTo(Eleve e) {
            if (moyenne() > e.moyenne())
                return 1;
            else if (moyenne() == e.moyenne()){
                if (mediane()>e.mediane())
                    return -1;
                else if(mediane()==e.mediane())
                    return 0;
                else
                    return 1;
            }
            else
                return -1;

    }
}
