/**
 * 
 */
package org.willmanning.thoughtworks.direction;

/**
 * The interface for a direction behavior that will be used by a
 * {@link Rover} to rotate itself
 *
 * @author will
 *
 */
public interface IDirectionBehavior {

	/**
	 * Rotate the given {@link Rover} in the given {@link Direction}
	 *
	 * @param direction The {@link Direction} to rotate in
	 * @param currentDirection The {@link Rover} current {@link Direction}
	 * 
	 *  @return The new {@link Direction} of rotation
	 */
	Direction changeDirection(char direction,
			Direction currentDirection);

}
