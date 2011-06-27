/**
 * 
 */
package org.willmanning.thoughtworks.rover.impl;

import org.willmanning.thoughtworks.Plateau.IPlateau;
import org.willmanning.thoughtworks.direction.Direction;
import org.willmanning.thoughtworks.direction.IDirectionBehavior;
import org.willmanning.thoughtworks.direction.impl.MarsDirectionBehavior;
import org.willmanning.thoughtworks.movement.IMovementBehavior;
import org.willmanning.thoughtworks.rover.Rover;

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
