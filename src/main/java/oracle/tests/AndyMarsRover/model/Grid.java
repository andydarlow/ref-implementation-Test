package oracle.tests.AndyMarsRover.model;

public class Grid {

	private int maxX;
	private int maxY;
	
	public Grid(int maxX,int maxY) {
		this.maxY = maxY;
		this.maxX = maxX;
	}
	
	
	public boolean isOnGrid(Position position) {
		return position.isWithinXBounds(0,maxX-1) &&
			   position.isWithinYBounds(0,maxY-1);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxX;
		result = prime * result + maxY;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if ((obj == null) ||  (getClass() != obj.getClass())) 
		   return false;
		Grid other = (Grid) obj;
		return (maxX == other.maxX) &&
	           (maxY == other.maxY);
	}


	
}
