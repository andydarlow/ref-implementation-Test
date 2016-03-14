package oracle.tests.AndyMarsRover.model;

import java.util.List;

import oracle.tests.AndyMarsRover.model.commands.Command;

/**
 * robot the moves about the grid
 */
public class Rover {

	private RoverOrientation orientation = RoverOrientation.NORTH;
	private Grid grid;
	private Position gridPosition;
	
	
	
	public Rover(RoverOrientation orientation,Grid grid, Position gridPosition) {
		this.orientation = orientation;
		this.grid = grid;
		this.gridPosition = gridPosition;
	}
		
	public Rover execute(List<Command> commands) {
		return commands.stream().reduce(this,(command,robot) -> robot.execute(command),(oldRobot,robot)->robot);
	}
	
	public Rover execute(Command command) {
		return command.execute(this);
	}
	
	public Rover rotateLeft() {
		return new Rover(orientation.left(),grid,gridPosition);
	}
	
	public Rover rotateRight() {
		return new Rover(orientation.right(),grid,gridPosition);
	}

	public boolean canMoveForward() {
		return moveForward().isOnGrid();
	}
	
	private boolean isOnGrid() {
		return grid.isOnGrid(gridPosition);
	}

	public Rover moveForward() {
		return new Rover(orientation,grid,orientation.forward(gridPosition));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grid == null) ? 0 : grid.hashCode());
		result = prime * result + ((gridPosition == null) ? 0 : gridPosition.hashCode());
		result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if  ((obj == null) ||  (getClass() != obj.getClass())) 
			return false;
		Rover other = (Rover) obj;
		return isEqual(grid,other.grid) &&
			   isEqual(gridPosition,other.gridPosition) &&
			   isEqual(orientation,other.orientation);
	}


	private boolean isEqual(Object object,Object other) {
		return   (object == null && other == null) ||
				 (object != null && object.equals(other));
	}


	@Override
	public String toString() {
		return "Rover [orientation=" + orientation + ", grid=" + grid + ", gridPosition=" + gridPosition + "]";
	}
	

}

