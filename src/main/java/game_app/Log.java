/**@Refactor
 * constructor in default access
 * self encapsulating field to avoid direct access of field even within own class
 * create setter and getter for encapsulated field 
 * rename getLeft() to moveLeft()
 * constructor in default access
 */
package game_app;

import javafx.scene.image.Image;

public class Log extends Sprites {
	private double speed;
	
//*****************************CONTROLLER*******************************************
	@Override
	public void act(long now) { 
		move(getSpeed() , 0);
		if (getX()>600 && getSpeed()>0)
			setX(-180);
		if (getX()<-300 && getSpeed()<0)
			setX(700);
	}
	
	Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		setSpeed(s);
		
	}
	
//*****************************MODEL********************************************


	public boolean moveLeft() { 
		return getSpeed() < 0;
	}
	
	

	public double getSpeed() { 
		return speed;
	}
	

	public void setSpeed(double sp) { 
		speed = sp;
	}
}
