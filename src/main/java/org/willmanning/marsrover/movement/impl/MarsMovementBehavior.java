package org.willmanning.marsrover.movement.impl;

import org.willmanning.marsrover.direction.Direction;
import org.willmanning.marsrover.movement.IMovementBehavior;
import org.willmanning.marsrover.position.IPosition;
import org.willmanning.marsrover.position.impl.Position;

/**
 * @author will
 *
 */
public class MarsMovementBehavior implements IMovementBehavior {

	/*
	 * (non-Javadoc)
	 * @see org.willmanning.thoughtworks.movement.
	 * IMovementBehavior#move(org.willmanning.thoughtworks.
	 * position.IPosition, org.willmanning.thoughtworks.direction.Direction)
	 */
	public final Position move(final IPosition position,
			final Direction direction) {

		Position newPosition = new Position(position);

		switch (direction) {
		case N:
			newPosition.setY(position.getY() + 1);
			break;
		case S:
			newPosition.setY(position.getY() - 1);
			break;
		case E:
			newPosition.setX(position.getX() + 1);
			break;
		case W:
			newPosition.setX(position.getX() - 1);
			break;
		default:
			System.err.println("Direction not supported");
		}

		return newPosition;
	}

}
