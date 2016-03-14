package oracle.tests.AndyMarsRover.ui;

import oracle.tests.AndyMarsRover.dao.IllegalCommandFoundException;
import oracle.tests.AndyMarsRover.model.Rover;
import oracle.tests.AndyMarsRover.model.commands.IllegalRoverMovementException;

public class ConsoleMarsRoverView implements MarsRoverView {

	@Override
	public void displayRobot(Rover robot) {
		System.out.println(robot.toString());

	}

	@Override
	public void displayMovementError(IllegalRoverMovementException e) {
		System.out.println("there was a problem moving the Rover : " + e.getMessage());
	};

	@Override
	public void displayDAOError(IllegalCommandFoundException e) {
		System.out.println("there was Parsing the commands : " + e.getMessage());
	}

}
