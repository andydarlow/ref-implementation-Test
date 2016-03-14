package oracle.tests.AndyMarsRover.dao;

import java.util.ArrayList;
import java.util.List;

public class IllegalCommandFoundException extends RuntimeException {

	//all the characters we found that aren't valid.
   private List<Character> errorCommands;

	public IllegalCommandFoundException(List<Character> errorCommands) {
		super("errors found in commands");
		this.errorCommands = errorCommands;
	}

	public List<Character> getErrorCommands() {
		return new ArrayList<Character>(errorCommands);
	}
	
	
	
}
