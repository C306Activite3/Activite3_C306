/**
 * Devoir c306.
 * @author eddy.andriamanantena
 */   
    /**
     * Interface d'une grille de sudoku
     */
    public interface Grille {
     /**
      * Caractere de case vide
      */
     static final char EMPTY = '@';
     /**
      * Caractere possible a mettre dans la grille
      * 
      * pour une grille 9x9 : 1..9
      * 
          * pour une grille 16x16: 0..9-a..f
      */
     static final char[] possible = new char[] { '1', '2', '3', '4', '5', '6',
       '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f' };
     /**
      * @return largeur/hauteur de la grille
      */
     public int getDimension();
      /**
      * Affecte une valeur dans la grille
      * 
          * @param x       position x dans la grille
      * @param y       position y dans la grille
      * @param value
      *            valeur a mettre dans la case
      * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
          * @throw IllegalArgumentException si la valeur est interdite aux vues des
      *        autres valeurs de la grille
      * @throw IllegalArgumentException si value n'est pas un caractere autorise
      *        ('1',...,'9')
      */
     public void setValue(int x, int y, char value) throws IllegalArgumentException;
     /**
      * Recupere une valeur de la grille
      * 
      * @param x      position x dans la grille
      * @param y      position y dans la grille
          * @return valeur dans la case x,y
      * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
      */
     public char getValue(int x, int y) throws IllegalArgumentException;
     /**
      * Test si une grille est terminee
          * 
      * @return true si la grille est complete
      */
     public boolean complete() {
        public boolean complete(char[][] grille) {
            /* Recuperer la dimension */
            dim = grille.getDimension();
            /* Parcourir la grille */
            for (i=0; i<dim; i++) {
                for (j=0; j<dim; j++) {
                    val = grille.getValue(i,j);
                    /* Dès qu'une valeur est vide, on quitte la boucle */
                    if (val == '@') {
                        return False;
                        break;
                    }
                }
            }
            return True;
        }
     }
     /**
      * Test si une valeur est possible dans la grille par rapport a ce qu'elle
          * contient deja
      * 
      * @param x     position x dans la grille
      * @param y     position y dans la grille
      * @param value
          *            valeur a mettre dans la case
      * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
      * @throw IllegalArgumentException si value n'est pas un caractere autorise
      *        ('1',...,'9',..)
      */
     public boolean possible(int x, int y, char value) throws IllegalArgumentException;
    }
