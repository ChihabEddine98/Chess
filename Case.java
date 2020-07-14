
public class Case {


    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_YELLOW_BACKGROUND = "\033[0;100m";
    public static final String ANSI_BLUE_BACKGROUND = "\033[0;107m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\033[1;31m";
    public static final String ANSI_WHITE =  "\033[1;35m";


    private boolean couleur;
    private Piece piece;

    // COnstructeur
    public Case(boolean couleur, Piece piece) {

        this.couleur = couleur;
        this.piece = piece;
    }


    // Méthodes Demandées

    public Piece getPiece() {
        return piece;
    }

    public boolean estVide()
    {
        return piece==null;
    }

    public void remplirPiece(Piece p)
    {
        this.piece=p;
    }

    public void enleverPiece()
    {
        piece=null;
    }


    @Override
    public String toString() {
        String r;
        if(this.estVide()) // si la case est vide
        {
            if(couleur)
            {
                //r="\t"+ String.format("%9s","blanc")+" |";

                r=ANSI_YELLOW_BACKGROUND+String.format("%11s"," ")+ANSI_RESET;

            }
            else
            {
                //r="\t"+ String.format("%9s","noir")+" |";
                r=ANSI_BLUE_BACKGROUND+String.format("%11s"," ")+ANSI_RESET;
            }

        }
        else
        {
            if(couleur)
            {

                if(piece.isCouleur())
                {
                    r=ANSI_WHITE+ANSI_YELLOW_BACKGROUND+String.format("%11s",piece.toString())+ANSI_RESET;
                }
                else
                {
                    r=ANSI_BLACK+ANSI_YELLOW_BACKGROUND+String.format("%11s",piece.toString())+ANSI_RESET;
                }



            }
            else
            {
                if(piece.isCouleur())
                {
                    r=ANSI_WHITE+ANSI_BLUE_BACKGROUND+String.format("%11s",piece.toString())+ANSI_RESET;
                }
                else
                {
                    r=ANSI_BLACK+ANSI_BLUE_BACKGROUND+String.format("%11s",piece.toString())+ANSI_RESET;
                }
                //r="\t"+ String.format("%9s","noir")+" |";
               // r=ANSI_BLUE_BACKGROUND+String.format("%11s",piece.toString())+ANSI_RESET;
            }
            //r=piece.toString();
        }

        return r;
    }

}
