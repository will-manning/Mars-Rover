package org.willmanning.thoughtworks.missionControl;

import java.util.ArrayList;

import org.willmanning.thoughtworks.Plateau.impl.Plateau;
import org.willmanning.thoughtworks.direction.Direction;
import org.willmanning.thoughtworks.direction.IDirectionBehavior;
import org.willmanning.thoughtworks.direction.impl.MarsDirectionBehavior;
import org.willmanning.thoughtworks.movement.IMovementBehavior;
import org.willmanning.thoughtworks.movement.impl.MarsMovementBehavior;
import org.willmanning.thoughtworks.position.impl.Position;
import org.willmanning.thoughtworks.rover.Rover;
import org.willmanning.thoughtworks.rover.impl.MarsRover;

/**
 * The {@link MissionControl} class is the control centre
 * for extra terrestrial missions.
 *
 * The {@link MissionControl} class creates:
 * {@link Plateau} the area to be explored.
 * {@link ArrayList} of {@link Rover} which will be used to explore the
 * {@link Plateau}.
 * {@link IMovementBehavior} and {@link IDirectionBehavior} to pass
 * to the {@link Rover} to specify it's behaviour
 *
 * @author will
 *
 */
public class MissionControl {

	/**
     * The plateau to explore
     */
	private Plateau plateau;
	
	/** 
	 * The movement behaviour to pass
	 * to the Rover
	 */
    private IMovementBehavior movementBehavior;

    /** 
	 * The direction behaviour to pass
	 * to the Rover
	 */
	private IDirectionBehavior directionBehavior;

	/**
	 * The rover to use to explore the Plateau 
	 */
	private ArrayList<Rover> rovers;

	/**
	 * Using an input string create a plateau and the
	 * appropriate amount of rovers. Move the 
	 * rovers according to the input string
	 * 
	 * An example of an input string:
	 * 5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM
	 * 
	 * The first two digits map the max x & y size of the plateau
	 * 
	 * The next two digits are the starting point of the first rover.
	 * The following character is the initial direction of the rover.
	 * The next string of digits are movement instructions
	 * M: move forward
	 * L: rotate left
	 * R: rotate right
	 * 
	 * The next digit signals a new rover and the process starts over.
	 * 
	 * @param input The input string to parse
	 * @return 
	 * A string describing the final resting place and direction of the rovers
	 * in the format 1 3 N 5 1 E. Each rover has 3 chars, the current location
	 * and the direction
	 */
	public String beginMarsMission(String input)
	{

		StringBuilder output = new StringBuilder();

		String plateauInput = input.substring(0, 3);

		plateau = new Plateau(new Integer(plateauInput.charAt(0))
		, new Integer(plateauInput.charAt(2)), 0, 0);

		movementBehavior = new MarsMovementBehavior();
		directionBehavior = new MarsDirectionBehavior();

		/*
		 * Create and move the rovers
		 */
		rovers = createRovers(input.substring(4, input.length()));

		//create the output string
		for (Rover rover : rovers) {
			output.append(rover.getPosition().getX() + " ");
			output.append(rover.getPosition().getY() + " ");
			output.append(rover.getDirection().name() + " ");
		}

		return output.toString().trim();
	}

	/**
	 * Break the input string up on a per rover basis and call
	 * {@link MissionControl.createAndMoveRover(String)} for
	 * each rover
	 *
	 * @param input The input string with instructions on how to create
	 * and move the rover
	 *
	 * @return {@link ArrayList} of {@link Rover}
	 */
	public final ArrayList<Rover> createRovers(final String input) {

		ArrayList<Rover> roversL = new ArrayList<Rover>();

		char[] charInput = input.trim().toCharArray();

		int whiteSpace = 0;
		int startPoint = 0;

		for (int i = 0; i < charInput.length; i++) {
			if (Character.isWhitespace(charInput[i])
					|| i == charInput.length - 1) {
				if (whiteSpace == 3) {
					roversL.add(createAndMoveRover(
						input.substring(startPoint,
								i + 1).trim()));

					whiteSpace = 0;
					startPoint = i;
					continue;
				}
				whiteSpace++;
			}
		}

		return roversL;
	}

	/**
	 * Create and move a {@link Rover} according to the instructions in
	 * and input string
	 *
	 * @param input A per rover instruction string containing the initial
	 * start position and direction as well as movement instructions
	 *
	 * @return The created {@link Rover}
	 */
	public final Rover createAndMoveRover(final String input) {
		char[] charInput = input.toCharArray();

		Rover rover = new MarsRover(plateau, directionBehavior,
				movementBehavior);

		rover.setPosition(new Position(
				new Integer(Character.toString(charInput[0])),
				new Integer(Character.toString(charInput[2]))));

		rover.setDirection(Direction.valueOf(
				Character.toString(charInput[4])));

		//time to move the rover
		rover.processCommands(input.substring(5, input.length())
				.trim());

		return rover;
	}

}
