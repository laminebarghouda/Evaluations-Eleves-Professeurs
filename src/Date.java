package Date;

public class Date {
    public int jour;
    public int mois;
    public int annee;

    public Date(int jour,int mois,int annee) throws WrongDateException {
        // Verification de la validité de la date saisie
        if(
                ((jour>31 || jour<1)&&(mois==1 || mois == 3 || mois==5 || mois == 7 || mois==8 || mois == 10 ||mois==12 )) || // Les mois de 31 Jours
                        ((jour>30 || jour<1)&&(mois == 4 || mois==6 || mois == 9 || mois==11)) || // Les mois de 30 Jours
                        ((mois==2)&&(jour>29 || jour < 1)&&(annee%4==0)&&(annee%100 != 0)) || // Année bisextile
                        ((mois==2)&&(jour>28 || jour < 1)&&(annee%4!=0)) || // Année non bisextile
                        (mois < 1 || mois >12) || // Les mois possibles de l'année
                        (annee<0)
        )
            // Lever une exception si la date saisie est invalide
            throw new WrongDateException();
        else {
            this.jour = jour;
            this.mois = mois;
            this.annee = annee;
        }
    }
}

