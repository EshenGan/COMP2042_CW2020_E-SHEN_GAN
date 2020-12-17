package game_app;

import javafx.scene.image.Image;

/**<b>REFACTOR</b>:
 * <p>. self encapsulating field to avoid direct access of field even within own class<br>
 * . create setter and getter for encapsulated field<br>
 * . rename from obstacles to vehicles</p>
 */
public class Vehicles extends Sprites {

	private int speed;
	
//*****************************CONTROLLER******************************************
	/**
	 *?  move according to speed set<br> 
	 *? reset x coordinate to -200 if more than 600 while moving to right<br>
	 *? reset x coordinate to 600 if less than -50 while moving to left
	 */
	public void act(long now) { 
		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -50 && getSpeed()<0)
			setX(600);
	}
	
	Vehicles(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		setSpeed(s);
	}
	
//*****************************MODEL***************************************
	public int getSpeed() { 
		return speed;
	}
	
	public void setSpeed(int sp) {
		speed = sp;
	}

}
