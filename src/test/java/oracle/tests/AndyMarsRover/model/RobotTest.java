package oracle.tests.AndyMarsRover.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import oracle.tests.AndyMarsRover.model.commands.Command;
import oracle.tests.AndyMarsRover.model.commands.MoveForwardCommand;
import oracle.tests.AndyMarsRover.model.commands.RotateRightCommand;

//most code tested in other places but worth repeating here.
public class RobotTest {

	Grid testGrid = new Grid(5,5);
	
	@Test
	public void testExecuteStreamOfCommand() {
		List<Command> testCommands = Arrays.asList(
				   new MoveForwardCommand(),
				   new MoveForwardCommand(),
				   new RotateRightCommand(),
				   new MoveForwardCommand()
				);
		
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(0,0));
		Rover resultRobot = testRobot.execute(testCommands);
		assertEquals(resultRobot,new Rover(RoverOrientation.EAST,testGrid, new Position(1,2)));		
	}

	@Test
	public void testExecuteCommand() {
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(0,0));
		Rover resultRobot = testRobot.execute(new MoveForwardCommand());
		assertEquals(resultRobot,new Rover(RoverOrientation.NORTH,testGrid, new Position(0,1)));		
	}

	@Test
	public void testRotateLeft() {
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(0,0));
		Rover resultRobot = testRobot.rotateLeft();
		assertEquals(resultRobot,new Rover(RoverOrientation.WEST,testGrid, new Position(0,0)));		
	}

	@Test
	public void testRotatatRight() {
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(1,1));
		Rover resultRobot = testRobot.rotateRight();
		assertEquals(resultRobot,new Rover(RoverOrientation.EAST,testGrid, new Position(1,1)));		
	}

	@Test
	public void testCanMoveForward() {
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(1,4));
		Rover resultRobot = testRobot.moveForward();
		assertFalse(resultRobot.canMoveForward());		
	}

	@Test
	public void testMoveForward() {
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(1,3));
		assertTrue(testRobot.canMoveForward());
		Rover resultRobot = testRobot.moveForward();
		assertFalse(resultRobot.canMoveForward());		
	}

	@Test
	public void testEqualsObject() {
		assertTrue(new Rover(RoverOrientation.EAST,testGrid, new Position(0,0))
				   .equals(new Rover(RoverOrientation.EAST,testGrid, new Position(0,0))));		

		assertFalse(new Rover(RoverOrientation.EAST,testGrid, new Position(0,0))
				   .equals(new Rover(RoverOrientation.WEST,testGrid, new Position(0,0))));		

		assertFalse(new Rover(RoverOrientation.EAST,testGrid, new Position(0,0))
				.equals(null));		
		
		assertFalse(new Rover(RoverOrientation.EAST,testGrid, new Position(0,0))
						.equals(new Rover(RoverOrientation.EAST,testGrid, new Position(0,1))));		

	}


}
