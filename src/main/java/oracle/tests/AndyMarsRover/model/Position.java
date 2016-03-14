package oracle.tests.AndyMarsRover.model;


public class Position {

	
	private int x;
	private int y;
	
	public Position(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position move(int deltax, int deltay) {
		return new Position(x + deltax,y+deltay);
	}

	private boolean isWithinbound(int value, int min,int max) {
		return (value >= min) && (value <= max);
	}
	
	
	public boolean isWithinXBounds(int minX, int maxX) {
		return isWithinbound(x,minX,maxX);
	}

	
	public boolean isWithinYBounds(int minY, int maxY) {
		return isWithinbound(y,minY,maxY);
	}

	@Override
	public String toString() {
	   return "("+ x + "," + y +")";	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if  ((obj == null) ||  (getClass() != obj.getClass()))  	
			return false;
		Position other = (Position) obj;
		return (x == other.x) && 
			   (y == other.y);		
	}
	
	
	
	
}
