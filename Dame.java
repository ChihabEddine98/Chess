
public class Dame extends Piece{


    public Dame(boolean couleur, String nom) {
        super(couleur, nom);
    }

    public boolean estValide(Deplacement d,Plateau p)
    {

        boolean sortie=false;

        if(super.estValide(d,p))
        {
            if((d.quelType()=='v' || d.quelType()=='h' ) && videDirect(d,p) )
            {

                sortie=true;
            }
            else
            {
                if (d.quelType()=='d' && videDiagonal(d,p))
                {
                    sortie=true;
                }
            }
        }
        else
        {
            sortie=false;
        }


        return sortie;
    }


}
