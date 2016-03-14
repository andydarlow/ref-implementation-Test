package oracle.tests.AndyMarsRover.model.commands;

import oracle.tests.AndyMarsRover.model.Rover;

/**
 * command performed by the robot.
 * Common baseline for all commands
 */
public abstract class Command {

	 public abstract Rover execute(Rover robot);
	 
	@Override
	//ensure that we have the same class to be the same... The class is stateless.
	public boolean equals(Object other) {
		return (other != null) && other.getClass() == getClass();
	}
	 
}
