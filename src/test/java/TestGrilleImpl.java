package miage.c306.dev2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * @author jeefntumba@gmail.com
 *
 */
public class TestGrilleImpl {
	/**
	* Tableau representant la grille sudoku.
	*/
	private char[][] tab;
	/**
	* l'objet a utiliser pour tous les tests.
	*/
	private GrilleImpl gimpl = new GrilleImpl();
	/**
	* Teste la methode setValue.
	*/
	@Test (expected = IllegalArgumentException.class)
	public final void testSetValue() {
		tab = gimpl.grille;
		tab[7][6] = '5';
		gimpl.setValue(6, 7, '5');
		assertEquals(gimpl.getValue(6, 7), 5);
	}
	/**
	* Teste la methode getValue.
	*/
	@Test (expected = IllegalArgumentException.class)
	public final void testGetValue() {
		assertEquals(gimpl.getValue(6, 7), '5');
	}
	/**
	* Teste la methode complete.
	*/
	@Test
	public final void testComplete() {
		assertFalse(gimpl.complete());
	}
	/**
	* Teste la methode possible.
	*/
	@Test (expected = IllegalArgumentException.class)
	public final void testPossible() {
		this.gimpl.grille[0][0] = '1';
		this.gimpl.grille[1][1] = '4';
		this.gimpl.grille[2][0] = '6';
		this.gimpl.grille[0][3] = '5';
		this.gimpl.grille[2][4] = '7';
		this.gimpl.grille[1][6] = '9';
		this.gimpl.grille[1][8] = '7';
		assertTrue(gimpl.possible(0, 1, '2'));
	}
}
