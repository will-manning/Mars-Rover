package org.willmanning.marsrover.Plateau;

import org.willmanning.marsrover.position.IPosition;
import org.willmanning.marsrover.position.impl.Position;

/**
 * The plateau to explore
 *
 * @author will *
 */
public interface IPlateau {

	/**
	 * verify that the position is with the plateau
	 *
	 * @param position the {@link IPosition} to verify
	 * @return is the {@link IPosition} ok
	 */
	boolean verifyPosition(Position position);

}
