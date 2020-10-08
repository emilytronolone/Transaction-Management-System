import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Emily Tronolone, Devin Gulati
 *
 */
class MoneyMarketTest {

	/**
	 * Test method for {@link MoneyMarket#monthlyInterest()}.
	 */
	@Test
	void testMonthlyInterest() {
		Profile p1 = new Profile("Emily", "Tronolone");
		Date d1 = new Date(1, 31, 2020);
		MoneyMarket m1 = new MoneyMarket(p1, 500, d1);
		MoneyMarket m2 = new MoneyMarket(p1, 0, d1);
		MoneyMarket m3 = new MoneyMarket(p1, -500, d1);
		MoneyMarket m4 = new MoneyMarket(p1, 12345, d1);
		assertEquals(m1.monthlyInterest(), 0.27);
		assertEquals(m2.monthlyInterest(), 0);
		assertEquals(m3.monthlyInterest(), 0);
		assertEquals(m4.monthlyInterest(), 6.69);
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link MoneyMarket#monthlyFee()}.
	 */
	@Test
	void testMonthlyFee() {
		Profile p1 = new Profile("Emily", "Tronolone");
		Date d1 = new Date(1, 31, 2020);
		MoneyMarket m1 = new MoneyMarket(p1, 2500, d1);
		m1.setWithdrawals(7);
		MoneyMarket m2 = new MoneyMarket(p1, 2501, d1);
		MoneyMarket m3 = new MoneyMarket(p1, 0, d1);
		MoneyMarket m4 = new MoneyMarket(p1, 12345, d1);
		m4.setWithdrawals(10);
		MoneyMarket m5 = new MoneyMarket(p1, -500, d1);
		MoneyMarket m6 = new MoneyMarket(p1, 2499, d1);
		MoneyMarket m7 = new MoneyMarket(p1, 3000, d1);
		assertEquals(m1.monthlyFee(), 12);
		assertEquals(m2.monthlyFee(), 0);
		assertEquals(m3.monthlyFee(), 12);
		assertEquals(m4.monthlyFee(), 12);
		assertEquals(m5.monthlyFee(), 12);
		assertEquals(m6.monthlyFee(), 12);
		assertEquals(m7.monthlyFee(), 0);
		//fail("Not yet implemented");
	}

}
