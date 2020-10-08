import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Emily Tronolone, Devin Gulati
 *
 */
class DateTest {

	/**
	 * Test method for {@link Date#isValid()}.
	 */
	@Test
	void testIsValid() {
		Date d1 = new Date(11, 31, 2019);
		Date d2 = new Date(2, 9, 2000);
		Date d3 = new Date(2, 29, 1900);
		Date d4 = new Date(1, 31, 2020);
		Date d5 = new Date(14, 1, 2010);
		assertFalse(d1.isValid()); //expected output is false
		assertTrue(d2.isValid());
		assertFalse(d3.isValid());
		assertTrue(d4.isValid());
		assertFalse(d5.isValid());
		//fail("Not yet implemented");
	}

}