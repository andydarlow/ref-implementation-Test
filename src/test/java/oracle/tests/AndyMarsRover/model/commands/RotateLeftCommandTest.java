package oracle.tests.AndyMarsRover.model.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import oracle.tests.AndyMarsRover.model.Grid;
import oracle.tests.AndyMarsRover.model.Position;
import oracle.tests.AndyMarsRover.model.Rover;
import oracle.tests.AndyMarsRover.model.RoverOrientation;

public class RotateLeftCommandTest {

	@Test
	public void testSingleRotate() {
		Grid testGrid = new Grid(4,4);
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(2,2));
		Rover result = new RotateLeftCommand().execute(testRobot);
		assertEquals(new Rover(RoverOrientation.WEST,testGrid,new Position(2,2)),result);
	}

	@Test
	public void testTwoRotate() {
		Grid testGrid = new Grid(4,4);
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(2,2));
		Rover result = new RotateLeftCommand().execute(
				                   new RotateLeftCommand().execute(testRobot));
		assertEquals(new Rover(RoverOrientation.SOUTH,testGrid,new Position(2,2)),result);
	}

	@Test
	public void testThreeRotate() {
		Grid testGrid = new Grid(4,4);
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(2,2));
		Rover result = new RotateLeftCommand().execute(
				                   new RotateLeftCommand().execute(
				                		   new RotateLeftCommand().execute(testRobot) 
				                		   ));
		assertEquals(new Rover(RoverOrientation.EAST,testGrid,new Position(2,2)),result);
	}
	
	
	@Test
	public void testRotateCircle() {
		Grid testGrid = new Grid(4,4);
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(2,2));
		Rover result = new RotateLeftCommand().execute(
				                   new RotateLeftCommand().execute(
				                		   new RotateLeftCommand().execute(
				                				   new RotateLeftCommand().execute(testRobot)
				                				   )));
		assertEquals(new Rover(RoverOrientation.NORTH,testGrid,new Position(2,2)),result);
	}

}
