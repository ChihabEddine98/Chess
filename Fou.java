
public class Fou extends Piece {

    public Fou(boolean couleur, String nom) {
        super(couleur, nom);
    }

    public boolean estValide(Deplacement d,Plateau p)
    {

        boolean sortie=false;

        if(super.estValide(d,p))
        {

            if(d.quelType()=='d' && videDiagonal(d,p))
            {
                sortie=true;
            }
        }
        else
        {
            sortie=false;
        }


        return sortie;
    }

}
