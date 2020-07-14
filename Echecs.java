
import java.io.IOException;
import java.util.Scanner;


/**
 * Université De Paris Diderot UFR D'informatique
 *                                                          2018/2019
 *
 * Remarques Imprtantes :
 *
 *  Ce Tp a était réalisé en binome entre :( Benamara Abdelkader Groupe  : 2 MI 1 )
 *                                         ( Elhoufi  Othman     Groupe  : 2 MI 2 )
 *
 *  Le Plateau se commence par la case de cordonnées (0,0)
 *  et se termine par la case (7,7).
 *
 *  Les cases sont de forme (ligne,colonne)
 *  Plus on déscent plus on aura ligne=ligne+1;
 *  Si on récule a gauche on aura donc colonne=colonne-1;
 *
 *  Par exemple le cavalier du haut a comme coordonnés (0,1)
 *              le cavalier du bas  lui sera           (7,1)
 *
 *  ALors c'est exactement les jeux d'échecs classiques ( 8x8 ) avec toutes les régles du jeu .
 *
 *  Pour mieux rendre la tache de l'utilistauer facile On a utilisé la grille avec l'alphabet et les numéros
 *
 * **/

public class Echecs {

    static Plateau plateau;
    static Joueur joueur1, joueur2;
    static boolean joueur=true;

    static Communication c = new Communication();



    // Une méthode afin de effacer le contenu de la console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nom1, nom2;
        Deplacement d;


        System.out.print(" \n Entrez le nom du joueur1 (Blanc) : ");
        nom1 = sc.next();
        System.out.print(" \n Entrez le nom du joueur2 (Noire) : ");
        nom2 = sc.next();

        joueur1 = new Joueur(nom1, 0, 16, true);
        joueur2 = new Joueur(nom2, 0, 16, false);



        remplirPlateau();
        plateau.afficher();

