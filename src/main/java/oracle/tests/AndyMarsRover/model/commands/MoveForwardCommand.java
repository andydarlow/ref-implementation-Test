package oracle.tests.AndyMarsRover.model.commands;

import oracle.tests.AndyMarsRover.model.Rover;

public class MoveForwardCommand extends Command {

	@Override
	public Rover execute(Rover robot) {
		if (!robot.canMoveForward())
		   throw new IllegalRoverMovementException(this,"Oops, I'll fall off the grid");
		return robot.moveForward();
	}
	
}
