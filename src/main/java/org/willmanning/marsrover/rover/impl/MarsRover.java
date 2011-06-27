/**
 * 
 */
package org.willmanning.marsrover.rover.impl;

import org.willmanning.marsrover.Plateau.IPlateau;
import org.willmanning.marsrover.direction.Direction;
import org.willmanning.marsrover.direction.IDirectionBehavior;
import org.willmanning.marsrover.direction.impl.MarsDirectionBehavior;
import org.willmanning.marsrover.movement.IMovementBehavior;
import org.willmanning.marsrover.rover.Rover;

/**
 * A Rover implementation specific to mars
 *
 * Changing the direction rotates the rover 90
 * degrees in the given direction.
 *
 * Moving the rover moves it one position in 
 * the given direction.
 *
 * @author will
 *
 */
public class MarsRover extends Rover {

	public MarsRover(IPlateau plateau, IDirectionBehavior directionBehavior,
			IMovementBehavior movementBehavior) {
		super(plateau, directionBehavior, movementBehavior);
	}

}
