package org.willmanning.thoughtworks.direction.impl;

import org.willmanning.thoughtworks.Constants.Constants;
import org.willmanning.thoughtworks.direction.Direction;
import org.willmanning.thoughtworks.direction.IDirectionBehavior;

/**
 * @author will
 *
 */
public class MarsDirectionBehavior implements IDirectionBehavior {

	/* (non-Javadoc)
	 * @see org.willmanning.thoughtworks.direction.IDirectionBehavior
	 * #changeDirection(char, org.willmanning.thoughtworks.rover.IRover)
	 */
	public Direction changeDirection(final char direction, final Direction currentDirection) {

		if (direction == Constants.LEFTCHAR)	{
			int newDirection = ((currentDirection
					.ordinal() - 1) % 3);
			if (newDirection < 0) {
				return Direction.values()[newDirection+4];
			} else {
				return Direction.values()[newDirection];
			}
		} else if (direction == Constants.RIGHTCHAR) {
			/*
			 * mod needs to be four because ((2+1) mod 3) == 0 when
			 * it should be 3
			 */
			return Direction.values()[((
					currentDirection.ordinal() + 1) % 4)];
		}

		return Direction.N;
	}

}
