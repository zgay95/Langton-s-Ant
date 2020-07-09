import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Ant{
	
	int direction = 0; // 0/360 is north
	int center = 6;
	int LocX = 31;
	int LocY = 24;
	int prevColor = 0;

	Location location = new Location(center, center);
	
	public Ant(){
		Location location = new Location(center, center);
		//setColor(Color.RED);
	}
	Location getLocation(){
		return location;
	}
	//read color
	// public int getDirection(Graphics g){
	// 	if(g.getColor() == Color.WHITE){
	// 		//turn left
	// 		//set color to grey
	// 		g.setColor(Color.gray);
	// 		direction +=90;
	// 		if (direction == 360){
	// 			direction == 0;
	// 		}
	// 	}
	// 	else{
	// 		//turn right
	// 		direction -= 90;
	// 		g.setColor(Color.WHITE);
	// 		if (direction == -90){
	// 			direction = 270;
	// 		}
	// 	}
	// 	return direction;
	// }
	// public Location setNewLocation(Graphics g){
	// 	direction = getDirection(g);
	// 	Location newLoc = getAdjacentLocation(direction);
	// 	location.setRow(newLoc.getRow());
	// 	location.setColumn(newLoc.getColumn());
	// 	return location;
	// }




	public int getDir(int[][] board, int x, int y){
		if(prevColor == 0){
			//turn left, white square
			board[x][y] = 1;
			if(direction == 0 || direction == 360)
			{
				prevColor = board[x+1][y];
				board[x+1][y] = 2;
				LocX = x+1;
				LocY = y;
				direction = 90;
			}
			else if(direction == 90)
			{
				prevColor = board[x][y+1];
				board[x][y+1] = 2;
				LocX = x;
				LocY = y+1;
				direction = 180;
			}
			else if(direction == 180)
			{
				prevColor = board[x-1][y];
				board[x-1][y] = 2;
				LocX = x-1;
				LocY = y;
				direction = 270;
			}
			else if(direction == 270)
			{
				prevColor = board[x][y-1];
				board[x][y-1] = 2;
				LocX = x;
				LocY = y-1;
				direction = 360;
			}
		}
		else{
			//turn right, black square
			board[x][y] = 0;
			if(direction == 0 || direction == 360)
			{
				prevColor = board[x-1][y];
				board[x-1][y] = 2;
				LocX = x-1;
				LocY = y;
				direction = 270;
			}
			else if(direction == 90)
			{
				prevColor = board[x][y-1];
				board[x][y-1] = 2;
				LocX = x;
				LocY = y-1;
				direction = 360;
			}
			else if(direction == 180)
			{
				prevColor = board[x+1][y];
				board[x+1][y] = 2;
				LocX = x+1;
				LocY = y;
				direction = 90;
			}
			else if(direction == 270)
			{
				prevColor = board[x][y+1];
				board[x][y+1] = 2;
				LocX = x;
				LocY = y+1;
				direction = 180;
			}
		}
		if (direction == 360){
			direction = 0;
		}
		return direction;
	}
	public int[][] setLocation(int[][] board, int x, int y){
		direction = getDir(board, x, y);
		return board;
	}
}