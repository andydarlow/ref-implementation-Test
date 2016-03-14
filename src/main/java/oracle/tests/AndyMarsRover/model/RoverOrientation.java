package oracle.tests.AndyMarsRover.model;

/**
 * represents which way the robot it facing
 */
public enum RoverOrientation {

	NORTH {
		@Override
		public Position forward(Position position) {
			return position.move(0, 1);
		}
	},
	EAST {
		@Override
		public Position forward(Position position) {
			return position.move(1, 0);
		}
	},
	SOUTH {
		@Override
		public Position forward(Position position) {
			return position.move(0, -1);
		}
	},
	WEST {
		@Override
		public Position forward(Position position) {
			return position.move(-1, 0);
		}
	};

	// IMPORTANT: using 'this' is not good but better than null. The static
	// initialiser fixes the values but means the values will be incorrect
	// until the static inisitaliser is call.
	private RoverOrientation toLeft = this;
	private RoverOrientation toRight = this;

	// this will move 1 unit forward in the direction
	// of the orientation
	public abstract Position forward(Position position);

	// where you go when you go left. Important.It's private and
	// needed as a workaround because you can't hoist ENUMs
	// so you have to set the neighbours after creation.
	private void setNeighbours(RoverOrientation toRight, RoverOrientation toLeft) {
		this.toLeft = toLeft;
		this.toRight = toRight;
	}

	public RoverOrientation left() {
		return toLeft;
	}

	public RoverOrientation right() {
		return toRight;
	}

	// OK this isn't perfect because definitions are
	// interrelated . So, you can't create a constructor
	// using enums that aren't defined (Later in the list). So this
	// static initialiser is used to get around it
	static {
		NORTH.setNeighbours(EAST, WEST);
		EAST.setNeighbours(SOUTH, NORTH);
		SOUTH.setNeighbours(WEST, EAST);
		WEST.setNeighbours(NORTH, SOUTH);
	}

}
