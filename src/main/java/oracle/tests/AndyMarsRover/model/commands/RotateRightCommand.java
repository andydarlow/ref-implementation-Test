package oracle.tests.AndyMarsRover.model.commands;

import oracle.tests.AndyMarsRover.model.Rover;

public class RotateRightCommand extends Command {

	@Override
	public Rover execute(Rover robot) {
		return robot.rotateRight();
	}

}
