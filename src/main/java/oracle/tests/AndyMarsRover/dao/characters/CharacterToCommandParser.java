package oracle.tests.AndyMarsRover.dao.characters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import oracle.tests.AndyMarsRover.dao.IllegalCommandFoundException;
import oracle.tests.AndyMarsRover.model.commands.Command;
import oracle.tests.AndyMarsRover.model.commands.UnknownCommand;
import oracle.tests.AndyMarsRover.model.commands.MoveForwardCommand;
import oracle.tests.AndyMarsRover.model.commands.RotateLeftCommand;
import oracle.tests.AndyMarsRover.model.commands.RotateRightCommand;

public class CharacterToCommandParser {

	
	private Map<Character,Command> parserMap = new HashMap<Character,Command>() {
		{
			//translate raw input to Commands. Add to this for more commands
		   put('F', new MoveForwardCommand());
		   put('L', new RotateLeftCommand());
		   put('R', new RotateRightCommand());
		}
	};
	
	
	//--------------------------------------------------------------------------------
	// Entry point
	//-------------------------------------------------------------------------------

	
	public List<Command> parse(String commandSequenceString) {  
		Objects.requireNonNull(commandSequenceString);
		if (containsIllegalCharacters(commandSequenceString))
			throw new IllegalCommandFoundException(findIllegalCommands((commandSequenceString)));
		return parseRawCommands(commandSequenceString);
	}

	//----------------------------------------------------
	// general
	//----------------------------------------------------
	
	private Stream<Character> toUpperCaseSequence(String characterSequence) {
		return characterSequence
				.chars()
				.mapToObj(charAsInt->Character.toUpperCase((char)charAsInt));
	}
	
	//--------------------------------------------------------------------------------
	// error handling...
	//-------------------------------------------------------------------------------
	
	private boolean containsIllegalCharacters(String commandSequenceString) {
		return !findIllegalCommands(commandSequenceString).isEmpty();
	}

    //list the errors in the commands (things you've entered incorrectly)
	private List<Character> findIllegalCommands(String commandSequenceString) {
		return toUpperCaseSequence(commandSequenceString)
				.filter(characterCommand->!parserMap.containsKey(characterCommand))
				.collect(Collectors.toList());
	}

	//--------------------------------------------------------------------------------
	// translation code
	//-------------------------------------------------------------------------------

	//translate characters to the commands that drive them
	private List<Command> parseRawCommands(String commandSequenceString) {
		return toUpperCaseSequence(commandSequenceString)
				// assume all characters are valid BUT just incase use Unknown command
			    .map(characterCommand-> parserMap.getOrDefault(characterCommand,new UnknownCommand()))
				.collect(Collectors.toList());
	}
	
}
