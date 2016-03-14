package oracle.tests.AndyMarsRover.model.commands;
/**
 * signal that the robot has hit a problem when running a command
 */
public class IllegalRoverMovementException extends RuntimeException {

	private Command causeOfException;
	
	public IllegalRoverMovementException(Command cause, String reason) {
		super(reason);
		this.causeOfException = cause;
	}

	public Command getCauseOfException() {
		return causeOfException;
	}
	
}
