/**
 * 
 */
package org.willmanning.marsrover.movement.impl;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.willmanning.marsrover.direction.Direction;
import org.willmanning.marsrover.movement.IMovementBehavior;
import org.willmanning.marsrover.movement.impl.MarsMovementBehavior;
import org.willmanning.marsrover.position.impl.Position;

/**
 * Test for {@link MarsMovementBehavior}
 * 
 * @author will
 *
 */
public class MarsMovementBehaviorTest {
	
	IMovementBehavior movementbehavior = new MarsMovementBehavior();

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
	 * test for {@link MarsMovementBehavior#
	 * move(org.willmanning.marsrover.position.IPosition, Direction)}
	 */
	@Test
	public void testMove()
	{
		Position position = new Position(0, 0);		
	
		//go north
		Position newPosition = movementbehavior.move(position, Direction.N);

		assertEquals(1, newPosition.getY());

		//go south
		newPosition = movementbehavior.move(position, Direction.S);

		assertEquals(-1, newPosition.getY());

		//go east
		newPosition = movementbehavior.move(position, Direction.E);

		assertEquals(1, newPosition.getX());

		//go west, where the grass is green
		newPosition = movementbehavior.move(position, Direction.W);

		assertEquals(-1, newPosition.getX());		
	}

}
