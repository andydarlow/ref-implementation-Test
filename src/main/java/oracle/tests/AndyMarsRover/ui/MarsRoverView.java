package oracle.tests.AndyMarsRover.ui;

import oracle.tests.AndyMarsRover.dao.IllegalCommandFoundException;
import oracle.tests.AndyMarsRover.model.Rover;
import oracle.tests.AndyMarsRover.model.commands.IllegalRoverMovementException;

//displays things out the user..
public interface MarsRoverView {

	void displayRobot(Rover robot);
	void displayMovementError(IllegalRoverMovementException e);
	void displayDAOError(IllegalCommandFoundException e);
}

