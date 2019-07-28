package test;
// Pour effectuer les tests sur un interface graphique
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class MyApplicationFrame extends JFrame{
    MyApplication app = new MyApplication(); // instance de MyApplication qui contient  Les données codées en dur
    JPanel pSouth =new JPanel();
    JLabel resultLabel = new JLabel("Résultats"); // Label de la zone d'affichage de résultats de tests
    TextArea result = new TextArea(""); // Zone du texte pour afficher les résultats de tests
    JLabel showEleveLabel = new JLabel("Chercher Elève     ID"); // Label de la saisie de l'ID d'un élève pour le rechercher
    JButton showElv = new JButton("Afficher l'élève"); // Permet  d'afficher un élève avec son nom, sa promotion, ses correcteurs, ses notes, leur moyenne et leur médiane
    JTextField idEleve = new JTextField("1"); // Zone de saisie de l'ID de l'élève recherché
    JButton showAll = new JButton("Afficher Tous Les Elèves"); // Permet d'afficher tous les élèves d'une promotion
    JButton classement = new JButton("Classement des élèves"); // Permet d'afficher tous les élèves d'une promotion classés par leurs moyennes et leurs médiannes


    public MyApplicationFrame(){
        this.setBackground(Color.blue); // Couleur de l'arriére plan du Frame
        this.add(pSouth);
        this.setBounds(50,50,520,550); // Dimensions du fenêtre du Frame
        this.setVisible(true); // Frame visible
        this.setTitle("Evaluations-Eleves-Notes"); // Titre du fenêtre
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Action par défault en cliquant sur l'icône de fermeture "X"
        this.setResizable(false); // Pour Garder la taille fixé dans le code du Frame

        pSouth.setBackground(Color.yellow); // Couleur de  l'arriére plan du Panel
        pSouth.setBounds(0,0,520,320); // Dimensions du Panel
        pSouth.setLayout(null);
        // dimensionnement et ajout des composants au Panel qui representera notre interface graphqiue
        resultLabel.setBounds(240,5,70,20);
        pSouth.add(resultLabel);
        result.setBounds(10,30,480,380);
        pSouth.add(result);
        showEleveLabel.setBounds(10,420,120,20);
        pSouth.add(showEleveLabel);
        idEleve.setBounds(130,420,30,20);
        pSouth.add(idEleve);
        showElv.setBounds(170,420,120,20);
        pSouth.add(showElv);
        showAll.setBounds(10,450,200,20);
        pSouth.add(showAll);
        classement.setBounds(220,450,200,20);
        pSouth.add(classement);

        // Définir les actions effectués suite à l'appui sur chaque bouton définit précedement

        showElv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idEleve.getText());
                if(app.promo2018.rechercher(id)!= null)
                result.setText(app.promo2018.rechercher(id).toString());
                else
                    result.setText("Elève Introuvable !");

            }
        });

        showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(app.promo2018.toString());
            }
        });

        classement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(app.promo2018.trierEleves());
            }
        });


    }

    public static void main(String[] args) {
        MyApplicationFrame f = new MyApplicationFrame(); // Lancer interface graphique
    }


}