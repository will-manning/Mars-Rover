/**
 * 
 */
package org.willmanning.thoughtworks.direction.impl;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.willmanning.thoughtworks.direction.Direction;
import org.willmanning.thoughtworks.direction.IDirectionBehavior;

/**
 * Test for {@link MarsDirectionBehavior}
 *
 * @author will
 *
 */
public class MarsDirectionTest {
	
	IDirectionBehavior directionBehavior = new MarsDirectionBehavior();

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
	 * test the
	 * {@link MarsDirectionBehavior#changeDirection(char, Direction)}
	 */
	@Test
	public void testChangeDirection()
	{
		//form N to E going R
		Assert.assertEquals(Direction.E, directionBehavior.changeDirection('R', Direction.N));

		//from W to N going R wrapping around
		Assert.assertEquals(Direction.N, directionBehavior.changeDirection('R', Direction.W));

		//from N to W going L wrapping around
		Assert.assertEquals(Direction.W, directionBehavior.changeDirection('L', Direction.N));
	}

}
