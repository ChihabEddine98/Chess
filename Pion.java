
public class Pion extends Piece {


    public Pion(boolean couleur, String nom) {
        super(couleur, nom);
    }


    public boolean estValide(Deplacement d, Plateau p) {

        boolean sortie = false;
        int x0, y0, x1, y1;

        x0 = d.getX0();
        y0 = d.getY0();
        x1 = d.getX1();
        y1 = d.getY1();


        // Le Démarrage !

        if (super.estValide(d, p) && p.getCase(x0, y0).getPiece().isCouleur()) // cas des Blancs
        {
            if (x0 == 6 && (x1 == x0 - 1 || x1 == x0 - 2) && y1 == y0) {
                sortie = true;
            } else // Les autres cas
            {
                if (videDirect(d, p) && x1 == x0 - 1 && y1==y0) // déplacement horizontal
                {
                    sortie = true;
                } else {
                    if (!p.getCase(x1, y1).estVide()) {
                        if (x1 == x0 - 1 && (y1 == y0 - 1 || y1 == y0 + 1) && (p.getCase(x1, y1).getPiece().isCouleur() != p.getCase(x0, y0).getPiece().isCouleur())) {
                            sortie = true;
                        }
                    } else {
                        if (y1 == y0 && x1 == x0 - 1) {
                            sortie = true;
                        }
                    }

                }
            }

        } else {

            if (super.estValide(d, p) && !p.getCase(x0, y0).getPiece().isCouleur()) // cas des Noires
            {
                if (x0 == 1 && (x1 == x0 + 1 || x1 == x0 + 2) && y1 == y0) {
                    sortie = true;
                } else // Les autres cas
                {
                    if (videDirect(d, p) && x1 == x0 + 1 && y1==y0) // déplacement horizontal
                    {
                        sortie = true;
                    } else {
                        if (!p.getCase(x1, y1).estVide()) {
                            if (x1 == x0 + 1 && (y1 == y0 - 1 || y1 == y0 + 1) && (p.getCase(x1, y1).getPiece().isCouleur() != p.getCase(x0, y0).getPiece().isCouleur())) {
                                sortie = true;
                            }
                            else if (p.getCase(x1, y1).getPiece().isCouleur() != p.getCase(x0, y0).getPiece().isCouleur() && y1 == y0 && x1 == x0 + 1)
                            {
                                sortie=false;
                            }

                        } else {
                            if (y1 == y0 && x1 == x0 + 1 ) {
                                sortie = true;
                            }
                        }

                    }
                }
            }



        }
        return sortie;
    }
}
