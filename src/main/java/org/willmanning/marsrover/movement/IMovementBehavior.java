package org.willmanning.marsrover.movement;

import org.willmanning.marsrover.direction.Direction;
import org.willmanning.marsrover.position.IPosition;
import org.willmanning.marsrover.position.impl.Position;
import org.willmanning.marsrover.rover.Rover;

/**
 * A Movement behavior that will be used by a {@link Rover}
 * to move itself
 *
 * @author will
 *
 */
public interface IMovementBehavior {
	/**
	 * move the {@link Rover} form the current {@link IPosition}
	 * in the given {@link Direction}
	 *
	 * @param position the start {@link IPosition} of the rover
	 * @param direction the {@link Direction} of the {@link Rover}
	 * @return the new {@link IPosition}
	 */
	Position move(IPosition position, Direction direction);
}
