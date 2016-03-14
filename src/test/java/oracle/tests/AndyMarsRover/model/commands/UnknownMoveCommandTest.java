package oracle.tests.AndyMarsRover.model.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import oracle.tests.AndyMarsRover.model.Grid;
import oracle.tests.AndyMarsRover.model.Position;
import oracle.tests.AndyMarsRover.model.Rover;
import oracle.tests.AndyMarsRover.model.RoverOrientation;

public class UnknownMoveCommandTest {

	@Test
	public void test() {
		try {
			Grid testGrid = new Grid(4,4);
			Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(2,2));
			Rover result = new UnknownCommand().execute(testRobot);
			fail("should have errored");
		}
		catch (IllegalRoverMovementException e) {	
	    	assertEquals("don't understand the command you're making..",e.getMessage());

		}
			

	}

}
