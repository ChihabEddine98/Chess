
public class Piece {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";

    private boolean couleur;
    private String nom;


    public Piece(boolean couleur, String nom) {
        this.couleur = couleur;
        this.nom = nom;
    }

    public boolean isCouleur() {
        return couleur;
    }

    public static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
    @Override
    public String toString() {

        String r;
        if(!couleur) // si la couleur est 'noir'
        {
            r=capitalize(nom);
        }
        else
        {
            r=nom;
        }

        return r;
    }

    public boolean videDiagonal(Deplacement d,Plateau p)
    {

        int i,j;
        boolean continu=true;

        if(d.quelType()=='d')
        {
            if(d.dirVer()==1 && d.dirHor()==1) // on déscent verticalement
            {
                i=d.getX0()+1;
                j=d.getY0()+1;

                while(i<d.getX1() && j<d.getY1() && continu && !p.horsLimite(i,j))
                {
                  if(!p.getCase(i,j).estVide())
                    {
                        continu=false;
                    }
                    else
                    {
                      i++;
                      j++;
                    }

                }
            }

            if(d.dirVer()==-1 && d.dirHor()==1) // on Monte verticalement
            {
                i=d.getX0()-1;
                j=d.getY0()+1;

                while(i>d.getX1() && j<d.getY1() && continu && !p.horsLimite(i,j))
                {
                    if(!p.getCase(i,j).estVide())
                    {
                        continu=false;
                    }
                    else
                    {
                        i--;
                        j++;
                    }

                }
            }
            if(d.dirVer()==-1 && d.dirHor()==-1) // on Monte verticalement
            {
                i=d.getX0()-1;
                j=d.getY0()-1;

                while(i>d.getX1() && j>d.getY1() && continu && !p.horsLimite(i,j))
                {
                    if(!p.getCase(i,j).estVide())
                    {
                        continu=false;
                    }
                    else
                    {
                        i--;
                        j--;
                    }

                }
            }
            if(d.dirVer()==1 && d.dirHor()==-1) // on Monte verticalement
            {
                i=d.getX0()+1;
                j=d.getY0()-1;

                while(i<d.getX1() && j>d.getY1() && continu && !p.horsLimite(i,j))
                {
                    if(!p.getCase(i,j).estVide())
                    {
                        continu=false;
                    }
                    else
                    {
                        i++;
                        j--;
                    }

                }
            }

        }


        return continu;
    }

    public boolean videDirect(Deplacement d,Plateau p) // si y on a pas de pieces dans le déplacement
    {

        boolean continu=true;
        int i;



        if(d.quelType()=='v' && d.dirVer()==1)
        {
            i=d.getY0()+1;

            //   Vertical positif " ;

            while (i<d.getY1() && !p.horsLimite(d.getX0(),i) && continu)
            {

                if(!p.getCase(d.getX0(),i).estVide())
                {
                    continu=false;
                }
                else
                {
                    i++;
                }
            }

        }
        else {
            if(d.quelType()=='v' && d.dirVer()==-1)
            {
                // Vertical négatif " ;

                i=d.getY0()-1;

                while (i>d.getY1() && !p.horsLimite(d.getX0(),i) && continu)
                {

                    if(!p.getCase(d.getX0(),i).estVide())
                    {
                        continu=false;
                    }
                    else
                    {
                        i--;
                    }

                }

            }

            else if(d.quelType()=='h' && d.dirVer()==1)
            {
                //   Horizontal positif " ;
                i=d.getX0()+1;


                while (i<d.getX1() && !p.horsLimite(i,d.getY0()) && continu)
                {

                    if(!p.getCase(i,d.getY0()).estVide())
                    {
                        continu=false;
                    }
                    else
                    {
                        i++;
                    }

                }

            }

            if(d.quelType()=='h' && d.dirVer()==-1)
            {
                //  Horizontal negatif " ;

                i=d.getX0()-1;




                while (i>d.getX1() && !p.horsLimite(i,d.getY0()) && continu)
                {
                    if(!p.getCase(i,d.getY0()).estVide())
                    {
                        continu=false;
                    }
                    else
                    {
                        i--;
                    }

                }


            }



        }

        return continu;

    }
    public boolean estValide(Deplacement d,Plateau p)
    {
        boolean sortie=false;
        int x0,y0,x1,y1;



        x0=d.getX0();
        y0=d.getY0();
        x1=d.getX1();
        y1=d.getY1();

        // Si la piece va se déplacer vers une case occupée par une piece de couleur différente
        if(!p.horLimite(d)) {
            if (p.getCase(x1, y1).estVide() || p.getCase(x1, y1).getPiece().couleur != p.getCase(x0, y0).getPiece().couleur ) {
                sortie = true;
            }
        }
        return sortie;
    }


    // Exo 8


    public boolean estRoi()
    {

        return this instanceof Roi;
    }


}
