package game_app;

import javafx.scene.image.Image;

public class Obstacle extends Sprites {
	/**@Refactor
	 * self encapsulating field to avoid direct access of field 
	 * even within own class
	 * create setter and getter for encapsulated field 
	 */
	private int speed;
	
//*****************************VIEW******************************************
	@Override
	public void act(long now) { 
		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -50 && getSpeed()<0)
			setX(600);
	}

//*****************************CONTROLLER*******************************************
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		//speed = s;
		setSpeed(s);
	}
	
//*****************************MODEL***************************************
	public int getSpeed() { //model
		return speed;
	}
	
	public void setSpeed(int sp) {//model
		speed = sp;
	}

}
