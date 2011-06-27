/**
 * 
 */
package org.willmanning.thoughtworks.missionControl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author will
 *
 */
public class MissionControlTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.willmanning.
	 * thoughtworks.missionControl.MissionControl#
	 * beginMarsMission(java.lang.String)}.
	 */
	@Test
	public void testBeginMarsMission() {
		MissionControl mission = new MissionControl();

		String output = mission.beginMarsMission(
				"5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");

		assertEquals("1 3 N 5 1 E", output.trim());
	}

}
