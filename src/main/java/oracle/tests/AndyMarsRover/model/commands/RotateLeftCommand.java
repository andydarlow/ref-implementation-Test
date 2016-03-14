package oracle.tests.AndyMarsRover.model.commands;

import oracle.tests.AndyMarsRover.model.Rover;

public class RotateLeftCommand extends Command {

	@Override
	public Rover execute(Rover robot) {
		return robot.rotateLeft();
	}

}
