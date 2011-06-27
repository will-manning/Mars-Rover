/**
 * 
 */
package org.willmanning.thoughtworks.rover.impl;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.willmanning.thoughtworks.Plateau.impl.Plateau;
import org.willmanning.thoughtworks.direction.Direction;
import org.willmanning.thoughtworks.direction.impl.MarsDirectionBehavior;
import org.willmanning.thoughtworks.movement.impl.MarsMovementBehavior;
import org.willmanning.thoughtworks.position.impl.Position;
import org.willmanning.thoughtworks.rover.Rover;

/**
 * Test for {@link MarsRover} 
 * 
 * @author will
 *
 */
public class MarsRoverTest {

	/**
	 * The rover to test
	 */
	Rover rover;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rover = new MarsRover(new Plateau(5, 5, 0, 0), new MarsDirectionBehavior(),
				new MarsMovementBehavior());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test for {@link MarsRover#move()}
	 */
	@Test
	public void testMove()
	{
		//test moving below the min values
		rover.setDirection(Direction.S);
		rover.move();

		assertEquals(new Position(0,0), rover.getPosition());	

		//test moving above the max values
		rover.setPosition(new Position(5, 5));
		rover.setDirection(Direction.N);
		rover.move();

		assertEquals(new Position(5,5), rover.getPosition());

		//positive tests
		rover.setPosition(new Position(0, 0));
		rover.setDirection(Direction.N);
		rover.move();

		assertEquals(new Position(0,1), rover.getPosition());

		rover.setPosition(new Position(0, 0));
		rover.setDirection(Direction.E);
		rover.move();

		assertEquals(new Position(1,0), rover.getPosition());

	}

}
