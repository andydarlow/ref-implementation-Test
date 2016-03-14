package oracle.tests.AndyMarsRover.model.commands;

import oracle.tests.AndyMarsRover.model.Rover;

public class UnknownCommand extends Command {

	@Override
	public Rover execute(Rover robot) {
		throw new IllegalRoverMovementException(this,"don't understand the command you're making..");
	}
	
}
