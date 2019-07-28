package test;
// Pour effectuer les simples tests sur la sortie standard (Mode Console)
import Date.WrongDateException;
import notesElevesProfesseurs.*;

import java.util.Scanner;

public class MyApplication {
    protected Promotion promo2018, promo2019, promo2020;
    protected Eleve e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;
    protected Professeur p1, p2, p3, p4, p5, p6;

    public MyApplication() {
        promo2018 = new Promotion("Promotion2018");
        promo2019 = new Promotion("Promotion2019");
        promo2020 = new Promotion("Promotion2020");
        try {

            // Création de plusieurs élèves
            e1 = new Eleve("DUPONT", "François", 02, 05, 1996);
            e2 = new Eleve("MARTIN", "Stephane", 28, 12, 1996);
            e3 = new Eleve("BERNARD", "Raphael", 17, 07, 1996);
            e4 = new Eleve("DUBOIS", "Emma", 03, 07, 1997);
            e5 = new Eleve("THOMAS", "Paul", 10, 02, 1998);
            e6 = new Eleve("ROUSSEAU", "Gabriel", 18, 11, 1996);
            e7 = new Eleve("VINCENT", "Antoine", 18, 11, 1998);
            e8 = new Eleve("LAMBERT", "Sarah", 18, 11, 1997);
            e9 = new Eleve("MARTINEZ", "Mia", 18, 11, 1997);
            e10 = new Eleve("CLEMENT", "Johanna", 18, 11, 1998);


            // Création de plusieurs Professeurs
            p1 = new Professeur("GAUTHIER", "Mathis");
            p2 = new Professeur("MORIN", "Lina");
            p3 = new Professeur("LOPEZ", "Rose");
            p4 = new Professeur("BOYER", "Lucas");
            p5 = new Professeur("MARTIN", "Alex");
            p6 = new Professeur("DUBOIS", "Antoine");


            // Création de plusieurs évaluations
            e1.addEvaluation("Mathematiques", 15.0, p2);
            e2.addEvaluation("Mathematiques", 9.0, p2);
            e3.addEvaluation("Mathematiques", 10.0, p2);
            e3.addEvaluation("Programmation", 12.0, p2);
            e3.addEvaluation("Sciences Physiques", 5.0, p2);
            e4.addEvaluation("Mathematiques", 15.0, p2);
            e5.addEvaluation("Mathematiques", 9.25, p2);
            e6.addEvaluation("Mathematiques", 8.75, p2);
            e7.addEvaluation("Mathematiques", 13.75, p2);
            e8.addEvaluation("Mathematiques", 16.1, p2);
            e9.addEvaluation("Mathematiques", 10.0, p2);
            e10.addEvaluation("Mathematiques", 9.5, p2);
            e1.addEvaluation("Programmation", 18.0, p1);
            e1.addEvaluation("Algorithmique", 14.5, p3);
            e1.addEvaluation("Sciences Physiques", 13.75, p3);
            e1.addEvaluation("Chimie", 16.0, p4);


            // Rangement des élèves de la promotion
            promo2018.add(e1);
            promo2018.add(e2);
            promo2018.add(e3);
            promo2019.add(e4);
            promo2020.add(e5);
            promo2018.add(e6);
            promo2020.add(e7);
            promo2019.add(e8);
            promo2019.add(e9);
            promo2020.add(e10);

        } catch (WrongDateException d) {
            System.out.println(d);
        } catch (IllegalStateException i) {
            System.out.println(i.toString());
        }
    }

    public static void main(String[] args) {
        MyApplication app = new MyApplication();


        // Affichage d'un élève
        System.out.println("*** Affichage d'un élève ***");
        System.out.println(app.e1.toString());


        // Affichage des élèves d'une promotion
        System.out.println("*** Affichage des élèves d'une promotion ***");
        System.out.println(app.promo2018.toString());


        // Recherche et Affichage d'un élève par son ID
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Rechercher et Afficher un élève par son ID ***");
        System.out.println("Saisir l'ID de l'élève à rechercher ! exemple : 1");
        int id = sc.nextInt();
        Eleve eSearched = app.promo2018.rechercher(id);
        if (eSearched != null) {
            System.out.println(eSearched.toString());
        } else
            System.out.println("Eleve Introuvable");


        // Classement et Affichage des élèves classés
        System.out.println("*** Affichage des élèves d'une promotion classés (Nom,Prenom,Moyenne,Médiane) ***");
        System.out.println(app.promo2018.trierEleves());


    }
}

