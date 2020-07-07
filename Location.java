public class Locaiton{
	private int row;
	private int column;
	public static final int LEFT = -90;
	public static final int RIGHT = 90;
	public Location(int r, int c){
        row = r;
        col = c;
    }
	public int getRow(){
		return row;
	}
	public int getColumn(){
		return column;
	}
	public int setRow(int r){
		row = r;
	}
	public int setColumn(int c){
		col = c;
	}
	public Location getAdjacentLocation(int direction){
		int dc = 0;
		int dr = 0;
		
		if (direction == 0){
			dr = -1;
			dc = 0;			
		}
		else if (direction == 90){
			dr = 0;
			dc = 1;
		}
		else if (direction == 180){
			dr = 1;
			dc = 0;
		}
		else if (direction == 270){
			dr = 0;
			dc = -1;
		}
		return new Location (getRow()+dr, getColumn()+dc);
	}
}