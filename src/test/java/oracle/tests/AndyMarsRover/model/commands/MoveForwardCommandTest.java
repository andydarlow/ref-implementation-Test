package oracle.tests.AndyMarsRover.model.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import oracle.tests.AndyMarsRover.model.Grid;
import oracle.tests.AndyMarsRover.model.Position;
import oracle.tests.AndyMarsRover.model.Rover;
import oracle.tests.AndyMarsRover.model.RoverOrientation;

public class MoveForwardCommandTest {

	@Test
	public void testSimpleForward() {
		Grid testGrid = new Grid(4,4);
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(1,1));
		Rover result = new MoveForwardCommand().execute(testRobot);
		assertEquals(new Rover(RoverOrientation.NORTH,testGrid,new Position(1,2)),result);
	}
	
	@Test
	public void testMultiForward() {
		Grid testGrid = new Grid(4,4);
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(1,1));
		Rover result = new MoveForwardCommand().execute(new MoveForwardCommand().execute(testRobot));
		assertEquals(new Rover(RoverOrientation.NORTH,testGrid,new Position(1,3)),result);
	}
	
	
	@Test
	public void testSimpleRotateThenForward() {
		Grid testGrid = new Grid(4,4);
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(1,1));
		Rover result = new MoveForwardCommand().execute(new RotateRightCommand().execute(testRobot));
		assertEquals(new Rover(RoverOrientation.EAST,testGrid,new Position(2,1)),result);
	}

	@Test
	public void testSimpleMultiRotateThenForward() {
		Grid testGrid = new Grid(4,4);
		Rover testRobot = new Rover(RoverOrientation.SOUTH,testGrid,new Position(1,1));
		Rover result = new MoveForwardCommand().execute(
				             new RotateLeftCommand().execute(
				            		         new RotateLeftCommand().execute(testRobot)));
		assertEquals(new Rover(RoverOrientation.NORTH,testGrid,new Position(1,2)),result);
	}
	
	
	@Test
	public void testMoveOffGridForward() {
		try {
		   Grid testGrid = new Grid(4,4);
		   Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(1,4));
		   Rover result = new MoveForwardCommand().execute(testRobot);
		   fail("should off gone off grid");
		}
		catch (IllegalRoverMovementException e){
			assertTrue(e.getCauseOfException() instanceof MoveForwardCommand);
		}
	}
	
	
}
