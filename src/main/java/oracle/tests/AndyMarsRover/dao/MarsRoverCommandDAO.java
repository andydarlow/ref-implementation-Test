package oracle.tests.AndyMarsRover.dao;

import java.util.List;

import oracle.tests.AndyMarsRover.model.commands.Command;

/**
 * source of Commands from the outside world
 */
public interface MarsRoverCommandDAO {


	List<Command> gwtAllCommands();

}
