package miage.c306.dev2;

import java.util.Scanner;
/**
 * @author jeefntumba@gmail.com
 *
 */
public class GrilleImpl implements Grille {
	/**
	* borne  region 1 (0,0 - 2,2) 3X3.
	*/
	static final int REGION1 = 0;
	/**
	* borne  region 2 (3,3 - 5,5) 3X3.
	*/
	static final int REGION2 = 3;
	/**
	* borne  region 3 (6,6 - 8,8) 3X3.
	*/
	static final int REGION3 = 6;
	/**
	* borne  sup. 9X9.
	*/
	static final int BORNE = 9;
	/**
	/**
	* borne  sup. 9X9.
	*/
	static final int BORNE_SUP_TOUS = 16;
	/**
	*  calcule borne inferieure  region 2.
	*/
	static final int BORNER2 = 3;
	/**
	*  calcule borne inferieure  region 2.
	*/
	static final int BORNER3 = 6;
	/**
	* la grille sudoku.
	*/
	char[][] grille;
	/**
	* constructeur cree une grille 9X9.
	*/
	public GrilleImpl() {
		this.grille = new char[BORNE][BORNE];
		generateGrille();
	}
	@Override
	public final void setValue(final int x, final int y, final char value)
			throws IllegalArgumentException {
				System.out.println(x+" "+y+" "+value);
		if (possible(x, y,value)) {
			//[y][x]
			if (this.grille[y][x] == Grille.EMPTY) {
				this.grille[y][x] = value;
			}
		}
	}
	@Override
	public final char getValue(final int x, final int y)
	throws IllegalArgumentException {
		if (isBornePossible(x, y)) {
			throw new IllegalArgumentException();
		}
		return this.grille[y][x];
	}

	@Override
	public final boolean complete() {
		for (int y = 0; y < BORNE; y++) {
			for (int x = 0; x < BORNE; x++) {
				if (grille [y][x] == Grille.EMPTY) {
				return  false;
				}
			}
		}
		return true;
	}
	@Override
	public final boolean possible(final int x,
	final int y, final char value)
			throws IllegalArgumentException {
				//verification dans la ligne
				for (int i = 0; i < BORNE; i++) {
					if (this.grille[y][i] == value) {
						return false;
					}
				}
				//verification dans la colonne
				for (int i = 0; i < BORNE; i++) {
					if (this.grille[i][x] == value) {
						return false;
					}
				}
				int regionx = regionCord(x);
				int regiony = regionCord(y);
				for (int j = regiony;
				j <= regiony + 2; j++) {
					for (int i = regionx;
					i <= regionx + 2; i++) {
						if (this.grille[j][i]
						== value) {
							return false;
						}
					}
				}
				if (!isBornePossible(x, y)
					|| !isPossible(value)) {
					throw new IllegalArgumentException();
				}
				return true;
	}
	/**
	 * cherche une region 3X3 sudoku.
	 * @param cord le parametre
	 * @return la borne inferieure pou x ou y
	 */
	private int regionCord(final int cord) {
		if (cord >= 0 && cord < BORNER2) {
			 return REGION1;
		} else if (cord >= BORNER2 && cord < BORNER3) {
			return REGION2;
		} else if (cord >= BORNER3 && cord < BORNE) {
			return REGION3;
		}
		return -1;
	}
	
	/**
	 * Test si est un caractere autorise.
	 * @param value  valeur
	 * @return vrai si valeur possible
	 */
	public final boolean isPossible(final char value) {
		for (int i = 0; i < BORNE_SUP_TOUS; i++) {
			if (Grille.possible[i] == value) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Test si est un caractere autorise.
	 * @param x  borne colonne
	 * @param y  borne ligne
	 * @return vrai si borne normale
	 */
	public final boolean isBornePossible(final int x, final int y) {
		if ((x >= 0 && x < BORNE) && (y  >= 0 && y < BORNE)) {
			return true;
		}
		return false;
	}
	/*
		METHODES ACTIVITE 3
	/**
	 * genere une grille 9 X 9 contenant '@'.
	 */
	public final void generateGrille() {
		for (int y = 0; y < BORNE; y++) {
			for (int x = 0; x < BORNE; x++) {
				grille [y][x] = Grille.EMPTY;
			}
		}
	}
	/**
	* affiche la grille sudoku.
	*/
	public void affiche(){
		System.out.println("===================");
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++){
				System.out.print("|" + grille[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("===================");
	}
	public static void main(String[] args) {
		GrilleImpl sudoku = new GrilleImpl();
		sudoku. affiche();
		
		String chaine;
		char valeur;
		int ligne;
		int colonne;
		
			while(!sudoku.complete()){	
			System.out.println("Entrez la valeur:");
			Scanner s = new Scanner(System.in);
			 chaine = s.nextLine();
			 System.out.println("Entrez respectivement la ligne et la colonne :");
			 valeur = chaine.charAt(0);
			 ligne = s.nextInt();
			 colonne = s.nextInt();
				try{
					sudoku.setValue(ligne, colonne,valeur);
				}catch(IllegalArgumentException e){
					System.out.println("l'application viend de lever illegaArmentException ");
				}
				System.out.println("apres insertion");
				sudoku.affiche();
			}
	}
}
