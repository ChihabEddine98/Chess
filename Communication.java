
import java.util.Scanner;

public class Communication {

    private Scanner sc=new Scanner(System.in);;

    public Communication() {

    }

    public static boolean isInt( String s ) {

      try
      {
        Integer.parseInt(s);
      }
      catch( NumberFormatException e )
      {
        return false;
      }

      return true;
    }

    public Deplacement demanderDeplacement(Joueur joueur,Plateau p)
    {
        int x0,y0,x1,y1;
        Deplacement d;
        String s = "";

        System.out.print("\n >>>>>>>>>>>>>"+ String.format("%10s",joueur.getNom())+"    <<<<<<<<<<<<< \n\n");
        System.out.print(" ++++++++++  Point De Départ ! ++++++++++ \n");
        System.out.print("\n Ligne  : ");
        // x0=sc.nextInt();
        //////////////// String Handling ////////////////
        s = sc.next();
        while ( isInt(s) == false ) {
            System.out.print("\n    Oups !!! Saisie Incorrecte !"+"\n"+"\n Veuillez re-saisir Svp\n  ");
          System.out.print("\n Ligne  : ");
          s = sc.next();
        }
        /////////////////////////////////////////////////
        x0 = Integer.parseInt(s)-1;

        System.out.print("\n Colonne : ");

        //////////////// String Handling ////////////////
        s = sc.next();
        while (s.isEmpty()) {
            System.out.print("\n    Oups !!! Saisie Incorrecte !"+"\n"+"\n Veuillez re-saisir Svp\n  ");
            System.out.print("\n Colonne : ");
          s = sc.next();
        }
        /////////////////////////////////////////////////

        //y0 = Integer.parseInt(s);

        switch (s)
        {
            case "a": y0=0; break;
            case "b": y0=1; break;
            case "c": y0=2; break;
            case "d": y0=3; break;
            case "e": y0=4; break;
            case "f": y0=5; break;
            case "g": y0=6; break;
            case "h": y0=7; break;
            default:y0=-1; break;
        }

        System.out.print("\n ++++++++++  Point D' Arrivé  ! ++++++++++ \n ");
        System.out.print("\n Ligne  : ");
        //////////////// String Handling ////////////////
        s = sc.next();
        while ( isInt(s) == false ) {
            System.out.print("\n    Oups !!! Saisie Incorrecte !"+"\n"+"\n Veuillez re-saisir Svp\n  ");
            System.out.print("\n Ligne : ");
          s = sc.next();
        }
        /////////////////////////////////////////////////
        x1=Integer.parseInt(s)-1;


        System.out.print("\n Colonne : ");
        //////////////// String Handling ////////////////
        s = sc.next();
        while (s.isEmpty()) {
            System.out.print("\n    Oups !!! Saisie Incorrecte !"+"\n"+"\n Veuillez re-saisir Svp \n  ");
            System.out.print("\n Colonne : ");
          s = sc.next();
        }
        /////////////////////////////////////////////////
        //y1=Integer.parseInt(s);
        switch (s)
        {
            case "a": y1=0; break;
            case "b": y1=1; break;
            case "c": y1=2; break;
            case "d": y1=3; break;
            case "e": y1=4; break;
            case "f": y1=5; break;
            case "g": y1=6; break;
            case "h": y1=7; break;
            default:y1=-1; break;
        }
        
        System.out.print("\n \n");




        while (p.getCase(x0,y0).estVide())
        {
            System.out.print("\n >>>>>>>>>>>>>"+ String.format("%10s",joueur.getNom())+"    <<<<<<<<<<<<< \n\n");
            System.out.print(" ++++++++++  Point De Départ ! ++++++++++ \n");
            System.out.print("\n Ligne  : ");
            // x0=sc.nextInt();
            //////////////// String Handling ////////////////
            s = sc.next();
            while ( isInt(s) == false ) {
                System.out.print("\n    Oups !!! Saisie Incorrecte !"+"\n"+"\n Veuillez re-saisir Svp\n  ");
                System.out.print("\n Ligne  : ");
                s = sc.next();
            }
            /////////////////////////////////////////////////
            x0 = Integer.parseInt(s)-1;

            System.out.print("\n Colonne : ");

            //////////////// String Handling ////////////////
            s = sc.next();
            while (s.isEmpty()) {
                System.out.print("\n    Oups !!! Saisie Incorrecte !"+"\n"+"\n Veuillez re-saisir Svp\n  ");
                System.out.print("\n Colonne : ");
                s = sc.next();
            }
            /////////////////////////////////////////////////

            //y0 = Integer.parseInt(s);

            switch (s)
            {
                case "a": y0=0; break;
                case "b": y0=1; break;
                case "c": y0=2; break;
                case "d": y0=3; break;
                case "e": y0=4; break;
                case "f": y0=5; break;
                case "g": y0=6; break;
                case "h": y0=7; break;
                default:y0=-1; break;
            }

            System.out.print("\n ++++++++++  Point D' Arrivé  ! ++++++++++ \n ");
            System.out.print("\n Ligne  : ");
            //////////////// String Handling ////////////////
            s = sc.next();
            while ( isInt(s) == false ) {
                System.out.print("\n    Oups !!! Saisie Incorrecte !"+"\n"+"\n Veuillez re-saisir Svp\n  ");
                System.out.print("\n Ligne : ");
                s = sc.next();
            }
            /////////////////////////////////////////////////
            x1=Integer.parseInt(s)-1;


            System.out.print("\n Colonne : ");
            //////////////// String Handling ////////////////
            s = sc.next();
            while (s.isEmpty()) {
                System.out.print("\n    Oups !!! Saisie Incorrecte !"+"\n"+"\n Veuillez re-saisir Svp \n  ");
                System.out.print("\n Colonne : ");
                s = sc.next();
            }
            /////////////////////////////////////////////////
            //y1=Integer.parseInt(s);
            switch (s)
            {
                case "a": y1=0; break;
                case "b": y1=1; break;
                case "c": y1=2; break;
                case "d": y1=3; break;
                case "e": y1=4; break;
                case "f": y1=5; break;
                case "g": y1=6; break;
                case "h": y1=7; break;
                default:y1=-1; break;
            }

            System.out.print("\n \n");

        }


        d=new Deplacement(x0,y0,x1,y1);



        return d;
    }

    public boolean demandeRejouer(Joueur j1,Joueur j2)
    {
        String verif;

        System.out.print("\n\n\n Voulez Vous Rejouuer ? (Y/N)  (O/N) \n");
        verif=sc.next();


        return verif.toString().toLowerCase().charAt(0)=='o'
                ||verif.toString().toLowerCase().charAt(0)=='y'
                ||verif.toString().toLowerCase()=="yes"
                ||verif.toString().toLowerCase()=="oui";

    }

    public void afficherScore(Joueur j1,Joueur j2)
    {
        System.out.print("\n\n +++++++++++++++++++++++++++++++++++++++++++++++ ");
        System.out.print("\n |  Joueur :  | "+String.format("%12s",j1.getNom())+"  |  "+String.format("%12s",j2.getNom())+"  |");
        System.out.print("\n +++++++++++++++++++++++++++++++++++++++++++++++ ");
        System.out.print("\n |  Score  :  | "+String.format("%12s",j1.getScore())+"  |  "+String.format("%12s",j2.getScore())+"  |");
        System.out.print("\n +++++++++++++++++++++++++++++++++++++++++++++++\n\n ");
    }
}
