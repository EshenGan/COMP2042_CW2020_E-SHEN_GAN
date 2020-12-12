	/**@Refactor
	 * self encapsulating field to avoid direct access of field 
	 * even within own class
	 * create setter and getter for encapsulated field 
	 */
package game_app;

import javafx.scene.image.Image;

public class Vehicles extends Sprites {

	private int speed;
	
//*****************************CONTROLLER******************************************
	@Override
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
