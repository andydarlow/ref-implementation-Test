package oracle.tests.AndyMarsRover.app;

import java.util.List;

import com.google.inject.Inject;

import oracle.tests.AndyMarsRover.app.environment.Application;
import oracle.tests.AndyMarsRover.dao.IllegalCommandFoundException;
import oracle.tests.AndyMarsRover.dao.MarsRoverCommandDAO;
import oracle.tests.AndyMarsRover.model.Grid;
import oracle.tests.AndyMarsRover.model.Position;
import oracle.tests.AndyMarsRover.model.Rover;
import oracle.tests.AndyMarsRover.model.RoverOrientation;
import oracle.tests.AndyMarsRover.model.commands.Command;
import oracle.tests.AndyMarsRover.model.commands.IllegalRoverMovementException;
import oracle.tests.AndyMarsRover.ui.MarsRoverView;

// the mars rover code. Runs the rover
public class MarsRoverApplication implements Application {

	@Inject
	private MarsRoverView view;
	
	@Inject
	private MarsRoverCommandDAO source;
   
	

	//entry point for the app
	/* (non-Javadoc)
	 * @see oracle.tests.AndyMarsRover.app.Application#run()
	 */
	@Override
	public void run() {
    	Rover robot =  new Rover(RoverOrientation.NORTH,new Grid(5,5),new Position(0,0));
		try {
			robot = robot.execute(source.gwtAllCommands());
			view.displayRobot(robot);
		}
		catch(IllegalRoverMovementException  e){
			view.displayMovementError(e);
			
		}
		catch(IllegalCommandFoundException  e) {
			 view.displayDAOError(e);
		}
	}

}
