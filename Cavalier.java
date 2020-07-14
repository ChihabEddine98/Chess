
public class Cavalier extends Piece {

    public Cavalier(boolean couleur, String nom) {
        super(couleur, nom);
    }

    public boolean estValide(Deplacement d,Plateau p)
    {

        boolean sortie=false;

        if(super.estValide(d,p))
        {
            if(!p.getCase(d.getX1(),d.getY1()).estVide() )
            {
                if(d.quelType()=='c' && p.getCase(d.getX1(),d.getY1()).getPiece().isCouleur()!=p.getCase(d.getX0(),d.getY0()).getPiece().isCouleur())
                {
                    sortie=true;
                }
            }
            else
                {

                    if(d.quelType()=='c')
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
