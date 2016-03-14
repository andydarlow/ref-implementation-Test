package oracle.tests.AndyMarsRover.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import oracle.tests.AndyMarsRover.model.commands.Command;
import oracle.tests.AndyMarsRover.model.commands.MoveForwardCommand;
import oracle.tests.AndyMarsRover.model.commands.RotateRightCommand;

public class RobotCommandTest {

	Grid testGrid = new Grid(5,5);
	
	@Test
	public void testMoveForwardAndLeft() {	
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
	public void testMoveForward() {	
		List<Command> testCommands = Arrays.asList(
				   new MoveForwardCommand(),
				   new MoveForwardCommand(),
				   new MoveForwardCommand(),
				   new MoveForwardCommand()
				);
		
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(0,0));
		Rover resultRobot = testRobot.execute(testCommands);
		assertEquals(resultRobot,new Rover(RoverOrientation.NORTH,testGrid, new Position(0,4)));		
	}

	
	@Test
	public void testMiander() {	
		List<Command> testCommands = Arrays.asList(
				   new MoveForwardCommand(),
				   new MoveForwardCommand(),
				   new RotateRightCommand(),
				   new MoveForwardCommand(),
				   new RotateRightCommand(),
				   new MoveForwardCommand(),
				   new MoveForwardCommand()
				);
		
		Rover testRobot = new Rover(RoverOrientation.NORTH,testGrid,new Position(0,0));
		Rover resultRobot = testRobot.execute(testCommands);
		assertEquals(resultRobot,new Rover(RoverOrientation.SOUTH,testGrid, new Position(1,0)));		
	}
	
	
	public void testGoOffGrid() {
	}
	
	
	/// more tests to do here...
	/// test right, test empty list, test spinning
	
	
}
