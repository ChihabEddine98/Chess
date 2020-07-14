
public class Plateau {

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private int longueur;
    private int largeur;
    private Case[][] cases;

    public Plateau(int hauteur, int largeur) {
        this.longueur = hauteur;
        this.largeur = largeur;
        cases=new Case[longueur][largeur];


        //4- Génération des couleurs alternées

        boolean coul=true;
        int j;
        int i=0;

        while (i!=longueur)
        {
            j=0;
            while (j!=largeur)
            {
                cases[i][j]=new Case(coul,null);

                if(j!=largeur-1)
                {
                    coul=!coul;
                }


                j++;
            }
            i++;

        }
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public Case getCase(int x, int y)
    {
        return cases[x][y];
    }

    public void videCase(int x,int y)
    {
        cases[x][y].enleverPiece();
    }

    public void remplirCase(int x,int y,Piece p)
    {
        cases[x][y].remplirPiece(p);

    }

    public char[] alphabet()
    {
        char[] alphabet=new char[8];
        alphabet[0]='a';alphabet[1]='b';
        alphabet[2]='c';alphabet[3]='d';
        alphabet[4]='e';alphabet[5]='f';
        alphabet[6]='g';alphabet[7]='h';
        return alphabet;
    }
    public void afficher()
    {

        char[] alphabet=alphabet();


        System.out.println();
        for(int j=0;j!=largeur;j++)
        {
            System.out.print("\t"+"\t "+ANSI_RED+ String.format("%6s",alphabet[j])+ANSI_RESET);
        }
        System.out.println();System.out.println();

        for(int i=0;i!=longueur;i++)
        {
            for(int j=0;j!=largeur;j++)
            {

                if(j==0)
                {
                    System.out.print("\t"+ANSI_RED+(i+1)+ANSI_RESET+"\t"+"\t");
                    System.out.print(cases[i][j]);
                }
                else if(j==largeur-1)
                {
                    System.out.print(cases[i][j]);
                    System.out.print("\t"+ANSI_RED+(i+1)+ANSI_RESET+"\t"+"\t");
                    System.out.println();
                }
                else
                {
                    System.out.print(cases[i][j]);
                }

            }


        }
        System.out.println();
        for(int j=0;j!=largeur;j++)
        {
            System.out.print("\t"+"\t "+ANSI_RED+ String.format("%6s",alphabet[j])+ANSI_RESET);
        }
        System.out.println();


    }


    public boolean horsLimite(int x,int y)
    {
        return ( x>longueur || y>largeur || x<0 || y<0);
    }


    public boolean horLimite(Deplacement d)
    {

        return(( d.getX0()>=longueur || d.getY0()>=largeur ||
                d.getX0()<0 || d.getY0()<0)
                ||(d.getX1()>=longueur || d.getY1()>=largeur ||
                d.getX1()<0 || d.getY1()<0));
    }





}
