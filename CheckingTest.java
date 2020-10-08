import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Emily Tronolone, Devin Gulati
 *
 */
class CheckingTest {

	/**
	 * Test method for {@link Checking#monthlyInterest()}.
	 */
	@Test
	void testMonthlyInterest() {
		Profile p1 = new Profile("Emily", "Tronolone");
		Date d1 = new Date(1, 31, 2020);
		Checking c1 = new Checking(p1, 500, d1, true);
		Checking c2 = new Checking(p1, 0, d1, false);
		Checking c3 = new Checking(p1, -500, d1, true);
		Checking c4 = new Checking(p1, 12345, d1, false);
		assertEquals(c1.monthlyInterest(), 0.02);
		assertEquals(c2.monthlyInterest(), 0);
		assertEquals(c3.monthlyInterest(), 0);
		assertEquals(c4.monthlyInterest(), 0.51);
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Checking#monthlyFee()}.
	 */
	@Test
	void testMonthlyFee() {
		Profile p1 = new Profile("Emily", "Tronolone");
		Date d1 = new Date(1, 31, 2020);
		Checking c1 = new Checking(p1, 1500, d1, true);
		Checking c2 = new Checking(p1, 0, d1, false);
		Checking c3 = new Checking(p1, 2000, d1, false);
		Checking c4 = new Checking(p1, 12345, d1, false);
		Checking c5 = new Checking(p1, 500, d1, true);
		Checking c6 = new Checking(p1, 1499, d1, true);
		assertEquals(c1.monthlyFee(), 0);
		assertEquals(c2.monthlyFee(), 0);
		assertEquals(c3.monthlyFee(), 0);
		assertEquals(c4.monthlyFee(), 0);
		assertEquals(c5.monthlyFee(), 25);
		assertEquals(c6.monthlyFee(), 25);
		//fail("Not yet implemented");
	}

}
