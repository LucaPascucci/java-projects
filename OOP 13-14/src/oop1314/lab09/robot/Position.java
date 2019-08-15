package oop1314.lab09.robot;

/**
 * Models a (x,y) position 
 * @author Andrea Santi
 *
 */
public class Position {

	private int x;
	private int y;
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 * @return X position
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return Y position
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
  @Override
  public String toString() {
    return "(x=" + x + ", y=" + y + ")";
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Position){
      Position p = (Position) obj;
      return p.getX()==x && p.getY() == y;
    } else {
      return false;
    }
  }
}