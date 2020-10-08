import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author emily
 *
 */
class DateTest {

	/**
	 * Test method for {@link Date#isValid()}.
	 */
	@Test
	void testIsValid() {
		Date d1 = new Date(11,31,2019);
		assertFalse(d1.isValid()); //expected output is false
		//fail("Not yet implemented");
	}

}