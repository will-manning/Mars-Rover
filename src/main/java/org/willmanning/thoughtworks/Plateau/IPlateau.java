package org.willmanning.thoughtworks.Plateau;

import org.willmanning.thoughtworks.position.IPosition;
import org.willmanning.thoughtworks.position.impl.Position;

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
