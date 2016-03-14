package oracle.tests.AndyMarsRover.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridTest {

	@Test
	public void test() {
	  Grid testCase = new Grid(4,4);
	  assertTrue(testCase.isOnGrid(new Position(0,0)));
	  assertTrue(testCase.isOnGrid(new Position(2,2)));
	  assertFalse(testCase.isOnGrid(new Position(4,4)));
	  assertFalse(testCase.isOnGrid(new Position(5,4)));
	  assertFalse(testCase.isOnGrid(new Position(5,5)));
	  assertFalse(testCase.isOnGrid(new Position(4,5)));

	}

}
