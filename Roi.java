
public class Roi extends Piece {

    public Roi(boolean couleur, String nom) {
        super(couleur, nom);
    }


    public boolean estValide(Deplacement d, Plateau p) {

        boolean sortie = false;
        int x0, x1, y0, y1;

        x0 = d.getX0();
        y0 = d.getY0();
        x1 = d.getX1();
        y1 = d.getY1();

        if (super.estValide(d, p)) {

            if (p.getCase(d.getX0(), d.getY0()).getPiece().estRoi()) {
                if ((Math.abs(x1 - x0) <= 1 && Math.abs(y1 - y0) <= 1)) // Déplacement Du Roi
                {
                    if (x0 != x1 || y0 != y1) {
                        sortie = true;
                    }
                }
            } else {
                sortie = false;
            }

        }
        return sortie;


    }
}
