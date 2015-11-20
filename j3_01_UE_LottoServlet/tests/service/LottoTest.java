package service;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LottoTest {
	
	private Lotto lotto;

	@Before
	public void setUp() throws Exception {
	
		lotto = new Lotto();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLottozahlen() {
		Random r = new Random();
		int anz = r.nextInt(10000)+1;
		int max = 0;
		while (max < anz) {
			max = r.nextInt(Integer.MAX_VALUE);
		}
	
		assertTrue(lotto.getLottozahlen(anz, max).length==anz);
		// -auf NULL testen
		// - Array > 0 ?
		// -Doppelte Einträge?
		// -aller Werte kleiner max?
		// -negative Zahlen
		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetLottozahlenException(){
		lotto.getLottozahlen(10, 5);
	}
	

}
