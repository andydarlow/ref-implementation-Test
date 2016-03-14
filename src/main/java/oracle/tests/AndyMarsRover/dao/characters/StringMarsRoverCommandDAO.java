package oracle.tests.AndyMarsRover.dao.characters;

import java.util.ArrayList;
import java.util.List;

import oracle.tests.AndyMarsRover.dao.MarsRoverCommandDAO;
import oracle.tests.AndyMarsRover.model.commands.Command;
/**
 * simple DAO that will provide the commands from a sequence of 
 * commands held in string. 
 */
public class StringMarsRoverCommandDAO implements MarsRoverCommandDAO {

	//change to queue
	private List<Command> commands = new ArrayList<>();
	
	
	public StringMarsRoverCommandDAO(String charCommands) {
		commands.addAll(new CharacterToCommandParser().parse(charCommands));
	}
	


	@Override
	public List<Command> gwtAllCommands() {
		return new ArrayList<Command>(commands);
	}

}
