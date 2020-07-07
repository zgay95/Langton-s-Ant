import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Ant{
	
	int direction = 180; // 0/360 is north
	int center = 6;
	Location location = new Location(center, center);
	
	public Ant(){
		Location location = new Location(center, center);
		setColor(Color.RED);
	}
	Location getLocation(){
		return location;
	}
	//read color
	public int getDirection(Graphics g){
		if(g.getColor() == Color.WHITE){
			//turn left
			//set color to grey
			g.setColor(Color.gray);
			direction +=90;
			if (direction == 360){
				direction == 0;
			}
		}
		else{
			//turn right
			direction -= 90;
			g.setColor(Color.WHITE);
			if (direction == -90){
				direction = 270;
			}
		}
		return direction;
	}
	public Location setNewLocation(Graphics g){
		direction = getDirection(g);
		Location newLoc = getAdjacentLocation(direction);
		location.setRow(newLoc.getRow());
		location.setColumn(newLoc.getColumn());
		return location;
	}
}