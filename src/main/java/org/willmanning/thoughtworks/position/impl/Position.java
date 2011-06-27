/**
 * 
 */
package org.willmanning.thoughtworks.position.impl;

import org.willmanning.thoughtworks.position.IPosition;

/**
 * The x and y coords
 * 
 * @author will
 *
 */
public class Position implements IPosition {

	/**
	 * x and y coords
	 */
	private int x, y;

	/**
	 * create a position with the given
	 * coords
	 *
	 * @param x the x coord
	 * @param y the y coord
	 */
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * copy constructor
	 *
	 * @param position {@link IPosition} to copy
	 */
	public Position(IPosition position) {
		this.x = position.getX();
		this.y = position.getY();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("x=" + x);
		builder.append(", ");
		builder.append("y=" + y);
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;
		Position position = (Position)obj;
		if (this.x == position.getX()
				&& this.y == position.getY())
			return true;

		return false;

	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return ((Integer)x).hashCode() ^ ((Integer)y).hashCode(); 
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

}