        jouerPartie();


    }

    static boolean tourJoueur() // elle nous retourne vrai si le tour est pour Le blanc
    {
        return joueur1.getNbPieces() <= joueur2.getNbPieces()
                && joueur1.getDeplacement() > joueur2.getDeplacement();
    }


    public static void remplirPlateau() // 8x8
    {
        plateau = new Plateau(8, 8);

        // pieces Noires
        plateau.remplirCase(0, 0, new Tour(false, "tour"));
        plateau.remplirCase(0, 7, new Tour(false, "tour"));
        plateau.remplirCase(0, 1, new Cavalier(false, "cavalier"));
        plateau.remplirCase(0, 6, new Cavalier(false, "cavalier"));
        plateau.remplirCase(0, 2, new Fou(false, "fou"));
        plateau.remplirCase(0, 5, new Fou(false, "fou"));
        plateau.remplirCase(0, 3, new Dame(false, "dame"));
        plateau.remplirCase(0, 4, new Roi(false, "roi"));

        // remplissage des pions
        for (int i = 0; i != 8; i++)

        {
            plateau.remplirCase(1, i, new Pion(false, "pion"));
            plateau.remplirCase(6, i, new Pion(true, "pion"));

        }


        // pieces Blanches
        plateau.remplirCase(7, 0, new Tour(true, "tour"));
        plateau.remplirCase(7, 7, new Tour(true, "tour"));
        plateau.remplirCase(7, 1, new Cavalier(true, "cavalier"));
        plateau.remplirCase(7, 6, new Cavalier(true, "cavalier"));
        plateau.remplirCase(7, 2, new Fou(true, "fou"));
        plateau.remplirCase(7, 5, new Fou(true, "fou"));
        plateau.remplirCase(7, 3, new Dame(true, "dame"));
        plateau.remplirCase(7, 4, new Roi(true, "roi"));


    }

    static boolean jouerTour(Deplacement d, Joueur j1, Plateau p, Joueur j2) {
        int x0, y0, x1, y1;

        boolean sortie=false;
        x0 = d.getX0();
        y0 = d.getY0();
        x1 = d.getX1();
        y1 = d.getY1();


        if (p.getCase(x0, y0).getPiece().estValide(d, p)) {

            j1.setDeplacement(j1.getDeplacement() + 1);

            // Si le joueur a pris une piece de l'adversaire !

            if (!p.getCase(x1, y1).estVide()) {
                if ((p.getCase(x1, y1).getPiece().isCouleur() && !p.getCase(x0, y0).getPiece().isCouleur())
                        || (!p.getCase(x1, y1).getPiece().isCouleur() && p.getCase(x0, y0).getPiece().isCouleur())
                        && p.getCase(x0,y0).getPiece().isCouleur()==j1.getCouleur()) {
                    p.videCase(x1, y1);
                    p.remplirCase(x1, y1, p.getCase(x0, y0).getPiece());
                    j2.setNbPieces(j2.getNbPieces() - 1);
                    p.videCase(x0, y0);

                    sortie=true;
                }
            } else if (p.getCase(x1, y1).estVide() && p.getCase(x0,y0).getPiece().isCouleur()==j1.getCouleur()
            && p.getCase(x0,y0).getPiece().isCouleur()==j1.getCouleur()) {
                p.remplirCase(x1, y1, p.getCase(x0, y0).getPiece());
                p.videCase(x0, y0);

                sortie=true;
            }

        } else {
            System.out.println("\n Ouups ! \n Déplacement Impossible !");



        }

        return sortie;


    }

    static boolean checkMate() {
        boolean stop = false;
        boolean roi1, roi2;
        int cpt=0;
        roi1 = false;
        roi2 = false;
        int a = 0;
        int b, c, d;

        while (a < plateau.getLongueur()) {

            b=0;

            while ( b < plateau.getLargeur()) {
                if (!plateau.getCase(a, b).estVide())
                {
                    if (plateau.getCase(a, b).getPiece().estRoi())
                    {
                         cpt++;

                         b++;
                    }
                    else {
                        b++;
                    }
                }
                else {
                    b++;
                }
            }
            a++;
        }


        return (cpt!=2);


    }

    static boolean matchFini() {

        boolean b = checkMate();


        return (b);

    }
    // Exo 8


    static void jouerPartie() {
        Joueur j; // Utile pour l'alternance
        Deplacement d;
        boolean b = false;

        while (!matchFini()) { // Tantque le match n'est pas terminé

            if (joueur)  // Si le tour du blanc (joueur1)
            {
                do {
                  d = c.demanderDeplacement(joueur1,plateau);

                  } while ( plateau.horLimite(d) || !plateau.getCase(d.getX0(),d.getY0()).getPiece().estValide(d,plateau));

                b = jouerTour(d, joueur1, plateau, joueur2);
                if(b) joueur=false;



                plateau.afficher();

            } else   // Si le tour du noir (joueur2)
            {
                do {
                    d = c.demanderDeplacement(joueur2,plateau);
                } while (plateau.horLimite(d) || !plateau.getCase(d.getX0(),d.getY0()).getPiece().estValide(d,plateau));

                b = jouerTour(d, joueur2, plateau, joueur1);
                if(b) joueur=true;
                plateau.afficher();

            }
        }

        joueur=true;
        if (joueur1.getNbPieces() > joueur2.getNbPieces()) {
            joueur1.setScore(joueur1.getScore() + 1);
            System.out.print(" \n Braaaoooo ! "+joueur1.getNom()+" Vous Avez Gagné ! \n");
            c.afficherScore(joueur1,joueur2);
            if (c.demandeRejouer(joueur1, joueur2)) {

                joueur1.setNbPieces(16);
                joueur2.setNbPieces(16);
                joueur1.setDeplacement(0);
                joueur2.setDeplacement(0);
                clearScreen();
                remplirPlateau();
                plateau.afficher();
                jouerPartie();

                }

            } else if (joueur2.getNbPieces() > joueur1.getNbPieces()) {

                System.out.print(" \n Braaaoooo ! "+joueur2.getNom()+" Vous Avez Gagné ! \n");
                joueur2.setScore(joueur2.getScore() + 1);
                c.afficherScore(joueur1,joueur2);
                if (c.demandeRejouer(joueur1, joueur2)) {

                    joueur1.setNbPieces(16);
                    joueur2.setNbPieces(16);
                    joueur1.setDeplacement(0);
                    joueur2.setDeplacement(0);
                        clearScreen();
                        remplirPlateau();
                        plateau.afficher();
                        jouerPartie();
                        }

            }

          else return;
        }





    }

