package oracle.tests.AndyMarsRover.ui.parsers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import oracle.tests.AndyMarsRover.dao.IllegalCommandFoundException;
import oracle.tests.AndyMarsRover.dao.characters.CharacterToCommandParser;
import oracle.tests.AndyMarsRover.model.commands.Command;
import oracle.tests.AndyMarsRover.model.commands.MoveForwardCommand;
import oracle.tests.AndyMarsRover.model.commands.RotateLeftCommand;
import oracle.tests.AndyMarsRover.model.commands.RotateRightCommand;

public class CommandParserTest {

	private CharacterToCommandParser testCase = new CharacterToCommandParser();
	
	@Test
	public void testSimpleParser() {
	    List<Command> resultSet = testCase.parse("FFFLLLR");
   	    assertEquals(7,resultSet.size());
   	    assertEquals(new MoveForwardCommand(),resultSet.get(0));
  	    assertEquals(new MoveForwardCommand(),resultSet.get(1));
  	    assertEquals(new MoveForwardCommand(),resultSet.get(2));
  	    assertEquals(new RotateLeftCommand(), resultSet.get(3));
	    assertEquals(new RotateLeftCommand(), resultSet.get(4));
	    assertEquals(new RotateLeftCommand(), resultSet.get(5));
	    assertEquals(new RotateRightCommand(), resultSet.get(6));
	}
	
	@Test
	public void testAllSameParse() {
	    List<Command> resultSet = testCase.parse("FFFFFF");
   	    assertEquals(6,resultSet.size());
   	    assertEquals(new MoveForwardCommand(),resultSet.get(0));
  	    assertEquals(new MoveForwardCommand(),resultSet.get(1));
  	    assertEquals(new MoveForwardCommand(),resultSet.get(2));
  	    assertEquals(new MoveForwardCommand(), resultSet.get(3));
	    assertEquals(new MoveForwardCommand(), resultSet.get(4));
	}
	
	
	@Test
	public void testEmptyList() {
		  List<Command> resultSet = testCase.parse("");
	   	    assertEquals(0,resultSet.size());
	}
	
	@Test
	public void testIllegalCommand() {
		try {
	      List<Command> resultSet = testCase.parse("FFJFFFF");
	   	  fail("should throw error");
		}
		catch (IllegalCommandFoundException e) {
			
		}
	}
	
	
	
}
