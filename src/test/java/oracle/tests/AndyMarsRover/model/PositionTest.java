package oracle.tests.AndyMarsRover.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void testXBounds() {
		Position testCase = new Position(3,8);
		assertTrue(testCase.isWithinXBounds(1, 9));
		assertFalse(testCase.isWithinXBounds(99,100));
		assertFalse(testCase.isWithinXBounds(2,2));
		assertTrue(testCase.isWithinXBounds(1,3));
	}

	@Test
	public void testYBounds() {
		Position testCase = new Position(3,8);
		assertTrue(testCase.isWithinYBounds(1, 9));
		assertFalse(testCase.isWithinYBounds(99,100));
		assertFalse(testCase.isWithinYBounds(2,2));
		assertTrue(testCase.isWithinYBounds(7,9));	}
	
	@Test
	public void testMove() {
		assertEquals(new Position(12,11), new Position(10,10).move(2, 1));
		assertEquals(new Position(10,10), new Position(10,10).move(0, 0));
		assertEquals(new Position(8,11), new Position(10,10).move(-2, 1));
		assertEquals(new Position(12,9), new Position(10,10).move(2, -1));
	}
	
	@Test
	public void testEquals() {
		assertTrue(new Position(1,1).equals(new Position(1,1)));
		assertFalse(new Position(1,1).equals(new Position(0,1)));
		assertFalse(new Position(1,1).equals(new Position(1,0)));
		assertFalse(new Position(1,1).equals(new Position(0,0)));
		assertFalse(new Position(1,1).equals(null));
		assertFalse(new Position(1,1).equals(1));
	}
	
}
