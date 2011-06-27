package org.willmanning.marsrover.Plateau.impl;

import org.willmanning.marsrover.Plateau.IPlateau;
import org.willmanning.marsrover.position.IPosition;
import org.willmanning.marsrover.position.impl.Position;

/**
 * The plateau to explore
 * 
 * @author will
 *
 */
public class Plateau implements IPlateau {

	/**
	 * storage for the size of teh plateau
	 */
	private int maxX, maxY, minX, minY;

	/**
	 * create a plateau of the given size
	 *
	 * @param maxXIn x axis max
	 * @param maxYIn y axis max
	 * @param minXIn x axis min
	 * @param minYIn y axis min
	 */
	public Plateau(int maxXIn, int maxYIn,
			int minXIn, int minYIn) {
		maxX = maxXIn;
		maxY = maxYIn;

		minX = minXIn;
		minY = minYIn;
	}

	/**
	 * verify the given position is on the plateau
	 *
	 * @param position the {@link IPosition} to verify
	 * @return is the position on the plateau
	 */
	public boolean verifyPosition(Position position) {
		if ((position.getX() <= maxX
				&& position.getX() >= minX)
				&& (position.getY() <= maxY
				&& position.getY() >= minY)) {
			return true;
		}
		return false;
	}

}
