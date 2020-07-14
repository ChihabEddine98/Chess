
public class Joueur {

    private String nom;
    private int score;
    private int nbPieces; // nombre de pieces Réstantes
    private boolean couleur; // blanc: true
    private int deplacement;




    public Joueur() {


    }

    public Joueur(String nom, int score, int nbPieces, boolean couleur) {
        this.nom = nom;
        this.score = score;
        this.nbPieces = nbPieces;
        this.couleur = couleur;
        this.deplacement=0;
    }


    public int getNbPieces() {
        return nbPieces;
    }

    public boolean getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
    }

    public boolean isCouleur() {
        return couleur;
    }

    public void setCouleur(boolean couleur) {
        this.couleur = couleur;
    }

    public int getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", score=" + score +
                ", nbPieces=" + nbPieces +
                ", couleur=" + couleur +
                '}';
    }


}
