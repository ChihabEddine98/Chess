
public class Deplacement {



    private int x0;
    private int y0;
    private int x1;
    private int y1;

    public Deplacement(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public char quelType()
    {
        char sortie='x';

        if( (x0==x1) && (y0!=y1)) // Déplacement Vertical
        {
            sortie='v';
        }
        else if((y0==y1) && (x0!=x1)) // Déplacement Horizontal
        {
            sortie='h';
        }
        else if((Math.abs(x1-x0)==2 && Math.abs(y1-y0)==1) ||
                (Math.abs(x1-x0)==1 && Math.abs(y1-y0)==2)) // Déplacement Cavalier
        {
            sortie='c';
        }
        else if(Math.abs(x1-x0)==Math.abs(y1-y0)) // Déplacement Diagonal
        {
            sortie='d';
        }

        else if((Math.abs(x1-x0)<=1 && Math.abs(y1-y0)<=1)) // Déplacement Du Roi
        {
            if (x0!=x1 || y0!=y1)
            {
                sortie='r';
            }

        }



        return sortie;

    }


    public int sqr(int a)
    {
        return a*a;

    }
    public int dist()
    {
        if(this.quelType()=='h' || this.quelType()=='v'
                || this.quelType()=='d')
        {

            return (int) Math.sqrt(sqr(y1-y0) + sqr(x1-x0));

        }
        else
        {
            return -1;
        }

    }

    public int dirHor()
    {
        if(y1>y0)
        {
            return 1;
        }
        else
        {
            if(y0>y1)
            {
                return -1;
            }

            else
            {
                return 0;
            }
        }
    }

    public int dirVer()
    {
        if(x1>x0)
        {
            return 1;
        }
        else
        {
            if(x0>x1)
            {
                return -1;
            }

            else
            {
                return 0;
            }
        }
    }






}
