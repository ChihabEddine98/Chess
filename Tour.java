
public class Tour extends Piece {


    public Tour(boolean couleur, String nom) {
        super(couleur, nom);
    }

    public boolean estValide(Deplacement d,Plateau p)
    {

        boolean sortie=false;

        if(super.estValide(d,p) && videDirect(d,p))
        {
            if(d.quelType()=='v' || d.quelType()=='h')
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
