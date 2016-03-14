package oracle.tests.AndyMarsRover.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RobotOrientationTest {

	@Test
	public void testNorth() {
		assertEquals(RoverOrientation.NORTH.right(),RoverOrientation.EAST);
		assertEquals(RoverOrientation.NORTH.left(),RoverOrientation.WEST);
		assertEquals(RoverOrientation.NORTH.forward(new Position(100,100)),new Position(100,101));
	}

	@Test
	public void testEAST() {
		assertEquals(RoverOrientation.EAST.left(),RoverOrientation.NORTH);
		assertEquals(RoverOrientation.EAST.right(),RoverOrientation.SOUTH);
		assertEquals(RoverOrientation.EAST.forward(new Position(100,100)),new Position(101,100));
	}
	
	@Test
	public void testSouth() {
		assertEquals(RoverOrientation.SOUTH.left(),RoverOrientation.EAST);
		assertEquals(RoverOrientation.SOUTH.right(),RoverOrientation.WEST);
		assertEquals(RoverOrientation.SOUTH.forward(new Position(100,100)),new Position(100,99));
	}

	@Test
	public void testWest() {
		assertEquals(RoverOrientation.WEST.left(),RoverOrientation.SOUTH);
		assertEquals(RoverOrientation.WEST.right(),RoverOrientation.NORTH);
		assertEquals(RoverOrientation.WEST.forward(new Position(100,100)),new Position(99,100));
	}
	
	
}
