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
		assertEquals(c2.monthlyInterest(), 0.00);
		assertEquals(c3.monthlyInterest(), 0.00);
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
		Profile p2 = new Profile("Jerry", "Anderson");
		Date d2 = new Date(9,23,2020);
		Checking c1 = new Checking(p1, 1500, d1, false);
		Checking c2 = new Checking(p1, 0, d1, true);
		Checking c3 = new Checking(p1, 2000, d1, true);
		Checking c4 = new Checking(p1, 12345, d1, true);
		Checking c5 = new Checking(p1, 500, d1, false);
		Checking c6 = new Checking(p1, 1499, d1, false);
		Checking c7 = new Checking(p2, 1001.4, d2, false);
		assertEquals(c1.monthlyFee(), 0.00);
		assertEquals(c2.monthlyFee(), 0.00);
		assertEquals(c3.monthlyFee(), 0.00);
		assertEquals(c4.monthlyFee(), 0.00);
		assertEquals(c5.monthlyFee(), 25.00);
		assertEquals(c6.monthlyFee(), 25.00);
		assertEquals(c7.monthlyFee(), 25.00);
		//fail("Not yet implemented");
	}

}
