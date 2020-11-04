/*
 * la classe grille
 */
package tp2_super_puissance4_emma_renois_etienne_nonnet;

/**
 *
 * @author Etienne Nonnet
 */
public class Grille {
    Cellule [][] Cellules = new Cellule [6][7];
    public Grille(){
        for(int i=0; i<6;i++){
            for (int j=0; j<7;j++){
                Cellules[i][j]=new Cellule();
            }
        }
    }
    
    public boolean ajouterJetonDansColonne(Jeton jeton_a_ajouter, int une_colonne){
        boolean reponse=false;//si le module ne renvoit rien c'est qu'il n'a pas marché
        int a;
        for(int i=0; i<5;i++){
            a=5-i;//on demarre de la cellule la plus basse de la colonne
            //Cellule c = Cellules[i][une_colonne];
            if (Cellules[a][une_colonne].jetonCourant==null){//si la cellule contient le jeton nul
                Cellules[a][une_colonne].jetonCourant=jeton_a_ajouter;//alors le jeton à ajouté ce met dans cette cellule
                reponse = true;//laors le programme a correctement fonctionné
                break;//on arret la boucle pour ce la remplissage s'arret apres l'ajoute d'un jeton
            }
        }
        return reponse;//on retourne si le jeton à etait correctement ajouté
        
    }
    public boolean etreRemplie(){
        boolean reponse=false;// initialisation à grille pas remplit
        int a=0;
        for(int i=0; i<6; i++){//on parcourt le tableau en long et en large
            for(int j=0; j<7;j++){
                if (Cellules[i][j].jetonCourant==null){//si une cellule n'a "pas" de jeton
                    a+=1; //alors a devient different de 0
                }
            }
        }
        if (a==0){//si est egal à 0 alors le tableau est remplit
            reponse=true;//le tableau est remplit
        }
        return reponse;
    }
    public void viderGrille(){
        for(int i=0; i<6; i++){//on parcourt le tableau en long et en large
            for(int j=0; j<7;j++){
                Cellules[i][j].jetonCourant=null;
            }
            
        }
    }
    public void afficherGrilleSurConsole(){// à faire en cours
        
    }
    public boolean celluleOccupee(int ligne_donnée ,int colonne_donnée){
        boolean reponse= false;
        if(Cellules[ligne_donnée][colonne_donnée].jetonCourant!=null){//si la cellule n'est pas vide (occupé)
            reponse= true;//la cellule est occupé
        }
        return reponse;
    }
    public String lireCouleurDuJeton(int ligne_donnée, int colonne_donnée){//premiere ligne premiere colonne =[0][0]
        
        String CouleurDuJeton=Cellules[ligne_donnée][colonne_donnée].jetonCourant.lireCouleur();//lit la couleur du jeton de la cellule des coordonnés donnés
        return CouleurDuJeton;//renvoit la couleur du jeton
    }
    
    public boolean etreGagnantePourJoueur(Joueur JoueurChoisit){
        boolean reponse= false;
        String CouleurDuJoueur= JoueurChoisit.Couleur;//la couleur associé au joueur
        //si 4 jeton aligné sur une ligne
        for(int i= 0; i<6; i++){
            int a=0;
            for(int j=0; j<7; j++){
                if (Cellules[i][j].jetonCourant.lireCouleur().equals(CouleurDuJoueur)){
                    a+=1;
                       
                }
                if (a==4){
                    reponse=true;
                }
            }
        }
        //si 4 jeton allignés sur une colonne
        for(int j=0 ; j<6; j++){
            int a=0;
            for(int i=0; i<7; i++){
                if (Cellules[i][j].jetonCourant.lireCouleur().equals(CouleurDuJoueur)){
                    a+=1;
                       
                }
                if (a==4){
                    reponse=true;

                }
            }
            
        }
        for(int i=0; i<3;i++){//on parcourt les lignes
            int a=0;
            for(int j=0; j<4; j++){//on parcourt les colonnes
                for(int k=0; k<3;k++){
                    if (Cellules[i+k][j+k].jetonCourant.lireCouleur().equals(CouleurDuJoueur)){
                        a+=1;
                       
                    }  
                    if (a==4){
                    reponse=true;
                    } 
                }
               
                
            }
        }
        //diagonal y=x
        for (int i=0; i<7; i++){//on parcourt la premiere ligne du tableau (i la colonne)
            int a=0;
            for (int k=0; k<7; k++){
                if (k<6 && (k+i)<7){//test si la cellule est dans le tableau
                    if (Cellules[0+k][i+k].jetonCourant.lireCouleur().equals(CouleurDuJoueur)){//si c'est la couleur du joueur
                        a+=1;
                    }
                    if (a==4){
                        reponse=true;
                    }
                }
                
            }
        }
        for (int i=0; i<6; i++){//on parcourt la colonne ligne du tabeau (i la ligne)
            int a=0;
            for (int k=0; k<7; k++){
                if (Cellules[i+k][0+k].jetonCourant.lireCouleur().equals(CouleurDuJoueur)){//si c'est la couleur du joueur
                    a+=1;
                }
                if (a==4){
                    reponse=true;
                }
            }
        }
    return reponse;
    }
    public void tasserGrille(){
        for (int i=5; i>0; i--){
            for (int j=6; i>0; i--){
                if (celluleOccupee(i,j)==true){
                    if (celluleOccupee(i,(j-1))==false){
                        Jeton jeton_a_deplacer = Cellules[i][j]
                        Cellules[i][j].jetonCourant=null;
                        
                        Cellules[i][j-1].jetonCourant=ajouterJetonDansColonne(jetonCourant,(j-1));
                    }
                }
                
            }
            
            
        }
    }
}
