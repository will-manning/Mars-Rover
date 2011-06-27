package org.willmanning.thoughtworks.movement;

import org.willmanning.thoughtworks.direction.Direction;
import org.willmanning.thoughtworks.position.IPosition;
import org.willmanning.thoughtworks.position.impl.Position;
import org.willmanning.thoughtworks.rover.Rover;

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
