package org.willmanning.marsrover.rover;

import org.willmanning.marsrover.Constants.Constants;
import org.willmanning.marsrover.Plateau.IPlateau;
import org.willmanning.marsrover.Plateau.impl.Plateau;
import org.willmanning.marsrover.direction.Direction;
import org.willmanning.marsrover.direction.IDirectionBehavior;
import org.willmanning.marsrover.movement.IMovementBehavior;
import org.willmanning.marsrover.position.IPosition;
import org.willmanning.marsrover.position.impl.Position;

/**
 *
 * An interface for a rover. A rover is an
 * extra-terrestrial vehicle
 *
 * @author will
 *
 */
public abstract class Rover {

	/**
	 * The rovers position
	 */
	private IPosition position = new Position(0,0);
	/**
	 * The rovers position
	 */
	private Direction direction = Direction.N;
	/**
	 * The rovers position
	 */
	private IDirectionBehavior directionBehavior;
	/**
	 * The rovers position
	 */
	private IMovementBehavior movementBehavior;
	/**
	 * The rovers position
	 */
	private IPlateau plateau;

	/**
	 * Create a rover and set the given args
	 * 
	 * @param plateauIn The {@link IPlateau} for the {@link Rover}
	 * @param directionBehaviorIn The {@link IDirectionBehavior}
	 * @param movementBehaviorIn The {@link IMovementBehavior}
	 */
	public Rover(final IPlateau plateauIn,
			final IDirectionBehavior directionBehaviorIn,
			final IMovementBehavior movementBehaviorIn)	{
		this.plateau = plateauIn;
		this.directionBehavior = directionBehaviorIn;
		this.movementBehavior = movementBehaviorIn;
	}

	/**
	 * Process the movement commands for this Rover
	 *
	 * The string must only contain valid chars
	 * e.g. MRRMLLM = move, right, right, move, left etc.
	 *
	 * @param commands The {@link String} of commands
	 */
	public final void processCommands(final String commands) {
		for (char charac : commands.toCharArray()) {
			switch (charac) {
			case Constants.MOVEMENTCHAR:
				this.move();
				break;
			case Constants.LEFTCHAR:
				this.changeDirection(charac);
				break;
			case Constants.RIGHTCHAR:
				this.changeDirection(charac);
				break;
			default:
				System.err.println(charac + " is not a valid "
						+ "command");
			}
		}
	}

	/**
	 * Move the rover according to the {@link IMovementBehavior}
	 */
	public final void move() {

		Position newPosition = movementBehavior.move(
				position, direction);

		if (plateau.verifyPosition(newPosition)) {
			position = new Position(newPosition);
		}

	}

	/**
	 * Get the direction that the rover is currently facing
	 *
	 * @return The direction
	 *
	 */
	public Direction getDirection() { return direction; }

	/**
	 * Change the direction that the rover is facing
	 *
	 * @param directionRotate The direction to rotate, must be
	 * a valid value from {@link Constants}
	 */
	public void changeDirection(final char directionRotate) {
		direction = directionBehavior.changeDirection(
				directionRotate, this.direction);
	}

	/**
	 * @return the {@link IDirectionBehavior}
	 */
	public IDirectionBehavior getDirectionBehavior() {
		return directionBehavior;
	}

	/**
	 * @param directionBehaviorIn the {@link IDirectionBehavior} to set
	 */
	public void setDirectionBehavior(final IDirectionBehavior
			directionBehaviorIn) {
		directionBehavior = directionBehaviorIn;
	}


	/**
	 * @param directionIn the direction to set
	 */
	public void setDirection(Direction directionIn) {
		direction = directionIn;
	}


	/**
	 * @return the {@link IPosition}
	 */
	public IPosition getPosition() {
		return position;
	}


	/**
	 * @param positionIn the {@link IPosition} to set
	 */
	public void setPosition(Position positionIn) {
		position = positionIn;
	}


	/**
	 * @return the {@link IMovementBehavior}
	 */
	public IMovementBehavior getMovementBehavior() {
		return movementBehavior;
	}


	/**
	 * @param movementBehaviorIn the {@link IMovementBehavior} to set
	 */
	public void setMovementBehavior(IMovementBehavior movementBehaviorIn) {
		movementBehavior = movementBehaviorIn;
	}


	/**
	 * @param plateauIn the {@link Plateau} to set
	 */
	public void registerPlateau(IPlateau plateauIn) {
		plateau = plateauIn;
	}

	/**
	 * @return the plateau
	 */
	public IPlateau getPlateau() {
		return plateau;
	}

	/**
	 * @param plateau the {@link IPlateau} to set
	 */
	public void setPlateau(IPlateau plateau) {
		this.plateau = plateau;
	}

	/**
	 * @param position the {@link IPosition} to set
	 */
	public void setPosition(IPosition position) {
		this.position = position;
	};

}
